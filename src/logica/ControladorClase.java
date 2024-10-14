package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeClase;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;

public class ControladorClase implements IControladorClase{
	private ManejadorClase manejador;
	
	public ControladorClase() {
        manejador = manejador.getinstance(); 
	} 
	
	public void crearClase(String nombre, Date fecha,String hora, String lugar, Date fechaAlta, String imagen, int cupo, Actividad actividad) throws ClaseRepetidaException {
        Clase clase = new Clase(nombre, fecha, hora, lugar, imagen, fechaAlta, cupo, actividad);
        manejador.agregarClase(clase);
    }
	
	 @Override
	 public List<dataTypeClase> listarTodas() throws ClaseNoExisteException {
	        return manejador.getClases();
	 }
	 
	 public List<Inscripcion> listarInscripcionesPorClase(String deportista){
		return manejador.listarInscripcionesPorClase(deportista);
	 }
	 
	 public dataTypeClase obtenerClasePorNombre2(String nombre) {
		 return manejador.obtenerClasePorNombre2(nombre);
	 };
	 
	 public Clase obtenerClase(String nombre) {
		 return manejador.obtenerClasePorNombre(nombre);
	 }
	 
	 public List<dataTypeClase> listarporActividad(Actividad act) throws ClaseNoExisteException {
         return manejador.listarporActividad(act);
	 }
	 
	 public List<dataTypeClase> listarporActividadNombre(String act) throws ClaseNoExisteException {
         return manejador.listarporActividadNombre(act);
	 }
	 
     public void agregarClase(Clase clase) throws ClaseRepetidaException {
         manejador.agregarClase(clase);
     }
     
 	public List<dataTypeClase> listarClases(String nombre) throws ClaseNoExisteException {
 		return manejador.getClases(); 
 	}

	@Override
	public List<dataTypeClase> listarClasesPorActividad(String nombreActividad) throws ClaseNoExisteException {
		return manejador.listarClasesPorActividad(nombreActividad);
	}
}