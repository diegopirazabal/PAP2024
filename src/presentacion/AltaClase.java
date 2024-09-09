package presentacion;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorUsuario;

public class AltaClase extends JInternalFrame{
	
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
	private JTextField textFieldFecha;
	private JTextField textFieldHora;
	private JTextField textFieldLugar;
	private JTextField textFieldCupos;
	
	public AltaClase() {
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 21, 198, 21);
		getContentPane().add(comboBox);
		
		JLabel lblActividades = new JLabel("Actividades Registradas");
		lblActividades.setBounds(170, 5, 116, 13);
		getContentPane().add(lblActividades);
		
		JLabel lblFecja = new JLabel("Fecha de la clase: ");
		lblFecja.setBounds(50, 88, 121, 13);
		getContentPane().add(lblFecja);
		
		JLabel lblHora = new JLabel("Hora de la clase: ");
		lblHora.setBounds(50, 121, 121, 13);
		getContentPane().add(lblHora);
		
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(50, 158, 121, 13);
		getContentPane().add(lblLugar);
		
		JLabel lblCupos = new JLabel("Cupos");
		lblCupos.setBounds(50, 199, 121, 13);
		getContentPane().add(lblCupos);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(210, 85, 180, 19);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(210, 118, 180, 19);
		getContentPane().add(textFieldHora);
		textFieldHora.setColumns(10);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(210, 155, 180, 19);
		getContentPane().add(textFieldLugar);
		textFieldLugar.setColumns(10);
		
		textFieldCupos = new JTextField();
		textFieldCupos.setBounds(210, 196, 180, 19);
		getContentPane().add(textFieldCupos);
		textFieldCupos.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(210, 225, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(305, 225, 85, 21);
		getContentPane().add(btnNewButton_1);
	}
}
