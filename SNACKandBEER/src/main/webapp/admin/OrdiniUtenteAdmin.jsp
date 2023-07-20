<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.bean.*,model.dao.*, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini Utente</title>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
	</head>
	<body>
	
		<%
		    ArrayList<UserBean> utenti = (ArrayList<UserBean>)request.getAttribute("listUtenti");		
		%>
	
		<%@ include file="../header.jsp" %>
	
		<section class="adminSection">
		<h2 id="inth2"><b>Utilizza filtri</b></h2>
			<form method="post" action="ordAdmin">
				<div class="content">	 
					<h2 style="padding: 12px 0;"> SCEGLI UTENTE</h2> 
			      	<div class="form-group">
			     
			        <div>
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
			<br><br><br><br><br>
			<br><br><br><br><br>
		</section>
	
		<%@ include file="../footer.jsp" %>
		
	</body>
</html>