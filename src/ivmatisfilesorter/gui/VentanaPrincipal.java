package ivmatisfilesorter.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ivmatisfilesorter.dominio.Proyecto;

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

	private Proyecto proyectoACrear;

	/* barra */
	private JMenuBar barraMenu;

	public VentanaPrincipal() {
		super("IvMatisFileSorter");

		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/logo.jpg")));

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
		crearProyecto.setMnemonic(KeyEvent.VK_C);

		abrirProyecto = new JMenuItem("Abrir proyecto");
		abrirProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png")));
		abrirProyecto.setToolTipText("Accede a proyectos previamente guardados");
		abrirProyecto.setMnemonic(KeyEvent.VK_A);

		propiedadesDelProyecto = new JMenuItem("Propiedades del proyecto");
		propiedadesDelProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));
		propiedadesDelProyecto.setToolTipText("Realiza modificaciones en la información del proyecto");
		propiedadesDelProyecto.setMnemonic(KeyEvent.VK_P);

		salir = new JMenuItem("Salir");
		salir.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/salir.png")));
		salir.setToolTipText("Cierra la aplicación");
		salir.setMnemonic(KeyEvent.VK_S);

		/* sub menus de Gestion del proyecto */
		gestionDeArchivos = new JMenuItem("Gestión de archivos");
		gestionDeArchivos
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));
		gestionDeArchivos.setToolTipText("Asigna las etiquetas seleccionadas al archivo");
		gestionDeArchivos.setMnemonic(KeyEvent.VK_G);

		gestionDeEtiquetas = new JMenuItem("Gestión de etiquetas");
		gestionDeEtiquetas
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));
		gestionDeEtiquetas.setToolTipText("Gestiona las etiquetas almacenadas en el sistema");
		gestionDeEtiquetas.setMnemonic(KeyEvent.VK_E);

		busquedaDeArchivos = new JMenuItem("Búsqueda de archivos");
		busquedaDeArchivos.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));
		busquedaDeArchivos.setToolTipText("Busca archivos según las etiquetas seleccionadas");
		busquedaDeArchivos.setMnemonic(KeyEvent.VK_B);

		/* sub menus de ayuda */
		acercaDe = new JMenuItem("Acerca de...");
		acercaDe.setToolTipText("Ofrece ayuda relacionada con la aplicación");
		acercaDe.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/acercaDe.png")));
		acercaDe.setMnemonic(KeyEvent.VK_A);

		manualDeUsuario = new JMenuItem("Manual de usuario");
		manualDeUsuario.setToolTipText("Accede a instrucciones detalladas sobre el uso de la aplicación");
		manualDeUsuario.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/manual.png")));
		manualDeUsuario.setMnemonic(KeyEvent.VK_M);

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
		busquedaDeArchivos.addActionListener(new ClaseAnonima());
		acercaDe.addActionListener(new ClaseAnonima());
		salir.addActionListener(new ClaseAnonima());

		/* configurar la barra */
		barraMenu = new JMenuBar();
		barraMenu.add(proyecto);
		barraMenu.add(gestionDelProyecto);
		barraMenu.add(ayuda);
		this.setJMenuBar(barraMenu);

		this.setSize(1700, 900);

		JLabel fondo = new JLabel();
		ImageIcon imagenFondo = new ImageIcon(
				getClass().getResource("/ivmatisfilesorter/imagenes/fondoIngenieria.jpg"));
		Image imagenEscalada = imagenFondo.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(imagenEscalada));
		this.getContentPane().add(fondo);
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
				DialogoGestionArchivos dialogoGestionArchivos = new DialogoGestionArchivos(VentanaPrincipal.this, null);
				dialogoGestionArchivos.setVisible(true);
			} else if (e.getSource().equals(gestionDeEtiquetas)) {
				DialogoGestionEtiquetas dialogoGestionEtiquetas = new DialogoGestionEtiquetas(VentanaPrincipal.this,
						null);
				dialogoGestionEtiquetas.setVisible(true);
			} else if (e.getSource().equals(busquedaDeArchivos)) {
				DialogoBusquedaArchivos dialogoBusquedaArchivos = new DialogoBusquedaArchivos(VentanaPrincipal.this,
						null);
				dialogoBusquedaArchivos.setVisible(true);
			} else if (e.getSource().equals(acercaDe)) {
				metodoAcercaDe();
			}

		}

		private void metodoAcercaDe() {
			ImageIcon logo = new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/logo.jpg"));
			String mensaje = "\n Nombre de la aplicacion:\n IvMatIsFileSorter \n\n Realizado por:\n Cortez Fescamilla Isaac \n Hernandez Perez Ivonne Estefania \n Matias Acevedo  Luis Fernando  \n\n Correo electrónico: \n Ivmatis_filesorter@gmail.com \n\n Derechos reservados UMAR  2023";

			JOptionPane.showMessageDialog(null, mensaje, "Acerca de... IvMatIsFileSorter",
					JOptionPane.INFORMATION_MESSAGE, logo);
		}

	}

	private void inicializar() {

	}

	private void habilitarCampos() {

	}

	private void establecerPoliticaFoco() {

	}

	private void deshabilitarCampos() {

	}

	private Proyecto getProyectoACrear() {
		return proyectoACrear;
	}

	private void setProyectoACrear(Proyecto proyectoACrear) {
		this.proyectoACrear = proyectoACrear;
	}

}
