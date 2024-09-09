package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dtos.dataTypeClase;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;

public class ControladorClase implements IControladorClase{
	private ManejadorClase manejador;
	
	public ControladorClase() {
        manejador = manejador.getinstance(); // Usa el método getinstance para obtener la instancia
    }
	
	public void crearClase(Long id, LocalDate fecha,LocalTime hora, String lugar, LocalDate fechaAlta, String imagen, int cupo) throws ClaseRepetidaException {
        Clase clase = new Clase(id, fecha, hora, lugar, imagen, fechaAlta, cupo);
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
}