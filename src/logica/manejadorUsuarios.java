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
    private Usuario obtenerUsuarioPorNickname(String nickname) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                     .setParameter("nickname", nickname)
                     .getResultStream()
                     .findFirst()
                     .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public manejadorUsuarios() {
        this.emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        this.em = emf.createEntityManager();
    }
    
    public static manejadorUsuarios getinstance() {
        if (instancia == null)
            instancia = new manejadorUsuarios();      // Constructor solo se llama de aca
        return instancia;
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
                            usuario.getTipo()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Retornar una lista vacía en caso de excepción
        }
    }


    public void agregar(Usuario usuario) throws UsuarioRepetidoException {
        // Verificar si el usuario ya existe en la base de datos utilizando la nueva función
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


    public dataTypeUsuario buscarUsuarioPorNickname(String nickname) {
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nickname = :nickname", Usuario.class)
                    .setParameter("nickname", nickname)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (usuario != null) {
                return new dataTypeUsuario(
                        usuario.getNickname(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getFNacimiento(),
                        usuario.getTipo()
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public dataTypeUsuario buscarUsuario(String nickname) throws UsuarioNoExisteException {
        dataTypeUsuario usuario = buscarUsuarioPorNickname(nickname);
        if (usuario == null) {
            throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
        }
        return usuario;
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


    public List<dataTypeUsuario> obtenerTodos() {
        try {
            List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
            return usuarios.stream()
                    .map(usuario -> new dataTypeUsuario(
                            usuario.getNickname(),
                            usuario.getNombre(),
                            usuario.getApellido(),
                            usuario.getEmail(),
                            usuario.getFNacimiento(),
                            usuario.getTipo()))
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
