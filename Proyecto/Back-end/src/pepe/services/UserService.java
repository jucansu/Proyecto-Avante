package pepe.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pepe.DAO.UsuarioDAO;
import pepe.model.Usuario;

@Path("/user")
public class UserService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public JsonObject login(Usuario user) {

		String token = "";
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
				token = generateToken(user.getId());
				break;
			}
		}

		return Json.createObjectBuilder().add("token", token).build();
	}
	
	private String generateToken(int id) {
		return UUID.randomUUID().toString() + id + UUID.randomUUID().toString();
	}
}
