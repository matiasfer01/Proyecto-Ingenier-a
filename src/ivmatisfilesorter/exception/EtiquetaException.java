package ivmatisfilesorter.exception;

public class EtiquetaException extends Exception {
    private static final long serialVersionUID = 1L;

    public static final String ETIQUETA_VACIA = "La etiqueta no puede estar vacía";
    public static final String ETIQUETA_INVALIDA = "La etiqueta es inválida";
    public static final String ETIQUETA_DUPLICADA = "La etiqueta ya existe";

    public EtiquetaException(String mensaje) {
        super(mensaje);
    }
}
