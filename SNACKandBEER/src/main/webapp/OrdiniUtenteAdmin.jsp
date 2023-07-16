<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.bean.*, model.DAO.*, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini Utente</title>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
					integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
					crossorigin="anonymous">
		
	</head>
	<body>
	
		<%
		    ArrayList<UserBean> utenti = (ArrayList<UserBean>)request.getAttribute("listUtenti");		
		%>
	
		<%@ include file="./header.jsp" %>
	
		<section class="adminSection">
		<h2 id="inth2"><b>Utilizza filtri</b></h2>
			<form method="post" action="ordAdmin">
				<div class="content">	 
					<h2> SCEGLI UTENTE</h2> 
			      	<div class="form-group">
			     
			        <div align="center">
				        <select class="selectCategoria" style="text-align: center;" name="user">
				        <%for(UserBean utente : utenti){ if(utente.isAdmin() == false) {%>
				        	<option value="<%=utente.getEmail()%>"> <%=utente.getEmail()%> - <%=utente.getNome()%> <%=utente.getCognome()%></option>
						<%} }%>
						</select>
				  <div class="form-group">
			        <br><label for="inizioPeriodo">Inizio periodo:</label>
			        <input type="date" id="inizioPeriodo" name="inizioPeriodo" required>
			      </div>
			      <div class="form-group">
			        <label for="finePeriodo">Fine periodo:</label>
			        <input type="date" id="finePeriodo" name="finePeriodo" required>
			      </div>
					</div><br>
			        	<input type="submit" name="scelta" value="Applica">
			      	</div>   	
		      </div>
		    </form>
			
		</section>
	
		<%@ include file="./footer.jsp" %>
		
	</body>
</html>