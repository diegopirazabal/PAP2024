package logica;
import java.util.*;

import com.toedter.calendar.JDateChooser;

import dtos.dataTypeUsuario;
import excepciones.*;

public class controladorUsuario implements IControladorUsuario{
    private manejadorUsuarios manejador;

    public controladorUsuario() {
        manejador = new manejadorUsuarios();
    }

    public void crearDeportista(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, char[] contrasena, boolean esProfesional) throws UsuarioRepetidoException {
        Usuario deportista = new Deportista(nickname, nombre, apellido, email, fechaNacimiento, esEntrenador, contrasena, esProfesional);
        manejador.agregar(deportista);
    }

    public void crearEntrenador(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, char[] contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException {
    	Usuario entrenador = new Entrenador(nickname, nombre, apellido, email, fechaNacimiento, esEntrenador, contrasena, disciplina, linkSitioWeb);
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
    
    public List<dataTypeUsuario> listarEntrenadores() {
        return manejador.obtenerEntrenadores();
    }

//    public List<dataTypeUsuario> listarEntrenadores() {
//        return manejadorUsuarios.getinstance().obtenerEntrenadores();
//    }

    public List<dataTypeUsuario> listarDeportistas() {
        return manejador.obtenerDeportistas();
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