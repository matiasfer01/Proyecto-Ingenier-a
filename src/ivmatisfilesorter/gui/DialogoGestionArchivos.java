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

	private JList<String> listaDeArchivos;
	private JScrollPane scrollpaneArchivo;
	private JTextField ruta;
	private JComboBox<String> etiquetas;
	private JList<String> listaEtiquetas;
	private JScrollPane scrollpaneEtiquetas;
	private DefaultListModel<String> archivoListModel = new DefaultListModel<>();
	private DefaultListModel<String> etiquetasListModel = new DefaultListModel<>();
	private DefaultComboBoxModel<String> etiquetasComboBoxModel = new DefaultComboBoxModel<>();
	private JButton selecccionarArchivo;
	private JButton agregar;
	private JButton quitar;
	private JButton nuevo;
	private JButton guardar;
	private JButton modificar;
	private JButton eliminar;
	private JButton cancelar;
	/* Acción de los botones que se están utilizando en la ventana. */
	private Action accionBotonSeleccionar;
	private Action accionBotonAgregar;
	private Action accionBotonQuitar;
	private Action accionBotonNuevo;
	private Action accionBotonGuardar;
	private Action accionBotonModificar;
	private Action accionBotonEliminar;
	private Action accionBotonCancelar;

	private Archivo listaArchivo[];

	private static final long serialVersionUID = 1L;

	public DialogoGestionArchivos(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de archivos", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetaRuta = new JLabel("Ruta: ");
		etiquetaRuta.setBounds(150, 10, 100, 100);

		ruta = new JTextField();
		ruta.setBounds(200, 45, 350, 30);
		ruta.setToolTipText("Mostrar la dirección del archivo.");
		ruta.setEditable(false);

		JLabel etiquetaListaArchivo = new JLabel("Lista de archivos: ");
		etiquetaListaArchivo.setBounds(70, 120, 120, 50);
		etiquetaListaArchivo.setDisplayedMnemonic(KeyEvent.VK_L);

		listaDeArchivos = new JList<String>();
		listaDeArchivos.setBounds(200, 130, 600, 80);
		listaDeArchivos.setToolTipText("Catálogo de archivos, seleccione un archivo para modificarle etiquetas.");

		scrollpaneArchivo = new JScrollPane(listaDeArchivos);
		scrollpaneArchivo.setBounds(200, 130, 600, 80);

		archivoListModel = new DefaultListModel<>();
		archivoListModel.addElement("The Legend of Zelda");
		archivoListModel.addElement("Final Fantasy VII");
		archivoListModel.addElement("Pokemon Red and Blue");
		archivoListModel.addElement("Grand Theft Auto V");
		archivoListModel.addElement("Minecraft");
		archivoListModel.addElement("The Elder Scrolls V: Skyrim");
		archivoListModel.addElement("Red Dead Redemption 2");
		archivoListModel.addElement("Dark Souls");
		archivoListModel.addElement("The Witcher 3: Wild Hunt");
		archivoListModel.addElement("Metal Gear Solid V: The Phantom Pain");
		archivoListModel.addElement("Uncharted 4: A Thief's End");
		archivoListModel.addElement("Bloodborne");
		archivoListModel.addElement("God of War");
		archivoListModel.addElement("FIFA 22");

		JLabel etiquetaEtiquetas = new JLabel("Etiquetas");
		etiquetaEtiquetas.setBounds(150, 200, 100, 100);
		etiquetaEtiquetas.setDisplayedMnemonic(KeyEvent.VK_E);

		etiquetas = new JComboBox<>();
		etiquetas.setBounds(250, 240, 200, 30);
		etiquetas.setToolTipText("Seleccionar la etiqueta.");

		JLabel campoEtiqueta = new JLabel("Lista de etiquetas: ");
		campoEtiqueta.setBounds(150, 260, 150, 100);
		campoEtiqueta.setDisplayedMnemonic(KeyEvent.VK_T);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(280, 305, 480, 130);
		listaEtiquetas.setToolTipText("Lista de etiquetas seleccionadas: ");

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(280, 305, 480, 130);

		etiquetasListModel = new DefaultListModel<>();
		etiquetasListModel.addElement("Los hermanos");
		etiquetasListModel.addElement("Bruce Wayne");
		etiquetasListModel.addElement("Clark Kent");
		etiquetasListModel.addElement("Peter Parker");
		etiquetasListModel.addElement("Diana Prince");
		etiquetasListModel.addElement("Tony Stark");
		etiquetasListModel.addElement("Natasha Romanoff");
		etiquetasListModel.addElement("Steve Rogers");
		etiquetasListModel.addElement("Barry Allen");
		etiquetasListModel.addElement("Thor Odinson");

		/*
		 * La accionBotonSeleccionar está asociada al botón. Cuando se ejecuta
		 * se manda a llamar al método seleccionarArchivo().
		 */
		accionBotonSeleccionar = new AbstractAction("Seleccionar archivo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/seleccione.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				seleccionarArchivo();

			}
		};
		
		selecccionarArchivo = new JButton(accionBotonSeleccionar);
		accionBotonSeleccionar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		accionBotonSeleccionar.putValue(Action.SHORT_DESCRIPTION, "Seleccionar un archivo.");
		accionBotonSeleccionar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_S));
		selecccionarArchivo.getActionMap().put("Seleccionar Archivo", accionBotonSeleccionar);
		selecccionarArchivo.setHorizontalTextPosition(JButton.TRAILING);
		selecccionarArchivo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonSeleccionar.getValue(Action.ACCELERATOR_KEY), "Seleccionar Archivo");
		selecccionarArchivo.setMnemonic(KeyEvent.VK_S);
		selecccionarArchivo.setBounds(600, 30, 190, 50);

		/*
		 * La accionBotonAgregar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método agregarEtiqueta().
		 */
		accionBotonAgregar = new AbstractAction("Agregar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				agregarEtiqueta();

			}
		};
		agregar = new JButton(accionBotonAgregar);
		accionBotonAgregar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		accionBotonAgregar.putValue(Action.SHORT_DESCRIPTION, "Agregar la etiqueta.");
		accionBotonAgregar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_A));
		agregar.getActionMap().put("Agregar", accionBotonAgregar);
		agregar.setHorizontalTextPosition(JButton.TRAILING);
		agregar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonAgregar.getValue(Action.ACCELERATOR_KEY), "Agregar");
		agregar.setMnemonic(KeyEvent.VK_A);
		agregar.setBounds(490, 230, 120, 50);
		/*
		 * La accionBotonQuitar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método quitarEtiqueta().
		 */
		accionBotonQuitar = new AbstractAction("Quitar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				quitarEtiqueta();

			}
		};
		quitar = new JButton(accionBotonQuitar);
		accionBotonQuitar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		accionBotonQuitar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));
		quitar.getActionMap().put("Quitar", accionBotonQuitar);
		quitar.setHorizontalTextPosition(JButton.TRAILING);
		accionBotonQuitar.putValue(Action.SHORT_DESCRIPTION, "Remover la etiqueta");
		quitar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonQuitar.getValue(Action.ACCELERATOR_KEY), "Quitar");
		quitar.setMnemonic(KeyEvent.VK_Q);
		quitar.setBounds(650, 230, 120, 50);
		/*
		 * La accionBotonGuardar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método guardarArchivo().
		 * 
		 */

		accionBotonNuevo = new AbstractAction("Nuevo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/nuevo.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				nuevoArchivo();
			}
		};

		nuevo = new JButton(accionBotonNuevo);
		accionBotonNuevo.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		accionBotonNuevo.putValue(Action.SHORT_DESCRIPTION, "Habilitar la creación de un nuevo archivo.");
		accionBotonNuevo.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_N));
		nuevo.getActionMap().put("Nuevo", accionBotonNuevo);
		nuevo.setHorizontalTextPosition(JButton.TRAILING);
		nuevo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonNuevo.getValue(Action.ACCELERATOR_KEY), "Nuevo");
		nuevo.setBounds(140, 465, 120, 50);

		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarArchivo();

			}

		};

		guardar = new JButton(accionBotonGuardar);
		accionBotonGuardar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonGuardar.putValue(Action.SHORT_DESCRIPTION, "Guardar el archivo con las etiquetas seleccionadas.");
		accionBotonGuardar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		guardar.getActionMap().put("Guardar", accionBotonGuardar);
		guardar.setHorizontalTextPosition(JButton.TRAILING);
		guardar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonGuardar.getValue(Action.ACCELERATOR_KEY), "Guardar");
		guardar.setMnemonic(KeyEvent.VK_G);
		guardar.setBounds(270, 465, 120, 50);

		/* Accion de Modificar */
		accionBotonModificar = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				modificarArchivo();

			}

		};

		modificar = new JButton(accionBotonModificar);
		accionBotonModificar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		accionBotonModificar.putValue(Action.SHORT_DESCRIPTION,
				"Modificar el archivo seleccionado de la lista de archivos.");
		accionBotonModificar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_M));
		modificar.getActionMap().put("Modificar", accionBotonGuardar);
		modificar.setHorizontalTextPosition(JButton.TRAILING);
		modificar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonModificar.getValue(Action.ACCELERATOR_KEY), "Modificar");
		modificar.setMnemonic(KeyEvent.VK_M);
		modificar.setBounds(400, 465, 125, 50);

		/*
		 * La accionBotonEliminar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método eliminarArchivo().
		 */

		accionBotonEliminar = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				eliminarArchivo();

			}

		};

		eliminar = new JButton(accionBotonEliminar);
		accionBotonEliminar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		accionBotonEliminar.putValue(Action.SHORT_DESCRIPTION, "Eliminar archivo seleccionado de la lista de archivos");
		accionBotonEliminar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
		eliminar.getActionMap().put("Eliminar", accionBotonEliminar);
		eliminar.setHorizontalTextPosition(JButton.TRAILING);
		eliminar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonEliminar.getValue(Action.ACCELERATOR_KEY), "Eliminar");
		eliminar.setMnemonic(KeyEvent.VK_I);
		eliminar.setBounds(535, 465, 120, 50);

		/*
		 * La accionBotonCancelar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método modificarArchivo().
		 */

		accionBotonCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cancelarArchivo();

			}

		};

		cancelar = new JButton(accionBotonCancelar);
		accionBotonCancelar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		accionBotonCancelar.putValue(Action.SHORT_DESCRIPTION, "Cancelar la edición del archivo.");
		accionBotonCancelar.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		cancelar.getActionMap().put("Cancelar", accionBotonCancelar);
		cancelar.setHorizontalTextPosition(JButton.TRAILING);
		cancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonCancelar.getValue(Action.ACCELERATOR_KEY), "Cancelar");
		cancelar.setMnemonic(KeyEvent.VK_C);
		cancelar.setBounds(665, 465, 125, 50);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetaListaArchivo);
		contenido.add(scrollpaneArchivo);
		contenido.add(etiquetaRuta);
		contenido.add(etiquetaEtiquetas);
		listaDeArchivos.setModel(archivoListModel);
		contenido.add(campoEtiqueta);
		contenido.add(ruta);
		contenido.add(etiquetas);
		listaEtiquetas.setModel(etiquetasListModel);
		contenido.add(scrollpaneEtiquetas);
		contenido.add(selecccionarArchivo);
		contenido.add(agregar);
		contenido.add(nuevo);
		contenido.add(quitar);
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

	// Selecciona un archivo de la lista de archivos.
	private void seleccionarArchivo() {

	}

	// Agrega la etiqueta al campo etiqueta y se agrega a la lista etiquetas.
	private void agregarEtiqueta() {
		System.out.println("aqui eso");
	}

	// Elimina la etiqueta de la lista etiquetas y también del campo etiquetas.
	private void quitarEtiqueta() {
		System.out.println("aqui eso");
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
