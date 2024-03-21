package ivmatisfilesorter.dominio;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;

public class Archivo {
	/** Ruta del archivo. */
    private String rutaArchivo;
    
    /** Nombre del archivo. */
    private String nombreArchivo;
    
    /** Lista de etiquetas asociadas al archivo. */
    private Etiqueta listaEtiquetasEtiqueta;

    /**
     * Constructor por defecto de la clase Archivo.
     */
    public Archivo() {

    }

    /**
     * M�todo para consultar el archivo.
     */
    public void consultarArchivo() {

    }

    /**
     * M�todo para modificar el archivo.
     */
    public void modificarArchivo() {

    }

    /**
     * M�todo para eliminar el archivo.
     */
    public void eliminarArchivo() {

    }

    /**
     * M�todo para crear el archivo.
     */
    public void crearArchivo() {

    }

    /**
     * Obtiene la ruta del archivo.
     * @return La ruta del archivo.
     */
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    /**
     * Establece la ruta del archivo.
     * @param rutaArchivo La nueva ruta del archivo.
     */
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Obtiene el nombre del archivo.
     * @return El nombre del archivo.
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Establece el nombre del archivo.
     * @param nombreArchivo El nuevo nombre del archivo.
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Obtiene la lista de etiquetas asociadas al archivo.
     * @return La lista de etiquetas asociadas al archivo.
     */
    public Etiqueta getListaEtiquetas() {
        return listaEtiquetasEtiqueta;
    }

    /**
     * Establece la lista de etiquetas asociadas al archivo.
     * @param listaEtiquetas La nueva lista de etiquetas asociadas al archivo.
     */
    public void setListaEtiquetas(Etiqueta listaEtiquetas) {
        this.listaEtiquetasEtiqueta = listaEtiquetas;
    }

    /**
     * Representaci�n en cadena de caracteres de la instancia de la clase Archivo.
     * @return Una cadena de caracteres que representa la instancia de la clase Archivo.
     */
    @Override
    public String toString() {
        return "Archivo [rutaArchivo=" + rutaArchivo + ", nombreArchivo=" + nombreArchivo + ", etiqueta="
                + listaEtiquetasEtiqueta + ", proyecto=" + "]";
    }

}
