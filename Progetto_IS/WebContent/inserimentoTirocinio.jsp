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


   <title>Inserimento Tirocinio</title>
	
	<jsp:include page="datiCss.jsp" />
	
  </head>

  <body>
 
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> -->Inserimento Tirocinio<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
					<div class="row">
                
             <form name="inserimentoTirocinioForm" action="InserimentoTirocinioServlet" onsubmit="return confirm('Sicuro?');">
             			<div class="col-md-6 form-group" >
                        		<label for="idTutorAziendale" class="control-label">Id Tutor Aziendale</label>
                        		<input type="text" class="form-control" id="idTutorAziendale" name="idTutorAziendale" placeholder="Inserisci..." required>
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="descrizione" class="control-label">Descrizione</label>
                        		<input type="text" class="form-control" id="descrizione" name="descrizione" placeholder="Inserisci..." >
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="tematica" class="control-label">Tematica</label>
                        		<input type="text" class="form-control" id="tematica" name="tematica" placeholder="Inserisci..." required>
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="note" class="control-label">Note</label>
                        		<input type="text" class="form-control" id="note" name="note" placeholder="Inserisci...">
             			</div> 
             
     
             			<div class="col-md-6 form-group">
                        		<label for="dataInizio" class="control-label">Data Inizio</label>
                        		<input type="date" class="form-control" id="dataInizio" name="dataInizio" required>
             			</div> 
             
             			<div class="col-md-6 form-group">
                        		<label for="dataFine" class="control-label">Data Fine</label>
                        		<input type="date" class="form-control" id="dataFine" name="dataFine" required>
             			</div> 
         	 
         	 			<div class="col-md-6 form-group">
                        		<label for="totaleOre" class="control-label">Totale Ore</label>
                        		<input type="text" class="form-control" id="totaleOre" name="totaleOre" placeholder="Inserisci..." required>
             			</div> 
             			
             			<div class="col-md-6 form-group">
                        		<label for="numeroMesi" class="control-label">Numero Mesi</label>
                        		<input type="text" class="form-control" id="numeroMesi" name="numeroMesi" placeholder="Inserisci..." required>
             			</div> 
             			
        			 	 <div class="col-md-4 col-md-offset-4 form-group" style="text-align:center">
         	 				<input type="submit" value="Inserisci Tirocinio" class="btn btn-default"> 
  						</div>
		 	</form>
                  
                  <%int flagInserimento = 0;
                  	if(!(session.getAttribute("flagInserimento")==null)){
                  		flagInserimento=(int) session.getAttribute("flagInserimento");
      				}
                  	if(flagInserimento==1){%>
                    <div class="col-md-4 col-md-offset-4 form-group" style="text-align:center">
         	 			<p> Tirocinio inserito con successo ! </p>
  					</div>
  				  <% flagInserimento=0;
  				  	session.removeAttribute("flagInserimento");
  				  }%>
		 </div><!-- row -->
		
<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
</body>
</html>