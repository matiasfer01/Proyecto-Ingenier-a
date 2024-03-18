package ivmatisfilesorter.exception;

public class ExceptionEtiqueta extends Exception {
	private static final long serialVersionUID = 1L;

	public static final String IVMATIS_EXCEPTION_ETIQUETA_VACIA = "La etiqueta no puede estar vacía";
	public static final String IVMATIS_EXCEPTION_ETIQUETA_INVALIDA = "La etiqueta es inválida";
	public static final String IVMATIS_EXCEPTION_ETIQUETA_DUPLICADA = "La etiqueta ya existe";

	public ExceptionEtiqueta(String mensaje) {
		super(mensaje);
	}
}
