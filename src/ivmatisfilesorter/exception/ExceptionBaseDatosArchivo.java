package ivmatisfilesorter.exception;

/**
 * 
 * Sirve para el manejo de excepciones personalizadas relacionadas con base de
 * datos archivos.
 * <p>
 * Las caracter�sticas de la clase <code>ExceptionBaseDatosArchivo</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_VISUALIZACION_ARCHIVO</code> para cuando los
 * archivos del sistema no se pueden visualizar debido a errores.</li>
 * <li><code>IVMATIS_EXCEPTION_SELECCION_ARCHIVO</code> para cuando se intenta
 * abrir un archivo sin haber seleccionado uno previamente.</li>
 * <li><code>IVMATIS_EXCEPTION_EXPORTACION_FALLIDA</code> para cuando la
 * exportaci�n de archivos no se puede realizar debido a errores en el
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
 * @autor Ivonne Estefan�a Hern�ndez P�rez
 *
 */

public class ExceptionBaseDatosArchivo extends Exception {
	
	/**
	 * Identificador de serializaci�n de la clase.
	 */
	
	private static final long serialVersionUID = 1L;

	
	/**
	 * Mensaje de excepci�n cuando no se pueden visualizar los archivos del sistema
	 * debido a errores.
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ARCHIVO = {
			"Los archivos del sistema no se pueden visualizar debido a errores." + "\n Intente m�s tarde.",
			"Visualizaci�n de archivos interrumpida" };

	/**
	 * Mensaje de excepci�n para cuando se intenta abrir un archivo sin haberlo
	 * seleccionado previamente.
	 */

	public static final String[] IVMATIS_EXCEPTION_SELECCION_ARCHIVO = { "Antes de abrir el archivo, seleccione uno.",
			"Seleccionar archivo" };

	/**
	 * Mensaje de excepci�n para cuando la exportaci�n de archivos no se puede
	 * realizar debido a errores en el sistema.
	 */

	public static final String[] IVMATIS_EXCEPTION_EXPORTACION_FALLIDA = {
			"La exportaci�n de archivos no se puede realizar " + "\ndebido a errores en el sistema."
					+ " \nIntente nuevamente m�s tarde.",
			"Exportaci�n fallida" };

	/**
	 * Mensaje de excepci�n para cuando las etiquetas del sistema no se pueden
	 * visualizar debido a errores.
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETAS = {
			"Las etiquetas del sistema no se pueden visualizar debido a errores." + "\n Intente m�s tarde.",
			"Visualizaci�n de etiquetas interrumpida" };

	/**
	 * El t�tulo asociado con la excepci�n.
	 */

	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatosArchivo con un mensaje y
	 * un t�tulo espec�fico.
	 * 
	 * @param msg 
	 * 			  Un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepci�n y el t�tulo. Se espera que el primer elemento sea el
	 *            mensaje de la excepci�n y el segundo elemento sea el t�tulo.
	 */
	
	public ExceptionBaseDatosArchivo(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * Obtiene el t�tulo asociado con la excepci�n.
	 * 
	 * @return titulo
	 */
	
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el t�tulo asocicado con la excepci�n.
	 * 
	 * @param titulo 
	 * 				El t�tulo de la excepci�n.
	 */
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
