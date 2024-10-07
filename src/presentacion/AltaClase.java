package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import dtos.dataTypeActividad;
import logica.Actividad;
import logica.Clase;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorClase;
import logica.IControladorUsuario;

public class AltaClase extends JInternalFrame{
	
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
	private IControladorClase controlCla = Fabrica.getInstance().getIcontroladorClase();
	private JTextField textFieldHora;
	private JTextField textFieldLugar;
	private JTextField textFieldNombre;
	private JTextField textFieldBuscador;
	private JTextField textFieldCupos;
	private JComboBox<dataTypeActividad> comboBoxActividades;
	private JTextField textFieldId;
	
	public AltaClase() {
		getContentPane().setLayout(null);
		setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar una Clase");
        setBounds(10, 40, 539, 404);
        
		comboBoxActividades = new JComboBox();
		comboBoxActividades.setBounds(128, 28, 198, 21);
		getContentPane().add(comboBoxActividades);
		comboBoxActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
                if (seleccionada != null) {
                	//agregarClase(seleccionada, fecha, lugar)
                }
            }
        });
		
		JLabel lblActividades = new JLabel("Actividades Registradas");
		lblActividades.setBounds(169, 10, 116, 13);
		getContentPane().add(lblActividades);
		
		JLabel lblHora = new JLabel("Hora de la clase: ");
		lblHora.setBounds(52, 173, 121, 13);
		getContentPane().add(lblHora);
		
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(52, 244, 121, 13);
		getContentPane().add(lblLugar);
		
		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(52, 282, 121, 13);
		getContentPane().add(lblCupos);
		
		JDateChooser campoFecha = new JDateChooser();
        campoFecha.setBounds(212, 202, 180, 21);
        campoFecha.setToolTipText("Seleccione la fecha");
        getContentPane().add(campoFecha);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(212, 168, 180, 21);
		getContentPane().add(textFieldHora);
		textFieldHora.setColumns(10);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(212, 241, 180, 19);
		getContentPane().add(textFieldLugar);
		textFieldLugar.setColumns(10);
		
		textFieldCupos = new JTextField();
		textFieldCupos.setBounds(212, 277, 180, 21);
		getContentPane().add(textFieldCupos);
		textFieldCupos.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(212, 106, 180, 21);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldBuscador = new JTextField();
    	textFieldBuscador.setColumns(10);
    	textFieldBuscador.setBounds(212, 77, 180, 21);
    	getContentPane().add(textFieldBuscador);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(212, 312, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	              try {
	                  String lugar = textFieldLugar.getText();
	                  String hora = textFieldHora.getText();
	                  int cupos = Integer.parseInt(textFieldCupos.getText());
	                  Date fecha = (Date) campoFecha.getDate();
	                  Long id = (long) Integer.parseInt(textFieldId.getText());
	                  Date fechaAlta = fecha;
	                  String nombre = textFieldNombre.getText();
	                  Actividad actividad = controlAct.consultarActividad2(textFieldBuscador.getText());
	                  controlCla.crearClase(nombre,fecha, hora, lugar, fechaAlta, lugar, cupos);
	                  String imagen = "";
					  Clase clase = new Clase(nombre, fecha, hora, lugar, imagen , fechaAlta, cupos);
					  dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
					  //controlCla.agregarClase(clase);
	                 
	                  
	                  JOptionPane.showMessageDialog(null, "Actividad registrada exitosamente.");
	                  //limpiarCampos();
	              } catch (Exception ex) {
	                  JOptionPane.showMessageDialog(null, "Error al registrar la actividad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	              }
	          }
	      });
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(307, 312, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(212, 138, 180, 21);
		getContentPane().add(textFieldId);
		
		JLabel lblIdDeLa = new JLabel("Id de la clase:");
		lblIdDeLa.setBounds(52, 138, 121, 13);
		getContentPane().add(lblIdDeLa);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(52, 210, 121, 13);
		getContentPane().add(lblFecha);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(52, 108, 121, 13);
		getContentPane().add(lblNombre);
		
		JLabel lblActividad = new JLabel("Nombre de la actividad");
		lblActividad.setBounds(52, 81, 121, 13);
		getContentPane().add(lblActividad);
		
//		JButton btnNewButton_2 = new JButton("Vincular");
//		btnNewButton_2.setBounds(367, 84, 89, 23);
//		getContentPane().add(btnNewButton_2);
		cargarDeportistas();
	}
	
	
	
	public void cargarDeportistas() {
        DefaultComboBoxModel<dataTypeActividad> model; // Este modelo se crea para cargar el combo
        try {
            // Obtener la lista de entrenadores desde el controlador
            List<dataTypeActividad> actividades = controlAct.listarTodas(); // Método que llama al manejador
            model = new DefaultComboBoxModel<>();
            for (dataTypeActividad actividad : actividades) {
                model.addElement(actividad);  // Agregar cada entrenador al modelo
            }
            comboBoxActividades.setModel(model);  // Asignar el modelo al ComboBox
        } catch (Exception e) {
            // Manejo de errores
            JOptionPane.showMessageDialog(this, "Error al listar las activdades: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
