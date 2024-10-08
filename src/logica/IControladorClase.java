package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;

public interface IControladorClase {

	List<dataTypeClase> listarTodas() throws ClaseNoExisteException;
	
	Clase obtenerClase(String nombre);
	
	public List<dataTypeClase> listarClases(String nombre) throws ClaseNoExisteException;
	
	void crearClase(String nombre, Date fecha,String hora, String lugar, Date fechaAlta, String imagen, int cupo, Actividad actividad) throws ClaseRepetidaException;
	
	public List<dataTypeClase> listarporActividad(Actividad act) throws ClaseNoExisteException;
	
	public List<dataTypeClase> listarporActividadNombre(String act) throws ClaseNoExisteException;
	
	public void agregarClase(Clase clase) throws ClaseRepetidaException;
    
	public List<dataTypeClase> listarClasesPorActividad(String nombreActividad) throws ClaseNoExisteException;
}