package logica;
import logica.Actividad.*;
import dtos.dataTypeActividad;
import logica.Usuario.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import dtos.dataTypeUsuario;

// import excepciones.ActividadNoExisteException;
 
public class controladorActividades {
	private manejadorActividades manejador;
	
    public controladorActividades() {
        manejador = new manejadorActividades();
    }

    public void crearActividad(String nombre, String descripcion, int duracion, double costo, String lugar, LocalDate fechaAlta, estadoActividad estado, String imagen, Entrenador entrenador) {
    	Actividad actividad = new Actividad(nombre, descripcion, duracion, costo, lugar, fechaAlta, estado, imagen, entrenador);
    	manejador.agregarActividad(actividad);
    }
    
    public Actividad consultarActividad(String nombre) {
        return manejador.buscarActividad(nombre);
    }
    
    public void eliminarActividad(String nombre) // throws ActividadNoExisteException
    {
   	 manejador.eliminarActividad(nombre);
   }
    
//    @GetMapping("/actividades")
//    public List<dataTypeActividad> listarActividades() {
//        List<Actividad> actividades = manejador.obtenerTodasLasActividades(); // Asumiendo que tienes un servicio para obtener actividades
//        return actividades.stream()
//                .map(actividad -> new dataTypeActividad(
//                    actividad.getId(),
//                    actividad.getNombre(),
//                    actividad.getDescripcion(),
//                    actividad.getDuracion(),
//                    actividad.getCosto(),
//                    actividad.getLugar(),
//                    actividad.getFechaAlta(),
//                    actividad.getEstado(),
//                    actividad.getImagen(),
//                    actividad.getEntrenador() != null ? actividad.getEntrenador().getId() : null
//                ))
//                .collect(Collectors.toList());
//    }















}