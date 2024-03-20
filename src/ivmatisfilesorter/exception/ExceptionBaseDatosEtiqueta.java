package ivmatisfilesorter.exception;

/**
 * Sirve para manejar excepciones personalizadas relacionadas con la base de
 * satos.
 * <p>
 * Las caracteristicas de la clase <code>ExceptionBaseDatos</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETA</code> para cuando no se
 * puedan visualizart la lista de etiquetas.</li>
 * <li><code>IVMATIS_EXCEPTION_ETIQUETA_NULL</code> para cuando el campo de
 * etiquetes este vacio.</li>
 * <li><code>IVMATIS_EXCEPTION_DESCONEXION</code> para cuando ya se ha
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
 * @author Ivonne Estefania Hernandez Perez
 * 
 * 
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
			"Las etiquetas no se pueden visualizar debido a errores en el sistema. Inténtelo más tarde.",
			"Datos inconclusos" };
	/**
	 * Mensaje de excepción para cuando se encuentre vacio el campo de
	 * etiquetas.
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_ETIQUETA_NULL = { "El campo de la etiqueta no puede estar vacío",
			"Campo de etiqueta vacío" };
	/**
	 * El título asociado con la excepción.
	 */
	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatosEtiqueta.
	 * 
	 * @param msg
	 *            un arreglo de cadenas de texto que contiene el mensaje de la
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
	 * @return el título de la excepción.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el título asociado con la excepción.
	 * 
	 * @param titulo
	 *            el título de la excepción.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
