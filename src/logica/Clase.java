package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Clase {
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String imagen; // URL o nombre de archivo de la imagen
    private LocalDate fechaAlta;
    private int cupo;
    private List<Inscripcion> inscripciones; // Relación con las inscripciones

    public Clase(LocalDate fecha, LocalTime hora, String lugar, String imagen, LocalDate fechaAlta, int cupo, List<Inscripcion> inscripciones) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.imagen = imagen;
        this.fechaAlta = fechaAlta;
        this.cupo = cupo;
        this.inscripciones = inscripciones;
    }

    // Getters y Setters

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    // Método para inscribir a un usuario
    public boolean inscribirUsuario(Inscripcion inscripcion) {
        if (inscripciones.size() < cupo) {
            inscripciones.add(inscripcion);
            return true;
        } else {
            System.out.println("Cupo máximo alcanzado.");
            return false;
        }
    }
}
