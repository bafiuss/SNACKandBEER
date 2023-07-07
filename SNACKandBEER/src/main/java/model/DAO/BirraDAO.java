package model.DAO;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;


import model.bean.*;


public class BirraDAO{

	private static final String TABLE_NAME = "Birra";
	private DataSource ds = null;
	private static Logger logger = Logger.getAnonymousLogger();

	public BirraDAO(DataSource ds) {
		this.ds = ds;
	}

	
	public synchronized void doSave(BirraBean ub) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		String query = "INSERT INTO " + BirraDAO.TABLE_NAME + " (ID_Prodotto,volume,gradAlcolica,colore,nazione) VALUES (?,?,?,?,?)";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setInt(1, ub.getID_Prodotto());
			p.setDouble(2, ub.getVolume());
			p.setDouble(3, ub.getGradAlcolica());
			p.setString(4, ub.getColore());
			p.setString(5, ub.getNazione());
			
			p.executeUpdate();
		} finally {
			try {
				if (p != null)
					p.close();
			} finally {
				if (c != null)
					c.close();
			}
		}
	}
	
	public synchronized BirraBean doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		BirraBean bean = new BirraBean();

		String selectSQL = "SELECT * FROM " + BirraDAO.TABLE_NAME + " WHERE ID_Prodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID_Prodotto(rs.getInt("ID_Prodotto"));
				bean.setVolume(rs.getDouble("volume"));
				bean.setGradAlcolica(rs.getDouble("gradAlcolica"));
				bean.setColore(rs.getString("colore"));
				bean.setNazione(rs.getString("nazione"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}

}