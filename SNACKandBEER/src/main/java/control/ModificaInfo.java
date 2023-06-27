package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
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

import model.bean.UserBean;
import model.DAO.UserDAO;



@WebServlet("/ModificaInfo")
public class ModificaInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getAnonymousLogger();
	
	public ModificaInfo() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String indirizzo = null;
		String indirizzoSped = null;
		
		
		
		if (request.getParameter("indirizzo") != null)
			indirizzo = request.getParameter("indirizzo");

		if (request.getParameter("indirizzoSped") != null)
			indirizzoSped = request.getParameter("indirizzoSped");
		
		UserDAO udao = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));	
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		String email = user.getEmail();
		
		HttpSession session = request.getSession();
		user.setIndirizzo(indirizzo);
		user.setIndirizzoSped(indirizzoSped);
		session.setAttribute("user", user);

		try {
			udao.doUpdateInfo(email,indirizzo,indirizzoSped);
			RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema aggiornamento dati DB!");
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}