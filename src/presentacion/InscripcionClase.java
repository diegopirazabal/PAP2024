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
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldLugar;
	private JTextField textFieldCupos;
	
	private IControladorClase controlCla = Fabrica.getInstance().getIcontroladorClase();
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private IControladorUsuario controlUsu = Fabrica.getInstance().getIControladorUsuario();
	
	public InscripcionClase() {
	    setResizable(true);
	    setIconifiable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    setTitle("Inscripcion a una clase");
	    setBounds(10, 40, 500, 400);  
	    getContentPane().setLayout(null);

	    
	    JLabel lblActividades = new JLabel("Actividades disponibles");
	    lblActividades.setBounds(38, 33, 150, 20);
	    getContentPane().add(lblActividades);
	    
	    
	    
	    comboBoxActividades = new JComboBox<dataTypeActividad>();
	    comboBoxActividades.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
                if (seleccionada != null) {
                    completarCampos(seleccionada);
                    cargarClases2(seleccionada);
                }
	    	}
	    });
	    comboBoxActividades.setBounds(200, 30, 250, 25);
	    getContentPane().add(comboBoxActividades);

	    JLabel lblClases = new JLabel("Clases disponibles");
	    lblClases.setBounds(38, 70, 150, 20);
	    getContentPane().add(lblClases);

	    comboBoxClases = new JComboBox<dataTypeClase>();
	    comboBoxClases.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dataTypeClase seleccionadaClase = (dataTypeClase) comboBoxClases.getSelectedItem();
                if (seleccionadaClase != null) {
                    completarCupos(seleccionadaClase);
                }
	    	}
	    });
	    comboBoxClases.setBounds(200, 67, 250, 25);
	    getContentPane().add(comboBoxClases);

	    JLabel lblDeportistas = new JLabel("Deportistas registrados");
	    lblDeportistas.setBounds(38, 110, 150, 20);
	    getContentPane().add(lblDeportistas);

	    comboBoxDeportistas = new JComboBox<dataTypeUsuario>();
	    comboBoxDeportistas.setBounds(200, 107, 250, 25);
	    getContentPane().add(comboBoxDeportistas);

	    JLabel lblNewLabel_2 = new JLabel("Descripcion");
	    lblNewLabel_2.setBounds(38, 150, 150, 20);
	    getContentPane().add(lblNewLabel_2);

	    textFieldDescripcion = new JTextField();
	    textFieldDescripcion.setEditable(false);
	    textFieldDescripcion.setBounds(200, 147, 250, 25);
	    getContentPane().add(textFieldDescripcion);

	    JLabel lblNewLabel_3 = new JLabel("Duracion");
	    lblNewLabel_3.setBounds(38, 190, 150, 20);
	    getContentPane().add(lblNewLabel_3);

	    textFieldDuracion = new JTextField();
	    textFieldDuracion.setEditable(false);
	    textFieldDuracion.setBounds(200, 187, 250, 25);
	    getContentPane().add(textFieldDuracion);

	    JLabel lblNewLabel_4 = new JLabel("Costo");
	    lblNewLabel_4.setBounds(38, 230, 150, 20);
	    getContentPane().add(lblNewLabel_4);

	    textFieldCosto = new JTextField();
	    textFieldCosto.setEditable(false);
	    textFieldCosto.setBounds(200, 227, 250, 25);
	    getContentPane().add(textFieldCosto);

	    // Agrego "Cupos" aquí
	    JLabel lblNewLabel_6 = new JLabel("Cupos");
	    lblNewLabel_6.setBounds(38, 270, 150, 20);
	    getContentPane().add(lblNewLabel_6);

	    textFieldCupos = new JTextField();
	    textFieldCupos.setEditable(false);
	    textFieldCupos.setBounds(200, 267, 250, 25);  // Ajustado debajo de "Costo"
	    getContentPane().add(textFieldCupos);

	    // Reajusto "Lugar" debajo de "Cupos"
	    JLabel lblNewLabel_5 = new JLabel("Lugar");
	    lblNewLabel_5.setBounds(38, 310, 150, 20);
	    getContentPane().add(lblNewLabel_5);

	    textFieldLugar = new JTextField();
	    textFieldLugar.setEditable(false);
	    textFieldLugar.setBounds(200, 307, 250, 25);
	    getContentPane().add(textFieldLugar);

	    JButton btnNewButton = new JButton("Cancelar");
	    btnNewButton.setBounds(200, 350, 119, 30);
	    getContentPane().add(btnNewButton);

	    JButton btnNewButton_1 = new JButton("Aceptar");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//Tengo que llamar al controlador de inscripciones
	    	}
	    });
	    btnNewButton_1.setBounds(331, 350, 119, 30);
	    getContentPane().add(btnNewButton_1);
	    cargarDeportistas();
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
        System.out.println("hola" + deportistas);
        model = new DefaultComboBoxModel<dataTypeUsuario>();
        for (dataTypeUsuario deportista : deportistas) {
            model.addElement(deportista);
        }
        comboBoxDeportistas.setModel(model);
	} catch (UsuarioNoExisteException e) {
       JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
	
}

private void completarCampos(dataTypeActividad actividad) {
    if (actividad != null) {
        textFieldLugar.setText(actividad.getLugar());
        String x = String.valueOf(actividad.getDuracion());
        textFieldDuracion.setText(x);
        String y = String.valueOf(actividad.getCosto());
        textFieldCosto.setText(y);
        textFieldDescripcion.setText(actividad.getDescripcion());
    }

}

public void cargarClases2(dataTypeActividad actividad) {
    DefaultComboBoxModel<dataTypeClase> model;
    try {
        // Llamar al método del controlador que obtiene las clases para la actividad seleccionada
        List<dataTypeClase> clases = controlCla.listarClasesPorActividad(actividad.getNombre());
        model = new DefaultComboBoxModel<>();
        for (dataTypeClase clase : clases) {
            model.addElement(clase);
        }
        comboBoxClases.setModel(model);
    } catch (ClaseNoExisteException e) {
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void completarCupos(dataTypeClase clase) {
	String x = String.valueOf(clase.getCupo());
	textFieldCupos.setText(x);
}

}