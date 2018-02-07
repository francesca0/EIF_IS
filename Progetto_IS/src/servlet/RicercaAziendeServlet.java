package servlet;

import java.io.IOException;
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
import domainClasses.Azienda;

@WebServlet("/RicercaAziendeServlet")
public class RicercaAziendeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	RequestDispatcher dispatcher = null;

    public RicercaAziendeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String localitaAzienda="";
		if(request.getParameter("localitaAzienda")!=""){
			localitaAzienda = request.getParameter("localitaAzienda");
		}
		String nomeAzienda = "";
		if(request.getParameter("nomeAzienda")!=""){
			nomeAzienda = request.getParameter("nomeAzienda");
		}


		ArrayList<Azienda> listaAziende = new ArrayList<Azienda>();
		session = request.getSession(true);
		String pagina = "ErrorPage.jsp";

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

		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
