<!DOCTYPE html>
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

   <title>Risultati Ricerca</title>
   
   <jsp:include page="datiCss.jsp" />
	
	</head>
	<body>
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> -->Risultati Ricerca <!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
		        	
	  <%int tipoAccount =0;
		if(!(session.getAttribute("tipoAccount")==null)){
			tipoAccount = (int) session.getAttribute("tipoAccount"); 
		}%>
		<%//ufficio
		if(tipoAccount == 4 ){ // se è uno studente
			ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
			ArrayList<Azienda> listaAziende = new ArrayList<Azienda>();
			
			String tipoRicerca="";
			if(!(session.getAttribute("tipoRicerca")==null)){
				tipoRicerca =(String) session.getAttribute("tipoRicerca"); 
			}
			// CASO TIROCINI
			if(tipoRicerca.equals("tirocini")){
				session.removeAttribute("tipoRicerca"); //cancelliamo l'attributo per successive ricerche
			%>
				<%! @SuppressWarnings("unchecked") %>
			<%
			listaTirocini = (ArrayList<Tirocinio>) session.getAttribute("listaTirocini");
				
				if(listaTirocini.isEmpty()){
					%>
					<div class="col-xs-12 form-group" style="text-align:center">
					<h1 style="text-align:center;">Nessun tirocinio trovato!</h1>
					</div>	
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
						  <th>IdResponsabile</th>
						  <th>IdTutorAziendale</th>
						  <th>DataInizio.</th>
						  <th>DataFine</th>
						  <th>Tematica</th>
						  <th>Descrizione</th>
						  <th>Note</th>
						  <th>Totale Ore</th>
						  <th>Numero Mesi</th>
						  <th>#</th>
						</tr>
						
					<%for(int i=0;i<listaTirocini.size();i++){
					tirocinio = listaTirocini.get(i);%>
						<tr>
							<td><%=tirocinio.getIdTirocinio()%></td>
							<td><%=tirocinio.getIdResponsabileAziendale()%></td>
							<td><%=tirocinio.getIdTutorAziendale()%></td>
							<td><%=ConvertDate.convertDateToString(tirocinio.getDataInizio())%></td>
							<td><%=ConvertDate.convertDateToString(tirocinio.getDataFine())%></td>
							<td><%=tirocinio.getTematica()%></td>
							<td><%=tirocinio.getDescrizione()%></td>
							<td><%=tirocinio.getNote()%></td>
							<td><%=tirocinio.getTotaleOre()%></td>
							<td><%=tirocinio.getNumeroMesi()%></td>
							<td>
								<form action="visionaTirocinio.jsp">
									<button type="submit" class="list-group-item" >Seleziona</button>
									<input type="hidden" value="<%=tirocinio.getIdTirocinio()%>" id="idTirocinioScelto" name="idTirocinioScelto"/>
								</form>
							</td>
						</tr>
					<%}%>
					</table>
					
					</div>
					</div>
					<% 
				}
			}
			//CASO AZIENDE
			else if(tipoRicerca.equals("aziende")){%>
				<% session.removeAttribute("tipoRicerca"); //cancelliamo l'attributo per successive ricerche
				listaAziende = (ArrayList<Azienda>) session.getAttribute("listaAziende");
					
					if(listaAziende.isEmpty()){
						%>
						<div class="col-xs-12 form-group" style="text-align:center">
						<h1 style="text-align:center;">Nessun azienda trovata!</h1>
						</div>	
						<%
					}
					else{
					Azienda azienda = null;
					%>
						<div class="col-xs-12"> 
						<div class="table-responsive">
						  <table class="table table-hover table-bordered table-striped">
							<tr>
							  <th>IdAzienda</th>
							  <th>NomeAzienda</th>
							  <th>Localita'</th>
							  <th>Indirizzo.</th>
							  <th>Visualizza Tirocini</th>
							</tr>
							
						<%for(int i=0;i<listaAziende.size();i++){
							azienda = listaAziende.get(i);%>
							<tr>
								<td><%=azienda.getIdAzienda()%></td>
								<td><%=azienda.getNomeAzienda()%></td>
								<td><%=azienda.getLocalitaAzienda()%></td>
								<td><%=azienda.getIndirizzoAzienda()%></td>
								<td>
									<form name="gestioneRicercaForm" action="GestioneRicercaServlet">
										<button type="submit" class="list-group-item" >Seleziona</button>
										<input type="hidden" value="<%=azienda.getIdAzienda()%>" id="idAziendaTirocini" name="idAziendaTirocini"/>
										<input type="hidden" value="caricaTirociniAzienda" id="tipoRicerca" name="tipoRicerca"/>
									</form>
								</td>
							</tr>
						<%}%>
						</table>
						
						</div>
						</div>
						<% 
					}
				}
			else{%>
				 <h1>ACCESSO NEGATO</h1>
			<%}
		}
		else{%>
			 <h1>ACCESSO NEGATO</h1>
		<%}%>			
			<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>