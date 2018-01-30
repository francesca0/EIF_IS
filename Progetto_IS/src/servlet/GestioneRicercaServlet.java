package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

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
import utility.ConvertStringToDate;


@WebServlet("/GestioneRicercaServlet")
public class GestioneRicercaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;

    public GestioneRicercaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String localitaAzienda = request.getParameter("localitaAzienda");
		String nomeAzienda = request.getParameter("nomeAzienda");
		Date dataInizio = ConvertStringToDate.convert(request.getParameter("dataInizio"));
		Date dataFine = ConvertStringToDate.convert(request.getParameter("dataFine"));
		ArrayList<Azienda> listaAziende = new ArrayList<Azienda>();
		ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
		session = request.getSession(true);

		switch(request.getParameter("richiesta")) { 
		/* passiamo un parametro richiesta che rappresenta se si vuole eseguire una ricerca per aziende,
		 *  per tirocini oppure se si clicca su di un'azienda ricercata e si vogliono caricare i suoi tirocini 
		 */
			case "ricercaAziende":{
					if(!(nomeAzienda.equals("")) && !(localitaAzienda.equals(""))){ //se ci sono entrambi			
						try {
							listaAziende = AziendaDCS.caricaAziendeDaNomeELocalita(nomeAzienda, localitaAzienda);
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					
					else if(!(localitaAzienda.equals(""))) {				// solo localita
						try {
							listaAziende = AziendaDCS.caricaAziendeDaLocalita(localitaAzienda);
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else if(!(nomeAzienda.equals(""))) {				// solo nome
						try {
							listaAziende = AziendaDCS.caricaAziendeDaNome(nomeAzienda);
							session.setAttribute("listaAziende", listaAziende);
							session.setAttribute("tipoRicerca", "aziende");
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Parametri insufficienti");
					}
			break;
			}
			case "ricercaTirocini": {
				if(!((request.getParameter("dataInizio").equals(""))) && !(request.getParameter("dataFine").equals(""))) { // solo date
						try {
							listaTirocini = TirocinioDCS.caricaTirociniRicerca(dataInizio, dataFine);
							session.setAttribute("listaTirocini", listaTirocini);
							session.setAttribute("tipoRicerca", "tirocini");
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Parametri insufficienti");
					}
			break;
			}
			case "caricaTirociniAzienda":{
				try {
					listaTirocini = TirocinioDCS.caricaTirociniDaAzienda(Integer.parseInt((request.getParameter("idAzienda"))));
					session.setAttribute("listaTirocini", listaTirocini);
					session.setAttribute("tipoRicerca", "tirocini");
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			
			}
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
