package logica;
import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPORTISTAS")
class Deportista extends Usuario {
    @Column (name = "Profesional", nullable = false)
    private boolean esProfesional;

    public Deportista() {};
    
    public Deportista(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String contrasena, boolean esProfesional) {
        super(nickname, nombre, apellido, email, fechaNacimiento, contrasena);
        this.esProfesional = esProfesional;
    }

    public boolean esProfesional() {
        return esProfesional;
    }

    public void setProfesional(boolean esProfesional) {
        this.esProfesional = esProfesional;
    }
}