package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    
    List<Inscripcion> listarInscripcionesPorClase(String deportista){
    	try {
            return em.createQuery(
                    "SELECT i FROM Inscripcion i WHERE i.deportista.nickname = :nickDeportista", Inscripcion.class)
                    .setParameter("nickDeportista", deportista)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    dataTypeClase obtenerClasePorNombre2(String nombre) {
        try {
            List<Clase> resultados = em.createQuery("SELECT c FROM Clase c WHERE c.nombre = :nombre", Clase.class)
                                           .setParameter("nombre", nombre)
                                           .getResultList();
            Clase a = resultados.get(0);
            dataTypeClase result = new dataTypeClase(
                            a.getFecha(),
                            a.getNombre(),
                            a.getHora(),
                            a.getLugar(),
                            a.getImagen(),
                            a.getFechaAlta(),
                            a.getCupo());
            return result;
                    
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
    	
        Clase claseExistente = obtenerClasePorNombre(clase.getNombre());
        if (claseExistente != null) {
            throw new ClaseRepetidaException("La clase con nombre " + clase.getNombre() + " ya existe.");
        }
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(clase);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
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