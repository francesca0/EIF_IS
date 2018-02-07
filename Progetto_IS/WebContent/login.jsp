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


   <title>Login</title>
	
	<jsp:include page="datiCss.jsp" />
	
  </head>

  <body>
<%@ page errorPage = "ErrorPage.jsp" %>

	 <div class="container-fluid row"> 
	<div class="col-xs-2 col-sm-3 col-md-4">
	</div>
		
		<div class="col-xs-8 col-sm-6 col-md-4">
			
			<div class="panel panel-default">
			
			<div class="panel-body">
			<img src="images/logo_sito.png" alt="logo" class="img-responsive">
			
			
			<form name="loginForm" method="post" action="LoginServlet">
  				<div class="input-group">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    				<input id="email" type="text" class="form-control" name="email" placeholder="Email" required>
  				</div>
  
  				<div class="input-group">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    				<input id="password" type="password" class="form-control" name="password" placeholder="Password" required>
  				</div>

	
      			<div style="text-align:center">
      				<input type="submit" class="btn btn-default" value="Login">
    			</div>
			</form> 
			</div><!-- panel-body -->
			
			
			</div> <!-- panel --> 
		
		</div><!-- col --> 
		<div class="col-xs-2 col-sm-3 col-md-4">
		</div>
	</div>





</body>
</html>