package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.bean.*;
import model.DAO.*;


@WebServlet("/GestioneProdotto")
public class GestioneProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getAnonymousLogger();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    	
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String operazione = request.getParameter("operazione");
    	int type = 0;
    	int mod = 0;
    	
    	ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));

    	if(operazione.equals("aggiungi"))
    	{
    		type = 1;
    		
    		int idProd = Integer.parseInt(request.getParameter("idProdotto"));
    		String nome = request.getParameter("nome");
    		String produttore = request.getParameter("produttore");
    		String descrizione = request.getParameter("descrizione");
    		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
    		int quantita = Integer.parseInt(request.getParameter("prezzo"));
    		String categoria = request.getParameter("categoria");
    		
    		
    		if(categoria.equals("Birra"))
    			mod = 1;
    		else if(categoria.equals("Snack"))
    			mod = 2;
    		else if(categoria.equals("Accessorio"))
    			mod = 3;
    		
    		ProdottoBean bean = new ProdottoBean();
    		bean.setID_Prodotto(idProd);
    		bean.setNome(nome);
    		bean.setProduttore(produttore);
    		bean.setDescrizione(descrizione);
    		bean.setPrezzo(prezzo);
    		bean.setQuantita(quantita);
    		bean.setCategoria(categoria);
    		
    		try {
    			prodottoDAO.doSave(bean);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING, "Problema accesso DB!");
    		}
    		request.setAttribute("idProd", idProd);
    	}
    	
    	
    	
    	request.setAttribute("mod", mod);
    	request.setAttribute("type", type);
    	
    	
    	
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/GestioneProdottoAdmin.jsp");
		dispatcher.forward(request, response);
    	
    }
}