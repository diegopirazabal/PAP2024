package logica;
import logica.Usuario;
import java.time.LocalDate;
import java.util.*;

import excepciones.*;

public class ControladorUsuario {
    private manejadorUsuario manejador;

    public ControladorUsuario() {
        manejador = new manejadorUsuario();
    }

    public void crearUsuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, boolean esProfesional) throws UsuarioRepetidoException {
        Usuario usuario = new Deportista(nickname, nombre, apellido, email, fechaNacimiento, contrasena, esProfesional);
        manejador.agregar(usuario);
    }

    public Usuario consultarUsuario(String nickname) throws UsuarioNoExisteException {
        return manejador.buscarUsuario(nickname);
    }

    public void eliminarUsuario(String nickname) throws UsuarioNoExisteException{
    	 manejador.eliminar(nickname);
    }
    
    public List<Usuario> listarTodos(){
    	return manejador.obtenerTodos();
    }
/*
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre.uy");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    //tx.begin();
    //em.persist(usu);
    //tx.commit();
    //em.close();
    //emf.close();
*/