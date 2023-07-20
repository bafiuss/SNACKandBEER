package control;

import java.io.IOException;
import java.sql.Date;
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


@WebServlet("/ordAdmin")
public class OrdiniUtenteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = (String)request.getParameter("user");
		String inizio =  (String)request.getParameter("inizioPeriodo");
		String fine = (String)request.getParameter("finePeriodo");
		
		Date parseInizio = null;
		Date parseFine = null;

		
		if (inizio != null && !inizio.equals(""))
			parseInizio = java.sql.Date.valueOf(inizio);
		
		if(fine != null && !fine.equals(""))
			parseFine = java.sql.Date.valueOf(fine);
						
		OrdineDAO ordineDAO = new OrdineDAO((DataSource) getServletContext().getAttribute("DataSource"));
		List <OrdineBean> ordineList = null;
		

			try {
				ordineList = (List<OrdineBean>) ordineDAO.doRetrieveByUserData(email, parseInizio, parseFine);
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Problema accesso DB!" + e.getMessage());
			}
		
			
			request.setAttribute("listOrdine", ordineList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/OrdiniUtenteFinaleAdmin.jsp");
			dispatcher.forward(request, response);	
	

}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}