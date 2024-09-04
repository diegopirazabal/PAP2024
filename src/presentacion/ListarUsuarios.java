package presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import dtos.dataTypeUsuario;
import logica.IControladorUsuario;

/**
 * JInternalFrame que permite listar todos los usuarios del sistema.
 * @author TProg2017
 *
 */

@SuppressWarnings("serial")
public class ListarUsuarios extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorUsuario controlUsr;
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JComboBox<dataTypeUsuario> comboBoxUsuarios;
    private JLabel lblUsuarios;
    private JButton btnCerrar;


    public ListarUsuarios(IControladorUsuario controlUsr) { // nos falta crear el controlador de usuarios!
        // Se inicializa con el controlador de usuarios        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
    	this.controlUsr = controlUsr; // Inicializa el controlador de usuarios
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar un Usuario");
        setBounds(30, 30, 300, 100);
        
        // En este caso se utiliza un BorderLayout en donde los componentes se ubican segun una orientacion.
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Una etiqueta (JLabel) muestra el titulo de la lista que vendra despues.
        // Se ubica al norte del layout y el texto se centra horizontalmente.
        lblUsuarios = new JLabel("Usuarios Registrados");
        lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblUsuarios, BorderLayout.NORTH);

        // Un combo (JComboBox) muestra la lista de usuarios registrados en el sistema.
        // Es posible utilizar otros componentes graficos, esta es salto una opcion.
        // Se ubica al centro del layout.
        comboBoxUsuarios = new JComboBox<dataTypeUsuario>();
        getContentPane().add(comboBoxUsuarios, BorderLayout.CENTER);

        // Un boton (JButton) con un evento asociado que permite limpiar la lista 
        // de usuarios y cerrar la ventana (solo la oculta).
        // Se ubica al sur del layout.
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxUsuarios.removeAllItems();
                setVisible(false);
            }
        });
        getContentPane().add(btnCerrar, BorderLayout.SOUTH);
    }

    // Metodo que permite cargar un nuevo modelo para el combo con la informacion
    // actualizada de usuarios, provista por la operacion del sistema getUsuarios(). 
    // Se invoca el metodo antes de hacer visible el JInternalFrame
    
    public void cargarUsuarios() {
        try {
            List<dataTypeUsuario> usuarios = controlUsr.getUsuarios();  // Obtiene la lista de usuarios
            if (usuarios != null && !usuarios.isEmpty()) {
                // Convierte la lista a un array
                dataTypeUsuario[] usuariosArray = usuarios.toArray(new dataTypeUsuario[0]);
                // Crea el modelo con el array
                DefaultComboBoxModel<dataTypeUsuario> model = new DefaultComboBoxModel<>(usuariosArray);
                // Establece el modelo al JComboBox
                comboBoxUsuarios.setModel(model);
            } else {
                // Manejar el caso en que no hay usuarios
                DefaultComboBoxModel<dataTypeUsuario> model = new DefaultComboBoxModel<>();
                comboBoxUsuarios.setModel(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
