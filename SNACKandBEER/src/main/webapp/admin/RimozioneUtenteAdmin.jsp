<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.bean.UserBean,model.dao.UserDAO, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<title>Rimozione Utente</title>
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
			
		
	</head>
	<body>
		<%@ include file="../header.jsp" %>
		
		<%
		    List<UserBean> list = (List<UserBean>)request.getAttribute("listUtenti");
		%>	
	
		<section class="adminSection">
		<h2 id="inth2"><b>Rimozione</b></h2>

			<form method="post" action="RimozioneUtente">
				<div class="content">	 
					<h2> SCEGLI L'UTENTE DA RIMUOVERE</h2> 
			      	<div class="form-group">
			     
			        <div>
				        <select class="selectCategoria" style="text-align: center;" name="user">
				        <%for(UserBean utente : list){ if(utente.isAdmin() == false) {%>
				        	<option value="<%=utente.getEmail()%>"> <%=utente.getEmail()%> - <%=utente.getNome()%> <%=utente.getCognome()%></option>
						<%} }%>
						</select>
					</div><br>
			        	<input type="submit" name="scelta" value="Rimuovi utente selezionato">
			      	</div>
			      	
		      </div>
		    </form>
				<br><br><br><br><br>
				<br><br><br><br><br>
				<br><br><br><br><br>
			</section>
	
		<%@ include file="../footer.jsp" %>
	</body>
</html>