<%@ page language="java"%>
<%@ page import="domainClasses.ProgettoFormativo,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Home</title>

</head>
<body>

	<%@include file="header.jsp"%>
	<%@include file="menu.jsp"%> <!--  menu occupa due colonne -->
	
	<div class="col-md-10"><!--  medium  occupa dieci colonne -->
	
	<% out.println("Ciao Mondo!"); %>
	
	
			<form method="POST" action="/Progetto_IS/VisualizzazioneProgettiFormativiServlet">
		  <div class="input-group">
		 
		 	<center><input type="submit" value="bOtton"></center>
		    
		  </div>
			   	
		</form>
	
			<div class="container" style="width: 100%; padding-top: 20px; padding-left: 10px;" >				


			</div>
	</div> <!--  medium  -->
	
	<%@include file="footer.jsp"%>
</body>
</html>
