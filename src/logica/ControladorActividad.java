package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.ClaseRepetidaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

public class ControladorActividad implements IControladorActividad {
    private manejadorActividad manejador;
    private manejadorUsuarios manejadorU;
    private ManejadorClase manejadorC;
    public ControladorActividad() {
        manejador = manejadorActividad.getinstance();
    }

    public void crearActividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, String nicknameEntrenador) throws ActividadRepetidaException, UsuarioNoExisteException, UsuarioRepetidoException {
        dataTypeUsuario dtEntrenador = manejador.obtenerEntrenadorDeLaActividadPorNickname(nicknameEntrenador);
        if (dtEntrenador == null) {
            throw new UsuarioNoExisteException("El entrenador con nickname " + nicknameEntrenador + " no existe.");
        }

        Entrenador entrenador = new Entrenador();
        entrenador.setNickname(dtEntrenador.getNickname()); 

        Actividad actividad = new Actividad(nombre, descripcion, duracion, costo, lugar, fechaAlta, imagen, entrenador);

        manejador.agregar(actividad);
    }
    
    @Override
    public List<dataTypeActividad> getConfirmadas() throws ActividadNoExisteException{
    	return manejador.getConfirmadas();
    }
    
    @Override
    public void rechazarActividad(Actividad x) {
    	manejador.rechazarActividad(x);
    }
    
    @Override
    public void activarActividad(Actividad x) {
    	manejador.activarActividad(x);
    }
    
    @Override
    public dataTypeActividad consultarActividad(String nombre) throws ActividadNoExisteException {
        return manejador.buscarActividadPorNombre(nombre);
    }
    
    public Actividad consultarActividad2(String nombre) throws ActividadNoExisteException {
        return manejador.obtenerActividadPorNombre(nombre);
    }

    @Override
    public void eliminarActividad(String nombre) throws ActividadNoExisteException {
        manejador.eliminar(nombre);
    }

    @Override
    public List<dataTypeActividad> listarTodas() throws ActividadNoExisteException {
        return manejador.getActividades();
    }

    @Override
    public List<dataTypeActividad> listarActividadesPorEntrenador(String nicknameEntrenador) throws UsuarioNoExisteException {
        return manejador.obtenerActividadesPorEntrenador(nicknameEntrenador);
    }

	@Override
	public dataTypeUsuario obtenerEntrenadorDeLaActividadPorNickname(String nickname) throws UsuarioRepetidoException {
		return manejador.obtenerEntrenadorDeLaActividadPorNickname(nickname);
	}
	@Override
    public List<dataTypeActividad> getAgregadas() throws ActividadNoExisteException {
        return manejador.getAgregadas();
    }
	

}