package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhotoControl;


@WebServlet("/GetPictureServlet")
public class GetPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getAnonymousLogger();
	private static final String WARNING_STR = "Problema accesso db!";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id != 0) 
		{
			byte[] bt=null;
			try {
				bt = PhotoControl.load(id);
			} catch (SQLException e) {
				logger.log(Level.WARNING,WARNING_STR);
			}

			ServletOutputStream out = response.getOutputStream();
			if (bt != null) 
			{
				out.write(bt);
				response.setContentType("image/jpeg");
			}
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}