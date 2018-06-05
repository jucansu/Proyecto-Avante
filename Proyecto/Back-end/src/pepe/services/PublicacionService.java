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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pepe.DAO.PublicacionDAO;
import pepe.DAO.UsuarioDAO;
import pepe.model.Publicacion;
import pepe.model.Usuario;

@Path("/publicacion")
public class PublicacionService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
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

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("post/")
	public List<Publicacion> create(Publicacion p) {
		List<Publicacion> res = new ArrayList<Publicacion>();
		try {
			res = new PublicacionDAO().getPublicaciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PublicacionDAO.createPublicacion(p);
			res = new PublicacionDAO().getPublicaciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{publicacionId}")
	public List<Publicacion> delete(@PathParam("publicacionId") int publicacionId) {
		List<Publicacion> res = new ArrayList<Publicacion>();
		try {
			res = new PublicacionDAO().getPublicaciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res != null && !res.isEmpty()) {
			for (Publicacion pub : res) {
				if (publicacionId == pub.getId()) {
					try {
						PublicacionDAO.removePublicacion(pub.getId());
						res = new PublicacionDAO().getPublicaciones();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return res;
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
