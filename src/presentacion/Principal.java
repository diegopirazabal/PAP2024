package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;
import logica.IControladorUsuario;
import logica.IControladorActividad;

public class Principal {
	 private JFrame frmGestionDeUsuarios;    
	 private IControladorUsuario ICU;
	 private IControladorActividad ICA;
	 private altaUsuario altUsrInternalFrame;
	 private ListarUsuarios listUsrInternalFrame;
	 private DesplegarDatosUsuario despUsrInternalFrame;
	 private altaActividad altActInternalFrame;
	 
	 
	 public static void main(String[] args) {
	    	System.out.print("Entre al main");
	        EventQueue.invokeLater(new Runnable() {  /* se utiliza para poner en cola una tarea */
	            public void run() {                  /* para ser ejecutada en el hilo de eventos EDT */
	                try {
	                    Principal window = new Principal();   // Crea una instancia del objeto principal
	                    window.frmGestionDeUsuarios.setVisible(true); // Pone la ventana visible
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	 }
	 
	 public Principal(){
		 initialize();
		 Fabrica fabrica = Fabrica.getInstance();  // Se crea una instancia unica de fabrica, se guarda en la varible fabrica
	     ICU = fabrica.getIControladorUsuario();
	     ICA = fabrica.getIControladorActividad();
	     
	     altUsrInternalFrame = new altaUsuario(ICU);
	     altUsrInternalFrame.setLocation(30, 35);
	     altUsrInternalFrame.setVisible(false);
	     
	     listUsrInternalFrame = new ListarUsuarios(ICU);
	     listUsrInternalFrame.setLocation(30, 35);
	     listUsrInternalFrame.setVisible(false);
	     
	     despUsrInternalFrame = new DesplegarDatosUsuario(ICU);
	     despUsrInternalFrame.setLocation(30, 35);
	     despUsrInternalFrame.setVisible(false);
	     
	     altActInternalFrame = new altaActividad(ICA, ICU); //crear controlador de actividad y pasale el icont
	     altActInternalFrame.setLocation(30, 35);
	     altActInternalFrame.setVisible(false);
	     
	     frmGestionDeUsuarios.getContentPane().add(altUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(listUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(despUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(altActInternalFrame);
	     
	 }
	 
	 private void initialize() {
		 frmGestionDeUsuarios = new JFrame();
	        frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
	        frmGestionDeUsuarios.setBounds(100, 100, 450, 400);
	        frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
	        // Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un 
	        // evento asociado que permite realizar una acción una vez se seleccionan. 
	        JMenuBar menuBar = new JMenuBar();
	        frmGestionDeUsuarios.setJMenuBar(menuBar);

	        JMenu menuSistema = new JMenu("Sistema");
	        menuBar.add(menuSistema);

	        JMenuItem menuSalir = new JMenuItem("Salir");
	        menuSalir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                // Salgo de la aplicacion
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
	                // Muestro el InternalFrame para registrar un usuario
	                altUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(menuItemRegistrar);
	        
	        JMenuItem mntmListaUsuarios = new JMenuItem("Listar Usuarios");
	        mntmListaUsuarios.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Muestro el InternalFrame para ver la lista de todos los usuarios,
	                // cargando previamente la lista
	            	listUsrInternalFrame.cargarUsuarios();
	            	listUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(mntmListaUsuarios);
	        
	        
	        JMenuItem mntmConsultarUsuarios = new JMenuItem("Consultar Usuarios");
	        mntmConsultarUsuarios.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Muestro el InternalFrame para ver la lista de todos los usuarios,
	                // cargando previamente la lista
	            	//listUsrInternalFrame.cargarUsuarios();
	            	
	            	despUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(mntmConsultarUsuarios);
	        
	        JMenu menuActividad = new JMenu("Actividad");
	        menuBar.add(menuActividad);
	        
	        JMenuItem mntmaltaActividad = new JMenuItem("Registrar Actividad");
	        mntmaltaActividad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Muestro el InternalFrame para ver la lista de todos los usuarios,
	                // cargando previamente la lista
	            	altActInternalFrame.cargarUsuarios();
	            	altActInternalFrame.setVisible(true);
	            }
	        });
	        menuActividad.add(mntmaltaActividad);
	        
	        JMenu menuClase = new JMenu("Clase");
	        menuBar.add(menuClase);
	    }
	 }


