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
								
		<%	switch( (int)request.getSession().getAttribute("tipoAccount") ) {
		
		
		
		case 1: %>   
			<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			
			case 2: %>   
				
				<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			
			case 3: %>   
			
			<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			
			
			case 4: %>   
			
			<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			
			case 5: %>   
			
			<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			
			case 6: %>   
			
			<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			case 7: %>   
			
			<div class="col-sm-4 col-md-3 sidebar">
						<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Menu
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum</a></li>
			<li><a href="#" >Lorem ipsum <span class="badge">14</span></a></li>
			<li role="separator" class="divider"></li>
			<li><a href="#">Lorem ipsum <span class="badge">14</span></a></li>
		  </ul>
		 
		</div>
		 <hr id="menudropdown">
		<!-- fine menu xs-->
		
		<!-- MENU SM MD-->
    <div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale">
        <span class="list-group-item active" style="text-align:center"> Menu </span>
		
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span></a>
        <a href="#" class="list-group-item">Lorem ipsum <span class="badge">14</span> </a>
        <a href="#" class="list-group-item">Lorem ipsum</a>
    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
					<%
			break; 
			
			
							
					}%>			
			

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
	
</body>
</html>