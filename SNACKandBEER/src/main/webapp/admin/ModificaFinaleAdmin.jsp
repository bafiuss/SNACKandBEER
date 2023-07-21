<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.bean.*,model.dao.*, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
			<title>Modifica Prodotto</title>
		</head>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
	<body>
	
		<%
			ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto");
			int cat = (int) request.getAttribute("cat");
	
		%>	
	
		<%@ include file="../header.jsp" %>
	
		<section class="adminSection">
			
			<h2 id="inth2"><b>Modifica</b></h2>
		<form action="ModificaFinaleAdmin" method="POST" enctype="multipart/form-data">
			<div class="form">
				<h2>INSERISCI MODIFICHE PRODOTTO</h2>
			    
			    
			    <input type="hidden" value="<%=cat%>" name="categoria">
			    
			      <div class="form-group">
			        <label for="idProdotto">ID:</label>
			        <input type="text" id="idProdotto" name="idProdotto" value="<%= prodotto.getID_Prodotto()%>" required>
			      </div>
			      <div class="form-group">
			        <label for="nome">Nome:</label>
			        <input type="text" id="nome" name="nome" value="<%= prodotto.getNome()%>" required>
			      </div>
			      <div class="form-group">
			        <label for="produttore">Produttore:</label>
			        <input type="text" id="produttore" name="produttore" value="<%= prodotto.getProduttore()%>"required>
			      </div>
			      <div class="form-group">
			        <label for="descrizione">Descrizione:</label>
			        <input type="text" id="descrizione" name="descrizione" value="<%= prodotto.getDescrizione()%>" required>
			      </div>
			      <div class="form-group">
			        <label for="prezzo">Prezzo:</label>
			        <input type="number" id="prezzo" name="prezzo" value="<%= prodotto.getPrezzo()%>" min="0" step="0.01" required>
			      </div>
			      <div class="form-group">
			        <label for="quantita">Quantità:</label>
			        <input type="number" id="quantita" name="quantita" value="<%= prodotto.getQuantita()%>"required>
			      </div>
			      <div class="form-group">
			        <label for="photo">Seleziona immagine: </label>
			        <input type="file" id="photo" name="photo" value="<%= prodotto.getPhoto()%>" required>
			      </div>
			      <%
					if(cat == 1)
					{
						BirraBean birra = (BirraBean) request.getAttribute("birra");
				  %>
				   <div class="form-group">
			        <label for="volume"> Volume: </label>
			        <input type="text" id="volume" name="volume" value="<%= birra.getVolume()%>" required>
			      </div>
			      <div class="form-group">
			        <label for="gradAlcolica"> Gradazione alcolica: </label>
			        <input type="text" id="gradAlcolica" name="gradAlcolica" value="<%= birra.getGradAlcolica()%>" required>
			      </div>
			      <div class="form-group">
			        <label for="colore"> Colore: </label>
			        <input type="text" id="colore" name="colore" value="<%= birra.getColore()%>" required>
			      </div>
			      <div class="form-group">
			        <label for="nazione"> Nazione: </label>
			        <input type="text" id="nazione" name="nazione" value="<%= birra.getNazione()%>" required>
			      </div>
				     <%
						}else if(cat == 2){ SnackBean snack = (SnackBean) request.getAttribute("snack");
					 %>
					
					 <div class="form-group">
				        <label for="quantita"> Quantità (in gr): </label>
				        <input type="text" id="quantita" name="quantitaSnack" value="<%= snack.getQuantita()%>" required>
				      </div>
				     
				    <%
						}else if(cat == 3){ AccessorioBean accessorio = (AccessorioBean) request.getAttribute("accessorio");
					%> 
					
					 <div class="form-group">
				        <label for="tipologia"> Quantità: </label>
				        <input type="text" id="tipologia" name="tipologia" value="<%= accessorio.getTipologia()%>" required>
				      </div>
					<%
						}
					
					%>	  
					
					<br><div class="form-group">
			        	<input type="submit" name="scelta" value="Modifica">
					</div>
					 </div>
			</form>
			<br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		
		</section>
		
		<%@ include file="../footer.jsp" %>
		
	</body>
</html>