<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@ page import="domainClasses.Tirocinio" %>
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

   <title>Gestione Tirocini</title>
	
	<jsp:include page="datiCss.jsp" />
	
	</head>
	<body>
  
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> Gestione Tirocini	<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
				<!-- <DATI NEL PANEL> -->
		<div class="row">
			<%//Notifica Eliminazione
			int flagEliminazione = 0;
	                  	if(!(session.getAttribute("flagEliminazione")==null)){
	                  		flagEliminazione=(int) session.getAttribute("flagEliminazione");
	      				}
	                  	if(flagEliminazione==1){%>
	                    <div class="col-xs-12 form-group" style="text-align:center">
	         	 			<p> Tirocinio eliminato con successo ! </p>
	  					</div>
	  				  <% flagEliminazione=0;
	  				  	session.removeAttribute("flagEliminazione");
	  				  }
			//Notifica Modifica
			int flagModifica = 0;
	                  	if(!(session.getAttribute("flagModifica")==null)){
	                  		flagModifica=(int) session.getAttribute("flagModifica");
	      				}
	                  	if(flagModifica==1){%>
	                    <div class="col-xs-12 form-group" style="text-align:center">
	         	 			<p> Tirocinio modificato con successo ! </p>
	  					</div>
	  				  <% flagModifica=0;
	  				  	session.removeAttribute("flagModifica");
	  				  }
	
	        // inizio
	
			int tipoAccount =0;
			if(!(session.getAttribute("tipoAccount")==null)){
					tipoAccount = (int) session.getAttribute("tipoAccount"); 
			}
	
			if(tipoAccount == 5){
				ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
				
			%>
			<%! @SuppressWarnings("unchecked") %>
			<%
				list = (ArrayList<Tirocinio>) session.getAttribute("listaTirocini");
				
				if(list.isEmpty()){
					%>
					<h1 style="text-align:center;">Non ci sono tirocini associati!</h1>	
					<%
				}
				else{
					Tirocinio tirocinio = null;
				%>
				<div class="col-xs-12">
					<div class="table-responsive">
					  <table class="table table-hover table-bordered table-striped">
						<tr>
						  <th>Id</th>
						  <th>TutorAz.</th>
						  <th>Descrizione.</th>
						  <th>Tematica</th>
						  <th>Note</th>
						  <th>Data Inizio</th>
						  <th>Data Fine</th>
						  <th>Totale Ore</th>
						  <th>Numero Mesi</th>
						  <th>#</th>
						  <th>#</th>
						</tr>
					
					<%for(int i=0;i<list.size();i++){
					tirocinio = list.get(i);%>
					<tr>
						<td><%=tirocinio.getIdTirocinio()%></td>
						<td><%=tirocinio.getIdTutorAziendale()%></td>
						<td><%=tirocinio.getDescrizione()%></td>
						<td><%=tirocinio.getTematica()%></td>
						<td><%=tirocinio.getNote()%></td>
						<td><%=ConvertDate.convertDateToString(tirocinio.getDataInizio())%></td>
						<td><%=ConvertDate.convertDateToString(tirocinio.getDataFine())%></td>
						<td><%=tirocinio.getTotaleOre()%></td>
						<td><%=tirocinio.getNumeroMesi()%></td>
						<td>
							<form action="modificaTirocinio.jsp">
							<button type="submit" class="list-group-item" >Modifica</button>
							<input type="hidden" value="<%= tirocinio.getIdTirocinio()%>" id="idTirocinioModifica" name="idTirocinioModifica"/>
							</form>
						</td>
						<td>
							<form name="eliminazioneTirocinioForm" action="EliminazioneTirocinioServlet" onsubmit="return confirm('Sicuro?');" > 
							<button type="submit" class="list-group-item">Elimina</button>
							<input type="hidden" value="<%= tirocinio.getIdTirocinio()%>" id="idTirocinioEliminazione" name="idTirocinioEliminazione"/>
							</form>
						</td>
						
					</tr>
					<%}%>
					</table>
					</div>
					</div>
					<% 
				}
			} %>
			</div>
	<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>