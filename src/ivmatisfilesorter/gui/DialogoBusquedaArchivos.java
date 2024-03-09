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
import javax.swing.KeyStroke;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.dominio.Etiqueta;

/*Está clase se encargará de mostrar un archivo o más archivos que se clasificarán por etiquetas seleccionadas de las etiquetas que se encuentran almacenadas o guardadas.*/
public class DialogoBusquedaArchivos extends JDialog {

	private static final long serialVersionUID = 1L;

	private JList<String> etiquetas;
	private JList<String> etiquetasSeleccionadas;
	private JList<String> archivos;
	private JScrollPane scrollpaneEtiquetas;
	private JScrollPane scrollpaneEtiquetasSeleccionadas;
	private JScrollPane scrollpaneArchivos;
	private DefaultListModel<String> listaEtiquetasModel = new DefaultListModel<>();
	private DefaultListModel<String> listaEtiquetasSeleccionadasModel = new DefaultListModel<>();
	private DefaultListModel<String> listaArchivosModel = new DefaultListModel<>();
	private JButton agregar;
	private JButton buscar;
	private JButton quitar;
	private JButton abrirArchivo;
	private JButton exportar;
	/* Acción de los botones que se están utilizando en la ventana. */
	private Action accionBotonAgregar;
	private Action accionBotonQuitar;
	private Action accionBotonBuscar;
	private Action accionBotonAbrirArchivo;
	private Action accionBotonExportar;
	private Archivo listaArchivos[];

