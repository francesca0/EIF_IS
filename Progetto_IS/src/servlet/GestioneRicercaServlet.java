package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.AziendaDCS;
import dcs.TirocinioDCS;
import domainClasses.Azienda;
import domainClasses.Tirocinio;
import utility.ConvertDate;


@WebServlet("/GestioneRicercaServlet")
public class GestioneRicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HttpSession session = null;
	RequestDispatcher dispatcher = null;
	String pagina="ErrorPage.jsp";
	
    public GestioneRicercaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		session = request.getSession(true);
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		
	if(tipoAccount==4){//visualizzazione concessa solo agli studenti
		
		if((request.getParameter("tipoRicerca"))!=null){	
				String tipoRicerca=(String) request.getParameter("tipoRicerca");
				System.out.println(tipoRicerca);
				session = request.getSession(true);
				ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
				//RICERCA TIROCINI
				if(tipoRicerca.equals("ricercaTirocini")){
		
					Date dataInizio = ConvertDate.convertStringToDate(request.getParameter("dataInizio"));
					Date dataFine = ConvertDate.convertStringToDate(request.getParameter("dataFine"));
						
					if(!((request.getParameter("dataInizio").equals(""))) && !(request.getParameter("dataFine").equals(""))) { //campi obbligatori
						try {
							listaTirocini = TirocinioDCS.caricaTirociniRicerca(dataInizio, dataFine);
							session.setAttribute("listaTirocini", listaTirocini);
							session.setAttribute("tipoRicerca", "tirocini");
							pagina = "risultatiRicerca.jsp";
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Parametri insufficienti , non si dovrebbe poter arrivare qui");
					}
				}
				//RICERCA AZIENDE
				else if(tipoRicerca.equals("ricercaAziende")){
					
					String localitaAzienda="";
					if(request.getParameter("localitaAzienda")!=""){
						localitaAzienda = request.getParameter("localitaAzienda");
					}
					String nomeAzienda = "";
					if(request.getParameter("nomeAzienda")!=""){
						nomeAzienda = request.getParameter("nomeAzienda");
					}
		
		
					ArrayList<Azienda> listaAziende = new ArrayList<Azienda>();
		
					if(nomeAzienda.equals("") && localitaAzienda.equals("")){ //se non inserisce niente		
		
						try {
		
							listaAziende = AziendaDCS.loadAll();
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
							pagina = "risultatiRicerca.jsp";
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else if((!(nomeAzienda.equals(""))) && (!(localitaAzienda.equals("")))){ //se ci sono entrambi	
						try {
		
							listaAziende = AziendaDCS.caricaAziendeDaNomeELocalita(nomeAzienda, localitaAzienda);
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
							pagina = "risultatiRicerca.jsp";
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}		
					else if(!(localitaAzienda.equals(""))) {				// solo localita
						try {
		
							listaAziende = AziendaDCS.caricaAziendeDaLocalita(localitaAzienda);
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
							pagina = "risultatiRicerca.jsp";
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else if(!(nomeAzienda.equals(""))) {				// solo nome
						try {
		
							listaAziende = AziendaDCS.caricaAziendeDaNome(nomeAzienda);
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
							pagina = "risultatiRicerca.jsp";
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Parametri insufficienti, non dovrebbe essere possibile arrivare qui");
					}
				}
				//CARICA TIROCINI DI AZIENDA
				else if(tipoRicerca.equals("caricaTirociniAzienda")){
					
					if(request.getParameter("idAziendaTirocini")!=null){ // se l'id esiste	
						
						int idAzienda = Integer.parseInt(request.getParameter("idAziendaTirocini"));
						try {
							listaTirocini = TirocinioDCS.caricaTirociniDaAzienda(idAzienda);
							session.setAttribute("listaTirocini", listaTirocini);
							session.setAttribute("tipoRicerca", "tirocini");
							pagina = "risultatiRicerca.jsp";
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else{
						session.setAttribute("messaggioErrore","Non esiste l'idAziendaTirocini per caricare i tirocini dall'idAzienda!");
					}
				}
				//ERRORE SCONOSCIUTO
				else{
					session.setAttribute("messaggioErrore","Errore sconosciuto in GestioneRicercaServlet");
				}
		}
		else{
			session.setAttribute("messaggioErrore","TipoRichiesta è null! Errore nella ricerca");
		}
	}
	else{
		session.setAttribute("messaggioErrore","L'utente non è uno studente! Accesso negato .");
	}
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
