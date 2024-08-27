package logica;

import java.time.LocalDate;
import java.util.List;

public class Actividad {
    private String nombre;
    private String descripcion;
    private int duracion; // En minutos
    private double costo;
    private String lugar;
    private LocalDate fechaAlta;
    private String estado; // Ej: Activa, Inactiva, etc.
    private String imagen; // URL o nombre de archivo de la imagen
    private Entrenador entrenador; // Relación con el entrenador
    private List<Clase> clases; // Relación con las clases
    public Actividad(String nombre, String descripcion, int duracion, double costo, String lugar, LocalDate fechaAlta, String estado, String imagen, Entrenador entrenador, List<Clase> clases) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.lugar = lugar;
        this.fechaAlta = fechaAlta;
        this.estado = estado;
        this.imagen = imagen;
        this.entrenador = entrenador;
        this.clases = clases;
    }
HOLAAAAAASDSADSADAS
    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
}

