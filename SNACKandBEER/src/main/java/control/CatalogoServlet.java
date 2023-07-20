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
import model.dao.*;


@WebServlet("/Catalogo")
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdottoDAO pDao = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));
		
		String categoria = request.getParameter("categoria");
		
		List<ProdottoBean> prodotti = null; 
		
		if(categoria.equals("birra"))
		{
			try {
				prodotti = pDao.getAllProductsByCat("Birra");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("type", 1);
			
		}
		else if(categoria.equals("snack"))
		{
			try {
				prodotti = pDao.getAllProductsByCat("Snack");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("type", 2);
		}
		else if(categoria.equals("accessori"))
		{
			try {
				prodotti = pDao.getAllProductsByCat("Accessorio");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("type", 3);
		}
		
		request.setAttribute("prodotti", prodotti);
		
		RequestDispatcher dispatcher;
		dispatcher = this.getServletContext().getRequestDispatcher("/catalogo.jsp");
		dispatcher.forward(request, response);	
		
	}

}