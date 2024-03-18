package ivmatisfilesorter.exception;

public class ExceptionPersonalizado extends Exception {
	private static final long serialVersionUID = 1L;

	// Excepciones relacionadas con acciones del usuario
	public static final String IVMATIS_EXCEPTION_ARCHIVO_NO_ENCONTRADO = "El archivo especificado no se encontr�";
	public static final String IVMATIS_EXCEPTION_DIRECTORIO_NO_ENCONTRADO = "El directorio especificado no se encontr�";
	public static final String IVMATIS_EXCEPTION_PERMISO_DENEGADO = "El usuario no tiene permiso para realizar esta acci�n";
	public static final String IVMATIS_EXCEPTION_FORMATO_INVALIDO = "El formato del archivo no es v�lido";
	// Puedes agregar m�s excepciones seg�n las acciones espec�ficas del usuario en
	// tu proyecto

	public ExceptionPersonalizado(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}

}
