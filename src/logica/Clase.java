package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "CLASES")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Hora", nullable = false)
    private LocalTime hora;

    @Column(name = "Lugar", nullable = false, length = 100)
    private String lugar;

    private String imagen;

    @Column(name = "FechaAlta", nullable = false)
    private LocalDate fechaAlta;

    @Column(name = "Cupo", nullable = false)
    private int cupo;

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inscripcion> inscripciones;


    
    
    public Clase(LocalDate fecha, LocalTime hora, String lugar, String imagen, LocalDate fechaAlta, int cupo) {
		super();
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


	public void setId(Long id) {
		this.id = id;
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