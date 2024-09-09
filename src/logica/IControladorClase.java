package logica;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import dtos.dataTypeClase;
import excepciones.ClaseNoExisteException;
import excepciones.ClaseRepetidaException;

public interface IControladorClase {

	List<dataTypeClase> listarTodas() throws ClaseNoExisteException;
	Clase obtenerClase(Long id);
	void crearClase(Long id, String nombre, Date fecha,String hora, String lugar, Date fechaAlta, String imagen, int cupo) throws ClaseRepetidaException;
}
