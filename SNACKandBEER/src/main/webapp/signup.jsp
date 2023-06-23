<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Signup</title>
		<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
		<link rel="stylesheet" href="./styles/accesso.css?ts=<?=time()?>&quot">

	</head>
	<body>
			<%@ include file="./header.jsp" %>
			<% 
			List<String> errors = (List<String>) request.getAttribute("errors");
			if (errors != null){
				for (String error: errors){ %>
					<div class="error-message">
  						<span class="error-text">
  							<%=error %>
  						</span>
  					</div>		
				<%
				}
			}
			%>
			
		  <div class="container">
		    <h2>SIGNUP</h2>
		    <form action="Signup" method="POST">
		      <div class="form-group">
		        <label for="email">Nome:</label>
		        <input type="text" id="nomeUtente" name="nome" required>
		      </div>
		      <div class="form-group">
		        <label for="password">Cognome:</label>
		        <input type="text" id="cognomeUtente" name="cognome" required>
		      </div>
		      <div class="form-group">
		        <label for="email">Indirizzo:</label>
		        <input type="text" id="indUtente" name="indirizzo" required>
		      </div>		      
		      <div class="form-group">
		        <label for="password">Email:</label>
		        <input type="text" id="emailUtente" name="email" required>
		      </div>
		      <div class="form-group">
		        <label for="password">Password:</label>
		        <input type="password" id="pswUtente" name="password" required>
		      </div>
		      <div class="form-group">
		        <label for="password">Conferma password:</label>
		        <input type="password" id="confPsw" name="confPsw" required>
		      </div>
		      <div class="form-group">
		        <input type="submit" value="Registrati">
		      </div>
		      Sei già registrato? <a href="login.jsp" class="registration-link"> Clicca qui</a>
		    </form>
		  </div>

		
			<%@ include file="./footer.jsp" %>
	</body>
</html>