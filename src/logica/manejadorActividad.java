package logica;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import jakarta.persistence.*;
import dtos.dataTypeActividad;
import dtos.dataTypeUsuario;

public class manejadorActividad {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static manejadorActividad instancia = null;

    public manejadorActividad() {
        this.emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        this.em = emf.createEntityManager();
    }

    public static manejadorActividad getinstance() {
        if (instancia == null)
            instancia = new manejadorActividad();
        return instancia;
    }

    Actividad obtenerActividadPorNombre(String nombre) {
        try {
            List<Actividad> resultados = em.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :nombre", Actividad.class)
                                           .setParameter("nombre", nombre)
                                           .getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<dataTypeActividad> getActividades() throws ActividadNoExisteException {
        try {
            List<Actividad> actividades = em.createQuery("SELECT a FROM Actividad a", Actividad.class).getResultList();
            return actividades.stream()
                    .map(actividad -> new dataTypeActividad(
                            actividad.getNombre(),
                            actividad.getDescripcion(),
                            actividad.getDuracion(),
                            actividad.getCosto(),
                            actividad.getLugar(),
                            actividad.getFechaAlta(),
                            actividad.getImagen(),
                            actividad.getEntrenador()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void agregar(Actividad actividad) throws ActividadRepetidaException {
        // Verificar si la actividad ya existe en la base de datos
        Actividad actividadExistente = obtenerActividadPorNombre(actividad.getNombre());
        if (actividadExistente != null) {
            throw new ActividadRepetidaException("La actividad con nombre " + actividad.getNombre() + " ya existe.");
        }

        // Persistir la nueva actividad
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();  // Inicia la transacción
            em.persist(actividad);  // Persiste la nueva actividad
            transaction.commit(); // Confirma la transacción
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();  // Si hay error, hacer rollback
            e.printStackTrace();
        }
    }

    public dataTypeActividad buscarActividadPorNombre(String nombre) {
        try {
            Actividad actividad = em.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :nombre", Actividad.class)
                    .setParameter("nombre", nombre)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (actividad != null) {
                return new dataTypeActividad(
                        actividad.getNombre(),
                        actividad.getDescripcion(),
                        actividad.getDuracion(),
                        actividad.getCosto(),
                        actividad.getLugar(),
                        actividad.getFechaAlta(),
                        actividad.getImagen(),
                        actividad.getEntrenador()
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Actividad buscarActividadPorNombre2(String nombre) {
        try {
            Actividad actividad = em.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :nombre", Actividad.class)
                    .setParameter("nombre", nombre)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (actividad != null) {
                return new Actividad(
                        actividad.getNombre(),
                        actividad.getDescripcion(),
                        actividad.getDuracion(),
                        actividad.getCosto(),
                        actividad.getLugar(),
                        actividad.getFechaAlta(),
                        actividad.getImagen(),
                        actividad.getEntrenador()
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public dataTypeActividad buscarActividad(String nombre) throws ActividadNoExisteException {
        dataTypeActividad actividad = buscarActividadPorNombre(nombre);
        if (actividad == null) {
            throw new ActividadNoExisteException("La actividad con nombre " + nombre + " no existe.");
        }
        return actividad;
    }
    
    
    
    
    public Actividad buscarActividad2(String nombre) throws ActividadNoExisteException {
        Actividad actividad = buscarActividadPorNombre2(nombre);
        if (actividad == null) {
            throw new ActividadNoExisteException("La actividad con nombre " + nombre + " no existe.");
        }
        return actividad;
    }

    public void eliminar(String nombre) throws ActividadNoExisteException {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Actividad actividad = em.createQuery("SELECT a FROM Actividad a WHERE a.nombre = :nombre", Actividad.class)
                    .setParameter("nombre", nombre)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
            if (actividad == null) {
                throw new ActividadNoExisteException("La actividad con nombre " + nombre + " no existe.");
            }
            em.remove(actividad);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }
    
    public dataTypeUsuario obtenerEntrenadorPorNickname(String nickname) {
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                                .setParameter("nickname", nickname)
                                .getResultStream()
                                .findFirst()
                                .orElse(null);

            if (usuario instanceof Entrenador) {
                Entrenador entrenador = (Entrenador) usuario;
                return new dataTypeUsuario(
                        entrenador.getNickname(),
                        entrenador.getNombre(),
                        entrenador.getApellido(),
                        entrenador.getEmail(),
                        entrenador.getFNacimiento(),
                        entrenador.getTipo()
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void agregarClase(Clase clase, String actividad) throws ActividadNoExisteException {
    	 Actividad act = buscarActividad2(actividad);
    	 act.setClases(clase);
    };
    
    public List<dataTypeActividad> obtenerActividadesPorEntrenador(String nickname) {
        try {
            List<Actividad> actividades = em.createQuery("SELECT a FROM Actividad a WHERE a.entrenador.nickname = :entrenadorId", Actividad.class)
                    .setParameter("entrenadorId", nickname)
                    .getResultList();

            return actividades.stream()
                    .map(actividad -> new dataTypeActividad(
                            actividad.getNombre(),
                            actividad.getDescripcion(),
                            actividad.getDuracion(),
                            actividad.getCosto(),
                            actividad.getLugar(),
                            actividad.getFechaAlta(),
                            actividad.getImagen(),
                            actividad.getEntrenador()))
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
