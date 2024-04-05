package ivmatisfilesorter.basedatos;

import java.util.ArrayList;
import java.util.Vector;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.dominio.Etiqueta;
import ivmatisfilesorter.exception.ExceptionBaseDatos;
import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;
import ivmatisfilesorter.exception.ExceptionBaseDatosEtiqueta;

public class BaseDatosArchivo {

	public BaseDatosArchivo(String archivo) {

	}

	protected boolean insertarBaseDatosArchivo(Archivo archivo) throws ExceptionBaseDatosArchivo {

		throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_VALIDACION_ARCHIVO);
	}

	protected boolean eliminarBaseDatosArchivo(Archivo archivo) throws ExceptionBaseDatosArchivo {

		throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_ELIMINAR_ARCHIVO);
	}

	protected boolean modificarBaseDatosArchivo(Archivo archivo) throws ExceptionBaseDatosArchivo {
		throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_MODIFICAR_ARCHIVO);
	}

	protected ArrayList<Etiqueta> consultarBaseDatosArchivoEtiqueta(Archivo archivo) throws ExceptionBaseDatosEtiqueta {
		ArrayList<Etiqueta> etiquetas = new ArrayList<>();
		throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_CONSULTAR_ETIQUETA);

	}

	protected ArrayList<Archivo> consultarBaseDatosArchivo(Archivo archivo) throws ExceptionBaseDatosArchivo {
		ArrayList<Archivo> archivos = new ArrayList<>();
		throw new ExceptionBaseDatosArchivo(ExceptionBaseDatosArchivo.IVMATIS_EXCEPTION_CONSULTA_ARCHIVO);
	}

}
