package pepe.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pepe.DAO.UsuarioDAO;
import pepe.model.Usuario;

@Path("/user")
public class UserService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("get/{userId}")
	public Usuario getUser(@PathParam("userId") int id) {
		Usuario res = new Usuario();
		
		try {
			res = new UsuarioDAO().getUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public List<Usuario> getUsers() {
		List<Usuario> res = new ArrayList<Usuario>();
		
		try {
			res = new UsuarioDAO().getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("post/")
	public List<Usuario> postUser(Usuario user) {
		List<Usuario> res = new ArrayList<Usuario>();
		try {
			res = new UsuarioDAO().getUsers();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			UsuarioDAO.addUser(user);
			res = new UsuarioDAO().getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("delete/{userId}")
	public List<Usuario> deleteUser(@PathParam("userId") int id) {
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			list = new UsuarioDAO().getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(list != null && !list.isEmpty()) {
			for(Usuario user : list) {
				if(id == user.getId()) {
					try {
						UsuarioDAO.removeCourse(user);
						list = new UsuarioDAO().getUsers();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return list;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public Usuario login(Usuario user) {

		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> users = new ArrayList<Usuario>();
		try {
			users = dao.getUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for(Usuario us : users) {
			if(!users.isEmpty() && us.getEmail().equals(user.getEmail())
					&& us.getContraseña().equals(user.getContraseña())) {
				user = us;	
				user.setToken(generateToken(user.getId()));
				break;
			}
		}

		return user;
	}
	
	private String generateToken(int id) {
		return UUID.randomUUID().toString() + id + UUID.randomUUID().toString();
	}
}
