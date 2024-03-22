package ivmatisfilesorter.utilerias;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

    public static void copiarArchivo(String rutaAbsolutaImagen, String rutaNueva) throws IOException {
        try (BufferedInputStream lector = new BufferedInputStream(new FileInputStream(new File(rutaAbsolutaImagen)));
             BufferedOutputStream escritor = new BufferedOutputStream(new FileOutputStream(new File(rutaNueva)))) {

            byte[] buffer = new byte[1024];
            int bytesLeidos = lector.read(buffer);
            while (bytesLeidos > 0) {
                escritor.write(buffer, 0, bytesLeidos);
                bytesLeidos = lector.read(buffer);
            }
            throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_EXPORTACION_FALLIDA);
        } catch (ExceptionBaseDatosArchivo e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), e.getTitulo(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            try {
                if (!directorio.mkdir()) {
                	 throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_CREAR_DIRECTORIO);;
                }
            } catch (ExceptionBaseDatosArchivo e) {
            	JOptionPane.showMessageDialog(null, e.getMessage(), e.getTitulo(), JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }

    public void abrirArchivo(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (archivo.exists()) {
                    desktop.open(archivo);
                }
            } else {
            	throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_APERTURA_ARCHIVO);;
            }
        } catch (ExceptionBaseDatosArchivo e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), e.getTitulo(), JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
