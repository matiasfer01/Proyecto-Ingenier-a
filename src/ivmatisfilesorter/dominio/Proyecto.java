package ivmatisfilesorter.dominio;

import java.util.ArrayList;
import java.util.Date;

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
public class Proyecto {

	/** Nombre del proyecto. */
	private String nombreProyecto;

	/** Nombre del propietario del proyecto. */
	private String nombrePropietario;

	/** Descripci�n del proyecto. */
	private String descripcion;

	/** Fecha de creaci�n del proyecto. */
	private Date fechaCreacion;

	/** Lista de archivos asociados al proyecto. */
	private ArrayList<Archivo> listaArchivosProyecto;

	/** Lista de etiquetas asociadas al proyecto. */
	private ArrayList<Etiqueta> listaEtiquetasProyecto;

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
	 * excepci�n para indicar que es obligatorio proporcionar un nombre. De
	 * igual manera si el nombre del proyecto se encuentra repetido.
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

		}
		this.nombreProyecto = nombreProyecto;

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

	private ArrayList<Archivo> getListaArchivosProyecto() {
		return listaArchivosProyecto;
	}

	private ArrayList<Etiqueta> getListaEtiquetasProyecto() {
		return listaEtiquetasProyecto;
	}

	public void setListaArchivosProyecto(ArrayList<Archivo> listaArchivosProyecto) {
		this.listaArchivosProyecto = listaArchivosProyecto;
	}

	public void setListaEtiquetasProyecto(ArrayList<Etiqueta> listaEtiquetasProyecto) {
		this.listaEtiquetasProyecto = listaEtiquetasProyecto;
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

	@Override
	public String toString() {
		return nombreProyecto;
	}

}