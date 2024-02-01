package ivmatisfilesorter.gui;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	private JButton aceptar;
	private JButton exportar;

	private Archivo listaArchivos[];

	public DialogoBusquedaArchivos(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Búsqueda de archivos", true);
		
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));
		/* contenido del dialogo */
		JPanel contenido = new JPanel(null);

		JLabel etiquetasDisponibles = new JLabel("Listado de etiquetas disponibles: ");
		etiquetasDisponibles.setBounds(30, 20, 200, 60);
		etiquetasDisponibles.setDisplayedMnemonic(KeyEvent.VK_L);

		etiquetas = new JList<String>();
		etiquetas.setBounds(220, 30, 150, 200);
		etiquetas.setToolTipText("Lista de etiquetas");

		scrollpaneEtiquetas = new JScrollPane(etiquetas);
		scrollpaneEtiquetas.setBounds(220, 30, 150, 200);

		listaEtiquetasModel = new DefaultListModel<>();
		listaEtiquetasModel.addElement("Los hermanos");
		listaEtiquetasModel.addElement("Bruce Wayne");

		JLabel seleccionadas = new JLabel("Listado de etiquetas seleccionadas: ");
		seleccionadas.setBounds(425, 20, 220, 60);
		seleccionadas.setDisplayedMnemonic(KeyEvent.VK_E);

		etiquetasSeleccionadas = new JList<String>();
		etiquetasSeleccionadas.setBounds(635, 30, 150, 200);
		etiquetasSeleccionadas.setToolTipText("Etiquetas seleccionadas");

		scrollpaneEtiquetasSeleccionadas = new JScrollPane(etiquetasSeleccionadas);
		scrollpaneEtiquetasSeleccionadas.setBounds(635, 30, 150, 200);

		listaEtiquetasSeleccionadasModel = new DefaultListModel<>();
		listaEtiquetasSeleccionadasModel.addElement("Los hermanos");
		listaEtiquetasSeleccionadasModel.addElement("Bruce Wayne");

		JLabel listaArchivos = new JLabel("Lista de archivos: ");
		listaArchivos.setBounds(220, 200, 220, 150);
		listaArchivos.setDisplayedMnemonic(KeyEvent.VK_A);
		

		archivos = new JList<String>();
		archivos.setBounds(350, 260, 350, 150);
		archivos.setToolTipText("Lista de archivos encontrados");

		scrollpaneArchivos = new JScrollPane(archivos);
		scrollpaneArchivos.setBounds(350, 260, 350, 150);

		listaArchivosModel = new DefaultListModel<>();
		listaArchivosModel.addElement("Los hermanos");
		listaArchivosModel.addElement("Bruce Wayne");

		agregar = new JButton("Agregar");
		agregar.setBounds(450, 120, 125, 40);
		agregar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png")));
		agregar.setToolTipText("Agrega la etiqueta");
		agregar.setMnemonic(KeyEvent.VK_G);

		buscar = new JButton("Buscar");
		buscar.setBounds(805, 60, 120, 40);
		buscar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));
		buscar.setToolTipText("Busca los archivos con las etiquetas seleccionadas");
		buscar.setMnemonic(KeyEvent.VK_B);

		quitar = new JButton("Quitar");
		quitar.setBounds(810, 150, 110, 40);
		quitar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png")));
		quitar.setToolTipText("Elimina la etiqueta seleccionada");
		quitar.setMnemonic(KeyEvent.VK_Q);

		abrirArchivo = new JButton("Abrir archivo");
		abrirArchivo.setBounds(275, 465, 145, 40);
		abrirArchivo.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png")));
		abrirArchivo.setToolTipText("Abre los archivos selecionados");
		abrirArchivo.setMnemonic(KeyEvent.VK_R);

		aceptar = new JButton("Aceptar");
		aceptar.setBounds(450, 465, 125, 40);
		aceptar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/aceptar.png")));
		aceptar.setToolTipText("Guardar todos los cambios");
		aceptar.setMnemonic(KeyEvent.VK_P);

		exportar = new JButton("Exportar");
		exportar.setBounds(600, 465, 120, 40);
		exportar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/exportar.png")));
		exportar.setToolTipText("Mueve los archivos a una carpeta");
		exportar.setMnemonic(KeyEvent.VK_X);
		

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
		contenido.add(aceptar);
		contenido.add(exportar);

		this.add(contenido);

		this.setSize(950, 600);
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	//Agregar etiqueta al campo de etiquetas seleccionadas
	private void agregarEtiqueta() {

	}
	//Buscar aquellos archivos con las etiquetas seleccionadas
	private void buscarEtiqueta() {

	}
	//Remover etiqueta selecionada
	private void quitarEtiqueta() {

	}
	//Abrir archivos seleccionados
	private void abrirArchivo() {

	}
	//Aceptación de archivos específicos.
	private void aceptarArchivo() {

	}
	//exportar los archivos a una carpeta
	private void exportarArchivo() {

	}

	// coordina acciones iniciales para establecer el estado inicial de la
	// interfaz de usuario.
	private void inicializar() {

	}

	@SuppressWarnings("unused")
	// realiza la acción de permitir la edición o interacción con varios
	// componentes de la interfaz gráfica
	private void habilitarCampos() {

	}

	@SuppressWarnings("unused")
	// realiza la acción de impedir la edición o interacción con varios
	// componentes de la interfaz gráfica
	private void deshabilitarCampos() {

	}

	@SuppressWarnings("unused")
	// La política de foco se basa en el orden en el que se añadieron los
	// componentes al vector
	private void establecerPoliticaFoco() {

	}
}
