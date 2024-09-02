package logica;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//Imports para persistencia, los saqué de google ni idea si son todos necesarios lol
import jakarta.persistence.*;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
    private String fechaNacimiento;
    
    @Column (name = "Contrasena", nullable = false, length = 20)
    private String contrasena;

    public Usuario(){}
    
public Usuario(String nickname, String nombre, String apellido, String email, String fechaNacimiento2, String contrasena) {
    this.nickname = nickname;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.fechaNacimiento = fechaNacimiento2;
    this.contrasena = contrasena;
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

public String getFechaNacimiento() {
    return fechaNacimiento;
}

public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
}

public void setContrasena(String contrasena){
    this.contrasena = contrasena;
}

public String getContrasena(){
    return contrasena;
}
}