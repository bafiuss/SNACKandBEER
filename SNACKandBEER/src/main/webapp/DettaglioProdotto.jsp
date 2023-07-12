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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-oqVuAfXRKap7fdgcCY5uykM6+R9GqQ8K/uxy9rx7HNQlGYl1kPzQho1wx4JwY8wC"></script>
		
	</head>
	<body>
	<%@ include file="./header.jsp" %>
	
	<section class="prodottoSection">

		  <div class="container">
  				<div class="image">
		      <img src="GetPictureServlet?id=<%=prod.getID_Prodotto()%>" >
		    </div>
		    <div class="info">
		      <h2><b><%= prod.getNome() %></b></h2><br>
		      <p><b>Produttore: </b><%= prod.getProduttore() %></p>
		      <p><b>Descrizione: </b><%= prod.getDescrizione() %></p>
		      <p><b>Prezzo: </b><%= prod.getPrezzo() %> &euro;</p>
		      
		      <%
		      	if(type == 1){
		      		BirraBean bir = (BirraBean) request.getAttribute("birra");
		      %>
			      <p><b>Volume: </b><%= bir.getVolume() %> L</p>
			      <p><b>Gradazione alcolica: </b><%= bir.getGradAlcolica() %></p>
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
	</section>
	
	<%@ include file="./footer.jsp" %>
	
	</body>
</html>