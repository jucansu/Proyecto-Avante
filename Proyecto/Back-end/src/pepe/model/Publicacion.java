package pepe.model;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import pepe.DAO.PublicacionDAO;

public class Publicacion {

	private String titulo;
	private String descripcion;
	private String etiqueta;
	private Date fecha;
	private Integer valoracion;
	private Integer id_usuario;
	private Integer id;

	private PublicacionDAO publicacionDAO = new PublicacionDAO();

	public void createPublicacion() throws SQLException {
		publicacionDAO.createPublicacion(this);
	}

	public void removePublicacion() throws SQLException {
		publicacionDAO.removePublicacion(this.id);
	}

	public void editPublicacion() throws SQLException {
		publicacionDAO.editPublicacion(this);
	}

	public List<Publicacion> getPublicaciones() throws SQLException {
		return publicacionDAO.getPublicaciones();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
