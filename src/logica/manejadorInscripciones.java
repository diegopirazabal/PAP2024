package logica;

import java.util.ArrayList;
import java.util.List;

import excepciones.ClaseRepetidaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class manejadorInscripciones {
	private EntityManagerFactory emf;
    private EntityManager em;
    private static manejadorInscripciones instancia = null;

    public manejadorInscripciones() {
        this.emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        this.em = emf.createEntityManager(); 
    }

    public static manejadorInscripciones getinstance() {
        if (instancia == null)
            instancia = new manejadorInscripciones();
        return instancia;
    }
	
    private List<Inscripcion> inscripciones;//Reemplazar esto por consultas sql en buscarInscripcion


    public void agregarInscripcionAClase(Inscripcion inscripcion) {// repensar esta funcion y checkear que funcione
    	System.out.println("\n\nLlegue al manejador de inscripciones.");
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(inscripcion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Inscripcion> buscarInscripcionesPorClase(Clase clase) {
        List<Inscripcion> resultado = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getClase().equals(clase)) {
                resultado.add(inscripcion);
            }
        }
        return resultado;
    }

    public List<Inscripcion> buscarInscripcionesPorDeportista(Deportista deportista) {
        List<Inscripcion> resultado = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getDeportista().equals(deportista)) {
                resultado.add(inscripcion);
            }
        }
        return resultado;
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        inscripciones.remove(inscripcion);
    }

    public List<Inscripcion> obtenerTodasLasInscripciones() {
        return new ArrayList<>(inscripciones);
    }
}
