<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.bean.UserBean, model.DAO.UserDAO, java.util.*, javax.sql.DataSource"%>
<html>
	<head>

			<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lista Utenti</title>
		<link rel="stylesheet" href="./styles/AdminArea.css">
		<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
					integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
					crossorigin="anonymous">
		
		
		
			
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
		
				<div class="container"  style="padding: 0;">
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col">Email</th>
					      <th scope="col">Password</th>
					      <th scope="col">Nome</th>
					      <th scope="col">Cognome</th>
					      <th scope="col">Data di nascita</th>
					      <th scope="col">Indirizzo</th>
					      <th scope="col">Indirizzo di spedizione</th>
					      <th scope="col">Admin</th>
					    </tr>
					  </thead>
					  <tbody>
					  <%for(UserBean utente : list){ %>
					    <tr>
					      <td class="table-secondary"><%= utente.getEmail()%></td>
					      <td class="table-secondary"><%= utente.getPassword()%></td>
					      <td class="table-secondary"><%= utente.getNome()%></td>
					      <td class="table-secondary"><%= utente.getCognome()%></td>
					      <td class="table-secondary"><%= utente.getNascita()%></td>
					      <td class="table-secondary"><%= utente.getIndirizzo()%></td>
					      <td class="table-secondary"><%= utente.getIndirizzoSped()%></td>
					      <td class="table-secondary"><%= utente.isAdmin()%></td>
					    </tr>
					    <%} } %>
					  </tbody>
					</table>
				</div>		
		<br><br><br><br><br><br><br><br>
		</section>
		
		
		<%@ include file="./footer.jsp" %>
	
	</body>
</html>