<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.bean.Cart"%>
<%@page import="model.bean.CartItem"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Carrello</title>
			
			<link rel="stylesheet" href="./styles/carrello.css">
			
		</head>
	<body>
	
		<% 
			Cart carrello = (Cart) request.getAttribute("carrello");
			if(carrello == null){
				response.sendRedirect("CartControl");
				return;
			}
			
			
		%>
	
		<%@ include file="./header.jsp" %>
			
			<section class="carrelloSection">	
							
				<% 
				List<String> errors = (List<String>) request.getAttribute("errors");
				if (errors != null){
					System.out.println("caio");
					for (String error: errors){ %>
						<div class="error-message">
	  						<span class="error-text">
	  							<%=error %>
	  						</span>
	  					</div>		
					<%
					}
				}
				%>				
				
				<h2 id="inth2"><b> Il tuo carrello</b></h2>	
					<table>
					    <tr>
					    	<th>    </th>
					      <th>Nome Prodotto</th>
					      <th>Prezzo</th>
					      <th>Quantità</th>
					      <th>Totale</th>
					    </tr>
					  <% for(CartItem pb : carrello.getProducts()) { %>
				
					    <tr>
					    <td> <a href="CartControl?action=delete&code=<%=pb.getProductBean().getID_Prodotto()%>&redirect=carrello">
												<svg width="16" height="18" viewBox="0 0 16 18" fill="none" xmlns="http://www.w3.org/2000/svg">
													<path d="M3 18C2.45 18 1.979 17.804 1.587 17.412C1.195 17.02 0.999333 16.5493 1 16V3H0V1H5V0H11V1H16V3H15V16C15 16.55 14.804 17.021 14.412 17.413C14.02 17.805 13.5493 18.0007 13 18H3ZM13 3H3V16H13V3ZM5 14H7V5H5V14ZM9 14H11V5H9V14Z" fill="black"/>
												</svg>
											</a>
									</td>
					      <td><%= pb.getProductBean().getNome() %></td>
					      <td><%= pb.getProductBean().getPrezzo() %></td>
					      <td><%= pb.getQuantita() %></td>
					      <td><%=pb.getProductBean().getPrezzo() * pb.getQuantita()%> &euro;</td>
					    </tr>
					    <%} %>
					</table>				
				<h2 id="riepilogoh2"><b>Riepilogo</b></h2>
						
				<div class="riepilogo">
						<p class="testoRiepilogo"><b>Spesa Totale:</b>  <%=carrello.getTotale()%>&euro; </p>
						
						
						<button onclick="window.location.href='checkout.jsp'" id="btnCarrello">Procedi</button>
					
					</div>
			
					<div class="checkout-button">
						</div>
				<BR><BR><BR><BR><BR>
				<BR><BR><BR><BR><BR>
				<BR><BR><BR><BR><BR>
				<BR><BR><BR><BR><BR>
				<BR><BR><BR><BR><BR>
			</section>
	
		<%@ include file="./footer.jsp" %>
	</body>
</html>