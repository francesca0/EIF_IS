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
<div class="container">
	<div class="row">
		<div class="col-sm-4 col-md-3 sidebar">
		<!-- MENU XS -->
		<div class="dropdown" id="menudropdown">
		  <button class="dropdown-toggle list-group-item active" style="width:100%" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			
<!-- <Menu> -->
	<jsp:include page="GestioneMenu.jsp" />
<!--</Menu> -->

    </div>
	<!-- fine menu sm md -->        
</div> <!-- col  -->
	
		<div class="col-sm-8  col-md-9"> 
			<div class="panel panel-default" style="border:1px solid;">
			
				<div class="panel-heading" style="text-align:center">
