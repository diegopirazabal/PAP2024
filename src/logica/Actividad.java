package logica;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACTIVIDADES")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = true, length = 50)
    private String nombre;

    @Column(name = "Descripcion", nullable = true, length = 50)
    private String descripcion;

    @Column(name = "Duracion", nullable = true)
    private int duracion; // En minutos

    @Column(name = "Costo")
    private double costo;

    @Column(name = "Lugar", length = 50)
    private String lugar;

    @Column(name = "FechaAlta")
    private Date fechaAlta;

    @Column (name = "Estado", nullable = true)
    private String estado;
    
    private String imagen;
    
    @ManyToOne
    private Entrenador entrenador;
    
    @OneToMany( targetEntity=Clase.class)
    private List<Clase> clases = new ArrayList<>();
    

    public Actividad(){};
    
    public Actividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, Entrenador entrenador) {
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


//	public estadoActividad getEstado() {
//		return estado;
//	}
//
//
//	public void setEstado(estadoActividad estado) {
//		this.estado = estado;
//	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Entrenador getEntrenador() {
		return entrenador;
	}


	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}


	public List<Clase> getClases() {
		return clases;
	}


	public void setClases(Clase clase) {
		this.clases.add(clase);
	}


	public enum estadoActividad {
        ACTIVA,
        INACTIVA,
        CANCELADA
    }
}
