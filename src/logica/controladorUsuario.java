package logica;
import logica.Usuario;
import java.time.LocalDate;
import java.util.*;
import dtos.dataTypeUsuario;
import excepciones.*;

public class ControladorUsuario  implements IControladorUsuario{
    private manejadorUsuario manejador;

    public ControladorUsuario() {
        manejador = new manejadorUsuario();
    }

    public void crearDeportista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, boolean esProfesional) throws UsuarioRepetidoException {
        Usuario deportista = new Deportista(nickname, nombre, apellido, email, fechaNacimiento, contrasena, esProfesional);
       
        manejador.agregar(deportista);
    }

    public void crearEntrenador(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException {
    	Usuario entrenador = new Entrenador(nickname, nombre, apellido, email, fechaNacimiento, contrasena, disciplina, linkSitioWeb);
    	manejador.agregar(entrenador);    	
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
    
    public dataTypeUsuario[] getUsuarios() throws UsuarioNoExisteException {
        manejadorUsuario mu = manejador.getinstance();
        Usuario[] usrs = mu.getUsuarios();  // Usa el getUsuarios que devuelve array de objetos

        if (usrs != null) {
        	dataTypeUsuario[] du = new dataTypeUsuario[usrs.length];
            Usuario usuario;

            // Para separar logica de presentacion, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usrs.length; i++) {
                usuario = usrs[i];
                du[i] = new dataTypeUsuario(usuario.getNickname(),usuario.getNombre(), usuario.getApellido(), usuario.getNickname(), usuario.getFechaNacimiento());
                // pasa el array de objetos a array de DataUsuaios
            }

            return du;
        } else
            throw new UsuarioNoExisteException("No existen usuarios registrados");
    }
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