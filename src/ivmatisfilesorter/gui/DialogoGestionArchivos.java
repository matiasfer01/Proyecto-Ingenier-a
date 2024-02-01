package ivmatisfilesorter.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
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
	private JList<String> listaDeArchivos;
	private JScrollPane scrollpaneArchivo;
	private JTextField ruta;
	private JComboBox<String> etiquetas;
	private JList<String> listaEtiquetas;
	private JScrollPane scrollpaneEtiquetas;
	/* Modeles */
	private DefaultListModel<String> archivoListModel = new DefaultListModel<>();
	private DefaultListModel<String> etiquetasListModel = new DefaultListModel<>();
	private DefaultComboBoxModel<String> etiquetasComboBoxModel = new DefaultComboBoxModel<>();

	/* Botones del dialogo */
	private JButton selecccionarArchivo;
	private JButton agregar;
	private JButton quitar;
	private JButton guardar;
	private JButton modificar;
	private JButton eliminar;
	private JButton cancelar;

	/* Acciones para los botones */
	private Action accionBotonSeleccionar;
	private Action accionBotonAgregar;
	private Action accionBotonQuitar;
	private Action accionBotonGuardar;
	private Action accionBotonModificar;
	private Action accionBotonEliminar;
	private Action accionBotonCancelar;

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
		etiquetaListaArchivo.setDisplayedMnemonic(KeyEvent.VK_L);

		listaDeArchivos = new JList<String>();
		listaDeArchivos.setBounds(200, 30, 600, 80);
		listaDeArchivos.setToolTipText("Lista de archivos existentes");

		scrollpaneArchivo = new JScrollPane(listaDeArchivos);
		scrollpaneArchivo.setBounds(200, 30, 600, 80);

		archivoListModel = new DefaultListModel<>();
		archivoListModel.addElement("Mario Bros");
		archivoListModel.addElement("Super Mario Bros");

		JLabel etiquetaRuta = new JLabel("Ruta: ");
		etiquetaRuta.setBounds(150, 130, 100, 100);
		etiquetaRuta.setDisplayedMnemonic(KeyEvent.VK_R);

		ruta = new JTextField();
		ruta.setBounds(200, 170, 350, 30);
		ruta.setToolTipText("Direccion del archivo");

		JLabel etiquetaEtiquetas = new JLabel("Etiquetas");
		etiquetaEtiquetas.setBounds(150, 200, 100, 100);
		etiquetaEtiquetas.setDisplayedMnemonic(KeyEvent.VK_E);

		etiquetas = new JComboBox<>();
		etiquetas.setBounds(250, 240, 200, 30);
		etiquetas.setToolTipText("Lista de etiquetas");

		JLabel campoEtiqueta = new JLabel("Campo etiqueta: ");
		campoEtiqueta.setBounds(150, 260, 150, 100);
		campoEtiqueta.setDisplayedMnemonic(KeyEvent.VK_C);

		listaEtiquetas = new JList<String>();
		listaEtiquetas.setBounds(280, 305, 480, 130);
		listaEtiquetas.setToolTipText("Etiquetas seleccionadas");

		scrollpaneEtiquetas = new JScrollPane(listaEtiquetas);
		scrollpaneEtiquetas.setBounds(280, 305, 480, 130);

		etiquetasListModel = new DefaultListModel<>();
		etiquetasListModel.addElement("Los hermanos");
		etiquetasListModel.addElement("Bruce wayne");

		/* Accione de seleccionar */
		accionBotonSeleccionar = new AbstractAction("Seleccionar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/seleccione.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				seleccionarArchivo();

			}
		};

		/* Accion de agregar */
		accionBotonAgregar = new AbstractAction("Agregar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				seleccionarArchivo();

			}
		};

		/* Accion de quitar */
		accionBotonQuitar = new AbstractAction("Quitar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				quitarEtiqueta();

			}
		};

		/* Accion de Guardar */
		accionBotonGuardar = new AbstractAction("Guardar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				guardarArchivo();

			}

		};

		/* Accion de Modificar */
		accionBotonModificar = new AbstractAction("Modificar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/modificar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				modificarArchivo();

			}

		};
		
		/* Accion de Eliminar */
		accionBotonEliminar = new AbstractAction("Eliminar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				eliminarArchivo();

			}

		};
		
		/* Accion de Modificar */
		accionBotonCancelar = new AbstractAction("Cancelar",
				new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/modificar.png"))) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				modificarArchivo();

			}

		};

		selecccionarArchivo = new JButton("Seleccionar Archivo");
		selecccionarArchivo.setBounds(600, 160, 190, 50);
		selecccionarArchivo
				.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/seleccione.png")));
		selecccionarArchivo.setToolTipText("permite seleccionar un archivo");
		selecccionarArchivo.setMnemonic(KeyEvent.VK_S);

		agregar = new JButton("Agregar");
		agregar.setBounds(490, 230, 120, 50);
		agregar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/agregar.png")));
		agregar.setToolTipText("Agrega la etiqueta");
		agregar.setMnemonic(KeyEvent.VK_A);

		quitar = new JButton("Quitar");
		quitar.setBounds(650, 230, 120, 50);
		quitar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/quitar.png")));
		quitar.setToolTipText("Remover la etiqueta.");
		quitar.setMnemonic(KeyEvent.VK_Q);

		guardar = new JButton("Guardar");
		guardar.setBounds(205, 465, 120, 50);
		guardar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/guardar.png")));
		guardar.setToolTipText("Guarda el archivo.");
		guardar.setMnemonic(KeyEvent.VK_G);

		modificar = new JButton("Modificar");
		modificar.setBounds(345, 465, 125, 50);
		modificar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/editar.png")));
		modificar.setToolTipText("Modifica el archivo.");
		modificar.setMnemonic(KeyEvent.VK_M);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(490, 465, 120, 50);
		eliminar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/eliminar.png")));
		eliminar.setToolTipText("Elimina el archivo.");
		eliminar.setMnemonic(KeyEvent.VK_I);

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(630, 465, 125, 50);
		cancelar.setIcon(new ImageIcon(getClass().getResource("/ivmatisfilesorter/imagenes/cancelar.png")));
		cancelar.setToolTipText("Cancela la edicion del archivo.");
		cancelar.setMnemonic(KeyEvent.VK_N);

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
	// permite seleccionar un archivo
	private void seleccionarArchivo() {

	}

	@SuppressWarnings("unused")
	// agrega la etiqueta al panel
	private void agregarEtiqueta() {

	}

	@SuppressWarnings("unused")
	// Remover la etiqueta.
	private void quitarEtiqueta() {

	}

	@SuppressWarnings("unused")
	// Guardar el el archivo con las etiquetas seleccionadas
	private void guardarArchivo() {

	}

	@SuppressWarnings("unused")
	// Permite la modificación del archivo
	private void modificarArchivo() {

	}

	@SuppressWarnings("unused")
	// Eliminar el archivo definitivamente.
	private void eliminarArchivo() {

	}

	@SuppressWarnings("unused")
	// Cansela la edicion del archivo
	private void cancelarArchivo() {

	}

	@SuppressWarnings("unused")
	// coordina acciones iniciales para establecer el estado inicial de la
	// interfaz de usuario.
	private void inicializar() {

	}

	@SuppressWarnings("unused")
	// realiza la acción de permitir la edición o interacción con varios
	// componentes de la interfaz gráfica.
	private void habilitarCampos() {

	}

	@SuppressWarnings("unused")
	// realiza la acción de impedir la edición o interacción con varios
	// componentes de la interfaz gráfica.
	private void deshabilitarCampos() {

	}

	@SuppressWarnings("unused")
	// La política de foco se basa en el orden en el que se añadieron los
	// componentes al vector.
	private void establecerPoliticaFoco() {

	}

}
