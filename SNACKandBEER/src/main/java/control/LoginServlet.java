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



@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
    
    public LoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO tool = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));
		UserBean user = null;
		
		String email = null;
		String password = null;
		String passwordUtente = null;
		
		boolean controllo = false;
		
		List<String> errors = new ArrayList<>();
		
		if(request.getParameter("email") != null)
			email = request.getParameter("email");
		
		if(request.getParameter("password") != null)
			password = request.getParameter("password");

		try {
			user = tool.doRetrieveByKey(email);
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema Parse/Sql!");
			}

		if(user!=null && user.getEmail().equals(email) ){
			
			passwordUtente = user.getPassword();
			
			if(passwordUtente.equals(password)) {
				controllo=true;
			}else
				controllo=false;
		}
		
		
		if(!controllo){ 
			errors.add("Email o password errati");
			HttpSession session = request.getSession();
			session.setAttribute("logged", "false");
			request.setAttribute("errors", errors);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		
		
		//significa che ho trovato l'utente
		HttpSession session = request.getSession();
		session.setAttribute("logged", "true"); 
		session.setAttribute("user", user); //mi serve per recuperare le info dell'utente per account
		
		
		
		String res;
		if(user.isAdmin())
			res = "true";
		else
			res = "false";
		
			
		
		session.setAttribute("isAdmin", res);
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		

		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
}


