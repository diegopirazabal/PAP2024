package logica;
import java.util.Date;


import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.UsuarioNoExisteException;

public class ControladorInscripciones implements IControladorInscripciones{
	private manejadorInscripciones manejador;
	private IControladorUsuario controlUsu = Fabrica.getInstance().getIControladorUsuario();
	private IControladorClase contCla = Fabrica.getInstance().getIcontroladorClase();
	
	public ControladorInscripciones() {
        manejador = manejadorInscripciones.getinstance();
    }
	
	@Override
	public void agregarInscripcionAClase(String depor, String clase, Date fechaInsc) throws UsuarioNoExisteException {
		System.out.println("Llegue al controladorInscripciones");
		
		dataTypeUsuario dtDeportista;
		try {
			dtDeportista = controlUsu.verInfoUsuario(depor);
			System.out.println("dtDeportista = " + dtDeportista);
			//check
			Deportista deportista = new Deportista();
	        deportista.setNickname(dtDeportista.getNickname());
	        deportista.setNombre(dtDeportista.getNombre());
	        deportista.setApellido(dtDeportista.getApellido());
	        deportista.setContrasena(dtDeportista.getContrasena());
	        deportista.setEmail(dtDeportista.getEmail());
	        deportista.esEntrenador = false;
	        deportista.setFNacimiento(dtDeportista.getFNacimiento());

	        System.out.println("\n\ndeportista nickname: " + deportista.getNickname() + "\n\n");
	        
	        dataTypeClase dtClase = contCla.obtenerClasePorNombre2(clase);
	        Clase clase2 = new Clase();
			clase2.setNombre(dtClase.getNombre());
	        
			Inscripcion Ins = new Inscripcion();
	        Ins.setClase(clase2);
	        Ins.setDeportista(deportista);
	        Ins.setFechaInscripcion(fechaInsc);
	        
			
	        System.out.println("\n\nDEPORTISTA: "+ deportista + "\n\nCLASE: " + clase2);
			
	        int x = dtClase.getCupo() - 1;
			dtClase.setCupo(x);
			
			System.out.println("LA INSCRIPCION QUE LE PASO AL MANEJADOR ES: " + Ins);
			
			manejador.agregarInscripcionAClase(Ins);
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		
    }


}


