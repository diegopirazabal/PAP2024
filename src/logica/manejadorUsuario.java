package logica;
import excepciones.*;
import java.util.*;
import java.util.stream.Collectors;


public class manejadorUsuario {
    private Map<String, Usuario> usuarios;

    // Constructor
    public manejadorUsuario() {
        usuarios = new HashMap<>();
    }

    // Método para agregar un usuario
    public void agregar(Usuario usuario) throws UsuarioRepetidoException {
        if (usuarios.containsKey(usuario.getNickname())) {
            throw new UsuarioRepetidoException("El usuario con nickname " + usuario.getNickname() + " ya existe.");
        }
        usuarios.put(usuario.getNickname(), usuario);
    }

    // Método para obtener un usuario por su nickname
    public Usuario buscarUsuario(String nickname) throws UsuarioNoExisteException {
        Usuario usuario = usuarios.get(nickname);
        if (usuario == null) {
            throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
        }
        return usuario;
    }

    public void eliminar(String nickname) throws UsuarioNoExisteException {
        if (!usuarios.containsKey(nickname)) {
            throw new UsuarioNoExisteException("El usuario con nickname " + nickname + " no existe.");
        }
        usuarios.remove(nickname);
    }

    public List<Usuario> obtenerTodos() {
        return usuarios.values().stream().collect(Collectors.toList());
    }

} 