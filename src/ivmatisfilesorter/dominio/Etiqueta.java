package ivmatisfilesorter.dominio;

import javax.swing.JOptionPane;

import ivmatisfilesorter.exception.ExceptionEtiqueta;

public class Etiqueta extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String etiqueta;
	private Archivo listaArchivosArchivo;

	public Archivo getListaArchivosArchivo() {
		return listaArchivosArchivo;
	}

	public void setListaArchivosArchivo(Archivo listaArchivosArchivo) {
		try {
			if(listaArchivosArchivo == null){
				throw new ExceptionEtiqueta(ExceptionEtiqueta.IVMATIS_EXCEPTION_DATOS_INCONCLUSOS);
			}
			this.listaArchivosArchivo = listaArchivosArchivo;
		} catch (ExceptionEtiqueta e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), e2.getTitulo(), JOptionPane.ERROR_MESSAGE);

		}
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) throws ExceptionEtiqueta {
		try {
			if (etiqueta.isEmpty()) {
				throw new ExceptionEtiqueta(ExceptionEtiqueta.IVMATIS_EXCEPTION_ETIQUETA_REPETIDA);
			}
		} catch (ExceptionEtiqueta e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getTitulo(), JOptionPane.ERROR_MESSAGE);
		}
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