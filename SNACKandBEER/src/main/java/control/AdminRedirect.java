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
import model.dao.*;


@WebServlet("/Admin")
public class AdminRedirect extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String UTENTI_STR = "listUtenti";
	private static Logger logger = Logger.getAnonymousLogger();
	private static final String WARNING_STR = "Problema accesso db!";
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("scelta");
        String address = null;
        
        ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));
        UserDAO utenteDAO = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));
        
        List<UserBean> utenteArrayList = null;
        List<ProdottoBean> prodottiArrayList = null;

        switch(scelta){
          
            case "Visualizza lista utenti":
				try {
					utenteArrayList = utenteDAO.doRetrieveAll();
				} catch (SQLException e) {
					logger.log(Level.WARNING,WARNING_STR);
				}
                request.setAttribute(UTENTI_STR, utenteArrayList);
                address = "./admin/ListaUtentiAdmin.jsp";
                break;
                
            case "Rimuovi un utente":
				try {
					utenteArrayList = utenteDAO.doRetrieveAll();
				} catch (SQLException e) {
					logger.log(Level.WARNING,WARNING_STR);
				}
                request.setAttribute(UTENTI_STR, utenteArrayList);        		
            	address = "./admin/RimozioneUtenteAdmin.jsp";
                break;
                
            case "Aggiungi un nuovo prodotto":
                address = "./admin/InserimentoProdottoAdmin.jsp";
                break;
                
            case "Rimuovi un prodotto":
				try {
					prodottiArrayList = prodottoDAO.doRetrieveAll();
				} catch (SQLException e) {
					logger.log(Level.WARNING,WARNING_STR);
				}
                request.setAttribute("listProdotti", prodottiArrayList);        		
            	address = "./admin/RimozioneProdottoAdmin.jsp";
                break;
                
            case "Modifica un prodotto":
				try {
					prodottiArrayList = prodottoDAO.doRetrieveAll();
				} catch (SQLException e) {
					logger.log(Level.WARNING,WARNING_STR);
				}
                request.setAttribute("listProdotti", prodottiArrayList);        		
            	address = "./admin/ModificaProdottoAdmin.jsp";
                break;
                
            case "Visualizza ordini":
				try {
					utenteArrayList = utenteDAO.doRetrieveAll();
				} catch (SQLException e) {
					logger.log(Level.WARNING,WARNING_STR);
				}
                request.setAttribute(UTENTI_STR, utenteArrayList);
                address = "./admin/OrdiniUtenteAdmin.jsp";
                break;
                
            default: break;
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}