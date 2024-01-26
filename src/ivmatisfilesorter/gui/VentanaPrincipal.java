package ivmatisfilesorter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Declaracion de variables para los menus */
	private JMenu proyecto;
	private JMenu gestionDelProyecto;
	private JMenu ayuda;

	/* Declaracion de los sub menus */
	private JMenuItem crearProyecto;
	private JMenuItem abrirProyecto;
	private JMenuItem propiedadesDelProyecto;
	private JMenuItem salir;

	private JMenuItem gestionDeArchivos;
	private JMenuItem gestionDeEtiquetas;
	private JMenuItem busquedaDeArchivos;

	private JMenuItem acercaDe;
	private JMenuItem manualDeUsuario;

	/* barra */
	private JMenuBar barraMenu;

	public VentanaPrincipal() {
		super("IvMatisFileSorter");

		/* Menus principales */
		proyecto = new JMenu("Proyecto");

		gestionDelProyecto = new JMenu("Gestión del proyecto");

		ayuda = new JMenu("Ayuda");

		/* sub menus de Proyecto */
		crearProyecto = new JMenuItem("Crear proyecto");

		abrirProyecto = new JMenuItem("Abrir proyecto");

		propiedadesDelProyecto = new JMenuItem("Propiedades del proyecto");

		salir = new JMenuItem("Salir");

		/* sub menus de Gestion del proyecto */
		gestionDeArchivos = new JMenuItem("Gestión de archivos");

		gestionDeEtiquetas = new JMenuItem("Gestión de etiquetas");

		busquedaDeArchivos = new JMenuItem("Búsqueda de archivos");
		
		/* sub menus de ayuda*/
		
		acercaDe = new JMenuItem("Acerca de...");
		
		manualDeUsuario = new JMenuItem("Manual de usuario");

		/* Se agregan los JMenuItem a los Menus */

		proyecto.add(crearProyecto);
		proyecto.add(abrirProyecto);
		proyecto.add(propiedadesDelProyecto);
		proyecto.addSeparator();
		proyecto.add(salir);

		gestionDelProyecto.add(gestionDeArchivos);
		gestionDelProyecto.add(gestionDeEtiquetas);
		gestionDelProyecto.add(busquedaDeArchivos);

		ayuda.add(acercaDe);
		ayuda.add(manualDeUsuario);

		/* Se agraga el ActionListener */
		crearProyecto.addActionListener(new ClaseAnonima());
		abrirProyecto.addActionListener(new ClaseAnonima());
		propiedadesDelProyecto.addActionListener(new ClaseAnonima());
		salir.addActionListener(new ClaseAnonima());

		/* configurar la barra */
		barraMenu = new JMenuBar();
		barraMenu.add(proyecto);
		barraMenu.add(gestionDelProyecto);
		barraMenu.add(ayuda);
		this.setJMenuBar(barraMenu);

		this.setSize(1700, 900);
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	class ClaseAnonima implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(crearProyecto)){
				DialogoCrearProyecto dialogoCrearProyecto = new DialogoCrearProyecto(VentanaPrincipal.this, null);
				dialogoCrearProyecto.setVisible(true);
			}else if(e.getSource().equals(propiedadesDelProyecto)) {
				DialogoPropiedadesProyecto dialogoPropiedades = new DialogoPropiedadesProyecto(VentanaPrincipal.this,null);
				dialogoPropiedades.setVisible(true);
			}
			
		}

	}

}
