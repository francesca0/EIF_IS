<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@ page import="domainClasses.Studente" %>
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

   <title>Pagina Esempio</title>
	
	<jsp:include page="datiCss.jsp" />
	
	
	</head>
	<body>
		<jsp:include page="BaseSitoSuperiore.jsp" />
			<!-- <TITOLO PANEL> --> Lista Studenti	<!-- </TITOLO PANEL> -->
		<jsp:include page="ChiusuraTitoloPanel.jsp" />
			<!-- <DATI NEL PANEL> -->
			
			<%//Notifica Mofifica Account Studente
					int flagModificaStudente = 0;
						
			                  	if(!(session.getAttribute("flagModificaStudente")==null)){
			                  		flagModificaStudente=(int) session.getAttribute("flagModificaStudente");
			      				}
			                  	
			                  	if(flagModificaStudente==1){%>
			                    <div class="col-xs-12" style="text-align:center">
			         	 			<p> Account studente modificato con successo ! </p>
			  					</div>
			  				  <% flagModificaStudente=0;
			  				  	session.removeAttribute("flagModificaStudente");
			  				  }
			                  	
					//Notifica Eliminazione Account Studente
					int flagEliminazioneStudente = 0;
			                  	if(!(session.getAttribute("flagEliminazioneStudente")==null)){
			                  		flagEliminazioneStudente=(int) session.getAttribute("flagEliminazioneStudente");
			      				}
			                  	if(flagEliminazioneStudente==1){%>
			                    <div class="col-xs-12 form-group" style="text-align:center">
			         	 			<p> Account Studente eliminato con successo ! </p>
			  					</div>
			  				  <% flagEliminazioneStudente=0;
			  				  	session.removeAttribute("flagEliminazioneStudente");
			  				  }
			                  	
			      %>            	
	  <%int tipoAccount =0;
		if(!(session.getAttribute("tipoAccount")==null)){
			tipoAccount = (int) session.getAttribute("tipoAccount"); 
		}%>
		<%//ufficio
		if(tipoAccount == 1 ){
			ArrayList<Studente> list = new ArrayList<Studente>();
		%>
		<%! @SuppressWarnings("unchecked") %>
		<%
			list = (ArrayList<Studente>) session.getAttribute("listaStudenti");
			
			if(list.isEmpty()){
				%>
				<div class="col-xs-12 form-group" style="text-align:center">
				<h1 style="text-align:center;">Nessuno Studente presente nel database!</h1>
				</div>	
				<%
			}
			else{
			Studente studente = null;
			%>
				<div class="col-xs-12"> 
				<div class="table-responsive">
				  <table class="table table-hover table-bordered table-striped">
					<tr>
					  <th>MatricolaStudente</th>
					  <th>Nome</th>
					  <th>Cognome</th>
					  <th>DataNascita.</th>
					  <th>LuogoNascita</th>
					  <th>Residenza</th>
					  <th>Telefono</th>
					  <th>Matr.Tutor.Acc.</th>
					  <th>Email</th>
					  <th>Password</th>
					  <th>#</th>
					  <th>#</th>
					</tr>
					
				<%for(int i=0;i<list.size();i++){
				studente = list.get(i);%>
					<tr>
						<td><%=studente.getMatricolaStudente()%></td>
						<td><%=studente.getNome()%></td>
						<td><%=studente.getCognome()%></td>
						<td><%=ConvertDate.convertDateToString(studente.getDataDiNascita())%></td>
						<td><%=studente.getLuogoDiNascita()%></td>
						<td><%=studente.getResidenza()%></td>
						<td><%=studente.getTelefono()%></td>
						<td><%=studente.getMatricolaTutorAccademico()%></td>
						<td><%=studente.getEmail()%></td>
						<td><%=studente.getPassword()%></td>
						<td>
							<form action="modificaAccountStudente.jsp" name="modificaAccountStudenteForm" action="ModificaAccountStudenteServlet">
								<button type="submit" class="list-group-item" >Modifica</button>
								<input type="hidden" value="<%=studente.getMatricolaStudente()%>" id="matricolaStudenteModifica" name="matricolaStudenteModifica"/>
							</form>
						</td>
						<td>
							<form name="eliminazioneAccountStudenteForm" action="EliminazioneAccountStudenteServlet" onsubmit="return confirm('Sicuro?');">
								<button type="submit" class="list-group-item" >Elimina</button>
								<input type="hidden" value="<%=studente.getMatricolaStudente()%>" id="matricolaStudenteEliminazione" name="matricolaStudenteEliminazione"/>
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
		<%}%>			
			<!-- </DATI NEL PANEL> -->
		<jsp:include page="BaseSitoInferiore.jsp" />
	</body>
</html>