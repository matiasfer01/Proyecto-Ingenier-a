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

	private JList<String> listaEtiquetas;
	private JList<String> listaEtiquetasSeleccionadas;
	private JList<String> listaArchivosDisponibles;
	private JScrollPane desplazamientoEtiquetas;
	private JScrollPane desplazamientoEtiquetasSeleccionadas;
	private JScrollPane desplazamientoArchivos;
	private DefaultListModel<String> listaModeloEtiquetas = new DefaultListModel<>();
	private DefaultListModel<String> listaModeloEtiquetasSeleccionadas = new DefaultListModel<>();
	private DefaultListModel<String> listaModeloArchivos = new DefaultListModel<>();
	private JButton botonAgregar;
	private JButton botonBuscar;
	private JButton botonQuitar;
	private JButton botonAbrirArchivo;
	private JButton botonExportar;
	/* Acción de los botones que se están utilizando en la ventana. */
	private Action accionAgregarBoton;
	private Action accionQuitarBoton;
	private Action accionBuscarBoton;
	private Action accionAbrirArchivoBoton;
	private Action accionExportarBoton;

	private Archivo listaArchivosArchivo[];

	public DialogoBusquedaArchivos(JFrame parent, DialogoVentanaPrincipal ventanaPrincipal) {
		super(parent, "Búsqueda de archivos", true);

		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetasDisponibles = new JLabel("Listado de etiquetas disponibles: ");
		etiquetasDisponibles.setBounds(30, 20, 200, 60);
		etiquetasDisponibles.setDisplayedMnemonic(KeyEvent.VK_L);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(220, 30, 180, 200);
		listaEtiquetas.setToolTipText("Catálogo de etiquetas:.");

		desplazamientoEtiquetas = new JScrollPane(listaEtiquetas);
		desplazamientoEtiquetas.setBounds(220, 30, 180, 200);

		listaModeloEtiquetas = new DefaultListModel<>();
		listaModeloEtiquetas.addElement("Vacaciones");
		listaModeloEtiquetas.addElement("Trabajo");
		listaModeloEtiquetas.addElement("Proyecto Importante");
		listaModeloEtiquetas.addElement("Personal");
		listaModeloEtiquetas.addElement("Reunión");
		listaModeloEtiquetas.addElement("Urgente");
		listaModeloEtiquetas.addElement("Familia");
		listaModeloEtiquetas.addElement("Estudio");
		listaModeloEtiquetas.addElement("Viaje");
		listaModeloEtiquetas.addElement("Evento Social");
		listaModeloEtiquetas.addElement("Recordatorio");
		listaModeloEtiquetas.addElement("Compra");
		listaModeloEtiquetas.addElement("Aniversario");
		listaModeloEtiquetas.addElement("Ocio");
		listaModeloEtiquetas.addElement("Deportes");
		listaModeloEtiquetas.addElement("Citas");
		listaModeloEtiquetas.addElement("Tareas Domésticas");
		listaModeloEtiquetas.addElement("Amigos");
		listaModeloEtiquetas.addElement("Cine");
		listaModeloEtiquetas.addElement("Comida");
		listaModeloEtiquetas.addElement("Ejercicio");
		listaModeloEtiquetas.addElement("Música");
		listaModeloEtiquetas.addElement("Libros");
		listaModeloEtiquetas.addElement("Tecnología");
		listaModeloEtiquetas.addElement("Salud");
		listaModeloEtiquetas.addElement("Bricolaje");

		JLabel seleccionadas = new JLabel("Listado de etiquetas seleccionadas: ");
		seleccionadas.setBounds(425, 20, 220, 60);
		seleccionadas.setDisplayedMnemonic(KeyEvent.VK_E);

		listaEtiquetasSeleccionadas = new JList<String>();
		listaEtiquetasSeleccionadas.setBounds(635, 30, 180, 200);
		listaEtiquetasSeleccionadas.setToolTipText("Lista de etiquetas elegidas.");

		desplazamientoEtiquetasSeleccionadas = new JScrollPane(listaEtiquetasSeleccionadas);
		desplazamientoEtiquetasSeleccionadas.setBounds(635, 30, 180, 200);

		listaModeloEtiquetasSeleccionadas = new DefaultListModel<>();
		listaModeloEtiquetasSeleccionadas.addElement("Trabajo");
		listaModeloEtiquetasSeleccionadas.addElement("Personal");
		listaModeloEtiquetasSeleccionadas.addElement("Proyecto importante");
		listaModeloEtiquetasSeleccionadas.addElement("Recordatorio");
		listaModeloEtiquetasSeleccionadas.addElement("Reunión");
		listaModeloEtiquetasSeleccionadas.addElement("Urgente");
		listaModeloEtiquetasSeleccionadas.addElement("Compra");
		listaModeloEtiquetasSeleccionadas.addElement("Aniversario");
		listaModeloEtiquetasSeleccionadas.addElement("Evento social");
		listaModeloEtiquetasSeleccionadas.addElement("Estudio");
		listaModeloEtiquetasSeleccionadas.addElement("Familia");
		listaModeloEtiquetasSeleccionadas.addElement("Ocio");
		listaModeloEtiquetasSeleccionadas.addElement("Vacaciones");

		JLabel listaArchivos = new JLabel("Lista de archivos: ");
		listaArchivos.setBounds(220, 200, 220, 150);
		listaArchivos.setDisplayedMnemonic(KeyEvent.VK_A);

		listaArchivosDisponibles = new JList<String>();
		listaArchivosDisponibles.setBounds(350, 260, 350, 150);
		listaArchivosDisponibles.setToolTipText("Lista de archivos encontrados.");

		desplazamientoArchivos = new JScrollPane(listaArchivosDisponibles);
		desplazamientoArchivos.setBounds(350, 260, 350, 150);

		listaModeloArchivos = new DefaultListModel<>();
		listaModeloArchivos.addElement("Documento1");
		listaModeloArchivos.addElement("Informe_Trabajo");
		listaModeloArchivos.addElement("Proyecto_Importante");
		listaModeloArchivos.addElement("Foto_Personal");
		listaModeloArchivos.addElement("Reunion_Notas");
		listaModeloArchivos.addElement("Urgente_Memo");
		listaModeloArchivos.addElement("Familia_Fotos");
		listaModeloArchivos.addElement("Estudio_Presentacion");
		listaModeloArchivos.addElement("Itinerario_Viaje");
		listaModeloArchivos.addElement("Evento_Social_Invitacion");
		listaModeloArchivos.addElement("Recordatorio");
		listaModeloArchivos.addElement("Lista_Compras");
		listaModeloArchivos.addElement("Aniversario_Video");
		listaModeloArchivos.addElement("Ocio_Playlist");

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
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionAgregarBoton.putValue(Action.SHORT_DESCRIPTION,
				"Incluir la etiqueta seleccionada de las opciones disponibles en las etiquetas seleccionadas.");
		accionAgregarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		botonAgregar.getActionMap().put("Agregar", accionAgregarBoton);
		botonAgregar.setHorizontalTextPosition(JButton.TRAILING);
		botonAgregar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionAgregarBoton.getValue(Action.ACCELERATOR_KEY), "Agregar");
		botonAgregar.setBounds(450, 80, 125, 40);
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
		accionQuitarBoton.putValue(Action.SHORT_DESCRIPTION,
				"Remover la etiqueta seleccionada de la lista de etiquetas seleccionadas.");
		accionQuitarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));
		botonQuitar.getActionMap().put("Quitar", accionQuitarBoton);
		botonQuitar.setHorizontalTextPosition(JButton.TRAILING);
		botonQuitar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionQuitarBoton.getValue(Action.ACCELERATOR_KEY), "Quitar");
		botonQuitar.setBounds(450, 150, 120, 40);
		/*
		 * La accionBotonBuscar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método buscarEtiqueta().
		 */
		accionBuscarBoton = new AbstractAction("Buscar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				buscarEtiqueta();

			}
		};
		botonBuscar = new JButton(accionBuscarBoton);
		accionBuscarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		accionBuscarBoton.putValue(Action.SHORT_DESCRIPTION, "Encontrar los archivos con las etiquetas seleccionadas.");
		accionBuscarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_B));
		botonBuscar.getActionMap().put("Buscar", accionBuscarBoton);
		botonBuscar.setHorizontalTextPosition(JButton.TRAILING);
		botonBuscar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBuscarBoton.getValue(Action.ACCELERATOR_KEY), "Buscar");
		botonBuscar.setBounds(275, 465, 120, 40);
		/*
		 * La accionBotonAbrirArchivo está asociada al botón. Cuando se ejecuta se manda
		 * a llamar al método abrirArchivo().
		 */
		accionAbrirArchivoBoton = new AbstractAction("Abrir archivo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				abrirArchivo();

			}
		};
		botonAbrirArchivo = new JButton(accionAbrirArchivoBoton);
		accionAbrirArchivoBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		accionAbrirArchivoBoton.putValue(Action.SHORT_DESCRIPTION, "Acceder al archivo seleccionado.");
		accionAbrirArchivoBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_R));
		botonAbrirArchivo.getActionMap().put("Abrir archivo", accionAbrirArchivoBoton);
		botonAbrirArchivo.setHorizontalTextPosition(JButton.TRAILING);
		botonAbrirArchivo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionAbrirArchivoBoton.getValue(Action.ACCELERATOR_KEY), "Abrir archivo");
		botonAbrirArchivo.setBounds(425, 465, 145, 40);

		/*
		 * La accionBotonExportar está asociada al botón. Cuando se ejecuta se manda a
		 * llamar al método exportarArchivo().
		 */
		accionExportarBoton = new AbstractAction("Exportar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/exportar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				exportarArchivo();

			}
		};

		botonExportar = new JButton(accionExportarBoton);
		accionExportarBoton.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		accionExportarBoton.putValue(Action.SHORT_DESCRIPTION,
				"Transferir los archivos de la lista de archivos a una carpeta.");
		accionExportarBoton.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_X));
		botonExportar.getActionMap().put("Exportar", accionExportarBoton);
		botonExportar.setHorizontalTextPosition(JButton.TRAILING);
		botonExportar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionExportarBoton.getValue(Action.ACCELERATOR_KEY), "Exportar");
		botonExportar.setBounds(600, 465, 120, 40);

		/* Los componentes han sido agregados a la ventana. */
		contenido.add(etiquetasDisponibles);
		listaEtiquetas.setModel(listaModeloEtiquetas);
		contenido.add(desplazamientoEtiquetas);
		contenido.add(seleccionadas);
		listaEtiquetasSeleccionadas.setModel(listaModeloEtiquetasSeleccionadas);
		contenido.add(desplazamientoEtiquetasSeleccionadas);
		contenido.add(listaArchivos);
		listaArchivosDisponibles.setModel(listaModeloArchivos);
		contenido.add(desplazamientoArchivos);
		contenido.add(botonAgregar);
		contenido.add(botonBuscar);
		contenido.add(botonQuitar);
		contenido.add(botonAbrirArchivo);
		contenido.add(botonExportar);

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
