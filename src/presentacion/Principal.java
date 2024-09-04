//package presentacion;
//
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JInternalFrame;
//import javax.swing.JDesktopPane;
//
//public class Principal extends JFrame {
//	
//	private JDesktopPane desktopPane;
//    private altaUsuario frameAltaUsuario;
//    private ListarUsuarios frameListarUsuarios;
//    private ModificarUsuario frameModificarUsuario;
//    //private JInternalFrame frameAltaUsuario;
//
//
//	public Principal() {
//		
//        // Configurar el JFrame
//        setTitle("Gestion de Usuarios 1.0");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        // Crear el JDesktopPane
//        desktopPane = new JDesktopPane();
//        setContentPane(desktopPane);
//        desktopPane.setLayout(null);
//        
//        //INTERNAL FRAME ALTA DE USUARIO
//        frameAltaUsuario = new altaUsuario(); //() puede ir controlador
//        frameAltaUsuario.setBounds(10, 10, 750, 500);
//        desktopPane.add(frameAltaUsuario);
//        frameAltaUsuario.setVisible(false);
//        //INTERNAL FRAME CONSULTAR USUARIOS
//        frameListarUsuarios = new ListarUsuarios(); //() puede ir controlador
//        frameListarUsuarios.setBounds(10, 10, 750, 500);
//        desktopPane.add(frameListarUsuarios);
//        frameListarUsuarios.setVisible(false);
//        //INTERNAL FRAME MODIFICAR USUARIOS
//        frameModificarUsuario = new ModificarUsuario(); //() puede ir controlador
//        frameModificarUsuario.setBounds(10, 10, 750, 500);
//        desktopPane.add(frameModificarUsuario);
//        frameModificarUsuario.setVisible(false);
//        
//        
//        // Crear la barra de menú
//        JMenuBar menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//        
//        // Crear el menú "Sistema"
//        JMenu menuSistema = new JMenu("Sistema");
//        menuBar.add(menuSistema);
//        
//        // Opción para salir del sistema
//        JMenuItem menuSalir = new JMenuItem("Salir");
//        menuSalir.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                // Salgo de la aplicación
//                setVisible(false);
//                dispose();
//            }
//        });
//        menuSistema.add(menuSalir);
//        
//   
//        //USUARIO
//        JMenu menuUsuarios = new JMenu("Usuarios");
//        menuBar.add(menuUsuarios);
//        
//        //USUARIO ---- Alta usuario
//        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
//        menuItemRegistrar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	frameAltaUsuario.setVisible(true);
//            	   try {
//                       frameAltaUsuario.setSelected(true);
//                   } catch (java.beans.PropertyVetoException ex) {
//                       ex.printStackTrace();
//                   }
//               
//            }
//        });
//        menuUsuarios.add(menuItemRegistrar);
//        
//        //USUARIO----- Consultar usuario
//        JMenuItem menuConsultarUsuario = new JMenuItem("Listar usuarios");
//        menuConsultarUsuario.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	frameListarUsuarios.setVisible(true);
//            	   try {
//            		   frameListarUsuarios.setSelected(true);
//                   } catch (java.beans.PropertyVetoException ex) {
//                       ex.printStackTrace();
//                   }
//               
//            }
//        });
//        menuUsuarios.add(menuConsultarUsuario);
//        
//        //USUARIO -------- Modificar usuario
//        JMenuItem menuModificarUsuario = new JMenuItem("Modificar usuario");
//        menuModificarUsuario.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	frameModificarUsuario.setVisible(true);
//            	   try {
//            		   frameModificarUsuario.setSelected(true);
//                   } catch (java.beans.PropertyVetoException ex) {
//                       ex.printStackTrace();
//                   }
//               
//            }
//        });
//        menuUsuarios.add(menuModificarUsuario);
//       
//        
//        //ACTIVIDADES
//        JMenu menuActividades = new JMenu ("Actividades");
//        menuBar.add(menuActividades);
//        
//        //ACTIVIDADES---Alta actividad
//        JMenuItem menuAltaActividad = new JMenuItem ("Alta actividad");
//        menuActividades.add(menuAltaActividad);
//        
//        //ACTIVIDADES----Consulta actividad
//        JMenuItem menuConsultaActividad = new JMenuItem ("Consulta actividad");
//        menuActividades.add(menuConsultaActividad);
//
//        //ACTIVIDADES-----Ranking actividades
//        JMenuItem menuRankingActividad = new JMenuItem ("Ranking actividades");
//        menuActividades.add(menuRankingActividad);
//        
//        //CLASE
//        JMenu menuClase = new JMenu ("Clase");
//        menuBar.add(menuClase);
//        
//        //CLASE---Alta clase
//        JMenuItem menuAltaClase = new JMenuItem ("Alta clase");
//        menuClase.add(menuAltaClase);
//        
//        //ACTIVIDADES----Consulta actividad
//        JMenuItem menuConsultaClase = new JMenuItem ("Consulta clase");
//        menuClase.add(menuConsultaClase);
//
//        //ACTIVIDADES-----Ranking actividades
//        JMenuItem menuInscripcionClase = new JMenuItem ("Inscripcion clase");
//        menuClase.add(menuInscripcionClase);
//        
//        // Configurar el layout y hacerlo visible
//        getContentPane().setLayout(null);
//	}
//	
//	public static void main(String[] args) {
//    	System.out.print("Entre al main");
//        EventQueue.invokeLater(new Runnable() {  // se utiliza para poner en cola una tarea */
//            public void run() {                  // para ser ejecutada en el hilo de eventos EDT */
//                try {
//                	Principal principal = new Principal();   // Crea una instancia del objeto principal
//                    principal.setVisible(true);  // Hacer visible la ventana principal
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//	}
//}





// src/presentacion/Principal.java
package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.*;

public class Principal {
    private IControladorUsuario ICU;
    private JFrame frmGestionDeUsuarios;  
    private CrearUsuario creUsrInternalFrame;  // Frame interno para dar de alta usuario
    private ConsultarUsuario conUsrInternalFrame; // Frame interno para consultar por usuario
    private ListarUsuarios lisUsrInternalFrame;    // Frame interno para listar usuario 

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
    
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
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
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemVerInfo = new JMenuItem("Ver Informacion");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
                conUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem mntmListaUsuarios = new JMenuItem("ListarUsuarios");
        mntmListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista
                lisUsrInternalFrame.cargarUsuarios();
                lisUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmListaUsuarios);
    }
    
public Principal() {   // Constructor de la clase
    initialize();     // Inicializa la interface

    // Inicializacion
    Fabrica fabrica = Fabrica.getInstance();  // Se crea una instancia unica de fabrica, se guarda en la varible fabrica
    ICU = fabrica.getIControladorUsuario();   // Se devuelve una instancia unica controlador de usuario
    
    // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
    // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
    // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
    creUsrInternalFrame = new CrearUsuario(ICU);
    creUsrInternalFrame.setLocation(30, 35);
    creUsrInternalFrame.setVisible(false);

    conUsrInternalFrame = new ConsultarUsuario(ICU);
    conUsrInternalFrame.setLocation(62, 11);
    conUsrInternalFrame.setVisible(false);

    lisUsrInternalFrame = new ListarUsuarios();
    lisUsrInternalFrame.setVisible(false);
    frmGestionDeUsuarios.getContentPane().setLayout(null);

    frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame); /*Agrego los 3 internos al principal */
    frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
    frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
}
}
