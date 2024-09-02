package logica;

import java.time.LocalDate;
import java.util.List;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {
	
	public void crearDeportista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, boolean esProfesional) throws UsuarioRepetidoException ;
	
	public void crearEntrenador(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException ;

	public Usuario consultarUsuario(String nickname) throws UsuarioNoExisteException;
	
	public void eliminarUsuario(String nickname) throws UsuarioNoExisteException;
	
	public List<Usuario> listarTodos();
}
