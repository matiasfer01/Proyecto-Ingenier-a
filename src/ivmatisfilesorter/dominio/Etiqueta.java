package ivmatisfilesorter.dominio;

import javax.swing.JOptionPane;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;
import ivmatisfilesorter.exception.ExceptionBaseDatosEtiqueta;

/**
 * Sirve para representar una etiqueta asociada a archivos en el sistema.
 * <p>
 * Las características de la clase <code>Etiqueta</code> son:
 * <ul>
 * <li><code>etiqueta</code> para el nombre de la etiqueta.</li>
 * </ul>
 *
 * @version 21/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 * 
 * @see ExceptionBaseDatosEtiqueta
 * @see ExceptionBaseDatosArchivo
 */
public class Etiqueta {

	/** Nombre de la etiqueta. */
	private String etiqueta;

	/**
	 * Obtiene el nombre de la etiqueta.
	 * 
	 * @return El nombre de la etiqueta.
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * Establece el nombre de la etiqueta.
	 * 
	 * @param etiqueta
	 *            El nuevo nombre de la etiqueta.
	 * @throws ExceptionBaseDatosEtiqueta
	 *             Si el nombre de la etiqueta es nulo o vacío.
	 */
	public void setEtiqueta(String etiqueta) throws ExceptionBaseDatosEtiqueta {
		etiqueta = etiqueta.trim();
		if (etiqueta.isEmpty()) {
			throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_ETIQUETA_NULL);
		} else {
			this.etiqueta = etiqueta;
		}

	}

	/**
	 * Método para crear una nueva etiqueta.
	 */
	public void crearEtiqueta() {

	}

	/**
	 * Método para eliminar una etiqueta existente.
	 */
	public void eliminarEtiqueta() {

	}

	/**
	 * Método para modificar una etiqueta existente.
	 */
	public void modificarEtiqueta() {

	}

	/**
	 * Método para consultar una etiqueta.
	 */
	public void consultarEtiqueta() {

	}

	/**
	 * Representación en cadena de caracteres de la instancia de la clase
	 * Etiqueta.
	 * 
	 * @return Una cadena de caracteres que representa la instancia de la clase
	 *         Etiqueta.
	 */
	@Override
	public String toString() {
		return etiqueta;
	}
}