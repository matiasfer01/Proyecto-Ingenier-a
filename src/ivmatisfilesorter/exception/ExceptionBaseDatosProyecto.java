package ivmatisfilesorter.exception;

/**
 * 
 * Sirve para manejar excepciones personalizadas relacionadas con base de datos
 * proyecto.
 * <p>
 * Las características de la clase <code>ExceptionBaseDatosProyecto</code> son:
 * <ul>
 * <li><code>IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO</code>: para el
 * nombre del proyecto es obligatorio.</li>
 * <li><code>IVMATIS_EXCEPTION_NOMBRE_PROYECTO_REPETIR</code>: para cuando se
 * intenta usar un nombre de proyecto que ya existe.</li>
 * <li><code>IVMATIS_EXCEPTION_ABRIR_PROYECTO</code>: para cuando no se puede
 * encontrar el proyecto en el sistema.</li>
 * <li><code>IVMATIS_EXCEPTION_ARCHIVO_NO_COMPATIBLE</code>: para cuando se
 * intenta abrir un archivo que no es de tipo .ivmatis.</li>
 * </ul>
 * 
 * @version 20/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @autor Luis Fernando Matias Acevedo
 * @autor Ivonne Estefania Hernandez Perez
 *
 */

public class ExceptionBaseDatosProyecto extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Mensaje para cuando el nombre del proyecto es obligatorio.
	 */
	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO = {
			"El nombre del proyecto es obligatorio", "Ingresar nombre del proyecto" };
	/**
	 * Mensaje para cuando se intenta usar un nombre de proyecto que ya existe.
	 */
	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO_REPETIR = { "El proyecto con ese nombre ya existe",
			"Proyecto duplicado" };

	/**
	 * Mensaje para cuando no se puede encontrar el proyecto en el sistema.
	 */
	public static final String[] IVMATIS_EXCEPTION_ABRIR_PROYECTO = { "El proyecto no se encuentra en el sistema",
			"Abrir proyecto" };

	/**
	 * Mensaje para cuando se intenta abrir un archivo que no es de tipo
	 * .ivmatis.
	 */
	public static final String[] IVMATIS_EXCEPTION_ARCHIVO_NO_COMPATIBLE = {
			"El archivo que intentas abrir no es de tipo .ivmatis", "Archivo no compatible con el sistema" };

	/**
	 * El titulo asociado con la excepción
	 */
	public String titulo;

	/**
	 * Contructor para crear la excepción.
	 * 
	 * @param msg
	 */
	public ExceptionBaseDatosProyecto(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * Obtiene el titulo de la excepción.
	 * 
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo asociado con la excepción.
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
