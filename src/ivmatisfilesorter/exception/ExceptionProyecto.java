package ivmatisfilesorter.exception;

public class ExceptionProyecto extends Exception {
	private static final long serialVersionUID = 1L;
	public static final String IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO = "El nombre del proyecto es obligatorio";
	public static final String IVMATIS_EXCEPTION_NOMBRE_PROPIETARIO_NO_VACIO = "El nombre del propietario no puede estar vac�o";
	public static final String IVMATIS_EXCEPTION_DESCRIPCION_NO_VACIO = "La descripci�n no puede estar vac�a";
	public static final String IVMATIS_EXCEPTION_FECHA_CREACION_NO_VACIO = "La fecha de creaci�n no puede estar vac�a";
	// Constantes para datos opcionales
	public static final String IVMATIS_EXCEPTION_NOMBRE_PROPIETARIO_OPCIONAL = "Se recomienda proporcionar un nombre de propietario";
	public static final String IVMATIS_EXCEPTION_DESCRIPCION_OPCIONAL = "Se recomienda proporcionar una descripci�n del proyecto";
	public static final String IVMATIS_EXCEPTION_FECHA_CREACION_OPCIONAL = "Se recomienda proporcionar una fecha de creaci�n del proyecto";
}