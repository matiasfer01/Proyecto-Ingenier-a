package ivmatisfilesorter.exception;

/**
 * 
 * Sirve para el manejo de excepciones personalizadas relacionadas con base de
 * datos archivos.
 * <p>
 * Las características de la clase <code>ExceptionBaseDatosArchivo</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_VISUALIZACION_ARCHIVO</code> para cuando los
 * archivos del sistema no se pueden visualizar debido a errores.</li>
 * <li><code>IVMATIS_EXCEPTION_SELECCION_ARCHIVO</code> para cuando se intenta
 * abrir un archivo sin haber seleccionado uno previamente.</li>
 * <li><code>IVMATIS_EXCEPTION_EXPORTACION_FALLIDA</code> para cuando la
 * exportación de archivos no se puede realizar debido a errores en el
 * sistema.</li>
 * <li><code>IVMATIS_EXCEPTION_EXPORTACION_VISUALIZACION_ETIQUETAS</code> para
 * cuando las etiquetas del sistema no se pueden visualizar debido a
 * errores.</li>
 * </ul>
 * 
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @autor Luis Fernando Matias Acevedo
 * @autor Ivonne Estefanía Hernández Pérez
 *
 */

public class ExceptionBaseDatosArchivo extends Exception {
	
	/**
	 * Identificador de serialización de la clase.
	 */
	
	private static final long serialVersionUID = 1L;

	
	/**
	 * Mensaje de excepción cuando no se pueden visualizar los archivos del sistema
	 * debido a errores.
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ARCHIVO = {
			"Los archivos del sistema no se pueden visualizar debido a errores." + "\n Intente más tarde.",
			"Visualización de archivos interrumpida" };

	/**
	 * Mensaje de excepción para cuando se intenta abrir un archivo sin haberlo
	 * seleccionado previamente.
	 */

	public static final String[] IVMATIS_EXCEPTION_SELECCION_ARCHIVO = { "Antes de abrir el archivo, seleccione uno.",
			"Seleccionar archivo" };

	/**
	 * Mensaje de excepción para cuando la exportación de archivos no se puede
	 * realizar debido a errores en el sistema.
	 */

	public static final String[] IVMATIS_EXCEPTION_EXPORTACION_FALLIDA = {
			"La exportación de archivos no se puede realizar " + "\ndebido a errores en el sistema."
					+ " \nIntente nuevamente más tarde.",
			"Exportación fallida" };

	/**
	 * Mensaje de excepción para cuando las etiquetas del sistema no se pueden
	 * visualizar debido a errores.
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETAS = {
			"Las etiquetas del sistema no se pueden visualizar debido a errores." + "\n Intente más tarde.",
			"Visualización de etiquetas interrumpida" };

	/**
	 * El título asociado con la excepción.
	 */

	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatosArchivo con un mensaje y
	 * un título específico.
	 * 
	 * @param msg 
	 * 			  Un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepción y el título. Se espera que el primer elemento sea el
	 *            mensaje de la excepción y el segundo elemento sea el título.
	 */
	
	public ExceptionBaseDatosArchivo(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * Obtiene el título asociado con la excepción.
	 * 
	 * @return titulo
	 */
	
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el título asocicado con la excepción.
	 * 
	 * @param titulo 
	 * 				El título de la excepción.
	 */
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
