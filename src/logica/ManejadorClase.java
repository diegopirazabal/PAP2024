package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
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
    
    
    public List<dataTypeClase> listarporActividad(Actividad act) throws ClaseNoExisteException{
        try {
            List<Clase> clases = em.createQuery("SELECT c FROM Clase c WHERE c.actividad = :acti", Clase.class)
            .setParameter("acti", act)
            .getResultList();
            return clases.stream()
                    .map(clase -> new dataTypeClase(
                            clase.getFecha(),
                            clase.getNombre(),
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
    
    public List<dataTypeClase> listarporActividadNombre(String act) throws ClaseNoExisteException{
        try {
            List<Clase> clases = em.createQuery("SELECT c FROM Clase c WHERE c.actividad = :act", Clase.class)
            .setParameter("act", act)
            .getResultList();
            return clases.stream()
                    .map(clase -> new dataTypeClase(
                            clase.getFecha(),
                            clase.getNombre(),
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

    public List<dataTypeClase> getClases() throws ClaseNoExisteException {
        try {
            List<Clase> clases = em.createQuery("SELECT c FROM Clase c", Clase.class).getResultList();
            return clases.stream()
                    .map(clase -> new dataTypeClase(
                            clase.getFecha(),
                            clase.getNombre(),
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
        Clase claseExistente = obtenerClasePorNombre(clase.getNombre());
        if (claseExistente != null) {
            throw new ClaseRepetidaException("La clase con nombre " + clase.getNombre() + " ya existe.");
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

    public List<dataTypeClase> listarClasesPorActividad(String nombreActividad) {
    	try {
            List<Clase> clases = em.createQuery(
                "SELECT c FROM Clase c WHERE c.actividad.nombre = :nombreActividad", Clase.class)
                .setParameter("nombreActividad", nombreActividad)
                .getResultList();

            return clases.stream()
                .map(clase -> new dataTypeClase(
                    clase.getFecha(), 
                    clase.getNombre(), 
                    clase.getHora(), 
                    clase.getLugar(), 
                    clase.getImagen(), 
                    clase.getFecha(), 
                    clase.getCupo()))
                .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    
    public void cerrar() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}