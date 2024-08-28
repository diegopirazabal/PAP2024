package logica;

import java.time.LocalDate;

public class DataUsuario {
	
	private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private String contrasena;

    public DataUsuario () {}

	public DataUsuario (String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena) {
    	this.setNickname(nickname);
    	this.setNombre(nombre);
    	this.setApellido(apellido);
    	this.setEmail(email);
    	this.setFechaNacimiento(fechaNacimiento);
    	this.setContrasena(contrasena);
    }
    
    //Getters
    public String getNickname() {
    	return nickname;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }
    
    public LocalDate getFechaNacimiento() {
    	return fechaNacimiento;
    }
    
    public String getConstrasena() {
    	return contrasena;
    }
    
    //Setters
    
   public void setNickname(String nickname) {
	   this.nickname = nickname;
   }
   
   public void setNombre(String nombre) {
	   this.nombre = nombre;
   }
   
   public void setApellido(String apellido) {
	   this.apellido = apellido;
   }
   
   public void setEmail (String email) {
	   this.email = email;
   }
   
   public void setFechaNacimiento(LocalDate fechaNacimiento) {
	   this.fechaNacimiento = fechaNacimiento;
   }
   
   public void setContrasena(String contrasena) {
	   this.contrasena = contrasena;
   }
}
