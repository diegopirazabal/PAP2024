package logica;
import logica.Usuario;
import logica.Usuario.Deportista;
import logica.Usuario.Entrenador;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "INSCRIPCIONES")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FechaInscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "CantidadDeportistas", nullable = false)
    private int cantidadDeportistas;

    @Column(name = "Costo", nullable = false)
    private double costo;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

    @ManyToOne
    @JoinColumn(name = "deportista_id")
    private Deportista deportista;

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

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }
}