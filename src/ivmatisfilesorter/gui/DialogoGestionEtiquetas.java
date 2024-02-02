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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import ivmatisfilesorter.dominio.Etiqueta;

public class DialogoGestionEtiquetas extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField etiqueta;
	private JList<String> listaEtiquetas;
	private JScrollPane scrollpaneEtiquetas;
	private JButton nuevo;
	private JButton guardar;
	private JButton modificar;
	private JButton eliminar;
	private JButton cancelar;
	private Action accionBotonNuevo;
	private Action accionBotonGuardar;
	private Action accionBotonModificar;
	private Action accionBotonEliminar;
	private Action accionBotonCancelar;
	private DefaultListModel<String> listaEtiquetasModel = new DefaultListModel<>();
	private Etiqueta listaEtiqueta[];

	public DialogoGestionEtiquetas(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de etiquetas", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetas = new JLabel("Etiqueta: ");
		etiquetas.setBounds(230, 20, 150, 50);
		etiquetas.setDisplayedMnemonic(KeyEvent.VK_E);

		etiqueta = new JTextField();
		etiqueta.setBounds(400, 30, 250, 30);
		etiqueta.setToolTipText("Nombre de la etiqueta");

		JLabel etiquetasLista = new JLabel("Lista de etiquetas: ");
		etiquetasLista.setBounds(230, 150, 250, 30);
		etiquetasLista.setDisplayedMnemonic(KeyEvent.VK_L);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(400, 150, 250, 250);
		listaEtiquetas.setToolTipText("Lista de etiquetas existentes");

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(400, 150, 250, 250);

		listaEtiquetasModel = new DefaultListModel<>();
		listaEtiquetasModel.addElement("Diversión");
		listaEtiquetasModel.addElement("Trabajo en equipo");
		listaEtiquetasModel.addElement("Proyecto personal");
		listaEtiquetasModel.addElement("Vacaciones");
		listaEtiquetasModel.addElement("Prioridad alta");
		listaEtiquetasModel.addElement("Fiesta");
		listaEtiquetasModel.addElement("Revisión de código");
		listaEtiquetasModel.addElement("Metas a corto plazo");
		listaEtiquetasModel.addElement("Investigación");
		listaEtiquetasModel.addElement("Recomendaciones");
		listaEtiquetasModel.addElement("Clientes");
		listaEtiquetasModel.addElement("Deportes");
		listaEtiquetasModel.addElement("Creatividad");
		listaEtiquetasModel.addElement("Comida");
		listaEtiquetasModel.addElement("Viaje de negocios");
		listaEtiquetasModel.addElement("Música");
		listaEtiquetasModel.addElement("Celebración");
		listaEtiquetasModel.addElement("Investigación científica");
		listaEtiquetasModel.addElement("Lista de deseos");
		listaEtiquetasModel.addElement("Organización");
		listaEtiquetasModel.addElement("Reunión familiar");

		/*
		 * La accionBotonNuevo está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método nuevaEtiqueta().
		 */
		accionBotonNuevo = new AbstractAction("Nuevo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/nuevo.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevaEtiqueta();

			}
		};
		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método guardarEtiqueta().
		 */
		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarEtiqueta();

			}
		};
		/*
		 * La accionBotonModificar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método modificarEtiqueta().
		 */
		accionBotonModificar = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				modificarEtiqueta();
			}
		};
		/*
		 * La accionBotonEliminar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método eliminarEtiqueta().
		 */
		accionBotonEliminar = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				eliminarEtiqueta();
			}
		};
		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método cancelarEtiqueta().
		 */
		accionBotonCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarEtiqueta();
			}
		};
		nuevo = new JButton(accionBotonNuevo);
		accionBotonNuevo.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		accionBotonNuevo.putValue(Action.SHORT_DESCRIPTION, "Permite crear una nueva etiqueta.");
		accionBotonNuevo.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_N));
		nuevo.getActionMap().put("Nuevo", accionBotonNuevo);
		nuevo.setHorizontalTextPosition(JButton.TRAILING);
		nuevo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonNuevo.getValue(Action.ACCELERATOR_KEY), "Nuevo");
		nuevo.setBounds(140, 465, 120, 50);

		guardar = new JButton(accionBotonGuardar);
		accionBotonGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonGuardar.putValue(Action.SHORT_DESCRIPTION, "Guarda cambios realizados.");
		accionBotonGuardar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_G);
		guardar.getActionMap().put("Guardar", accionBotonGuardar);
		guardar.setHorizontalTextPosition(JButton.TRAILING);
		guardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonGuardar.getValue(Action.ACCELERATOR_KEY), "Guardar");
		guardar.setBounds(270, 465, 120, 50);

		modificar = new JButton(accionBotonModificar);
		accionBotonModificar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		accionBotonModificar.putValue(Action.SHORT_DESCRIPTION, "Modifica la etiqueta seleccionada.");
		accionBotonModificar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_M);
		modificar.getActionMap().put("Modificar", accionBotonModificar);
		modificar.setHorizontalTextPosition(JButton.TRAILING);
		modificar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonModificar.getValue(Action.ACCELERATOR_KEY), "Modificar");
		modificar.setBounds(400, 465, 125, 50);

		eliminar = new JButton(accionBotonEliminar);
		accionBotonEliminar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		accionBotonEliminar.putValue(Action.SHORT_DESCRIPTION, "Elimina la etiqueta seleccionada.");
		accionBotonEliminar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
		eliminar.getActionMap().put("Eliminar", accionBotonEliminar);
		eliminar.setHorizontalTextPosition(JButton.TRAILING);
		eliminar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonEliminar.getValue(Action.ACCELERATOR_KEY), "Eliminar");
		eliminar.setBounds(535, 465, 120, 50);

		cancelar = new JButton(accionBotonCancelar);
		accionBotonCancelar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionBotonCancelar.putValue(Action.SHORT_DESCRIPTION, "Cancela la edición de la etiqueta.");
		accionBotonCancelar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		cancelar.getActionMap().put("Cancelar", accionBotonCancelar);
		cancelar.setHorizontalTextPosition(JButton.TRAILING);
		cancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonCancelar.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		cancelar.setBounds(665, 465, 125, 50);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetas);
		contenido.add(etiquetasLista);
		contenido.add(etiqueta);
		listaEtiquetas.setModel(listaEtiquetasModel);
		contenido.add(scrollpaneEtiquetas);
		contenido.add(nuevo);
		contenido.add(guardar);
		contenido.add(modificar);
		contenido.add(eliminar);
		contenido.add(cancelar);

		this.add(contenido);

		this.setSize(950, 600);
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	// Permite agregar una nueva etiqueta.
	private void nuevaEtiqueta() {

	}

	// Permite guargar los cambios o las etiquetas agregadas.
	private void guardarEtiqueta() {

	}

	// Modifica la etiqueta seleccionada.
	private void modificarEtiqueta() {

	}

	// Elimina la etiqueta seleccionada definitivamente.
	private void eliminarEtiqueta() {

	}

	// Cancela los cambios efectuados.
	private void cancelarEtiqueta() {

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
