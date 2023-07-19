<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<title>Chi siamo</title>
		<link rel="stylesheet" href="./styles/header.css">
		<link rel="stylesheet" href="./styles/footer.css">
		<link rel="stylesheet" href="./styles/about.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
	</head>
	<body>
		<%@ include file="./header.jsp" %>
	
		<section class="aboutSection">
		
			<div class="wrapper">
				<div class="rosw">
					<div class="image-section">
						<img src ="images/logo.jpg">
					</div>
					<div class="content">
						<h1>Chi siamo</h1>
						<h2>Il nostro e-commerce</h2>
						<p>Benvenuti nel nostro sito ecommerce dedicato alla birra, il paradiso per gli amanti delle bevande artigianali e dei sapori unici. Siamo entusiasti di presentarvi la nostra vasta selezione di birre provenienti da tutto il mondo, pronte ad essere esplorate e apprezzate.
						<br><br>	Quando visitate il nostro sito, sarete accolti da un'interfaccia intuitiva e moderna, progettata per rendere la vostra esperienza di shopping online semplice e piacevole.
						</p>
					</div>
				</div>
			
			</div>
			
		</section>
		
		<%@ include file="./footer.jsp" %>
	</body>
</html>
