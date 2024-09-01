package logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class manejadorActividades {
    private Map<String, Actividad> actividades;

    public manejadorActividades() {
        actividades = new HashMap<>();
    }

    public void agregarActividad(Actividad actividad) {
        actividades.put(actividad.getNombre(), actividad);
    }

    public Actividad buscarActividad(String nombre) {
        return actividades.get(nombre);
    }

    public void eliminarActividad(String nombre) {
        actividades.remove(nombre);
    }

    public List<Actividad> obtenerTodasLasActividades() {
        return actividades.values().stream().collect(Collectors.toList());
    }
}