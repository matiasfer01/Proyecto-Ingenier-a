package ivmatisfilesorter.exception;

public class BaseDatosException extends Exception {
    private static final long serialVersionUID = 1L;
    public static final String BD_NO_ENCONTRO_ARCHIVO = "La base de datos no encontró el archivo";
    public static final String NO_SE_PUDO_LEER_ARCHIVO = "No se pudo leer el archivo";
    public static final String NO_SE_PUDO_ESCRIBIR_ARCHIVO = "No se pudo escribir en el archivo";
    public static final String NO_SE_PUDO_CERRAR_ARCHIVO = "No se pudo cerrar el archivo";

    public BaseDatosException(String msg) {
        super(msg);
    }
}
