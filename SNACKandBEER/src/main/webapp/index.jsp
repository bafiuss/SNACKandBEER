<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Snack&Beer</title>
		<link rel="stylesheet" href="./styles/header.css">
		<link rel="stylesheet" href="./styles/footer.css">
		<link rel="stylesheet" href="./styles/index.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	</head>
	
    <section class="home">
        <div class="text">	
        
        </div>
    </section>
	
	<body>
		<%@ include file="./header.jsp" %>
        <div class="contenuto">	
        	<p class="testoIndex">SNACK&BEER</p>
        	<p class="slogan">Il piacere di bere</p>
			 <a href="Catalogo?categoria=birra"><button id="btnCentrale">SFOGLIA</button> </a>     	
        </div>

		<%@ include file="./footer.jsp" %>
	</body>
</html>