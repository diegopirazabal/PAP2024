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

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import dtos.dataTypeUsuario;
import excepciones.ActividadNoExisteException;
import excepciones.ClaseNoExisteException;
import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorClase;
import logica.IControladorUsuario;

public class InscripcionClase extends JInternalFrame{
	
	private JComboBox<dataTypeUsuario> comboBoxDeportistas;
	private JComboBox<dataTypeClase> comboBoxClases;
	private JComboBox<dataTypeActividad> comboBoxActividades;
	private IControladorClase controlCla = Fabrica.getInstance().getIcontroladorClase();
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private IControladorUsuario controlUsu = Fabrica.getInstance().getIControladorUsuario();
	
	public InscripcionClase() {
		setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a una clase");
        setBounds(10, 40, 490, 297);
        getContentPane().setLayout(null);
        
        comboBoxActividades = new JComboBox();
        comboBoxActividades.setBounds(167, 29, 248, 21);
        getContentPane().add(comboBoxActividades);
        comboBoxActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
                if (seleccionada != null) {
                	
                }
            }
        });
        
        JLabel lblActividades = new JLabel("Actividades disponibles");
        lblActividades.setBounds(38, 33, 119, 13);
        getContentPane().add(lblActividades);
        
        comboBoxClases = new JComboBox();
        comboBoxClases.setBounds(167, 72, 248, 21);
        getContentPane().add(comboBoxClases);
        comboBoxActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeClase seleccionada = (dataTypeClase) comboBoxClases.getSelectedItem();
                if (seleccionada != null) {
                	
                }
            }
        });
        
        JLabel lblDeportistas = new JLabel("Deportistas registrados");
        lblDeportistas.setBounds(38, 121, 119, 13);
        getContentPane().add(lblDeportistas);
        
        comboBoxDeportistas = new JComboBox();
        comboBoxDeportistas.setBounds(167, 117, 248, 21);
        getContentPane().add(comboBoxDeportistas);
        comboBoxDeportistas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dataTypeUsuario seleccionada = (dataTypeUsuario) comboBoxDeportistas.getSelectedItem();
                if (seleccionada != null) {
                	
                }
            }
        });
        
        JLabel lblClases = new JLabel("Clases disponibles");
        lblClases.setBounds(38, 76, 119, 13);
        getContentPane().add(lblClases);
        
        JButton btnNewButton = new JButton("Cancelar");
        btnNewButton.setBounds(167, 192, 119, 21);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Aceptar");
        btnNewButton_1.setBounds(296, 192, 119, 21);
        getContentPane().add(btnNewButton_1);
	}
	
	public void cargarClases() {
        DefaultComboBoxModel<dataTypeClase> model;
        try {
            List<dataTypeClase> clases = controlCla.listarTodas();
            model = new DefaultComboBoxModel<dataTypeClase>();
            for (dataTypeClase clase : clases) {
                model.addElement(clase);
            }
            comboBoxClases.setModel(model);
        } catch (ClaseNoExisteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
	}
	
	public void cargarActividades() {
        DefaultComboBoxModel<dataTypeActividad> model;
        try {
            List<dataTypeActividad> actividades = controlAct.listarTodas();
            model = new DefaultComboBoxModel<dataTypeActividad>();
            for (dataTypeActividad actividad : actividades) {
                model.addElement(actividad);
            }
            comboBoxActividades.setModel(model);
        } catch (ActividadNoExisteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	


public void cargarDeportistas() {
	DefaultComboBoxModel<dataTypeUsuario> model;
    try {
        List<dataTypeUsuario> deportistas = controlUsu.listarDeportistas();
        model = new DefaultComboBoxModel<dataTypeUsuario>();
        for (dataTypeUsuario deportista : deportistas) {
            model.addElement(deportista);
        }
        comboBoxDeportistas.setModel(model);
	} catch (UsuarioNoExisteException e) {
       JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
	
}


}