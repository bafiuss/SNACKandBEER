package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.bean.OrdineBean;

public class OrdineDAO {
	
	
	private static final String TABLE_NAME = "Ordine";
	private DataSource ds = null;
	private static Logger logger = Logger.getAnonymousLogger();
	
	
	public OrdineDAO(DataSource ds) {
		this.ds = ds;
	}
	
	
	
	public synchronized void doSave(OrdineBean ordine) throws SQLException { 

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		

		String insertSQL = "INSERT INTO " + OrdineDAO.TABLE_NAME + " (numero_ordine,email,data_ordine,quantita,prezzo_totale) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, ordine.getNumero_ordine());
			preparedStatement.setString(2, ordine.getEmail());
			preparedStatement.setDate(3, new java.sql.Date(ordine.getData_ordine().getTime()));
			preparedStatement.setInt(4, ordine.getQuantita());
			preparedStatement.setDouble(5, ordine.getPrezzo_totale());
			
			
			preparedStatement.executeUpdate();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}

	
	public synchronized boolean doDelete(OrdineBean ordine) throws SQLException { //cancella un ordine
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + OrdineDAO.TABLE_NAME + " WHERE numero_ordine = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, ordine.getNumero_ordine());

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

	
	public synchronized OrdineBean doRetrieveByKey(int numero_ordine) throws SQLException{ //trova un ordine
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrdineBean bean = new OrdineBean();
		String selectSQL = "SELECT * FROM " + OrdineDAO.TABLE_NAME + " WHERE numero_ordine = ?";
		try {
			connection = ds.getConnection();	
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, numero_ordine);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				bean.setNumero_ordine(rs.getInt("numero_ordine"));
				bean.setEmail(rs.getString("email"));
				bean.setData_ordine(rs.getDate("data_ordine"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzo_totale(rs.getDouble("prezzo_totale"));
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

	
	public synchronized Collection<OrdineBean> doRetrieveAll(String order) throws SQLException { //trova tutti gli ordini
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = "SELECT * FROM" + OrdineDAO.TABLE_NAME + " ORDER BY ?";

		

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			if (order != null && !order.equals("")) {
				preparedStatement.setString(1, order);
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setNumero_ordine(rs.getInt("numero_ordine"));
				bean.setEmail(rs.getString("email"));
				bean.setData_ordine(rs.getDate("data_ordine"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzo_totale(rs.getDouble("prezzo_totale"));
				
				
				ordini.add(bean);
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
		return ordini;
	}
	
	
	public synchronized Collection<OrdineBean> doRetrieveByEmail(String email, String order) throws SQLException { //trova tutti gli ordini di un determinato cliente
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = "SELECT * FROM  " + OrdineDAO.TABLE_NAME + " WHERE email = ? ORDER BY ?";

		

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			if (order != null && !order.equals("")) {
				preparedStatement.setString(2, order);
			}
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setNumero_ordine(rs.getInt("numero_ordine"));
				bean.setEmail(rs.getString("email"));
				bean.setData_ordine(rs.getDate("data_ordine"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzo_totale(rs.getDouble("prezzo_totale"));
				
				ordini.add(bean);
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
		return ordini;
	}
	
	
	public synchronized int doRetrieveMaxNumOrdine() throws SQLException{ //trova il numero ordine da utulizzare
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT MAX(numero_ordine) AS MAX FROM " + OrdineDAO.TABLE_NAME;
		
		int max = 0 ;
		
		try {
			connection = ds.getConnection();	
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				max = rs.getInt("MAX");
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
		return max;
	}
	
	public synchronized Collection<OrdineBean> doRetrieveByUserData(String email, Date startDate, Date endDate) throws SQLException { //trova tutti gli ordini di un determinato cliente
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = "SELECT * FROM  " + OrdineDAO.TABLE_NAME + " WHERE email = ? " + " AND data_ordine BETWEEN ? AND ?";

		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setDate(2, startDate);
			preparedStatement.setDate(3, endDate);

			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setNumero_ordine(rs.getInt("numero_ordine"));
				bean.setEmail(rs.getString("email"));
				bean.setData_ordine(rs.getDate("data_ordine"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzo_totale(rs.getDouble("prezzo_totale"));
				
				ordini.add(bean);
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
		return ordini;
	}
	
	public synchronized Collection<OrdineBean> doRetrieveByData(Date startDate, Date endDate) throws SQLException { //trova tutti gli ordini di un determinato cliente
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> ordini = new LinkedList<>();

		String selectSQL = "SELECT * FROM" + OrdineDAO.TABLE_NAME + " WHERE " + "data_ordine BETWEEN ? AND ?";

		
		try {
			connection = ds.getConnection();
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setDate(1, startDate);
			preparedStatement.setDate(2, endDate);

			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setNumero_ordine(rs.getInt("numero_ordine"));
				bean.setEmail(rs.getString("email"));
				bean.setData_ordine(rs.getDate("data_ordine"));
				
				ordini.add(bean);
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
		return ordini;
	}
	
	
	

}