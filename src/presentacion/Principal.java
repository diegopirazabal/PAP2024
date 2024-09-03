package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;

public class Principal extends JFrame {
	
	private JDesktopPane desktopPane;
    private altaUsuario frameAltaUsuario;
    //private JInternalFrame frameAltaUsuario;


	public Principal() {
		
        // Configurar el JFrame
        setTitle("Gestion de Usuarios 1.0");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // Crear el JDesktopPane
        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        desktopPane.setLayout(null);
        
        //INTERNAL FRAME ALTA DE USUARIO
        frameAltaUsuario = new altaUsuario(); //() puede ir controlador
        frameAltaUsuario.setBounds(10, 10, 750, 500);
        desktopPane.add(frameAltaUsuario);
        frameAltaUsuario.setVisible(false);
        
        
        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Crear el menú "Sistema"
        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);
        
        // Opción para salir del sistema
        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
                setVisible(false);
                dispose();
            }
        });
        menuSistema.add(menuSalir);
        
        
        //USUARIO
        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);
        
        //USUARIO ---- Alta usuario
        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frameAltaUsuario.setVisible(true);
            	   try {
                       frameAltaUsuario.setSelected(true);
                   } catch (java.beans.PropertyVetoException ex) {
                       ex.printStackTrace();
                   }
               
            }
        });
        menuUsuarios.add(menuItemRegistrar);
        
        //USUARIO----- Consultar usuario
        JMenuItem menuConsultarUsuario = new JMenuItem("Consultar usuario");
        menuUsuarios.add(menuConsultarUsuario);
        
        //USUARIO -------- Modificar usuario
        JMenuItem menuModificarUsuario = new JMenuItem("Modificar usuario");
        menuUsuarios.add(menuModificarUsuario);
       
        
        //ACTIVIDADES
        JMenu menuActividades = new JMenu ("Actividades");
        menuBar.add(menuActividades);
        
        //ACTIVIDADES---Alta actividad
        JMenuItem menuAltaActividad = new JMenuItem ("Alta actividad");
        menuActividades.add(menuAltaActividad);
        
        //ACTIVIDADES----Consulta actividad
        JMenuItem menuConsultaActividad = new JMenuItem ("Consulta actividad");
        menuActividades.add(menuConsultaActividad);

        //ACTIVIDADES-----Ranking actividades
        JMenuItem menuRankingActividad = new JMenuItem ("Ranking actividades");
        menuActividades.add(menuRankingActividad);
        
        
        
        // Configurar el layout y hacerlo visible
        getContentPane().setLayout(null);
        
        
        //INTERNAL FRAME ALTA DE USUARIO
    }
	
	
	public static void main(String[] args) {
    	System.out.print("Entre al main");
        EventQueue.invokeLater(new Runnable() {  // se utiliza para poner en cola una tarea */
            public void run() {                  // para ser ejecutada en el hilo de eventos EDT */
                try {
                	Principal principal = new Principal();   // Crea una instancia del objeto principal
                    principal.setVisible(true);  // Hacer visible la ventana principal
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

}
}