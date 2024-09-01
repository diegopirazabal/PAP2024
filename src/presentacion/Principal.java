package presentacion;

import java.awt.EventQueue;  // La clase EventQueue es para manejo de eventos, pone eventos en cola
import java.awt.event.ActionEvent; // Para indicar que el usuario quiere que ocurra alguna acción.
import java.awt.event.ActionListener; // Permite quedar a la espera de una accion

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;   // Uso Fabricas de la clase logica
import logica.IControladorUsuario;  // Lo mismo para controlador de usuarios

/**
 * Clase principal (Frame) con el metodo Main.

 */
public class Principal {

    private JFrame frmGestionDeUsuarios;       // Frame principal
    private IControladorUsuario ICU;           // Objeto de tipo controlador para manipulacion de objetos
    private CrearUsuario creUsrInternalFrame;  // Frame interno para dar de alta usuario
    private ConsultarUsuario conUsrInternalFrame; // Frame interno para consultar por usuario
    private ListaUsuarios lisUsrInternalFrame;    // Frame interno para listar usuario 

    /**
     * Launch the application.
     */
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

    /**
     * Create the application.
     */
    public Principal() {   // Constructor de la clase
        initialize();     // Inicializa la interface

        Fabrica fabrica = Fabrica.getInstance();  // Se crea una instancia unica de fabrica, se guarda en la varible fabrica
        ICU = fabrica.getIControladorUsuario();   // Se devuelve una instancia unica controlador de usuario
        
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        creUsrInternalFrame = new CrearUsuario(ICU);
        creUsrInternalFrame.setLocation(10, 118);
        creUsrInternalFrame.setVisible(false);

        conUsrInternalFrame = new ConsultarUsuario(ICU);
        conUsrInternalFrame.setLocation(10, 247);
        conUsrInternalFrame.setVisible(false);

        lisUsrInternalFrame = new ListaUsuarios(ICU);
        lisUsrInternalFrame.setLocation(24, 10);
        lisUsrInternalFrame.setVisible(false);
        frmGestionDeUsuarios.getContentPane().setLayout(null);

        frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame); /*Agrego los 3 internos al principal */
        frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
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

        JMenuItem menuConsultarUsuario = new JMenuItem("Consultar Usuario");
        menuConsultarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
                conUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuConsultarUsuario);

        JMenuItem mntmModificarUsuario = new JMenuItem("Modificar Usuario");
        mntmModificarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver la lista de todos los usuarios,
                // cargando previamente la lista
                lisUsrInternalFrame.cargarUsuarios();
                lisUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmModificarUsuario);
        
        JMenu menuActividades = new JMenu("Activdades");
        menuBar.add(menuActividades);
        
        JMenuItem menuAltaAct = new JMenuItem("Alta Actividad Deportiva");
        menuAltaAct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuActividades.add(menuAltaAct);
        
        JMenuItem menuConstultaAct = new JMenuItem("Consulta Actividad Deportiva");
        menuConstultaAct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuActividades.add(menuConstultaAct);
        
        JMenuItem menuRankingAct = new JMenuItem("Ranking Actividad Deportiva");
        menuRankingAct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuActividades.add(menuRankingAct);
        
        JMenu menuClaseDeportiva = new JMenu("Clase Deportiva");
        menuBar.add(menuClaseDeportiva);
        
        JMenuItem menuConsultaClase = new JMenuItem("Consulta Clase Deportiva");
        menuConsultaClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuClaseDeportiva.add(menuConsultaClase);
        
        JMenuItem menuInscripcionClase = new JMenuItem("Inscripcion Clase Deportiva");
        menuInscripcionClase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuClaseDeportiva.add(menuInscripcionClase);
        
        JMenuItem menuConsultaInscripciones = new JMenuItem("Consulta Inscripciones a Clase");
        menuConsultaInscripciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuClaseDeportiva.add(menuConsultaInscripciones);
        
    }
    
}
