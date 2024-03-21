package ivmatisfilesorter.dominio;

import javax.swing.JOptionPane;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;
import ivmatisfilesorter.exception.ExceptionBaseDatosEtiqueta;
/**
 * Sirve para representar una etiqueta asociada a archivos en el sistema.
 * <p>
 * Las características de la clase <code>Etiqueta</code> son:
 * <ul>
 *	<li><code>etiqueta</code> para el nombre de la etiqueta.</li>
 *	<li><code>listaArchivosArchivo</code> para la lista de etiquetas.</li>
 *	</ul>
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
public class Etiqueta extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Nombre de la etiqueta. */
    private String etiqueta;
    
    /** Lista de archivos asociados a la etiqueta. */
    private Archivo listaArchivosArchivo;

    /**
     * Obtiene la lista de archivos asociados a la etiqueta.
     * @return La lista de archivos asociados a la etiqueta.
     */
    public Archivo getListaArchivosArchivo() {
        return listaArchivosArchivo;
    }

    /**
     * Establece la lista de archivos asociados a la etiqueta.
     * @param listaArchivosArchivo La nueva lista de archivos asociados a la etiqueta.
     */
    public void setListaArchivosArchivo(Archivo listaArchivosArchivo) {
        this.listaArchivosArchivo = listaArchivosArchivo;
    }

    /**
     * Obtiene el nombre de la etiqueta.
     * @return El nombre de la etiqueta.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece el nombre de la etiqueta.
     * @param etiqueta El nuevo nombre de la etiqueta.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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
     * Representación en cadena de caracteres de la instancia de la clase Etiqueta.
     * @return Una cadena de caracteres que representa la instancia de la clase Etiqueta.
     */
    @Override
    public String toString() {
        return "Etiqueta [etiqueta=" + etiqueta + ", archivo=" + listaArchivosArchivo + ", proyecto=" + "]";
    }
}