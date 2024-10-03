package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeClase;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;

public class ControladorClase implements IControladorClase{
	private ManejadorClase manejador;
	
	public ControladorClase() {
        manejador = manejador.getinstance(); // Usa el método getinstance para obtener la instancia
    }
	
	public void crearClase(Long id, String nombre, Date fecha,String hora, String lugar, Date fechaAlta, String imagen, int cupo) throws ClaseRepetidaException {
        Clase clase = new Clase(id, nombre, fecha, hora, lugar, imagen, fechaAlta, cupo);
        // Agregar la actividad al manejador
        manejador.agregarClase(clase);
    }
	
	 @Override
	 public List<dataTypeClase> listarTodas() throws ClaseNoExisteException {
	        return manejador.getClases();
	 }
	    
	 public Clase obtenerClase(Long id) {
		 return manejador.obtenerClasePorID(id);
	 }
	 
	 public List<dataTypeClase> listarporActividad(Actividad act) throws ClaseNoExisteException {
         return manejador.listarporActividad(act);
	 }
     public void agregarClase(Clase clase) throws ClaseRepetidaException {
         manejador.agregarClase(clase);
     }
}