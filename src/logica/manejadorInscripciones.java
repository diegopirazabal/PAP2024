package logica;

import java.util.ArrayList;
import java.util.List;
import logica.Usuario.Deportista;

public class manejadorInscripciones {
    private List<Inscripcion> inscripciones;

    public manejadorInscripciones() {
        inscripciones = new ArrayList<>();
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public List<Inscripcion> buscarInscripcionesPorClase(Clase clase) {
        List<Inscripcion> resultado = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getClase().equals(clase)) {
                resultado.add(inscripcion);
            }
        }
        return resultado;
    }

    public List<Inscripcion> buscarInscripcionesPorDeportista(Deportista deportista) {
        List<Inscripcion> resultado = new ArrayList<>();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getDeportista().equals(deportista)) {
                resultado.add(inscripcion);
            }
        }
        return resultado;
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        inscripciones.remove(inscripcion);
    }

    public List<Inscripcion> obtenerTodasLasInscripciones() {
        return new ArrayList<>(inscripciones);
    }
}
