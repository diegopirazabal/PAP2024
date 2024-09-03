package logica;

import java.time.LocalDate;

import logica.Usuario.Deportista;

public class Inscripcion {
    private LocalDate fechaInscripcion;
    private int cantidadDeportistas;
    private double costo;
    private Clase clase; // Relación con la clase
    private Deportista deportista; // Relación con el deportista

    public Inscripcion(LocalDate fechaInscripcion, int cantidadDeportistas, double costo, Clase clase, Deportista deportista) {
        this.fechaInscripcion = fechaInscripcion;
        this.cantidadDeportistas = cantidadDeportistas;
        this.costo = costo;
        this.clase = clase;
        this.deportista = deportista;
    }

    // Getters y Setters

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
