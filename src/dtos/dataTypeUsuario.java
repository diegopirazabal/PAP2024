package dtos;

import java.time.LocalDate;

public class dataTypeUsuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private String fechaNacimiento;
    private Boolean esEntrenador;

    public dataTypeUsuario(String nickname, String nombre, String apellido, String email, String fechaNacimiento, boolean esEntrenador) {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String toString() {
		 return getNickname() + " (" + getNombre() + " " + getApellido() + ")";
	 }

	public Boolean getEsEntrenador() {
		return esEntrenador;
	}

	public void setEsEntrenador(Boolean esEntrenador) {
		this.esEntrenador = esEntrenador;
	}
    
    
}