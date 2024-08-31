package logica;
import excepciones.*;
import java.util.HashMap;
import java.util.Map;

public class manejadorUsuario {
    private Map<String, Usuario> usuarios;

    // Constructor
    public manejadorUsuario() {
        usuarios = new HashMap<>();
    }

    // Método para agregar un usuario
    public void agregarUsuario(Usuario usuario) throws UsuarioRepetidoException {
        if (usuarios.containsKey(usuario.getNickname())) {
            throw new UsuarioRepetidoException("El usuario con nickname " + usuario.getNickname() + " ya existe.");
        }
        usuarios.put(usuario.getNickname(), usuario);
    }

    // Método para obtener un usuario por su nickname
    public Usuario obtenerUsuario(String nickname) throws UsuarioNoExisteException {
        Usuario usuario = usuarios.get(nickname);
        if (usuario == null) {
            throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
        }
        return usuario;
    }
    // Otros métodos...
} 