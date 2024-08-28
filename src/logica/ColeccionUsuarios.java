package logica; 

import java.util.HashSet;
import java.util.Set;

public class ColeccionUsuarios {
	private Set<Usuario> usuarios;
	
	public ColeccionUsuarios () {
		this.usuarios = new HashSet<>();
	}
	
	public boolean agregarUsuario(Usuario usuario) {
        return usuarios.add(usuario);
    }

    public boolean borrarUsuario(Usuario usuario) {
        return usuarios.remove(usuario);
    }

    public boolean existeUsuario(Usuario usuario) {
        return usuarios.contains(usuario);
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}


