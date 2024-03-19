package ivmatisfilesorter.exception;

public class ExceptionArchivo extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ELEGIR_ARCHIVO = {
			"El archivo no esta donde deberia y podria estar dañado" + "\n Intentelo buscarlo en otro lugar.",
	"Elegir Archivo" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DATOS_INCONCLUSOS_ARCHIVO = {
			"Los archivos no se pueden visualizar debido a errores en el sistema" + "\n Inténtolo más tarde.",
	"Datos inconclusos" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DATOS_INCONCLUSOS_ETIQUETA = {
			"Las etiquetas no se pueden visualizar debido a errores en el sistema" + "\n Inténtolo más tarde.",
	"Datos inconclusos" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_AGREGACION_FALLIDA = { "Seleccione una etiqueta antes de agregar.",
	"Agregación fallida" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ETIQUETA_REPETIDA = { "La etiqueta xxx ya ha sido agregada.",
	"Etiqueta repetida" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ELIMINACION_PROCESOS = { "Seleccione una etiqueta antes de quitar.",
	"Eliminacion en proceso" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_BUSQUEDA_PROCESO = {
			"La búsqueda no se puede realizar por errores del sistema" + "\n Inténtelo más tarde",
	"Búsqueda en proceso" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_SELECCION_INCONCLUSA = {
			"Antes de abrir el archivo, elija uno y selecciónelo.", "Selección inconclusa" };

	/**
	 * 
	 */

	public String titulo;

	/**
	 * Contructor para crear la excepciósn.
	 * 
	 * @param msg
	 */
	public ExceptionArchivo(String[] msg) {
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
