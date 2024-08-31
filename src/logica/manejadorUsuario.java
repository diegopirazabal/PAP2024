package logica;

import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuario {
    private Map<String, Usuario> usuarios;

    // Constructor
    public ManejadorUsuario() {
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
    public Usuario obtenerUsuario(String nickname) throws UsuarioNoExisteExcepcion {
        Usuario usuario = usuarios.get(nickname);
        if (usuario == null) {
            throw new UsuarioNoExisteExcepcion("El usuario con nickname " + nickname + " no existe.");
        }
        return usuario;
    }

    // Otros métodos...
}