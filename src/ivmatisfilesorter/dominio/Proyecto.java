package ivmatisfilesorter.dominio;

import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;
import ivmatisfilesorter.exception.ExceptionBaseDatosProyecto;

/**
 * Sirve para representar un proyecto con su nombre, propietario, descripci�n,
 * fecha de creaci�n, lista de archivos asociados con sus respectivas lista de
 * etiquetas.
 * <p>
 * Las caracter�sticas de la clase <code>Archivo</code> son:
 * <ul>
 * <li><code>nombreProyecto</code> Para el nombre del proyecto.</li>
 * <li><code>nombrePropietario</code> Para el nombre del propietario.</li>
 * <li><code>descripcion</code> Para describir el proyecto.</li>
 * <li><code>fechaCreacion</code> para la fecha de craci�n.</li>
 * <li><code>listaArchivosArchivo</code> para la lista de archivos
 * asociada.</li>
 * <li><code>listaEtiquetasEtiqueta</code> para la lista de etiquetas asociadas
 * a los archivos.</li>
 * 
 * </ul>
 *
 * @version 21/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefan�a Hern�ndez P�rez
 * 
 * @see ExceptionBaseDatosArchivo
 * @see ExceptionBaseDatosproyecto
 */
public class Proyecto extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Nombre del proyecto. */
	private String nombreProyecto;

	/** Nombre del propietario del proyecto. */
	private String nombrePropietario;

	/** Descripci�n del proyecto. */
	private String descripcion;

	/** Fecha de creaci�n del proyecto. */
	private Date fechaCreacion;

	/** Lista de archivos asociados al proyecto. */
	private Archivo listaArchivosArchivo;

	/** Lista de etiquetas asociadas al proyecto. */
	private Etiqueta listaEtiquetasEtiqueta;

	/**
	 * Lista de proyectos.
	 * se utiliza para mostrar los nombres de los proyectos
	 */
	private JList<String> listaProyectos;

	/**
	 * Modelo de lista predeterminado que contiene los elementos que se mostrar�n en la lista de proyectos.
	 * Se utiliza para administrar los elementos que se muestran en la listaProyectos.
	 */
	private DefaultListModel<String> listaModeloProyecto = new DefaultListModel<>();


	/**
	 * Constructor por defecto de la clase Proyecto.
	 */
	public Proyecto() {

	}

	/**
	 * Obtiene el nombre del proyecto.
	 * 
	 * @return El nombre del proyecto.
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * Este metodo verifica si el nombre del proyecto est� vac�o, se lanza una
	 * excepci�n para indicar que es obligatorio proporcionar un nombre. 
	 * De igual manera si el nombre del proyecto se encuentra repetido.
	 * 
	 * @param nombreProyecto
	 *            El nuevo nombre del proyecto.
	 * @throws ExceptionBaseDatosProyecto
	 *             si el nombre del proyecto est� vac�o o ya existe.
	 */
	public void setNombreProyecto(String nombreProyecto) throws ExceptionBaseDatosProyecto {
		nombreProyecto = nombreProyecto.trim();
		if (nombreProyecto.isEmpty()) {
			throw new ExceptionBaseDatosProyecto(
					ExceptionBaseDatosProyecto.IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO);
		} else {
			for (int i = 0; i < listaModeloProyecto.getSize(); i++) {
				String nombProyecto = listaModeloProyecto.getElementAt(i);
				if (nombProyecto.equals(nombreProyecto)) {
					throw new ExceptionBaseDatosProyecto(
							ExceptionBaseDatosProyecto.IVMATIS_EXCEPTION_NOMBRE_PROYECTO_REPETIR);
				}
			}
			this.nombreProyecto = nombreProyecto;

		}
	}

	/**
	 * Obtiene el nombre del propietario del proyecto.
	 * 
	 * @return El nombre del propietario del proyecto.
	 */
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	/**
	 * Establece el nombre del propietario del proyecto.
	 * 
	 * @param nombrePropietario
	 *            El nuevo nombre del propietario del proyecto.
	 */
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	/**
	 * Obtiene la descripci�n del proyecto.
	 * 
	 * @return La descripci�n del proyecto.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripci�n del proyecto.
	 * 
	 * @param descripcion
	 *            La nueva descripci�n del proyecto.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la fecha de creaci�n del proyecto.
	 * 
	 * @return La fecha de creaci�n del proyecto.
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Establece la fecha de creaci�n del proyecto.
	 * 
	 * @param fechaCreacion
	 *            La nueva fecha de creaci�n del proyecto.
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * M�todo para consultar el proyecto.
	 */
	public void consultarProyecto() {

	}

	/**
	 * M�todo para crear el proyecto.
	 */
	public void crearProyecto() {

	}

	/**
	 * M�todo para modificar el proyecto.
	 */
	public void modificarProyecto() {

	}

	/**
	 * Obtiene la lista de archivos asociados al proyecto.
	 * 
	 * @return La lista de archivos asociados al proyecto.
	 */
	public Archivo getListaArchivos() {
		return listaArchivosArchivo;
	}

	/**
	 * Establece la lista de archivos asociados al proyecto.
	 * 
	 * @param listaArchivos
	 *            La nueva lista de archivos asociados al proyecto.
	 */
	public void setListaArchivos(Archivo listaArchivos) {
		this.listaArchivosArchivo = listaArchivos;
	}

	/**
	 * Obtiene la lista de etiquetas asociadas al proyecto.
	 * 
	 * @return La lista de etiquetas asociadas al proyecto.
	 */
	public Etiqueta getListaEtiquetas() {
		return listaEtiquetasEtiqueta;
	}

	/**
	 * Establece la lista de etiquetas asociadas al proyecto.
	 * 
	 * @param listaEtiquetas
	 *            La nueva lista de etiquetas asociadas al proyecto.
	 */
	public void setListaEtiquetas(Etiqueta listaEtiquetas) {
		this.listaEtiquetasEtiqueta = listaEtiquetas;
	}

}
