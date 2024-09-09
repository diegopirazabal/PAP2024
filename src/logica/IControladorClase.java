package logica;

import java.util.List;

import dtos.dataTypeClase;
import excepciones.ClaseNoExisteException;

public interface IControladorClase {

	List<dataTypeClase> listarTodas() throws ClaseNoExisteException;

}
