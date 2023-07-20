<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.bean.ProdottoBean, model.DAO.ProdottoDAO, java.util.*"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
			<title>Modifica Prodotto</title>
		</head>
		
		<link rel="stylesheet" href="./styles/AdminArea.css">
		
	<body>
	
		<%@ include file="../header.jsp" %>
		
		<%
		    ArrayList<ProdottoBean> list = (ArrayList<ProdottoBean>)request.getAttribute("listProdotti");
		%>
		
			<section class="adminSection">
			<h2 id="inth2"><b>Modifica</b></h2>
			
			<form method="post" action="ModificaProdotto" enctype="multipart/form-data">
				<div class="content">	 
					<h2> SCEGLI IL PRODOTTO DA MODIFICARE</h2> 
			      	<div class="form-group">
			     	  
			     	<input type="hidden" value="1" name="modType">
			     	
			     
			        <div align="center">
				        <select class="selectCategoria" style="text-align: center;" name="prodotto">
				        <%for(ProdottoBean prodotto : list)
				          {
				        %>
				        	<option value="<%=prodotto.getID_Prodotto()%>"> Nome: <%=prodotto.getNome()%></option>
						<%
				          }  
				        %>
						</select>
					</div><br>
			        	<input type="submit" name="scelta" value="Prosegui">
			      	</div>
			      	
		      </div>
		    </form>	
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
		    <br><br><br><br><br><br>
			</section>
	
		<%@ include file="../footer.jsp" %>
	
	</body>
</html>