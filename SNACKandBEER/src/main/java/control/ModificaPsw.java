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



@WebServlet("/ModificaPsw")
public class ModificaPsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getAnonymousLogger();
	
	public ModificaPsw() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vecchiaPsw = null;
		String nuovaPsw = null;

		if (request.getParameter("vecchiaPsw") != null)
			vecchiaPsw = request.getParameter("vecchiaPsw");

		if (request.getParameter("nuovaPsw") != null)
			nuovaPsw = request.getParameter("nuovaPsw");


		UserDAO udao = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		String email = user.getEmail();
		String password = user.getPassword();
		
		List<String> errors = new ArrayList<>();
		
		if(password.equals(vecchiaPsw))
		{
			try {
				udao.doUpdatePsw(email, nuovaPsw);
			} catch (SQLException e) {
				logger.log(Level.WARNING, "Problema aggiornamento dati DB!");	
			}
		}else {
			errors.add("Errore nel cambio password");
			request.setAttribute("errors", errors);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		dispatcher.forward(request, response);
	
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}