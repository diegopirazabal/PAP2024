package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import dtos.dataTypeUsuario;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorUsuario;

@SuppressWarnings("serial")
public class altaActividad extends JInternalFrame {

    // Controlador de actividades que se utilizará para las acciones del JFrame
    private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
    private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();

    // Los componentes gráficos se agregan como atributos de la clase
    private JTextField textFieldNombre;
    private JTextField textFieldDescripcion;
    private JTextField textFieldDuracion;
    private JTextField textFieldCosto;
    private JTextField textFieldLugar;
    private JTextField textFieldImagen;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseDescripcion;
    private JLabel lblIngreseDuracion;
    private JLabel lblIngreseCosto;
    private JLabel lblIngreseLugar;
    private JLabel lblIngreseFechaAlta;
    private JLabel lblIngreseImagen;
    private JButton btnCancelar;
    private JDateChooser fechaAlta;
    private JTextField textFieldEntrenador;
    private JComboBox<dataTypeUsuario> comboBoxEntrenadores;
    private JButton btnAceptar_1;
    
    public altaActividad(IControladorActividad ica, IControladorUsuario icu) {
        controlAct = ica;
        controlUsr = icu;
        getContentPane().setLayout(null);

        // ComboBox para mostrar los entrenadores
        comboBoxEntrenadores = new JComboBox<>();
        comboBoxEntrenadores.setBounds(100, 27, 361, 22);
        getContentPane().add(comboBoxEntrenadores);
        
        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar una Actividad");
        setBounds(10, 40, 539, 404);

        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setBounds(0, 90, 127, 14);
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(137, 87, 361, 20);
        getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        lblIngreseDescripcion = new JLabel("Descripción:");
        lblIngreseDescripcion.setBounds(0, 109, 127, 25);
        lblIngreseDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseDescripcion);

        textFieldDescripcion = new JTextField();
        textFieldDescripcion.setBounds(137, 109, 361, 25);
        getContentPane().add(textFieldDescripcion);
        textFieldDescripcion.setColumns(10);

        lblIngreseDuracion = new JLabel("Duración (min):");
        lblIngreseDuracion.setBounds(0, 139, 127, 25);
        lblIngreseDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseDuracion);

        textFieldDuracion = new JTextField();
        textFieldDuracion.setBounds(137, 139, 361, 25);
        getContentPane().add(textFieldDuracion);
        textFieldDuracion.setColumns(10);

        lblIngreseCosto = new JLabel("Costo:");
        lblIngreseCosto.setBounds(0, 169, 127, 25);
        lblIngreseCosto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseCosto);

        textFieldCosto = new JTextField();
        textFieldCosto.setBounds(137, 169, 361, 25);
        getContentPane().add(textFieldCosto);
        textFieldCosto.setColumns(10);

        lblIngreseLugar = new JLabel("Lugar:");
        lblIngreseLugar.setBounds(0, 199, 127, 25);
        lblIngreseLugar.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseLugar);

        textFieldLugar = new JTextField();
        textFieldLugar.setBounds(137, 199, 361, 25);
        getContentPane().add(textFieldLugar);
        textFieldLugar.setColumns(10);

        lblIngreseFechaAlta = new JLabel("Fecha de alta:");
        lblIngreseFechaAlta.setBounds(26, 229, 101, 25);
        lblIngreseFechaAlta.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseFechaAlta);

        fechaAlta = new JDateChooser();
        fechaAlta.setBounds(137, 229, 236, 25);
        fechaAlta.setToolTipText("Seleccione la fecha de alta");
        getContentPane().add(fechaAlta);

        lblIngreseImagen = new JLabel("Imagen:");
        lblIngreseImagen.setBounds(55, 259, 72, 25);
        lblIngreseImagen.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblIngreseImagen);

        textFieldImagen = new JTextField();
        textFieldImagen.setBounds(137, 259, 361, 25);
        getContentPane().add(textFieldImagen);
        textFieldImagen.setColumns(10);

        JLabel lblEntrenador = new JLabel("Entrenador:");
        lblEntrenador.setBounds(37, 295, 90, 14);
        lblEntrenador.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(lblEntrenador);
        
        cargarEntrenadores();
        
        JLabel lblEntrenadoresRegistrados = new JLabel("Entrenadores registrados:");
        lblEntrenadoresRegistrados.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEntrenadoresRegistrados.setBounds(210, 11, 126, 14);
        getContentPane().add(lblEntrenadoresRegistrados);
        
        textFieldEntrenador = new JTextField();
        textFieldEntrenador.setColumns(10);
        textFieldEntrenador.setBounds(137, 290, 361, 25);
        getContentPane().add(textFieldEntrenador);
        
//        btnAceptar_1 = new JButton("Aceptar");       
//        btnAceptar_1.setBounds(100, 250, 75, 23);
//        btnAceptar_1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    String nombre = textFieldNombre.getText();
//                    String descripcion = textFieldDescripcion.getText();
//                    int duracion = Integer.parseInt(textFieldDuracion.getText());
//                    double costo = Double.parseDouble(textFieldCosto.getText());
//                    String lugar = textFieldLugar.getText();
//                    Date fecha = new Date(fechaAlta.getDate().getTime());
//                    String imagen = textFieldImagen.getText();
//					// Llamar al método correspondiente del controlador
//                    String entrenadorSeleccionado = textFieldEntrenador.getText();
//                    controlAct.crearActividad(nombre, descripcion, duracion, costo, lugar, fecha, imagen, entrenadorSeleccionado);
//                    
//                    JOptionPane.showMessageDialog(null, "Actividad registrada exitosamente.");
//                    limpiarCampos();
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "Error al registrar la actividad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });     
        
        btnCancelar = new JButton("Cancelar");       
        btnCancelar.setBounds(386, 326, 75, 23);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limpiarCampos();
                dispose();
            }
        });
        getContentPane().add(btnCancelar);
        
        btnAceptar_1 = new JButton("Aceptar");
        btnAceptar_1.setBounds(301, 326, 75, 23);
        btnAceptar_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              try {
                  String nombre = textFieldNombre.getText();
                  String descripcion = textFieldDescripcion.getText();
                  int duracion = Integer.parseInt(textFieldDuracion.getText());
                  double costo = Double.parseDouble(textFieldCosto.getText());
                  String lugar = textFieldLugar.getText();
                  Date fecha = new Date(fechaAlta.getDate().getTime());
                  String imagen = textFieldImagen.getText();
					// Llamar al método correspondiente del controlador
                  String entrenadorSeleccionado = textFieldEntrenador.getText();
                  controlAct.crearActividad(nombre, descripcion, duracion, costo, lugar, fecha, imagen, entrenadorSeleccionado);
                  
                  JOptionPane.showMessageDialog(null, "Actividad registrada exitosamente.");
                  limpiarCampos();
              } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "Error al registrar la actividad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
              }
          }
      });     
        getContentPane().add(btnAceptar_1);
        

    }

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

	// Método para limpiar los campos del formulario
    private void limpiarCampos() {
        textFieldNombre.setText("");
        textFieldDescripcion.setText("");
        textFieldDuracion.setText("");
        textFieldCosto.setText("");
        textFieldLugar.setText("");
        textFieldImagen.setText("");
        textFieldEntrenador.setText("");
        fechaAlta.setDate(null);
    }
}