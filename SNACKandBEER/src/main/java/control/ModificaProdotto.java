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

import model.bean.*;
import model.dao.*;

@WebServlet("/ModificaProdotto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class ModificaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
	
	private static final String WARNING_STR = "Problema accesso DB!";
	private static final String DS_STR = "DataSource";
	//private static final String MODIFY_STR = "Problema modifica prodotto!";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		int cat = 0;
		
		
		ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute(DS_STR));
		BirraDAO birraDAO = new BirraDAO((DataSource) getServletContext().getAttribute(DS_STR));
		SnackDAO snackDAO = new SnackDAO((DataSource) getServletContext().getAttribute(DS_STR));
		AccessorioDAO accessorioDAO = new AccessorioDAO((DataSource) getServletContext().getAttribute(DS_STR));
		
		ProdottoBean prodottoBean = null;
		BirraBean birraBean = null;
		SnackBean snackBean = null;
		AccessorioBean accessorioBean = null;
		
			int id = Integer.parseInt(request.getParameter("prodotto"));
			
			try {
				prodottoBean = prodottoDAO.doRetrieveByKey(id);
			} catch (SQLException e) {
				logger.log(Level.WARNING, WARNING_STR);
			}
			
			if(prodottoBean.getCategoria().equals("Birra"))
			{
				cat = 1;
				try {
					birraBean = birraDAO.doRetrieveByKey(id);
				} catch (SQLException e) {
					logger.log(Level.WARNING, WARNING_STR);
				}
				
				request.setAttribute("birra", birraBean);
				
			}		
			else if(prodottoBean.getCategoria().equals("Snack"))
			{
				cat = 2;
				try {
					snackBean = snackDAO.doRetrieveByKey(id);
				} catch (SQLException e) {
					logger.log(Level.WARNING, WARNING_STR);
				}
				
				request.setAttribute("snack", snackBean);
				
			}
			else if(prodottoBean.getCategoria().equals("Accessorio"))
			{
				cat = 3;
				try {
					accessorioBean = accessorioDAO.doRetrieveByKey(id);
				} catch (SQLException e) {
					logger.log(Level.WARNING, WARNING_STR);
				}
				
				request.setAttribute("accessorio", accessorioBean);
			}
			
			request.setAttribute("prodotto", prodottoBean);
			request.setAttribute("cat", cat);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/ModificaFinaleAdmin.jsp");
			dispatcher.forward(request, response);

		
	}
}