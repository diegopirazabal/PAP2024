package presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorUsuario;

public class ListarUsuarios extends JInternalFrame {

    private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
    private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
    private JComboBox<dataTypeUsuario> comboBoxUsuarios;
    private JComboBox<dataTypeActividad> comboBoxActividades;
    private JLabel lblUsuarios;
    private JButton btnLimpiar;
    private JLabel lblMostrarNombre;
    private JLabel lblMostrarApellido;
    private JLabel lblMostrarMail;
    private JLabel lblMostrarTipo;
    private JTextField txtMostrarTipo;
    private JTextField txtMostrarMail;
    private JTextField txtMostrarApellido;
    private JTextField txtMostrarNombre;
    private JTextField textFieldDuracion;
    private JTextField textFieldLugar;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    public ListarUsuarios(IControladorUsuario icu) {
        controlUsr = icu;
        
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar un Usuario");
        setBounds(300, 300, 551, 395);
        getContentPane().setLayout(null);

        lblUsuarios = new JLabel("Usuarios Registrados");
        lblUsuarios.setBounds(10, 9, 132, 13);
        getContentPane().add(lblUsuarios);

        comboBoxUsuarios = new JComboBox<dataTypeUsuario>();
        comboBoxUsuarios.setMinimumSize(new Dimension(40, 22));
        comboBoxUsuarios.setBounds(171, 5, 258, 21);
        getContentPane().add(comboBoxUsuarios);
        comboBoxUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeUsuario seleccionado = (dataTypeUsuario) comboBoxUsuarios.getSelectedItem();
                if (seleccionado != null) {
                	cargarActividades2(seleccionado);
                    completarCampos(seleccionado);
                    limpiarCamposActividad();
                }
            }
        });
        
        comboBoxActividades = new JComboBox<dataTypeActividad>();
        comboBoxActividades.setMinimumSize(new Dimension(40, 22));
        comboBoxActividades.setBounds(171, 182, 258, 22);
        getContentPane().add(comboBoxActividades);
        comboBoxActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
                if (seleccionada != null) {
                    completarCamposAct(seleccionada);
                }
            }
         });

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(237, 150, 132, 21);
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        getContentPane().add(btnLimpiar);

        lblMostrarNombre = new JLabel("Nombre:");
        lblMostrarNombre.setBounds(10, 39, 182, 16);
        getContentPane().add(lblMostrarNombre);

        txtMostrarNombre = new JTextField();
        txtMostrarNombre.setBounds(171, 37, 258, 20);
        getContentPane().add(txtMostrarNombre);
        txtMostrarNombre.setEditable(false);
        txtMostrarNombre.setText("");
        txtMostrarNombre.setColumns(10);

        lblMostrarApellido = new JLabel("Apellido:");
        lblMostrarApellido.setBounds(10, 66, 182, 16);
        getContentPane().add(lblMostrarApellido);

        txtMostrarApellido = new JTextField();
        txtMostrarApellido.setBounds(171, 64, 258, 20);
        getContentPane().add(txtMostrarApellido);
        txtMostrarApellido.setEditable(false);
        txtMostrarApellido.setText("");
        txtMostrarApellido.setColumns(10);

        lblMostrarMail = new JLabel("Mail:");
        lblMostrarMail.setBounds(10, 93, 182, 16);
        getContentPane().add(lblMostrarMail);

        txtMostrarMail = new JTextField();
        txtMostrarMail.setBounds(171, 91, 258, 20);
        getContentPane().add(txtMostrarMail);
        txtMostrarMail.setEditable(false);
        txtMostrarMail.setText("");
        txtMostrarMail.setColumns(10);

        lblMostrarTipo = new JLabel("Tipo de Usuario:");
        lblMostrarTipo.setBounds(10, 123, 182, 16);
        getContentPane().add(lblMostrarTipo);

        txtMostrarTipo = new JTextField();
        txtMostrarTipo.setBounds(171, 119, 258, 20);
        getContentPane().add(txtMostrarTipo);
        txtMostrarTipo.setEditable(false);
        txtMostrarTipo.setText("");
        txtMostrarTipo.setColumns(10);
        
        
        
        JLabel lblNewLabel = new JLabel("Actividades ofrecidas");
        lblNewLabel.setBounds(10, 182, 214, 14);
        getContentPane().add(lblNewLabel);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(171, 313, 258, 22);
        getContentPane().add(comboBox_1);
        
        JLabel lblNewLabel_1 = new JLabel("Clases en las que se anoto");
        lblNewLabel_1.setBounds(10, 317, 151, 14);
        getContentPane().add(lblNewLabel_1);
        
        textFieldDuracion = new JTextField();
        textFieldDuracion.setEditable(false);
        textFieldDuracion.setBounds(171, 215, 258, 20);
        getContentPane().add(textFieldDuracion);
        textFieldDuracion.setColumns(10);
        
        textFieldLugar = new JTextField();
        textFieldLugar.setEditable(false);
        textFieldLugar.setBounds(171, 247, 258, 20);
        getContentPane().add(textFieldLugar);
        textFieldLugar.setColumns(10);
        
        lblNewLabel_2 = new JLabel("Duracion");
        lblNewLabel_2.setBounds(10, 218, 46, 14);
        getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("Lugar");
        lblNewLabel_3.setBounds(10, 250, 46, 14);
        getContentPane().add(lblNewLabel_3);

    }

    public void cargarUsuarios() {
        DefaultComboBoxModel<dataTypeUsuario> model;
        try {
            List<dataTypeUsuario> usuarios = controlUsr.listarTodos();
            model = new DefaultComboBoxModel<dataTypeUsuario>();
            for (dataTypeUsuario usuario : usuarios) {
                model.addElement(usuario);
            }
            comboBoxUsuarios.setModel(model);
        } catch (UsuarioNoExisteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void completarCampos(dataTypeUsuario usuario) {
        if (usuario != null) {
            txtMostrarTipo.setText(usuario.getTipo() ? "Entrenador" : "Deportista");
            txtMostrarNombre.setText(usuario.getNombre());
            txtMostrarApellido.setText(usuario.getApellido());
            txtMostrarMail.setText(usuario.getEmail());
        }
    }
    private void completarCamposAct(dataTypeActividad act) {
        if (act != null) {
            textFieldLugar.setText(act.getLugar());
            String g = String.valueOf(act.getDuracion());
            textFieldDuracion.setText(g);
        }
    }
    
    public void cargarActividades2(dataTypeUsuario x) {
        DefaultComboBoxModel<dataTypeActividad> model;
        try {
            List<dataTypeActividad> actividades = controlAct.listarActividadesPorEntrenador(x.getNickname());
            model = new DefaultComboBoxModel<dataTypeActividad>();
            for (dataTypeActividad actividad : actividades) {
                model.addElement(actividad);
            }
            comboBoxActividades.setModel(model);
        } catch (UsuarioNoExisteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public void cargarClases(dataTypeUsuario x) {
//        DefaultComboBoxModel<dataTypeClase> model;
//        try {
//            List<dataTypeClase> clases = controlCla.listarClasesPorDeportista(x.getNickname());
//            model = new DefaultComboBoxModel<dataTypeClase>();
//            for (dataTypeClase clase : clases) {
//                model.addElement(clase);
//            }
//            comboBoxClases.setModel(model);
//        } catch (ClaseNoExisteException e) {
//            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    private void limpiarCampos() {
        txtMostrarTipo.setText("");
        txtMostrarNombre.setText("");
        txtMostrarApellido.setText("");
        txtMostrarMail.setText("");
        //textFieldNick.setText("");
    }
    
    private void limpiarCamposActividad() {
        textFieldLugar.setText("");
        textFieldDuracion.setText("");
    }
}
