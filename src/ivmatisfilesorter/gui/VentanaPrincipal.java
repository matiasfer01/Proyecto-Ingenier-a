package ivmatisfilesorter.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		proyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/proyecto.png")));
		proyecto.setToolTipText("Realiza diversas operaciones relacionadas con proyectos");

		gestionDelProyecto = new JMenu("Gestión del proyecto");
		gestionDelProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-proyectos.png")));
		gestionDelProyecto
				.setToolTipText("Engloba diversas operaciones relacionadas con el manejo de archivos y etiquetas");

		ayuda = new JMenu("Ayuda");
		ayuda.setToolTipText("Muestra información acerca de la aplicación IvMatIs FileSorter y sus créditos");
		ayuda.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/ayuda.png")));

		/* sub menus de Proyecto */
		crearProyecto = new JMenuItem("Crear proyecto");
		crearProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/crear.png")));
		crearProyecto.setToolTipText("Inicia la creación de un nuevo proyecto");

		abrirProyecto = new JMenuItem("Abrir proyecto");
		abrirProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png")));
		abrirProyecto.setToolTipText("Accede a proyectos previamente guardados");

		propiedadesDelProyecto = new JMenuItem("Propiedades del proyecto");
		propiedadesDelProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));
		propiedadesDelProyecto.setToolTipText("Realiza modificaciones en la información del proyecto");

		salir = new JMenuItem("Salir");
		salir.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/salir.png")));
		salir.setToolTipText("Cierra la aplicación");

		/* sub menus de Gestion del proyecto */
		gestionDeArchivos = new JMenuItem("Gestión de archivos");
		gestionDeArchivos
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));
		gestionDeArchivos.setToolTipText("Asigna las etiquetas seleccionadas al archivo");

		gestionDeEtiquetas = new JMenuItem("Gestión de etiquetas");
		gestionDeEtiquetas
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));
		gestionDeEtiquetas.setToolTipText("Gestiona las etiquetas almacenadas en el sistema");

		busquedaDeArchivos = new JMenuItem("Búsqueda de archivos");
		busquedaDeArchivos.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));
		busquedaDeArchivos.setToolTipText("Busca archivos según las etiquetas seleccionadas");

		/* sub menus de ayuda */

		acercaDe = new JMenuItem("Acerca de...");
		acercaDe.setToolTipText("Ofrece ayuda relacionada con la aplicación");
		acercaDe.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/acercaDe.png")));
		

		manualDeUsuario = new JMenuItem("Manual de usuario");
		manualDeUsuario.setToolTipText("Accede a instrucciones detalladas sobre el uso de la aplicación");
		manualDeUsuario.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/manual.png")));

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
		gestionDeArchivos.addActionListener(new ClaseAnonima());
		gestionDeEtiquetas.addActionListener(new ClaseAnonima());
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
			if (e.getSource().equals(crearProyecto)) {
				DialogoCrearProyecto dialogoCrearProyecto = new DialogoCrearProyecto(VentanaPrincipal.this, null);
				dialogoCrearProyecto.setVisible(true);
			} else if (e.getSource().equals(propiedadesDelProyecto)) {
				DialogoPropiedadesProyecto dialogoPropiedades = new DialogoPropiedadesProyecto(VentanaPrincipal.this,
						null);
				dialogoPropiedades.setVisible(true);
			} else if (e.getSource().equals(gestionDeArchivos)) {
				DialogoGestionArchivo dialogoGestionArchivos = new DialogoGestionArchivo(VentanaPrincipal.this, null);
				dialogoGestionArchivos.setVisible(true);
			} else if (e.getSource().equals(gestionDeEtiquetas)) {
				DialogoGestionEtiquetas dialogoGestionEtiquetas = new DialogoGestionEtiquetas(VentanaPrincipal.this,
						null);
				dialogoGestionEtiquetas.setVisible(true);
			}

		}

	}

}
