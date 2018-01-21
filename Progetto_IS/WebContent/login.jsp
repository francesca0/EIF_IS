<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
<!-- charset base -->
<meta charset="UTF-8">
<!-- serve a rendere responsive -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="style.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Login</title>
</head>
<body>

<div class="panel panel-default">
 
 	<img src="logo.png" class="img-responsive">
	 
 <div class="panel-bodylogin">

 <form method="POST" action="/Progetto_IS/LoginServlet">
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    <input id="email" type="text" class="form-control" name="email" placeholder="Email">
  </div>
  <div class="input-group">
    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    <input id="password" type="password" class="form-control" name="password" placeholder="Password">
  </div>
	   	<input type="submit" value="Login">
</form>

</div>
	   

</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>