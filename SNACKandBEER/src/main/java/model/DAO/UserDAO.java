package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
	
    public ArrayList<UserBean> doRetrieveAll() throws SQLException{
    	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<UserBean> utenteList = new ArrayList<>();


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
	
/*
	@Override
	public synchronized UserBean doRetrieveByEmailAndPass(String email, String password) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		UserBean bean = null;

		String query = "SELECT * FROM " + UserDao.TABLE_NAME + " WHERE email = ? AND password = ?";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setString(1, email);
			p.setString(2, toHash(password));

			ResultSet rs = p.executeQuery();

			if (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				// bean.setPassword(rs.getString("password"));
			}
		} finally {
			try {
				if (p != null)
					p.close();
			} finally {
				if (c != null)
					c.close();
			}
		}

		return bean;
	}*/

	
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
	
	public UserBean doRetrieveByEmail(String code) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		UserBean bean = new UserBean();
		String query;	
		
		if(code == null)
			query = "select * FROM " + UserDAO.TABLE_NAME ; 
		else
			query = "select * FROM " + UserDAO.TABLE_NAME + " WHERE email = ? ; "; 
		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setString(1, code);
			ResultSet rs = p.executeQuery();	
			while (rs.next()) {
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setAdmin(rs.getBoolean("isAdmin"));
			}
		} finally {
			try {
				if (p != null)
					p.close();
			} finally {
				if (c != null)
					c.close();
			}
		}
		return bean;
	}
/*
	public static String toHash(String password) {
		StringBuilder sb = new StringBuilder();
        try {
            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toHexString( 
                                  (hash[i] & 0xFF) | 0x100 
                              ).toLowerCase().substring(1,3));
            }
        } catch (java.security.NoSuchAlgorithmException e) {
        	logger.log(Level.WARNING, "Problema hash pswd!");
        }
        return sb.toString();
    }*/
	
	public boolean isRegistrato(String s) throws SQLException{
		Connection c = null;
		PreparedStatement p = null;

		UserBean user;
		String query;

		if(s == null)
			query = "select count(*) as numUtenti FROM" + UserDAO.TABLE_NAME;
		else
			query = "select count(*) as numUtenti FROM " + UserDAO.TABLE_NAME + " WHERE email = ? ; "; 
		
		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setString(1, s);
			ResultSet rs = p.executeQuery();
			rs.next();
			if(rs.getInt("numUtenti") > 0) {
				return true;
			}
			return false;
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
/*
	@Override
	public synchronized boolean checkUserIsAdmin(int id) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		boolean isAdmin = false;

		String query = "SELECT * FROM ADMIN WHERE id = ?";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setInt(1, id);

			ResultSet rs = p.executeQuery();

			if (rs.next())
				isAdmin = true;

		} finally {
			try {
				if (p != null)
					p.close();
			} finally {
				if (c != null)
					c.close();
			}
		}
		return isAdmin;
	}*/

}