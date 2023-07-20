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

import model.bean.Cart;
import model.dao.ProdottoDAO;


@WebServlet("/CartControl")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
	private static final String CARRELLO_STR = "carrello";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cart carrello = (Cart) request.getSession().getAttribute(CARRELLO_STR);
		
		if (carrello == null) 
		{
			carrello = new Cart();
			request.getSession().setAttribute(CARRELLO_STR, carrello);
		}

		String action = request.getParameter("action");
		String codeStr = request.getParameter("code");
		String redirect = request.getParameter("redirect");
		

		if (action != null && codeStr != null) 
		{
			int code = Integer.parseInt(codeStr);

			ProdottoDAO productDao = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));

			switch (action) {
			case "add": {
				try {
					carrello.addProduct(productDao.doRetrieveByKey(code));
				} catch (SQLException e) {
					logger.log(Level.WARNING, "Problema accesso DB!");
				}
				break;
			}
			case "delete": {
				try {
					carrello.deleteProduct(productDao.doRetrieveByKey(code));
				} catch (SQLException e) {
					logger.log(Level.WARNING, "Problema accesso DB!");
				}
				break;
			}
			default: break;
			}
		}
		
		if (redirect != null && redirect.equals("catalogo")) {
			response.sendRedirect("catalogo.jsp");
			return;
		}
		if (redirect != null && redirect.equals(CARRELLO_STR)) {
			response.sendRedirect("carrello.jsp");
			return;
		}

		request.setAttribute(CARRELLO_STR, carrello);
		request.getRequestDispatcher("/carrello.jsp").forward(request, response);
		
		
	}

}