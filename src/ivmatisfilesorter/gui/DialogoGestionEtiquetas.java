package ivmatisfilesorter.gui;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DialogoGestionEtiquetas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField etiqueta;
	private JList<String> listaEtiquetas;
	private JScrollPane scrollpaneEtiquetas;

	private JButton nuevo;
	private JButton guardar;
	private JButton modificar;
	private JButton eliminar;
	private JButton cancelar;

	private DefaultListModel<String> listaEtiquetasModel = new DefaultListModel<>();

	public DialogoGestionEtiquetas(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de etiquetas", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetas = new JLabel("Etiqueta: ");
		etiquetas.setBounds(230, 20, 150, 50);

		etiqueta = new JTextField();
		etiqueta.setBounds(400, 30, 250, 30);

		JLabel etiquetasLista = new JLabel("Lista de etiquetas: ");
		etiquetasLista.setBounds(230, 150, 250, 30);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(400, 150, 250, 250);

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(400, 150, 250, 250);

		listaEtiquetasModel = new DefaultListModel<>();
		listaEtiquetasModel.addElement("Los hermanos");
		listaEtiquetasModel.addElement("Bruce Wayne");

		nuevo = new JButton("Nuevo");
		nuevo.setBounds(140, 465, 120, 50);
		nuevo.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/nuevo.png")));

		guardar = new JButton("Guardar");
		guardar.setBounds(270, 465, 120, 50);
		guardar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png")));

		modificar = new JButton("Modificar");
		modificar.setBounds(400, 465, 125, 50);
		modificar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png")));

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(535, 465, 120, 50);
		eliminar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png")));

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(665, 465, 125, 50);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png")));

		/**/
		contenido.add(etiquetas);
		contenido.add(etiquetasLista);

		/**/
		contenido.add(etiqueta);
		listaEtiquetas.setModel(listaEtiquetasModel);
		contenido.add(scrollpaneEtiquetas);

		contenido.add(nuevo);
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
