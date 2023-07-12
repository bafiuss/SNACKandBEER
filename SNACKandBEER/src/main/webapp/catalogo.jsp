<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<%@ page import="java.util.List"%>
<%@ page import="model.bean.ProdottoBean, model.DAO.ProdottoDAO, java.util.*, javax.sql.DataSource"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Birre</title>
			
			<link rel="stylesheet" href="./styles/header.css">
			<link rel="stylesheet" href="./styles/footer.css">
			<link rel="stylesheet" href="./styles/catalogo.css">
		
			<%
				List<ProdottoBean> prodotti = (List<ProdottoBean>) request.getAttribute("prodotti");
				int type = (int) request.getAttribute("type");
;			%>

		</head>
	<body>
		<%@ include file="./header.jsp" %>
	
		
		<section class="catalogoSection">
		
		<% if(!prodotti.isEmpty()) 
		   {
			  if(type == 1)
			  {
		%>
			<h2>Le nostre birre</h2>		
		<%	  } else if(type == 2){
		%>
			<h2>I nostri snack</h2>
		<%
			  } else if(type == 3){	  
		%>		
			<h2>I nostri accessori</h2>
		<%	 }
			   for(ProdottoBean p: prodotti)
			   {
		%>
			<div class="all-products">
				<div class="product">
					<img src="GetPictureServlet?id=<%=p.getID_Prodotto()%>">
					<div class="product-info">
						<h4 class="product-title"><%= p.getNome() %></h4>
						<p class="product-price"><%= p.getPrezzo() %> &euro;</p>
						<a class="product-btn" href="GetProdotto?categoria=<%=p.getCategoria()%>&id=<%= p.getID_Prodotto()%>">Dettagli</a>
					</div>
				</div>
			<%
				}
			   
			}else{
			%>
			<h2>Nessun prodotto disponibile</h2>
			<% } %>
			</div>
			
		</section>
		
		<%@ include file="./footer.jsp" %>
	</body>
</html>