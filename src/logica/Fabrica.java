package logica;

public class Fabrica {

		/* Con private static, digo no solo que es privado sino que el miembro pertenece a la clase en lugar 
		 de a las instancias individuales de la clase. Esto significa que solo hay una copia del atributo o m�todo 
		 para todas las instancias de la clase, en lugar de una copia por cada instancia creada.*/
	   
		private static Fabrica instancia;

	    private Fabrica() {
	    };
	    
	    public static Fabrica getInstance() {
	        if (instancia == null) {
	            instancia = new Fabrica();
	        }
	        return instancia;
	    }
	    public IControladorUsuario getIControladorUsuario() {
	        return new controladorUsuario();
	    }
	    
	    public IControladorActividad getIControladorActividad() {
	    	return new ControladorActividad();
	    }
	    
	    public IControladorClase getIcontroladorClase() {
	    	return new ControladorClase();
	    }
}