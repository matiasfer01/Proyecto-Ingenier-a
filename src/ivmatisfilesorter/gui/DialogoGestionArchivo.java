package ivmatisfilesorter.gui;

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

public class DialogoGestionArchivo extends JDialog {

	/* Componentes del dialogo */
	private JList<String> listaDeArchivos;
	private JScrollPane scrollpaneArchivo;
	private JTextField ruta;
	private JComboBox<String> etiquetas;
	private JList<String> listaEtiquetas;
	private JScrollPane scrollpaneEtiquetas;
	/* Modeles */
	private DefaultListModel<String> archivoListModel = new DefaultListModel<>();
	private DefaultListModel<String> etiquetasListModel = new DefaultListModel<>();

	/* Botones del dialogo */
	private JButton selecccionarArchivo;
	private JButton agregar;
	private JButton quitar;
	private JButton guardar;
	private JButton modificar;
	private JButton eliminar;
	private JButton cancelar;

	private static final long serialVersionUID = 1L;

	public DialogoGestionArchivo(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de archivos", true);

		/* contenido del dialogo */
		JPanel contenido = new JPanel(null);

		JLabel etiquetaListaArchivo = new JLabel("Lista de archivos: ");
		etiquetaListaArchivo.setBounds(70, 10, 120, 50);

		listaDeArchivos = new JList<String>();
		listaDeArchivos.setBounds(200, 30, 600, 80);

		scrollpaneArchivo = new JScrollPane(listaDeArchivos);
		scrollpaneArchivo.setBounds(200, 30, 600, 80);

		archivoListModel = new DefaultListModel<>();
		archivoListModel.addElement("Mario Bros");
		archivoListModel.addElement("Super Mario Bros");

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

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(280, 305, 480, 130);

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(280, 305, 480, 130);

		etiquetasListModel = new DefaultListModel<>();
		etiquetasListModel.addElement("Los hermanos");
		etiquetasListModel.addElement("Bruce wayne");

		selecccionarArchivo = new JButton("Seleccionar Archivo");
		selecccionarArchivo.setBounds(600, 160, 190, 50);
		selecccionarArchivo.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/seleccione.png")));

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
		cancelar.setBounds(630, 465,125, 50);
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

}
