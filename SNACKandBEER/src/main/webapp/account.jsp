<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.DAO.UserDAO, model.bean.UserBean, java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Account</title>
		<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
		<link rel="stylesheet" href="./styles/accesso.css?ts=<?=time()?>&quot">
		<link rel="stylesheet" href="./styles/index.css">
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		
		<%
			UserBean user = (UserBean)session.getAttribute("user");
		%>
		
		<section class="accountSection">
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
		    <h2>BENTORNATO <i style="color: '#1ED953'"> <%=user.getEmail()%></i><br><br><hr><br> INFORMAZIONI ACCOUNT</h2>
		    <form action="ModificaInfo" method="POST">
		      <div class="form-group">
		        <label for="nome">Nome:</label>
		        <input type="text" id="nomeUtente" name="nome" value="<%=user.getNome()%>" disabled>
		      </div>
		      <div class="form-group">
		        <label for="cognome">Cognome:</label>
		        <input type="text" id="cognomeUtente" name="cognome" value="<%=user.getCognome()%>" disabled>
		      </div>
		      <div class="form-group">
		        <label for="nascita">Data di nascita:</label>
		        <input type="date" id="nascitaUtente" name="nascita"  value="<%=user.getNascita()%>" disabled>
		      </div>
		      <div class="form-group">
		        <label for="email">Email:</label>
		        <input type="text" id="emailUtente" name="email" value="<%=user.getEmail()%>" disabled>
		      </div>
		      <div class="form-group">
		        <label for="indirizzo">Indirizzo:</label>
		        <input type="text" id="indUtente" name="indirizzo" value="<%=user.getIndirizzo()%>">
		      </div>
		      <div class="form-group">
		        <label for="indirizzoSped">Indirizzo spedizione:</label>
		        <input type="text" id="indSpedUtente" name="indirizzoSped" value="<%=user.getIndirizzoSped()%>">
		      </div>		      
		      <div class="form-group">
		        <input type="submit" value="Modifica">
		      </div>
		    </form>
		  </div>
		  <div class="container">
		  <h2>CAMBIA PASSWORD</h2>		  
		  <form action="ModificaPsw" method="POST">
		  	<div class="form-group">
		        <label for="password">Vecchia password:</label>
		        <input type="password" id="pswUtente" name="vecchiaPsw" required>
		      </div>
		      <div class="form-group">
		        <label for="confPsw">Nuova password:</label>
		        <input type="password" id="confPsw" name="nuovaPsw" required>
		      </div>
			<div class="form-group">
		        <input type="submit" value="Modifica">
		      </div>		      
		  </form>
		  </div>
		  <div class="container">
		   <form action="Logout" method="POST">
		    <h2>EFFETTUA LOGOUT</h2>
		    <div class="form-group">
		        <input id="logout" type="submit" value="Logout">
		    </div>
		    </form>
		   </div>
		</section>
		
		<%@ include file="./footer.jsp" %>
	</body>
</html>