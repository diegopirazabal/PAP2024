package logica;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

//Imports para persistencia, los saqué de google ni idea si son todos necesarios lol
import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Tipo_Usuario", discriminatorType = DiscriminatorType.STRING)
@Table(name = "USUARIOS")
public abstract class Usuario {
    @Id
    private String nickname;
    
    @Column (name = "Nombre", nullable = false, length = 50) 
    private String nombre;
    
    @Column (name = "Apellido", nullable = false, length = 50)
    private String apellido;
    
    @Column (name = "Email", nullable = false, length = 50)
    private String email;
    
    @Column (name = "fechaNac", nullable = false)
    private Date fechaNacimiento;
    
    @Column (name = "Contrasena", nullable = false, length = 20)
    private char[] contrasena;
    
    @Column (name = "Entrenador", nullable = false)
	protected Boolean esEntrenador;
;
    
public Usuario(){};

public Usuario(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador, char[] contrasena) {
    this.nickname = nickname;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.fechaNacimiento = fechaNacimiento;
    this.contrasena = contrasena;
    this.esEntrenador = esEntrenador;
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
	
	public Date getFNacimiento() {
	    return fechaNacimiento;
	}
	
	public void setFNacimiento(Date fechaNacimiento) {
	    this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setContrasena(char[] contrasena){
	    this.contrasena = contrasena;
	}
	
	public char[] getContrasena(){
	    return contrasena;
	}

	protected abstract Boolean getTipo();
}