	public DialogoBusquedaArchivos(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Búsqueda de archivos", true);

		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetasDisponibles = new JLabel("Listado de etiquetas disponibles: ");
		etiquetasDisponibles.setBounds(30, 20, 200, 60);
		etiquetasDisponibles.setDisplayedMnemonic(KeyEvent.VK_L);

		etiquetas = new JList<String>();
		etiquetas.setBounds(220, 30, 180, 200);
		etiquetas.setToolTipText("Catálogo de etiquetas:.");

		scrollpaneEtiquetas = new JScrollPane(etiquetas);
		scrollpaneEtiquetas.setBounds(220, 30, 180, 200);

		listaEtiquetasModel = new DefaultListModel<>();
		listaEtiquetasModel.addElement("Vacaciones");
		listaEtiquetasModel.addElement("Trabajo");
		listaEtiquetasModel.addElement("Proyecto Importante");
		listaEtiquetasModel.addElement("Personal");
		listaEtiquetasModel.addElement("Reunión");
		listaEtiquetasModel.addElement("Urgente");
		listaEtiquetasModel.addElement("Familia");
		listaEtiquetasModel.addElement("Estudio");
		listaEtiquetasModel.addElement("Viaje");
		listaEtiquetasModel.addElement("Evento Social");
		listaEtiquetasModel.addElement("Recordatorio");
		listaEtiquetasModel.addElement("Compra");
		listaEtiquetasModel.addElement("Aniversario");
		listaEtiquetasModel.addElement("Ocio");
		listaEtiquetasModel.addElement("Deportes");
		listaEtiquetasModel.addElement("Citas");
		listaEtiquetasModel.addElement("Tareas Domésticas");
		listaEtiquetasModel.addElement("Amigos");
		listaEtiquetasModel.addElement("Cine");
		listaEtiquetasModel.addElement("Comida");
		listaEtiquetasModel.addElement("Ejercicio");
		listaEtiquetasModel.addElement("Música");
		listaEtiquetasModel.addElement("Libros");
		listaEtiquetasModel.addElement("Tecnología");
		listaEtiquetasModel.addElement("Salud");
		listaEtiquetasModel.addElement("Bricolaje");

		JLabel seleccionadas = new JLabel("Listado de etiquetas seleccionadas: ");
		seleccionadas.setBounds(425, 20, 220, 60);
		seleccionadas.setDisplayedMnemonic(KeyEvent.VK_E);

		etiquetasSeleccionadas = new JList<String>();
		etiquetasSeleccionadas.setBounds(635, 30, 180, 200);
		etiquetasSeleccionadas.setToolTipText("Lista de etiquetas elegidas.");

		scrollpaneEtiquetasSeleccionadas = new JScrollPane(etiquetasSeleccionadas);
		scrollpaneEtiquetasSeleccionadas.setBounds(635, 30, 180, 200);

		listaEtiquetasSeleccionadasModel = new DefaultListModel<>();
		listaEtiquetasSeleccionadasModel.addElement("Trabajo");
		listaEtiquetasSeleccionadasModel.addElement("Personal");
		listaEtiquetasSeleccionadasModel.addElement("Proyecto importante");
		listaEtiquetasSeleccionadasModel.addElement("Recordatorio");
		listaEtiquetasSeleccionadasModel.addElement("Reunión");
		listaEtiquetasSeleccionadasModel.addElement("Urgente");
		listaEtiquetasSeleccionadasModel.addElement("Compra");
		listaEtiquetasSeleccionadasModel.addElement("Aniversario");
		listaEtiquetasSeleccionadasModel.addElement("Evento social");
		listaEtiquetasSeleccionadasModel.addElement("Estudio");
		listaEtiquetasSeleccionadasModel.addElement("Familia");
		listaEtiquetasSeleccionadasModel.addElement("Ocio");
		listaEtiquetasSeleccionadasModel.addElement("Vacaciones");

		JLabel listaArchivos = new JLabel("Lista de archivos: ");
		listaArchivos.setBounds(220, 200, 220, 150);
		listaArchivos.setDisplayedMnemonic(KeyEvent.VK_A);

		archivos = new JList<String>();
		archivos.setBounds(350, 260, 350, 150);
		archivos.setToolTipText("Lista de archivos encontrados.");

		scrollpaneArchivos = new JScrollPane(archivos);
		scrollpaneArchivos.setBounds(350, 260, 350, 150);

		listaArchivosModel = new DefaultListModel<>();
		listaArchivosModel.addElement("Documento1");
		listaArchivosModel.addElement("Informe_Trabajo");
		listaArchivosModel.addElement("Proyecto_Importante");
		listaArchivosModel.addElement("Foto_Personal");
		listaArchivosModel.addElement("Reunion_Notas");
		listaArchivosModel.addElement("Urgente_Memo");
		listaArchivosModel.addElement("Familia_Fotos");
		listaArchivosModel.addElement("Estudio_Presentacion");
		listaArchivosModel.addElement("Itinerario_Viaje");
		listaArchivosModel.addElement("Evento_Social_Invitacion");
		listaArchivosModel.addElement("Recordatorio");
		listaArchivosModel.addElement("Lista_Compras");
		listaArchivosModel.addElement("Aniversario_Video");
		listaArchivosModel.addElement("Ocio_Playlist");

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
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonAgregar.putValue(Action.SHORT_DESCRIPTION,
				"Incluir la etiqueta seleccionada de las opciones disponibles en las etiquetas seleccionadas.");
		accionBotonAgregar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		agregar.getActionMap().put("Agregar", accionBotonAgregar);
		agregar.setHorizontalTextPosition(JButton.TRAILING);
		agregar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonAgregar.getValue(Action.ACCELERATOR_KEY), "Agregar");
		agregar.setBounds(450, 80, 125, 40);
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
		accionBotonQuitar.putValue(Action.SHORT_DESCRIPTION,
				"Remover la etiqueta seleccionada de la lista de etiquetas seleccionadas.");
		accionBotonQuitar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));
		quitar.getActionMap().put("Quitar", accionBotonQuitar);
		quitar.setHorizontalTextPosition(JButton.TRAILING);
		quitar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonQuitar.getValue(Action.ACCELERATOR_KEY), "Quitar");
		quitar.setBounds(450, 150, 120, 40);
		/*
		 * La accionBotonBuscar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método buscarEtiqueta().
		 */
		accionBotonBuscar = new AbstractAction("Buscar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				buscarEtiqueta();

			}
		};
		buscar = new JButton(accionBotonBuscar);
		accionBotonBuscar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		accionBotonBuscar.putValue(Action.SHORT_DESCRIPTION, "Encontrar los archivos con las etiquetas seleccionadas.");
		accionBotonBuscar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_B));
		buscar.getActionMap().put("Buscar", accionBotonBuscar);
		buscar.setHorizontalTextPosition(JButton.TRAILING);
		buscar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonBuscar.getValue(Action.ACCELERATOR_KEY), "Buscar");
		buscar.setBounds(275, 465, 120, 40);
		/*
		 * La accionBotonAbrirArchivo está asociada al botón. Cuando se ejecuta
		 * se manda a llamar al método abrirArchivo().
		 */
		accionBotonAbrirArchivo = new AbstractAction("Abrir archivo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				abrirArchivo();

			}
		};
		abrirArchivo = new JButton(accionBotonAbrirArchivo);
		accionBotonAbrirArchivo.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		accionBotonAbrirArchivo.putValue(Action.SHORT_DESCRIPTION, "Acceder al archivo seleccionado.");
		accionBotonAbrirArchivo.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_R));
		abrirArchivo.getActionMap().put("Abrir archivo", accionBotonAbrirArchivo);
		abrirArchivo.setHorizontalTextPosition(JButton.TRAILING);
		abrirArchivo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonAbrirArchivo.getValue(Action.ACCELERATOR_KEY), "Abrir archivo");
		abrirArchivo.setBounds(425, 465, 145, 40);

		/*
		 * La accionBotonExportar está asociada al botón. Cuando se ejecuta se
		 * manda a llamar al método exportarArchivo().
		 */
		accionBotonExportar = new AbstractAction("Exportar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/exportar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				exportarArchivo();

			}
		};

		exportar = new JButton(accionBotonExportar);
		accionBotonExportar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		accionBotonExportar.putValue(Action.SHORT_DESCRIPTION,
				"Transferir los archivos de la lista de archivos a una carpeta.");
		accionBotonExportar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_X));
		exportar.getActionMap().put("Exportar", accionBotonExportar);
		exportar.setHorizontalTextPosition(JButton.TRAILING);
		exportar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonExportar.getValue(Action.ACCELERATOR_KEY), "Exportar");
		exportar.setBounds(600, 465, 120, 40);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetasDisponibles);
		etiquetas.setModel(listaEtiquetasModel);
		contenido.add(scrollpaneEtiquetas);
		contenido.add(seleccionadas);
		etiquetasSeleccionadas.setModel(listaEtiquetasSeleccionadasModel);
		contenido.add(scrollpaneEtiquetasSeleccionadas);
		contenido.add(listaArchivos);
		archivos.setModel(listaArchivosModel);
		contenido.add(scrollpaneArchivos);
		contenido.add(agregar);
		contenido.add(buscar);
		contenido.add(quitar);
		contenido.add(abrirArchivo);
		contenido.add(exportar);

		this.add(contenido);

		this.setSize(950, 600);
		/* No se puede redimensionar. */
		this.setResizable(false);
		/* Se destruirá cuando se cierre. */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	// Agrega etiqueta a la lista de etiquetas seleccionadas.
	private void agregarEtiqueta() {
		
	}

	// Busca los archivos dependiendo de las etiquetas que han sido
	// seleccionadas.
	private void buscarEtiqueta() {
		
	}

	// Elimina la etiqueta que han sido seleccionadas.
	private void quitarEtiqueta() {
		
	}

	// Abre el archivo que se ha seleccionado, dependiendo de las etiquetas
	// seleccionadas.
	private void abrirArchivo() {
		
	}

	// Envía el archivo seleccionado a un ruta o carpeta.
	private void exportarArchivo() {
		
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
