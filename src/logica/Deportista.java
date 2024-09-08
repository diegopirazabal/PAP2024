package logica;

import java.util.Date;

import com.toedter.calendar.JDateChooser;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("DEPORTISTA")
@Table(name = "DEPORTISTAS")
public class Deportista extends Usuario {
	@Column(name = "DISCIPLINA", nullable = true)
	private String disciplina;

	@Column (name = "PROFESIONAL", nullable = true)
    private boolean esProfesional;

    public Deportista() {};
    
    public Deportista(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador,  char[] contrasena, boolean esProfesional) {
        super(nickname, nombre, apellido, email, (Date) fechaNacimiento, esEntrenador, contrasena);
        this.esProfesional = esProfesional;
    }

    public boolean esProfesional() {
        return esProfesional;
    }

    public void setProfesional(boolean esProfesional) {
        this.esProfesional = esProfesional;
    }

	protected Boolean getTipo() {
		return this.esEntrenador;
	}
}