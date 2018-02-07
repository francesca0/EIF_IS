<!DOCTYPE html>
<html lang="en">
	<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

   <title>Pagina Esempio</title>
	
	<jsp:include page="datiCss.jsp" />
	
	</head>
	<body>
  
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> HomePage	<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
		     <%int tipoAccount= 0;
		     
		     if(!(session.getAttribute("tipoAccount")==null)){
		    	  tipoAccount = (int) session.getAttribute("tipoAccount"); 
		    	 }
		        String stampa="";
		        
		     switch(tipoAccount){
		     case 1: stampa="Ufficio Stage e Tirocini!"; break;
		     case 2: stampa="Tutor Aziendale!"; break;
		     case 3: stampa="Tutor Accademico!"; break;
		     case 4: stampa="Studente!"; break;
		     case 5: stampa="Responsabile Aziendale!"; break;
		     case 6: stampa="Presidente del Consiglio Didattico!"; break;
		     case 7: stampa="Direttore di Dipartimento!"; break;
		     }%>
	     	<h1 style="text-align:center;">Benvenuto in Easy In-Formation</h1>
	     	<h2 style="text-align:center;"><%=stampa %></h2>
   <!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>