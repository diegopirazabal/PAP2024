package logica;

import java.time.LocalDate;

@Entity
@Table(name = "DEPORTISTAS")
class Deportista extends Usuario {
    @Column (name = "Profesional", nullable = false)
    private boolean esProfesional;

    public Deportista() {};
    
    public Deportista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, boolean esProfesional) {
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

