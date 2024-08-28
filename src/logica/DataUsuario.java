package logica;

import java.time.LocalDate;

public class DataUsuario {
	
	private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;

    public DataUsuario () {
    	this.setNickname(new String());
    	this.setNombre(new String());
    	this.setApellido(new String());
    	this.setEmail(new String());
    	//this.setFechaNacimiento(LocalDate());
    }
    
    public DataUsuario (String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento) {
    	this.setNickname(nickname);
    	this.setNombre(nombre);
    	this.setApellido(apellido);
    	this.setEmail(email);
    	this.setFechaNacimiento(fechaNacimiento);
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
}
