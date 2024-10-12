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

    public void crearDeportista(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, String contrasena, boolean esProfesional) throws UsuarioRepetidoException {
        Usuario deportista = new Deportista(nickname, nombre, apellido, email, fechaNacimiento, esEntrenador, contrasena, esProfesional);
        manejador.agregar(deportista);
    }

    public void crearEntrenador(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, String contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException {
    	Usuario entrenador = new Entrenador(nickname, nombre, apellido, email, fechaNacimiento, esEntrenador, contrasena, disciplina, linkSitioWeb);
    	manejador.agregar(entrenador);    	
    }
    
    public dataTypeUsuario consultarUsuario(String nickname) throws UsuarioNoExisteException {
    	return manejador.buscarUsuarioPorNickname(nickname);
    }
    
    public dataTypeUsuario buscarUsuarioPorEmail(String email) throws UsuarioNoExisteException{
    	return manejador.buscarUsuarioPorEmail(email);
    }
    
    public void eliminarUsuario(String nickname) throws UsuarioNoExisteException{
    	 manejador.eliminar(nickname);
    }
    
    public List<dataTypeUsuario> listarTodos(){
    	return manejador.getUsuarios();
    }
    
    public dataTypeUsuario verInfoUsuario(String nickname) throws UsuarioNoExisteException{
    	return manejador.buscarUsuarioPorNickname(nickname);
    }
    
    public List<dataTypeUsuario> listarEntrenadores() {
        return manejador.obtenerEntrenadores();
    }
    
    public dataTypeUsuario obtenerEntrenadorPorNickname(String nickname) {
    	return manejador.obtenerEntrenadorPorNickname(nickname);
    }

    public List<dataTypeUsuario> listarDeportistas() {
        return manejador.obtenerDeportistas();
    }
}