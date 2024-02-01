package ivmatisfilesorter.dominio;

import ivmatisfilesorter.exception.ArchivoException;


public class Archivo  {
	private String rutaArchivo;
	private String nombreArchivo;
	private Etiqueta listaEtiquetas;

	public Archivo() {

	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public void setRutaArchivo(String rutaArchivo)  throws ArchivoException{
		this.rutaArchivo = rutaArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo)  throws ArchivoException{
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
		return "Archivo [rutaArchivo=" + rutaArchivo + ", nombreArchivo=" + nombreArchivo + ", etiqueta=" + listaEtiquetas
				+ ", proyecto=" + "]";
	}

	public Etiqueta getListaEtiquetas() {
		return listaEtiquetas;
	}

	public void setListaEtiquetas(Etiqueta listaEtiquetas) {
		this.listaEtiquetas = listaEtiquetas;
	}

	
	
}
