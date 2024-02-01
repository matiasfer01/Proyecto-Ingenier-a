package ivmatisfilesorter.gui;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ivmatisfilesorter.dominio.Proyecto;

public class DialogoCrearProyecto extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**/
	private JTextField nombreProyecto;
	private JTextField propietario;
	private JDateChooser fechaDeCreacion;
	private JTextArea descripcion;
	/* Botones del dialogo */
	private JButton guardar;
	private JButton cancelar;

	private Proyecto proyecto[];

	public DialogoCrearProyecto(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		// TODO Auto-generated constructor stub
		super(parent, "Crear Proyecto", true);
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/crear.png")));

		/* contenido del dialogo */
		JPanel contenido = new JPanel(null);

		JLabel etiquetasNombre = new JLabel("Nombre del proyecto: ");
		etiquetasNombre.setBounds(50, 30, 150, 150);

		nombreProyecto = new JTextField();
		nombreProyecto.setBounds(180, 92, 150, 30);

		JLabel etiquetaFecha = new JLabel("Fecha de creación : ");
		etiquetaFecha.setBounds(500, 92, 150, 30);

		fechaDeCreacion = new JDateChooser();
		fechaDeCreacion.setBounds(650, 92, 150, 30);

		JLabel etiquetaPropietario = new JLabel("Propietario: ");
		etiquetaPropietario.setBounds(100, 240, 150, 150);

		propietario = new JTextField();
		propietario.setBounds(180, 300, 150, 30);

		JLabel etiquetaDescripcion = new JLabel("Descripción: ");
		etiquetaDescripcion.setBounds(500, 240, 150, 150);

		descripcion = new JTextArea();
		descripcion.setBounds(600, 300, 300, 100);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);

		guardar = new JButton("Guardar");
		guardar.setBounds(300, 465, 120, 40);
		guardar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png")));
		guardar.setToolTipText("Guarda el proyecto");

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(450, 465, 125, 40);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png")));
		cancelar.setToolTipText("Cancela la creación del proyecto");

		/* mostras los componentes en el dialogo */
		contenido.add(etiquetasNombre);
		contenido.add(etiquetaFecha);
		contenido.add(etiquetaPropietario);
		contenido.add(etiquetaDescripcion);

		/* mostrar campos */
		contenido.add(nombreProyecto);
		contenido.add(fechaDeCreacion);
		contenido.add(propietario);
		contenido.add(descripcion);
		/* mostrar los botones */
		contenido.add(guardar);
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
	private void guardarProyecto() {

	}

	@SuppressWarnings("unused")
	private void cancelarProyecto() {

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
