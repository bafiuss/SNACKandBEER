<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="model.bean.*, model.DAO.*, java.util.*, javax.sql.DataSource"%><!DOCTYPE html>


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

		<div class="container">
		    <div class="image">
		      <img src="percorso_dell_immagine" alt="Immagine del prodotto">
		    </div>
		    <div class="info">
		      <h2>Nome: <%= prod.getTitolo() %></h2>
		      <p>Produttore: <%= prod.getProduttore() %></p>
		      <p>Descrizione: <%= prod.getDescrizione() %></p>
		      <p>Prezzo: <%= prod.getPrezzo() %></p>
		      
		      <%
		      	if(type == 1){
		      		BirraBean bir = (BirraBean) request.getAttribute("birra");
		      %>
			      <p>Volume: <%= bir.getVolume() %> L</p>
			      <p>Gradazione alcolica: <%= bir.getGradAlcolica() %></p>
			      <p>Colore: <%= bir.getColore() %></p>
			      <p>Nazione: <%= bir.getNazione() %></p>
		      <%
		      	} else if(type == 2){
		      		SnackBean sna = (SnackBean) request.getAttribute("snack");
		      %>
		      	  <p>Quantita: <%= sna.getQuantita() %> gr </p>
		      <%
		      	} else if(type == 3){
		      		AccessorioBean acc = (AccessorioBean) request.getAttribute("accessorio");
		      %>
		      	  <p>Tipologia: <%= acc.getTipologia() %></p>
		      <%
		      	}
		      %>
		    </div>
		  </div>
		
	</section>
	
	<%@ include file="./footer.jsp" %>
	
	</body>
</html>