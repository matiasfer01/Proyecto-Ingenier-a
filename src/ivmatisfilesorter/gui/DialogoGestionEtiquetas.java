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
import javax.swing.JTextField;

import ivmatisfilesorter.dominio.Etiqueta;

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
	private Etiqueta listaEtiqueta[];

	public DialogoGestionEtiquetas(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		super(parent, "Gestión de etiquetas", true);
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/ivmatisfilesorter/imagenes/gestion-de-etiquetas.png")));

		JPanel contenido = new JPanel(null);

		JLabel etiquetas = new JLabel("Etiqueta: ");
		etiquetas.setBounds(230, 20, 150, 50);
		etiquetas.setDisplayedMnemonic(KeyEvent.VK_E);

		etiqueta = new JTextField();
		etiqueta.setBounds(400, 30, 250, 30);
		etiqueta.setToolTipText("Nombre de la etiqueta");

		JLabel etiquetasLista = new JLabel("Lista de etiquetas: ");
		etiquetasLista.setBounds(230, 150, 250, 30);
		etiquetasLista.setDisplayedMnemonic(KeyEvent.VK_L);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(400, 150, 250, 250);
		listaEtiquetas.setToolTipText("Lista de etiquetas existentes");

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(400, 150, 250, 250);

		listaEtiquetasModel = new DefaultListModel<>();
		listaEtiquetasModel.addElement("Los hermanos");
		listaEtiquetasModel.addElement("Bruce Wayne");

		nuevo = new JButton("Nuevo");
		nuevo.setBounds(140, 465, 120, 50);
		nuevo.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/nuevo.png")));
		nuevo.setMnemonic(KeyEvent.VK_N);
		nuevo.setToolTipText("Permite crear una nueva etiqueta.");

		guardar = new JButton("Guardar");
		guardar.setBounds(270, 465, 120, 50);
		guardar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png")));
		guardar.setMnemonic(KeyEvent.VK_G);
		guardar.setToolTipText("Guarda cambios realizados.");

		modificar = new JButton("Modificar");
		modificar.setBounds(400, 465, 125, 50);
		modificar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png")));
		modificar.setMnemonic(KeyEvent.VK_M);
		modificar.setToolTipText("Modifica la etiqueta seleccionada.");

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(535, 465, 120, 50);
		eliminar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png")));
		eliminar.setMnemonic(KeyEvent.VK_E);
		eliminar.setToolTipText("Elimina la etiqueta seleccionada.");

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(665, 465, 125, 50);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png")));
		cancelar.setMnemonic(KeyEvent.VK_C);
		cancelar.setToolTipText("Cancela la edicion de la etiqueta.");

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
	//Permite agregar una nueva etiqueta.
	private void nuevaEtiqueta() {

	}
	//Permite guargar los cambios o las etiquetas agregadas.
	private void guardarEtiqueta() {

	}
	//Modifica la etiqueta seleccionada.
	private void modificarEtiqueta() {

	}
	//Elimina la etiqueta seleccionada definitivamente.
	private void eliminarEtiqueta() {

	}
	//cancelar la creacion de una nueva etiqueta
	private void cancelarEtiqueta() {

	}
	//coordina acciones iniciales para establecer el estado inicial de la interfaz de usuario. 
	private void inicializar() {

	}
	// realiza la acción de permitir la edición o interacción con varios componentes de la interfaz gráfica
	private void habilitarCampos() {

	}
	//realiza la acción de impedir la edición o interacción con varios componentes de la interfaz gráfica
	private void deshabilitarCampos() {

	}
	//La política de foco se basa en el orden en el que se añadieron los componentes al vector
	private void establecerPoliticaFoco() {

	}

}
