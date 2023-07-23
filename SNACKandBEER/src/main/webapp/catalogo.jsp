<%@ page import="model.bean.ProdottoBean,model.dao.ProdottoDAO, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="utf-8">
		<meta name="viewpoint" content="width=device-width, initial-scale=1">
		<title>Catalogo</title>
		<link rel="stylesheet" type="text/css" href="./styles/catalogo.css">
		
		<%
				List<ProdottoBean> prodotti = (List<ProdottoBean>) request.getAttribute("prodotti");
				int type = (int) request.getAttribute("type");
		%>
		
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
			<%	 } %>
			<div class="all-products">
			<%
			   for(ProdottoBean p: prodotti)
			   {
			%>
				<div class="product">
					<img src="GetPictureServlet?id=<%=p.getID_Prodotto()%>" alt="imgProdotto">
					<div class="product-info">
						<h4 class="product-title"><%= p.getNome() %></h4>
						<p class="product-price"><%= p.getPrezzo() %> &euro;</p>
						<a class="product-btn" href="GetProdotto?categoria=<%=p.getCategoria()%>&id=<%= p.getID_Prodotto()%>">Dettagli</a>
					</div>
				</div>
				<%
			   }}
			%>
			</div>
		</section>
		
		<%@ include file="./footer.jsp" %>
	</body>
</html>