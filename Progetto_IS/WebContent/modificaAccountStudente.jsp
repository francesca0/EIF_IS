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

   <title>Modifica Account Studente</title>
	
	<jsp:include page="datiCss.jsp" />

	</head>
	<body>
  
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> Modifica Account Studente<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
		    <!-- <DATI NEL PANEL> -->
		<div class="row">
		<%	String matricolaStudente = request.getParameter("matricolaStudenteModifica"); %>
			<h2 style="text-align:center;"> Modifica dello Studente con matricola[<%=matricolaStudente%>]</h2>
             <form name="modificaAccountStudenteForm" action="ModificaAccountStudenteServlet" onsubmit="return confirm('Sicuro?'); " >
             			<div class="col-md-6 form-group" >
                        		<label for="matricolaStudente" class="control-label">Matricola Studente</label>
                        		<input type="text" class="form-control" id="matricolaStudente" name="matricolaStudente" placeholder="Inserisci..." >
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="nome" class="control-label">Nome</label>
                        		<input type="text" class="form-control" id="nome" name="nome" placeholder="Inserisci..." >
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="cognome" class="control-label">Cognome</label>
                        		<input type="text" class="form-control" id="cognome" name="cognome" placeholder="Inserisci..." >
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="dataDiNascita" class="control-label">Data di Nascita</label>
                        		<input type="date" class="form-control" id="dataDiNascita" name="dataDiNascita" placeholder="Inserisci...">
             			</div> 
             
     
             			<div class="col-md-6 form-group">
                        		<label for="luogoDiNascita" class="control-label">Luogo di Nascita</label>
                        		<input type="text" class="form-control" id="luogoDiNascita" name="luogoDiNascita" placeholder="Inserisci...">
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="residenza" class="control-label">Residenza</label>
                        		<input type="text" class="form-control" id="residenza" name="residenza" placeholder="Inserisci...">
             			</div> 
             			
         	 			
             			<div class="col-md-6 form-group">
                        		<label for="telefono" class="control-label">Telefono</label>
                        		<input type="text" class="form-control" id="telefono" name="telefono" placeholder="Inserisci...">
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="matricolaTutorAccademico" class="control-label">Matricola Tutor Accademico</label>
                        		<input type="text" class="form-control" id="matricolaTutorAccademico" name="matricolaTutorAccademico" placeholder="Inserisci...">
             			</div> 
             			
             			<div class="col-md-6 form-group">
                        		<label for="email" class="control-label">Email</label>
                        		<input type="text" class="form-control" id="email" name="email" placeholder="Inserisci...">
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="password" class="control-label">Password</label>
                        		<input type="text" class="form-control" id="password" name="password" placeholder="Inserisci...">
             			</div> 
             			
        			 	 <div class="col-md-4 col-md-offset-4 form-group" style="text-align:center">
         	 				<input type="submit" value="Modifica Account Studente" class="btn btn-default" > 
         	 				<input type="hidden" value="<%=matricolaStudente%>" id="matricolaStudenteModifica" name="matricolaStudenteModifica"/>
  						</div>
		 	</form>
		 </div>
   <!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>