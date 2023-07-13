<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.UserBean" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Pagamento</title>
		
		<link rel="stylesheet" href="./styles/checkout.css">
		
		</head>
	<%
		UserBean user = (UserBean)session.getAttribute("user");
		if(user != null){
	%>

	<body>
	
	<%@ include file="./header.jsp" %>
	
		<section class="checkoutSection">
		
		 <div class="container">
		    <h1 style="color: red; text-align: center;">Indirizzo di spedizione: <i style="color: '#1ED953'"> <%=user.getIndirizzoSped()%></i><br><br><hr><h2> Informazioni Carta </h2></h1>
		    <form action="/CheckoutServlet" method="post">
 			<input type="hidden" name="indSped" value="<%=user.getIndirizzoSped() %>">
		      <div class="form-group">
			        <label for="numeroCarta">Numero di carta:</label>
			        <input type="text" id="numeroCarta" name="numeroCarta" required>
			      </div>
			      <div class="form-group">
			        <label for="scadenzaCarta">Data di scadenza:</label>
			        <input type="text" id="scadenzaCarta" name="scadenzaCarta" required>
			      </div>
			      <div class="form-group">
			        <label for="cvv">CVV:</label>
			        <input type="password" id="cvv" name="cvv" required>
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
		</section>
	
	<%@ include file="./footer.jsp" %>
	
	</body>
</html>