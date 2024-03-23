package ivmatisfilesorter.utilerias;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;

/**
 * Sirve para representar los diferentes métodos de la interacción entre los
 * diferentes métodos que se utilicen con archivos.
 * <p>
 * Las características de la clase <code>Etiqueta</code> son:
 * <ul>
 * <li><code>etiqueta</code> para el nombre de la etiqueta.</li>
 * <li><code>listaArchivosArchivo</code> para la lista de etiquetas.</li>
 * </ul>
 *
 * @version 21/03/2024
 * 
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 * 
 * 
 *         /** Clase que proporciona métodos de utilidad para el manejo de
 *         archivos. Permite copiar archivos, crear directorios y abrir archivos
 *         en el sistema.
 * 
 * @version 21/03/2024
 * @author Isaac Cortez Escamilla
 * @author Luis Fernando Matias Acevedo
 * @author Ivonne Estefanía Hernández Pérez
 */

public class UtileriasManejoArchivos {

	public static void copiarArchivo(String rutaAbsolutaImagen, String rutaNueva) throws ExceptionBaseDatosArchivo {
		try (BufferedInputStream lector = new BufferedInputStream(new FileInputStream(new File(rutaAbsolutaImagen)));
				BufferedOutputStream escritor = new BufferedOutputStream(new FileOutputStream(new File(rutaNueva)))) {

			byte[] buffer = new byte[1024];
			int bytesLeidos = lector.read(buffer);
			while (bytesLeidos > 0) {
				escritor.write(buffer, 0, bytesLeidos);
				bytesLeidos = lector.read(buffer);
			}
		} catch (IOException e) {
			throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_APERTURA_ARCHIVO);
		
		}
	}

	public static void crearDirectorio(String ruta) throws ExceptionBaseDatosArchivo {
		File directorio = new File(ruta);
		if (!directorio.exists()) {

			if (!directorio.mkdir()) {
				throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_CREACION_DIRECTORIO);
			}

		}
	}

	public void abrirArchivo(String nombreArchivo) throws ExceptionBaseDatosArchivo, IOException {
		File archivo = new File(nombreArchivo);

		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if (archivo.exists()) {
				desktop.open(archivo);
			}
		} else {
			throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_APERTURA_ARCHIVO);
		}

	}
}
