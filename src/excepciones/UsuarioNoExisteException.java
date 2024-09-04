package excepciones;

@SuppressWarnings("serial")
public class UsuarioNoExisteException extends Exception {

    public UsuarioNoExisteException(String string) {
        super(string);  // Le pasamos al constructor de la clase exception el mensaje especifico
    }
}
