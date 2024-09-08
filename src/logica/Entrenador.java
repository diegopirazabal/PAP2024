package logica;

import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("ENTRENADOR")
@Table(name = "ENTRENADORES")
public class Entrenador extends Usuario {
    @Column (name = "Disciplina", nullable = true, length = 50)
    private String disciplina;
    
    @Column (name = "URL", nullable = true, length = 75)
    private String linkSitioWeb;
    
    @OneToMany(targetEntity=Actividad.class) //  @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.LAZY) segun chatgpt)
    private List<Actividad> actividades;
    
    private Boolean esEntrenador = true;
    public Entrenador() {};
    
    public Entrenador(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, char[] contrasena, String disciplina, String linkSitioWeb) {
        super(nickname, nombre, apellido, email, fechaNacimiento, esEntrenador, contrasena);
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

	protected Boolean getTipo() {
		return this.esEntrenador;
	}
}