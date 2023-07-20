<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<title>Signup</title>
		<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
		<link rel="stylesheet" href="./styles/accesso.css">
		<script src="./scripts/validate.js"></script>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<section class="signupSection">
			
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
		    <h2>SIGNUP</h2>
		    <form action="Signup" method="POST" id="regForm" onsubmit="event.preventDefault();checkSignup(this)">
		      <div class="form-group">
		        <label for="nome">Name:</label>
		        <input type="text" id="nome" name="nome" required onChange="return validateNome()">
		        <span id="errorName"></span><br>
			  </div>
		      <div class="form-group">
		        <label for="cognome">Cognome:</label>
		        <input type="text" id="cognome" name="cognome" required onChange="return validateCognome()">
		        <span id="errorLastname"></span><br>
		      </div>
		      <div class="form-group">
		        <label for="nascita">Data di nascita:</label>
		        <input type="date" id="nascitaUtente" name="nascita" required onChange="return ageValidate()">
		        <span id="ageError"></span>
		      </div>
		      <div class="form-group">
		        <label for="indirizzo">Indirizzo:</label>
		        <input type="text" id="indUtente" name="indirizzo" required>
		      </div>
		      <div class="form-group">
		        <label for="indirizzoSped">Indirizzo spedizione:</label>
		        <input type="text" id="indSpedUtente" name="indirizzoSped" required>
		      </div>		      
		      <div class="form-group">
		        <label for="email">Email:</label>
		        <input type="text" id="email" name="email" required onBlur="return validateEmail()" onChange="return tryEmail()"> 
		        <span id="errorEmail"></span><br>
			  </div>
		      <div class="form-group">
		        <label for="password">Password:</label>
		        <input type="password" id="pswUtente" name="password" required onChange ="return validatePassword()">
		        <span id="errorpswd"></span><br>
		      </div>
		      <div class="form-group">
		        <label for="confPsw">Conferma password:</label>
		        <input type="password" id="confPsw" name="confPsw" required onChange="return pswMatching()">
		        <span id="matchError"></span><br>
		      </div>
		      <input type="hidden" name="isAdmin" value="0" required>
		      <div class="form-group">
		        <input type="submit" value="Registrati">
		      </div>
		      Sei già registrato? <a href="login.jsp" class="registration-link"> Clicca qui</a>
		    </form>
		  </div>
		</section>
		
			<%@ include file="./footer.jsp" %>
	</body>
</html>