package logica;

import dtos.dataTypeActividad;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;

public interface IControladorActividad {

	public void registrarActividad(String nombreA, String descA, String lugarA, int duracionA, double CostoA, String fechaA, String imgA, String nomEnt) throws ActividadRepetidaException;
	
	public dataTypeActividad verInfoActividad(String nomA) throws ActividadNoExisteException;
	
	public dataTypeActividad[] getActividad() throws ActividadNoExisteException;
}
