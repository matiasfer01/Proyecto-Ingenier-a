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

	private JTextField nombreProyecto;
	private JTextField propietario;
	private JDateChooser fechaDeCreacion;
	private JTextArea descripcion;
	private JScrollPane scrollpaneDescripcion;
	private JButton editar;
	private JButton guardar;
	private JButton cancelar;
	private JButton nuevaEtiqueta;
	private Action accionBotonEditar;
	private Action accionBotonGuardar;
	private Action accionBotonCancelar;
	private Action accionBotonNuevaEtiqueta;

	private Proyecto proyecto[];

	public DialogoPropiedadesProyecto(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		// TODO Auto-generated constructor stub
		super(parent, "Propiedades del proyecto", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetasNombre = new JLabel("Nombre del proyecto*: ");
		etiquetasNombre.setBounds(50, 30, 150, 150);
		etiquetasNombre.setDisplayedMnemonic(KeyEvent.VK_N);

		nombreProyecto = new JTextField();
		nombreProyecto.setBounds(180, 92, 150, 30);
		nombreProyecto.setToolTipText("Ingresar el nombre del proyecto");

		JLabel etiquetaFecha = new JLabel("*Fecha de creación: ");
		etiquetaFecha.setBounds(500, 92, 150, 30);
		etiquetaFecha.setDisplayedMnemonic(KeyEvent.VK_F);

		fechaDeCreacion = new JDateChooser();
		fechaDeCreacion.setBounds(650, 92, 150, 30);

		JLabel etiquetaPropietario = new JLabel("*Propietario: ");
		etiquetaPropietario.setBounds(100, 240, 150, 150);
		etiquetaPropietario.setDisplayedMnemonic(KeyEvent.VK_P);

		propietario = new JTextField();
		propietario.setBounds(180, 300, 150, 30);
		propietario.setToolTipText("Ingresar el nombre del propietario del proyecto.");

		JLabel etiquetaDescripcion = new JLabel("*Descripción: ");
		etiquetaDescripcion.setBounds(500, 240, 150, 150);
		etiquetaDescripcion.setDisplayedMnemonic(KeyEvent.VK_D);

		descripcion = new JTextArea();
		descripcion.setBounds(600, 300, 300, 100);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);
		descripcion.setToolTipText("Agregar una breve descripción del proyecto. ");

		scrollpaneDescripcion = new JScrollPane(descripcion);
		scrollpaneDescripcion.setBounds(600, 300, 300, 100);

		/*
		 * La accionBotonEditar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método editarProyecto().
		 */
		accionBotonEditar = new AbstractAction("Editar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				editarProyecto();

			}

		};

		editar = new JButton(accionBotonEditar);
		accionBotonEditar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		accionBotonEditar.putValue(Action.SHORT_DESCRIPTION, "Editar el proyecto");
		accionBotonEditar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_E));
		editar.getActionMap().put("Editar", accionBotonEditar);
		editar.setHorizontalTextPosition(JButton.TRAILING);
		editar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonEditar.getValue(Action.ACCELERATOR_KEY), "Editar");
		editar.setBounds(170, 465, 120, 40);

		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método guardarProyecto().
		 */
		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarProyecto();

			}

		};

		guardar = new JButton(accionBotonGuardar);
		accionBotonGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonGuardar.putValue(Action.SHORT_DESCRIPTION, "Guardar los cambios");
		accionBotonGuardar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		guardar.getActionMap().put("Guardar", accionBotonGuardar);
		guardar.setHorizontalTextPosition(JButton.TRAILING);
		guardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonGuardar.getValue(Action.ACCELERATOR_KEY), "Guardar");
		guardar.setBounds(310, 465, 150, 40);

		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método cancelarProyecto().
		 */
		accionBotonCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarProyecto();

			}

		};

		cancelar = new JButton(accionBotonCancelar);
		accionBotonCancelar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionBotonCancelar.putValue(Action.SHORT_DESCRIPTION, "Cancelar la edición del proyecto");
		accionBotonCancelar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
		cancelar.getActionMap().put("Cancelar", accionBotonCancelar);
		cancelar.setHorizontalTextPosition(JButton.TRAILING);
		cancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonCancelar.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		cancelar.setBounds(480, 465, 150, 40);

		/*
		 * La accionBotonNuevaEtiqueta está asociada al botón. Cuando se ejecuta
		 * se manda a llamar al método nuevaEtiqueta().
		 */

		accionBotonNuevaEtiqueta = new AbstractAction("Nueva etiqueta",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevaEtiqueta();

			}

		};

		nuevaEtiqueta = new JButton(accionBotonNuevaEtiqueta);
		accionBotonNuevaEtiqueta.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		accionBotonNuevaEtiqueta.putValue(Action.SHORT_DESCRIPTION, "Crear una nueva etiqueta");
		accionBotonNuevaEtiqueta.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_U));
		nuevaEtiqueta.getActionMap().put("Nueva etiqueta", accionBotonNuevaEtiqueta);
		nuevaEtiqueta.setHorizontalTextPosition(JButton.TRAILING);
		nuevaEtiqueta.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonNuevaEtiqueta.getValue(Action.ACCELERATOR_KEY), "Nueva etiqueta");
		nuevaEtiqueta.setBounds(650, 465, 155, 40);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetasNombre);
		contenido.add(etiquetaFecha);
		contenido.add(etiquetaPropietario);
		contenido.add(etiquetaDescripcion);
		contenido.add(nombreProyecto);
		contenido.add(fechaDeCreacion);
		contenido.add(propietario);
		// contenido.add(descripcion);
		contenido.add(scrollpaneDescripcion);
		contenido.add(editar);
		contenido.add(guardar);
		contenido.add(cancelar);
		contenido.add(nuevaEtiqueta);

		nuevaEtiqueta.addActionListener(new ClaseAnonima());

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
			if (e.getSource().equals(nuevaEtiqueta)) {
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
