package ivmatisfilesorter.basedatos;

import java.util.ArrayList;

import ivmatisfilesorter.dominio.Etiqueta;
import ivmatisfilesorter.exception.ExceptionBaseDatos;
import ivmatisfilesorter.exception.ExceptionBaseDatosEtiqueta;
import ivmatisfilesorter.exception.ExceptionBaseDatosProyecto;

public class BaseDatosEtiqueta {

	public BaseDatosEtiqueta(String etiqueta) {

	}

	protected void crearBaseDatosEtiqueta() throws ExceptionBaseDatosEtiqueta {
		throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_CREAR_ETIQUETA);
	}

	// Se debe de crear la excepcion
	protected boolean insertarBaseDatosEtiqueta(Etiqueta etiqueta) throws ExceptionBaseDatos {
		throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_ERROR_EN_CONSULTA);
	}

	protected ArrayList<Etiqueta> consultarBaseDatosEtiqueta(Etiqueta etiqueta) throws ExceptionBaseDatosEtiqueta {
		ArrayList<Etiqueta> etiquetas = new ArrayList<>();
		throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_CONSULTAR_ETIQUETA);
	}

	protected boolean modificarBaseDatosEtiqueta(String nuevaEtiqueta) throws ExceptionBaseDatosEtiqueta {
		throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_MODIFICAR_ETIQUETA);
	}

	protected boolean eliminarBaseDatosEtiqueta(Etiqueta etiqueta) throws ExceptionBaseDatosEtiqueta {
		throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_ELIMINAR_ETIQUETA);
	}

	protected boolean buscarBaseDatosEtiqueta(Etiqueta etiqueta) throws ExceptionBaseDatosEtiqueta {
		throw new ExceptionBaseDatosEtiqueta(ExceptionBaseDatosEtiqueta.IVMATIS_EXCEPTION_ETIQUETA_REPETIDA);
	}

}
