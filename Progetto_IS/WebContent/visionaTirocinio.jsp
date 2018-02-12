<!DOCTYPE html>
<%@page import="domainClasses.TutorAziendale"%>
<%@page import="domainClasses.ResponsabileAziendale"%>
<%@page import="dcs.TirocinioDCS"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="domainClasses.Tirocinio" %>
<%@ page import="domainClasses.Azienda" %>
<%@ page import="utility.ConvertDate" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">


   <title> Tirocinio Selezionato</title>
	
	<jsp:include page="datiCss.jsp" />
  </head>

  <body>
 				<% 
				int idTirocinio = Integer.parseInt(request.getParameter("idTirocinioScelto"));
				//carichiamo tirocinio
			    Tirocinio tirocinio = new Tirocinio();
			    tirocinio.setIdTirocinio(idTirocinio);
			    tirocinio.leggiDatiDaDB();

				//carichiamo responsabileAziendale
			    ResponsabileAziendale responsabileAziendale= new ResponsabileAziendale();
			    responsabileAziendale.setIdResponsabileAziendale(tirocinio.getIdResponsabileAziendale());
			     responsabileAziendale.leggiDatiDaDB();

				//carichiamo tutorAziendale
			    TutorAziendale tutorAziendale = new TutorAziendale();
			     tutorAziendale.setIdTutorAziendale(tirocinio.getIdTutorAziendale());
			     tutorAziendale.leggiDatiDaDB();
			    
			 	 //carichiamo Azienda
			    Azienda azienda= new Azienda();
			    azienda.setIdAzienda(responsabileAziendale.getIdAzienda());
			    azienda.leggiDatiDaDB();
			   
			   %>
			   
			  
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> -->  Tirocinio #<%=idTirocinio%><!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
			
					  <div class="row" style="text-align:center;">
					  	<div class="col-xs-4">
					  		<h5><b>Azienda:</b> <%=azienda.getNomeAzienda()%></h5>
					  	</div>
					  	<div class="col-xs-4">
					  		<h5> <b>Indirizzo:</b> <%=azienda.getIndirizzoAzienda()%></h5>
					  	</div>
					  	<div class="col-xs-4">
					  		<h5> <b>Localita':</b> <%=azienda.getLocalitaAzienda()%></h5>
					  	</div>
					  <hr><hr>
					  	<p>Il tirocinio inizierà il <b><%=ConvertDate.convertDateToString(tirocinio.getDataInizio())%></b> e si concluderà il <b><%=ConvertDate.convertDateToString(tirocinio.getDataFine())%></b>.</p>
						<p>Si svolgerà lungo un periodo di <b><%=tirocinio.getNumeroMesi()%> mesi</b> per un totale di <b><%=tirocinio.getTotaleOre()%> ore</b> lavorative.</p>
					  <hr>
					  	<p>Il tirocinio verrà svolto sotto la supervisione del Tutor Aziendale <b><%=tutorAziendale.getNome()%> <%=tutorAziendale.getCognome()%></b> .</p>
					  	<p><b>Recapiti:</b> Telefono: [<b><%=tutorAziendale.getTelefono()%></b>]   E-mail: [ <b><%=tutorAziendale.getEmail()%></b> ]</p>
				<% /// %>
					  </div>
					  <div class="row" style="text-align:left; max-height: 150px; overflow-y: scroll;">
					  <div class="col-xs-4">
					  		<h5><b>Tematica:</b> </h5>
					  		<p><%=tirocinio.getTematica()%></p>
					  	</div>
					  	<div class="col-xs-4">
					  		<h5> <b>Descrizione:</b> </h5>
					  		<p><%=tirocinio.getDescrizione()%></p>
					  	</div>
					  	<div class="col-xs-4">
					  		<h5> <b>Note:</b> </h5>
					  		<p><%=tirocinio.getNote()%></p>
					  	</div>
					  </div>
					  <hr>
				<% //Form Di Upload %>				
      <div class="panel panel-default">
        <div class="panel-body" style="text-align:center; display: inline;">
          <form method="post" action="InvioProgettoFormativoServlet" enctype="multipart/form-data">
            <div class="form-inline">
              <div class="form-group">
                <input type="file" name="uploadFile" />
              </div>
              <input type="submit" class="btn btn-sm btn-primary" value="Invia Progetto Formativo" />
              <!-- input type="hidden" value="<%//=idTirocinio%>" id="idTirocinioScelto" name="idTirocinioScelto"/ -->
              <% // con la request e hidden non funziona  da controllare
             	session.setAttribute("idTirocinioScelto", idTirocinio);
              %>
            </div>
          </form>
        </div>
      </div> 
						<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>