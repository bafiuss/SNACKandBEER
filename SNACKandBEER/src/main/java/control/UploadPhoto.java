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
import javax.servlet.http.Part;

import model.bean.PhotoControl;

@WebServlet("/UploadPhoto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();

	public UploadPhoto() {
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = (int) request.getAttribute("idProd");
		
		Part filePart = request.getPart("photo");
                
		System.out.println(filePart);
        try {
			PhotoControl.updatePhoto(code, filePart.getInputStream());
		} catch (SQLException sqlException) {
			logger.log(Level.WARNING, "Problema SQL!");
		}
        
        String redirect = (String) request.getAttribute("op");
        
        if(redirect.equals("inserimento"))
        {
        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/InserimentoFinaleAdmin.jsp");
    		dispatcher.forward(request, response);
    		return;
        }else if(redirect.equals("modifica"))
        {
        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/gestione.jsp");
    		dispatcher.forward(request, response);
    		return;
        }

        
    	
        
	}

}
