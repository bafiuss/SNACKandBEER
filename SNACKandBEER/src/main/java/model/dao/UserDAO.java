package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;


import model.bean.*;


public class UserDAO{

	static final String TABLE_NAME = "utente";
	private DataSource ds = null;
	private static Logger logger = Logger.getAnonymousLogger();

	public UserDAO(DataSource ds) {
		this.ds = ds;
	}

	
	public synchronized void doSave(UserBean ub) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		String query = "INSERT INTO " + UserDAO.TABLE_NAME + " (email,pswd,nome,cognome,data_nascita,indirizzo,indirizzo_spedizione,isAdmin) VALUES (?,?,?,?,?,?,?,?)";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setString(1, ub.getEmail());
			p.setString(2, ub.getPassword());
			p.setString(3, ub.getNome());
			p.setString(4, ub.getCognome());
			p.setString(5, ub.getNascita());
			p.setString(6, ub.getIndirizzo());
			p.setString(7, ub.getIndirizzoSped());
			p.setBoolean(8, ub.isAdmin());
			
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
	
	public synchronized boolean doUpdateInfo(String email, String indirizzo, String indirizzoSped) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		String updateSQL = "UPDATE " + UserDAO.TABLE_NAME + " SET indirizzo= ? , indirizzo_spedizione = ? WHERE email = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, indirizzo);
			preparedStatement.setString(2, indirizzoSped);
			preparedStatement.setString(3, email);
			
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
	
	public synchronized boolean doUpdatePsw(String email, String nuovaPsw) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		String updateSQL = "UPDATE " + UserDAO.TABLE_NAME + " SET pswd= ? WHERE email = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, nuovaPsw);
			preparedStatement.setString(2, email);
			
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
	
	public synchronized UserBean doRetrieveByKey(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UserBean bean = new UserBean();

		String selectSQL = "SELECT * FROM " + UserDAO.TABLE_NAME + " WHERE EMAIL = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("pswd"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNascita(rs.getString("data_nascita"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setIndirizzoSped(rs.getString("indirizzo_spedizione"));
				bean.setAdmin(rs.getBoolean("isAdmin"));
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
	
    public List<UserBean> doRetrieveAll() throws SQLException{
    	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<UserBean> utenteList = new ArrayList<>();


		String selectSQL = "SELECT * FROM " + UserDAO.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String email = rs.getString(1);
                String password = rs.getString(2);
                String nome = rs.getString(3);
                String cognome = rs.getString(4);
                String nascita = rs.getString(5);
                String indirizzo = rs.getString(6);
                String indirizzoSped = rs.getString(7);
                boolean isAdmin = rs.getBoolean(8);
                utenteList.add(new UserBean(email, password, nome, cognome, nascita, indirizzo, indirizzoSped, isAdmin));
            }
        }finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}

        return utenteList;
    }

	public synchronized boolean doDelete(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + UserDAO.TABLE_NAME + " WHERE email = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, email);

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

	
	public synchronized boolean checkUserEmailExistance(String email) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		boolean exists = false;

		String query = "SELECT * FROM " + UserDAO.TABLE_NAME + " WHERE email = ?";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setString(1, email);

			ResultSet rs = p.executeQuery();

			if (rs.next())
				exists = true;

		} finally {
			try {
				if (p != null)
					p.close();
			} finally {
				if (c != null)
					c.close();
			}
		}

		return exists;
	}
}