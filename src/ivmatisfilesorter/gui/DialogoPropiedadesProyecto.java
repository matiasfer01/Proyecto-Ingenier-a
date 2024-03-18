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
import java.awt.event.ActionListener;
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

public class DialogoPropiedadesProyecto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField campoNombreProyecto;
	private JTextField campoPropietario;
	private JDateChooser fechaCreacion;
	private JTextArea areaDescripcion;
	private JScrollPane desplazamientoDescripcion;
	private JButton botonEditar;
	private JButton botonGuardar;
	private JButton botonCancelar;
	private JButton botonNuevaEtiqueta;
	private Action accionEditarBoton;
	private Action accionGuardarBoton;
	private Action accionCancelarBoton;
	private Action accionCrearNuevaBoton;

	private Proyecto listaProyectosProyecto[];

	public DialogoPropiedadesProyecto(JFrame parent, DialogoVentanaPrincipal ventanaPrincipal) {
		// TODO Auto-generated constructor stub
		super(parent, "Propiedades del proyecto", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetasNombre = new JLabel("*Nombre del proyecto*: ");
		etiquetasNombre.setBounds(50, 30, 150, 150);
		etiquetasNombre.setDisplayedMnemonic(KeyEvent.VK_N);

		campoNombreProyecto = new JTextField();
		campoNombreProyecto.setBounds(180, 92, 150, 30);
		campoNombreProyecto.setToolTipText("Ingresar el nombre del proyecto");

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
		areaDescripcion.setToolTipText("Agregar una breve descripción del proyecto. ");

		desplazamientoDescripcion = new JScrollPane(areaDescripcion);
		desplazamientoDescripcion.setBounds(600, 300, 300, 100);

		/*
		 * La accionBotonEditar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método editarProyecto().
		 */
		accionEditarBoton = new AbstractAction("Editar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				editarProyecto();

			}

		};

		botonEditar = new JButton(accionEditarBoton);
		accionEditarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		accionEditarBoton.putValue(Action.SHORT_DESCRIPTION, "Editar el proyecto");
		accionEditarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_E));
		botonEditar.getActionMap().put("Editar", accionEditarBoton);
		botonEditar.setHorizontalTextPosition(JButton.TRAILING);
		botonEditar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionEditarBoton.getValue(Action.ACCELERATOR_KEY), "Editar");
		botonEditar.setBounds(170, 465, 120, 40);

		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método guardarProyecto().
		 */
		accionGuardarBoton = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarProyecto();

			}

		};

		botonGuardar = new JButton(accionGuardarBoton);
		accionGuardarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionGuardarBoton.putValue(Action.SHORT_DESCRIPTION, "Guardar los cambios");
		accionGuardarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		botonGuardar.getActionMap().put("Guardar", accionGuardarBoton);
		botonGuardar.setHorizontalTextPosition(JButton.TRAILING);
		botonGuardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionGuardarBoton.getValue(Action.ACCELERATOR_KEY), "Guardar");
		botonGuardar.setBounds(310, 465, 150, 40);

		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método cancelarProyecto().
		 */
		accionCancelarBoton = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarProyecto();

			}

		};

		botonCancelar = new JButton(accionCancelarBoton);
		accionCancelarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionCancelarBoton.putValue(Action.SHORT_DESCRIPTION, "Cancelar la edición del proyecto");
		accionCancelarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
		botonCancelar.getActionMap().put("Cancelar", accionCancelarBoton);
		botonCancelar.setHorizontalTextPosition(JButton.TRAILING);
		botonCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionCancelarBoton.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		botonCancelar.setBounds(480, 465, 150, 40);

		/*
		 * La accionBotonNuevaEtiqueta está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método nuevaEtiqueta().
		 */

		accionCrearNuevaBoton = new AbstractAction("Nueva etiqueta",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevaEtiqueta();

			}

		};

		botonNuevaEtiqueta = new JButton(accionCrearNuevaBoton);
		accionCrearNuevaBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		accionCrearNuevaBoton.putValue(Action.SHORT_DESCRIPTION, "Crear una nueva etiqueta");
		accionCrearNuevaBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_U));
		botonNuevaEtiqueta.getActionMap().put("Nueva etiqueta", accionCrearNuevaBoton);
		botonNuevaEtiqueta.setHorizontalTextPosition(JButton.TRAILING);
		botonNuevaEtiqueta.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionCrearNuevaBoton.getValue(Action.ACCELERATOR_KEY), "Nueva etiqueta");
		botonNuevaEtiqueta.setBounds(650, 465, 155, 40);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetasNombre);
		contenido.add(etiquetaFecha);
		contenido.add(etiquetaPropietario);
		contenido.add(etiquetaDescripcion);
		contenido.add(campoNombreProyecto);
		contenido.add(fechaCreacion);
		contenido.add(campoPropietario);
		// contenido.add(descripcion);
		contenido.add(desplazamientoDescripcion);
		contenido.add(botonEditar);
		contenido.add(botonGuardar);
		contenido.add(botonCancelar);
		contenido.add(botonNuevaEtiqueta);

		botonNuevaEtiqueta.addActionListener(new ClaseAnonima());

		this.add(contenido);

		this.setSize(950, 600);
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	// Se utiliza para definir un manejador de eventos de acción.
	class ClaseAnonima implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(botonNuevaEtiqueta)) {
				DialogoGestionEtiquetas dialogoGestionEtiquetas = new DialogoGestionEtiquetas(null, null);
				dialogoGestionEtiquetas.setVisible(true);
			}

		}
	}

	// Permite editar el proyecto de acuerdo a los elementos guardados.
	private void editarProyecto() {

	}

	// Guarda los elementos del proyecto.
	private void guardarProyecto() {

	}

	// Cancela el ingreso de datos del proyecto.
	private void cancelarProyecto() {

	}

	// Crea una nueva etiqueta, este método se enlaza hasta la clase
	// DialogoGestionEtiquetas.
	private void nuevaEtiqueta() {

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
