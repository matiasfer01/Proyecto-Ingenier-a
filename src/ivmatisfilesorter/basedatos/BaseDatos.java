package ivmatisfilesorter.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ivmatisfilesorter.exception.ExceptionBaseDatos;

public class BaseDatos {

	protected Connection conexion;
	private String controlador = "org.sqlite.JDBC";
	private String url = "jdbc:sqlite:";

	public BaseDatos(String archivo) {
		this.url = url + archivo;

	}

	protected boolean realizarConexion() throws ExceptionBaseDatos{
		try {
			Class.forName(controlador);
			conexion = DriverManager.getConnection(url);
			return true;
		} catch (ClassNotFoundException e) {
			throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_NO_SE_ENCONTRO_DRIVER);
		} catch (SQLException e) {
			throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_BD_NO_ENCONTRADA);
		}
	}

	protected void cerrarConexion() throws ExceptionBaseDatos{
		try {
			conexion.close();
		} catch (SQLException e) {
			throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_DESCONEXION);
		}
	}

	protected ResultSet realizarConsulta(String consulta) throws ExceptionBaseDatos{
		try {
			Statement instruccion;
			instruccion = conexion.createStatement();
			return instruccion.executeQuery(consulta);
		} catch (SQLException e) {
			throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_ERROR_EN_CONSULTA);
		}
	}

	protected int realizarAccion(String accion) throws ExceptionBaseDatos {
		try {
			Statement instruccion;
			instruccion = conexion.createStatement();
			return instruccion.executeUpdate(accion);
		} catch (SQLException e) {
			throw new ExceptionBaseDatos(ExceptionBaseDatos.IVMATIS_EXCEPTION_BD_EN_ACCION);
		}
	}


	public String getControlador() {
		return controlador;
	}

	public String getUrl() {
		return url;
	}

}
