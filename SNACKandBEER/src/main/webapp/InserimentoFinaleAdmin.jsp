<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Gestione Prodotto</title>
			
			<link rel="stylesheet" href="./styles/AdminArea.css">
		</head>
	<body>
	
	<%
		int mod = (int) request.getAttribute("mod");
		int idProd = (int) request.getAttribute("idProd");
	%>
	
	
		<%@ include file="./header.jsp" %>
		
			<section class="adminSection">
			
					<div class="container">
					    <h2>INSERISCI DETTAGLI PRODOTTO</h2>
					    <form action="InserimentoFinaleProdotto" method="POST">		      
					      
					      
					      <input type="hidden" value="<%=idProd%>" name="idProd">
					      
					      <%
					      		if(mod == 1)
					      		{
					      %>
					      <input type="hidden" value="1" name="mod">
					      <div class="form-group">
					        <label for="volume">Volume:</label>
					        <input type="number" id="volume" name="volume" required>
					      </div>
					      <div class="form-group">
					        <label for="gradAlcolica">Gradazione Alcolica:</label>
					        <input type="number" id="gradAlcolica" name="gradAlcolica" required>
					      </div>
					      <div class="form-group">
					        <label for="colore">Colore:</label>
					        <input type="text" id="colore" name="colore" required>
					      </div>
					      <div class="form-group">
					        <label for="nazione">Nazione:</label>
					        <input type="text" id="nazione" name="nazione" required>
					      </div>
					      
					      <%
					      	}else if(mod == 2){
					      %>
					      <input type="hidden" value="2" name="mod">
					      <div class="form-group">
					        <label for="quantita">Quantit�:</label>
					        <input type="number" id="quantita" name="quantita" required>
					      </div>
					      <div class="form-group">
					        <input type="submit" value="Prosegui">
					      </div>
					      <%
					      		}else if(mod == 3){
					      %>
					      <input type="hidden" value="3" name="mod">
					      <div class="form-group">
					        <label for="tipologia">Tipologia:</label>
					        <input type="text" id="tipologia" name="tipologia" required>
					      </div>
						 <div class="form-group">
					        <input type="submit" value="Prosegui">
					      </div>
					      <%
					      		}
					      %>
					      
					      
						</form>
					</div>
			
			</section>
	
		<%@ include file="./footer.jsp" %>
		
	</body>
</html>