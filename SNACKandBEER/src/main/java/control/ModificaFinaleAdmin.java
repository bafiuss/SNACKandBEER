package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.dao.*;

@WebServlet("/ModificaFinaleAdmin")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class ModificaFinaleAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();

	private static final String DS_STR = "DataSource";
	private static final String MODIFY_STR = "Problema modifica prodotto!";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute(DS_STR));
		BirraDAO birraDAO = new BirraDAO((DataSource) getServletContext().getAttribute(DS_STR));
		SnackDAO snackDAO = new SnackDAO((DataSource) getServletContext().getAttribute(DS_STR));
		AccessorioDAO accessorioDAO = new AccessorioDAO((DataSource) getServletContext().getAttribute(DS_STR));
			
		int id = Integer.parseInt(request.getParameter("idProdotto"));
		String nome = request.getParameter("nome");
		String produttore = request.getParameter("produttore");
		String descrizione = request.getParameter("descrizione");
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		
		
		try {
			prodottoDAO.doUpdate(id,nome,produttore,descrizione,prezzo,quantita);
		} catch (SQLException e) {
			logger.log(Level.WARNING,MODIFY_STR);
		}
		
		int categ = Integer.parseInt(request.getParameter("categoria"));
		
		if(categ == 1)
		{
			double volume = Double.parseDouble(request.getParameter("volume"));
			double gradAlcolica = Double.parseDouble(request.getParameter("gradAlcolica"));
			String colore = request.getParameter("colore");
			String nazione = request.getParameter("nazione");

			try {
    			birraDAO.doUpdate(id,volume,gradAlcolica,colore,nazione);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING,MODIFY_STR);
    		}
		}else if(categ == 2)
		{
			int quant = Integer.parseInt(request.getParameter("quantitaSnack"));
			
			try {
    			snackDAO.doUpdate(id,quant);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING,MODIFY_STR);
    		}
		}else if(categ == 3)
		{
			String tipologia = request.getParameter("tipologia");
			
			try {
    			accessorioDAO.doUpdate(id,tipologia);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING,MODIFY_STR);
    		}
		}
		
		String op = "modifica";
		
		request.setAttribute("idProd", id);
		request.setAttribute("op", op);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/UploadPhoto");
		dispatcher.forward(request, response);
		
	}
}