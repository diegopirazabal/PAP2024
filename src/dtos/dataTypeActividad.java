package dtos;
import java.time.LocalDate;
import logica.Actividad.estadoActividad;

public class dataTypeActividad {

    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion; // En minutos
    private double costo;
    private String lugar;
    private LocalDate fechaAlta;
    private estadoActividad estado;
    private String imagen;
    private Long entrenadorId; // Puedes almacenar solo el ID del entrenador si no necesitas toda la información del entrenador

    // Constructor sin argumentos
    public dataTypeActividad() {
    }

    // Constructor con todos los parámetros necesarios
    public dataTypeActividad(Long id, String nombre, String descripcion, int duracion, double costo, String lugar, LocalDate fechaAlta, estadoActividad estado, String imagen, Long entrenadorId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.lugar = lugar;
        this.fechaAlta = fechaAlta;
        this.estado = estado;
        this.imagen = imagen;
        this.entrenadorId = entrenadorId;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public LocalDate getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(LocalDate fechaAlta) { this.fechaAlta = fechaAlta; }

    public estadoActividad getEstado() { return estado; }
    public void setEstado(estadoActividad estado) { this.estado = estado; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public Long getEntrenadorId() { return entrenadorId; }
    public void setEntrenadorId(Long entrenadorId) { this.entrenadorId = entrenadorId; }
}