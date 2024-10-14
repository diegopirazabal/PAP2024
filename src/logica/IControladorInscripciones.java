package logica;

import java.util.Date;

import excepciones.UsuarioNoExisteException;

public interface IControladorInscripciones {

	public void agregarInscripcionAClase(String depor, String clase, Date fechaInsc) throws UsuarioNoExisteException;
}
