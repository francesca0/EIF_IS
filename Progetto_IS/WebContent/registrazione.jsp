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


   <title>Registrazione</title>
	
	<jsp:include page="datiCss.jsp" />
  </head>

  <body>
<%@ page errorPage = "ErrorPage.jsp" %>

<div class="container">
	
	<div class="row">
		
		<div class="col-md-6 col-md-offset-3">
			
			<div class="panel panel-default" style="margin: auto; height:auto">
				
				<img src="images/logo_sito.png" alt="logo" class="img-responsive">
					
					<div class="panel-body">
			
						<form class="form-horizontal" name="registrazioneForm" action="RegistrazioneServlet" onsubmit="return checkDatiRegistrazione();">
						
  						
  							<div class="form-group">
    						<label class="control-label col-sm-4" for="nome">Nome:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required >
   					    	</div>
  							</div>
  
    						<div class="form-group">
    						<label class="control-label col-sm-4" for="cognome">Cognome:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="cognome" name="cognome" placeholder="Cognome" required>
   							</div>
  							</div>

    						<div class="form-group">
    						<label class="control-label col-sm-4" for="dataDiNascita">Data di nascita:</label>
    						<div class="col-sm-7">
      						<input type="date" class="form-control" id="dataDiNascita" name="dataDiNascita" placeholder="Data di nascita" required>
    						</div>
  							</div> 
  
  							<div class="form-group">
    						<label class="control-label col-sm-4" for="luogoDiNascita" >Luogo di nascita:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="luogoDiNascita" name="luogoDiNascita" placeholder="Luogo di nascita" required>
    						</div>
  							</div>
  
  							<div class="form-group">
    						<label class="control-label col-sm-4" for="residenza">Residenza:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="residenza" name="residenza" placeholder="Residenza" required>
    						</div>
  							</div>  
  

							<div class="form-group">
    						<label class="control-label col-sm-4" for="matricolaStudente">Matricola:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="matricolaStudente" name="matricolaStudente" placeholder="Matricola">
    						</div>
							</div>
  

							<div class="form-group">
    						<label class="control-label col-sm-4" for="telefono">Telefono:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="telefono" name="telefono" placeholder="Telefono">
    						</div>
							</div> 
  

							<div class="form-group">
    						<label class="control-label col-sm-4" for="matricolaTutorAccademico">Matricola Tutor Accademico:</label>
    						<div class="col-sm-7">
      						<input type="text" class="form-control" id="matricolaTutorAccademico" name="matricolaTutorAccademico" placeholder="Matricola Tutor Accademico" required>
    						</div>
							</div>
   

							<div class="form-group">
    						<label class="control-label col-sm-4" for="email">Email:</label>
    						<div class="col-sm-7">
      						<input type="email" class="form-control" id="email" name="email" placeholder="Email">
    						</div>
							</div>


							<div class="form-group">
    						<label class="control-label col-sm-4" for="password">Password:</label>
    						<div class="col-sm-7">
      						<input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
    						</div>
							</div>


							<div class="form-group">
    						<label class="control-label col-sm-4" for="confermaPassword" >Conferma Password:</label>
    						<div class="col-sm-7">
      						<input type="password" class="form-control" id="confermaPassword" name="confermaPassword" placeholder="Conferma Password" required>
    						</div>
							</div>
      
      
      							<div style="text-align:center">
      								<input type="submit" value="Registrati" class="btn btn-default">
	 							</div>	

					</form>
			
		
			</div><!-- panel body -->
		
		</div><!-- panel --> 
		
		</div><!-- col-md-6 -->
	
	</div><!-- row  --> 

</div><!-- container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> <!--  cdn di google per jquery (messo prime del js di bs seno bs non funziona) -->		
<script src="bootstrap/js/bootstrap.min.js"></script> <!-- inclusione del javascript di bootstrap -->
</body>
</html>