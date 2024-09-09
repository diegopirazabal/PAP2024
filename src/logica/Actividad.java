package logica;
import jakarta.persistence.*;
import logica.Usuario;
import logica.Clase;
import java.time.LocalDate;
import java.util.List;
import java.persistence.*;
import java.util.Date;

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
    private String estado; // Ej: Activa, Inactiva, etc. DEBERIA SER UN ENUM ?
    
    private String imagen; // URL o nombre de archivo de la imagen
    
    @ManyToOne
    private Entrenador entrenador; // Relación con el entrenador
    
    @OneToMany( targetEntity=Clase.class)
    private List<Clase> clases; // Relación con las clases
    

    public Actividad(){};
    
    public Actividad(String nombre, String descripcion, int duracion, double costo, String lugar, Date fechaAlta, String imagen, Entrenador entrenador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.lugar = lugar;
        this.fechaAlta = fechaAlta;
        this.imagen = imagen;
        this.entrenador = entrenador; // Establece el entrenador
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


	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}


	public enum estadoActividad {
        ACTIVA,
        INACTIVA,
        CANCELADA
    }
}
