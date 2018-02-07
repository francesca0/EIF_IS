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

   <title> Ricerca Tirocini </title>
	
	<jsp:include page="datiCss.jsp" />

  </head>

  <body>
 
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> Ricerca Tirocini <!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
					<div class="row">
                
             <form name="gestioneRicercaForm" action="GestioneRicercaServlet">
             
             			<div class="col-md-6 form-group">
                        		<label for="dataInizio" class="control-label">Data Inizio</label>
                        		<input type="date" class="form-control" id="dataInizio" name="dataInizio" required>
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="dataFine" class="control-label">Data Fine</label>
                        		<input type="date" class="form-control" id="dataFine" name="dataFine" required>
             			</div> 
             
         	 
        			 	 <div class="col-md-4 col-md-offset-4 form-group" style="text-align:center">
         	 				<input type="submit" value="Ricerca" class="btn btn-default"> 
         	 				<input type="hidden" value="ricercaTirocini" id="tipoRicerca" name="tipoRicerca"/>
  						</div>
		 	</form>
		 </div><!-- row -->
		
<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
</body>
</html>