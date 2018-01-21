<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>header2</title>
</head>
<body>

   <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="glyphicon glyphicon-log-out"></span>
          Log out
      </button>
      
      
      <!--          ssssssss             -->
      <a class="navbar-brand" href="#"><img style="height: 60px; width: 90px"  alt="logo"  src="logo.png"></a>  <!--  LOGO  -->
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#" style="color: white;"><i>Easy In-Formation</i></a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right" >		<!--  PULSANTE DI LOGOUT -->
      	<li style="padding-top: 10px;">
      	<button type="button" class="btn btn-default btn-sm" style="background-color: white;">
          <span class="glyphicon glyphicon-log-out"></span>
          Logout </button>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


    
  

</body>
	
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    
</html>
