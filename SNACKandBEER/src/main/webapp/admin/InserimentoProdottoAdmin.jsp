<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Inserimento Prodotto</title>
		</head>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
	<body>
	
	<%@ include file="../header.jsp" %>
	
		<section class="adminSection">
		<h2 id="inth2"><b>Inserimento</b></h2>
			  <div class="form">
			    <h2>INSERISCI DATI PRODOTTO</h2>
			    <form action="InserimentoProdotto" method="POST" enctype="multipart/form-data">      
			      <div class="form-group">
			        <label for="idProdotto">ID:</label>
			        <input type="number" id="idProdotto" name="idProdotto" required>
			      </div>
			      <div class="form-group">
			        <label for="nome">Nome:</label>
			        <input type="text" id="nome" name="nome" required>
			      </div>
			      <div class="form-group">
			        <label for="produttore">Produttore:</label>
			        <input type="text" id="produttore" name="produttore" required>
			      </div>
			      <div class="form-group">
			        <label for="descrizione">Descrizione:</label>
			        <input type="text" id="descrizione" name="descrizione" required>
			      </div>
			      <div class="form-group">
			        <label for="prezzo">Prezzo:</label>
			        <input type="number" id="prezzo" name="prezzo" min="0" step="0.01"required>
			      </div>
			      <div class="form-group">
			        <label for="quantita">Quantità:</label>
			        <input type="number" id="quantita" name="quantita" required>
			      </div>
			      <div class="form-group">
			        <label for="photo">Seleziona immagine: </label>
			        <input type="file" id="photo" name="photo" value="" required>
			      </div>
			      <div class="form-group">
			       <label for="img">Seleziona categoria: </label>
			        <select class="selectCategoria" name="categoria" required> 
			        	<option value="Birra">Birra</option>	
			        	<option value="Snack">Snack</option>	
			        	<option value="Accessorio">Accessorio</option>	
			        </select>
			      </div>
			      <div class="form-group">
			        <input type="submit" value="Prosegui">
			      </div>
			     
			    </form>
			  </div>	
			  <br><br><br><br><br>
			<br><br><br><br><br>		
		</section>	
		
		<%@ include file="../footer.jsp" %>
		
	</body>
</html>