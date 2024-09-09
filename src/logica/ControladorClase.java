package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import dtos.dataTypeActividad;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.UsuarioNoExisteException;

public class ControladorClase implements IControladorClase{
	private ManejadorClase manejador;

    public ControladorClase() {
        manejador = ManejadorClase.getinstance(); // Usa el método getinstance para obtener la instancia
    }

    public void crearClase(LocalDate fecha, LocalTime hora, String lugar, String imagen, LocalDate fechaAlta, int cupo, String nickname) throws ClaseRepetidaException, ClaseNoExisteException {
        
        dataTypeUsuario dtDeportista = manejador.obtenerDeportista(nickname);
        if (dtDeportista == null) {
            throw new UsuarioNoExisteException("El deportista con nickname " + nickname + " no existe.");
        }
        Clase clase = new Clase(fecha, hora, lugar, imagen, fechaAlta, cupo);

        manejador.agregarClase(clase);
    }


    @Override
    public dataTypeActividad consultarClase(String nombre) throws ActividadNoExisteException {
        return manejador.buscarClase(nombre);
    }

    @Override
    public void eliminarClase(String nombre) throws ActividadNoExisteException {
        manejador.eliminar(nombre);
    }

    @Override
    public List<dataTypeClase> listarClases() throws ActividadNoExisteException {
        return manejador.getClases();
    }



    @Override
    public List<dataTypeActividad> listarActividadesPorEntrenador(String nicknameEntrenador) throws UsuarioNoExisteException {
        // Obtener las actividades asociadas al entrenador por su nickname
        return manejador.obtenerActividadesPorEntrenador(nicknameEntrenador);
    }
}
