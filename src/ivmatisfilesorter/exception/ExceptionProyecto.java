package ivmatisfilesorter.exception;

public class ExceptionProyecto extends Exception {
	private static final long serialVersionUID = 1L;
	public static final String IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO = "El nombre del proyecto es obligatorio";
	public static final String IVMATIS_EXCEPTION_NOMBRE_PROPIETARIO_NO_VACIO = "El nombre del propietario no puede estar vacío";
	public static final String IVMATIS_EXCEPTION_DESCRIPCION_NO_VACIO = "La descripción no puede estar vacía";
	public static final String IVMATIS_EXCEPTION_FECHA_CREACION_NO_VACIO = "La fecha de creación no puede estar vacía";
	// Constantes para datos opcionales
	public static final String IVMATIS_EXCEPTION_NOMBRE_PROPIETARIO_OPCIONAL = "Se recomienda proporcionar un nombre de propietario";
	public static final String IVMATIS_EXCEPTION_DESCRIPCION_OPCIONAL = "Se recomienda proporcionar una descripción del proyecto";
	public static final String IVMATIS_EXCEPTION_FECHA_CREACION_OPCIONAL = "Se recomienda proporcionar una fecha de creación del proyecto";
}
