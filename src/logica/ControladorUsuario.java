package logica;

import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;


public class ControladorUsuario implements IControladorUsuario {

	 public ControladorUsuario() {		 
	 }
	 
	 public void registrarUsuario(String nom, String ap, String nick, String email, String fnac, boolean EsEntrenador) throws UsuarioRepetidoException {
	        manejadorUsuario mu = manejadorUsuario.getinstance();
	        Usuario u = mu.obtenerUsuario(nick);  // Lo voy a buscar a la coleccion
	        if (u != null)  // Si lo encontre es porque ya existe
	            throw new UsuarioRepetidoException("El usuario " + nick + " ya esta registrado");

	        u = new Usuario(nom, ap, nick, email, fnac, EsEntrenador);  // Creo el objeto con el contructor de la clase Usuario
	        mu.addUsuario(u);
	 }
	 
	 public dataTypeUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException {
	        manejadorUsuario mu = manejadorUsuario.getinstance();  // mu tiene la coleccion
	        Usuario u = mu.obtenerUsuario(nick);                     // u obtiene el usuario pasado por parametro 
	        if (u != null) // Si lo encontre es porque ya existe, solo traigo sus datos
	            return new dataTypeUsuario(u.getNombre(), u.getApellido(), u.getNickname(), u.getEmail(), u.getFnacimiento(), u.getTipo());
	        else
	            throw new UsuarioNoExisteException("El usuario " + nick + " no existe");

	 }
	 
	   public dataTypeUsuario[] getUsuarios() throws UsuarioNoExisteException {
	        manejadorUsuario mu = manejadorUsuario.getinstance();
	        Usuario[] usrs = mu.getUsuarios();  // Usa el getUsuarios que devuelve array de objetos

	        if (usrs != null) {
	        	dataTypeUsuario[] du = new dataTypeUsuario[usrs.length];
	            Usuario usuario;

	            // Para separar logica de presentacion, no se deben devolver los Usuario, sino los DataUsuario.
	            for (int i = 0; i < usrs.length; i++) {
	                usuario = usrs[i];
	                du[i] = new dataTypeUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getNickname(), usuario.getEmail(), usuario.getFnacimiento(), usuario.getTipo());
	                // pasa el array de objetos a array de DataUsuaios
	            }
	            return du;
	        } else
	            throw new UsuarioNoExisteException("No existen usuarios registrados");
	    }
}
