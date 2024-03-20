package ivmatisfilesorter.dominio;

import java.util.Date;

import javax.swing.JOptionPane;

import ivmatisfilesorter.exception.ExceptionBaseDatosProyecto;

public class Proyecto extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombreProyecto;
	private String nombrePropietario;
	private String descripcion;
	private Date fechaCreacion;
	private Archivo listaArchivosArchivo;
	private Etiqueta listaEtiquetasEtiqueta;

	public Proyecto() {

	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void consultarProyecto() {

	}

	public void crearProyecto() {

	}

	public void modificarProyecto() {

	}

	public Archivo getListaArchivos() {
		return listaArchivosArchivo;
	}

	public void setListaArchivos(Archivo listaArchivos) {
		this.listaArchivosArchivo = listaArchivos;
	}

	public Etiqueta getListaEtiquetas() {
		return listaEtiquetasEtiqueta;
	}

	public void setListaEtiquetas(Etiqueta listaEtiquetas) {
		this.listaEtiquetasEtiqueta = listaEtiquetas;
	}

}
