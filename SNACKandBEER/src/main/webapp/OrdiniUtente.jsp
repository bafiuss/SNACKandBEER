<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "model.bean.OrdineBean, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini Effettuati</title>
		
		<link rel="stylesheet" href="./styles/ordini.css">
			<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
					integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
					crossorigin="anonymous">
		
	</head>
	
		<%
	    
    	List<OrdineBean> ordini = (List<OrdineBean>)request.getAttribute("ordini");
					
		/*if(ordini == null){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/OrdiniUtente");
			dispatcher.forward(request, response);	
			return;
		}*/
      	
		%>
	
	<body>
	
		<%@ include file="./header.jsp" %>
		
		<section class="ordiniSection">	
			<h2 id="inth2"><b> I tuoi ordini</b></h2>
					<div class="container">		
					<table class="table">
						  <thead class="thead-dark" style="text-align: center;">
						    <tr>
						      <th scope="col" style="text-align: center;">ID ordine</th>
						      <th scope="col" style="text-align: center;">Data acquisto</th>
						    </tr>
						  </thead>
						  <tbody>	
						 <%for(OrdineBean ordine : ordini){%>
				<tr>
					<td class="table-secondary" style="text-align: center;"><%=ordine.getNumero_ordine()%></td>
					<td class="table-secondary" style="text-align: center;"><%=ordine.getData_ordine()%></td>
                
				</tr>
			<%} %>
			</tbody>
		</table>		
		</section>
		
		<%@ include file="./footer.jsp" %>
	
	
	</body>
</html>