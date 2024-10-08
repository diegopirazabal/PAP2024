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

    public void crearActividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, String nicknameEntrenador) throws ActividadRepetidaException, UsuarioNoExisteException, UsuarioRepetidoException;

    public dataTypeActividad consultarActividad(String nombre) throws ActividadNoExisteException;
    
    public Actividad consultarActividad2(String nombre) throws ActividadNoExisteException;
    
    public void eliminarActividad(String nombre) throws ActividadNoExisteException;

    public List<dataTypeActividad> listarTodas() throws ActividadNoExisteException;

    public List<dataTypeActividad> listarActividadesPorEntrenador(String nicknameEntrenador) throws UsuarioNoExisteException;
    
    public dataTypeUsuario obtenerEntrenadorDeLaActividadPorNickname(String nickname) throws UsuarioRepetidoException;
}
