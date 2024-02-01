package ivmatisfilesorter.exception;

public class EtiquetaException extends Exception {
    private static final long serialVersionUID = 1L;

    public static final String ETIQUETA_VACIA = "La etiqueta no puede estar vac�a";
    public static final String ETIQUETA_INVALIDA = "La etiqueta es inv�lida";
    public static final String ETIQUETA_DUPLICADA = "La etiqueta ya existe";

    public EtiquetaException(String mensaje) {
        super(mensaje);
    }
}
