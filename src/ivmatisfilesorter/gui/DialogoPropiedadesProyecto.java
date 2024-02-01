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
	/* Botones del dialogo */
	private JButton editar;
	private JButton guardar;
	private JButton cancelar;
	private JButton nuevaEtiqueta;

	/* Accion de los botones */
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

		/* contenido del dialogo */
		JPanel contenido = new JPanel(null);

		JLabel etiquetasNombre = new JLabel("Nombre del proyecto: ");
		etiquetasNombre.setBounds(50, 30, 150, 150);
		etiquetasNombre.setDisplayedMnemonic(KeyEvent.VK_N);

		nombreProyecto = new JTextField();
		nombreProyecto.setBounds(180, 92, 150, 30);
		nombreProyecto.setToolTipText("Nombre de tú proyecto");

		JLabel etiquetaFecha = new JLabel("Fecha de creación : ");
		etiquetaFecha.setBounds(500, 92, 150, 30);
		etiquetaFecha.setDisplayedMnemonic(KeyEvent.VK_F);

		fechaDeCreacion = new JDateChooser();
		fechaDeCreacion.setBounds(650, 92, 150, 30);

		JLabel etiquetaPropietario = new JLabel("Propietario: ");
		etiquetaPropietario.setBounds(100, 240, 150, 150);
		etiquetaPropietario.setDisplayedMnemonic(KeyEvent.VK_P);

		propietario = new JTextField();
		propietario.setBounds(180, 300, 150, 30);
		propietario.setToolTipText("Nombre del propietario");

		JLabel etiquetaDescripcion = new JLabel("Descripción: ");
		etiquetaDescripcion.setBounds(500, 240, 150, 150);
		etiquetaDescripcion.setDisplayedMnemonic(KeyEvent.VK_D);

		descripcion = new JTextArea();
		descripcion.setBounds(600, 300, 300, 100);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);
		descripcion.setToolTipText("Recordatorio corto");

		/* Acciones de los botones */
		accionBotonEditar = new AbstractAction("Editar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				editarProyecto();

			}

		};

		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarProyecto();

			}

		};

		accionBotonCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarProyecto();

			}

		};

		accionBotonNuevaEtiqueta = new AbstractAction("Nueva etiqueta",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevaEtiqueta();

			}

		};
		/* Valores de Editar */

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

		/* Valores de Guardar */

		accionBotonGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonGuardar.putValue(Action.SHORT_DESCRIPTION, "Guarda los cambios");
		accionBotonGuardar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		guardar = new JButton(accionBotonGuardar);
		guardar.setHorizontalTextPosition(JButton.TRAILING);
		guardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonGuardar.getValue(Action.ACCELERATOR_KEY), "Guardar");
		guardar.setBounds(310, 465, 150, 40);

		/* Valores de Cancelar */
		accionBotonCancelar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionBotonCancelar.putValue(Action.SHORT_DESCRIPTION, "Cansela la edición del proyecto");
		accionBotonCancelar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_C));
		cancelar = new JButton(accionBotonCancelar);
		cancelar.setHorizontalTextPosition(JButton.TRAILING);
		cancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonCancelar.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		cancelar.setBounds(480, 465, 150, 40);

		/* valores de Nuevo Etiqueta */
		accionBotonNuevaEtiqueta.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
		accionBotonNuevaEtiqueta.putValue(Action.SHORT_DESCRIPTION, "Creas una nueva etiqueta");
		accionBotonNuevaEtiqueta.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_U));
		nuevaEtiqueta = new JButton(accionBotonNuevaEtiqueta);
		nuevaEtiqueta.setHorizontalTextPosition(JButton.TRAILING);
		nuevaEtiqueta.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonNuevaEtiqueta.getValue(Action.ACCELERATOR_KEY), "Nueva etiqueta");
		nuevaEtiqueta.setBounds(655, 465, 180, 40);

		/* mostras los componentes en el dialogo */
		contenido.add(etiquetasNombre);
		contenido.add(etiquetaFecha);
		contenido.add(etiquetaPropietario);
		contenido.add(etiquetaDescripcion);

		/* mostrar campos */
		contenido.add(nombreProyecto);
		contenido.add(fechaDeCreacion);
		contenido.add(propietario);
		contenido.add(descripcion);
		/* mostrar los botones */
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

	// Permite editar el proyecto
	private void editarProyecto() {

	}

	// Guarda la edicion del proyecto
	private void guardarProyecto() {

	}

	// cansela la edicion del proyecto
	private void cancelarProyecto() {

	}

	// permite crear una nueva etiqueta
	private void nuevaEtiqueta() {

	}

	// coordina acciones iniciales para establecer el estado inicial de la
	// interfaz de usuario.
	private void inicializar() {

	}

	// realiza la acción de permitir la edición o interacción con varios
	// componentes de la interfaz gráfica
	private void habilitarCampos() {

	}

	// realiza la acción de impedir la edición o interacción con varios
	// componentes de la interfaz gráfica
	private void deshabilitarCampos() {

	}

	// La política de foco se basa en el orden en el que se añadieron los
	// componentes al vector
	private void establecerPoliticaFoco() {

	}

}
