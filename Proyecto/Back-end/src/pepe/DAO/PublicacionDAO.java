package pepe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pepe.connection.DatabaseConnectionFactory;
import pepe.model.Publicacion;

public class PublicacionDAO {

	public static void createPublicacion(Publicacion publicacion) throws SQLException {
		// get connection from connection pool
		Connection con = DatabaseConnectionFactory.getConnectionFactory().getConnection();
		try {
			final String sql = "insert into Publicacion (titulo,descripcion,etiqueta,fecha) values (?,?,?,?)";
			// create the prepared statement with an option to get auto-generated keys
			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// set parameters
			stmt.setString(1, publicacion.getTitulo());
			stmt.setString(2, publicacion.getDescripcion());
			stmt.setString(3, publicacion.getEtiqueta());
			stmt.setDate(4, publicacion.getFecha());

			stmt.execute();

			// Get auto-generated keys
			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next())
				publicacion.setId(rs.getInt(1));

			rs.close();
			stmt.close();
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

}
