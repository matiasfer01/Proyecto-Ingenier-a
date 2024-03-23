package ivmatisfilesorter.dominio;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;

public class Archivo {
	private String rutaArchivo;
	private String nombreArchivo;
	private Etiqueta listaEtiquetasEtiqueta;

	public Archivo() {

	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo){
		this.nombreArchivo = nombreArchivo;
	}

	public void consultarArchivo() {

	}

	public void modificarArchivo() {

	}

	public void eliminarArchivo() {

	}

	public void crearArchivo() {

	}

	@Override
	public String toString() {
		return "Archivo [rutaArchivo=" + rutaArchivo + ", nombreArchivo=" + nombreArchivo + ", etiqueta="
				+ listaEtiquetasEtiqueta + ", proyecto=" + "]";
	}

	public Etiqueta getListaEtiquetas() {
		return listaEtiquetasEtiqueta;
	}

	public void setListaEtiquetas(Etiqueta listaEtiquetas) {
		this.listaEtiquetasEtiqueta = listaEtiquetas;
	}

}
