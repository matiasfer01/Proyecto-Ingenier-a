package ivmatisfilesorter.exception;

public class ExceptionBaseDatosProyecto extends Exception {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO = {
			"El nombre del proyecto es obligatorio", "Ingresar nombre del proyecto" };

	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO__NO_REPETIR = {
			"Selecciona un nombre diferente para su proyecto", "El nombre del proyecto ya existe" };

	/**
	 * El titulo esta bien , mensaje esta mal.
	 */

	public static final String[] IVMATIS_EXCEPTION_ABRIR_PROYECTO = {
			"El proyecto no está donde deberia y podria estar dañado" + "\nInténtelo buscarlo en otro lugar.",
			"Abrir proyecto" };

	/**
	 * el titulo esta bien, el mensaje esta mal
	 */

	public static final String[] IVMATIS_EXCEPTION_ARCHIVO_NO_COMPATIBLE = {
			"El proyecto que estás intentando abrir no puede ser accedido" + "\n ya que está siendo utilizado",
			"Archivo no compatible con el sistema" };

	/**
	 * El titulo asociado con la exception
	 */

	public String titulo;

	/**
	 * Contructor para crear la excepciósn.
	 * 
	 * @param msg
	 */

	public ExceptionBaseDatosProyecto(String[] msg) {
		super(msg[0]);
		setTitulo(msg[1]);
	}

	/**
	 * Obtiene el titulo de la excepción.
	 * 
	 * @return titulo
	 */

	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * 
	 * @param titulo
	 */

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
