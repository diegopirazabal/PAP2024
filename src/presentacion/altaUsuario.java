package presentacion;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.ControladorUsuario;
import java.time.LocalDate;


public class altaUsuario extends JInternalFrame {
	 private JTextField nicknameField;
	 private JTextField nombreField;
	 private JTextField apellidoField;
	 private JTextField correoField;
	 private JTextField fechaNacimientoField;
   		private JTextField contrasenaField;
	    private JRadioButton deportistaRadio;
	    private JRadioButton entrenadorRadio;
	    private JCheckBox checkBoxProfesional;
	    private JTextField txtDisciplina;
	    private JTextField txtUrl;
	    private JButton btnCancelar;
	    private JPanel deportistaPanel;
	    private JPanel entrenadorPanel;
	    private JButton btnRegistrar;
	   // CONTROLADOR USUARIO
	    ControladorUsuario cntrlUsuario;

    public altaUsuario() {
    	setTitle("Alta de Usuario");
        setSize(561, 549);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));

        // Etiquetas y campos de texto
        panel.add(new JLabel("Nickname:"));
        nicknameField = new JTextField();
        panel.add(nicknameField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        panel.add(apellidoField);

        panel.add(new JLabel("Correo:"));
        correoField = new JTextField();
        panel.add(correoField);
        
        panel.add(new JLabel("Fecha de Nacimiento (dd/mm/yyyy):"));
        fechaNacimientoField = new JTextField();
        panel.add(fechaNacimientoField);
        
        panel.add(new JLabel("Contraseña:"));
        contrasenaField = new JTextField();
        panel.add(contrasenaField);
       
        // Radio buttons para seleccionar si es deportista o entrenador
        JLabel label = new JLabel("Tipo de Usuario:");
        panel.add(label);
       
        JPanel radioPanel = new JPanel();
        deportistaRadio = new JRadioButton("Deportista");
        entrenadorRadio = new JRadioButton("Entrenador");
        ButtonGroup tipoUsuarioGroup = new ButtonGroup();
        tipoUsuarioGroup.add(deportistaRadio);
        tipoUsuarioGroup.add(entrenadorRadio);
        radioPanel.add(deportistaRadio);
        radioPanel.add(entrenadorRadio);
        panel.add(radioPanel);

        // Panel extra para deportista
        deportistaPanel = new JPanel();
        deportistaPanel.setLayout(new GridLayout(1, 2, 10, 10));
        deportistaPanel.add(new JLabel("Profesional:"));
        checkBoxProfesional = new JCheckBox();
        deportistaPanel.add(checkBoxProfesional);
        deportistaPanel.setVisible(false);
        panel.add(deportistaPanel);

        // Panel extra para entrenador
        entrenadorPanel = new JPanel();
        entrenadorPanel.setLayout(new GridLayout(2, 2, 10, 10));
        entrenadorPanel.add(new JLabel("Disciplina:"));
        txtDisciplina = new JTextField();
        entrenadorPanel.add(txtDisciplina);
        entrenadorPanel.add(new JLabel("Sitio Web (opcional):"));
        txtUrl = new JTextField();
        entrenadorPanel.add(txtUrl);
        entrenadorPanel.setVisible(false);
        panel.add(entrenadorPanel);

        // Botón de registro
        btnCancelar = new JButton("Cancelar");
        panel.add(btnCancelar);

        // Acción del botón
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        // Mostrar/ocultar paneles según selección de tipo de usuario
        deportistaRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deportistaPanel.setVisible(true);
                entrenadorPanel.setVisible(false);
                pack(); // Ajusta el tamaño de la ventana
            }
        });

        entrenadorRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrenadorPanel.setVisible(true);
                deportistaPanel.setVisible(false);
                pack(); // Ajusta el tamaño de la ventana
            }
        });

        getContentPane().add(panel);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		registrarUsuario();
        	}
        });
        panel.add(btnRegistrar);

        
    }
    
    
//REGISTRAR USUARIO
    private void registrarUsuario() {
    	String nickname = nicknameField.getText();
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String correo = correoField.getText();
        LocalDate fechaNacimiento = fechaNacimientoField.getDate();
		String contrasena = contrasenaField.getText();
        String tipoUsuario = deportistaRadio.isSelected() ? "Deportista" : "Entrenador";
        //FALTA CHECKEAR EXCEPCIONES
        if(tipoUsuario.equals("Deportista")) {
        	boolean esProfesional = checkBoxProfesional.isSelected();
        	cntrlUsuario.crearDeportista(nickname, nombre, apellido, correo, fechaNacimiento, contrasena, esProfesional);
        } else if (tipoUsuario.equals("Entrenador")) {
            String disciplina = txtDisciplina.getText();
            String url = txtUrl.getText();
        	cntrlUsuario.crearEntrenador(nickname, nombre, apellido, correo, fechaNacimiento, contrasena, disciplina, url);

        }
    }
}
    