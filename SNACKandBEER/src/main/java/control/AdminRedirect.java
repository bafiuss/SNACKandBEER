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


@WebServlet("/Admin")
public class AdminRedirect extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	 
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("scelta");
        String address = null;
        
        ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));
        UserDAO utenteDAO = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));
        
        ArrayList<UserBean> utenteArrayList;
        ArrayList<ProdottoBean> prodottiArrayList;
        HttpSession session = request.getSession(false);

        switch(scelta){
          
            case "Visualizza lista utenti":
            	utenteArrayList = utenteDAO.doRetrieveAll();
                request.setAttribute("listUtenti", utenteArrayList);
                address = "/ListaUtentiAdmin.jsp";
                break;
                
            case "Rimuovi un utente":
            	utenteArrayList = utenteDAO.doRetrieveAll();
                request.setAttribute("listUtenti", utenteArrayList);        		
            	address = "/RimozioneUtenteAdmin.jsp";
                break;
                
            case "Aggiungi un nuovo prodotto":
                address = "/InserimentoProdottoAdmin.jsp";
                break;
                
            case "Rimuovi un prodotto":
            	prodottiArrayList = prodottoDAO.doRetrieveAll();
                request.setAttribute("listProdotti", prodottiArrayList);        		
            	address = "/RimozioneProdottoAdmin.jsp";
                break;
                
            case "Modifica un prodotto":
            	prodottiArrayList = prodottoDAO.doRetrieveAll();
                request.setAttribute("listProdotti", prodottiArrayList);        		
            	address = "/ModificaProdottoAdmin.jsp";
                break;
                
            case "Visualizza ordini":
            	utenteArrayList = utenteDAO.doRetrieveAll();
                request.setAttribute("listUtenti", utenteArrayList);
                address = "/OrdiniUtenteAdmin.jsp";
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}