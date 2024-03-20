package ivmatisfilesorter.exception;

public class ExceptionBaseDatosArchivo extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	
	/**
	 * el titulo esta bien , mensaje esta mal
	 */
	public static final String[] IVMATIS_EXCEPTION_ELEGIR_ARCHIVO = {
			"El archivo no esta donde deberia y podria estar da�ado" + "\n Intentelo buscarlo en otro lugar.",
			"Elegir Archivo" };

	/**
	 * el mensaje esta bien  y mal el mensaje
	 */

	public static final String[] IVMATIS_EXCEPTION_DATOS_INCONCLUSOS_ARCHIVO = {
			"Los archivos no se pueden visualizar debido a errores en el sistema" + "\n Int�ntolo m�s tarde.",
			"Datos inconclusos" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_SELECCION_INCONCLUSA = {
			"Antes de abrir el archivo, selecci�nelo uno .", "Selecci�nar archivo" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_EXPORTACION_FALLIDA = {
			"La exportaci�n de archivos no se puede realizar debido a errores en el sistema" + " \nInt�ntelo mas tarde",
			"Exportaci�n fallida" };

	public String titulo;

	/**
	 * Contructor para crear la excepci�sn.
	 * 
	 * @param msg
	 */
	public ExceptionBaseDatosArchivo(String[] msg) {
		super(msg[0]);
		setTitulo(titulo);
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
