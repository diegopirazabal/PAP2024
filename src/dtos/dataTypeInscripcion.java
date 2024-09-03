package dtos;

import java.time.LocalDate;

public class dataTypeInscripcion {
	 private LocalDate fechaInscripcion;
	 private int cantidadDeportistas;
	 private double costo;
	 
	 
	 public dataTypeInscripcion(LocalDate fechaInscripcion, int cantidadDeportistas, double costo) {
		this.fechaInscripcion = fechaInscripcion;
		this.cantidadDeportistas = cantidadDeportistas;
		this.costo = costo;
	}

	 
	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}


	public int getCantidadDeportistas() {
		return cantidadDeportistas;
	}


	public void setCantidadDeportistas(int cantidadDeportistas) {
		this.cantidadDeportistas = cantidadDeportistas;
	}


	public double getCosto() {
		return costo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}
	 
}
