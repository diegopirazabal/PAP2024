package logica;
import java.util.*;
import dtos.dataTypeUsuario;
import excepciones.*;

public class controladorUsuario implements IControladorUsuario{
    private manejadorUsuarios manejador;

    public controladorUsuario() {
        manejador = new manejadorUsuarios();
    }

    public void crearDeportista(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String contrasena, boolean esProfesional) throws UsuarioRepetidoException {
        Usuario deportista = new Deportista(nickname, nombre, apellido, email, fechaNacimiento, contrasena, esProfesional);
        manejador.agregar(deportista);
    }

    public void crearEntrenador(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException {
    	Usuario entrenador = new Entrenador(nickname, nombre, apellido, email, fechaNacimiento, contrasena, disciplina, linkSitioWeb);
    	manejador.agregar(entrenador);    	
    }
    
    public dataTypeUsuario consultarUsuario(String nickname) throws UsuarioNoExisteException {
    	return manejador.buscarUsuario(nickname);
    }

    public void eliminarUsuario(String nickname) throws UsuarioNoExisteException{
    	 manejador.eliminar(nickname);
    }
    
    public List<dataTypeUsuario> listarTodos(){
    	return manejador.obtenerTodos();
    }
    
    public dataTypeUsuario verInfoUsuario(String nickname) throws UsuarioNoExisteException{
    	return manejador.buscarUsuario(nickname);
    }
    
//    public List<dataTypeUsuario> getUsuarios() throws UsuarioNoExisteException {
//        manejadorUsuarios mu = manejadorUsuarios.getinstance();
//        List<dataTypeUsuario> usuarios = mu.obtenerTodos(); // Método que devuelve List<dataTypeUsuario>
//
//        if (usuarios != null && !usuarios.isEmpty()) {
//            return usuarios;
//        } else {
//            throw new UsuarioNoExisteException("No existen usuarios registrados");
//        }
//    }
}