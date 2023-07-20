<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html lang="it">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewpoint" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/header.css">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

	<title>Snack&Beer</title>
</head>
<body>

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

	<header>
	<div class="cont">
		<div class="subcont">
			<nav class="navbar">
				<a href="index.jsp" class="nav-branding">Snack&Beer</a>
				<ul class="nav-menu">
					<li class="nav-item">
						<a href="Catalogo?categoria=birra" class="nav-link">BIRRE</a>
					</li>
					<li class="nav-item">
						<a href="Catalogo?categoria=snack" class="nav-link">SNACK</a>
					</li>
					<li class="nav-item">
						<a href="Catalogo?categoria=accessori" class="nav-link">ACCESSORI</a>
					</li>
					<% 
						if(!logged){%>
					<li class="nav-item">
						<button onclick="window.location.href='<%=request.getContextPath()%>/login.jsp'"><i class="fa-solid fa-user"></i> ACCEDI</button>
					</li>
					<% }else if(logged){ %>
					<li class="nav-item">
						<button onclick="window.location.href='<%=request.getContextPath()%>/account.jsp'" class="btnUtente"><i class="fa-solid fa-user"></i> ACCOUNT</button>	
					</li>
					<% }%>	
					<li class="nav-item">
						<button onclick="window.location.href='<%=request.getContextPath()%>/carrello.jsp'" class="btnCarrello"><i class="fa-solid fa-cart-shopping"></i> CARRELLO</button>			
					</li>
				</ul>
				<div class="hamburger">
					<span class="bar"></span>
					<span class="bar"></span>
					<span class="bar"></span>
				</div>
			</nav>
		</div>
	</div>
	</header>
	<script src="scripts/header.js"></script>
</body>

</html>
