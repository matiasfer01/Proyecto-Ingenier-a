package ivmatisfilesorter.exception;

public class BaseDatosProyectoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static final String ERROR_INICIALIZAR_BD = "Error al inicializar la base de datos del proyecto: ";
    public static final String ERROR_VALIDAR_BD = "Error al validar la base de datos del proyecto: ";
    public static final String ERROR_CREAR_BD = "Error al crear la base de datos del proyecto: ";
    public static final String ERROR_LLENAR_BD = "Error al llenar la base de datos del proyecto: ";
    public static final String ERROR_CONSULTAR_ID_PROYECTO = "Error al consultar los IDs de proyecto: ";
    public static final String ERROR_CONSULTAR_PROYECTO = "Error al consultar proyectos: ";
    
    public BaseDatosProyectoException(String mensaje) {
        super(mensaje);
    }
}
