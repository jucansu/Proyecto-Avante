package pepe.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pepe.DAO.PublicacionDAO;
import pepe.model.Publicacion;

@Path("/publicacion")
public class PublicacionService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("get")
	public List<Publicacion> listaComentarios() {
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		PublicacionDAO dao = new PublicacionDAO();
		try {
			publicaciones = dao.getPublicaciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publicaciones;

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("create")
	public void create(Publicacion p) {
		try {
			PublicacionDAO.createPublicacion(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("delete")
	public void delete(int publicacionId) {
		try {
			PublicacionDAO.removePublicacion(publicacionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("edit")
	public void edit(Publicacion p) {
		try {
			PublicacionDAO.editPublicacion(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
