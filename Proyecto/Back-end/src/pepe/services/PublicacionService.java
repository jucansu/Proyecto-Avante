package pepe.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pepe.DAO.PublicacionDAO;
import pepe.model.Publicacion;

@Path("/publicacion")
public class PublicacionService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get/{publicacionId}")
	public Publicacion getPublicacion(@PathParam("publicacionId") int id) {
		Publicacion res = new Publicacion();
		
		try {
			res = new PublicacionDAO().getPublicacion(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("post/")
	public Publicacion create(Publicacion p) {
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		Publicacion res = new Publicacion();
		try {
			PublicacionDAO.createPublicacion(p);
			publicaciones = new PublicacionDAO().getPublicaciones();
			for(Publicacion pub : publicaciones)
			if(pub.getId() == p.getId()) {
				res = pub;
			}
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
