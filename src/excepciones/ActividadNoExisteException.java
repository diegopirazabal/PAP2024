package excepciones;

@SuppressWarnings("serial")
public class ActividadNoExisteException extends Exception {
	public ActividadNoExisteException(String string) {
        super(string); 
    }
}