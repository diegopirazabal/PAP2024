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
        manejador = manejadorActividad.getinstance(); // Usa el método getinstance para obtener la instancia
    }

    public void crearActividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, String nicknameEntrenador) throws ActividadRepetidaException, UsuarioNoExisteException, UsuarioRepetidoException {
        // Buscar el entrenador por nickname
        dataTypeUsuario dtEntrenador = manejador.obtenerEntrenadorDeLaActividadPorNickname(nicknameEntrenador);
        if (dtEntrenador == null) {
            throw new UsuarioNoExisteException("El entrenador con nickname " + nicknameEntrenador + " no existe.");
        }

        // Crear la nueva actividad
        Entrenador entrenador = new Entrenador(); // Crear el objeto Entrenador
        entrenador.setNickname(dtEntrenador.getNickname()); // Asegúrate de que los campos se ajusten
        // Setear otros campos de Entrenador si es necesario

        Actividad actividad = new Actividad(nombre, descripcion, duracion, costo, lugar, fechaAlta, imagen, entrenador);

        // Agregar la actividad al manejador
        manejador.agregar(actividad);
    }

//    public void agregarClase(Clase clase, String actividad) throws ClaseRepetidaException {
//    	manejadorC.agregarClase(clase);
//    };
    
    @Override
    public dataTypeActividad consultarActividad(String nombre) throws ActividadNoExisteException {
    	//Devuelve un objeto de tipo dataTypeActividad con nombre "nombre"
        return manejador.buscarActividadPorNombre(nombre);
    }
    
    public Actividad consultarActividad2(String nombre) throws ActividadNoExisteException {
    	//Devuelve un objeto de tipo actividad con nombre "nombre"
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

//    public List<dataTypeClase> listarClases(String nombreAct) throws ActividadNoExisteException {
//    	return manejador.getClases(nombreAct);
//    }

    @Override
    public List<dataTypeActividad> listarActividadesPorEntrenador(String nicknameEntrenador) throws UsuarioNoExisteException {
        // Obtener las actividades asociadas al entrenador por su nickname
        return manejador.obtenerActividadesPorEntrenador(nicknameEntrenador);
    }

	@Override
	public dataTypeUsuario obtenerEntrenadorDeLaActividadPorNickname(String nickname) throws UsuarioRepetidoException {
		// TODO Auto-generated method stub
		return manejador.obtenerEntrenadorDeLaActividadPorNickname(nickname);
	}

}
