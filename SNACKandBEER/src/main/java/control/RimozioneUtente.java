package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.dao.UserDAO;

@WebServlet("/RimozioneUtente")
public class RimozioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();

       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("user");
		UserDAO userDAO = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/gestione.jsp");
		
		
		if(email != null) {
		
			try {
				userDAO.doDelete(email);
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Problema eliminazione utente dal DB!");
			}
			
	
			dispatcher.forward(request, response);
			return ;
		}
		
		dispatcher.forward(request, response);
	}

}