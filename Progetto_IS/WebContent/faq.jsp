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
  
		<!--  base1 -->
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container-fluid centered">
          	 <a href="homePage.jsp"><img alt="logo sito" src="images/logo_sito.png" class="img-responsive" height="140px" width="293px"></a> <!--  logo  -->
         	 <img alt="logo dip" src="images/logo_dipartimento.png" class="img-responsive" height="73px" width="424px" id="hideonscreensize"> 
         	 <img alt="logout" src="images/logo_unisa.png" class="img-responsive" height="75px" width="75px">
       </div>
    </nav>

    <!-- Begin page content -->
<div class="container-fluid">
	<div class="row">
	
		<div class="col-xs-12"> 

			<div class="panel panel-default" style="border:1px solid;">
   	
				<div class="panel-heading" style="text-align:center"><b>FAQ</b></div> 
	 
					<div class="panel-body" style="text-align:left">
			
					<h3 style="color:#D21F1B">Q: Cosa faccio se ho dimenticato la password?</h3> 
					<h4>A: Contatta l'ufficio stage e tirocini per modificarla</h4> 
				
					<h3 style="color:#D21F1B">Q: È possibile avere più di un progetto formativo in corso?</h3> 
					<h4>A: No, nella versione attuale del sito non è previsto</h4> 
				
					<h3 style="color:#D21F1B">Q: Cosa faccio se la mia richiesta di progetto non viene accettata/firmata/confermata da tempo?</h3> 
					<h4>A: Contatta l'ufficio stage e tirocini, chiedendo informazioni; in alternativa chiedere 
					l'annullamento del progetto formativo per poterne inviare un altro.</h4> 
				
					<h3 style="color:#D21F1B">Q: Come invio un progetto formativo per uno specifico tirocinio?</h3> 
					<h4>A: Prima va fatta la ricerca del tirocinio tramite una delle due modalità di ricerca messe a disposizione dal sito. </h4>
					<h4>Successivamente, va cliccato il pulsante "Seleziona" sul tirocinio scelto; si potrà quindi inviare il progetto formativo.</h4> 
  
  
					</div><!-- panel body -->
		    </div> <!-- panel default -->
		     <!-- </DATI NEL PANEL> -->
		
				</div>
			</div>
		</div>
	

    <footer class="footer">
      <div class="container row" style=" padding-top: 20px;">
     	 <div class="col-xs-1">
     	 </div>
      	<div class="col-xs-1">
	      	<a href="http://corsi.unisa.it/informatica/attivita-e-servizi/tirocini" style="color:white;">Info</a>
	    </div>
	    <div class="col-xs-1">
	        <a href="faq.jsp" style="color:white;">FAQ</a>
	    </div>
      </div>
    </footer>

<!--  base2 -->
  
    <!-- Bootstrap core JavaScript
    //script aggiuntivi
     <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../assets/js/docs.min.js"></script>
    
    ================================================== -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> <!--  cdn di google per jquery (messo prime del js di bs seno bs non funziona) -->		
<script src="bootstrap/js/bootstrap.min.js"></script> <!-- inclusione del javascript di bootstrap -->

	</body>
</html>
