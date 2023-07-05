<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestione</title>
		
		<link rel="stylesheet" href="./styles/gestione.css">
		
	</head>
	<body>
		<%@ include file="./header.jsp" %>
	
			<section class="gestioneSection">
			<form action="Admin">
				<div class="container">	 
					<h2> OPERAZIONI SU UTENTI</h2> 
			      	<div class="form-group">
			        	<input type="submit" name="scelta" value="Visualizza lista utenti" onclick="window.location.href='ListaUtentiAdmin.jsp'">
			      		<input type="submit" name="scelta" value="Rimuovi un utente" onclick="window.location.href='RimozioneUtenteAdmin.jsp'">
			      	</div>
		      </div>
		      <div class="container">	 
					<h2> OPERAZIONI SUGLI ORDINI</h2> 
			      	<div class="form-group">
			        	<input type="submit" name="scelta" value="Visualizza tutti gli ordini effettuati" onclick="window.location.href='ListaOrdini.jsp'">
			      	</div>
		      </div>
		      <div class="container">	 
					<h2> OPERAZIONI SUI PRODOTTI</h2> 
			      	<div class="form-group">
			        	<input type="submit" name="scelta" value="Aggiungi un nuovo prodotto" onclick="window.location.href='AggiuntaProdotto.jsp'">
			      		<input type="submit" name="scelta" value="Rimuovi un prodotto" onclick="window.location.href='RimozioneProdotto.jsp'">
			      		<input type="submit" name="scelta" value="Modifica un prodotto" onclick="window.location.href='ModificaProdotto.jsp'">
			      	</div>
		      </div>
		      </form>
			</section>
	
	
		<%@ include file="./footer.jsp" %>
	</body>
</html>