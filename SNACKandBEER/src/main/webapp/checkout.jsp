<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.UserBean" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
			<title>Pagamento</title>
		
		<link rel="stylesheet" href="./styles/checkout.css">
		<script src="./scripts/validate.js"></script>
		</head>
	<%
		UserBean user = (UserBean)session.getAttribute("user");
		if(user != null){
	%>

	<body>
	
	<%@ include file="./header.jsp" %>
	
		<section class="checkoutSection">
		
		 <div class="container">
		    <h1 style="color: red; text-align: center;">Indirizzo di spedizione: <i style="color: '#1ED953'"> <%=user.getIndirizzoSped()%></i></h1><br><br><hr>
		    <h2 style="padding: 15px 0"> Informazioni Carta </h2>
		    <form action="checkoutPagamento" method="post" id="checkoutForm" onsubmit="event.preventDefault();checkCheckout(this)">
 			 <div class="form-group">
			        <label for="numeroCarta">Numero di carta:</label>
			        <input type="text" id="numCard" name="numeroCarta" required onChange="return validateNumCarta()">
			        <span id="cardNumberError"></span><br>
			      </div>
			      <div class="form-group">
			        <label for="scadenzaCarta">Data di scadenza:</label>
			        <input type="date" id="scadenzaCarta" name="scadenzaCarta" required onChange="return validateScadenzaCarta()"> 
			        <span id="expiryError"></span><br>
			      </div>
			      <div class="form-group">
			        <label for="cvv">CVV:</label>
			        <input type="text" id="cvv" name="cvv" onChange="return validateCVV()"> 
			        <span id="CVVError"></span><br>
			      </div>
			      <div class="form-group">
		        		<input type="submit" value="Effettua Pagamento">
		     	 </div>
		 
			    
			    </form>
			    
			    <%}else{ 
				response.sendRedirect("login.jsp");
				return ;
			}
			%>
			  </div>
			  <br><br><br><br><br>
			  <br><br><br><br><br>
			  <br><br><br><br><br>
			  <br><br><br><br><br>
			  <br><br><br><br><br>
		</section>
	
	<%@ include file="./footer.jsp" %>
	
	</body>
</html>