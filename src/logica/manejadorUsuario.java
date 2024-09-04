package logica;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class manejadorUsuario {
    private Map<String, Usuario> usuariosNick;           // Coleccion
    private static manejadorUsuario instancia = null;  // Instancia unica de manejador usando Singleton

    private manejadorUsuario() {                       // Constructor privado
    	usuariosNick = new HashMap<String, Usuario>();
    }

    public static manejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new manejadorUsuario();      // Constructor solo se llama de aca
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickname();    // Get del nickname
        usuariosNick.put(nick, usu);       // agrego al usuario a la coleccion
    }

    public Usuario obtenerUsuario(String ci) {     // Recibo un nickname y devuelvo el objeto Usuario
        return ((Usuario) usuariosNick.get(ci));
    }

    public Usuario[] getUsuarios() {      // Devuelve la coleccion completa de los usuarios en array
        if (usuariosNick.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuariosNick.values(); // Metodo values devuelve la coleccion entera
            Object[] o = usrs.toArray();                    // Devuelve los objetos a una array     
            Usuario[] usuarios = new Usuario[o.length];     // Creo  un array de usuarios
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];              // Cargo con la salida de toArray
            }

            return usuarios;
        }
    }

}