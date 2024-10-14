package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.UsuarioRepetidoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
    
    public void activarActividad(Actividad x) {
    	x.setEstado(true);
    	EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();  
            em.persist(x);  
            transaction.commit(); 
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();  
            e.printStackTrace();
        }
    }
    
    public void rechazarActividad(Actividad x) {
    	x.setEstado(false);
    	EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();  
            em.persist(x);  
            transaction.commit(); 
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();  
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
                dataTypeActividad act = new dataTypeActividad(
                        actividad.getNombre(),
                        actividad.getDescripcion(),
                        actividad.getDuracion(),
                        actividad.getCosto(),
                        actividad.getLugar(),
                        actividad.getFechaAlta(),
                        actividad.getImagen(),
                        actividad.getEntrenador()
                );
                return act;
            }
            throw new ActividadNoExisteException("La actividad con nombre " + nombre + " no existe.");
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
        Actividad actividadExistente = obtenerActividadPorNombre(actividad.getNombre());
        if (actividadExistente != null) {
            throw new ActividadRepetidaException("La actividad con nombre " + actividad.getNombre() + " ya existe.");
        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();  
            em.persist(actividad);  
            em.flush(); 
            em.refresh(actividad);  
            em.refresh(actividad.getEntrenador());
            transaction.commit(); 
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); 
            }
            e.printStackTrace();
        }
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

    public dataTypeUsuario obtenerEntrenadorDeLaActividadPorNickname(String nickname) throws UsuarioRepetidoException{
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
                        entrenador.getTipo(),
                        entrenador.getContrasena()
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
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
    
    public List<dataTypeActividad> obtenerActividadesConfirmadasPorEntrenador(String nickname) {
        try {
            List<Actividad> actividades = em.createQuery("SELECT a FROM Actividad a WHERE a.entrenador.nickname = :entrenadorId AND a.estado = true", Actividad.class)
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
    
    public List<dataTypeActividad> getAgregadas() throws ActividadNoExisteException {
        try {
            List<Actividad> actividades = em.createQuery("SELECT a FROM Actividad a WHERE a.estado = null", Actividad.class).getResultList();
            
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
    
    public List<dataTypeActividad> getConfirmadas() throws ActividadNoExisteException {
        try {
            List<Actividad> actividades = em.createQuery("SELECT a FROM Actividad a WHERE a.estado = true", Actividad.class).getResultList();
            
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
    public void modificarActividad(String nombre, String descripcion, int duracion, double costo, String lugar) throws ActividadNoExisteException {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // Buscar la actividad por nombre
            Actividad actividad = obtenerActividadPorNombre(nombre);
            if (actividad == null) {
                throw new ActividadNoExisteException("La actividad con nombre " + nombre + " no existe.");
            }

            // Actualizar los campos de la actividad
            actividad.setDescripcion(descripcion);
            actividad.setDuracion(duracion);
            actividad.setCosto(costo);
            actividad.setLugar(lugar);
            em.merge(actividad); // Actualiza la actividad en la base de datos
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Hacer rollback si hay un error
            }
            e.printStackTrace();
        }
    }
    
    public void cerrar() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}