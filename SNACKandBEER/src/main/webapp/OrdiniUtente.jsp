<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "model.bean.OrdineBean, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<title>Ordini Effettuati</title>
		
		<link rel="stylesheet" href="./styles/ordini.css">
		
		<meta charset="UTF-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1.0">
  
	</head>
	<body>
	
	<%
	    
    	List<OrdineBean> ordini = (List<OrdineBean>)request.getAttribute("ordini");
					
		if(ordini == null){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/OrdiniUtente");
			dispatcher.forward(request, response);	
			return;
		}
      	
		%>
	
		<%@ include file="./header.jsp" %>
			<section class="ordiniSection">	
			<h2 id="inth2"><b> I tuoi ordini</b></h2>
				<table>
				<caption> </caption>
			        <tr>
			            <th>ID</th>
		            	<th>DATA ACQUISTO</th>
		            	<th>QUANTITA'</th>
		            	<th>PREZZO TOTALE</th>
		       		 </tr>
		       		  <%for(OrdineBean ordine : ordini){%>
		       		 <tr>
		       		 	<td><%=ordine.getNumero_ordine()%></td>
		       		 	<td><%=ordine.getData_ordine()%></td>
		       		 	<td><%=ordine.getQuantita()%></td>
		       		 	<td><%=ordine.getPrezzo_totale()%></td>
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