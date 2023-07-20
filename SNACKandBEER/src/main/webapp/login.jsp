<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
		<link rel="stylesheet" href="./styles/accesso.css">
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<section class="loginSection">
		
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
			
			
			  <div class="inForm">
			    <h2>LOGIN</h2>
			    <form action="Login" method="POST">
			      <div class="form-group">
			        <label for="email">Email:</label>
			        <input type="text" id="email" name="email" required>
			      </div>
			      <div class="form-group">
			        <label for="password">Password:</label>
			        <input type="password" id="password" name="password" required>
			      </div>
			      <div class="form-group">
			        <input type="submit" value="Accedi">
			      </div>
			      Non sei registrato? <a href="signup.jsp" class="registration-link">Clicca qui</a>
			    </form>
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