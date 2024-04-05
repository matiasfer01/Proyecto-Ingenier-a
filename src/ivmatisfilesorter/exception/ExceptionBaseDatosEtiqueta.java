package ivmatisfilesorter.exception;

/**
 * Sirve para el manejo de excepciones personalizadas relacionadas con la base
 * de datos de etiquetas.
 * <p>
 * Las características de la clase <code>ExceptionBaseDatosEtiqueta</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETA</code> para cuando no se
 * puedan visualizar la lista de etiquetas.</li>
 * <li><code>IVMATIS_EXCEPTION_ETIQUETA_NULL</code> para cuando el campo de
 * etiquetas se encuentre vacío.</li>
 * <li><code>titulo</code> para el título de las excepciones.</li>
 * </ul>
 * 
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 */

public class ExceptionBaseDatosEtiqueta extends Exception {

	/**
	 * Identificador de serialización de la clase.
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de excepción para cuando no se pueda visualizar la lista de
	 * etiquetas.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETA = {
			"Las etiquetas no se pueden visualizar debido a errores en el sistema.\n Intente más tarde.",
			"Visualización de etiquetas interrumpida" };

	/**
	 * Mensaje de excepción para cuando se encuentre vacío el campo de
	 * etiquetas.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ETIQUETA_VACIA = { "El campo de la etiqueta no puede estar vacío.",
			"Campo de etiqueta vacío" };

	/**
	 * 
	 *
	 */
	public static final String[] IVMATIS_EXCEPTION_ETIQUETA_REPETIDA = { "La etiqueta con ese nombre ya existe.",
			"Etiqueta duplicada" };
	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_CREAR_ETIQUETA = {
			"No se puede crear la etiqueta por errores en el sistema.",
			"Falla en la creación de etiqueta" };
	/**
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_ELIMINAR_ETIQUETA = {
			"La etiqueta no puede ser eliminada debido a errores en el sistema.",
			"Eliminar etiqueta" };
	/**
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_MODIFICAR_ETIQUETA = {
			"La etiqueta no puede ser modificada debido a errores en el sistema.",
			"Modificar etiqueta" };
	/**
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_CONSULTAR_ETIQUETA = {
			"Las etiquetas no pueden visualizar debido a errores en el sistema. \n Intente más tarde.",
			"Consultar etiqueta" };

	/**
	 * El título asociado con la excepción.
	 */

	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatosEtiqueta.
	 * 
	 * @param msg
	 *            Un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepción y el título. Se espera que el primer elemento sea el
	 *            mensaje de la excepción y el segundo elemento sea el título.
	 */
	public ExceptionBaseDatosEtiqueta(String[] msg) {
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
	 * Establece el título asociado con la excepción.
	 * 
	 * @param titulo
	 *            El título de la excepción.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
