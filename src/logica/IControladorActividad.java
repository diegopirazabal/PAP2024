package logica;

import java.util.Date;
import java.util.List;

import dtos.dataTypeActividad;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;

public interface IControladorActividad {

    // Método para crear una actividad, donde el entrenador es un String nickname
    public void crearActividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, String nicknameEntrenador) throws ActividadRepetidaException, UsuarioNoExisteException, UsuarioRepetidoException;

    // Método para consultar una actividad por su nombre
    public dataTypeActividad consultarActividad(String nombre) throws ActividadNoExisteException;
    
    public Actividad consultarActividad2(String nombre) throws ActividadNoExisteException;

    // Método para eliminar una actividad por su nombre
    public void eliminarActividad(String nombre) throws ActividadNoExisteException;

    // Método para listar todas las actividades
    public List<dataTypeActividad> listarTodas() throws ActividadNoExisteException;

    // Método para listar actividades asociadas a un entrenador específico por su nickname
    public List<dataTypeActividad> listarActividadesPorEntrenador(String nicknameEntrenador) throws UsuarioNoExisteException;
    
    public dataTypeUsuario obtenerEntrenadorDeLaActividadPorNickname(String nickname) throws UsuarioRepetidoException;
}
