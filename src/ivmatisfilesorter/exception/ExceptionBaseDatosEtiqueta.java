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
 * error durante la recopilaci�n de informaci�n.</li>
 * <li><code>titulo</code> para el t�tulo de las excepciones.</li>
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
	 * Identificador de serializaci�n de la clase.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Mensaje de excepci�n para cuando no se pueda visualizar la lista de
	 * etiquetas.
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_VISUALIZACION_ETIQUETA = {
			"Las etiquetas no se pueden visualizar debido a errores en el sistema. Int�ntelo m�s tarde.",
			"Datos inconclusos" };
	/**
	 * Mensaje de excepci�n para cuando se encuentre vacio el campo de
	 * etiquetas.
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_ETIQUETA_NULL = { "El campo de la etiqueta no puede estar vac�o",
			"Campo de etiqueta vac�o" };
	/**
	 * El t�tulo asociado con la excepci�n.
	 */
	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatosEtiqueta.
	 * 
	 * @param msg
	 *            un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepci�n y el t�tulo. Se espera que el primer elemento sea el
	 *            mensaje de la excepci�n y el segundo elemento sea el t�tulo.
	 */
	public ExceptionBaseDatosEtiqueta(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * Obtiene el t�tulo asociado con la excepci�n.
	 * 
	 * @return el t�tulo de la excepci�n.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el t�tulo asociado con la excepci�n.
	 * 
	 * @param titulo
	 *            el t�tulo de la excepci�n.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
