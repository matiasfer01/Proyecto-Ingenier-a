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

	private JTextField campoEtiqueta;
	private JList<String> listaEtiquetas;
	private JScrollPane desplazamientoEtiquetas;
	private JButton botonNuevo;
	private JButton botonGuardar;
	private JButton botonModificar;
	private JButton botonEliminar;
	private JButton botonCancelar;
	private Action accionCrearNuevoBoton;
	private Action accionGuardarBoton;
	private Action accionModificarBoton;
	private Action accionEliminarBoton;
	private Action accionCancelarBoton;
	private DefaultListModel<String> listaEtiquetasModel = new DefaultListModel<>();

	private Etiqueta listaEtiquetasEtiqueta[];

	public DialogoGestionEtiquetas(JFrame parent, DialogoVentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de etiquetas", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetas = new JLabel("Etiqueta: ");
		etiquetas.setBounds(230, 20, 150, 50);
		etiquetas.setDisplayedMnemonic(KeyEvent.VK_E);

		campoEtiqueta = new JTextField();
		campoEtiqueta.setBounds(400, 30, 250, 30);
		campoEtiqueta.setToolTipText("Identificador de la etiqueta");

		JLabel etiquetasLista = new JLabel("Lista de etiquetas: ");
		etiquetasLista.setBounds(230, 150, 250, 30);
		etiquetasLista.setDisplayedMnemonic(KeyEvent.VK_L);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(400, 150, 250, 250);
		listaEtiquetas.setToolTipText("Catálogo de etiquetas");

		desplazamientoEtiquetas = new JScrollPane(listaEtiquetas);
		desplazamientoEtiquetas.setBounds(400, 150, 250, 250);

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
		 * La accionBotonNuevo está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método nuevaEtiqueta().
		 */

		accionCrearNuevoBoton = new AbstractAction("Nuevo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/nuevo.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevaEtiqueta();

			}
		};

		botonNuevo = new JButton(accionCrearNuevoBoton);
		accionCrearNuevoBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		accionCrearNuevoBoton.putValue(Action.SHORT_DESCRIPTION, "Habilitar la creación de una nueva etiqueta");
		accionCrearNuevoBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_N));
		botonNuevo.getActionMap().put("Nuevo", accionCrearNuevoBoton);
		botonNuevo.setHorizontalTextPosition(JButton.TRAILING);
		botonNuevo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionCrearNuevoBoton.getValue(Action.ACCELERATOR_KEY), "Nuevo");
		botonNuevo.setBounds(140, 465, 120, 50);

		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método guardarEtiqueta().
		 */

		accionGuardarBoton = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarEtiqueta();

			}
		};

		botonGuardar = new JButton(accionGuardarBoton);
		accionGuardarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionGuardarBoton.putValue(Action.SHORT_DESCRIPTION, "Guardar Modificaciones.");
		accionGuardarBoton.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_G);
		botonGuardar.getActionMap().put("Guardar", accionGuardarBoton);
		botonGuardar.setHorizontalTextPosition(JButton.TRAILING);
		botonGuardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionGuardarBoton.getValue(Action.ACCELERATOR_KEY), "Guardar");
		botonGuardar.setBounds(270, 465, 120, 50);

		/*
		 * La accionBotonModificar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método modificarEtiqueta().
		 */

		accionModificarBoton = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				modificarEtiqueta();
			}
		};

		botonModificar = new JButton(accionModificarBoton);
		accionModificarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		accionModificarBoton.putValue(Action.SHORT_DESCRIPTION, "Editar la etiqueta seleccionada.");
		accionModificarBoton.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_M);
		botonModificar.getActionMap().put("Modificar", accionModificarBoton);
		botonModificar.setHorizontalTextPosition(JButton.TRAILING);
		botonModificar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionModificarBoton.getValue(Action.ACCELERATOR_KEY), "Modificar");
		botonModificar.setBounds(400, 465, 125, 50);

		/*
		 * La accionBotonEliminar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método eliminarEtiqueta().
		 */

		accionEliminarBoton = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				eliminarEtiqueta();
			}
		};

		botonEliminar = new JButton(accionEliminarBoton);
		accionEliminarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		accionEliminarBoton.putValue(Action.SHORT_DESCRIPTION, "Eliminar la etiqueta seleccionada.");
		accionEliminarBoton.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
		botonEliminar.getActionMap().put("Eliminar", accionEliminarBoton);
		botonEliminar.setHorizontalTextPosition(JButton.TRAILING);
		botonEliminar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionEliminarBoton.getValue(Action.ACCELERATOR_KEY), "Eliminar");
		botonEliminar.setBounds(535, 465, 120, 50);

		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método cancelarEtiqueta().
		 */

		accionCancelarBoton = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarEtiqueta();
			}
		};

		botonCancelar = new JButton(accionCancelarBoton);
		accionCancelarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionCancelarBoton.putValue(Action.SHORT_DESCRIPTION, "Cancelar la edición de la etiqueta.");
		accionCancelarBoton.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		botonCancelar.getActionMap().put("Cancelar", accionCancelarBoton);
		botonCancelar.setHorizontalTextPosition(JButton.TRAILING);
		botonCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionCancelarBoton.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		botonCancelar.setBounds(665, 465, 125, 50);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetas);
		contenido.add(etiquetasLista);
		contenido.add(campoEtiqueta);
		listaEtiquetas.setModel(listaEtiquetasModel);
		contenido.add(desplazamientoEtiquetas);
		contenido.add(botonNuevo);
		contenido.add(botonGuardar);
		contenido.add(botonModificar);
		contenido.add(botonEliminar);
		contenido.add(botonCancelar);

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
