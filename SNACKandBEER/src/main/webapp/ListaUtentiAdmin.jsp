<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.bean.UserBean, model.DAO.UserDAO, java.util.*, javax.sql.DataSource"%>
<html>
	<head>
		<title>Lista Utenti</title>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
				
	</head>
	<body>
	
		<%
		    ArrayList<UserBean> list = (ArrayList<UserBean>)request.getAttribute("listUtenti");   
		%>
	
		<%@ include file="./header.jsp" %>
		
		<section class="adminSection">
		<%if(list.size() == 0){%>
		<h2><b>Non sono disponibili utenti registrati</b></h2>
		<%}else{ %>
			<h2 id="inth2"><b>Utenti Registrati</b></h2>
					<table class="tab">
					    <tr>
					      <th>Email</th>
					      <th>Password</th>
					      <th>Nome</th>
					      <th>Cognome</th>
					      <th>Data di nascita</th>
					      <th>Indirizzo</th>
					      <th>Indirizzo di spedizione</th>
					      <th>Admin</th>
					    </tr>
					  <%for(UserBean utente : list){ %>
					    <tr>
					      <td><%= utente.getEmail()%></td>
					      <td><%= utente.getPassword()%></td>
					      <td><%= utente.getNome()%></td>
					      <td><%= utente.getCognome()%></td>
					      <td><%= utente.getNascita()%></td>
					      <td><%= utente.getIndirizzo()%></td>
					      <td><%= utente.getIndirizzoSped()%></td>
					      <td><%= utente.isAdmin()%></td>
					    </tr>
					    <%} } %>
					</table>	
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
		</section>
		
		
		<%@ include file="./footer.jsp" %>
	
	</body>
</html>