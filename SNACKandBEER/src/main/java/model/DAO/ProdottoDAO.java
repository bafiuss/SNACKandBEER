package model.DAO;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import javax.sql.DataSource;


import model.bean.*;


public class ProdottoDAO{

	private static final String TABLE_NAME = "prodotto";
	private DataSource ds = null;
	private static Logger logger = Logger.getAnonymousLogger();
	
	
	public ProdottoDAO(DataSource ds) {
		this.ds = ds;
	}

	
	public synchronized void doSave(ProdottoBean ub) throws SQLException {
		Connection c = null;
		PreparedStatement p = null;

		String query = "INSERT INTO " + ProdottoDAO.TABLE_NAME + " (ID_Prodotto,titolo,produttore,descrizione,prezzo,categoria,png) VALUES (?,?,?,?,?,?,?)";

		try {
			c = ds.getConnection();
			p = c.prepareStatement(query);
			p.setInt(1, ub.getID_Prodotto());
			p.setString(2, ub.getTitolo());
			p.setString(3, ub.getProduttore());
			p.setString(4, ub.getDescrizione());
			p.setDouble(5, ub.getPrezzo());
			p.setString(6, ub.getCategoria());
			p.setString(7, ub.getPng());
			
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
	
	public List<ProdottoBean> getAllProducts(String cat){
		List<ProdottoBean> prodotti = new ArrayList<ProdottoBean>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME + " WHERE categoria = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, cat);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				ProdottoBean row = new ProdottoBean();
				
				row.setID_Prodotto(rs.getInt("ID_Prodotto"));
				row.setTitolo(rs.getString("titolo"));
				row.setProduttore(rs.getString("produttore"));
				row.setDescrizione(rs.getString("descrizione"));
				row.setPrezzo(rs.getDouble("prezzo"));
				row.setCategoria(rs.getString("categoria"));
				row.setPng(rs.getString("png"));
				
				prodotti.add(row);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prodotti;
		
	}
	
	public synchronized ProdottoBean doRetrieveByKey(int id) throws SQLException {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ProdottoBean bean = new ProdottoBean();
		
		String selectSQL = "SELECT * FROM " + ProdottoDAO.TABLE_NAME + " WHERE ID_Prodotto = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			

			ResultSet rs = preparedStatement.executeQuery();
			
			
			
			while (rs.next()) {
				bean.setID_Prodotto(rs.getInt("ID_Prodotto"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setProduttore(rs.getString("produttore"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setCategoria(rs.getString("categoria"));
				bean.setPng(rs.getString("png"));
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