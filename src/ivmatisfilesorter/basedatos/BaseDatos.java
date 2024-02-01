package ivmatisfilesorter.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import ivmatisfilesorter.dominio.Archivo;
import ivmatisfilesorter.exception.BaseDatosException;

public class BaseDatos {
	private Connection conexion;
	private String controlador = "org.sqlite.JDBC";
	private String url = "jdbc:sqlite:";

	public BaseDatos(String archivo) {
		this.url = url + archivo;
	}

	protected boolean realizarConexion() throws BaseDatosException {
		return false;
		
	}

	protected void cerrarConexion() throws BaseDatosException{
		
	}
		

	protected ResultSet realizarConsulta(String consulta) throws BaseDatosException {
		return null;
		
	}

	protected int realizarAccion(String accion) throws BaseDatosException {
		return 0;
		
	}

	protected Vector<String> consultarTablas() throws BaseDatosException {
		return null;
		
	}

}
