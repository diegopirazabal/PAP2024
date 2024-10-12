package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeUsuario;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {
	
	public void crearDeportista(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, String contrasena, boolean esProfesional) throws UsuarioRepetidoException ;
	
	public void crearEntrenador(String nickname, String nombre, String apellido, String email, Date fechaNac, Boolean esEntrenador, String contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException ;

	public dataTypeUsuario consultarUsuario(String nickname) throws UsuarioNoExisteException;
	
	public void eliminarUsuario(String nickname) throws UsuarioNoExisteException;
	
	public List<dataTypeUsuario> listarTodos() throws UsuarioNoExisteException;

	public dataTypeUsuario verInfoUsuario(String nickname) throws UsuarioNoExisteException;

	public List<dataTypeUsuario> listarDeportistas() throws UsuarioNoExisteException;
	
	public List<dataTypeUsuario> listarEntrenadores() throws UsuarioNoExisteException;
	
	public dataTypeUsuario buscarUsuarioPorEmail(String email) throws UsuarioNoExisteException;
}