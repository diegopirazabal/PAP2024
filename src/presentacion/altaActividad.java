package presentacion;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dtos.dataTypeUsuario;
import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.IControladorUsuario;

@SuppressWarnings("serial")
public class altaActividad extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
	private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JComboBox<dataTypeUsuario> comboBoxUsuarios;
    private JLabel lblUsuarios;
    private JButton btnCerrar;
    private JTextField lblnombre;
//    private JTextField lbldescripción;  NO SE USAN
//    private JTextField lblduración;
//    private JTextField lblcosto;
//    private JTextField lblubicacion; 
//    private JTextField lblFecha;
//    private JTextField lbllugar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField txtMostrarTipo;
    private JTextField txtMostrarMail;
    private JTextField txtMostrarApellido;
    private JTextField txtMostrarNombre;
    private JTextField textFieldNick;
	private String nick;

  
    public altaActividad(IControladorUsuario icu) { // nos falta crear el controlador de usuarios!
        // Se inicializa con el controlador de usuarios
        controlUsr = icu;
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta Actividad Deportiva");
        //setBounds(30, 30, 300, 100);
        setSize(561, 286);
        getContentPane().setLayout(null);

        // Una etiqueta (JLabel) muestra el titulo de la lista que vendra despues.
        // Se ubica al norte del layout y el texto se centra horizontalmente.
        lblUsuarios = new JLabel("Entrenadores Registrados");
        lblUsuarios.setBounds(0, 0, 549, 13);
        lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblUsuarios);
        comboBoxUsuarios = new JComboBox<dataTypeUsuario>();
        comboBoxUsuarios.setMinimumSize(new Dimension(40, 22));
        comboBoxUsuarios.setBounds(216, 5, 177, 21);
        getContentPane().add(comboBoxUsuarios);
        comboBoxUsuarios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//SOLUCION NAHUEL
        		cargarUsuarios();
        	}
        });

        // Un boton (JButton) con un evento asociado que permite limpiar la lista 
        // de usuarios y cerrar la ventana (solo la oculta).
        // Se ubica al sur del layout.
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(0, 499, 549, 21);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxUsuarios.removeAllItems();
                setVisible(false);
            }
        });
        getContentPane().add(btnCerrar);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        
        panel.add(new JLabel("Nombre Actividad:"));
        lblnombre = new JTextField();
        lblnombre.setBounds(0, 13, 7, 486);
        getContentPane().add(lblnombre);
        
        JLabel lblNewLabel = new JLabel("Entrenador a cargo: ");
        lblNewLabel.setBounds(62, 67, 116, 13);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre de la actividad: ");
        lblNewLabel_1.setBounds(62, 90, 116, 13);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Descripcion: ");
        lblNewLabel_2.setBounds(62, 113, 116, 13);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Duracion(En horas): ");
        lblNewLabel_3.setBounds(62, 136, 116, 13);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Costo: ");
        lblNewLabel_4.setBounds(62, 159, 116, 13);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Lugar:");
        lblNewLabel_5.setBounds(62, 182, 116, 13);
        getContentPane().add(lblNewLabel_5);
        
        textField = new JTextField();
        textField.setBounds(309, 64, 170, 19);
        getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(309, 87, 170, 19);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(309, 110, 170, 19);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(309, 133, 170, 19);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(309, 156, 170, 19);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(309, 179, 170, 19);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);
    }
    
    public void cargarUsuarios() {
        DefaultComboBoxModel<dataTypeUsuario> model; // Este modelo se crea para cargar el combo
        try {
            // Aquí llamas al método que obtiene la lista de entrenadores desde el controlador
            List<dataTypeUsuario> entrenadores = controlUsr.listarEntrenadores();  // Este método debería devolver solo los entrenadores
            model = new DefaultComboBoxModel<dataTypeUsuario>();
            for (dataTypeUsuario entrenador : entrenadores) {
                model.addElement(entrenador);  // Agregas cada entrenador al modelo
            }
            comboBoxUsuarios.setModel(model);  // Asignas el modelo al ComboBox
        } catch (UsuarioNoExisteException e) {
            // Manejas la excepción en caso de que no existan entrenadores
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    protected void cmdBuscarUsuarioActionPerformed(ActionEvent e) {
        dataTypeUsuario du;
        try {
        	System.out.print(nick);
            du = controlUsr.verInfoUsuario(textFieldNick.getText());
            if (du.getTipo()) {
            	txtMostrarTipo.setText("Entrenador");
            }else {
            	txtMostrarTipo.setText("Deportista");
            }
            txtMostrarNombre.setText(du.getNombre());
            txtMostrarApellido.setText(du.getApellido());
            txtMostrarMail.setText(du.getEmail());
           // textFieldFNac.setText(du.getFnacimiento());
        } catch (UsuarioNoExisteException e1) {
            // Si el usuario no existe, se muestra mensaje de error y se limpia el
            // formulario.
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Usuario", JOptionPane.ERROR_MESSAGE);
           // limpiarFormulario();
        }
    }
}