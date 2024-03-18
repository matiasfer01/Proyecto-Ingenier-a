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

public class DialogoVentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* Declaración de variables para los menú. */
	private JMenu menuProyecto;
	private JMenu menuGestionProyecto;
	private JMenu menuAyuda;

	/* Declaración de los submenús. */
	private JMenuItem submenuCrearProyecto;
	private JMenuItem submenuAbrirProyecto;
	private JMenuItem submenuPropiedadesDelProyecto;
	private JMenuItem submenuSalir;

	private JMenuItem submenuGestionDeArchivos;
	private JMenuItem submenuGestionDeEtiquetas;
	private JMenuItem submenuBusquedaDeArchivos;

	private JMenuItem submenuAcercaDe;
	private JMenuItem submenuManualDeUsuario;

	private Proyecto crearProyecto;

	private JMenuBar barraMenu;

	public DialogoVentanaPrincipal() {
		super("IvMatisFileSorter");

		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/logo.jpg")));

		/*******************************************************
		 * Menús
		 ************************************************************/
		/* Menú Proyecto */

		menuProyecto = new JMenu("Proyecto");
		menuProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/proyecto.png")));
		menuProyecto.setToolTipText("Realizar diversas operaciones relacionadas con proyectos.");
		menuProyecto.setMnemonic(KeyEvent.VK_O);

		/* Menú Gestión del proyecto. */

		menuGestionProyecto = new JMenu("Gestión del proyecto");
		menuGestionProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-proyectos.png")));
		menuGestionProyecto
				.setToolTipText("Englobar diversas operaciones relacionadas con el manejo de archivos y etiquetas.");
		menuGestionProyecto.setMnemonic(KeyEvent.VK_T);

		/* Menú Ayuda. */

		menuAyuda = new JMenu("Ayuda");
		menuAyuda.setToolTipText("Mostrar información acerca de la aplicación IvMatIs FileSorter y sus créditos");
		menuAyuda.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/ayuda.png")));
		menuAyuda.setMnemonic(KeyEvent.VK_Y);

		/*******************************************************
		 * Submenús
		 ************************************************************/

		/***** Menú proyecto. ******/

		/* Submenú Crear proyecto. */

		submenuCrearProyecto = new JMenuItem("Crear proyecto");
		submenuCrearProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/crear.png")));
		submenuCrearProyecto.setToolTipText("Crear un nuevo proyecto.");
		submenuCrearProyecto.setMnemonic(KeyEvent.VK_C);
		submenuCrearProyecto.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Abrir proyecto. */

		submenuAbrirProyecto = new JMenuItem("Abrir proyecto");
		submenuAbrirProyecto.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png")));
		submenuAbrirProyecto.setToolTipText("Acceder a proyectos previamente guardados.");
		submenuAbrirProyecto.setMnemonic(KeyEvent.VK_A);
		submenuAbrirProyecto.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Propiedades del proyecto. */

		submenuPropiedadesDelProyecto = new JMenuItem("Propiedades del proyecto");
		submenuPropiedadesDelProyecto
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));
		submenuPropiedadesDelProyecto.setToolTipText("Realizar modificaciones en la información del proyecto.");
		submenuPropiedadesDelProyecto.setMnemonic(KeyEvent.VK_P);
		submenuPropiedadesDelProyecto.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Salir. */
		submenuSalir = new JMenuItem("Salir");
		submenuSalir.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/salir.png")));
		submenuSalir.setToolTipText("Cerrar la aplicación.");
		submenuSalir.setMnemonic(KeyEvent.VK_S);
		submenuSalir.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/***** Menú Gestión de proyectos. ******/

		/* Submenú Gestión de archivos. */

		submenuGestionDeArchivos = new JMenuItem("Gestión de archivos");
		submenuGestionDeArchivos
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));
		submenuGestionDeArchivos.setToolTipText("Gestionar los archivos almacenados en el sistema");
		submenuGestionDeArchivos.setMnemonic(KeyEvent.VK_G);
		submenuGestionDeArchivos.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Gestión de etiquetas. */

		submenuGestionDeEtiquetas = new JMenuItem("Gestión de etiquetas");
		submenuGestionDeEtiquetas
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));
		submenuGestionDeEtiquetas.setToolTipText("Gestionar las etiquetas almacenadas en el sistema");
		submenuGestionDeEtiquetas.setMnemonic(KeyEvent.VK_E);
		submenuGestionDeEtiquetas.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Búsqueda de archivos. */

		submenuBusquedaDeArchivos = new JMenuItem("Búsqueda de archivos");
		submenuBusquedaDeArchivos
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));
		submenuBusquedaDeArchivos.setToolTipText("Buscar archivos según las etiquetas seleccionadas");
		submenuBusquedaDeArchivos.setMnemonic(KeyEvent.VK_B);
		submenuBusquedaDeArchivos.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/***** Menú Ayuda. ******/

		/* Submenú Acerca de. */

		submenuAcercaDe = new JMenuItem("Acerca de...");
		submenuAcercaDe.setToolTipText("Ofrecer ayuda relacionada con la aplicación");
		submenuAcercaDe.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/acercaDe.png")));
		submenuAcercaDe.setMnemonic(KeyEvent.VK_R);
		submenuAcercaDe.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		/* Submenú Manual de usuario. */
		submenuManualDeUsuario = new JMenuItem("Manual de usuario");
		submenuManualDeUsuario.setToolTipText("Acceder a instrucciones detalladas sobre el uso de la aplicación");
		submenuManualDeUsuario.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/manual.png")));
		submenuManualDeUsuario.setMnemonic(KeyEvent.VK_M);
		submenuManualDeUsuario.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK + InputEvent.ALT_DOWN_MASK));

		// Se agregan los submenús.

		menuProyecto.add(submenuCrearProyecto);
		menuProyecto.add(submenuAbrirProyecto);
		menuProyecto.add(submenuPropiedadesDelProyecto);
		menuProyecto.addSeparator();
		menuProyecto.add(submenuSalir);

		menuGestionProyecto.add(submenuGestionDeArchivos);
		menuGestionProyecto.add(submenuGestionDeEtiquetas);
		menuGestionProyecto.add(submenuBusquedaDeArchivos);

		menuAyuda.add(submenuAcercaDe);
		menuAyuda.add(submenuManualDeUsuario);

		submenuCrearProyecto.addActionListener(new ClaseAnonima());
		submenuAbrirProyecto.addActionListener(new ClaseAnonima());
		submenuPropiedadesDelProyecto.addActionListener(new ClaseAnonima());
		submenuGestionDeArchivos.addActionListener(new ClaseAnonima());
		submenuGestionDeEtiquetas.addActionListener(new ClaseAnonima());
		submenuBusquedaDeArchivos.addActionListener(new ClaseAnonima());
		submenuAcercaDe.addActionListener(new ClaseAnonima());
		submenuManualDeUsuario.addActionListener(new ClaseAnonima());
		submenuSalir.addActionListener(new ClaseAnonima());

		/* configurar la barra */
		barraMenu = new JMenuBar();
		barraMenu.add(menuProyecto);
		barraMenu.add(menuGestionProyecto);
		barraMenu.add(menuAyuda);
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
			if (e.getSource().equals(submenuCrearProyecto)) {
				DialogoCrearProyecto dialogoCrearProyecto = new DialogoCrearProyecto(DialogoVentanaPrincipal.this,
						null);
				dialogoCrearProyecto.setVisible(true);
			} else if (e.getSource().equals(submenuPropiedadesDelProyecto)) {
				DialogoPropiedadesProyecto dialogoPropiedades = new DialogoPropiedadesProyecto(
						DialogoVentanaPrincipal.this, null);
				dialogoPropiedades.setVisible(true);
			} else if (e.getSource().equals(submenuGestionDeArchivos)) {
				DialogoGestionArchivos dialogoGestionArchivos = new DialogoGestionArchivos(DialogoVentanaPrincipal.this,
						null);
				dialogoGestionArchivos.setVisible(true);
			} else if (e.getSource().equals(submenuGestionDeEtiquetas)) {
				DialogoGestionEtiquetas dialogoGestionEtiquetas = new DialogoGestionEtiquetas(
						DialogoVentanaPrincipal.this, null);
				dialogoGestionEtiquetas.setVisible(true);
			} else if (e.getSource().equals(submenuBusquedaDeArchivos)) {
				DialogoBusquedaArchivos dialogoBusquedaArchivos = new DialogoBusquedaArchivos(
						DialogoVentanaPrincipal.this, null);
				dialogoBusquedaArchivos.setVisible(true);
			} else if (e.getSource().equals(submenuAcercaDe)) {
				metodoAcercaDe();
			} else if (e.getSource().equals(submenuManualDeUsuario)) {
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
		return crearProyecto;
	}

	private void setProyectoACrear(Proyecto proyectoACrear) {
		this.crearProyecto = proyectoACrear;
	}

}
