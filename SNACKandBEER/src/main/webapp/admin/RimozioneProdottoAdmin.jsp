<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.bean.ProdottoBean, model.DAO.ProdottoDAO, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
			<title>Elimina Prodotto</title>
		</head>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
	<body>
	
		<%@ include file="../header.jsp" %>
		
		<%
		    ArrayList<ProdottoBean> list = (ArrayList<ProdottoBean>)request.getAttribute("listProdotti");
		%>
		
			<section class="adminSection">
		<h2 id="inth2"><b>Rimozione</b></h2>

			<form method="post" action="RimozioneProdotto">
				<div class="content">	 
					<h2> SCEGLI IL PRODOTTO DA ELIMINARE</h2> 
			      	<div class="form-group">
			     
			        <div align="center">
				        <select class="selectCategoria" style="text-align: center;" name="prodotto">
				        <%for(ProdottoBean prodotto : list)
				          {
				        %>
				        	<option value="<%=prodotto.getID_Prodotto()%>"> ID: <%=prodotto.getID_Prodotto()%> - Nome: <%=prodotto.getNome()%></option>
						<%
				          }  
				        %>
						</select>
					</div><br>
			        	<input type="submit" name="scelta" value="Rimuovi prodotto selezionato">
			      	</div>
			      	
		      </div>
		    </form>		
		    <br><br><br><br><br>
		    <br><br><br><br><br>
			</section>
	
		<%@ include file="../footer.jsp" %>
	</body>
</html>