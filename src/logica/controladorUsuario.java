package logica;
import logica.Usuario;
import persistencia.Persistencia;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import excepciones.*;
import dtos.*;

public class controladorUsuario {
    private manejadorUsuarios manejador;

    public controladorUsuario() {
        manejador = new manejadorUsuarios();
    }

    public void crearDeportista(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String contrasena, boolean esProfesional) throws UsuarioRepetidoException {
        Deportista deportista = new Deportista (nickname, nombre, apellido, email, fechaNacimiento, contrasena, esProfesional);
       
        manejador.agregar(deportista);
    }

    public void crearEntrenador(String nickname, String nombre, String apellido, String email, String fechaNacimiento, String contrasena, String disciplina, String linkSitioWeb) throws UsuarioRepetidoException {
    	Entrenador entrenador = new Entrenador(nickname, nombre, apellido, email, fechaNacimiento, contrasena, disciplina, linkSitioWeb);
    	manejador.agregar(entrenador);    	
    }
    
    	public Usuario consultarUsuario(String nickname) throws UsuarioNoExisteException {
        return manejador.buscarUsuario(nickname);
    }

    public void eliminarUsuario(String nickname) throws UsuarioNoExisteException{
    	 manejador.eliminar(nickname);
    }

//    public List<dataTypeUsuario> obtenerTodos() {
//        try {
//            List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
//            return usuarios.stream()
//                    .map(usuario -> new dataTypeUsuario(
//                            usuario.getNickname(),
//                            usuario.getNombre(),
//                            usuario.getApellido(),
//                            usuario.getEmail(),
//                            usuario.getFechaNacimiento()))
//                    .collect(Collectors.toList());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
}
/*
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("airelibre.uy");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    //tx.begin();
    //em.persist(usu);
    //tx.commit();
    //em.close();
    //emf.close();
*/