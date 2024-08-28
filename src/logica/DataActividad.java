package logica;

import java.time.LocalDate;

public class DataActividad {
    private String nombre;
    private String descripcion;
    private int duracion; // En minutos
    private double costo;
    private String lugar;
    private LocalDate fechaAlta;
    private String estado; // Ej: Activa, Inactiva, etc.
    private String imagen; // URL o nombre de archivo de la imagen
	
    
    public DataActividad(String nombre, String descripcion, int duracion, double costo, String lugar,
			LocalDate fechaAlta, String estado, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.lugar = lugar;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		this.imagen = imagen;
	}
    
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
    
    
    
    
}

