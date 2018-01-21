<%@ page language="java"%>
<%@ page import="domainClasses.ProgettoFormativo,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<script src="/Progetto_IS/javascript/confermaSubmit.js" type="text/javascript" ></script>
<% 	List<ProgettoFormativo> list = (List<ProgettoFormativo>) request.getSession().getAttribute("list"); %>

<title>Home</title>

</head>
<body>

	<%@include file="header.jsp"%>
	<%@include file="menu.jsp"%> <!--  menu occupa due colonne -->
	
	<div class="col-md-10"><!--  medium  occupa dieci colonne -->
	
	<% out.println("Ciao Mondo!"); %>
	
	
			<form method="POST" action="/Progetto_IS/FirmaProgettoFormativoServlet">
		  <div class="input-group">
		 
		 			
			<%for(int i=0; i<list.size(); i++){%><p><%=list.get(i).toString()%></p><%; %>
			<center><p><%=list.get(i).getIdProgettoFormativo()%></p><%; }%></center>
			<input type="hidden" value="list.get(i).getIdProgettoFormativo" id="idProgettoFormativo" name="idProgettoFormativo" />
		 	<center><input type="submit" value="firma" onclick="confermaSubmit(this.form)"></center>
		    
		  </div>
			   	
		</form>
	
			<div class="container" style="width: 100%; padding-top: 20px; padding-left: 10px;" >				


			</div>
	</div> <!--  medium  -->
	
	<%@include file="footer.jsp"%>
</body>
</html>
