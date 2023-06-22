<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<nav>
				<ul class="link-sx"><li><a href="index.jsp">SNACK&BEER</a></li></ul>
			<div class="topnav">
				<input type="text" placeholder="Cerca...">
			</div>
			<ul class="link-dx">
				<li><a href="birre.jsp" class="aLink">BIRRE</a></li>
				<li><a href="snacks.jsp" class="aLink">SNACKS</a></li>
				<li><a href="accessori.jsp" class="aLink">ACCESSORI</a></li>
			
			</ul>
				<button onclick="window.location.href='login.jsp'"><i class="fa-solid fa-user"></i> ACCEDI</button>
				<button class="sec-btn"><i class="fa-solid fa-cart-shopping"></i> CARRELLO</button>	
		</nav>
	</body>
</html>