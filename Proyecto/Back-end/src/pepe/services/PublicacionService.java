package pepe.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
	public List<Publicacion> delete(@Context HttpServletRequest request,
			@Context HttpServletResponse response,  @PathParam("publicacionId") int publicacionId) {
		//Inicialización de variables
		List<Publicacion> res = new ArrayList<Publicacion>();
		Publicacion publicacion = new Publicacion();
		
		try {
			publicacion = new PublicacionDAO().getPublicacion(publicacionId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			res = new PublicacionDAO().getPublicaciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Se intenta pillar el token de la cabecera HTTP
		String token = request.getHeader("Authorization");
		token = token == null || token.isEmpty()? "" : token.substring(36, token.length()-36);
		
		//Si no se ha podido, se devuelve error y se sale del método
		if(token == "") {
			try {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return res;
		}
		
		//Se intenta convertir el token en id (id del usuario logueado)
		int id = 0;
		try {
			id = Integer.parseInt(token);
			Boolean isValid = publicacion.getId_usuario() == id;
			
			//Si no coincide el id del usuario logueado con el creador del post, se devuelve error
			if(!isValid) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				return res;
			}
		//Si hay error de parseo, se devuelve error
		} catch (Exception err) {
			try {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return res;
		}
		
		//Si todo está correcto hasta aquí, se elimina el post
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
