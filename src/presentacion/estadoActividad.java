package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		getContentPane().setLayout(null);
		
        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Cambiar Estado de Actividad");
        setBounds(10, 40, 477, 357);
		
		comboBoxActividades = new JComboBox<dataTypeActividad>();
		comboBoxActividades.setBounds(153, 39, 290, 21);
		getContentPane().add(comboBoxActividades);	
		    
		
		JLabel lblNewLabel = new JLabel("Actividades");
		lblNewLabel.setBounds(65, 43, 78, 17);
		getContentPane().add(lblNewLabel);
		
        estadoActividad = new ButtonGroup();
        
JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar");
rdbtnConfirmar.setBounds(159, 219, 75, 25);
getContentPane().add(rdbtnConfirmar);
estadoActividad.add(rdbtnConfirmar);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(312, 281, 143, 21);
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
	            	if (rdbtnConfirmar.isSelected())
	            		aux.setEstado(true);
	            		else aux.setEstado(false);
	            }
            }
        });
                
        JRadioButton rdbtnRechazar = new JRadioButton("Rechazar");
        rdbtnRechazar.setBounds(259, 221, 71, 21);
        getContentPane().add(rdbtnRechazar);
        estadoActividad.add(rdbtnRechazar);
getContentPane().add(btnAceptar);
        
                JButton btnCancelar = new JButton("Cancelar");
                    btnCancelar.setBounds(159, 281, 143, 21);
                    btnCancelar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setVisible(false);
                        }
                    });
                    getContentPane().add(btnCancelar);
                    	}
	
	
	public void cargarActividades() {
        DefaultComboBoxModel<dataTypeActividad> model;
        try {
            List<dataTypeActividad> actividades = controlAct.listarAgregadas();
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