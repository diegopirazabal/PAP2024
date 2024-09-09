package dtos;

import java.util.Date;
import java.time.LocalDate;

public class dataTypeUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;
    private Boolean esEntrenador;

    public dataTypeUsuario(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, Boolean esEntrenador) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.esEntrenador = esEntrenador;
    }

    public Boolean getTipo() {
    	return esEntrenador;
    }
    
    public void setTipo(Boolean tipo) {
        this.esEntrenador = tipo;
    }
    
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
    
    @Override
    public String toString() {
        return nickname + " - " + nombre + " " + apellido; // Personaliza esto según lo que quieras mostrar
    }
}