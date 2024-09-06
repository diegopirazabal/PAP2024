package dtos;


public class dataTypeActividad {

    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion; // En minutos
    private double costo;
    private String lugar;
    private String fechaAlta;
    private String imagen;
    private String entrenadorNick; // Puedes almacenar solo el ID del entrenador si no necesitas toda la información del entrenador

    // Constructor sin argumentos
    public dataTypeActividad() {
    }

    // Constructor con todos los parámetros necesarios
    public dataTypeActividad(String nombre, String descripcion, int duracion, double costo, String lugar, String fechaAlta, String imagen, String entrenadorNick) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.lugar = lugar;
        this.fechaAlta = fechaAlta;
        this.imagen = imagen;
        this.entrenadorNick = entrenadorNick;
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

    public String getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(String fechaAlta) { this.fechaAlta = fechaAlta; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getEntrenadorId() { return entrenadorNick; }
    public void setEntrenadorId(String entrenadorNick) { this.entrenadorNick = entrenadorNick; }
}