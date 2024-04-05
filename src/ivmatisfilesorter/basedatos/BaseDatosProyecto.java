package ivmatisfilesorter.basedatos;

import java.util.Vector;

import ivmatisfilesorter.dominio.Proyecto;
import ivmatisfilesorter.exception.ExceptionBaseDatos;
import ivmatisfilesorter.exception.ExceptionBaseDatosArchivo;
import ivmatisfilesorter.exception.ExceptionBaseDatosProyecto;

public class BaseDatosProyecto {

	public BaseDatosProyecto(String proyecto) {

	}

	protected void crearBaseDatosProyecto() throws ExceptionBaseDatosProyecto {
		throw new ExceptionBaseDatosProyecto(ExceptionBaseDatosProyecto.IVMATIS_EXCEPTION_CREAR_PROYECTO);
	}

	protected boolean insertarBaseDatosProyecto(Proyecto proyecto) throws ExceptionBaseDatos{
		throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_ERROR_EN_CONSULTA);
	}

	protected boolean modificarBaseDatosProyecto(Proyecto proyecto) throws ExceptionBaseDatosProyecto {
		throw new ExceptionBaseDatosProyecto(ExceptionBaseDatosProyecto.IVMATIS_EXCEPTION_MODIFICAR_PROYECTO);
	}
}
