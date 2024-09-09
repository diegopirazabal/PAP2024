package dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import logica.Inscripcion;

public class dataTypeClase {
    
	private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String imagen; // URL o nombre de archivo de la imagen
    private LocalDate fechaAlta;
    private int cupo;
    
   	
    public dataTypeClase(){}
    
    public dataTypeClase(LocalDate fecha, LocalTime hora, String lugar, String imagen, LocalDate fechaAlta, int cupo){
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.imagen = imagen;
		this.fechaAlta = fechaAlta;
		this.cupo = cupo;
	 }


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
    
}

