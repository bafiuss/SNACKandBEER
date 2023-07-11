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


public class SnackDAO{

	private static final String TABLE_NAME = "Snack";
	private DataSource ds = null;
	private static Logger logger = Logger.getAnonymousLogger();

	public SnackDAO(DataSource ds) {
		this.ds = ds;
	}

	
	public synchronized void doSave(SnackBean ub) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		String query = "INSERT INTO " + SnackDAO.TABLE_NAME + " (ID_Prodotto,quantita) VALUES (?,?)";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setInt(1, ub.getID_Prodotto());
			p.setInt(2, ub.getQuantita());
			
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
	
	public synchronized SnackBean doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		SnackBean bean = new SnackBean();

		String selectSQL = "SELECT * FROM " + SnackDAO.TABLE_NAME + " WHERE ID_Prodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID_Prodotto(rs.getInt("ID_Prodotto"));
				bean.setQuantita(rs.getInt("quantita"));
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
	
	public synchronized boolean doUpdate(int id, int quant) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String updateSQL = "UPDATE " + SnackDAO.TABLE_NAME + " SET quantita = ? WHERE ID_Prodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, quant);
			preparedStatement.setInt(2, id);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

}