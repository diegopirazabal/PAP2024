package logica;
import logica.manejadorInscripciones;

public class ControladorInscripciones implements IControladorInscripciones{
	private manejadorInscripciones manejador;
	public ControladorInscripciones() {
        manejador = manejadorInscripciones.getinstance();
    }
	
	
	@Override
	public void agregarInscripcion(Inscripcion inscripcion) {
        manejador.agregarInscripcion
    }

}
