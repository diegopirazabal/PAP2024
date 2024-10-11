package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dtos.dataTypeActividad;
import excepciones.ActividadNoExisteException;
import logica.Actividad;
import logica.Fabrica;
import logica.IControladorActividad;

public class estadoActividad  extends JInternalFrame {
	private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();
	private JComboBox<dataTypeActividad> comboBoxActividades;
    private ButtonGroup estadoActividad; 
	public estadoActividad(IControladorActividad ControlAct) {
		
		setIconifiable(true);
		getContentPane().setLayout(null);
		setResizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Cambiar el estado de una actividad");
        setBounds(10, 40, 500, 250);
		
		comboBoxActividades = new JComboBox<dataTypeActividad>();
		comboBoxActividades.setBounds(153, 39, 290, 21);
		getContentPane().add(comboBoxActividades);	
		    
		
		JLabel lblNewLabel = new JLabel("Actividades");
		lblNewLabel.setBounds(65, 43, 78, 17);
		getContentPane().add(lblNewLabel);
		
        estadoActividad = new ButtonGroup();
        
JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar");
rdbtnConfirmar.setBounds(65, 78, 171, 25);
getContentPane().add(rdbtnConfirmar);
estadoActividad.add(rdbtnConfirmar);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(300, 188, 143, 21);
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
	            dataTypeActividad seleccionada = (dataTypeActividad) comboBoxActividades.getSelectedItem();
	            Actividad aux = null;
				try {
					aux = controlAct.consultarActividad2(seleccionada.getNombre());
				} catch (ActividadNoExisteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            if (seleccionada != null) {
	            	if (rdbtnConfirmar.isSelected()) {
	            		System.out.println("FLAG -- actividad seleccionada: " + aux.getNombre());
	            		System.out.println("FLAG -- estado pre activacion actividad seleccionada: " + aux.getEstado());
	            		controlAct.activarActividad(aux);
	            		System.out.println("FLAG -- estado post activacion actividad seleccionada: " + aux.getEstado());
	            		setVisible(false);
	            		
	            		
	            	}else {
	            		controlAct.rechazarActividad(aux);
	            		setVisible(false);
	            		}
	            cargarActividades3();
	            }
            }
        });
        
       
        
        JRadioButton rdbtnRechazar = new JRadioButton("Rechazar");
        rdbtnRechazar.setBounds(295, 80, 148, 21);
        getContentPane().add(rdbtnRechazar);
        estadoActividad.add(rdbtnRechazar);
getContentPane().add(btnAceptar);
        
                JButton btnCancelar = new JButton("Cancelar");
                    btnCancelar.setBounds(153, 152, 143, 21);
                    btnCancelar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setVisible(false);
                        }
                    });
                    getContentPane().add(btnCancelar);
                    	}
	
	
	public void cargarActividades3() {
        DefaultComboBoxModel<dataTypeActividad> model;
        try {
            List<dataTypeActividad> actividades = controlAct.getAgregadas();
            
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