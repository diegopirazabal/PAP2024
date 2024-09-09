package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
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
import excepciones.ActividadNoExisteException;
import logica.Fabrica;
import logica.IControladorActividad;

public class listarActividades extends JInternalFrame {
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private JComboBox<dataTypeActividad> comboBoxActividades;
	private JTextField textFieldBuscador;
	private JTextField textFieldDescripcion;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldLugar;
	private JTextField textFieldEntrenadorDesignado;
	public listarActividades(IControladorActividad ControlAct) {
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar una Actividad");
        setBounds(300, 300, 406, 272);
        getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		comboBoxActividades = new JComboBox<dataTypeActividad>();
		comboBoxActividades.setBounds(151, 7, 257, 22);
		getContentPane().add(comboBoxActividades);
		comboBoxActividades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
                if (seleccionada != null) {
                    completarCampos(seleccionada);
                }
            }
        });
		
		JLabel lblNewLabel = new JLabel("Actividades Registradas");
		lblNewLabel.setBounds(29, 11, 130, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre actividad");
		lblNewLabel_1.setBounds(29, 49, 112, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(29, 139, 112, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Duracion");
		lblNewLabel_3.setBounds(29, 164, 112, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Costo");
		lblNewLabel_4.setBounds(29, 195, 112, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Lugar");
		lblNewLabel_5.setBounds(29, 234, 112, 14);
		getContentPane().add(lblNewLabel_5);
		
		textFieldBuscador = new JTextField();
		textFieldBuscador.setBounds(151, 43, 257, 20);
		getContentPane().add(textFieldBuscador);
		textFieldBuscador.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setBounds(151, 140, 257, 20);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setEditable(false);
		textFieldDuracion.setBounds(151, 165, 257, 20);
		getContentPane().add(textFieldDuracion);
		textFieldDuracion.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setBounds(151, 196, 257, 20);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setEditable(false);
		textFieldLugar.setBounds(151, 232, 257, 20);
		getContentPane().add(textFieldLugar);
		textFieldLugar.setColumns(10);
		JLabel lblNewLabel_2_1 = new JLabel("Entrenador Designado");
		lblNewLabel_2_1.setBounds(29, 109, 112, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		textFieldEntrenadorDesignado = new JTextField();
		textFieldEntrenadorDesignado.setEditable(false);
		textFieldEntrenadorDesignado.setColumns(10);
		textFieldEntrenadorDesignado.setBounds(151, 109, 257, 20);
		getContentPane().add(textFieldEntrenadorDesignado);
		
		JButton btnMostrarDetalles = new JButton("Mostrar Detalles");
		btnMostrarDetalles.setBounds(193, 75, 166, 23);
		btnMostrarDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cmdBuscarActividadActionPerformed(e);
			}
		});
		getContentPane().add(btnMostrarDetalles);
		
		JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(212, 263, 132, 21);
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        getContentPane().add(btnLimpiar);
		cargarActividades();
	}
	
	private void cmdBuscarActividadActionPerformed(ActionEvent e) {
        dataTypeActividad da;
        if(checkFormulario()) {
        try {
            da = controlAct.consultarActividad(textFieldBuscador.getText());
            completarCampos(da);
        } catch (ActividadNoExisteException e1) {
        	String z = this.textFieldBuscador.getText();
        	if (z == null)
        		JOptionPane.showMessageDialog(this, "Ingrese un entrenador", "Consultar Actividad",
	                    JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Usuario", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
        }
    }
	private boolean checkFormulario() {
        String nombreU = this.textFieldBuscador.getText();

	        if (nombreU.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Consultar Actividad",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        
        }
        
       return true;
    }
	private void limpiarCampos() {
        textFieldEntrenadorDesignado.setText("");
        textFieldLugar.setText("");
        textFieldDuracion.setText("");
        textFieldDescripcion.setText("");
        textFieldCosto.setText("");
        //textFieldBuscador.setText("");
    }
	
	private void completarCampos(dataTypeActividad actividad) {
        if (actividad != null) {
            textFieldEntrenadorDesignado.setText(actividad.getEntrenadorId().getNombre());
            textFieldLugar.setText(actividad.getLugar());
            String x = String.valueOf(actividad.getDuracion());
            textFieldDuracion.setText(x);
            String y = String.valueOf(actividad.getCosto());
            textFieldCosto.setText(y);
            textFieldDescripcion.setText(actividad.getDescripcion());
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

}

