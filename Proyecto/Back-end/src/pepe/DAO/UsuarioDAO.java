package pepe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pepe.connection.DatabaseConnectionFactory;
import pepe.model.Estado;
import pepe.model.Rol;
import pepe.model.Usuario;

public class UsuarioDAO {
	
	public List<Usuario> getUsers() throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		List<Usuario> users = new ArrayList<Usuario>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			// create SQL statement using left outer join
			StringBuilder sb = new StringBuilder("select usuario.id as userId, usuario.nombre as userName, ")
					.append("usuario.apellidos as userApellidos, usuario.contraseña as userContraseña, ")
					.append("usuario.email as userEmail, usuario.avatar as userAvatar, ")
					.append("usuario.rol as userRol, usuario.mensajebaneo as userMensajeBaneo, ")
					.append("usuario.estado as userEstado from Usuario order by usuario.id");

			// execute the query
			rs = stmt.executeQuery(sb.toString());

			// iterate over result set and create user objects
			// add them to user list
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("userId"));
				user.setNombre(rs.getString("userName"));
				user.setApellidos(rs.getString("userApellidos"));
				user.setContraseña(rs.getString("userContraseña"));
				user.setEmail(rs.getString("userEmail"));
				user.setAvatar(rs.getString("userAvatar"));
				user.setRol(Rol.valueOf(rs.getString("userRol")));
				user.setMensajeBaneo((rs.getString("userMensajeBaneo")));
				user.setEstado(Estado.valueOf(rs.getString("userEstado")));
				users.add(user);
			}

			return users;
			
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

	public Usuario getUser(int id) throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			// create SQL statement using left outer join
			StringBuilder sb = new StringBuilder("select * from Usuario where id=" + id);

			// execute the query
			rs = stmt.executeQuery(sb.toString());
			Usuario user = new Usuario();
			if (rs.next()) {
				user.setId(id);
				user.setNombre(rs.getString(1));
				user.setApellidos(rs.getString(2));
				user.setContraseña(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAvatar(rs.getString(5));
				user.setRol(Rol.valueOf(rs.getString(6)));
				user.setMensajeBaneo((rs.getString(7)));
				user.setEstado(Estado.valueOf(rs.getString(8)));

				// check whether teacher id was null in the table
			}

			return user;
			
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void addUser(Usuario user) throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			if (user.getId() == 0) {
				final String sql = "insert into Usuario (nombre, apellidos, contraseña, "
						+ "email, avatar, rol, mensajebaneo, estado) values (?,?,?,?,?,?,?,?)";
				// create the prepared statement with an option to get auto-generated keys
				PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// set parameters
				stmt.setString(1, user.getNombre());
				stmt.setString(2, user.getApellidos());
				stmt.setString(3, user.getContraseña());
				stmt.setString(4, user.getEmail());
				stmt.setString(5, user.getAvatar());
				stmt.setString(6, user.getRol().toString());
				stmt.setString(7, user.getMensajeBaneo());
				stmt.setString(8, user.getEstado().toString());

				stmt.execute();

				// Get auto-generated keys
				ResultSet rs = stmt.getGeneratedKeys();

				if (rs.next()) 
					user.setId(rs.getInt(1));
				

				rs.close();
				stmt.close();
			} else {
				final String sql = "update Usuario set nombre='" + user.getNombre() +
						"', apellidos='" + user.getApellidos() + 
						"', contraseña='" + user.getContraseña() +
						"', email='" + user.getEmail() +
						"', avatar='" + user.getAvatar() +
						"', rol='" + user.getRol() +
						"', mensajebaneo='" + user.getMensajeBaneo() +
						"', estado='" + user.getEstado() + 
						"' where id = " + user.getId();
				// create the prepared statement with an option to get auto-generated keys
				PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// set parameters
				stmt.execute();
				stmt.close();
			}
		} finally {
			con.close();
		}
	}

	public static void removeCourse(Usuario user) throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "DELETE FROM Usuario WHERE id = ?";
			// create the prepared statement with an option to get auto-generated keys
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// set parameters
			stmt.setString(1, new Integer(user.getId()).toString());
			stmt.execute();
			stmt.close();
		} finally {
			con.close();
		}
	}

}
