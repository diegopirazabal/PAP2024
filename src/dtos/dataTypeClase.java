package dtos;

import java.util.Date;
import java.time.LocalTime;

public class dataTypeClase {
    
	private Date fecha;
    private String hora;
    private String lugar;
    private String imagen; // URL o nombre de archivo de la imagen
    private Date fechaAlta;
    private String nombre;
    private int cupo;
    
   	
    public dataTypeClase(){}
    
    public dataTypeClase(Date date, String nombre, String hora, String lugar, String imagen, Date date2, int cupo){
		super();
		this.fecha = date;
		this.nombre = nombre;
		this.hora = hora;
		this.lugar = lugar;
		this.imagen = imagen;
		this.fechaAlta = date2;
		this.cupo = cupo;
	 }


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setHora(String hora) {
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
    @Override
	public String toString() {
        return nombre; // Personaliza esto según lo que quieras mostrar
    }
	
}

