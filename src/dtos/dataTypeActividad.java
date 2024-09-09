package dtos;
import java.util.Date;
import java.time.LocalDate;

import logica.Entrenador;

public class dataTypeActividad {

    private Long id;
    private String nombre;
    private String descripcion;
    private int duracion; // En minutos
    private double costo;
    private String lugar;
    private Date fechaAlta;
    private String imagen;
    private Entrenador entrenador; // Puedes almacenar solo el ID del entrenador si no necesitas toda la información del entrenador

    public dataTypeActividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, Entrenador entrenador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.lugar = lugar;
        this.fechaAlta = fechaAlta;
        this.imagen = imagen;
        this.entrenador = entrenador;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Entrenador getEntrenadorId() {
		return entrenador;
	}

	public void setEntrenadorId(Entrenador entrenadorId) {
		this.entrenador = entrenadorId;
	}

 
}