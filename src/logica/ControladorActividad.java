package logica;
import dtos.dataTypeActividad;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;

public class ControladorActividad implements IControladorActividad {

	public ControladorActividad() {
	}
	
	public void registrarActividad(String nombreA, String descA, String lugarA, int duracionA, double CostoA, String fechaA, String imgA, String nomEnt) throws ActividadRepetidaException{
		manejadorActividad ma = manejadorActividad.getinstance();
        Actividad a = ma.obtenerActividad(nombreA);  // Lo voy a buscar a la coleccion
        if (a != null)  // Si lo encontre es porque ya existe
            throw new ActividadRepetidaException("La actividad con ese nombre ya esta registrada");

        a = new Actividad(nombreA, descA, duracionA, lugarA, CostoA, fechaA, imgA, nomEnt);  // Creo el objeto con el contructor de la clase Usuario
        ma.addActividad(a);
	}
	
	public dataTypeActividad verInfoActividad(String nomA) throws ActividadNoExisteException {
        manejadorActividad ma = manejadorActividad.getinstance();  // mu tiene la coleccion
        Actividad a = ma.obtenerActividad(nomA);                     // u obtiene el usuario pasado por parametro 
        if (a != null) // Si lo encontre es porque ya existe, solo traigo sus datos
            return new dataTypeActividad(a.getNombre(),a.getDescripcion(),a.getDuracion(), a.getCosto(), a.getLugar(), a.getFechaAlta(), a.getImagen(), a.getNomEntrenador());
        else
            throw new ActividadNoExisteException("La actividad con ese nombre no existe");

	}
	
	public dataTypeActividad[] getActividad() throws ActividadNoExisteException {
        manejadorActividad ma = manejadorActividad.getinstance();
        Actividad[] acts = ma.getActividades();  // Usa el getUsuarios que devuelve array de objetos

        if (acts != null) {
        	dataTypeActividad[] da = new dataTypeActividad[acts.length];
            Actividad actividad;

            // Para separar logica de presentacion, no se deben devolver los Usuario, sino los DataUsuario.
            for (int i = 0; i < acts.length; i++) {
                actividad = acts[i];
                da[i] = new dataTypeActividad(actividad.getNombre(),actividad.getDescripcion(),actividad.getDuracion(), actividad.getCosto(), actividad.getLugar(), actividad.getFechaAlta(), actividad.getImagen(), actividad.getNomEntrenador());
                // pasa el array de objetos a array de DataUsuaios
            }
            return da;
        } else
            throw new ActividadNoExisteException("No existen actividades registradas");
    }
	
	
}
