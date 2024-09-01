package logica;
<<<<<<< HEAD
import java.time.LocalDate;
import javax.persistence.*;
=======
import logica.Usuario;
import logica.Usuario.Deportista;
import logica.Usuario.Entrenador;
import java.time.LocalDate;
import jakarta.persistence.*;
>>>>>>> cantomauro

@Entity
@Table(name = "INSCRIPCIONES")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int id;

    @Column(name = "Fecha", nullable = false)
=======
    private Long id;

    @Column(name = "FechaInscripcion", nullable = false)
>>>>>>> cantomauro
    private LocalDate fechaInscripcion;

    @Column(name = "CantidadDeportistas", nullable = false)
    private int cantidadDeportistas;

    @Column(name = "Costo", nullable = false)
    private double costo;
<<<<<<< HEAD

    @ManyToOne
    private Clase clase; // Relación con la clase

    @ManyToOne
    private Deportista deportista; // Relación con el deportista

    // Constructor sin parámetros
    public Inscripcion() {}

    // Constructor con parámetros
    public Inscripcion(LocalDate fechaInscripcion, int cantidadDeportistas, double costo, Clase clase, Deportista deportista) {
        this.fechaInscripcion = fechaInscripcion;
        this.cantidadDeportistas = cantidadDeportistas;
        this.costo = costo;
        this.clase = clase;
        this.deportista = deportista;
    }

    // Getters y Setters
=======

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

    @ManyToOne
    @JoinColumn(name = "deportista_id")
    private Deportista deportista;

>>>>>>> cantomauro
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