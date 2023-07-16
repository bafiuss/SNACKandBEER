package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import model.bean.*;
import model.DAO.*;



@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getAnonymousLogger();
	
	private static final String LOG_MSG = "Problema accesso DB!";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cart carrello = (Cart) request.getSession().getAttribute("carrello");
		UserBean user = (UserBean) request.getSession().getAttribute("user"); 

		if (carrello == null || user == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		
		/*List<String> errors = carrello.getProducts().stream().map(el->
		el.getProductBean().getQuantita()<el.getQuantita()
		?"Non ci sono abbastanza "+el.getProductBean().getNome()+" nel magazzino (Restanti: "+el.getProductBean().getQuantita()+")"
		:null
		)
		.filter(x -> x != null)
		.collect(Collectors.toList());
		
		/*if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/CartControl").forward(request, response);
			return;
		}*/
		
		List<String> errors = new ArrayList<>();
		List<CartItem> elementi = carrello.getProducts(); 

		if (elementi == null || elementi.isEmpty()) {
			errors.add("Non puoi procedere al pagamento con un carrello vuoto!");
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/carrello.jsp").forward(request, response);
			return;
		}

		OrdineDAO ordinedao = new OrdineDAO((DataSource) getServletContext().getAttribute("DataSource"));
		OrdineBean ordine = new OrdineBean();
		
		int numero_ordine = 0;

		try {
			numero_ordine = ordinedao.doRetrieveMaxNumOrdine() + 1;
			ordine.setNumero_ordine(numero_ordine);
			ordine.setEmail(user.getEmail());
			ordine.setData_ordine(new java.sql.Date(System.currentTimeMillis()));
			ordinedao.doSave(ordine);
		} catch (SQLException e1) {
			logger.log(Level.WARNING, LOG_MSG);
		}


		DettaglioOrdineDAO dettaglioOrdineDAO = new DettaglioOrdineDAO((DataSource) getServletContext().getAttribute("DataSource"));

		try {
			for (CartItem elem : elementi) {
				DettaglioOrdineBean dettaglioOrdine = new DettaglioOrdineBean();
				dettaglioOrdine.setID_Prodotto(elem.getProductBean().getID_Prodotto());
				dettaglioOrdine.setQuantita(elem.getQuantita());
				dettaglioOrdine.setPrezzo(elem.getProductBean().getPrezzo() * elem.getQuantita());
				dettaglioOrdine.setNumero_ordine(numero_ordine);

				dettaglioOrdineDAO.doSave(dettaglioOrdine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ProdottoDAO prodottoDAO = new ProdottoDAO((DataSource) getServletContext().getAttribute("DataSource"));
		for (CartItem elem : elementi) {
			try {
				prodottoDAO.doUpdateQuantity(elem.getProductBean().getID_Prodotto(), elem.getQuantita());
			} catch (SQLException e) {
				logger.log(Level.WARNING, LOG_MSG);
			}
		}
		
		request.getSession().setAttribute("carrello", null);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}