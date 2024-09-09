package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ManejadorClase {
	private EntityManagerFactory emf;
    private EntityManager em;
    private static ManejadorClase instancia = null;

    public ManejadorClase() {
        this.emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        this.em = emf.createEntityManager();
    }

    public static ManejadorClase getinstance() {
        if (instancia == null)
            instancia = new ManejadorClase();
        return instancia;
    }

    Clase obtenerClasePorNombre(String nombre) {
        try {
            List<Clase> resultados = em.createQuery("SELECT c FROM Clase c WHERE c.nombre = :nombre", Clase.class)
                                           .setParameter("nombre", nombre)
                                           .getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<dataTypeClase> getClases() throws ActividadNoExisteException {
        try {
            List<Clase> clases = em.createQuery("SELECT c FROM Clase c", Clase.class).getResultList();
            return clases.stream()
                    .map(clase -> new dataTypeClase(
                            clase.getFecha(),
                            clase.getHora(),
                            clase.getLugar(),
                            clase.getImagen(),
                            clase.getFechaAlta(),
                            clase.getCupo()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void agregarClase(Clase clase) throws ActividadRepetidaException {
        // Verificar si la actividad ya existe en la base de datos
        Clase claseExistente = obtenerClasePorNombre(clase.getImagen());
        if (claseExistente != null) {
            throw new ActividadRepetidaException("La actividad con nombre " + clase.getImagen() + " ya existe.");
        }

        // Persistir la nueva actividad
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();  // Inicia la transacción
            em.persist(clase);  // Persiste la nueva clase
            transaction.commit(); // Confirma la transacción
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();  // Si hay error, hacer rollback
            e.printStackTrace();
        }
    }




//    public void eliminar(String nombre) throws ActividadNoExisteException {
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            Actividad actividad = em.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :nombre", Actividad.class)
//                    .setParameter("nombre", nombre)
//                    .getResultStream()
//                    .findFirst()
//                    .orElse(null);
//            if (actividad == null) {
//                throw new ActividadNoExisteException("La actividad con nombre " + nombre + " no existe.");
//            }
//            em.remove(actividad);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction.isActive()) transaction.rollback();
//            e.printStackTrace();
//        }
//    }
    
    public dataTypeUsuario obtenerDeportista(String nickname) {
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                                .setParameter("nickname", nickname)
                                .getResultStream()
                                .findFirst()
                                .orElse(null);

            if (usuario instanceof Deportista) {
                Deportista deportista = (Deportista) usuario;
                return new dataTypeUsuario(
                        deportista.getNickname(),
                        deportista.getNombre(),
                        deportista.getApellido(),
                        deportista.getEmail(),
                        deportista.getFNacimiento(),
                        deportista.getTipo()
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
 
    
    public void cerrar() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}
