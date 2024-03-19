package ivmatisfilesorter.exception;

public class ExceptionProyecto extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public static final String[] IVMATIS_EXCEPTION_NOMBRE_PROYECTO_OBLIGATORIO = {
			"El nombre del proyecto es obligatorio", "Ingresar nombre del proyecto" };

	/**
	 * El titulo asociado con la exception
	 */
	public String titulo;

	/**
	 * Contructor para crear la excepciósn.
	 * 
	 * @param msg
	 */
	public ExceptionProyecto(String[] msg) {
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
