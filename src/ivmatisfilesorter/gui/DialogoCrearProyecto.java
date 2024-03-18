/*
 * Universidad del Mar campus Puerto Escondido
 * Integrantes:
 * 		Cortez Escamilla Isaac
 * 	 	Hernández Pérez Ivonne Estefanía
 * 		Matías Acevedo Luis Fernando
 * Actividad: Primera entrega de las pantallas del sistema IvMatIs FileSorter que consiste en que un proyecto puede contener múltiples 
 * archivos y los archivos contienen etiquetas que son las que organizan a los archivos.
 * Fecha de elaboración: 01/02/2024
 * 		
 * */
package ivmatisfilesorter.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.toedter.calendar.JDateChooser;

import ivmatisfilesorter.dominio.Proyecto;

public class DialogoCrearProyecto extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**/
	private JTextField campoNombreProyecto;
	private JTextField campoPropietario;
	private JDateChooser fechaCreacion;
	private JTextArea areaDescripcion;
	private JScrollPane desplazamientoDescripcion;
	private JButton botonCancelar;
	private JButton botonGuardar;

	/* Acción de los botones que se están utilizando en la ventana. */
	private Action accionBotonGuardar;
	private Action accionBotonCancelar;

	private Proyecto listaProyectosProyecto[];

	public DialogoCrearProyecto(JFrame parent, DialogoVentanaPrincipal ventanaPrincipal) {
		// TODO Auto-generated constructor stub
		super(parent, "Crear Proyecto", true);
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/crear.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetasNombre = new JLabel("*Nombre del proyecto: ");
		etiquetasNombre.setBounds(50, 30, 150, 150);
		etiquetasNombre.setDisplayedMnemonic(KeyEvent.VK_N);

		campoNombreProyecto = new JTextField();
		campoNombreProyecto.setBounds(180, 92, 150, 30);
		campoNombreProyecto.setToolTipText("Ingresar el nombre del proyecto.");

		JLabel etiquetaFecha = new JLabel("Fecha de creación: ");
		etiquetaFecha.setBounds(500, 92, 150, 30);
		etiquetaFecha.setDisplayedMnemonic(KeyEvent.VK_F);

		fechaCreacion = new JDateChooser();
		fechaCreacion.setBounds(650, 92, 150, 30);

		JLabel etiquetaPropietario = new JLabel("Propietario: ");
		etiquetaPropietario.setBounds(100, 240, 150, 150);
		etiquetaPropietario.setDisplayedMnemonic(KeyEvent.VK_P);

		campoPropietario = new JTextField();
		campoPropietario.setBounds(180, 300, 150, 30);
		campoPropietario.setToolTipText("Ingresar el nombre del propietario del proyecto.");

		JLabel etiquetaDescripcion = new JLabel("Descripción: ");
		etiquetaDescripcion.setBounds(500, 240, 150, 150);
		etiquetaDescripcion.setDisplayedMnemonic(KeyEvent.VK_D);

		areaDescripcion = new JTextArea();
		areaDescripcion.setBounds(600, 300, 300, 100);
		areaDescripcion.setLineWrap(true);
		areaDescripcion.setWrapStyleWord(true);
		areaDescripcion.setToolTipText("Agregar una breve descripción del proyecto.");

		desplazamientoDescripcion = new JScrollPane(areaDescripcion);
		desplazamientoDescripcion.setBounds(600, 300, 300, 100);

		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método guardarProyecto().
		 */
		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				guardarProyecto();
			}

		};

		botonGuardar = new JButton(accionBotonGuardar);
		accionBotonGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonGuardar.putValue(Action.SHORT_DESCRIPTION, "Guardar el proyecto");
		accionBotonGuardar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		botonGuardar.getActionMap().put("Guardar", accionBotonGuardar);
		botonGuardar.setHorizontalTextPosition(JButton.TRAILING);
		botonGuardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonGuardar.getValue(Action.ACCELERATOR_KEY), "Guardar");
		botonGuardar.setMnemonic(KeyEvent.VK_G);
		botonGuardar.setBounds(300, 465, 120, 40);

		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método cancelarProyecto().
		 */
		accionBotonCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelarProyecto();
			}
		};

		botonCancelar = new JButton(accionBotonCancelar);
		accionBotonCancelar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionBotonCancelar.putValue(Action.SHORT_DESCRIPTION, "Cancelar el proyecto");
		accionBotonCancelar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
		botonCancelar.getActionMap().put("Cancelar", accionBotonCancelar);
		botonCancelar.setHorizontalTextPosition(JButton.TRAILING);
		botonCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonCancelar.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		botonCancelar.setMnemonic(KeyEvent.VK_C);
		botonCancelar.setBounds(450, 465, 125, 40);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetasNombre);
		contenido.add(etiquetaFecha);
		contenido.add(etiquetaPropietario);
		contenido.add(etiquetaDescripcion);
		contenido.add(campoNombreProyecto);
		contenido.add(fechaCreacion);
		contenido.add(campoPropietario);
		contenido.add(desplazamientoDescripcion);
		contenido.add(botonGuardar);
		contenido.add(botonCancelar);

		this.add(contenido);

		this.setSize(950, 600);
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	// Guarda el proyecto con los componentes agregados.
	private void guardarProyecto() {

	}

	// Cancela los cambios del proyecto.
	private void cancelarProyecto() {

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

}
