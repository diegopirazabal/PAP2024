package logica;

public class Fabrica {

		/* Con private static, digo no solo que es privado sino que el miembro pertenece a la clase en lugar 
		 de a las instancias individuales de la clase. Esto significa que solo hay una copia del atributo o m�todo 
		 para todas las instancias de la clase, en lugar de una copia por cada instancia creada.*/
	   
		private static Fabrica instancia;

	    private Fabrica() {  /* Constructor privado para evitar que otras clases puedan instanciarlo */
	    };
	    
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

