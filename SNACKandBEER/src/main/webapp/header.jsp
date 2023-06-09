<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Snack&Beer</title>
		 <link rel="stylesheet" href="./styles/header.css?ts=<?=time()?>&quot">
		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body class="header-body">

				<%
				String log = (String) session.getAttribute("logged");
				
				boolean logged = false, isAdmin = false;
				
				if (log != null && log.equals("true"))
					logged = true;
				else
					logged = false;

				if (session.getAttribute("isAdmin") != null && session.getAttribute("isAdmin").equals("true"))
					isAdmin = true;
				else
					isAdmin = false;
				
				
				%>
	
		<nav>
				<ul class="link-sx"><li><a href="index.jsp" class="aLinkLogo">SNACK&BEER</a></li></ul>
			
			<ul class="link-dx">
				<li><a href="Catalogo?categoria=birra" class="aLink">BIRRE</a></li>
				<li><a href="Catalogo?categoria=snack" class="aLink">SNACKS</a></li>
				<li><a href="Catalogo?categoria=accessori" class="aLink">ACCESSORI</a></li>		
			</ul>
			<% 
			if(!logged && !isAdmin){%>
				<button onclick="window.location.href='login.jsp'"><i class="fa-solid fa-user"></i> ACCEDI</button>
				<button onclick="window.location.href='carrello.jsp'" class="btnCarrello"><i class="fa-solid fa-cart-shopping"></i> CARRELLO</button>			
			<% }else if(logged && !isAdmin){ %>
				<button onclick="window.location.href='account.jsp'" class="btnUtente"><i class="fa-solid fa-user"></i> ACCOUNT</button>	
				<button onclick="window.location.href='carrello.jsp'" class="btnCarrello"><i class="fa-solid fa-cart-shopping"></i> CARRELLO</button>				
			<% }else if (logged && isAdmin){%>	
				<button onclick="window.location.href='account.jsp'" class="btnUtente"><i class="fa-solid fa-user"></i> ACCOUNT</button>	
				<button onclick="window.location.href='gestione.jsp'" class="btnCarrello"><i class='fas fa-user-cog'></i></i> GESTIONE</button>				
			<% } %>
				
	
		</nav>
	</body>
</html>