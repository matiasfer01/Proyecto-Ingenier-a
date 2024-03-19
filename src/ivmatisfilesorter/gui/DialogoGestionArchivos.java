/*
 * Universidad del Mar campus Puerto Escondido
 * Integrantes:
 * 		Cortez Escamilla Isaac
 * 	 	Hernández Pérez Ivonne Estefanía
 * 		Matías Acevedo Luis Fernando
 * Actividad: Primer entrega de las pantallas del sistema IvMatIs FileSorter que consiste en que un proyecto puede contener múltiples 
 * archivos y los archivos contienen etiquetas que son las que organizan a los archivos.
 * Fecha de elaboración: 01/02/2024.
 * 		
 * */
package ivmatisfilesorter.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.dominio.Etiqueta;

public class DialogoGestionArchivos extends JDialog {

	private JList<String> listaArchivos;
	private JList<String> listaEtiquetas;
	private JScrollPane desplazamientoArchivo;
	private JTextField campoRuta;
	private JComboBox<String> comboEtiquetas;
	private JScrollPane desplazamientoEtiquetas;
	private DefaultListModel<String> listamodeloArchivos = new DefaultListModel<>();
	private DefaultListModel<String> listamodeloEtiquetas = new DefaultListModel<>();
	private DefaultComboBoxModel<String> combomodeloEtiquetas = new DefaultComboBoxModel<>();
	private JButton botonSelecccionarArchivo;
	private JButton botonAgregar;
	private JButton botonQuitar;
	private JButton botonNuevo;
	private JButton botonGuardar;
	private JButton botonModificar;
	private JButton botonEliminar;
	private JButton botonCancelar;
	/* Acción de los botones que se están utilizando en la ventana. */
	private Action accionSeleccionarBoton;
	private Action accionAgregarBoton;
	private Action accionQuitarBoton;
	private Action accionCrearNuevoBoton;
	private Action accionBotonGuardar;
	private Action accionModificarBoton;
	private Action accionEliminarBoton;
	private Action accionCancelarBoton;

	private Archivo listaArchivosArchivo[];

	private static final long serialVersionUID = 1L;

	public DialogoGestionArchivos(JFrame parent, DialogoVentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de archivos", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetaRuta = new JLabel("Ruta: ");
		etiquetaRuta.setBounds(150, 10, 100, 100);

		campoRuta = new JTextField();
		campoRuta.setBounds(200, 45, 350, 30);
		campoRuta.setToolTipText("Mostrar la dirección del archivo.");
		campoRuta.setEditable(false);

		JLabel etiquetaListaArchivo = new JLabel("Lista de archivos: ");
		etiquetaListaArchivo.setBounds(70, 120, 120, 50);
		etiquetaListaArchivo.setDisplayedMnemonic(KeyEvent.VK_L);

		listaArchivos = new JList<String>();
		listaArchivos.setBounds(200, 130, 600, 80);
		listaArchivos.setToolTipText("Catálogo de archivos, seleccione un archivo para modificarle etiquetas.");

		desplazamientoArchivo = new JScrollPane(listaArchivos);
		desplazamientoArchivo.setBounds(200, 130, 600, 80);

		listamodeloArchivos = new DefaultListModel<>();
		listamodeloArchivos.addElement("The Legend of Zelda");
		listamodeloArchivos.addElement("Final Fantasy VII");
		listamodeloArchivos.addElement("Pokemon Red and Blue");
		listamodeloArchivos.addElement("Grand Theft Auto V");
		listamodeloArchivos.addElement("Minecraft");
		listamodeloArchivos.addElement("The Elder Scrolls V: Skyrim");
		listamodeloArchivos.addElement("Red Dead Redemption 2");
		listamodeloArchivos.addElement("Dark Souls");
		listamodeloArchivos.addElement("The Witcher 3: Wild Hunt");
		listamodeloArchivos.addElement("Metal Gear Solid V: The Phantom Pain");
		listamodeloArchivos.addElement("Uncharted 4: A Thief's End");
		listamodeloArchivos.addElement("Bloodborne");
		listamodeloArchivos.addElement("God of War");
		listamodeloArchivos.addElement("FIFA 22");

		JLabel etiquetaEtiquetas = new JLabel("Etiquetas");
		etiquetaEtiquetas.setBounds(150, 200, 100, 100);
		etiquetaEtiquetas.setDisplayedMnemonic(KeyEvent.VK_E);

		comboEtiquetas = new JComboBox<>();
		comboEtiquetas.setBounds(250, 240, 200, 30);
		comboEtiquetas.setToolTipText("Seleccionar la etiqueta.");

		JLabel campoEtiqueta = new JLabel("Lista de etiquetas: ");
		campoEtiqueta.setBounds(150, 260, 150, 100);
		campoEtiqueta.setDisplayedMnemonic(KeyEvent.VK_T);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(280, 305, 480, 130);
		listaEtiquetas.setToolTipText("Lista de etiquetas seleccionadas: ");

		desplazamientoEtiquetas = new JScrollPane(listaEtiquetas);
		desplazamientoEtiquetas.setBounds(280, 305, 480, 130);

		listamodeloEtiquetas = new DefaultListModel<>();
		listamodeloEtiquetas.addElement("Los hermanos");
		listamodeloEtiquetas.addElement("Bruce Wayne");
		listamodeloEtiquetas.addElement("Clark Kent");
		listamodeloEtiquetas.addElement("Peter Parker");
		listamodeloEtiquetas.addElement("Diana Prince");
		listamodeloEtiquetas.addElement("Tony Stark");
		listamodeloEtiquetas.addElement("Natasha Romanoff");
		listamodeloEtiquetas.addElement("Steve Rogers");
		listamodeloEtiquetas.addElement("Barry Allen");
		listamodeloEtiquetas.addElement("Thor Odinson");

		/*
		 * La accionBotonSeleccionar está asociada al botón. Cuando se ejecuta se manda
		 * a llamar al método seleccionarArchivo().
		 */
		accionSeleccionarBoton = new AbstractAction("Seleccionar archivo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/seleccione.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				seleccionarArchivo();

			}
		};

