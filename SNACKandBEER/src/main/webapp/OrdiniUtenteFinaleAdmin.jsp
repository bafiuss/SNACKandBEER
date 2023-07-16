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
			List<OrdineBean> ordini = (List<OrdineBean>)request.getAttribute("listOrdine");		
		%>
	
		<%@ include file="./header.jsp" %>
	
		<section class="adminSection">
		<h2 id="inth2"><b>Visualizza ordini</b></h2>
				<div class="container"  style="padding: 0;">
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					      <th scope="col" style="text-align: center;">ID</th>
					      <th scope="col" style="text-align: center;">Utente</th>
					      <th scope="col" style="text-align: center;">Data</th>
					    </tr>
					  </thead>
					  <tbody>
					   <%for(OrdineBean ordine: ordini){ %>
					    <tr>
					      <td class="table-secondary" style="text-align: center;"><%= ordine.getNumero_ordine()%></td>
					      <td class="table-secondary" style="text-align: center;"><%= ordine.getEmail()%></td>
					      <td class="table-secondary" style="text-align: center;"><%= ordine.getData_ordine()%></td>
					    </tr>
					    <%} %>
					  </tbody>
					</table>
				</div>		
			
		</section>
	
		<%@ include file="./footer.jsp" %>
		
	</body>
</html>