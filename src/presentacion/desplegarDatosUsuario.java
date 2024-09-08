package presentacion;
import dtos.dataTypeUsuario;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.IControladorUsuario;



public class desplegarDatosUsuario extends JInternalFrame {
    private JTextField textFieldNick;  // Agregamos el campo para el nickname
    private JTextField textFieldNom;
    private JTextField textFieldApe;
    private JTextField textFieldMail;
    private JTextField textFieldFNac;
	private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();

    public desplegarDatosUsuario(IControladorUsuario icu) {
        setResizable(true);
        controlUsr = icu;

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Datos Usuario");
        setBounds(10, 40, 360, 250);  // Ajustamos el tamaño del frame para incluir el nuevo campo
        getContentPane().setLayout(null);

        // Agregamos el JLabel y JTextField para el nickname
        JLabel lblNickname = new JLabel("Nickname:");
        lblNickname.setBounds(36, 20, 96, 13);
        getContentPane().add(lblNickname);

        textFieldNick = new JTextField();
        textFieldNick.setBounds(214, 20, 96, 19);
        getContentPane().add(textFieldNick);
        textFieldNick.setColumns(10);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setBounds(36, 60, 96, 13);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Apellido");
        lblNewLabel_1.setBounds(36, 100, 96, 13);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Email");
        lblNewLabel_3.setBounds(36, 140, 96, 13);
        getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento:");
        lblNewLabel_4.setBounds(36, 180, 122, 13);
        getContentPane().add(lblNewLabel_4);

        textFieldNom = new JTextField();
        textFieldNom.setEditable(false);
        textFieldNom.setBounds(214, 60, 96, 19);
        getContentPane().add(textFieldNom);
        textFieldNom.setColumns(10);

        textFieldApe = new JTextField();
        textFieldApe.setEditable(false);
        textFieldApe.setBounds(214, 100, 96, 19);
        getContentPane().add(textFieldApe);
        textFieldApe.setColumns(10);

        textFieldMail = new JTextField();
        textFieldMail.setEditable(false);
        textFieldMail.setBounds(214, 140, 96, 19);
        getContentPane().add(textFieldMail);
        textFieldMail.setColumns(10);

        textFieldFNac = new JTextField();
        textFieldFNac.setEditable(false);
        textFieldFNac.setBounds(214, 180, 96, 19);
        getContentPane().add(textFieldFNac);
        textFieldFNac.setColumns(10);
    }

    protected void cmdBuscarUsuarioActionPerformed(ActionEvent e) {
        dataTypeUsuario du;
        try {
            // Obtén el nickname desde el nuevo campo de texto
            String nickname = textFieldNick.getText();
            du = controlUsr.verInfoUsuario(nickname);  // Pasa el nickname al método
            textFieldNom.setText(du.getNombre());
            textFieldApe.setText(du.getApellido());
            textFieldMail.setText(du.getEmail());
            textFieldFNac.setText(du.getFNacimiento().toString());  // Si es LocalDate
        } catch (UsuarioNoExisteException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Usuario", JOptionPane.ERROR_MESSAGE);
        }
    }
}