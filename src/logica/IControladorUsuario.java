package logica;

import dtos.dataTypeUsuario;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

	
public interface IControladorUsuario {
	    
	    /**
	     * Registra al usuario en el sistema.
	     * @param nom Nombre del usuario.
	     * @param ap Apellido del usuario.
	     * @param nick Nickname del usuario.
	     * @param email Email del usuario.
	     * @param fnac Fecha de nacimiento del usuario.
	     * @throws UsuarioRepetidoException Si el nickname del usuario se encuentra registrada en el sistema.
	     */
		public abstract void registrarUsuario(String nombreU, String apellidoU, String nick, String mail, String fnac, boolean EsEntrenador)  throws UsuarioRepetidoException;
	    /**
	     * Retorna la información de un usuario con el nickname indicado.
	     * @param nick Nickname del usuario.
	     * @return Información del usuario.
	     * @throws UsuarioNoExisteException Si el nickname del usuario no está registrada en el sistema.
	     */
	    public abstract dataTypeUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException;

	    /**
	     * Retorna la información de todos los usuarios registrados en el sistema.
	     * @return Información de los usuarios del sistema.
	     * @throws UsuarioNoExisteException Si no existen usuarios registrados en el sistema.
	     */
	    public abstract dataTypeUsuario[] getUsuarios() throws UsuarioNoExisteException;
	    
	    public dataTypeUsuario[] getUsuariosEntrenadores() throws UsuarioNoExisteException;

		
	}

