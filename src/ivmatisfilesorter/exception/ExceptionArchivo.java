package ivmatisfilesorter.exception;

public class ExceptionArchivo extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ELEGIR_ARCHIVO = {
			"El archivo no esta donde deberia y podria estar da�ado" + "\n Intentelo buscarlo en otro lugar.",
	"Elegir Archivo" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DATOS_INCONCLUSOS_ARCHIVO = {
			"Los archivos no se pueden visualizar debido a errores en el sistema" + "\n Int�ntolo m�s tarde.",
	"Datos inconclusos" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DATOS_INCONCLUSOS_ETIQUETA = {
			"Las etiquetas no se pueden visualizar debido a errores en el sistema" + "\n Int�ntolo m�s tarde.",
	"Datos inconclusos" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_AGREGACION_FALLIDA = { "Seleccione una etiqueta antes de agregar.",
	"Agregaci�n fallida" };

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
			"La b�squeda no se puede realizar por errores del sistema" + "\n Int�ntelo m�s tarde",
	"B�squeda en proceso" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_SELECCION_INCONCLUSA = {
			"Antes de abrir el archivo, elija uno y selecci�nelo.", "Selecci�n inconclusa" };

	/**
	 * 
	 */

	public String titulo;

	/**
	 * Contructor para crear la excepci�sn.
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
