package presentacion;

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
import javax.swing.SwingConstants;

import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.IControladorUsuario;
import dtos.dataTypeUsuario;
import java.awt.Dimension;

public class ListarUsuarios extends JInternalFrame {

    private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
    private JComboBox<dataTypeUsuario> comboBoxUsuarios;
    private JLabel lblUsuarios;
    private JButton btnBuscar;
    private JButton btnLimpiar;
    private JTextField textFieldNick;
    private JLabel lblNewLabel;
    private JLabel lblMostrarNombre;
    private JLabel lblMostrarApellido;
    private JLabel lblMostrarMail;
    private JLabel lblMostrarTipo;
    private JTextField txtMostrarTipo;
    private JTextField txtMostrarMail;
    private JTextField txtMostrarApellido;
    private JTextField txtMostrarNombre;

    public ListarUsuarios(IControladorUsuario icu) {
        controlUsr = icu;
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar un Usuario");
        setBounds(300, 300, 406, 272);
        getContentPane().setLayout(null);

        lblUsuarios = new JLabel("Usuarios Registrados");
        lblUsuarios.setBounds(10, 9, 132, 13);
        getContentPane().add(lblUsuarios);

        comboBoxUsuarios = new JComboBox<dataTypeUsuario>();
        comboBoxUsuarios.setMinimumSize(new Dimension(40, 22));
        comboBoxUsuarios.setBounds(171, 5, 182, 21);
        getContentPane().add(comboBoxUsuarios);
        comboBoxUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeUsuario seleccionado = (dataTypeUsuario) comboBoxUsuarios.getSelectedItem();
                if (seleccionado != null) {
                    completarCampos(seleccionado);
                }
            }
        });

        btnBuscar = new JButton("Buscar Usuario");
        btnBuscar.setBounds(171, 65, 103, 24);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmdBuscarUsuarioActionPerformed(e);
            }
        });
        getContentPane().add(btnBuscar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(171, 210, 132, 21);
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        getContentPane().add(btnLimpiar);

        lblNewLabel = new JLabel("Ingrese Nickname:");
        lblNewLabel.setBounds(10, 39, 132, 16);
        getContentPane().add(lblNewLabel);

        textFieldNick = new JTextField();
        textFieldNick.setBounds(171, 37, 182, 19);
        getContentPane().add(textFieldNick);
        textFieldNick.setColumns(10);

        lblMostrarNombre = new JLabel("Nombre:");
        lblMostrarNombre.setBounds(10, 102, 182, 16);
        getContentPane().add(lblMostrarNombre);

        txtMostrarNombre = new JTextField();
        txtMostrarNombre.setBounds(171, 100, 182, 20);
        getContentPane().add(txtMostrarNombre);
        txtMostrarNombre.setEditable(false);
        txtMostrarNombre.setText("");
        txtMostrarNombre.setColumns(10);

        lblMostrarApellido = new JLabel("Apellido:");
        lblMostrarApellido.setBounds(10, 129, 182, 16);
        getContentPane().add(lblMostrarApellido);

        txtMostrarApellido = new JTextField();
        txtMostrarApellido.setBounds(171, 127, 182, 20);
        getContentPane().add(txtMostrarApellido);
        txtMostrarApellido.setEditable(false);
        txtMostrarApellido.setText("");
        txtMostrarApellido.setColumns(10);

        lblMostrarMail = new JLabel("Mail:");
        lblMostrarMail.setBounds(10, 156, 182, 16);
        getContentPane().add(lblMostrarMail);

        txtMostrarMail = new JTextField();
        txtMostrarMail.setBounds(171, 154, 182, 20);
        getContentPane().add(txtMostrarMail);
        txtMostrarMail.setEditable(false);
        txtMostrarMail.setText("");
        txtMostrarMail.setColumns(10);

        lblMostrarTipo = new JLabel("Tipo de Usuario:");
        lblMostrarTipo.setBounds(10, 183, 182, 16);
        getContentPane().add(lblMostrarTipo);

        txtMostrarTipo = new JTextField();
        txtMostrarTipo.setBounds(171, 182, 182, 20);
        getContentPane().add(txtMostrarTipo);
        txtMostrarTipo.setEditable(false);
        txtMostrarTipo.setText("");
        txtMostrarTipo.setColumns(10);

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

    private void cmdBuscarUsuarioActionPerformed(ActionEvent e) {
        dataTypeUsuario du;
        try {
            du = controlUsr.verInfoUsuario(textFieldNick.getText());
            completarCampos(du);
        } catch (UsuarioNoExisteException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Usuario", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
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

    private void limpiarCampos() {
        txtMostrarTipo.setText("");
        txtMostrarNombre.setText("");
        txtMostrarApellido.setText("");
        txtMostrarMail.setText("");
        textFieldNick.setText("");
    }
}
