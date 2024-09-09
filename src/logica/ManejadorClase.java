package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;
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

    Clase obtenerClasePorID(Long id) {
        try {
            List<Clase> resultados = em.createQuery("SELECT c FROM Clase c WHERE c.id = :id", Clase.class)
                                           .setParameter("id", id)
                                           .getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<dataTypeClase> getClases() throws ClaseNoExisteException {
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

    public void agregarClase(Clase clase) throws ClaseRepetidaException {
        // Verificar si la actividad ya existe en la base de datos
        Clase claseExistente = obtenerClasePorID(clase.getId());
        if (claseExistente != null) {
            throw new ClaseRepetidaException("La clase con ID " + clase.getId() + " ya existe.");
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

 
    
    public void cerrar() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}
