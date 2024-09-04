package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;


import excepciones.UsuarioNoExisteException;
import logica.IControladorUsuario;
import logica.dataTypeUsuario;

public class ListarUsuarios extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.  
    private JComboBox<dataTypeUsuario> comboBoxUsuarios;
    private JLabel lblUsuarios;
    private JButton btnCerrar;
    private JTextField textFieldNick;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
  	private JTextField textFieldNom;
	private JTextField textFieldApe;
	private JTextField textFieldMail;
	private JTextField textFieldFNac;
	private DesplegarDatosUsuario despUsrJInternalFrame;
	private IControladorUsuario ICU;
	//SOLUCION NAHUEL
	private JDesktopPane panelDespUsu;
	private String nick;
    //private DesplegarDatosUsuario despDatosInternalFrame;

    /**
     * Create the frame.
     */
    public ListarUsuarios(IControladorUsuario icu) {
        // Se inicializa con el controlador de usuarios
        controlUsr = icu;
        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar un Usuario");
        setBounds(30, 30, 6001, 200);
        getContentPane().setLayout(null);

        despUsrJInternalFrame = new DesplegarDatosUsuario(ICU);
        despUsrJInternalFrame.setLocation(30, 35);
        despUsrJInternalFrame.setVisible(false);
        
        //SOLUCION NAHUEL
        panelDespUsu = new JDesktopPane();
        setContentPane(panelDespUsu);
        

        lblUsuarios = new JLabel("Usuarios Registrados");
        lblUsuarios.setBounds(20, 9, 132, 13);
        lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblUsuarios);

        
        comboBoxUsuarios = new JComboBox<dataTypeUsuario>();
        comboBoxUsuarios.setBounds(216, 5, 177, 21);
        getContentPane().add(comboBoxUsuarios);

        // Un boton (JButton) con un evento asociado que permite limpiar la lista 
        // de usuarios y cerrar la ventana (solo la oculta).
        // Se ubica al sur del layout.
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(279, 76, 114, 21);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxUsuarios.removeAllItems();
                setVisible(false);
            }
        });
        getContentPane().add(btnCerrar);
        
        lblNewLabel = new JLabel("Ingrese Nickname:");
        lblNewLabel.setBounds(20, 48, 132, 16);
        getContentPane().add(lblNewLabel);
        
        textFieldNick = new JTextField();
        textFieldNick.setBounds(216, 47, 177, 19);
        getContentPane().add(textFieldNick);
        textFieldNick.setColumns(10);
        
        label = new JLabel("");
        label.setBounds(189, 40, 0, 0);
        getContentPane().add(label);
        
        label_1 = new JLabel("");
        label_1.setBounds(194, 40, 0, 0);
        getContentPane().add(label_1);
        
        label_2 = new JLabel("");
        label_2.setBounds(199, 40, 0, 0);
        getContentPane().add(label_2);
        
        JButton btnNewButton = new JButton("Buscar Usuario");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//SOLUCION NAHUEL
        		DesplegarDatosUsuario nuevo = new DesplegarDatosUsuario(ICU);
        		panelDespUsu.add(nuevo);
        		nuevo.setVisible(true);
        	}
        });
        btnNewButton.setBounds(50, 76, 132, 21);
        getContentPane().add(btnNewButton);
    }

    // Metodo que permite cargar un nuevo modelo para el combo con la informacion
    // actualizada de usuarios, provista por la operacion del sistema getUsuarios(). 
    // Se invoca el metodo antes de hacer visible el JInternalFrame
    
    public void cargarUsuarios() {
        DefaultComboBoxModel<dataTypeUsuario> model; // Este modelo se crea para carga el combo 
        try {                                    // En model esta lo que vamos a carga al combo
            model = new DefaultComboBoxModel<dataTypeUsuario>(controlUsr.getUsuarios()); //Aca se carga
            comboBoxUsuarios.setModel(model);        //VER EN LA API DefaultComboBoxModel
        } catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }
    }
        
        private void limpiarFormulario() {
        	textFieldNom.setText("");
        	textFieldApe.setText("");
        	textFieldNick.setText("");
            textFieldMail.setText("");
            textFieldFNac.setText("");
        }
}

