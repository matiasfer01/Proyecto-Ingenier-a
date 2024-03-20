package ivmatisfilesorter.exception;

/**
 * 
 * Sirve para manejo excepciones personalizadas relacionadas con base de datos
 * archivos.
 * <p>
 * Las caracteristicas de la clases<code>ExceptionBaseDatosArchivo</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_ELEGIR_ARCHIVO</code> para cuando el archivo no
 * se encuentra en el sistema.</li>
 * <li><code>IVMATIS_EXCEPTION_VISUALIZACION_ARCHIVO</code> para cuando los
 * archivos del sistema no se pueden visualizar debido a errores.</li>
 * <li><code>IVMATIS_EXCEPTION_SELECCION_ARCHIVO</code> para cuando se intenta
 * abrir un archivo sin haber seleccionado uno previamente.</li>
 * <li><code>IVMATIS_EXCEPTION_EXPORTACION_FALLIDA </code> para cuando la
 * exportación de archivos no se puede realizar debido a errores en el
 * sistema.</li>
 * <li><code>IVMATIS_EXCEPTION_EXPORTACION_VISUALIZACION_ETIQUETAS </code> para
 * cuando las etiquetas del sistema no se pueden visualizar debido a
 * errores.</li>
 * </ul>
 * 
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefania Hernandez Perez
 *
 */

public class ExceptionBaseDatosArchivo extends Exception {
	/**
	 * Identificador de serialización de la clase.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje para cuando el archivo no se encuentra en el sistema.
	 */
	public static final String[] IVMATIS_EXCEPTION_ELEGIR_ARCHIVO = {
			"El archivo no se encuentra en el sistema," + "\n Busque el archivo", "Elegir Archivo" };

	/**
	 * Mensaje para cuando los archivos del sistema no se pueden visualizar
	 * debido a errores.
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ARCHIVO = {
			"Los archivos del sistema no se pueden visualizar debido a errores" + "\n Inténtalo más tarde.",
			"Visualización de Archivos Interrumpida" };

	/**
	 * Mensaje para cuando se intenta abrir un archivo sin haber seleccionado
	 * uno previamente
	 */

	public static final String[] IVMATIS_EXCEPTION_SELECCION_ARCHIVO = { "Antes de abrir el archivo, seleccióne uno .",
			"Selecciónar archivo" };

	/**
	 * Mensaje para cuando la exportación de archivos no se puede realizar
	 * debido a errores en el sistema.
	 */

	public static final String[] IVMATIS_EXCEPTION_EXPORTACION_FALLIDA = {
			"La exportación de archivos no se puede realizar " + "\ndebido a errores en el sistema"
					+ " \nInténtelo mas tarde",
			"Exportación fallida" };
	/*
	 * Mensaje para cuando las etiquetas del sistema no se pueden visualizar
	 * debido a errores.
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETAS = {
			"Las etiquetas del sistema no se pueden visualizar debido a errores" + "\n Inténtalo más tarde.",
			"Visualización de etiquetas Interrumpida" };

	public String titulo;

	/**
	 * Contructor para crear la excepciósn.
	 * 
	 * @param msg
	 */
	public ExceptionBaseDatosArchivo(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * Obtiene el titulo asociado con la exception
	 * 
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo asocicado con la exception
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
