<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.bean.UserBean, model.DAO.UserDAO, java.util.*, javax.sql.DataSource"%>
<html>
	<head>
		<title>Lista Utenti</title>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		<link rel="stylesheet" href="./styles/table.css">
		
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
				
	</head>
	<body>
	
		<%
		    ArrayList<UserBean> list = (ArrayList<UserBean>)request.getAttribute("listUtenti");   
		%>
	
		<%@ include file="../header.jsp" %>
		
		<section class="adminSection">
		<br><br><br><br><br>
		<%if(list.size() == 0){%>
			<h2><b>Non sono disponibili utenti registrati</b></h2>
		<%}else{ %>
			<h2 id="inth2"><b>Utenti Registrati</b></h2>
					<table class="responsive-table">
					<caption> </caption>
					    <thead>
					      <tr>
					        <th class="email">Email</th>
					        <th class="password">Password</th>
					        <th class="name">Nome</th>
					        <th class="surname">Cognome</th>
					        <th class="birthdate">Data di nascita</th>
					        <th class="address">Indirizzo</th>
					        <th class="shipping-address">Indirizzo di spedizione</th>
					        <th class="admin">Admin</th>
					      </tr>
					    </thead>
					    <tbody>
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
					    </tbody>
					  </table>	
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
			<br><br><br><br><br>
		</section>
		
		
		<%@ include file="../footer.jsp" %>
	
	</body>
</html>