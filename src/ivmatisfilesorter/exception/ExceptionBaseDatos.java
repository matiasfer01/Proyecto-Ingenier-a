package ivmatisfilesorter.exception;

/**
 * Sirve para el manejo de excepciones personalizadas relacionadas con la base
 * de datos.
 * <p>
 * Las características de la clase <code>ExceptionBaseDatos</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_BD_NO_ENCONTRADA</code> para cuando no sea la
 * base de datos correcta.</li>
 * <li><code>IVMATIS_EXCEPTION_NO_SE_ENCONTRÓ_DRIVER</code> para cuando el
 * controlador no sea el adecuado.</li>
 * <li><code>IVMATIS_EXCEPTION_DESCONEXIÓN</code> para cuando ya se ha
 * desconectado de la base de datos.</li>
 * <li><code>IVMATIS_EXCEPTION_ERROR_EN_CONSULTA</code> para cuando ocurre un
 * error durante la recopilación de información.</li>
 * <li><code>titulo</code> para el título de las excepciones.</li>
 * </ul>
 *
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 */

public class ExceptionBaseDatos extends Exception {

	/**
	 * Identificador de serialización de la clase.
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de excepción para cuando no se encuentra la base de datos.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_BD_NO_ENCONTRADA = {
			"No se pudo encontrar la base de datos en el sistema.", "Sistema no encontrado" };
	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_BD_EN_ACCION = {
			"La operación no se puede realizar debido errores del sistema", "Fallo en la operación del sistema" };

	/**
	 * Mensaje de excepción para cuando no se encuentra el controlador necesario
	 * para la conexión de la base de datos.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_NO_SE_ENCONTRO_DRIVER = {
			"Los componentes necesarios para conectar " + "\n con el sistema no han sido localizados.",
			"Controladores no encontrados" };
	/**
	 * Mensaje de excepción para cuando la conexión con el sistema ya está
	 * cerrada.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DESCONEXION = { "La conexión con el sistema ya está cerrada.",
			"Conexión cerrada" };

	/**
	 * Mensaje de excepción para cuando ocurre un error durante una consulta.
	 */

	public static final String[] IVMATIS_EXCEPTION_ERROR_EN_CONSULTA = {
			"La visualización de la información no es posible," + " \ndebido a errores en el sistema.",
			"Visualización interrumpida" };

	/**
	 * El título asociado con la excepción.
	 */

	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatos con un mensaje
	 * y un título específico.
	 * 
	 * @param msg
	 *            Un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepción y el título. Se espera que el primer elemento sea el
	 *            mensaje de la excepción y el segundo elemento sea el título.
	 */

	public ExceptionBaseDatos(String[] msg) {
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
