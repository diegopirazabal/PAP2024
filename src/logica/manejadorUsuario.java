import java.util.ArrayList;
import java.util.List;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class manejadorUsuario {
    private EntityManagerFactory emf;
    private EntityManager em;

    public manejadorUsuario() {
        this.emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        this.em = emf.createEntityManager();
    }

    public void agregar(Usuario usuario) throws UsuarioRepetidoException {
        // Verificar si el usuario ya existe en la base de datos
        Usuario usuarioExistente = buscarUsuarioPorNickname(usuario.getNickname());
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

    private Usuario buscarUsuarioPorNickname(String nickname) {
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

    public Usuario buscarUsuario(String nickname) throws UsuarioNoExisteException {
        Usuario usuario = buscarUsuarioPorNickname(nickname);
        if (usuario == null) {
            throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
        }
        return usuario;
    }

    public void eliminar(String nickname) throws UsuarioNoExisteException {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Usuario usuario = buscarUsuarioPorNickname(nickname);
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

    public List<Usuario> obtenerTodos() {
        try {
            return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
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
