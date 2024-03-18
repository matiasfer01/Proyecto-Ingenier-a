package ivmatisfilesorter.exception;

public class ExceptionPersonalizado extends Exception {
	private static final long serialVersionUID = 1L;

	// Excepciones relacionadas con acciones del usuario
	public static final String IVMATIS_EXCEPTION_ARCHIVO_NO_ENCONTRADO = "El archivo especificado no se encontró";
	public static final String IVMATIS_EXCEPTION_DIRECTORIO_NO_ENCONTRADO = "El directorio especificado no se encontró";
	public static final String IVMATIS_EXCEPTION_PERMISO_DENEGADO = "El usuario no tiene permiso para realizar esta acción";
	public static final String IVMATIS_EXCEPTION_FORMATO_INVALIDO = "El formato del archivo no es válido";
	// Puedes agregar más excepciones según las acciones específicas del usuario en
	// tu proyecto

	public ExceptionPersonalizado(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}

}
