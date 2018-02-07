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


   <title> Ricerca Aziende </title>
	
	<jsp:include page="datiCss.jsp" />
  </head>

  <body>
 
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> Ricerca Aziende <!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
					<div class="row">
                
             <form name="gestioneRicercaForm" action="GestioneRicercaServlet">
             			<div class="col-md-6 form-group" >
                        		<label for="localitaAzienda" class="control-label">Localita Azienda</label>
                        		<input type="text" class="form-control" id="localitaAzienda" name="localitaAzienda" placeholder="Inserisci..." >
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="nomeAzienda" class="control-label">Nome Azienda</label>
                        		<input type="text" class="form-control" id="nomeAzienda" name="nomeAzienda" placeholder="Inserisci..." >
             			</div> 
             
         	 
        			 	 <div class="col-md-4 col-md-offset-4 form-group" style="text-align:center">
         	 				<input type="submit" value="Ricerca" class="btn btn-default"> 
         	 				<input type="hidden" value="ricercaAziende" id="tipoRicerca" name="tipoRicerca"/>
  						</div>
		 	</form>
		 </div><!-- row -->
		
<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
</body>
</html>