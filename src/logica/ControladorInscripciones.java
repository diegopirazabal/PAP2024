package logica;
import java.util.Date;

public class ControladorInscripciones implements IControladorInscripciones{
	private manejadorInscripciones manejador;
	
	public ControladorInscripciones() {
        manejador = manejadorInscripciones.getinstance();
    }
	
	@Override
	public void agregarInscripcionAClase(Deportista depor, Clase clase, Date fechaInsc) {
		Inscripcion Ins = new Inscripcion(fechaInsc, clase, depor);
		int x = clase.getCupo() - 1;
		clase.setCupo(x);
		manejador.agregarInscripcionAClase(Ins);
    }

}
