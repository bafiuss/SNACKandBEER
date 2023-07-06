<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Carrello</title>
			
			<link rel="stylesheet" href="./styles/carrello.css">
			<link rel="stylesheet"
					href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
					integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
					crossorigin="anonymous">
		</head>
	<body>
	
		<%@ include file="./header.jsp" %>
			
			<section class="carrelloSection">	
				<h2 id="inth2"><b> Il tuo carrello</b></h2>
			
				<div class="container">
	
					<table class="table">
					  <thead class="thead-dark">
					    <tr>
					    	<th>    </th>
					      <th scope="col">Nome</th>
					      <th scope="col">Prezzo</th>
					      <th scope="col">Quantità</th>
					      <th scope="col">Totale</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					    <td class="table-secondary"> <a href="#">
												<svg width="16" height="18" viewBox="0 0 16 18" fill="none" xmlns="http://www.w3.org/2000/svg">
													<path d="M3 18C2.45 18 1.979 17.804 1.587 17.412C1.195 17.02 0.999333 16.5493 1 16V3H0V1H5V0H11V1H16V3H15V16C15 16.55 14.804 17.021 14.412 17.413C14.02 17.805 13.5493 18.0007 13 18H3ZM13 3H3V16H13V3ZM5 14H7V5H5V14ZM9 14H11V5H9V14Z" fill="black"/>
												</svg>
											</a>
									</td>
					      <td class="table-secondary">...</td>
					      <td class="table-secondary">...</td>
					      <td class="table-secondary">...</td>
					      <td class="table-secondary">...</td>
					    </tr>
					  </tbody>
					</table>
				</div>
				
				<h2 id="riepilogoh2"><b>Riepilogo</b></h2>
						
				<div class="riepilogo">
						<p class="testoRiepilogo"><b>Spesa Totale:</b> 5&euro; </p>
						
						
						<button onclick="window.location.href='checkout.jsp'" id="btnCarrello">Procedi</button>
					
					</div>
			
					<div class="checkout-button">
						</div>
				
			</section>
	
		<%@ include file="./footer.jsp" %>
	</body>
</html>