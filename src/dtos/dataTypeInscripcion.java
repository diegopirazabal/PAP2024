package dtos;

import java.time.LocalDate;
import java.util.Date;

public class dataTypeInscripcion {
	 private Date fechaInscripcion;
	 private int cantidadDeportistas;
	 private double costo;
	 
	 
	 public dataTypeInscripcion(Date fechaInscripcion, int cantidadDeportistas, double costo) {
		this.fechaInscripcion = fechaInscripcion;
		this.cantidadDeportistas = cantidadDeportistas;
		this.costo = costo;
	}

	 
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(Date fechaInscripcion) {
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
