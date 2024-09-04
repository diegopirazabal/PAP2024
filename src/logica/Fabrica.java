package logica;


public class Fabrica {

	/* Con private static, digo no solo que es privado sino que el miembro pertenece a la clase en lugar 
	 de a las instancias individuales de la clase. Esto significa que solo hay una copia del atributo o m�todo 
	 para todas las instancias de la clase, en lugar de una copia por cada instancia creada.*/
   
	private static Fabrica instancia;

    private Fabrica() {  /* Constructor privado para evitar que otras clases puedan instanciarlo */
    };

    /*La primera vez que se llama a getInstance(), la instancia se crea y almacenada en la variable instance. 
     En llamadas posteriores, simplemente se devuelve la instancia ya creada.*/
    
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();   // SOlo de aca se puede llamar al contructor
        }
        return instancia;
    }
    /*Metodo publico para devolver el controlador*/
    public IControladorUsuario getIControladorUsuario() {
        return new ControladorUsuario();
    }

}