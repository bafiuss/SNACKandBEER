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

import model.bean.*;
import model.dao.*;


@WebServlet("/GetProdotto")
public class GetProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
	private static final String DS_STR = "DataSource";
	private static final String WARNING_STR = "Problema accesso DB!";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdottoDAO pDao = new ProdottoDAO((DataSource) getServletContext().getAttribute(DS_STR));
		BirraDAO bDao =new BirraDAO((DataSource) getServletContext().getAttribute(DS_STR));
		SnackDAO sDao =new SnackDAO((DataSource) getServletContext().getAttribute(DS_STR));
		AccessorioDAO aDao = new AccessorioDAO((DataSource) getServletContext().getAttribute(DS_STR));
		
		int num = 0;
		int code = Integer.parseInt(request.getParameter("id"));
		String type = (String) request.getParameter("categoria");
		
		ProdottoBean pBean = null;
		BirraBean bBean = null;
		SnackBean sBean = null;
		AccessorioBean aBean = null;
		

		try {
			pBean = pDao.doRetrieveByKey(code);
		} catch (SQLException e) {
			logger.log(Level.WARNING, WARNING_STR);
		}

		request.setAttribute("prodotto", pBean);
		
		if(type.equals("Birra"))
		{
			try {
				bBean = bDao.doRetrieveByKey(code);
			} catch (SQLException e) {
				logger.log(Level.WARNING, WARNING_STR);
			}
			
			num = 1;
			request.setAttribute("birra", bBean);
			
		}else if(type.equals("Snack"))
		{
			try {
				sBean = sDao.doRetrieveByKey(code);
			} catch (SQLException e) {
				logger.log(Level.WARNING, WARNING_STR);
			}

			num = 2;
			request.setAttribute("snack", sBean);
			
		}else if(type.equals("Accessorio"))
		{
			try {
				aBean = aDao.doRetrieveByKey(code);
			} catch (SQLException e) {
				logger.log(Level.WARNING, WARNING_STR);
			}
			
			num = 3;
			request.setAttribute("accessorio", aBean);
		}
		
		
		request.setAttribute("num", num);
		
		RequestDispatcher dispatcher;
		dispatcher = this.getServletContext().getRequestDispatcher("/DettaglioProdotto.jsp");
		dispatcher.forward(request, response);

		
		
		
	}

}