package presentacion;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Date;
import java.time.LocalTime;
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
import logica.Clase;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorClase;
import logica.IControladorUsuario;

public class AltaClase extends JInternalFrame{
	
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
	private IControladorClase controlCla = Fabrica.getInstance().getIcontroladorClase();
	private JTextField textFieldFecha;
	private JTextField textFieldHora;
	private JTextField textFieldLugar;
	private JTextField textFieldNombre;
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
		comboBoxActividades.setBounds(128, 21, 198, 21);
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
		lblActividades.setBounds(170, 5, 116, 13);
		getContentPane().add(lblActividades);
		
		JLabel lblFecja = new JLabel("Fecha de la clase: ");
		lblFecja.setBounds(52, 140, 121, 13);
		getContentPane().add(lblFecja);
		
		JLabel lblHora = new JLabel("Hora de la clase: ");
		lblHora.setBounds(52, 173, 121, 13);
		getContentPane().add(lblHora);
		
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(52, 241, 121, 13);
		getContentPane().add(lblLugar);
		
		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(52, 282, 121, 13);
		getContentPane().add(lblCupos);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(212, 135, 180, 19);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JDateChooser campoFecha = new JDateChooser();
        campoFecha.setBounds(180, 198, 236, 25);
        campoFecha.setToolTipText("Seleccione la fecha");
        getContentPane().add(campoFecha);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(212, 168, 180, 19);
		getContentPane().add(textFieldHora);
		textFieldHora.setColumns(10);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(212, 241, 180, 19);
		getContentPane().add(textFieldLugar);
		textFieldLugar.setColumns(10);
		
		textFieldCupos = new JTextField();
		textFieldCupos.setBounds(212, 282, 180, 19);
		getContentPane().add(textFieldCupos);
		textFieldCupos.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(212, 75, 180, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
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
	                  controlCla.crearClase(id, nombre,fecha, hora, lugar, fechaAlta, lugar, cupos);
	                  String imagen = "";
					  Clase clase = new Clase(id, nombre, fecha, hora, lugar, imagen , fechaAlta, cupos);
					  dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
	                  controlAct.agregarClase(clase, seleccionada.getNombre());
	                  
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
		textFieldId.setBounds(212, 105, 180, 19);
		getContentPane().add(textFieldId);
		
		JLabel lblIdDeLa = new JLabel("Id de la clase:");
		lblIdDeLa.setBounds(52, 105, 121, 13);
		getContentPane().add(lblIdDeLa);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(49, 197, 121, 13);
		getContentPane().add(lblFecha);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(52, 75, 121, 13);
		getContentPane().add(lblNombre);
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