		botonSelecccionarArchivo = new JButton(accionSeleccionarBoton);
		accionSeleccionarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		accionSeleccionarBoton.putValue(Action.SHORT_DESCRIPTION, "Seleccionar un archivo.");
		accionSeleccionarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_S));
		botonSelecccionarArchivo.getActionMap().put("Seleccionar Archivo", accionSeleccionarBoton);
		botonSelecccionarArchivo.setHorizontalTextPosition(JButton.TRAILING);
		botonSelecccionarArchivo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionSeleccionarBoton.getValue(Action.ACCELERATOR_KEY), "Seleccionar Archivo");
		botonSelecccionarArchivo.setMnemonic(KeyEvent.VK_S);
		botonSelecccionarArchivo.setBounds(600, 30, 190, 50);

		/*
		 * La accionBotonAgregar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método agregarEtiqueta().
		 */
		accionAgregarBoton = new AbstractAction("Agregar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				agregarEtiqueta();

			}
		};
		botonAgregar = new JButton(accionAgregarBoton);
		accionAgregarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		accionAgregarBoton.putValue(Action.SHORT_DESCRIPTION, "Agregar la etiqueta.");
		accionAgregarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_A));
		botonAgregar.getActionMap().put("Agregar", accionAgregarBoton);
		botonAgregar.setHorizontalTextPosition(JButton.TRAILING);
		botonAgregar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionAgregarBoton.getValue(Action.ACCELERATOR_KEY), "Agregar");
		botonAgregar.setMnemonic(KeyEvent.VK_A);
		botonAgregar.setBounds(490, 230, 120, 50);
		/*
		 * La accionBotonQuitar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método quitarEtiqueta().
		 */
		accionQuitarBoton = new AbstractAction("Quitar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				quitarEtiqueta();

			}
		};
		botonQuitar = new JButton(accionQuitarBoton);
		accionQuitarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		accionQuitarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));
		botonQuitar.getActionMap().put("Quitar", accionQuitarBoton);
		botonQuitar.setHorizontalTextPosition(JButton.TRAILING);
		accionQuitarBoton.putValue(Action.SHORT_DESCRIPTION, "Remover la etiqueta");
		botonQuitar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionQuitarBoton.getValue(Action.ACCELERATOR_KEY), "Quitar");
		botonQuitar.setMnemonic(KeyEvent.VK_Q);
		botonQuitar.setBounds(650, 230, 120, 50);
		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método guardarArchivo().
		 * 
		 */

		accionCrearNuevoBoton = new AbstractAction("Nuevo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/nuevo.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevoArchivo();
			}
		};

		botonNuevo = new JButton(accionCrearNuevoBoton);
		accionCrearNuevoBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		accionCrearNuevoBoton.putValue(Action.SHORT_DESCRIPTION, "Habilitar la creación de un nuevo archivo.");
		accionCrearNuevoBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_N));
		botonNuevo.getActionMap().put("Nuevo", accionCrearNuevoBoton);
		botonNuevo.setHorizontalTextPosition(JButton.TRAILING);
		botonNuevo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionCrearNuevoBoton.getValue(Action.ACCELERATOR_KEY), "Nuevo");
		botonNuevo.setBounds(140, 465, 120, 50);

		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarArchivo();

			}

		};

		botonGuardar = new JButton(accionBotonGuardar);
		accionBotonGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonGuardar.putValue(Action.SHORT_DESCRIPTION, "Guardar el archivo con las etiquetas seleccionadas.");
		accionBotonGuardar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		botonGuardar.getActionMap().put("Guardar", accionBotonGuardar);
		botonGuardar.setHorizontalTextPosition(JButton.TRAILING);
		botonGuardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonGuardar.getValue(Action.ACCELERATOR_KEY), "Guardar");
		botonGuardar.setMnemonic(KeyEvent.VK_G);
		botonGuardar.setBounds(270, 465, 120, 50);

		/* Accion de Modificar */
		accionModificarBoton = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				modificarArchivo();

			}

		};

		botonModificar = new JButton(accionModificarBoton);
		accionModificarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		accionModificarBoton.putValue(Action.SHORT_DESCRIPTION,
				"Modificar el archivo seleccionado de la lista de archivos.");
		accionModificarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_M));
		botonModificar.getActionMap().put("Modificar", accionBotonGuardar);
		botonModificar.setHorizontalTextPosition(JButton.TRAILING);
		botonModificar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionModificarBoton.getValue(Action.ACCELERATOR_KEY), "Modificar");
		botonModificar.setMnemonic(KeyEvent.VK_M);
		botonModificar.setBounds(400, 465, 125, 50);

		/*
		 * La accionBotonEliminar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método eliminarArchivo().
		 */

		accionEliminarBoton = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				eliminarArchivo();

			}

		};

		botonEliminar = new JButton(accionEliminarBoton);
		accionEliminarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		accionEliminarBoton.putValue(Action.SHORT_DESCRIPTION, "Eliminar archivo seleccionado de la lista de archivos");
		accionEliminarBoton.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
		botonEliminar.getActionMap().put("Eliminar", accionEliminarBoton);
		botonEliminar.setHorizontalTextPosition(JButton.TRAILING);
		botonEliminar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionEliminarBoton.getValue(Action.ACCELERATOR_KEY), "Eliminar");
		botonEliminar.setMnemonic(KeyEvent.VK_I);
		botonEliminar.setBounds(535, 465, 120, 50);

		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método modificarArchivo().
		 */

		accionCancelarBoton = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarArchivo();

			}

		};

		botonCancelar = new JButton(accionCancelarBoton);
		accionCancelarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionCancelarBoton.putValue(Action.SHORT_DESCRIPTION, "Cancelar la edición del archivo.");
		accionCancelarBoton.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		botonCancelar.getActionMap().put("Cancelar", accionCancelarBoton);
		botonCancelar.setHorizontalTextPosition(JButton.TRAILING);
		botonCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionCancelarBoton.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		botonCancelar.setMnemonic(KeyEvent.VK_C);
		botonCancelar.setBounds(665, 465, 125, 50);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetaListaArchivo);
		contenido.add(desplazamientoArchivo);
		contenido.add(etiquetaRuta);
		contenido.add(etiquetaEtiquetas);
		listaArchivos.setModel(listamodeloArchivos);
		contenido.add(campoEtiqueta);
		contenido.add(campoRuta);
		contenido.add(comboEtiquetas);
		listaEtiquetas.setModel(listamodeloEtiquetas);
		contenido.add(desplazamientoEtiquetas);
		contenido.add(botonSelecccionarArchivo);
		contenido.add(botonAgregar);
		contenido.add(botonNuevo);
		contenido.add(botonQuitar);
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

	// Selecciona un archivo de la lista de archivos.
	private void seleccionarArchivo() {

	}

	// Agrega la etiqueta al campo etiqueta y se agrega a la lista etiquetas.
	private void agregarEtiqueta() {
		
	}

	// Elimina la etiqueta de la lista etiquetas y también del campo etiquetas.
	private void quitarEtiqueta() {
		
	}

	// Permite agregar un nuevo archivo
	private void nuevoArchivo() {

	}

	// Guarda el archivo con las etiquetas seleccionadas.
	private void guardarArchivo() {

	}

	// Modifica las etiquetas del archivo.
	private void modificarArchivo() {

	}

	// Elimina las etiquetas que han sido seleccionados para el archivo.
	private void eliminarArchivo() {

	}

	// Cancela los cambios de las etiquetas que se han realizado en el archivo.
	private void cancelarArchivo() {

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
