package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.bean.*;
import model.DAO.*;
import model.interfaces.*;

@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confPsw = request.getParameter("confPsw");
		String indirizzo = request.getParameter("indirizzo");
		List<String> errors = new ArrayList<>();
		RequestDispatcher registerDispatcher = request.getRequestDispatcher("signup.jsp");

		


		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			registerDispatcher.forward(request, response);
			return;
		}

		UserDAO userDao = new UserDAO((DataSource) getServletContext().getAttribute("DataSource"));

		try {
			if (userDao.checkUserEmailExistance(email)) {
				errors.add("L'email è già in uso!");
				request.setAttribute("errors", errors);
				//registerDispatcher.forward(request, response);
				//return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		UserBean ub = new UserBean();
		ub.setEmail(email);
		ub.setPassword(password);
		ub.setNome(nome);
		ub.setCognome(cognome);
		ub.setIndirizzo(indirizzo);
		
		if(ub.passControl(password,confPsw)) {
			try {
				userDao.doSave(ub);
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			errors.add("Le due password non corrispondono");
			request.setAttribute("errors", errors);
			
		}
		registerDispatcher.forward(request, response);
		request.setAttribute("registrazione_completata", true);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}