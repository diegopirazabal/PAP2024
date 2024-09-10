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
import java.awt.Dimension;
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
    	getContentPane().setSize(new Dimension(6, 7));
        controlUsr = icu;

        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Usuario");
        setBounds(10, 40, 477, 357);
        getContentPane().setLayout(null);

        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setBounds(25, 34, 98, 13);
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(133, 28, 237, 25);
        getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setBounds(30, 58, 98, 25);
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setBounds(133, 58, 237, 25);
        getContentPane().add(textFieldApellido);
        textFieldApellido.setColumns(10);

        lblIngreseNick = new JLabel("Nickname:");
        lblIngreseNick.setBounds(30, 88, 98, 25);
        lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseNick);

        textFieldNick = new JTextField();
        textFieldNick.setBounds(133, 88, 237, 25);
        textFieldNick.setToolTipText("Ingrese su nickname");
        textFieldNick.setColumns(10);
        getContentPane().add(textFieldNick);

        lblIngreseContrasena = new JLabel("Contraseña:");
        lblIngreseContrasena.setBounds(30, 118, 98, 25);
        lblIngreseContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseContrasena);

        passwordField = new JPasswordField();
        passwordField.setBounds(133, 118, 237, 25);
        getContentPane().add(passwordField);

        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setBounds(30, 153, 98, 19);
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(133, 150, 237, 25);
        textFieldEmail.setToolTipText("Ingrese su email");
        textFieldEmail.setColumns(10);
        getContentPane().add(textFieldEmail);

        lblIngreseFNac = new JLabel("Fecha de nacimiento:");
        lblIngreseFNac.setBounds(30, 182, 98, 19);
        lblIngreseFNac.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseFNac);
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
        fechaNacimiento.setBounds(133, 181, 237, 25);
        fechaNacimiento.setMaximumSize(new Dimension(100000000, 100000000));
        fechaNacimiento.setToolTipText("Seleccione su fecha de nacimiento");
        getContentPane().add(fechaNacimiento);

        
        rdbtnEsEntrenador = new JRadioButton("Entrenador");
        rdbtnEsEntrenador.setBounds(159, 219, 75, 25);
        getContentPane().add(rdbtnEsEntrenador);
        grupoRoles.add(rdbtnEsEntrenador);
        
                btnAceptar = new JButton("Aceptar");
                btnAceptar.setBounds(312, 281, 143, 21);
                btnAceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        cmdRegistroUsuarioActionPerformed(arg0);
                    }
                });
                        
                                rdbtnEsDeportista = new JRadioButton("Deportista");
                                rdbtnEsDeportista.setBounds(259, 221, 71, 21);
                                getContentPane().add(rdbtnEsDeportista);
                                grupoRoles.add(rdbtnEsDeportista);
                        getContentPane().add(btnAceptar);
                                
                                        btnCancelar = new JButton("Cancelar");
                                        btnCancelar.setBounds(159, 281, 143, 21);
                                        btnCancelar.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                limpiarFormulario();
                                                setVisible(false);
                                            }
                                        });
                                        getContentPane().add(btnCancelar);
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
