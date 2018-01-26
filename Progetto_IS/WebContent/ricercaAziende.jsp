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


   <title>pagina</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"> 			<!-- inclusione stile di bootstrap -->
    <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">    <!-- Bootstrap theme -->
	<link rel="stylesheet" href="bootstrap/style.css"> 						<!--  css modificato -->
	
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container-fluid centered">
          	 <a href="homepage.jsp"><img alt="logo sito" src="images/logo_sito.png" class="img-responsive" height="140px" width="293px"></a> <!--  logo  -->
         	 <img alt="logo dip" src="images/logo_dipartimento.png" class="img-responsive" height="73px" width="424px" id="hideonscreensize"> 
         	 <a href="logout.jsp" ><img alt="logout" src="images/logo_dipartimento.png" class="img-responsive" height="73px" width="200px"></a>
       </div>
    </nav>

    <!-- Begin page content -->
<div class="container">
	<div class="row">
		<div class="col-sm-4 col-md-3 sidebar">
    <div class="mini-submenu" id="minimenu">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </div>
    <div class="list-group" style="border:1px solid;border-radius:4px">
        <span class="list-group-item active" style="text-align:center"> menu 
        <span class="pull-right" id="slide-submenu">
                
            </span>
        </span>
        <a href="#" class="list-group-item">
            <i class="fa fa-comment-o"></i> Lorem ipsum
        </a>
        <a href="#" class="list-group-item">
            <i class="fa fa-search"></i> Lorem ipsum
        </a>
        <a href="#" class="list-group-item">
            <i class="fa fa-user"></i> Lorem ipsum
        </a>
        <a href="#" class="list-group-item">
            <i class="fa fa-folder-open-o"></i> Lorem ipsum <span class="badge">14</span>
        </a>
        <a href="#" class="list-group-item">
            <i class="fa fa-bar-chart-o"></i> Lorem ipsumr <span class="badge">14</span>
        </a>
        <a href="#" class="list-group-item">
            <i class="fa fa-envelope"></i> Lorem ipsum
        </a>
    </div> <!-- list group -->        
</div> <!-- col  -->
	
		<div class="col-sm-8  col-md-9"> 
		
		<div class="panel panel-default" style="border:1px solid"> 
		<div class="panel-heading" style="text-align:center"><b>Welcome to easy-Information!</b></div> 
		<div class="panel-body" style="height: 500px;overflow-y: scroll;"> 
		
			<div class="row">
                
             <div class="col-md-3">
                    <div class="form-group">
                        <label for="lastname" class="control-label">Località Azienda</label>
                        <input type="text" class="form-control" id="lastname" placeholder="Inserisci...">
                    </div>
             </div>
                
                
             <div class="col-md-3">
                    <div class="form-group">
                        <label for="lastname" class="control-label">Nome Azienda</label>
                        <input type="text" class="form-control" id="lastname" placeholder="Inserisci...">
                    </div>
             </div>
                
             
             
        
         	 <div class="col-md-3">
         	 	<div class="form-group">
         	 		<div style="margin-top:25px;text-align:center;">
         	 			<button type="button" class="btn btn-default">
    			 		<span class="glyphicon glyphicon-search"></span> Ricerca  
  						</button> 
  					</div>
  				</div>
            </div>
                      
 
		</div> <!-- row -->	 
		<hr style="border:1px solid">
			
		
		</div> <!-- panel body -->
			
		
		</div> <!-- panel -->
	
	
	</div> <!-- col  -->
	
		</div><!-- row -->
			
			</div> <!-- container -->



    <footer class="footer">
      <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
      </div>
    </footer>


  
    <!-- Bootstrap core JavaScript
    //script aggiuntivi
     <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../assets/js/docs.min.js"></script>
    
    ================================================== -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> <!--  cdn di google per jquery (messo prime del js di bs seno bs non funziona) -->		
<script src="bootstrap/js/bootstrap.min.js"></script> <!-- inclusione del javascript di bootstrap -->
</body>
</html>