package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dtos.dataTypeActividad;
import dtos.dataTypeClase;
import excepciones.ActividadNoExisteException;
import excepciones.ClaseNoExisteException;
import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorClase;

public class consultaClase extends JInternalFrame {
	private JTextField textFieldLugar;
	private JTextField textFieldCupos;
	private JComboBox<dataTypeActividad> comboBoxActividades;
	private JComboBox<dataTypeClase> comboBoxClases;
	private IControladorClase controlCla = Fabrica.getInstance().getIcontroladorClase();
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private JTextField textFieldHora;
	private JTextField textFieldFecha;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblClase;
	private JLabel lblActividad;
	
	public consultaClase() {
		setResizable(true);
    	setIconifiable(true);
    	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	setClosable(true);
    	setTitle("Consultar clase");
    	setBounds(10, 40, 539, 404);
    	getContentPane().setLayout(null);
    	
    	comboBoxActividades = new JComboBox();
		comboBoxActividades.setBounds(128, 21, 198, 21);
		getContentPane().add(comboBoxActividades);
		comboBoxActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
                if (seleccionada != null) {
                	
                }
            }
        });
    	
    	comboBoxClases = new JComboBox();
    	comboBoxClases.setBounds(92, 44, 318, 22);
    	getContentPane().add(comboBoxClases);
    	comboBoxClases.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeClase seleccionada = (dataTypeClase) comboBoxClases.getSelectedItem();
                if (seleccionada != null) {
                	completarCampos(seleccionada);
                }
            }
        });
    	
    	textFieldLugar = new JTextField();
    	textFieldLugar.setEditable(false);
    	textFieldLugar.setBounds(92, 94, 318, 20);
    	getContentPane().add(textFieldLugar);
    	textFieldLugar.setColumns(10);
    	
    	textFieldCupos = new JTextField();
    	textFieldCupos.setEditable(false);
    	textFieldCupos.setBounds(92, 142, 318, 20);
    	getContentPane().add(textFieldCupos);
    	textFieldCupos.setColumns(10);
    	
    	textFieldHora = new JTextField();
    	textFieldHora.setEditable(false);
    	textFieldHora.setBounds(92, 173, 318, 20);
    	getContentPane().add(textFieldHora);
    	textFieldHora.setColumns(10);
    	
    	textFieldFecha = new JTextField();
    	textFieldFecha.setEditable(false);
    	textFieldFecha.setBounds(95, 204, 315, 20);
    	getContentPane().add(textFieldFecha);
    	textFieldFecha.setColumns(10);
    	
    	lblNewLabel = new JLabel("Lugar");
    	lblNewLabel.setBounds(10, 97, 46, 14);
    	getContentPane().add(lblNewLabel);
    	
    	lblNewLabel_1 = new JLabel("Cupos");
    	lblNewLabel_1.setBounds(10, 145, 46, 14);
    	getContentPane().add(lblNewLabel_1);
    	
    	lblNewLabel_2 = new JLabel("Hora");
    	lblNewLabel_2.setBounds(10, 176, 46, 14);
    	getContentPane().add(lblNewLabel_2);
    	
    	lblNewLabel_3 = new JLabel("Fecha");
    	lblNewLabel_3.setBounds(10, 207, 46, 14);
    	getContentPane().add(lblNewLabel_3);
    	
    	lblClase = new JLabel("Clase");
    	lblClase.setBounds(10, 48, 46, 14);
    	getContentPane().add(lblClase);
    	
    	lblActividad = new JLabel("Actividad");
    	lblActividad.setBounds(10, 24, 151, 14);
    	getContentPane().add(lblActividad);
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
	
	private void completarCampos(dataTypeClase clase) {
        if (clase != null) {
        	textFieldLugar.setText(clase.getLugar());
        	String k = String.valueOf(clase.getCupo());
        	textFieldCupos.setText(k);
        	textFieldHora.setText(clase.getHora());
        	SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
        	String f = sm.format(clase.getFecha());
        	//String strDate = sm.format(myDate);
        	textFieldFecha.setText(f);
        	
//            textFieldLugar.setText(actividad.getLugar());
//            String x = String.valueOf(actividad.getDuracion());
//            textFieldDuracion.setText(x);
//            String y = String.valueOf(actividad.getCosto());
//            textFieldCosto.setText(y);
//            textFieldDescripcion.setText(actividad.getDescripcion());
        }
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
	
}