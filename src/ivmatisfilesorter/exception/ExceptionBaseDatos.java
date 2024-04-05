package ivmatisfilesorter.exception;

/**
 * Sirve para el manejo de excepciones personalizadas relacionadas con la base
 * de datos.
 * <p>
 * Las caracter�sticas de la clase <code>ExceptionBaseDatos</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_BD_NO_ENCONTRADA</code> para cuando no sea la
 * base de datos correcta.</li>
 * <li><code>IVMATIS_EXCEPTION_NO_SE_ENCONTR�_DRIVER</code> para cuando el
 * controlador no sea el adecuado.</li>
 * <li><code>IVMATIS_EXCEPTION_DESCONEXI�N</code> para cuando ya se ha
 * desconectado de la base de datos.</li>
 * <li><code>IVMATIS_EXCEPTION_ERROR_EN_CONSULTA</code> para cuando ocurre un
 * error durante la recopilaci�n de informaci�n.</li>
 * <li><code>titulo</code> para el t�tulo de las excepciones.</li>
 * </ul>
 *
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefan�a Hern�ndez P�rez
 */

public class ExceptionBaseDatos extends Exception {

	/**
	 * Identificador de serializaci�n de la clase.
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de excepci�n para cuando no se encuentra la base de datos.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_BD_NO_ENCONTRADA = {
			"No se pudo encontrar la base de datos en el sistema.", "Sistema no encontrado" };
	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_BD_EN_ACCION = {
			"La operaci�n no se puede realizar debido errores del sistema", "Fallo en la operaci�n del sistema" };

	/**
	 * Mensaje de excepci�n para cuando no se encuentra el controlador necesario
	 * para la conexi�n de la base de datos.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_NO_SE_ENCONTRO_DRIVER = {
			"Los componentes necesarios para conectar " + "\n con el sistema no han sido localizados.",
			"Controladores no encontrados" };
	/**
	 * Mensaje de excepci�n para cuando la conexi�n con el sistema ya est�
	 * cerrada.
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DESCONEXION = { "La conexi�n con el sistema ya est� cerrada.",
			"Conexi�n cerrada" };

	/**
	 * Mensaje de excepci�n para cuando ocurre un error durante una consulta.
	 */

	public static final String[] IVMATIS_EXCEPTION_ERROR_EN_CONSULTA = {
			"La visualizaci�n de la informaci�n no es posible," + " \ndebido a errores en el sistema.",
			"Visualizaci�n interrumpida" };

	/**
	 * El t�tulo asociado con la excepci�n.
	 */

	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatos con un mensaje
	 * y un t�tulo espec�fico.
	 * 
	 * @param msg
	 *            Un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepci�n y el t�tulo. Se espera que el primer elemento sea el
	 *            mensaje de la excepci�n y el segundo elemento sea el t�tulo.
	 */

	public ExceptionBaseDatos(String[] msg) {
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
	 * Establece el t�tulo asociado con la excepci�n.
	 * 
	 * @param titulo
	 *            El t�tulo de la excepci�n.
	 */

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
