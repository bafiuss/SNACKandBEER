package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.bean.*;
import model.DAO.*;


@WebServlet("/InserimentoProdotto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class InserimentoProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getAnonymousLogger();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    	
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	int mod = 0;
	    	
	    	ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));
	    
	    		
    		int idProd = Integer.parseInt(request.getParameter("idProdotto"));
    		String nome = request.getParameter("nome");
    		String produttore = request.getParameter("produttore");
    		String descrizione = request.getParameter("descrizione");
    		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
    		int quantita = Integer.parseInt(request.getParameter("quantita"));
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
	    	request.setAttribute("mod", mod);
		
	    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/UploadPhoto");
			dispatcher.forward(request, response);
			return;
    	
    }
}