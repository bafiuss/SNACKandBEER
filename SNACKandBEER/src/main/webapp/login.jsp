<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
		<link rel="stylesheet" href="./styles/accesso.css?ts=<?=time()?>&quot">
		<link rel="stylesheet" href="./styles/index.css">
	</head>
	<body>
			<%@ include file="./header.jsp" %>
			<% 
			List<String> errors = (List<String>) request.getAttribute("errors");
			if (errors != null){
				for (String error: errors){ %>
					<p style="font-size:25px; color: red; padding-top: 2em"  align="center" ><%=error %></p>		
				<%
				}
			}
			%>
		<section class="loginSection">
			  <div class="container">
			    <h2>LOGIN</h2>
			    <form action="Signup" method="POST">
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
			  ciao<br>ciao<br>ciao<br>ciao<br>
		 </section>

		
			<%@ include file="./footer.jsp" %>
	</body>
</html>