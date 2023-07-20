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

import model.DAO.ProdottoDAO;

@WebServlet("/RimozioneProdotto")
public class RimozioneProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int prodotto = Integer.parseInt(request.getParameter("prodotto"));
		ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/gestione.jsp");

			try {
				prodottoDAO.doDelete(prodotto);
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Problema eliminazione prodotto dal DB!"+e.getMessage());
			}
			
			dispatcher.forward(request, response);

	}

}