package ivmatisfilesorter.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class DialogoPropiedadesProyecto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField nombreProyecto;
	private JTextField propitario;
	private JDateChooser fechaDeCreacion;
	private JTextArea descripcion;
	/* Botones del dialogo */
	private JButton editar;
	private JButton guardar;
	private JButton cancelar;
	private JButton nuevaEtiqueta;

	public DialogoPropiedadesProyecto(JFrame parent, VentanaPrincipal ventanaPrincipal) {
		// TODO Auto-generated constructor stub
		super(parent, "Propiedades del proyecto", true);
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ivmatisfilesorter/imagenes/propiedades.png")));

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

		propitario = new JTextField();
		propitario.setBounds(180, 300, 150, 30);

		JLabel etiquetaDescripcion = new JLabel("Descripción: ");
		etiquetaDescripcion.setBounds(500, 240, 150, 150);

		descripcion = new JTextArea();
		descripcion.setBounds(600, 300, 300, 100);
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);

		editar = new JButton("Editar");
		editar.setBounds(170, 465, 120, 40);
		editar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png")));
		editar.setToolTipText("Editar el proyecto");

		guardar = new JButton("Guardar");
		guardar.setBounds(310, 465, 150, 40);
		guardar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png")));
		guardar.setToolTipText("Guarda los cambios");

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(480, 465, 150, 40);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png")));
		cancelar.setToolTipText("Cansela la edición del proyecto");

		nuevaEtiqueta = new JButton("Nueva etiqueta");
		nuevaEtiqueta.setBounds(655, 465, 150, 40);
		nuevaEtiqueta.setToolTipText("Creas una nueva etiqueta");

		/* mostras los componentes en el dialogo */
		contenido.add(etiquetasNombre);
		contenido.add(etiquetaFecha);
		contenido.add(etiquetaPropietario);
		contenido.add(etiquetaDescripcion);

		/* mostrar campos */
		contenido.add(nombreProyecto);
		contenido.add(fechaDeCreacion);
		contenido.add(propitario);
		contenido.add(descripcion);
		/* mostrar los botones */
		contenido.add(editar);
		contenido.add(guardar);
		contenido.add(cancelar);
		contenido.add(nuevaEtiqueta);

		nuevaEtiqueta.addActionListener(new ClaseAnonima());

		this.add(contenido);

		this.setSize(950, 600);
		/* No se puede redimensionar */
		this.setResizable(false);
		/* Se destruirá cuando se cierre */
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	class ClaseAnonima implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(nuevaEtiqueta)) {
				DialogoGestionEtiquetas dialogoGestionEtiquetas = new DialogoGestionEtiquetas(null, null);
				dialogoGestionEtiquetas.setVisible(true);
			}

		}
	}

}
