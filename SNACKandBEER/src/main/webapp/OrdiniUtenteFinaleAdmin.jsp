<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.bean.*, model.DAO.*, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini Utente</title>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
	</head>
	<body>
	
		<%
			List<OrdineBean> ordini = (List<OrdineBean>)request.getAttribute("listOrdine");		
		%>
	
		<%@ include file="./header.jsp" %>
	
		<section class="adminSection">
		<h2 id="inth2"><b>Visualizza ordini</b></h2>
					<table>
					    <tr>
					      <th> ID</th>
					      <th>Utente</th>
					      <th>Data</th>
					    </tr>
					   <%for(OrdineBean ordine: ordini){ %>
					    <tr>
					      <td><%= ordine.getNumero_ordine()%></td>
					      <td><%= ordine.getEmail()%></td>
					      <td><%= ordine.getData_ordine()%></td>
					    </tr>
					    <%} %>
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