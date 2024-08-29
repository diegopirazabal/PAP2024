package logica;
import Actividad.java; // ??? dxxd
import java.util.\*;
/**Representa a un usuario en el sistema con nombre, apellido y cedula de identidad. */
import java.time.LocalDate;

//Imports para persistencia, los saqué de google ni idea si son todos necesarios lol
package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
@Table(name = Usuarios)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  //no se si va todo esto xd "unique = true" ? no se si se crea la tabla o hay que poner el @column tambn
    private String nickname;
    
    @Column (name = Nombre, nullable = false, length = 50) 
    private String nombre;
    
    @Column (name = Apellido, nullable = false, length = 50)
    private String apellido;
    
    @Column (name = Email, nullable = false, length = 50)
    private String email;
    
    @Column (name = fechaNac, nullable = false)
    private LocalDate fechaNacimiento;
    
    @Column (name = Contrasena, nullable = false, length = 20)
    private String contrasena;
};
    
public Usuario(){};
    
public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena) {
    this.nickname = nickname;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.fechaNacimiento = fechaNacimiento;
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

public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
}

public void setContrasena(String contrasena){
    this.contrasena = contrasena;
}

public String getContrasena(){
    return contrasena;
}

// Subclase Deportista
@Entity
class Deportista extends Usuario {
    @Column (name = Profesional, nullable = false)
    private boolean esProfesional;

    public Deportista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, boolean esProfesional) {
        super(nickname, nombre, apellido, email, fechaNacimiento, contrasena);
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
    @Column (name = Disciplina, nullable = false, length = 50)
    private String disciplina;
    
    @Column (name = URL, nullable = false, length = 75)
    private String linkSitioWeb;
    
    @OneToMany(targetEntity=Usuario.class)
    private List<Actividad> actividades;
    
    public Entrenador(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contrasena, String disciplina, String linkSitioWeb) {
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
