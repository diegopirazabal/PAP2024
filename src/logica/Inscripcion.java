package logica;
<<<<<<< HEAD
import logica.Usuario;
<<<<<<< HEAD
=======
import logica.Usuario.Deportista;
import logica.Usuario.Entrenador;
=======
>>>>>>> refs/remotes/origin/PAP2024
>>>>>>> branch 'cantomauro' of https://github.com/diegopirazabal/PAP2024/
import java.time.LocalDate;
<<<<<<< HEAD
import jakarta.persistence.*;
=======
import javax.persistence.*;
>>>>>>> refs/remotes/origin/PAP2024

@Entity
@Table(name = "INSCRIPCIONES")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long id;

    @Column(name = "FechaInscripcion", nullable = false)
=======
    private int id;

    @Column(name = "Fecha", nullable = false)
>>>>>>> refs/remotes/origin/PAP2024
    private LocalDate fechaInscripcion;

    @Column(name = "CantidadDeportistas", nullable = false)
    private int cantidadDeportistas;

    @Column(name = "Costo", nullable = false)
    private double costo;
<<<<<<< HEAD
=======

    @ManyToOne
    private Clase clase; // Relación con la clase

    @ManyToOne
    private Deportista deportista; // Relación con el deportista
>>>>>>> refs/remotes/origin/PAP2024

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;
=======
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
>>>>>>> refs/remotes/origin/PAP2024

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "deportista_id")
    private Deportista deportista;

=======
    // Getters y Setters
>>>>>>> refs/remotes/origin/PAP2024
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