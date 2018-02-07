<!DOCTYPE html>
<%@page import="domainClasses.TutorAziendale"%>
<%@page import="domainClasses.ResponsabileAziendale"%>
<%@page import="dcs.TirocinioDCS"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="domainClasses.Tirocinio" %>
<%@ page import="domainClasses.Azienda" %>
<%@ page import="utility.ConvertDate" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">


   <title> Tirocinio </title>
	
	<jsp:include page="datiCss.jsp" />
  </head>

  <body>
 
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> -->  Tirocinio <!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
			<% int idTirocinio = Integer.parseInt(request.getParameter("idTirocinioScelto")); 
				//carichiamo tirocinio
			    Tirocinio tirocinio = new Tirocinio();
			    tirocinio.setIdTirocinio(idTirocinio);
			    tirocinio.leggiDatiDaDB();

				//carichiamo responsabileAziendale
			    ResponsabileAziendale responsabileAziendale= new ResponsabileAziendale();
			    responsabileAziendale.setIdResponsabileAziendale(tirocinio.getIdResponsabileAziendale());
			    responsabileAziendale.leggiDatiDaDB();

				//carichiamo tutorAziendale
			    TutorAziendale tutorAziendale = new TutorAziendale();
			    tutorAziendale.setIdTutorAziendale(tirocinio.getIdTutorAziendale());
			    tutorAziendale.leggiDatiDaDB();
			    
			 	 //carichiamo Azienda
			    Azienda azienda= new Azienda();
			    azienda.setIdAzienda(responsabileAziendale.getIdAzienda());
			    azienda.leggiDatiDaDB();
			    %>
			    
			<div style="text-align:center;">
				<h1> <%=idTirocinio%></h1>

			</div>
<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
</body>
</html>