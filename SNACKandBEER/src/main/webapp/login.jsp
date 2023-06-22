<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
		<link rel="stylesheet" href="./styles/accesso.css?ts=<?=time()?>&quot">

	</head>
	<body>
			<%@ include file="./header.jsp" %>
	
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

		
			<%@ include file="./footer.jsp" %>
	</body>
</html>