package ivmatisfilesorter.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.exception.ExceptionBaseDatos;

public class BaseDatos {
	private Connection conexion;
	private String controlador = "org.sqlite.JDBC";
	private String url = "jdbc:sqlite:";

	public BaseDatos(String archivo) {
		this.url = url + archivo;
	}

	protected boolean realizarConexion() throws ExceptionBaseDatos {
		return false;

	}

	protected void cerrarConexion() throws ExceptionBaseDatos {

	}

	protected ResultSet realizarConsulta(String consulta) throws ExceptionBaseDatos {
		return null;

	}

	protected int realizarAccion(String accion) throws ExceptionBaseDatos {
		return 0;

	}

	protected Vector<String> consultarTablas() throws ExceptionBaseDatos {
		return null;

	}

}
