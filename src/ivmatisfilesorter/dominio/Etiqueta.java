package ivmatisfilesorter.dominio;

import javax.swing.JOptionPane;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;
import ivmatisfilesorter.exception.ExceptionBaseDatosEtiqueta;

/**
 * Sirve para representar una etiqueta asociada a archivos en el sistema.
 * <p>
 * Las caracter�sticas de la clase <code>Etiqueta</code> son:
 * <ul>
 * <li><code>etiqueta</code> para el nombre de la etiqueta.</li>
 * </ul>
 *
 * @version 21/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefan�a Hern�ndez P�rez
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
	 *             Si el nombre de la etiqueta es nulo o vac�o.
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
	 * M�todo para crear una nueva etiqueta.
	 */
	public void crearEtiqueta() {

	}

	/**
	 * M�todo para eliminar una etiqueta existente.
	 */
	public void eliminarEtiqueta() {

	}

	/**
	 * M�todo para modificar una etiqueta existente.
	 */
	public void modificarEtiqueta() {

	}

	/**
	 * M�todo para consultar una etiqueta.
	 */
	public void consultarEtiqueta() {

	}

	/**
	 * Representaci�n en cadena de caracteres de la instancia de la clase
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