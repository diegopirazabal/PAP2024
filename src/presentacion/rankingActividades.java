package presentacion;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import logica.IControladorActividad;
import logica.ControladorActividad;
import dtos.dataTypeActividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class rankingActividades extends JInternalFrame {

    private IControladorActividad controladorActividades;
    private JTable tablaRanking;

    public rankingActividades() {

        setTitle("Ranking de Actividades");
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setClosable(true);
        
  
        // Botón para cargar el ranking de actividades
        JButton btnCargarRanking = new JButton("Cargar Ranking");
        btnCargarRanking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRankingActividades();
            }
        });
        btnCargarRanking.setBounds(10, 10, 150, 25);
        getContentPane().add(btnCargarRanking);

        // Tabla para mostrar el ranking de actividades
        tablaRanking = new JTable();
        tablaRanking.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Posición", "Actividad", "Clases" }
        ));
        JScrollPane scrollPane = new JScrollPane(tablaRanking);
        scrollPane.setBounds(10, 50, 400, 200);
        getContentPane().add(scrollPane);
    }

    // Método para cargar el ranking de actividades con más clases
    public void cargarRankingActividades() {
        try {
            // Obtener lista de actividades ordenadas por la cantidad de clases
           // List<dataTypeActividad> actividades = controladorActividades.obtenerRankingActividades();

            // Limpiar la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaRanking.getModel();
            modeloTabla.setRowCount(0);

            // Llenar la tabla con los datos del ranking
//            for (int i = 0; i < actividades.size(); i++) {
//                dataTypeActividad actividad = actividades.get(i);
//               // Object[] fila = { i + 1, actividad.getNombre(), actividad.getCantidadClases() };
//                modeloTabla.addRow(fila);
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el ranking: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}