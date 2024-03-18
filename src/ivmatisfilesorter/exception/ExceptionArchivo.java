package ivmatisfilesorter.exception;

public class ExceptionArchivo extends Exception {

	private static final long serialVersionUID = 1L;
	/*
	 * El nombre de las constantes de las clases del paquete exception se determina
	 * utilizando el prefijo "IVMATIS_EXCEPTION_" seguido del error específico que
	 * genere, con una separación de guiones bajos entre las palabras.
	 */

	public static final String IVMATIS_EXCEPTION_RUTA_ARCHIVO_OBLIGATORIA = "La ruta del archivo es obligatoria";
	public static final String IVMATIS_EXCEPTION_NOMBRE_ARCHIVO_NO_VACIO = "El nombre del archivo no puede estar vacío";
	public static final String IVMATIS_EXCEPTION_RUTA_ARCHIVO_NO_VACIO = "La ruta del archivo no puede estar vacía";
	public static final String IVMATIS_EXCEPTION_NOMBRE_ARCHIVO_OBLIGATORIA = "El nombre del archivo es obligatorio";
}
