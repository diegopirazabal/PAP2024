package logica;

import java.time.LocalDate;

public class DataInscripcion {
	 private LocalDate fechaInscripcion;
	 private int cantidadDeportistas;
	 private double costo;
	 
	 
	 public DataInscripcion(LocalDate fechaInscripcion, int cantidadDeportistas, double costo) {
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
