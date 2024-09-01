package presentacion;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import logica.manejadorUsuarios;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class Principal {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Mi Aplicación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Crear un panel y agregar componentes
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nombre:");
        label.setBounds(22, 12, 40, 13);
        JTextField textField = new JTextField(20);
        textField.setBounds(72, 9, 166, 19);
        JButton button = new JButton("Buscar usuario");
        button.setBounds(248, 8, 99, 21);

        // Crear una instancia del manejador
        manejadorUsuarios manejadorUsuario = new manejadorUsuarios(); // Corrige el nombre de la clase según tu implementación

        // Agregar un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto del campo de texto
                String nombre = textField.getText();
                // Llamar al método del manejador
                manejadorUsuario.buscarUsuarioPorNickname(nombre); // Asegúrate de que el método y parámetro son correctos
            }
        });
        panel.setLayout(null);

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}


/*
import java.awt.EventQueue;  // La clase EventQueue es para manejo de eventos, pone eventos en cola

import javax.swing.JFrame;   
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;   // Uso Fabricas de la clase logica
import logica.IControladorUsuario;  // Lo mismo para controlador de usuarios

import javax.swing.JMenu;
import java.awt.event.ActionEvent; // Para indicar que el usuario quiere que ocurra alguna acción.
import java.awt.event.ActionListener; // Permite quedar a la espera de una accion
*/
/*
public class Principal {

    private JFrame frmGestionDeUsuarios;       // Frame principal
    private IControladorUsuario ICU;           // Objeto de tipo controlador para manipulacion de objetos
    private CrearUsuario creUsrInternalFrame;  // Frame interno para dar de alta usuario
    private ConsultarUsuario conUsrInternalFrame; // Frame interno para consultar por usuario
    private ListaUsuarios lisUsrInternalFrame;    // Frame interno para listar usuario 

  
    public static void main(String[] args) {
    	System.out.print("Entre al main");
        EventQueue.invokeLater(new Runnable() {  // se utiliza para poner en cola una tarea 
            public void run() {                  // para ser ejecutada en el hilo de eventos EDT
                try {
                    Principal window = new Principal();   // Crea una instancia del objeto principal
                    window.frmGestionDeUsuarios.setVisible(true); // Pone la ventana visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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

        lisUsrInternalFrame = new ListaUsuarios(ICU);
        lisUsrInternalFrame.setVisible(false);
        frmGestionDeUsuarios.getContentPane().setLayout(null);

        frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame); //Agrego los 3 internos al principal 
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
}
*/