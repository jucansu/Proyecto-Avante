package pepe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pepe.connection.DatabaseConnectionFactory;
import pepe.model.Publicacion;

public class PublicacionDAO {

	public static void createPublicacion(Publicacion publicacion) throws SQLException {
		// get connection from connection pool

		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			if (publicacion.getId() == 0) {
				final String sql = "insert into Publicacion (titulo,descripcion,etiqueta,fecha,valoracion,id_usuario) values (?,?,?,?,?,?)";
				// create the prepared statement with an option to get auto-generated keys
				PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// set parameters
				stmt.setString(1, publicacion.getTitulo());
				stmt.setString(2, publicacion.getDescripcion());
				stmt.setString(3, publicacion.getEtiqueta());
				stmt.setDate(4, publicacion.getFecha());
				stmt.setInt(5, publicacion.getValoracion());
				stmt.setInt(6, publicacion.getId_usuario());

				stmt.execute();

				// Get auto-generated keys
				ResultSet rs = stmt.getGeneratedKeys();

				if (rs.next())
					publicacion.setId(rs.getInt(1));

				rs.close();
				stmt.close();
			} else {
				final String sql = "update Publicacion set titulo='" + publicacion.getTitulo() +
						"', descripcion='" + publicacion.getDescripcion() + 
						"', etiqueta='" + publicacion.getEtiqueta() +
						"', fecha='" + publicacion.getFecha() +
						"', valoracion='" + publicacion.getValoracion() +
						"', id_usuario='" + publicacion.getId_usuario() +
						"' where id = " + publicacion.getId();
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

	public static void removePublicacion(int publicacionId) throws SQLException {
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "delete from Publicacion where Id= (?) ";

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, publicacionId);
			stmt.execute();

			stmt.close();
		} finally {
			con.close();
		}

	}

	public static void editPublicacion(Publicacion publicacion) throws SQLException {
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "edit from Publicacion where Id= (?) ";

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, publicacion.getId());
			stmt.setString(2, publicacion.getTitulo());
			stmt.setString(3, publicacion.getDescripcion());
			stmt.setString(4, publicacion.getEtiqueta());
			stmt.setDate(5, publicacion.getFecha());

			stmt.execute();

		} finally {
			con.close();
		}

	}

	public List<Publicacion> getPublicaciones() throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		List<Publicacion> publicacion = new ArrayList<Publicacion>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			// create SQL statement using left outer join
			StringBuilder sb = new StringBuilder("select Publicacion.id as id, Publicacion.titulo as titulo,").append(
					"Publicacion.descripcion as descripcion, Publicacion.etiqueta as etiqueta, Publicacion.fecha as fecha, Publicacion.valoracion as valoracion, Publicacion.id_usuario as id_usuario ")
					.append("from Publicacion order by Publicacion.fecha desc");

			// execute the query
			rs = stmt.executeQuery(sb.toString());

			// iterate over result set and create Course objects
			// add them to course list
			while (rs.next()) {
				Publicacion publi = new Publicacion();
				publi.setId(rs.getInt("id"));
				publi.setTitulo(rs.getString("titulo"));
				publi.setDescripcion(rs.getString("descripcion"));
				publi.setEtiqueta(rs.getString("etiqueta"));
				publi.setFecha(rs.getDate("fecha"));
				publi.setValoracion(rs.getInt("valoracion"));
				publi.setId_usuario(rs.getInt("id_usuario"));
				publicacion.add(publi);

			}

			return publicacion;
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
	
	public Publicacion getPublicacion(int id) throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();

			// create SQL statement using left outer join
			StringBuilder sb = new StringBuilder("select * from Publicacion where id=" + id);

			// execute the query
			rs = stmt.executeQuery(sb.toString());
			Publicacion post = new Publicacion();
			if (rs.next()) {
				post.setId(id);
				post.setTitulo(rs.getString(1));
				post.setDescripcion(rs.getString(2));
				post.setEtiqueta(rs.getString(3));
				post.setFecha(rs.getDate(4));
				post.setValoracion(rs.getInt(5));
				post.setId_usuario(rs.getInt(6));
			}

			return post;
			
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

}
