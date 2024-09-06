package logica;

public class Actividad {
	private String nombre;
	private String descripcion;
	private int duracion;
	private String lugar;
	private double costo;
	private String fechaAlta;
	private String imagen;
	private String nomEntrenador;
	
	public Actividad(String nombre, String descripcion, int duracion, String lugar, double costo, String fechaAlta,
			String imagen, String nomEntrenador) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.lugar = lugar;
		this.costo = costo;
		this.fechaAlta = fechaAlta;
		this.imagen = imagen;
		this.nomEntrenador = nomEntrenador;
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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNomEntrenador() {
		return nomEntrenador;
	}

	public void setNomEntrenador(String nomEntrenador) {
		this.nomEntrenador = nomEntrenador;
	}
	
	
}
