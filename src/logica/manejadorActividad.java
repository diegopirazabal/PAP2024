package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class manejadorActividad {
	private Map<String, Actividad> actividadNom;           // Coleccion
    private static manejadorActividad instancia = null;  // Instancia unica de manejador usando Singleton

    private manejadorActividad() {                       // Constructor privado
    	actividadNom = new HashMap<String, Actividad>();
    }

    public static manejadorActividad getinstance() {
        if (instancia == null)
            instancia = new manejadorActividad();      // Constructor solo se llama de aca
        return instancia;
    }

    public void addActividad(Actividad act) {
        String nomA = act.getNombre();    // Get del nickname
        actividadNom.put(nomA, act);       // agrego al usuario a la coleccion
    }

    public Actividad obtenerActividad(String nomA) {     // Recibo un nickname y devuelvo el objeto Usuario
        return ((Actividad) actividadNom.get(nomA));
    }

    public Actividad[] getActividades() {      // Devuelve la coleccion completa de los usuarios en array
        if (actividadNom.isEmpty())
            return null;
        else {
            Collection<Actividad> acts = actividadNom.values(); // Metodo values devuelve la coleccion entera
            Object[] o = acts.toArray();                    // Devuelve los objetos a una array     
            Actividad[] activ = new Actividad[o.length];     // Creo  un array de usuarios
            for (int i = 0; i < o.length; i++) {
            	activ[i] = (Actividad) o[i];              // Cargo con la salida de toArray
            }
            return activ;
        }
    }

}
