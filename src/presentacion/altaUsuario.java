package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.UsuarioRepetidoException;
import logica.IControladorUsuario;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class altaUsuario extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldNick;
    private JTextField textFieldEmail;
    private JTextField textFieldFNac;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseNick;
    private JLabel lblIngreseEmail;
    private JLabel lblIngreseFNac;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JRadioButton rdbtnEsEntrenador;
    private JRadioButton rdbtnEsDeportista;
    private JLabel lblNewLabel;

    /**
     * Create the frame.
     */
    public altaUsuario(IControladorUsuario icu) {
        // Se inicializa con el controlador de usuarios
        controlUsr = icu;

        // Propiedades del JInternalFrame como dimensión, posición dentro del frame,
        // etc.
        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Usuario");
        setBounds(10, 40, 360, 236);

        // En este caso utilizaremos el GridBagLayout que permite armar una grilla
        // en donde las filas y columnas no son uniformes.
        // Conviene trabajar este componente desde la vista de diseño gráfico y sólo
        // manipular los valores para ajustar alguna cosa.
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 120, 120, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 30, 30, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0 };
        getContentPane().setLayout(gridBagLayout);

        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
        // el nombre del usuario. El texto está alineado horizontalmente a la derecha para
        // que quede casi pegado al campo de texto.
        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
        gbc_lblIngreseNombre.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNombre.gridx = 0;
        gbc_lblIngreseNombre.gridy = 0;
        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);

        // Una campo de texto (JTextField) para ingresar el nombre del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.gridwidth = 2;
        gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 0;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);

        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
        // el apellido del usuario. El texto está alineado horizontalmente a la derecha para
        // que quede casi pegado al campo de texto.
        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
        gbc_lblIngreseApellido.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseApellido.gridx = 0;
        gbc_lblIngreseApellido.gridy = 1;
        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

        // Una campo de texto (JTextField) para ingresar el apellido del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.gridwidth = 2;
        gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 1;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);

        // Una etiqueta (JLabel) indicando que en el siguiente campo debe ingresarse 
        // la cédula del usuario. El texto está alineado horizontalmente a la derecha para
        // que quede casi pegado al campo de texto.
        lblIngreseNick = new JLabel("Nickname:");
        lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNick = new GridBagConstraints();
        gbc_lblIngreseNick.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNick.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNick.gridx = 0;
        gbc_lblIngreseNick.gridy = 2;
        getContentPane().add(lblIngreseNick, gbc_lblIngreseNick);

        // Una campo de texto (JTextField) para ingresar la cédula del usuario. 
        // Por defecto es posible ingresar cualquier string.
        // Al campo se le incluye un Tooltip que, al pasar el mouse por encima, despliega un mensaje.
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
        
        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseEmail = new GridBagConstraints();
        gbc_lblIngreseEmail.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseEmail.gridx = 0;
        gbc_lblIngreseEmail.gridy = 3;
        getContentPane().add(lblIngreseEmail, gbc_lblIngreseEmail);

        // Una campo de texto (JTextField) para ingresar la cédula del usuario. 
        // Por defecto es posible ingresar cualquier string.
        // Al campo se le incluye un Tooltip que, al pasar el mouse por encima, despliega un mensaje.
        textFieldEmail = new JTextField();
        textFieldEmail.setToolTipText("Ingrese su email");
        textFieldEmail.setColumns(10);
        GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
        gbc_textFieldEmail.gridwidth = 2;
        gbc_textFieldEmail.fill = GridBagConstraints.BOTH;
        gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldEmail.gridx = 1;
        gbc_textFieldEmail.gridy = 3;
        getContentPane().add(textFieldEmail, gbc_textFieldEmail);
        
        lblIngreseFNac = new JLabel("Fecha de nacimiento:");
        lblIngreseFNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseFNac = new GridBagConstraints();
        gbc_lblIngreseFNac.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseFNac.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseFNac.gridx = 0;
        gbc_lblIngreseFNac.gridy = 4;
        getContentPane().add(lblIngreseFNac, gbc_lblIngreseFNac);

        // Una campo de texto (JTextField) para ingresar la cédula del usuario. 
        // Por defecto es posible ingresar cualquier string.
        // Al campo se le incluye un Tooltip que, al pasar el mouse por encima, despliega un mensaje.
        textFieldFNac = new JTextField();
        textFieldFNac.setToolTipText("Ingrese su fecha de nacimiento");
        textFieldFNac.setColumns(10);
        GridBagConstraints gbc_textFieldFNac = new GridBagConstraints();
        gbc_textFieldFNac.gridwidth = 2;
        gbc_textFieldFNac.fill = GridBagConstraints.BOTH;
        gbc_textFieldFNac.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldFNac.gridx = 1;
        gbc_textFieldFNac.gridy = 4;
        getContentPane().add(textFieldFNac, gbc_textFieldFNac);

        
        
        // Un botón (JButton) con un evento asociado que permite registrar el usuario.
        // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
        // a otro método en lugar de incluirlo directamente de el método actionPerformed 
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cmdRegistroUsuarioActionPerformed(arg0);
            }
        });
        
        rdbtnEsEntrenador = new JRadioButton("Entrenador");
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton.gridx = 1;
        gbc_rdbtnNewRadioButton.gridy = 5;
        getContentPane().add(rdbtnEsEntrenador, gbc_rdbtnNewRadioButton);
        
        rdbtnEsDeportista = new JRadioButton("Deportista");
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 2;
        gbc_rdbtnNewRadioButton_1.gridy = 5;
        getContentPane().add(rdbtnEsDeportista, gbc_rdbtnNewRadioButton_1);

        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.fill = GridBagConstraints.BOTH;
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 6;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        // Un botón (JButton) con un evento asociado que permite cerrar el formulario (solo ocultarlo).
        // Dado que antes de cerrar se limpia el formulario, se invoca un método reutilizable para ello. 
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.fill = GridBagConstraints.BOTH;
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 6;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
    }
    
    
    

    // Este método es invocado al querer registrar un usuario, funcionalidad
    // provista por la operación del sistem registrarUsuario().
    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos
    // y que la cédula sea un número. 
    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // Obtengo datos de los controles Swing
        String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String nick = this.textFieldNick.getText();
        String mail = this.textFieldEmail.getText();
        String fnac = this.textFieldFNac.getText();
        Boolean esEntrenador = this.rdbtnEsEntrenador.isSelected();
        //boolean esEtrenador; 
        if (checkFormulario()) {
            try {
                controlUsr.registrarUsuario(nombreU, apellidoU, nick, mail, fnac, esEntrenador);

                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (UsuarioRepetidoException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }

            // Limpio el internal frame antes de cerrar la ventana
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
        String fnac = this.textFieldFNac.getText();
         

        if (nombreU.isEmpty() || apellidoU.isEmpty() || nick.isEmpty() || mail.isEmpty() || fnac.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
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
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldNick.setText("");
        textFieldEmail.setText("");
        textFieldFNac.setText("");
    }
}
