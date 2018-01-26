<%@ page language="java"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Menù</title>
</head>
<body>

<head>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
</head>
<div class="container">
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	<div class="row">
		<div class="col-sm-4 col-md-3 sidebar">
    <div class="mini-submenu">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </div>
    <div class="list-group" style="border:1px solid;border-radius:4px;">
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

		<div class="col-md-9 col-xs-offset-3"> 
		<div class="panel panel-default" style="height:500px;border:1px solid">
		
		</div>
		</div>
	
	</div> <!-- row  -->
		

			
		</div> <!-- container -->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>