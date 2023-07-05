package control;

import java.io.IOException;
import java.sql.SQLException;
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordUtente = null;
		String type = null;
		boolean controlloPsw = false;
		
		List<String> errors = new ArrayList<>();
		
		try {
			user = tool.doRetrieveByKey(email);
		} catch (SQLException e) {
			logger.log(Level.WARNING, "Problema Parse/Sql!");
			}

		if(user!=null && user.getEmail().equals(email) )
		{
			passwordUtente = user.getPassword();
			
			if(passwordUtente.equals(password)) 
				controlloPsw = true;
			else
				controlloPsw = false;
		}
		
		HttpSession session = request.getSession();
		
		if(!controlloPsw){ 
			errors.add("Email o password errati");
			session.setAttribute("logged", "false");
			request.setAttribute("errors", errors);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		
		session.setAttribute("logged", "true"); 
		session.setAttribute("user", user); 
		
		if(user.isAdmin()) 
			type = "true";
		else
			type = "false";
		
		session.setAttribute("isAdmin", type);
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

}


