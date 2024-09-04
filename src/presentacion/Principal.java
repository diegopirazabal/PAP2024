package presentacion;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Fabrica;
import logica.IControladorUsuario;

public class Principal {
    private IControladorUsuario ICU;
    private JFrame frmGestionDeUsuarios;  
    private CrearUsuario creUsrInternalFrame;  // Frame interno para dar de alta usuario
    private ConsultarUsuario conUsrInternalFrame; // Frame interno para consultar por usuario
    private ListarUsuarios lisUsrInternalFrame;    // Frame interno para listar usuarios 

    public static void main(String[] args) {
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
        frmGestionDeUsuarios = new JFrame();
        frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
        frmGestionDeUsuarios.setBounds(100, 100, 800, 600);  // Ajusta el tamaño según sea necesario
        frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem menuItemVerInfo = new JMenuItem("Ver Informacion");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem mntmListaUsuarios = new JMenuItem("ListarUsuarios");
        mntmListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisUsrInternalFrame.cargarUsuarios();
                lisUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmListaUsuarios);
    }
    
    public Principal() {   // Constructor de la clase
        initialize();     // Inicializa la interfaz

        // Inicialización del controlador de usuarios
        Fabrica fabrica = Fabrica.getInstance();  // Se crea una instancia única de fábrica
        ICU = fabrica.getIControladorUsuario();   // Se devuelve una instancia única del controlador de usuarios

        // Se crean los InternalFrames y se incluyen al Frame principal
        creUsrInternalFrame = new CrearUsuario(ICU);
        creUsrInternalFrame.setLocation(30, 35);
        creUsrInternalFrame.setVisible(false);

        conUsrInternalFrame = new ConsultarUsuario(ICU);
        conUsrInternalFrame.setLocation(62, 11);
        conUsrInternalFrame.setVisible(false);

        lisUsrInternalFrame = new ListarUsuarios(ICU);  // Pasar el controlador al ListarUsuarios
        lisUsrInternalFrame.setLocation(30, 35);  // Ajusta la posición según sea necesario
        lisUsrInternalFrame.setVisible(false);
        
        frmGestionDeUsuarios.getContentPane().setLayout(null);
        frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame); /* Agrega los InternalFrames al principal */
        frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
    }
}
