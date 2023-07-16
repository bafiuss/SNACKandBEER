package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.bean.*;
import model.DAO.*;


@WebServlet("/ordini")
public class OrdiniUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <OrdineBean> ordini = null;
		List <OrdineBean> dettagli = null;
		Logger logger = Logger.getAnonymousLogger();
		OrdineDAO ordineDAO = new OrdineDAO((DataSource) getServletContext().getAttribute("DataSource"));
		//DettaglioOrdineDAO dettaglioDAO= new DettaglioOrdineDAO((DataSource) getServletContext().getAttribute("DataSource"));
		
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		String email = null;
		
		if(user != null)
			email = user.getEmail();
		
		try {
			ordini = (List<OrdineBean>) ordineDAO.doRetrieveByEmail(email ,"data_ordine");
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema accesso DB!"+e.getMessage());
		}
		
		
		
		
		request.setAttribute("ordini", ordini);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/OrdiniUtente.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}