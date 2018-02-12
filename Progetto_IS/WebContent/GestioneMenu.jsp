<% int tipoAccount =0;
String key =null;
 if(!(session.getAttribute("tipoAccount")==null)){
  tipoAccount = (int) session.getAttribute("tipoAccount"); 
 }
 if(!(session.getAttribute("key")==null)){
	  key = (String) session.getAttribute("key");
 }
 
 if(tipoAccount==0 || key==null){
 System.out.println("Utente non loggato . Redirect a Login.");%>
  <jsp:forward page="login.jsp"/>
  <%
  }
 else{

 switch( tipoAccount ) {
		
		case 1: { //Ufficio%>
			
	<!-- </header Menu> -->
		Ufficio
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneAccountStudentiForm" action="VisualizzazioneAccountStudentiServlet">
				<button type="submit" class="list-group-item">Visualizza Account Studenti</button>
			</form>
		</li>

		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> 
		Ufficio</span>
	<!-- <Menu Normale> -->
		<form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
        </form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
        </form>
        <form name="visualizzazioneAccountStudentiForm" action="VisualizzazioneAccountStudentiServlet">
        	<button type="submit" class="list-group-item">Visualizza Account Studenti</button>
        </form>
        <form name="logoutForm" action="LogoutServlet">
        	<button type="submit" class="list-group-item">Logout</button>
        </form>
	<!-- </Menu Normale> -->


		<% }break;
		case 2: { //Tutor Aziendale%>
			
	<!-- </header Menu> -->
		Tutor Aziendale
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
			</form>
		</li>
		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> Tutor Aziendale </span>
	<!-- <Menu Normale> -->
        <form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
        </form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
        </form>
        <form name="logoutForm" action="LogoutServlet">
        	<button type="submit" class="list-group-item">Logout</button>
        </form>
	<!-- </Menu Normale> -->

		<% }break;
		case 3: { //Tutor Accademico%>
			
	<!-- </header Menu> -->
		Tutor Accademico
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
			</form>
		</li>
		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> Tutor Accademico </span>
	<!-- <Menu Normale> -->
        <form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
        </form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
        </form>
        <form name="logoutForm" action="LogoutServlet">
        	<button type="submit" class="list-group-item">Logout</button>
        </form>
	<!-- </Menu Normale> -->

		<% }break;
		case 4: {// Studente%>
			
	<!-- </header Menu> -->
		Studente
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form method="get" action="DownloadProgettoFormativoServlet">
				<button type="submit" class="list-group-item">Download Progetto Formativo</button>
				<input type="hidden" value="0512100000" id="matricolaFile" name="matricolaFile"/>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Stato Progetto Formativo</button>
			</form>
		</li>
		<li>
			<form name="ricercaAziendeForm" action="ricercaAziende.jsp">
				<button type="submit" class="list-group-item">Ricerca Azienda</button>
			</form>
		</li>
		<li>
			<form name="ricercaTirociniForm" action="ricercaTirocini.jsp">
				<button type="submit" class="list-group-item">Ricerca Tirocini</button>
			</form>
		</li>
		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> Studente </span>
	<!-- <Menu Normale> -->
		<form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form method="get" action="DownloadProgettoFormativoServlet">
				<button type="submit" class="list-group-item">Download Progetto Formativo</button>
				<input type="hidden" value="0512100000" id="matricolaFile" name="matricolaFile"/>
			</form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
        </form>
        <form name="ricercaAziendaForm" action="ricercaAziende.jsp">
				<button type="submit" class="list-group-item">Ricerca Azienda</button>
		</form>
		<form name="ricercaTirociniForm" action="ricercaTirocini.jsp">
				<button type="submit" class="list-group-item">Ricerca Tirocini</button>
		</form>
        <form name="logoutForm" action="LogoutServlet">
        	<button type="submit" class="list-group-item">Logout</button>
        </form>
	<!-- </Menu Normale> -->
		
		<% }break;
		case 5: {// Responsabile Aziendale%>
			
	<!-- </header Menu> -->
		Responsabile Aziendale
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form name="inserimentoTirocinioForm" action="InserimentoTirocinioServlet">
				<button type="submit" class="list-group-item">Inserisci Tirocinio</button>
			</form>
		</li>
		<li>
			<form name="gestioneTirociniForm" action="VisualizzazioneTirociniServlet">
				<button type="submit" class="list-group-item">Gestione Tirocini</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
			</form>
		</li>
		
		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> Responsabile Aziendale </span>
	<!-- <Menu Normale> -->
        <form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form action="inserimentoTirocinio.jsp">
			<button type="submit" class="list-group-item">Inserisci Tirocinio</button>
		</form>
        <form name="gestioneTirociniForm" action="VisualizzazioneTirociniServlet">
				<button type="submit" class="list-group-item">Gestione Tirocini</button>
		</form>
        <form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
			<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
		</form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
			<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
		</form>
		<form name="logoutForm" action="LogoutServlet">
			<button type="submit" class="list-group-item">Logout</button>
		</form>
	<!-- </Menu Normale> -->
		
		<% }break;
		case 6: {// Presidente Consiglio Didattico%>
			
	<!-- </header Menu> -->
		Presidente Consiglio Didattico
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
			</form>
		</li>
		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> Presidente Consiglio Didattico </span>
	<!-- <Menu Normale> -->
        <form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
        </form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
        </form>
        <form name="logoutForm" action="LogoutServlet">
        	<button type="submit" class="list-group-item">Logout</button>
        </form>
	<!-- </Menu Normale> -->
		
		<% }break;
		case 7: {// Direttore Dipartimento%>
			
	<!-- </header Menu> -->
		Direttore Dipartimento
	<!-- </header Menu> -->
					<!-- HTML  --><span class="caret"></span></button><ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width:100%">
	<!-- </Menu Dropdown> -->
		<li>
			<form action="homePage.jsp">
				<button type="submit" class="list-group-item" >Home</button>
			</form>
		</li>
		<li>
			<form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
			</form>
		</li>
		<li>
			<form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
				<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
			</form>
		</li>
		<li>
			<form name="logoutForm" action="LogoutServlet">
				<button type="submit" class="list-group-item">Logout</button>
			</form>
		</li>
	<!-- </Menu Dropdown> -->
					<!-- HTML  --></ul></div><hr id="menudropdown"><!-- fine menu xs--><!-- MENU SM MD--><div class="list-group" style="border:1px solid;border-radius:4px" id="menulaterale"><span class="list-group-item active" style="text-align:center"> Direttore Dipartimento </span>
	<!-- <Menu Normale> -->
        <form action="homePage.jsp">
			<button type="submit" class="list-group-item" >Home</button>
		</form>
        <form name="visualizzazioneProgettiFormativiForm" action="VisualizzazioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visualizza Progetti Formativi Ricevuti</button>
        </form>
        <form name="visioneProgettiFormativiForm" action="VisioneProgettiFormativiServlet">
        	<button type="submit" class="list-group-item">Visiona Progetti Formativi</button>
        </form>
        <form name="logoutForm" action="LogoutServlet">
        	<button type="submit" class="list-group-item">Logout</button>
        </form>
	<!-- </Menu Normale> -->
		
		<% }break;
		
		default: break;

		}
 }%>
	