package model.bean;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PhotoControl {
	
	private PhotoControl() {
		
	}
	
	private static DataSource ds;
	private static Logger logger = Logger.getAnonymousLogger();

	
	static {
		
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/snackandbeer");

		} catch (NamingException e) {
			logger.log(Level.WARNING, "Problema accesso al DB");
		}
	}
	
	
	public static synchronized byte[] load(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		byte[] bt = null;
		
		try {
			connection = ds.getConnection();
			String sql = "SELECT photo FROM prodotto WHERE ID_Prodotto = ?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				bt = rs.getBytes("photo");
			}

		} catch (SQLException sqlException) {
			logger.log(Level.WARNING, "Problema accesso al DB");
		} 
			finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				logger.log(Level.WARNING, "Problema SQL");
			} finally {
				if (connection != null) 
					connection.close();
			}
		}
		return bt;
	}
	
	
	
	public static synchronized void updatePhoto(int idA, InputStream photo) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("UPDATE prodotto SET photo = ? WHERE ID_Prodotto = ?");
			try {
				stmt.setBinaryStream(1, photo, photo.available());
				stmt.setInt(2, idA);	
				stmt.executeUpdate();
			} catch (IOException e) {
				logger.log(Level.WARNING, "Problema IO!");
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				logger.log(Level.WARNING, "Problema SQL");
			} finally {
				if (con != null)
					con.close();
			}
		}
	}

}