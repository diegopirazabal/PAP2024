package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;
import excepciones.UsuarioRepetidoException;
import logica.Fabrica;
import logica.IControladorUsuario;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
@SuppressWarnings("serial")
public class altaUsuario extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
	private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldNick;
    private JTextField textFieldEmail;
//    private JCalendar textFieldFNac;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseNick;
    private JLabel lblIngreseEmail;
    private JLabel lblIngreseFNac;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JRadioButton rdbtnEsEntrenador;
    private JRadioButton rdbtnEsDeportista;
    private ButtonGroup grupoRoles; 
    private JPasswordField passwordField;
    private JLabel lblIngreseContrasena; 
    private JDateChooser fechaNacimiento;
    
    
//   private JLabel lblNewLabel; NO SE USA

    /**
     * Create the frame.
     */
    public altaUsuario(IControladorUsuario icu) {
        controlUsr = icu;

        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Usuario");
        setBounds(10, 40, 477, 357);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{100, 120, 120, 0};
        gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
        getContentPane().setLayout(gridBagLayout);

        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
        gbc_lblIngreseNombre.anchor = GridBagConstraints.SOUTH;
        gbc_lblIngreseNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNombre.gridx = 0;
        gbc_lblIngreseNombre.gridy = 0;
        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);

        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.anchor = GridBagConstraints.SOUTH;
        gbc_textFieldNombre.gridwidth = 2;
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 0;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);

        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
        gbc_lblIngreseApellido.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseApellido.gridx = 0;
        gbc_lblIngreseApellido.gridy = 1;
        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.gridwidth = 2;
        gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 1;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);

        lblIngreseNick = new JLabel("Nickname:");
        lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNick = new GridBagConstraints();
        gbc_lblIngreseNick.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNick.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNick.gridx = 0;
        gbc_lblIngreseNick.gridy = 2;
        getContentPane().add(lblIngreseNick, gbc_lblIngreseNick);

        textFieldNick = new JTextField();
        textFieldNick.setToolTipText("Ingrese su nickname");
        textFieldNick.setColumns(10);
        GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
        gbc_textFieldNick.gridwidth = 2;
        gbc_textFieldNick.fill = GridBagConstraints.BOTH;
        gbc_textFieldNick.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNick.gridx = 1;
        gbc_textFieldNick.gridy = 2;
        getContentPane().add(textFieldNick, gbc_textFieldNick);

        lblIngreseContrasena = new JLabel("Contraseña:");
        lblIngreseContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseContrasena = new GridBagConstraints();
        gbc_lblIngreseContrasena.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseContrasena.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseContrasena.gridx = 0;
        gbc_lblIngreseContrasena.gridy = 3;
        getContentPane().add(lblIngreseContrasena, gbc_lblIngreseContrasena);

        passwordField = new JPasswordField();  // Campo para la contraseña
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.gridwidth = 2;
        gbc_passwordField.fill = GridBagConstraints.BOTH;
        gbc_passwordField.insets = new Insets(0, 0, 5, 0);
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 3;
        getContentPane().add(passwordField, gbc_passwordField);

        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseEmail = new GridBagConstraints();
        gbc_lblIngreseEmail.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseEmail.gridx = 0;
        gbc_lblIngreseEmail.gridy = 4;
        getContentPane().add(lblIngreseEmail, gbc_lblIngreseEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setToolTipText("Ingrese su email");
        textFieldEmail.setColumns(10);
        GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
        gbc_textFieldEmail.gridwidth = 2;
        gbc_textFieldEmail.fill = GridBagConstraints.BOTH;
        gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldEmail.gridx = 1;
        gbc_textFieldEmail.gridy = 4;
        getContentPane().add(textFieldEmail, gbc_textFieldEmail);

        lblIngreseFNac = new JLabel("Fecha de nacimiento:");
        lblIngreseFNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseFNac = new GridBagConstraints();
        gbc_lblIngreseFNac.anchor = GridBagConstraints.EAST;
        gbc_lblIngreseFNac.fill = GridBagConstraints.VERTICAL;
        gbc_lblIngreseFNac.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseFNac.gridx = 0;
        gbc_lblIngreseFNac.gridy = 5;
        getContentPane().add(lblIngreseFNac, gbc_lblIngreseFNac);
//        textFieldFNac = new UtilDateModel();
//        textFieldFNac.setToolTipText("Ingrese su fecha de nacimiento");
//        textFieldFNac.setColumns(10);
//        GridBagConstraints gbc_textFieldFNac = new GridBagConstraints();
//        gbc_textFieldFNac.gridwidth = 2;
//        gbc_textFieldFNac.fill = GridBagConstraints.BOTH;
//        gbc_textFieldFNac.insets = new Insets(0, 0, 5, 0);
//        gbc_textFieldFNac.gridx = 1;
//        gbc_textFieldFNac.gridy = 5;
//        getContentPane().add(textFieldFNac, gbc_textFieldFNac);

        grupoRoles = new ButtonGroup();
        
        fechaNacimiento = new JDateChooser();
        fechaNacimiento.setToolTipText("Seleccione su fecha de nacimiento");
        GridBagConstraints gbc_fechaNacimiento = new GridBagConstraints();
        gbc_fechaNacimiento.insets = new Insets(0, 0, 5, 5);
        gbc_fechaNacimiento.fill = GridBagConstraints.BOTH;
        gbc_fechaNacimiento.gridx = 1;
        gbc_fechaNacimiento.gridy = 5;
        getContentPane().add(fechaNacimiento, gbc_fechaNacimiento);

        
        rdbtnEsEntrenador = new JRadioButton("Entrenador");
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton.gridx = 1;
        gbc_rdbtnNewRadioButton.gridy = 6;
        getContentPane().add(rdbtnEsEntrenador, gbc_rdbtnNewRadioButton);
        grupoRoles.add(rdbtnEsEntrenador);

        rdbtnEsDeportista = new JRadioButton("Deportista");
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 2;
        gbc_rdbtnNewRadioButton_1.gridy = 6;
        getContentPane().add(rdbtnEsDeportista, gbc_rdbtnNewRadioButton_1);
        grupoRoles.add(rdbtnEsDeportista);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cmdRegistroUsuarioActionPerformed(arg0);
            }
        });

        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.anchor = GridBagConstraints.NORTH;
        gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 7;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.anchor = GridBagConstraints.NORTH;
        gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 7;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
    }

    // Este método es invocado al querer registrar un usuario, funcionalidad
    // provista por la operación del sistem registrarUsuario().
    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos
    // y que la cédula sea un número. 
    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {
        String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String nick = this.textFieldNick.getText();
        String mail = this.textFieldEmail.getText();
        char[] contrasena = this.passwordField.getPassword();
        Date fechaNac = this.fechaNacimiento.getDate(); // Obtén la fecha seleccionada
        
        // Verifica si el usuario ha seleccionado "Entrenador" o "Deportista"
        Boolean esEntrenador = this.rdbtnEsEntrenador.isSelected();
        Boolean esDeportista = this.rdbtnEsDeportista.isSelected();

        if (checkFormulario()) {
            try {
                if (esEntrenador) {
                    String disciplina = JOptionPane.showInputDialog(this, "Ingrese la disciplina");
                    String linkSitioWeb = JOptionPane.showInputDialog(this, "Ingrese el link del sitio web");
                    controlUsr.crearEntrenador(nick, nombreU, apellidoU, mail, fechaNac, esEntrenador, contrasena, disciplina, linkSitioWeb);
                } else if (esDeportista) {
                    Boolean esProfesional = JOptionPane.showConfirmDialog(this, "¿Es un deportista profesional?", "Profesional", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                    controlUsr.crearDeportista(nick, nombreU, apellidoU, mail, fechaNac, esEntrenador, contrasena, esProfesional);
                }
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (UsuarioRepetidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }
            limpiarFormulario();
            setVisible(false);
        }
    }



    // Permite validar la información introducida en los campos e indicar
    // a través de un mensaje de error (JOptionPane) cuando algo sucede.
    // Este tipo de chequeos se puede realizar de otras formas y con otras librerías de Java, 
    // por ejemplo impidiendo que se escriban caracteres no numéricos al momento de escribir en
    // en el campo de la cédula, o mostrando un mensaje de error apenas el foco pasa a otro campo.
    private boolean checkFormulario() {
        String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String nick = this.textFieldNick.getText();
        String mail = this.textFieldEmail.getText();
        Calendar fnac = this.fechaNacimiento.getCalendar();
        
        if(mail.contains("@")) {
	        if (nombreU.isEmpty() || apellidoU.isEmpty() || nick.isEmpty() || mail.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
        }
        else {
        	JOptionPane.showMessageDialog(this, "Por favor ingrese un email valido", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
        	return false;
        }
       return true;
    }

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        // Limpia los campos de texto
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldNick.setText("");
        textFieldEmail.setText("");
        fechaNacimiento.setDate(null);
        passwordField.setText("");
        grupoRoles.clearSelection();  // Esto desmarca los botones de radio
    }

}
