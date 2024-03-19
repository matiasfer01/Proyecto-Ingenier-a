package ivmatisfilesorter.exception;

public class ExceptionEtiqueta extends Exception {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_DATOS_INCONCLUSOS = {
			"Las etiquetas no se pueden visualizar debido a errores en el sistema" + "\n Int�ntolo m�s tarde.",
			"Datos inconclusos" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ETIQUETA_REPETIDA = {
			"La etiqueta xxxx ya se encuentra en el cat�logo.", "Etiqueta repetida" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_GUARDAR_ETIQUETA = { "Etiqueta xxxx guardada exitosamente",
			"Guardar etiquetas" };

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_ELIMINACION_PROCESO = {
			"�Est� completamente seguro de eliminar la etiqueta? "
					+ "\n Tenga en cuenta que esta etiqueta esta asociada con algunos archivos",
			"Eliminaci�n en proceso" };

	/**
	 * 
	 */
	public static final String[] IVMATIS_EXCEPTION_ELINIMACION_EXITOSA = { "Etiqueta xxxx eliminada exitosamente",
			"Eliminaci�n exitosa" };

	public String titulo;

	/**
	 * Contructor para crear la excepci�sn.
	 * 
	 * @param msg
	 */
	public ExceptionEtiqueta(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * 
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
