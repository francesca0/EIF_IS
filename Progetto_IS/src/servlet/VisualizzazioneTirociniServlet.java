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

import dcs.ResponsabileAziendaleDCS;
import dcs.TirocinioDCS;
import domainClasses.ResponsabileAziendale;
import domainClasses.Tirocinio;
import utility.ConvertDate;

/* import usati per lo studente , nel caso ne necessitassimo
import dcs.TirocinioDCS;
import java.sql.Date;
import utility.ConvertStringToDate;
*/

@WebServlet("/VisualizzazioneTirociniServlet")
public class VisualizzazioneTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	 
    public VisualizzazioneTirociniServlet() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(true);
		String pagina="homePage.jsp";

		//controllo se l'utente è loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		if(tipoAccount == 5){
			
			ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
			int idResponsabileAziendale = responsabileAziendale.getIdResponsabileAziendale();
			
				try {
					ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
					list = ResponsabileAziendaleDCS.caricaTirocini(idResponsabileAziendale);
					session.setAttribute("listaTirocini", list);
					pagina="gestioneTirocini.jsp";
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}	
				
			
			
			if(tipoAccount == 4){	
				ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
				Date dataInizio = ConvertDate.convertStringToDate(request.getParameter("dataInizio"));
				Date dataFine = ConvertDate.convertStringToDate(request.getParameter("dataFine"));
					
				try {
					list = TirocinioDCS.caricaTirociniRicerca(dataInizio, dataFine);
					session.setAttribute("listaTirocini", list);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		else{//se l'utente non è loggato come responsabile aziendale
			System.out.println("Non sei loggato come responsabile aziendale!");
			session.setAttribute("messaggioErrore", "Non sei loggato come responsabile aziendale!");
			pagina = "ErrorPage.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
