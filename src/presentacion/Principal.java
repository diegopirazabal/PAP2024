package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;
import logica.IControladorActividad;
import logica.IControladorUsuario;

public class Principal {
	 private JFrame frmGestionDeUsuarios;    
	 private IControladorUsuario controlUsr = Fabrica.getInstance().getIControladorUsuario();
	 private IControladorActividad controlAct = Fabrica.getInstance().getIControladorActividad();

	 // Nuevas ventanas internas
	 private altaUsuario altUsrInternalFrame;
	 private ListarUsuarios listUsrInternalFrame;
	 private desplegarDatosUsuario despUsrInternalFrame;
	 private altaActividad altActInternalFrame;
	 private listarActividades consActInternalFrame;
	 private AltaClase altClaInternalFrame;
	 private rankingActividades rankActInternalFrame;
	 private consultaClase consClaInternalFrame;
	 private InscripcionClase insClaInternalFrame;
	 
	 
	 public static void main(String[] args) {
	    	System.out.print("Entre al main");
	        EventQueue.invokeLater(new Runnable() {  
	            public void run() {                 
	                try {
	                    Principal window = new Principal();   
	                    window.frmGestionDeUsuarios.setVisible(true); 
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	 }
	 
	 public Principal(){
		 initialize();
		 Fabrica fabrica = Fabrica.getInstance(); 
		 controlUsr = fabrica.getIControladorUsuario();
	     
	     altUsrInternalFrame = new altaUsuario(controlUsr);
	     altUsrInternalFrame.setLocation(30, 35);
	     altUsrInternalFrame.setVisible(false);
	     
	     consActInternalFrame = new listarActividades(controlAct);
	     consActInternalFrame.setLocation(30, 35);
	     consActInternalFrame.setVisible(false);
	     
	     listUsrInternalFrame = new ListarUsuarios(controlUsr);
	     listUsrInternalFrame.setLocation(30, 35);
	     listUsrInternalFrame.setVisible(false);
	     
	     despUsrInternalFrame = new desplegarDatosUsuario(controlUsr);
	     despUsrInternalFrame.setLocation(30, 35);
	     despUsrInternalFrame.setVisible(false);
	     
		 altActInternalFrame = new altaActividad(controlAct, controlUsr); 
	     altActInternalFrame.setLocation(30, 35);
	     altActInternalFrame.setVisible(false);
	     
	     altClaInternalFrame = new AltaClase(); 
	     altClaInternalFrame.setLocation(30, 35);
	     altClaInternalFrame.setVisible(false);
	     
	     consClaInternalFrame = new consultaClase(); 
	     consClaInternalFrame.setLocation(30, 35);
	     consClaInternalFrame.setVisible(false);
	     
	     insClaInternalFrame = new InscripcionClase(); 
	     insClaInternalFrame.setLocation(30, 35);
	     insClaInternalFrame.setVisible(false);
	     
	     rankActInternalFrame = new rankingActividades(); 
	     rankActInternalFrame.setLocation(30, 35);
	     rankActInternalFrame.setVisible(false);
	     
	     frmGestionDeUsuarios.getContentPane().add(altUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(listUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(despUsrInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(altActInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(consActInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(altClaInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(consClaInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(insClaInternalFrame);
	     frmGestionDeUsuarios.getContentPane().add(rankActInternalFrame);
	 }
	 
	 private void initialize() {
		 frmGestionDeUsuarios = new JFrame();
	        frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
	        frmGestionDeUsuarios.setBounds(100, 100, 450, 400);
	        frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frmGestionDeUsuarios.setResizable(false);
	        frmGestionDeUsuarios.setSize(800, 600);

	        JMenuBar menuBar = new JMenuBar();
	        frmGestionDeUsuarios.setJMenuBar(menuBar);

	        JMenu menuSistema = new JMenu("Sistema");
	        menuBar.add(menuSistema);

	        JMenuItem menuSalir = new JMenuItem("Salir");
	        menuSalir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                frmGestionDeUsuarios.setVisible(false);
	                frmGestionDeUsuarios.dispose();
	            }
	        });
	        menuSistema.add(menuSalir);

	        JMenu menuUsuarios = new JMenu("Usuarios");
	        menuBar.add(menuUsuarios);

	        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
	        menuItemRegistrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                altUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(menuItemRegistrar);
	        
	        JMenuItem mntmListaUsuarios = new JMenuItem("Consultar Usuarios");
	        mntmListaUsuarios.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	listUsrInternalFrame.cargarUsuarios();
	            	listUsrInternalFrame.setVisible(true);
	            }
	        });
	        menuUsuarios.add(mntmListaUsuarios);
	        
//	        JMenuItem mntmConsultarUsuarios = new JMenuItem("Consultar Usuarios");
//	        mntmConsultarUsuarios.addActionListener(new ActionListener() {
//	            public void actionPerformed(ActionEvent e) {
//	            	despUsrInternalFrame.setVisible(true);
//	            }
//	        });
//	        menuUsuarios.add(mntmConsultarUsuarios);
	        
	        JMenu menuActividad = new JMenu("Actividad");
	        menuBar.add(menuActividad);
	        
	        JMenuItem mntmaltaActividad = new JMenuItem("Registrar Actividad");
	        mntmaltaActividad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	altActInternalFrame.setVisible(true);
	            	altActInternalFrame.cargarEntrenadores();
	            }
	        });
	        menuActividad.add(mntmaltaActividad);
	        
	        JMenuItem mntmconsultaActividad = new JMenuItem("Consulta Actividad");
	        mntmconsultaActividad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	consActInternalFrame.setVisible(true);
	            	consActInternalFrame.cargarActividades(); 
	            }
	        });
	        

	        menuActividad.add(mntmconsultaActividad);
	        JMenuItem mntmrankingActividades = new JMenuItem("Ranking Actividades");
	        mntmrankingActividades.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	rankActInternalFrame.setVisible(true);
	            	
	            }
	        });
	        menuActividad.add(mntmrankingActividades);
	        
	        JMenu menuClase = new JMenu("Clase");
	        menuBar.add(menuClase);
	        
	        JMenuItem mntmaltaClase = new JMenuItem("Registrar Clase");
	        mntmaltaClase.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	altClaInternalFrame.setVisible(true);
	            	//consClaInternalFrame.cargarClases();
	            	altClaInternalFrame.cargarActividades();
	            }
	        });
	        menuClase.add(mntmaltaClase);
	        
	        JMenuItem mntmconsultaClase = new JMenuItem("Consulta Clase");
	        mntmconsultaClase.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	consClaInternalFrame.setVisible(true);
	            	consClaInternalFrame.cargarActividades();
	            	//consClaInternalFrame.listarTodas();
	            }
	        });
	        menuClase.add(mntmconsultaClase);
	        
	        JMenuItem mntmInscripcionClase = new JMenuItem("Inscripcion a Clase");
	        mntmInscripcionClase.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	insClaInternalFrame.setVisible(true);
	            	insClaInternalFrame.cargarActividades();
	            	insClaInternalFrame.cargarClases();
	            }
	        });
	        menuClase.add(mntmInscripcionClase);
	    }
}