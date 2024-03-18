/*
 * Universidad del Mar campus Puerto Escondido
 * Integrantes:
 * 		Cortez Escamilla Isaac
 * 	 	Hernández Pérez Ivonne Estefanía
 * 		Matías Acevedo Luis Fernando
 * Actividad: Primer entrega de las pantallas del sistema IvMatIs FileSorter que consiste en que un proyecto puede contener múltiples 
 * archivos y los archivos contienen etiquetas que son las que organizan a los archivos.
 * Fecha de elaboración: 01/02/2024
 * 		
 * */
package ivmatisfilesorter.gui;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import ivmatisfilesorter.dominio.Proyecto;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Declaración de variables para los menú. */
	private JMenu proyecto;
	private JMenu gestionDelProyecto;
	private JMenu ayuda;

	/* Declaración de los submenús. */
	private JMenuItem crearProyecto;
	private JMenuItem abrirProyecto;
	private JMenuItem propiedadesDelProyecto;
	private JMenuItem salir;

	private JMenuItem gestionDeArchivos;
	private JMenuItem gestionDeEtiquetas;
	private JMenuItem busquedaDeArchivos;

	private JMenuItem acercaDe;
	private JMenuItem manualDeUsuario;
	
	private Proyecto IVONNE;

	private JMenuBar barraMenu;

	public VentanaPrincipal() {
		super("IvMatisFileSorter");

		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/logo.jpg")));

		/******************************************************* Menús ************************************************************/
		/* Menú Proyecto */

		proyecto = new JMenu("Proyecto");
		proyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/proyecto.png")));
		proyecto.setToolTipText("Realizar diversas operaciones relacionadas con proyectos.");
		proyecto.setMnemonic(KeyEvent.VK_O);

		/* Menú Gestión del proyecto. */

		gestionDelProyecto = new JMenu("Gestión del proyecto");
		gestionDelProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-proyectos.png")));
		gestionDelProyecto
				.setToolTipText("Englobar diversas operaciones relacionadas con el manejo de archivos y etiquetas.");
		gestionDelProyecto.setMnemonic(KeyEvent.VK_T);

		/* Menú Ayuda. */

		ayuda = new JMenu("Ayuda");
		ayuda.setToolTipText("Mostrar información acerca de la aplicación IvMatIs FileSorter y sus créditos");
		ayuda.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/ayuda.png")));
		ayuda.setMnemonic(KeyEvent.VK_Y);

		/******************************************************* Submenús ************************************************************/

		/***** Menú proyecto. ******/

		/* Submenú Crear proyecto. */

		crearProyecto = new JMenuItem("Crear proyecto");
		crearProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/crear.png")));
		crearProyecto.setToolTipText("Crear un nuevo proyecto.");
		crearProyecto.setMnemonic(KeyEvent.VK_C);
		crearProyecto.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Abrir proyecto. */

		abrirProyecto = new JMenuItem("Abrir proyecto");
		abrirProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png")));
		abrirProyecto.setToolTipText("Acceder a proyectos previamente guardados.");
		abrirProyecto.setMnemonic(KeyEvent.VK_A);
		abrirProyecto.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Propiedades del proyecto. */

		propiedadesDelProyecto = new JMenuItem("Propiedades del proyecto");
		propiedadesDelProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));
		propiedadesDelProyecto.setToolTipText("Realizar modificaciones en la información del proyecto.");
		propiedadesDelProyecto.setMnemonic(KeyEvent.VK_P);
		propiedadesDelProyecto.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Salir. */
		salir = new JMenuItem("Salir");
		salir.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/salir.png")));
		salir.setToolTipText("Cerrar la aplicación.");
		salir.setMnemonic(KeyEvent.VK_S);
		salir.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/***** Menú Gestión de proyectos. ******/

		/* Submenú Gestión de archivos. */

		gestionDeArchivos = new JMenuItem("Gestión de archivos");
		gestionDeArchivos
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));
		gestionDeArchivos.setToolTipText("Gestionar los archivos almacenados en el sistema");
		gestionDeArchivos.setMnemonic(KeyEvent.VK_G);
		gestionDeArchivos.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Gestión de etiquetas. */

		gestionDeEtiquetas = new JMenuItem("Gestión de etiquetas");
		gestionDeEtiquetas
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));
		gestionDeEtiquetas.setToolTipText("Gestionar las etiquetas almacenadas en el sistema");
		gestionDeEtiquetas.setMnemonic(KeyEvent.VK_E);
		gestionDeEtiquetas.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Búsqueda de archivos. */

		busquedaDeArchivos = new JMenuItem("Búsqueda de archivos");
		busquedaDeArchivos.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));
		busquedaDeArchivos.setToolTipText("Buscar archivos según las etiquetas seleccionadas");
		busquedaDeArchivos.setMnemonic(KeyEvent.VK_B);
		busquedaDeArchivos.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/***** Menú Ayuda. ******/

		/* Submenú Acerca de. */

		acercaDe = new JMenuItem("Acerca de...");
		acercaDe.setToolTipText("Ofrecer ayuda relacionada con la aplicación");
		acercaDe.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/acercaDe.png")));
		acercaDe.setMnemonic(KeyEvent.VK_R);
		acercaDe.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Manual de usuario. */
		manualDeUsuario = new JMenuItem("Manual de usuario");
		manualDeUsuario.setToolTipText("Acceder a instrucciones detalladas sobre el uso de la aplicación");
		manualDeUsuario.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/manual.png")));
		manualDeUsuario.setMnemonic(KeyEvent.VK_M);
		manualDeUsuario.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		// Se agregan los submenús.

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

		crearProyecto.addActionListener(new ClaseAnonima());
		abrirProyecto.addActionListener(new ClaseAnonima());
		propiedadesDelProyecto.addActionListener(new ClaseAnonima());
		gestionDeArchivos.addActionListener(new ClaseAnonima());
		gestionDeEtiquetas.addActionListener(new ClaseAnonima());
		busquedaDeArchivos.addActionListener(new ClaseAnonima());
		acercaDe.addActionListener(new ClaseAnonima());
		manualDeUsuario.addActionListener(new ClaseAnonima());
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
		this.setResizable(false);
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
			} else if (e.getSource().equals(manualDeUsuario)) {
				metodoManualDeUsuario();
			}

		}

		private void metodoAcercaDe() {
			ImageIcon logo = new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/logo.jpg"));
			String mensaje = "\n Nombre de la aplicación:\n IvMatIsFileSorter \n\n Realizado por:\n Cortez Escamilla Isaac \n Hernández "
					+ "Pérez Ivonne Estefanía \n Matías Acevedo Luis Fernando  \n\n Correo electrónico: \n Ivmatis_filesorter@gmail.com \n\n Derechos reservados UMAR  2024";

			JOptionPane.showMessageDialog(null, mensaje, "Acerca de... IvMatIsFileSorter",
					JOptionPane.INFORMATION_MESSAGE, logo);
		}

	}

	private void metodoManualDeUsuario() {
		File archivo = new File("src/IvMatisFileSorte.pdf");
		if (archivo.exists()) {
			try {
				Desktop.getDesktop().open(archivo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,
						"El sistema no pudo abrir el manual, favor de contactar con soporte técnico",
						"Error al abrir el manual", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"El sistema no pudo encontrar el manual, favor de contactar con soporte técnico",
					"Error al encontrar el manual", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Agrega los valores por defecto a los componentes que lo requieran.
	private void inicializar() {

	}

	// Realiza la acción de permitir la edición o interacción con varios
	// componentes.
	private void habilitarCampos() {

	}

	// Realiza la acción de impedir la edición o interacción con varios
	// componentes.
	private void deshabilitarCampos() {

	}

	// Añade los componentes en orden al vector.
	private void establecerPoliticaFoco() {

	}

	private Proyecto getProyectoACrear() {
		return IVONNE;
	}

	private void setProyectoACrear(Proyecto proyectoACrear) {
		this.IVONNE = proyectoACrear;
	}

}
