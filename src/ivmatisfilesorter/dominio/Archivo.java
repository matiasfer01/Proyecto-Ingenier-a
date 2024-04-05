package ivmatisfilesorter.dominio;

import java.util.ArrayList;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;


/**
 * Sirve para representar un archivo con su ruta, nombre del archivo y lista de
 * etiquetas asociadas.
 * <p>
 * Las características de la clase <code>Archivo</code> son:
 * <ul>
 * <li><code>rutaArchivo</code> para la ruta del archivo.</li>
 * <li><code>nombreArchivo</code>: para el nombre del archivo.</li>
 * <li><code>listaEtiquetasEtiqueta</code>para la lista de etiquetas asociadas
 * al archivo.</li>
 * </ul>
 *
 * @version 21/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 * 
 * @see ExceptionBaseDatosArchivo
 */

public class Archivo {
	/** Ruta del archivo. */
	private String rutaArchivo;

	/** Nombre del archivo. */
	private String nombreArchivo;

	/** Lista de etiquetas asociadas al archivo. */
	private ArrayList<Etiqueta> listaEtiquetas;

	/**
	 * Constructor por defecto de la clase Archivo.
	 */
	public Archivo() {

	}

	/**
	 * Método para consultar el archivo.
	 */
	public void consultarArchivo() {
        try {
            throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_CONSULTA_ARCHIVO);
        } catch (ExceptionBaseDatosArchivo e) {
            // Manejo de la excepción ExceptionBaseDatosArchivo si es necesario
        }
    }

	/**
	 * Método para modificar el archivo.
	 */
	public void modificarArchivo() {
	    try {
	        // Lógica para modificar el archivo
	        // Si hay algún error en la modificación, lanzar la excepción correspondiente
	        throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_MODIFICAR_ARCHIVO);
	    } catch (ExceptionBaseDatosArchivo e) {
	        // Manejo de la excepción ExceptionBaseDatosArchivo si es necesario
	    }
	}

	/**
	 * Método para eliminar el archivo.
	 */
	public void eliminarArchivo() {
	    try {
	        // Lógica para eliminar el archivo
	        // Si hay algún error en la eliminación, lanzar la excepción correspondiente
	        throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_ELIMINAR_ARCHIVO);
	    } catch (ExceptionBaseDatosArchivo e) {
	        // Manejo de la excepción ExceptionBaseDatosArchivo si es necesario
	    }
	}

	/**
	 * Método para crear el archivo.
	 */
	public void crearArchivo() {
        try {
            throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_ARCHIVO_NO_ENCONTRADO);
        } catch (ExceptionBaseDatosArchivo e) {
            // Manejo de la excepción ExceptionBaseDatosArchivo si es necesario
        }
    }

	/**
	 * Obtiene la ruta del archivo.
	 * 
	 * @return La ruta del archivo.
	 */
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	/**
	 * Establece la ruta del archivo.
	 * 
	 * @param rutaArchivo
	 *            La nueva ruta del archivo.
	 */
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) throws ExceptionBaseDatosArchivo {
		nombreArchivo = nombreArchivo.trim();
		if (nombreArchivo.isEmpty()) {
			throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_NOMBRE_ARCHIVO_VACIO);
		} else {
			this.nombreArchivo = nombreArchivo;
		}

	}

	public ArrayList<Etiqueta> getListaEtiquetas() {
		return listaEtiquetas;
	}

	public void setListaEtiquetas(ArrayList<Etiqueta> listaEtiquetas) throws ExceptionBaseDatosArchivo {
		if (listaEtiquetas.size() > 0) {
			this.listaEtiquetas = listaEtiquetas;
		} else {
			throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_ETIQUETAS_INCOMPLETA);
		}
	}

	@Override
	public String toString() {
		return nombreArchivo;
	}

}
