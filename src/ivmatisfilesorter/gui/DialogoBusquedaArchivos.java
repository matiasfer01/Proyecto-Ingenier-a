package ivmatisfilesorter.gui;

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

	private JList<Etiqueta> etiquetas;
	private JList<Etiqueta> etiquetasSeleccionadas;
	private JList<Archivo> archivos;
	private JScrollPane scrollpaneEtiquetas;
	private JScrollPane scrollpaneEtiquetasSeleccionadas;
	private JScrollPane scrollpaneArchivos;
	private ListModel<Etiqueta> listaEtiquetasModel = new DefaultListModel<>();
	private ListModel<Etiqueta> listaEtiquetasSeleccionadasModel = new DefaultListModel<>();
	private ListModel<Archivo> listaArchivosModel = new DefaultListModel<>();
	private JButton agregar;
	private JButton buscar;
	private JButton quitar;
	private JButton abrirArchivo;
	private JButton aceptar;
	private JButton exportar;
	
	private Archivo listaArchivos[];

	public DialogoBusquedaArchivos(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Búsqueda de archivos", true);
		/* contenido del dialogo */
		JPanel contenido = new JPanel(null);

		JLabel etiquetasDisponibles = new JLabel("Listado de etiquetas disponibles: ");
		etiquetasDisponibles.setBounds(30, 20, 200, 60);

		etiquetas = new JList<Etiqueta>();
		etiquetas.setBounds(220, 30, 150, 200);

		scrollpaneEtiquetas = new JScrollPane(etiquetas);
		scrollpaneEtiquetas.setBounds(220, 30, 150, 200);

		listaEtiquetasModel = new DefaultListModel<>();
		//listaEtiquetasModel.addElement("Los hermanos");
		//listaEtiquetasModel.addElement("Bruce Wayne");

		JLabel seleccionadas = new JLabel("Listado de etiquetas seleccionadas: ");
		seleccionadas.setBounds(425, 20, 220, 60);

		etiquetasSeleccionadas = new JList<Etiqueta>();
		etiquetasSeleccionadas.setBounds(635, 30, 150, 200);

		scrollpaneEtiquetasSeleccionadas = new JScrollPane(etiquetasSeleccionadas);
		scrollpaneEtiquetasSeleccionadas.setBounds(635, 30, 150, 200);

		listaEtiquetasSeleccionadasModel = new DefaultListModel<>();
		//listaEtiquetasModel.addElement("Los hermanos");
		//listaEtiquetasModel.addElement("Bruce Wayne");

		JLabel listaArchivos = new JLabel("Lista de archivos: ");
		listaArchivos.setBounds(220, 200, 220, 150);

		archivos = new JList<Archivo>();
		archivos.setBounds(350, 260, 350, 150);

		scrollpaneArchivos = new JScrollPane(archivos);
		scrollpaneArchivos.setBounds(350, 260, 350, 150);

		listaArchivosModel = new DefaultListModel<>();
		//listaArchivosModel.addElement("Los hermanos");
		//listaArchivosModel.addElement("Bruce Wayne");

		agregar = new JButton("Agregar");
		agregar.setBounds(450, 120, 125, 40);
		agregar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png")));

		buscar = new JButton("Buscar");
		buscar.setBounds(805, 60, 120, 40);
		buscar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/buscar.png")));

		quitar = new JButton("Quitar");
		quitar.setBounds(810, 150, 110, 40);
		quitar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png")));

		abrirArchivo = new JButton("Abrir archivo");
		abrirArchivo.setBounds(275, 465, 145, 40);
		abrirArchivo.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/abrir.png")));

		aceptar = new JButton("Aceptar");
		aceptar.setBounds(450, 465, 125, 40);
		aceptar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/aceptar.png")));

		exportar = new JButton("Exportar");
		exportar.setBounds(600, 465, 120, 40);
		exportar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/exportar.png")));

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
	
	

	private void agregarEtiqueta() {

	}

	private void buscarEtiqueta() {

	}

	private void quitarEtiqueta() {

	}

	private void abrirArchivo() {

	}

	private void aceptarArchivo() {

	}

	private void exportarArchivo() {

	}

	private void inicializar() {

	}

	private void habilitarCampos() {

	}

	private void establecerPoliticaFoco() {

	}

	private void deshabilitarCampos() {

	}

}
