<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="model.bean.*, model.DAO.*, java.util.*, javax.sql.DataSource"%>
<!DOCTYPE html>

		<%
			ProdottoBean prod = (ProdottoBean) request.getAttribute("prodotto");
			int type = (int) request.getAttribute("num");
		%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dettaglio Prodotto</title>
		<link rel="stylesheet" href="./styles/prodotto.css">
	</head>
	<body>
	<%@ include file="./header.jsp" %>
	
	<section class="prodottoSection">
 		<form action="CartControl?action=add&code=<%=prod.getID_Prodotto()%>&redirect=carrello" method="post"> 
			  <div class="product-container">
			    <div class="product-image">
			      <img src="GetPictureServlet?id=<%=prod.getID_Prodotto()%>"  alt="imgProdotto">
			    </div>
			    <div class="product-info">
			      <h1><%= prod.getNome() %></b></h1><br>
			      <p><b>Produttore: </b><%= prod.getProduttore() %></p>
			      <p><b>Descrizione: </b><%= prod.getDescrizione() %></p>
			      <p><b>Prezzo: </b><%= prod.getPrezzo() %> &euro;</p>
			      <%
			      	if(type == 1){
			      		BirraBean bir = (BirraBean) request.getAttribute("birra");
			      %>
				      <p><b>Volume: </b><%= bir.getVolume() %> L</p>
				      <p><b>Gradazione alcolica: </b><%= bir.getGradAlcolica() %> % </p>
				      <p><b>Colore: </b><%= bir.getColore() %></p>
				      <p><b>Nazione: </b><%= bir.getNazione() %></p>
			      <%
			      	} else if(type == 2){
			      		SnackBean sna = (SnackBean) request.getAttribute("snack");
			      %>
			      	  <p><b>Quantita: </b><%= sna.getQuantita() %> gr </p>
			      <%
			      	} else if(type == 3){
			      		AccessorioBean acc = (AccessorioBean) request.getAttribute("accessorio");
			      %>
			      	  <p><b>Tipologia: </b><%= acc.getTipologia() %></p>
			      <%
			      	}
			      %>
			      	<button id="">Aggiungi al carrello</button>
			  	</div>
			  </div>
		  </form>
	</section>
	
	<%@ include file="./footer.jsp" %>
	
	</body>
</html>