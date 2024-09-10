package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeActividad;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.UsuarioNoExisteException;

public class ControladorActividad implements IControladorActividad {
    private manejadorActividad manejador;

    public ControladorActividad() {
        manejador = manejadorActividad.getinstance(); // Usa el método getinstance para obtener la instancia
    }

    public void crearActividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, String nicknameEntrenador) throws ActividadRepetidaException, UsuarioNoExisteException {
        // Buscar el entrenador por nickname
        dataTypeUsuario dtEntrenador = manejador.obtenerEntrenadorPorNickname(nicknameEntrenador);
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

    public void agregarClase(Clase clase, String actividad) throws ActividadNoExisteException {
    	manejador.agregarClase(clase, actividad);
    };
    
    @Override
    public dataTypeActividad consultarActividad(String nombre) throws ActividadNoExisteException {
        return manejador.buscarActividad(nombre);
    }
    
    public Actividad consultarActividad2(String nombre) throws ActividadNoExisteException {
        return manejador.buscarActividad2(nombre);
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
        // Obtener las actividades asociadas al entrenador por su nickname
        return manejador.obtenerActividadesPorEntrenador(nicknameEntrenador);
    }
}
