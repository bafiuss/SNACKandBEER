package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;


import model.bean.*;


public class ProdottoDAO{

	private static final String TABLE_NAME = "prodotto";
	private static final String SELECT = "SELECT * FROM ";
	private DataSource ds = null;
	
	
	public ProdottoDAO(DataSource ds) {
		this.ds = ds;
	}

	
	public synchronized void doSave(ProdottoBean ub) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		String query = "INSERT INTO " + ProdottoDAO.TABLE_NAME + " (ID_Prodotto,nome,produttore,descrizione,prezzo,quantita,categoria) VALUES (?,?,?,?,?,?,?)";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setInt(1, ub.getID_Prodotto());
			p.setString(2, ub.getNome());
			p.setString(3, ub.getProduttore());
			p.setString(4, ub.getDescrizione());
			p.setDouble(5, ub.getPrezzo());
			p.setInt(6, ub.getQuantita());
			p.setString(7, ub.getCategoria());
			
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
	
	public synchronized boolean doUpdate(int id, String nome, String produttore, String descrizione, double prezzo, int quantita) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String updateSQL = "UPDATE " + ProdottoDAO.TABLE_NAME + " SET nome = ? , produttore = ? , descrizione= ?, prezzo = ?, quantita = ? WHERE ID_Prodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, produttore);
			preparedStatement.setString(3, descrizione);
			preparedStatement.setDouble(4, prezzo);
			preparedStatement.setInt(5, quantita);
			preparedStatement.setInt(6, id);

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
	
	public synchronized boolean doUpdateQuantity(int id, int quantita) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String updateSQL = " UPDATE " + ProdottoDAO.TABLE_NAME + " SET quantita = quantita - ? " + "WHERE ID_Prodotto = ?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, quantita);
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
	
	public List<ProdottoBean> getAllProductsByCat(String cat)throws SQLException{
		List<ProdottoBean> prodotti = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = SELECT + ProdottoDAO.TABLE_NAME + " WHERE categoria = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, cat);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				ProdottoBean row = new ProdottoBean();
				
				row.setID_Prodotto(rs.getInt("ID_Prodotto"));
				row.setNome(rs.getString("nome"));
				row.setProduttore(rs.getString("produttore"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setPrezzo(rs.getDouble("prezzo"));
				row.setQuantita(rs.getInt("quantita"));
				row.setCategoria(rs.getString("categoria"));
				row.setPhoto(rs.getBytes("photo"));
				
				prodotti.add(row);
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
		
		return prodotti;
	}
	
	public List<ProdottoBean> doRetrieveAll() throws SQLException{
    	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		List<ProdottoBean> prodottiList = new ArrayList<>();


		String selectSQL = SELECT + ProdottoDAO.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String produttore = rs.getString(3);
                String descrizione = rs.getString(4);
                double prezzo = rs.getDouble(5);
                int quantita = rs.getInt(6);
                String categoria = rs.getString(7);
                prodottiList.add(new ProdottoBean(id,nome,produttore,descrizione,prezzo,quantita,categoria));
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

        return prodottiList;
    }
	
	public synchronized ProdottoBean doRetrieveByKey(int id) throws SQLException {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ProdottoBean bean = new ProdottoBean();
		
		String selectSQL = SELECT + ProdottoDAO.TABLE_NAME + " WHERE ID_Prodotto = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			

			ResultSet rs = preparedStatement.executeQuery();
			
			
			
			while (rs.next()) {
				bean.setID_Prodotto(rs.getInt("ID_Prodotto"));
				bean.setNome(rs.getString("nome"));
				bean.setProduttore(rs.getString("produttore"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setCategoria(rs.getString("categoria"));
				bean.setPhoto(rs.getBytes("photo"));
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

	
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProdottoDAO.TABLE_NAME + " WHERE ID_Prodotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

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