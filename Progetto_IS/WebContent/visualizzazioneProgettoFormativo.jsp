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
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> Progetti Formativi Ricevuti	<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
	
				<%//Notifica Approvazione Responsabile Aziendale
					int flagApprovazione = 0;
						
			                  	if(!(session.getAttribute("flagApprovazione")==null)){
			                  		flagApprovazione=(int) session.getAttribute("flagApprovazione");
			      				}
			                  	
			                  	if(flagApprovazione==1){%>
			                    <div class="col-xs-12" style="text-align:center">
			         	 			<p> Progetto Formativo approvato con successo ! </p>
			  					</div>
			  				  <% flagApprovazione=0;
			  				  	session.removeAttribute("flagApprovazione");
			  				  }
			                  	
					//Notifica Rifiuto Responsabile Aziendale
					int flagRifiuto = 0;
			                  	if(!(session.getAttribute("flagRifiuto")==null)){
			                  		flagRifiuto=(int) session.getAttribute("flagRifiuto");
			      				}
			                  	if(flagRifiuto==1){%>
			                    <div class="col-xs-12 form-group" style="text-align:center">
			         	 			<p> Progetto Formativo rifiutato con successo ! </p>
			  					</div>
			  				  <% flagRifiuto=0;
			  				  	session.removeAttribute("flagRifiuto");
			  				  }
			                  	
					//Notifica Conferma Ufficio
					int flagConferma = 0;
					
                  	if(!(session.getAttribute("flagConferma")==null)){
                  		flagConferma=(int) session.getAttribute("flagConferma");
      				}
                  	
                  	if(flagConferma==1){%>
                    <div class="col-xs-12" style="text-align:center">
         	 			<p> Progetto Formativo confermato con successo ! </p>
  					</div>
  				  <% flagConferma=0;
  				  	session.removeAttribute("flagConferma");
  				  }
                  	
					//Notifica Annullamento Ufficio
					int flagAnnullamento = 0;
			                  	if(!(session.getAttribute("flagAnnullamento")==null)){
			                  		flagAnnullamento=(int) session.getAttribute("flagAnnullamento");
			      				}
			                  	if(flagAnnullamento==1){%>
			                    <div class="col-xs-12 form-group" style="text-align:center">
			         	 			<p> Progetto Formativo annullato con successo ! </p>
			  					</div>
			  				  <% flagAnnullamento=0;
			  				  	session.removeAttribute("flagAnnullamento");
			  				  }
			                  	
			       //Notifica Firma
					int flagFirma = 0;
					if(!(session.getAttribute("flagFirma")==null)){
						flagFirma=(int) session.getAttribute("flagFirma");
					}
					if(flagFirma==1){%>
						<div class="col-xs-12 form-group" style="text-align:center">
							<p> Progetto Formativo firmato con successo ! </p>
						</div>
					<% flagFirma=0;
						session.removeAttribute("flagFirma");
					}        
						
			        // FINE NOTIFICHE
				int tipoAccount =0;
					if(!(session.getAttribute("tipoAccount")==null)){
						tipoAccount = (int) session.getAttribute("tipoAccount"); 
					}%>
		<%// tutti gli utenti tranne studente
		if(tipoAccount == 1 || tipoAccount == 2 ||tipoAccount == 3 ||tipoAccount == 5 ||tipoAccount == 6 ||tipoAccount == 7 ){
			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		%>
		<%! @SuppressWarnings("unchecked") %>
		<%
			list = (ArrayList<ProgettoFormativo>) session.getAttribute("listaProgettiFormativiRicevuti");
			
			if(list.isEmpty()){
				%><div class="col-xs-12 form-group" style="text-align:center">
				<h1 style="text-align:center;">Nessun Progetto Formativo !</h1>	
				</div>
				<%
			}
			else{
			ProgettoFormativo progettoFormativo =null;
			%>
				<div class="col-xs-12">
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
					 <%if(tipoAccount!=5){ //il responsabile aziendale non deve vedere il suo id e ha appena ricevuto il progetto , le firme non ci sono per forza di cose%> 
					  <th>Resp. Az.</th>
					  <th>firmaTaz</th>
					  <th>firmaTac</th>
					  <th>firmaDd</th>
					  <th>firmaPcd</th>
					  <%}%>
					  <th>FileProgetto</th>
					  <th>Stato</th>
					  <th>#</th>
					  <%if(tipoAccount==1 || tipoAccount==5){%>
					  <th>#</th>
					  <%} %>
					</tr>
				
				<%for(int i=0;i<list.size();i++){
				progettoFormativo = list.get(i);%>
				<tr style="text-align:center;">
					<td><%=progettoFormativo.getIdProgettoFormativo()%></td>
					<td><%=progettoFormativo.getMatricolaStudente()%></td>
					<td><%=progettoFormativo.getIdTirocinio()%></td>
					<%if(tipoAccount!=2){ %>
					<td><%=progettoFormativo.getIdTutorAziendale()%></td>
					<%} %>
					<%if(tipoAccount!=3){ %>
					<td><%=progettoFormativo.getMatricolaTutorAccademico()%></td>
					<%} %>
					<%if(tipoAccount!=5){ //il responsabile aziendale non deve vedere il suo id e ha appena ricevuto il progetto , le firme non ci sono per forza di cose%> 
					<td><%=progettoFormativo.getIdResponsabileAziendale()%></td>
					<td><%=progettoFormativo.getFirmaTaz()%></td>
					<td><%=progettoFormativo.getFirmaTac()%></td>
					<td><%=progettoFormativo.getFirmaDd()%></td>
					<td><%=progettoFormativo.getFirmaPcd()%></td>
					  <%}%>
					<td>
						<form method="get" action="DownloadProgettoFormativoServlet">
		          			 <input type="submit" value="Scarica File" />
		           			 <input type="hidden" value="<%=progettoFormativo.getMatricolaStudente()%>" id="matricolaFile" name="matricolaFile"/>
		       			 </form>
					</td>
					
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
					
					<%//GESTIONE PULSANTI PER I DIVERSI UTENTI
					if(tipoAccount==1){ //Ufficio 
						if(progettoFormativo.getFirmaTac()==1 && progettoFormativo.getFirmaTaz()==1 && (progettoFormativo.getFirmaDd()==1 || progettoFormativo.getFirmaPcd()==1)){//controllo se il progetto ha tutte le firme %> 
						<td>
							<form name="confermaProgettoFormativoForm" action="ConfermaProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
									<button type="submit" class="list-group-item" >Conferma</button>
									<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoConferma" name="idProgettoFormativoConferma"/>
							</form>
						</td>
						<%}
						else{ //se il progetto non ha tutte le firme , il pulsante non appare%>
						<td>/</td>
						<%}%>
						<td>
							<form name="annullaProgettoFormativoForm" action="AnnullamentoProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
									<button type="submit" class="list-group-item" >Annulla</button>
									<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoAnnullamento" name="idProgettoFormativoAnnullamento"/>
							</form>
						</td>
						<%
						
					} //Ufficio
					if(tipoAccount==5){ //ResponsabileAziendale %> 
					<td>
						<form name="approvazioneProgettoFormativoForm" action="ApprovazioneProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Approva</button>
								<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoApprovazione" name="idProgettoFormativoApprovazione"/>
						</form>
					</td>
					<td>
						<form name="rifiutoProgettoFormativoForm" action="RifiutoProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Rifiuta</button>
								<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoRifiuto" name="idProgettoFormativoRifiuto"/>
						</form>
					</td>
					<%
					}
					if(tipoAccount==3){ //Tutor Accademico 
						if(progettoFormativo.getFirmaTac()==0 && (progettoFormativo.getAnnullato()!=1 && progettoFormativo.getRifiutato()!=1)){//controllo se il progetto ha tutte le firme %> 
						<td>
						<form name="firmaProgettoFormativoForm" action="FirmaProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Firma</button>
								<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoFirma" name="idProgettoFormativoFirma"/>
						</form>
					</td>
						<%}
						else{ //se il progetto non ha tutte le firme , il pulsante non appare%>
						<td>/</td>
						<%}%>
					<%
					} //Tutor Accademico
					
					if(tipoAccount==2){ //Tutor Aziendale 
						if(progettoFormativo.getFirmaTaz()==0 &&((progettoFormativo.getAnnullato()!=1 && progettoFormativo.getRifiutato()!=1))){//controllo se il progetto ha tutte le firme %> 
						<td>
						<form name="firmaProgettoFormativoForm" action="FirmaProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Firma</button>
								<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoFirma" name="idProgettoFormativoFirma"/>
						</form>
					</td>
						<%}
						else{ //se il progetto non ha tutte le firme , il pulsante non appare%>
						<td>/</td>
						<%}%>
					<%
					} //Tutor Aziendale
					

					if(tipoAccount==6){ // Pcd if
						if(progettoFormativo.getFirmaPcd()==0 && ((progettoFormativo.getAnnullato()!=1 && progettoFormativo.getRifiutato()!=1))){ %> 
						<td>
						<form name="firmaProgettoFormativoForm" action="FirmaProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Firma</button>
								<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoFirma" name="idProgettoFormativoFirma"/>
						</form>
					</td>
						<%}
						else{ 
						
							%>
						<td>/</td>
						<%}%>
					<%
					} //Pcd chiusura if
					
					if(tipoAccount==7){ //Dd if
						if(progettoFormativo.getFirmaDd()==0 && (progettoFormativo.getAnnullato()!=1 && progettoFormativo.getRifiutato()!=1)){//controllo se il progetto ha tutte le firme %> 
						<td>
						<form name="firmaProgettoFormativoForm" action="FirmaProgettoFormativoServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Firma</button>
								<input type="hidden" value="<%= progettoFormativo.getIdProgettoFormativo()%>" id="idProgettoFormativoFirma" name="idProgettoFormativoFirma"/>
						</form>
						</td>
					<%}
						else{ //se il progetto non ha tutte le firme , il pulsante non appare%>
						<td>/</td>
						<%}%>
				</tr>
				<%
				    } //dd chiusura if
					
					//ResponsabileAziendale%>
				
				<%
				}
				%>
				</table>
				</div>
				</div>
				<% 
			}
		}
		else{%>
			 <h1>ACCESSO NEGATO</h1>
		<%}%>			
			<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>