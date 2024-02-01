package ivmatisfilesorter.gui;

import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.dominio.Etiqueta;

public class DialogoGestionArchivos extends JDialog {

	/* Componentes del dialogo */
	private JList<Archivo> listaDeArchivos;
	private JScrollPane scrollpaneArchivo;
	private JTextField ruta;
	private JComboBox<Etiqueta> etiquetas;
	private JList<Etiqueta> listaEtiquetas;
	private JScrollPane scrollpaneEtiquetas;
	/* Modeles */
	private DefaultListModel<Archivo> archivoListModel = new DefaultListModel<>();
	private DefaultListModel<Etiqueta> etiquetasListModel = new DefaultListModel<>();
	private DefaultComboBoxModel<Etiqueta> etiquetasComboBoxModel = new DefaultComboBoxModel<>();

	/* Botones del dialogo */
	private JButton selecccionarArchivo;
	private JButton agregar;
	private JButton quitar;
	private JButton guardar;
	private JButton modificar;
	private JButton eliminar;
	private JButton cancelar;

	private Archivo listaArchivo[];

	private static final long serialVersionUID = 1L;

	public DialogoGestionArchivos(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de archivos", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-archivos.png")));

		/* contenido del dialogo */
		JPanel contenido = new JPanel(null);

		JLabel etiquetaListaArchivo = new JLabel("Lista de archivos: ");
		etiquetaListaArchivo.setBounds(70, 10, 120, 50);

		listaDeArchivos = new JList<Archivo>();
		listaDeArchivos.setBounds(200, 30, 600, 80);

		scrollpaneArchivo = new JScrollPane(listaDeArchivos);
		scrollpaneArchivo.setBounds(200, 30, 600, 80);

		archivoListModel = new DefaultListModel<>();
		// archivoListModel.removeElement("Mario Bros");
		// archivoListModel.removeElement("Super Mario Bros");

		JLabel etiquetaRuta = new JLabel("Ruta: ");
		etiquetaRuta.setBounds(150, 130, 100, 100);

		ruta = new JTextField();
		ruta.setBounds(200, 170, 350, 30);

		JLabel etiquetaEtiquetas = new JLabel("Etiquetas");
		etiquetaEtiquetas.setBounds(150, 200, 100, 100);

		etiquetas = new JComboBox<>();
		etiquetas.setBounds(250, 240, 200, 30);

		JLabel campoEtiqueta = new JLabel("Campo etiqueta: ");
		campoEtiqueta.setBounds(150, 260, 150, 100);

		listaEtiquetas = new JList<Etiqueta>();
		listaEtiquetas.setBounds(280, 305, 480, 130);

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(280, 305, 480, 130);

		etiquetasListModel = new DefaultListModel<>();
		// etiquetasListModel.removeElement("Los hermanos");
		// etiquetasListModel.removeElement("Bruce wayne");

		selecccionarArchivo = new JButton("Seleccionar Archivo");
		selecccionarArchivo.setBounds(600, 160, 190, 50);
		selecccionarArchivo
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/seleccione.png")));

		agregar = new JButton("Agregar");
		agregar.setBounds(490, 230, 120, 50);
		agregar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png")));

		quitar = new JButton("Quitar");
		quitar.setBounds(650, 230, 120, 50);
		quitar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png")));

		guardar = new JButton("Guardar");
		guardar.setBounds(205, 465, 120, 50);
		guardar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png")));

		modificar = new JButton("Modificar");
		modificar.setBounds(345, 465, 125, 50);
		modificar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png")));

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(490, 465, 120, 50);
		eliminar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png")));

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(630, 465, 125, 50);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png")));

		/* mostras los componentes en el dialogo */
		contenido.add(etiquetaListaArchivo);
		contenido.add(scrollpaneArchivo);
		contenido.add(etiquetaRuta);
		contenido.add(etiquetaEtiquetas);
		listaDeArchivos.setModel(archivoListModel);
		contenido.add(campoEtiqueta);

		/* mostrar campos */

		contenido.add(ruta);
		contenido.add(etiquetas);
		listaEtiquetas.setModel(etiquetasListModel);
		contenido.add(scrollpaneEtiquetas);
		/* Botones */
		contenido.add(selecccionarArchivo);
		contenido.add(agregar);
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

	@SuppressWarnings("unused")
	private void seleccionarArchivo() {

	}

	@SuppressWarnings("unused")
	private void agregarEtiqueta() {

	}

	@SuppressWarnings("unused")
	private void quitarEtiqueta() {

	}

	@SuppressWarnings("unused")
	private void aplicarArchivo() {

	}

	@SuppressWarnings("unused")
	private void modificarArchivo() {

	}

	@SuppressWarnings("unused")
	private void eliminarArchivo() {

	}

	@SuppressWarnings("unused")
	private void cancelarArchivo() {

	}

	@SuppressWarnings("unused")
	private void inicializar() {

	}

	@SuppressWarnings("unused")
	private void habilitarCampos() {

	}

	@SuppressWarnings("unused")
	private void deshabilitarCampos() {

	}

	@SuppressWarnings("unused")
	private void establecerPoliticaFoco() {

	}

}
