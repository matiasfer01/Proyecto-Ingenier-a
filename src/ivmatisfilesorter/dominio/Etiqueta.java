package ivmatisfilesorter.dominio;

import ivmatisfilesorter.exception.ExceptionEtiqueta;

public class Etiqueta extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String etiqueta;
	private Archivo listaArchivosArchivo;

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) throws ExceptionEtiqueta {
		this.etiqueta = etiqueta;
	}

	public void crearEtiqueta() {

	}

	public void eliminarEtiqueta() {

	}

	public void modificarEtiqueta() {

	}

	public void consultarEtiqueta() {

	}

	@Override
	public String toString() {
		return "Etiqueta [etiqueta=" + etiqueta + ", archivo=" + listaArchivosArchivo + ", proyecto=" + "]";
	}

}