package logica;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLASES")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    
    @Column(name = "Fecha", nullable = false)
    private Date fecha;

    @Column(name = "Hora", nullable = false)
    private String hora;

    @Column(name = "Lugar", nullable = false, length = 100)
    private String lugar;

    private String imagen;

    @Column(name = "FechaAlta", nullable = false)
    private Date fechaAlta;

    @Column(name = "Cupo", nullable = false)
    private int cupo;

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inscripcion> inscripciones;


    public Clase() {};
    
    public Clase(Long id, String nombre, Date fecha, String hora, String lugar, String imagen, Date fechaAlta, int cupo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.imagen = imagen;
		this.fechaAlta = fechaAlta;
		this.cupo = cupo;
		//this.inscripciones = inscripciones;
	}


	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(Long id) {
		this.id = id;
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


	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}


	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}


	public boolean inscribirUsuario(Inscripcion inscripcion) {
        if (inscripciones.size() < cupo) {
            inscripciones.add(inscripcion);
            return true;
        } else {
            System.out.println("Cupo máximo alcanzado.");
            return false;
        }
    }
}