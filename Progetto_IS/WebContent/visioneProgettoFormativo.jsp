<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@ page import="domainClasses.ProgettoFormativo" %>
<html lang="en">
	<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

   <title>Pagina Esempio</title>
   
	<jsp:include page="datiCss.jsp" />
	
	</head>
	<body>
		<%int tipoAccount =0;
			if(!(session.getAttribute("tipoAccount")==null)){
				tipoAccount = (int) session.getAttribute("tipoAccount"); 
			}%>
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> -->
			
			<%if(tipoAccount==0){%>
				ERRORE
			<%}
			else if(tipoAccount==4){%>
				Stato Progetto Formativo
			<%}
			else{%>
				Progetti Formativi
			<%}%>
			
			<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
			
		<%// tutti gli utenti tranne studente
		if(tipoAccount == 1 || tipoAccount == 2 ||tipoAccount == 3 ||tipoAccount == 5 ||tipoAccount == 6 ||tipoAccount == 7 ){
			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		%>
		<%! @SuppressWarnings("unchecked") %>
		<%
			list = (ArrayList<ProgettoFormativo>) session.getAttribute("listaProgettiFormativiCompletati");
			
			if(list.isEmpty()){
				%>
				<div class="col-xs-12 form-group" style="text-align:center">
				<h1 style="text-align:center;">Nessun Progetto Formativo !</h1>
				</div>	
				<%
			}
			else{
			ProgettoFormativo progettoFormativo =null;
			%>
				
				<div class="table-responsive">
				  <table class="table table-hover table-bordered table-striped">
					<tr>
					  <th>Id</th>
					  <th>Stud.</th>
					  <th>Tirocinio</th>
					  <%if(tipoAccount!=2){ %>
					  <th>TutorAz.</th>
					  <%} %>
					   <%if(tipoAccount!=3){ %>
					  <th>TutorAcc.</th>
					  <%} %>
					  <%if(tipoAccount!=5){ %>
					  <th>Resp. Az.</th>
					  <%} %>
					  <th>firmaTaz</th>
					  <th>firmaTac</th>
					  <th>firmaDd</th>
					  <th>firmaPcd</th>
					  <th>ConfermaUst</th>
					  <th>FileProgetto</th>
					  <th>Stato</th>
					</tr>
				
				<%for(int i=0;i<list.size();i++){
				progettoFormativo = list.get(i);%>
				<tr>
					<td><%=progettoFormativo.getIdProgettoFormativo()%></td>
					<td><%=progettoFormativo.getMatricolaStudente()%></td>
					<td><%=progettoFormativo.getIdTirocinio()%></td>
					<%if(tipoAccount!=2){ %>
					<td><%=progettoFormativo.getIdTutorAziendale()%></td>
					<%} %>
					<%if(tipoAccount!=3){ %>
					<td><%=progettoFormativo.getMatricolaTutorAccademico()%></td>
					<%} %>
					<%if(tipoAccount!=5){ %>
					<td><%=progettoFormativo.getIdResponsabileAziendale()%></td>
					<%} %>
					<td><%=progettoFormativo.getFirmaTaz()%></td>
					<td><%=progettoFormativo.getFirmaTac()%></td>
					<td><%=progettoFormativo.getFirmaDd()%></td>
					<td><%=progettoFormativo.getFirmaPcd()%></td>
					<td><%=progettoFormativo.getConfermaUst()%></td>
					<td><%=progettoFormativo.getNomeFile()%></td>
					
					<%
				if(progettoFormativo.getConfermaUst()==1){%>
						<td class="success">Confermato</td>
					<%}
				else if(progettoFormativo.getRifiutato()==1){%>
				 	 	<td class="danger">Rifiutato</td>
					<%}
				else if(progettoFormativo.getAnnullato()==1){%>
			 	 		<td class="danger">Annullato</td>
					<%}
				else if(progettoFormativo.getFirmaTac()==1 && progettoFormativo.getFirmaTaz()==1 && (progettoFormativo.getFirmaDd()==1 || progettoFormativo.getFirmaPcd()==1)){%>
						<td class="info">Attende conferma</td>
					<%}
				else{%>
			 	 		<td class="info">Attende firme</td>
					<%}%>
					
				</tr>
				<%}%>
				</table>
				</div>
				<% 
			}
		}
		// STUDENTE
		else if(tipoAccount==4){
				ProgettoFormativo progettoFormativo = (ProgettoFormativo) session.getAttribute("progettoFormativoStudente");
				if(progettoFormativo==null){ %>
				<h1>Non hai nessun progetto formativo !</h1>
			<%	}
				else{
				
					//notifica progetto appena inviato
					int progettoInviato = 0;
					if(!(session.getAttribute("progettoInviato")==null)){
						progettoInviato=(int) session.getAttribute("progettoInviato");
					}
					if(progettoInviato==1){%>
						<div class="col-xs-12 form-group" style="text-align:center">
							<p> Progetto Formativo inviato con successo ! </p>
						</div>
					<% progettoInviato=0;
						session.removeAttribute("progettoInviato");
					}
					// fine notifica
					%>
				
					
				
					<div style="text-align:center;">
					<%String stato="In attesa dell'approvazione del Responsabile Aziendale.";
					
					if(progettoFormativo.getRifiutato() == 1){
						stato="Il tuo progetto è stato rifiutato dal Responsabile Aziendale";
					}
					else{
						if(progettoFormativo.getApprovazioneRa()==1){
							stato="Approvato dal Responsabile Aziendale , in attesa delle firme";
						}
						if(progettoFormativo.getFirmaTac()==1 && progettoFormativo.getFirmaTaz()==1 && (progettoFormativo.getFirmaDd()==1 || progettoFormativo.getFirmaPcd()==1)){
							stato="Il progetto ha tutte le firme necessarie! In attesa di conferma dall' Ufficio";
						}
						if(progettoFormativo.getConfermaUst()==1){
							stato="Il tuo progetto è stato confermato dall'ufficio!";
						}
						if(progettoFormativo.getAnnullato()==1){
							stato="Il tuo progetto è stato annullato dall'ufficio!";
					}
				}
				%>
		
				<p>IdProgettoFormativo = <%=progettoFormativo.getIdProgettoFormativo() %></p>
				<p>IdTirocinio = <%=progettoFormativo.getIdTirocinio() %></p>
				<p>idTutorAziendale = <%=progettoFormativo.getIdTutorAziendale() %></p>
				<p>Stato corrente: <%=stato %></p>
				
				</div>
					
			  <%}
		}
		else{%>
			 <h1>ACCESSO NEGATO</h1>
		<%}%>			
			<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>