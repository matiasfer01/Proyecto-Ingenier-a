package ivmatisfilesorter.exception;

public class ExceptionBaseDatosEtiqueta extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String IVMATIS_EXCEPTION_ERROR_INICIALIZAR_BD = "Error al inicializar la base de datos de etiquetas: ";
	public static final String IVMATIS_EXCEPTION_ERROR_VALIDAR_BD = "Error al validar la base de datos de etiquetas: ";
	public static final String IVMATIS_EXCEPTION_ERROR_CREAR_BD = "Error al crear la base de datos de etiquetas: ";
	public static final String IVMATIS_EXCEPTION_ERROR_LLENAR_BD = "Error al llenar la base de datos de etiquetas: ";
	public static final String IVMATIS_EXCEPTION_ERROR_CONSULTAR_ID_ETIQUETA = "Error al consultar los IDs de etiqueta: ";
	public static final String IVMATIS_EXCEPTION_ERROR_CONSULTAR_ETIQUETA = "Error al consultar etiquetas: ";

	public ExceptionBaseDatosEtiqueta(String mensaje) {
		super(mensaje);
	}
}
