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


@WebServlet("/InserimentoFinaleProdotto")
public class InserimentoFinaleProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getAnonymousLogger();
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    	
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int mod = Integer.parseInt(request.getParameter("mod"));
    	int idProd = Integer.parseInt(request.getParameter("idProd"));
    	
    	if(mod == 1)
    	{
    		
    		double volume = Double.parseDouble(request.getParameter("volume"));
    		double gradAlcolica = Double.parseDouble(request.getParameter("gradAlcolica"));
    		String colore = request.getParameter("colore");
    		String nazione = request.getParameter("nazione");
    		
    		BirraBean beanBirra = new BirraBean();
    		
    		beanBirra.setID_Prodotto(idProd);
    		beanBirra.setVolume(volume);
    		beanBirra.setGradAlcolica(gradAlcolica);
    		beanBirra.setColore(colore);
    		beanBirra.setNazione(nazione);
    		
    		BirraDAO birraDAO = new BirraDAO((DataSource) getServletContext().getAttribute("DataSource"));
    		
    		try {
    			birraDAO.doSave(beanBirra);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING, "Problema accesso DB!" +e.getMessage());
    		}
    	}else if(mod == 2)
    	{
    		
    		int quantita = Integer.parseInt(request.getParameter("quantita"));  
    		
    		SnackBean beanSnack = new SnackBean();
    		
    		beanSnack.setID_Prodotto(idProd);
    		beanSnack.setQuantita(quantita);
    		
    		SnackDAO snackDAO = new SnackDAO((DataSource) getServletContext().getAttribute("DataSource"));
    		
    		try {
    			snackDAO.doSave(beanSnack);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING, "Problema accesso DB!" +e.getMessage());
    		}
    	}else if(mod == 3)
    	{
    		String tipologia = request.getParameter("tipologia");  
    		
    		AccessorioBean beanAccessorio = new AccessorioBean();
    		
    		beanAccessorio.setID_Prodotto(idProd);
    		beanAccessorio.setTipologia(tipologia);
    		
    		AccessorioDAO accessorioDAO = new AccessorioDAO((DataSource) getServletContext().getAttribute("DataSource"));
    		
    		try {
    			accessorioDAO.doSave(beanAccessorio);
    		} catch (SQLException e) {
    			logger.log(Level.WARNING, "Problema accesso DB!" +e.getMessage());
    		}    		
    	}
    	
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/gestione.jsp");
		dispatcher.forward(request, response);
    	
    }
}