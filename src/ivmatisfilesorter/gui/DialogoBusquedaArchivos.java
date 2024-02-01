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
import javax.swing.ListModel;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.dominio.Etiqueta;

public class DialogoBusquedaArchivos extends JDialog {
	/**
	 * 
	 */
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
	/* Acción de los botones */
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
		etiquetas.setToolTipText("Lista de etiquetas");

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
		etiquetasSeleccionadas.setToolTipText("Etiquetas seleccionadas");

		scrollpaneEtiquetasSeleccionadas = new JScrollPane(etiquetasSeleccionadas);
		scrollpaneEtiquetasSeleccionadas.setBounds(635, 30, 180, 200);

		listaEtiquetasSeleccionadasModel = new DefaultListModel<>();
		listaEtiquetasSeleccionadasModel.addElement("Trabajo");
		listaEtiquetasSeleccionadasModel.addElement("Personal");
		listaEtiquetasSeleccionadasModel.addElement("Proyecto Importante");
		listaEtiquetasSeleccionadasModel.addElement("Recordatorio");
		listaEtiquetasSeleccionadasModel.addElement("Reunión");
		listaEtiquetasSeleccionadasModel.addElement("Urgente");
		listaEtiquetasSeleccionadasModel.addElement("Compra");
		listaEtiquetasSeleccionadasModel.addElement("Aniversario");
		listaEtiquetasSeleccionadasModel.addElement("Evento Social");
		listaEtiquetasSeleccionadasModel.addElement("Estudio");
		listaEtiquetasSeleccionadasModel.addElement("Familia");
		listaEtiquetasSeleccionadasModel.addElement("Ocio");
		listaEtiquetasSeleccionadasModel.addElement("Vacaciones");

		JLabel listaArchivos = new JLabel("Lista de archivos: ");
		listaArchivos.setBounds(220, 200, 220, 150);
		listaArchivos.setDisplayedMnemonic(KeyEvent.VK_A);

		archivos = new JList<String>();
		archivos.setBounds(350, 260, 350, 150);
		archivos.setToolTipText("Lista de archivos encontrados");

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

		accionBotonAgregar = new AbstractAction("Agregar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				agregarEtiqueta();

			}
		};
		accionBotonQuitar = new AbstractAction("Quitar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				quitarEtiqueta();

			}
		};
		accionBotonBuscar = new AbstractAction("Buscar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				buscarEtiqueta();

			}
		};
		accionBotonAbrirArchivo = new AbstractAction("Abrir archivo",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				abrirArchivo();

			}
		};
		accionBotonExportar = new AbstractAction("Exportar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/exportar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				exportarArchivo();

			}
		};
		agregar = new JButton(accionBotonAgregar);
		accionBotonAgregar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
		accionBotonAgregar.putValue(Action.SHORT_DESCRIPTION, "Agrega la etiqueta seleccionada");
		accionBotonAgregar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_G));
		agregar.getActionMap().put("Agregar", accionBotonAgregar);
		agregar.setHorizontalTextPosition(JButton.TRAILING);
		agregar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonAgregar.getValue(Action.ACCELERATOR_KEY), "Agregar");
		agregar.setBounds(450, 80, 125, 40);

		quitar = new JButton(accionBotonQuitar);
		accionBotonQuitar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		accionBotonQuitar.putValue(Action.SHORT_DESCRIPTION, "Elimina la etiqueta seleccionada");
		accionBotonQuitar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));
		quitar.getActionMap().put("Quitar", accionBotonQuitar);
		quitar.setHorizontalTextPosition(JButton.TRAILING);
		quitar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonQuitar.getValue(Action.ACCELERATOR_KEY), "Quitar");
		quitar.setBounds(450, 150, 120, 40);

		buscar = new JButton(accionBotonBuscar);
		accionBotonBuscar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		accionBotonBuscar.putValue(Action.SHORT_DESCRIPTION, "Busca los archivos con las etiquetas seleccionadas");
		accionBotonBuscar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_B));
		buscar.getActionMap().put("Buscar", accionBotonBuscar);
		buscar.setHorizontalTextPosition(JButton.TRAILING);
		buscar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonBuscar.getValue(Action.ACCELERATOR_KEY), "Buscar");
		buscar.setBounds(275, 465, 120, 40);

		abrirArchivo = new JButton(accionBotonAbrirArchivo);
		accionBotonAbrirArchivo.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		accionBotonAbrirArchivo.putValue(Action.SHORT_DESCRIPTION, "Abre el archivos selecionados");
		accionBotonAbrirArchivo.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_R));
		abrirArchivo.getActionMap().put("Abrir archivo", accionBotonAbrirArchivo);
		abrirArchivo.setHorizontalTextPosition(JButton.TRAILING);
		abrirArchivo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonAbrirArchivo.getValue(Action.ACCELERATOR_KEY), "Abrir archivo");
		abrirArchivo.setBounds(425, 465, 145, 40);

		exportar = new JButton(accionBotonExportar);
		accionBotonExportar.putValue(Action.ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		accionBotonExportar.putValue(Action.SHORT_DESCRIPTION, "Mueve los archivos a una carpeta");
		accionBotonExportar.putValue(Action.MNEMONIC_KEY, new Integer(KeyEvent.VK_X));
		exportar.getActionMap().put("Exportar", accionBotonExportar);
		exportar.setHorizontalTextPosition(JButton.TRAILING);
		exportar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put((KeyStroke) accionBotonExportar.getValue(Action.ACCELERATOR_KEY), "Exportar");
		exportar.setBounds(600, 465, 120, 40);

		/* mostras los componentes en el dialogo */
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
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	// Agregar etiqueta al campo de etiquetas seleccionadas
	private void agregarEtiqueta() {

	}

	// Buscar aquellos archivos con las etiquetas seleccionadas
	private void buscarEtiqueta() {

	}

	// Remover etiqueta selecionada
	private void quitarEtiqueta() {

	}

	// Abrir archivos seleccionados
	private void abrirArchivo() {

	}

	// Aceptación de archivos específicos.
	private void aceptarArchivo() {

	}

	// exportar los archivos a una carpeta
	private void exportarArchivo() {

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
