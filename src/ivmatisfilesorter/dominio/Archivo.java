package ivmatisfilesorter.dominio;

import java.util.ArrayList;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;



/**
 * Sirve para representar un archivo con su ruta, nombre del archivo y lista de
 * etiquetas asociadas.
 * <p>
 * Las características de la clase <code>Archivo</code> son:
 * <ul>
 * <li><code>rutaArchivo</code> para la ruta del archivo.</li>
 * <li><code>nombreArchivo</code>: para el nombre del archivo.</li>
 * <li><code>listaEtiquetasEtiqueta</code>para la lista de etiquetas asociadas
 * al archivo.</li>
 * </ul>
 *
 * @version 21/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 * 
 * @see ExceptionBaseDatosArchivo
 */
public class Archivo {
	/** Ruta del archivo. */
	private String rutaArchivo;

	/** Nombre del archivo. */
	private String nombreArchivo;

	/** Lista de etiquetas asociadas al archivo. */
	private ArrayList<Etiqueta> listaEtiquetas;

	/**
	 * Constructor por defecto de la clase Archivo.
	 */
	public Archivo() {

	}

	/**
	 * Método para consultar el archivo.
	 */
	public void consultarArchivo() {

	}

	/**
	 * Método para modificar el archivo.
	 */
	public void modificarArchivo() {

	}

	/**
	 * Método para eliminar el archivo.
	 */
	public void eliminarArchivo() {

	}

	/**
	 * Método para crear el archivo.
	 */
	public void crearArchivo() {

	}

	/**
	 * Obtiene la ruta del archivo.
	 * 
	 * @return La ruta del archivo.
	 */
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	/**
	 * Establece la ruta del archivo.
	 * 
	 * @param rutaArchivo
	 *            La nueva ruta del archivo.
	 */
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo; 
	}

	public ArrayList<Etiqueta> getListaEtiquetas() {
		return listaEtiquetas;
	}

	public void setListaEtiquetas(ArrayList<Etiqueta> listaEtiquetas) {
		this.listaEtiquetas = listaEtiquetas;
	}

	@Override
	public String toString() {
		return nombreArchivo;
	}

}
