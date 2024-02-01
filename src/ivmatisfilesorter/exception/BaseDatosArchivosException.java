package ivmatisfilesorter.exception;

public class BaseDatosArchivosException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static final String ERROR_INICIALIZAR_BD = "Error al inicializar la base de datos: ";
    public static final String ERROR_VALIDAR_BD = "Error al validar la base de datos: ";
    public static final String ERROR_CREAR_BD = "Error al crear la base de datos: ";
    public static final String ERROR_LLENAR_BD = "Error al llenar la base de datos: ";
    public static final String ERROR_CONSULTAR_ID_ARCHIVO = "Error al consultar los IDs de archivo: ";
    public static final String ERROR_CONSULTAR_ARCHIVO = "Error al consultar archivos: ";
    
    public BaseDatosArchivosException(String mensaje) {
        super(mensaje);
    }
}
