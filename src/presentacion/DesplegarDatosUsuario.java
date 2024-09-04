package presentacion;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.UsuarioNoExisteException;
import logica.IControladorUsuario;
import logica.dataTypeUsuario;


public class DesplegarDatosUsuario extends JInternalFrame {
	  	private JTextField textFieldNom;
		private JTextField textFieldApe;
		private JTextField textFieldMail;
		private JTextField textFieldFNac;
		private IControladorUsuario controlUsr;

	
	public DesplegarDatosUsuario(IControladorUsuario icu) {
		
		setResizable(true);
		controlUsr = icu;

	    //setIconifiable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    setTitle("Datos Usuario");
	    setBounds(10, 40, 360, 194);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(36, 22, 96, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(36, 62, 96, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(36, 104, 96, 13);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_4.setBounds(36, 152, 122, 13);
		getContentPane().add(lblNewLabel_4);
		
		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBounds(214, 19, 96, 19);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldApe = new JTextField();
		textFieldApe.setEditable(false);
		textFieldApe.setBounds(214, 59, 96, 19);
		getContentPane().add(textFieldApe);
		textFieldApe.setColumns(10);
		
		textFieldMail = new JTextField();
		textFieldMail.setEditable(false);
		textFieldMail.setBounds(214, 101, 96, 19);
		getContentPane().add(textFieldMail);
		textFieldMail.setColumns(10);
		
		textFieldFNac = new JTextField();
		textFieldFNac.setEditable(false);
		textFieldFNac.setBounds(214, 149, 96, 19);
		getContentPane().add(textFieldFNac);
		textFieldFNac.setColumns(10);
		
		
		
		//String nickname = textFieldNick.getText();
		//ListarUsuarios.cmdBuscarUsuarioActionPerformed(e, nickname);
		
	}
	

	protected void cmdBuscarUsuarioActionPerformed(ActionEvent e) {
        dataTypeUsuario du;
        try {
            du = controlUsr.verInfoUsuario();
            textFieldNom.setText(du.getNombre());
            textFieldApe.setText(du.getApellido());
            textFieldMail.setText(du.getEmail());
            textFieldFNac.setText(du.getFnacimiento());
        } catch (UsuarioNoExisteException e1) {
            // Si el usuario no existe, se muestra mensaje de error y se limpia el
            // formulario.
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Usuario", JOptionPane.ERROR_MESSAGE);
           // limpiarFormulario();
        }
    }

}

