package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * Clase que conserva la coleccion global de los usuarios del sistema.
 * Los usuarios se identifican por su nickname.
 * Se implementa en base al patron Singleton.
 * 
 */ 
public class ManejadorUsuario {
    private Map<String, Usuario> usuarios;           // Coleccion
    private static ManejadorUsuario instancia = null;  // Instancia unica de manejador usando Singleton

    private ManejadorUsuario() {                       // Constructor privado
        usuarios = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();      // Constructor solo se llama de aca
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String ci = usu.getNickname();    // Get de la cedula
        usuarios.put(ci, usu);                 // agrego al usuario a la coleccion
    }

    public Usuario obtenerUsuario(String nickname) {     // Recibo una cedula y devuelvo el objeto Usuario
        return ((Usuario) usuarios.get(nickname));
    }

    public Usuario[] getUsuarios() {      // Devuelve la coleccion completa de los usuarios en array
        if (usuarios.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuarios.values(); // Metodo values devuelve la coleccion entera
            Object[] o = usrs.toArray();                    // Devuelve los objetos a una array     
            Usuario[] usuarios = new Usuario[o.length];     // Creo  un array de usuarios
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];              // Cargo con la salida de toArray
            }

            return usuarios;
        }
    }

}
