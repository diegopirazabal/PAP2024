package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Entrenador;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorUsuario;

public class Principal {
	 private JFrame frmGestionDeUsuarios;    
	 private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
	 private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();

	 // Nuevas ventanas internas
	 private altaUsuario altUsrInternalFrame;
	 private ListarUsuarios listUsrInternalFrame;
	 private listarEntrenadores listEntrenadoresInternalFrame; // InternalFrame para listar entrenadores
	 private desplegarDatosUsuario despUsrInternalFrame;
	 private altaActividad altActInternalFrame;
	 private listarActividades consActInternalFrame;
	 private AltaClase altClaInternalFrame;
	 
	 
	 public static void main(String[] args) {
	    	System.out.print("Entre al main");
	        EventQueue.invokeLater(new Runnable() {  
	            public void run() {                 
	                try {
	                    Principal window = new Principal();   
	                    window.frmGestionDeUsuarios.setVisible(true); 
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	 }
	 
	 public Principal(){
		 initialize();
		 Fabrica fabrica = Fabrica.getInstance(); 
		 controlUsr = fabrica.getIControladorUsuario();
	     
	     altUsrInternalFrame = new altaUsuario(controlUsr);
	     altUsrInternalFrame.setLocation(30, 35);
	     altUsrInternalFrame.setVisible(false);
	     
	     consActInternalFrame = new listarActividades(controlAct);
	     consActInternalFrame.setLocation(30, 35);
	     consActInternalFrame.setVisible(false);
	     
	     listUsrInternalFrame = new ListarUsuarios(controlUsr);
	     listUsrInternalFrame.setLocation(30, 35);
	     listUsrInternalFrame.setVisible(false);
	     
	     listEntrenadoresInternalFrame = new listarEntrenadores(controlUsr); // Instancia de la nueva ventana para listar entrenadores
	     listEntrenadoresInternalFrame.setLocation(30, 35);
	     listEntrenadoresInternalFrame.setVisible(false);
	     
	     despUsrInternalFrame = new desplegarDatosUsuario(controlUsr);
	     despUsrInternalFrame.setLocation(30, 35);
	     despUsrInternalFrame.setVisible(false);
	     
		 altActInternalFrame = new altaActividad(controlAct, controlUsr); 
	     altActInternalFrame.setLocation(30, 35);
	     altActInternalFrame.setVisible(false);
	     
	     altClaInternalFrame = new AltaClase(); 
	     altClaInternalFrame.setLocation(30, 35);
	     altClaInternalFrame.setVisible(false);
	     
	     frmGestionDeUsuarios.getContentPane().add(altUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(listUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(listEntrenadoresInternalFrame); // Añadir a la ventana principal
	     frmGestionDeUsuarios.getContentPane().add(despUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(altActInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(consActInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(altClaInternalFrame);
	     
	 }
	 
	 private void initialize() {
		 frmGestionDeUsuarios = new JFrame();
	        frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
	        frmGestionDeUsuarios.setBounds(100, 100, 450, 400);
	        frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmGestionDeUsuarios.setResizable(false);
	        frmGestionDeUsuarios.setSize(800, 600);

	        JMenuBar menuBar = new JMenuBar();
	        frmGestionDeUsuarios.setJMenuBar(menuBar);

	        JMenu menuSistema = new JMenu("Sistema");
	        menuBar.add(menuSistema);

	        JMenuItem menuSalir = new JMenuItem("Salir");
	        menuSalir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                frmGestionDeUsuarios.setVisible(false);
	                frmGestionDeUsuarios.dispose();
	            }
	        });
	        menuSistema.add(menuSalir);

	        JMenu menuUsuarios = new JMenu("Usuarios");
	        menuBar.add(menuUsuarios);

	        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
	        menuItemRegistrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                altUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(menuItemRegistrar);
	        
	        JMenuItem mntmListaUsuarios = new JMenuItem("Consultar Usuarios");
	        mntmListaUsuarios.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	listUsrInternalFrame.cargarUsuarios();
	            	listUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(mntmListaUsuarios);
	        
//	        JMenuItem mntmConsultarUsuarios = new JMenuItem("Consultar Usuarios");
//	        mntmConsultarUsuarios.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	            	despUsrInternalFrame.setVisible(true);
//	            }
//	        });
//	        menuUsuarios.add(mntmConsultarUsuarios);
	        
	        // Añadir un nuevo ítem para listar entrenadores
	        JMenuItem mntmListarEntrenadores = new JMenuItem("Listar Entrenadores");
	        mntmListarEntrenadores.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	listEntrenadoresInternalFrame.cargarEntrenadores(); // Llamar la función para cargar entrenadores
	            	listEntrenadoresInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(mntmListarEntrenadores); // Agregar al menú

	        JMenu menuActividad = new JMenu("Actividad");
	        menuBar.add(menuActividad);
	        
	        JMenuItem mntmaltaActividad = new JMenuItem("Registrar Actividad");
	        mntmaltaActividad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	altActInternalFrame.setVisible(true);
	            }
	        });
	        menuActividad.add(mntmaltaActividad);
	        
	        JMenuItem mntmconsultaActividad = new JMenuItem("Consulta Actividad");
	        mntmconsultaActividad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	consActInternalFrame.setVisible(true);

	            }
	        });
	        menuActividad.add(mntmconsultaActividad);
	        
	        JMenu menuClase = new JMenu("Clase");
	        menuBar.add(menuClase);
	        
	        JMenuItem mntmaltaClase = new JMenuItem("Registrar Clase");
	        mntmaltaClase.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	altClaInternalFrame.setVisible(true);

	            }
	        });
	        menuClase.add(mntmaltaClase);
	    }
}