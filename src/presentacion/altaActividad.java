package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dtos.dataTypeUsuario;
import logica.IControladorUsuario;

/**
 * JInternalFrame que permite listar todos los usuarios del sistema.
 * @author TProg2017
 *
 */

@SuppressWarnings("serial")
public class altaActividad extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JComboBox<dataTypeUsuario> comboBoxUsuarios;
    private JLabel lblUsuarios;
    private JButton btnCerrar;
    private JTextField lblnombre;
    private JTextField lbldescripción;
    private JTextField lblduración;
    private JTextField lblcosto;
    private JTextField lblubicacion; 
    private JTextField lblFecha;
    private JTextField lbllugar;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
  
    public altaActividad() { // nos falta crear el controlador de usuarios!
        // Se inicializa con el controlador de usuarios
        
        
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

        // Un combo (JComboBox) muestra la lista de usuarios registrados en el sistema.
        // Es posible utilizar otros componentes graficos, esta es salto una opcion.
        // Se ubica al centro del layout.
        comboBoxUsuarios = new JComboBox<dataTypeUsuario>();
        comboBoxUsuarios.setBounds(7, 13, 542, 33);
        getContentPane().add(comboBoxUsuarios);

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
}
