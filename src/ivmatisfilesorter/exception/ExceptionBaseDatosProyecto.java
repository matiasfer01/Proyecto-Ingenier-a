package ivmatisfilesorter.exception;

/**
 * 
 * Sirve para el manejo de excepciones personalizadas relacionadas con base de
 * datos proyecto.
 * <p>
 * Las caracter�sticas de la clase <code>ExceptionBaseDatosProyecto</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO</code> para el nombre
 * del proyecto es obligatorio.</li>
 * <li><code>IVMATIS_EXCEPTION_NOMBRE_PROYECTO_REPETIR</code> para cuando se
 * intenta usar un nombre de proyecto que ya existe.</li>
 * <li><code>IVMATIS_EXCEPTION_ABRIR_PROYECTO</code> para cuando no se puede
 * encontrar el proyecto en el sistema.</li>
 * <li><code>IVMATIS_EXCEPTION_ARCHIVO_NO_COMPATIBLE</code> para cuando se
 * intenta abrir un archivo que no es de tipo .ivmatis.</li>
 * </ul>
 * 
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefan�a Hern�ndez P�rez
 *
 */

public class ExceptionBaseDatosProyecto extends Exception {

	/**
	 * Identificador de serializaci�n de la clase.
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje de excepci�n para indicar que el nombre del proyecto es obligatorio.
	 */

	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO = {
			"El nombre del proyecto es obligatorio.", "Ingrese el nombre del proyecto" };
	

	/**
	 * Mensaje de excepci�n para cuando se intenta usar un nombre de proyecto que ya
	 * existe.
	 */

	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO_REPETIR = { "El proyecto con ese nombre ya existe.",
			"Proyecto duplicado" };

	/**
	 * Mensaje de excepci�n para cuando no se puede encontrar el proyecto en el
	 * sistema.
	 */

	public static final String[] IVMATIS_EXCEPTION_ABRIR_PROYECTO = { "El proyecto no se encuentra en el sistema.",
			"Abrir proyecto" };

	/**
	 * Mensaje de excepci�n para cuando se intenta abrir un archivo que no es de
	 * tipo .ivmatis.
	 */

	public static final String[] IVMATIS_EXCEPTION_ARCHIVO_NO_COMPATIBLE = {
			"El archivo que intentas abrir no es de tipo .ivmatis.", "Archivo no compatible con el sistema" };

	/**
	 * El titulo asociado con la excepci�n.
	 */

	public String titulo;

	/**
	 * Constructor para crear una instancia de ExceptionBaseDatosProyecto con un
	 * mensaje y un t�tulo espec�fico.
	 * 
	 * @param msg 
	 * 			  Un arreglo de cadenas de texto que contiene el mensaje de la
	 *            excepci�n y el t�tulo. Se espera que el primer elemento sea el
	 *            mensaje de la excepci�n y el segundo elemento sea el t�tulo.
	 */

	public ExceptionBaseDatosProyecto(String[] msg) {
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
	 * 				El t�tulo de la excepci�n.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
