package logica;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import jakarta.persistence.*;
import dtos.*;
import dtos.dataTypeUsuario;
import jakarta.persistence.*;

public class manejadorUsuarios {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static manejadorUsuarios instancia = null;
    
    public manejadorUsuarios() {
        this.emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        this.em = emf.createEntityManager();
    }
    
    public static manejadorUsuarios getinstance() {
        if (instancia == null)
            instancia = new manejadorUsuarios();      // Constructor solo se llama de aca
        return instancia;
    }
    
    public Usuario obtenerUsuarioPorNickname(String nickname) {
        try {
            List<Usuario> resultados = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                                         .setParameter("nickname", nickname)
                                         .getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
    public List<dataTypeUsuario> getUsuarios() {
        try {
            // Recuperar todos los usuarios desde la base de datos
            List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

            // Transformar cada usuario en un dataTypeUsuario
            return usuarios.stream()
                    .map(usuario -> new dataTypeUsuario(
                            usuario.getNickname(),
                            usuario.getNombre(),
                            usuario.getApellido(),
                            usuario.getEmail(),
                            usuario.getFNacimiento(),
                            usuario.getTipo(),
                            usuario.getContrasena()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retornar una lista vacía en caso de excepción
        }
    }


    public void agregar(Usuario usuario) throws UsuarioRepetidoException {
        Usuario usuarioExistente = obtenerUsuarioPorNickname(usuario.getNickname());
        if (usuarioExistente != null) {
            throw new UsuarioRepetidoException("El usuario con nickname " + usuario.getNickname() + " ya existe.");
        }

        // Persistir el nuevo usuario
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();  
            em.persist(usuario);  
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
    
    
    public dataTypeUsuario buscarUsuarioPorNickname(String nickname) {
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                    .setParameter("nickname", nickname)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (usuario != null) {
                dataTypeUsuario user =  new dataTypeUsuario(
                        usuario.getNickname(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getFNacimiento(),
                        usuario.getTipo(),
                        usuario.getContrasena()
                );
                return user;
            }
            throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public dataTypeUsuario buscarUsuarioPorEmail(String email) {
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (usuario != null) {
                dataTypeUsuario user =  new dataTypeUsuario(
                        usuario.getNickname(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getFNacimiento(),
                        usuario.getTipo(),
                        usuario.getContrasena()
                );
                return user;
            }
            throw new UsuarioNoExisteException("El usuario con email " + email + " no existe.");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminar(String nickname) throws UsuarioNoExisteException {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                    .setParameter("nickname", nickname)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
            if (usuario == null) {
                throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
            }
            em.remove(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<dataTypeUsuario> obtenerEntrenadores() {
        try {
            List<Entrenador> entrenadores = em.createQuery("SELECT u FROM Usuario u WHERE u.esEntrenador = true", Entrenador.class)
                    .getResultList();
            return entrenadores.stream()
                    .map(entrenador -> new dataTypeUsuario(
                            entrenador.getNickname(),
                            entrenador.getNombre(),
                            entrenador.getApellido(),
                            entrenador.getEmail(),
                            entrenador.getFNacimiento(),
                            entrenador.getTipo(),
                            entrenador.getContrasena())) 
                    .collect(Collectors.toList());
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<dataTypeUsuario> obtenerDeportistas() {
        try {
            List<Deportista> deportistas = em.createQuery("SELECT d FROM Deportista d", Deportista.class).getResultList();
            return deportistas.stream()
                    .map(deportista -> new dataTypeUsuario(
                            deportista.getNickname(),
                            deportista.getNombre(),
                            deportista.getApellido(),
                            deportista.getEmail(),
                            deportista.getFNacimiento(),
                            deportista.getTipo(),
                            deportista.getContrasena()))
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