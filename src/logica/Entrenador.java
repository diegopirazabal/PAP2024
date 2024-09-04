package logica;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTRENADORES")
class Entrenador extends Usuario {
    @Column (name = "Disciplina", nullable = false, length = 50)
    private String disciplina;
    
    @Column (name = "URL", nullable = false, length = 75)
    private String linkSitioWeb;
    
    @OneToMany(targetEntity=Usuario.class) //  @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY) segun chatgpt)
    private List<Actividad> actividades;
    
    public Entrenador() {};
    
    public Entrenador(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String contrasena, String disciplina, String linkSitioWeb) {
        super(nickname, nombre, apellido, email, fechaNacimiento, contrasena);
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