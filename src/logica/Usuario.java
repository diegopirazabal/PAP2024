package logica;
/**Representa a un usuario en el sistema con nombre, apellido y cedula de identidad. */
import java.time.LocalDate;

public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;

    public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

// Subclase Deportista
class Deportista extends Usuario {
    private boolean esProfesional;

    public Deportista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, boolean esProfesional) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.esProfesional = esProfesional;
    }

    public boolean esProfesional() {
        return esProfesional;
    }

    public void setProfesional(boolean esProfesional) {
        this.esProfesional = esProfesional;
    }
}

// Subclase Entrenador
class Entrenador extends Usuario {
    private String disciplina;
    private String linkSitioWeb;

    public Entrenador(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String disciplina, String linkSitioWeb) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.disciplina = disciplina;
        this.linkSitioWeb = linkSitioWeb;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getLinkSitioWeb() {
        return linkSitioWeb;
    }

    public void setLinkSitioWeb(String linkSitioWeb) {
        this.linkSitioWeb = linkSitioWeb;
    }
}
