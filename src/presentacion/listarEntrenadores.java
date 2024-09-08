package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.IControladorUsuario;
import dtos.dataTypeUsuario;

public class listarEntrenadores extends JInternalFrame {

    // Controlador de usuarios que se utilizará para obtener los entrenadores
    private IControladorUsuario controlUsr;

    // Componentes gráficos
    private JComboBox<dataTypeUsuario> comboBoxEntrenadores;
    private JLabel lblEntrenadores;
    private JButton btnCerrar;

    /**
     * Constructor del JInternalFrame para listar entrenadores
     */
    public listarEntrenadores(IControladorUsuario icu) {
        // Se inicializa con el controlador de usuarios
        controlUsr = icu;

        // Configuración de la ventana
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        setTitle("Listar Entrenadores");
        setBounds(300, 300, 462, 247);
        getContentPane().setLayout(null);

        // Etiqueta de título
        lblEntrenadores = new JLabel("Entrenadores Registrados");
        lblEntrenadores.setHorizontalAlignment(SwingConstants.CENTER);
        lblEntrenadores.setBounds(20, 9, 132, 13);
        getContentPane().add(lblEntrenadores);

        // ComboBox para mostrar los entrenadores
        comboBoxEntrenadores = new JComboBox<>();
        comboBoxEntrenadores.setBounds(216, 5, 177, 21);
        getContentPane().add(comboBoxEntrenadores);

        // Botón para cerrar la ventana
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(279, 76, 114, 21);
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxEntrenadores.removeAllItems();
                setVisible(false);
            }
        });
        getContentPane().add(btnCerrar);

        // Cargar los entrenadores al inicializar la ventana
        cargarEntrenadores();
    }

    // Método para cargar los entrenadores en el ComboBox
    public void cargarEntrenadores() {
        DefaultComboBoxModel<dataTypeUsuario> model; // Este modelo se crea para cargar el combo
        try {
            // Obtener la lista de entrenadores desde el controlador
            List<dataTypeUsuario> entrenadores = controlUsr.listarEntrenadores(); // Método que llama al manejador
            model = new DefaultComboBoxModel<>();
            for (dataTypeUsuario entrenador : entrenadores) {
                model.addElement(entrenador);  // Agregar cada entrenador al modelo
            }
            comboBoxEntrenadores.setModel(model);  // Asignar el modelo al ComboBox
        } catch (Exception e) {
            // Manejo de errores
            JOptionPane.showMessageDialog(this, "Error al listar los entrenadores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}