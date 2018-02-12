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

import dcs.ResponsabileAziendaleDCS;
import domainClasses.Tirocinio;

/* import usati per lo studente , nel caso ne necessitassimo
import dcs.TirocinioDCS;
import java.sql.Date;
import utility.ConvertStringToDate;
*/

@WebServlet("/VisualizzazioneTirociniServlet")
public class VisualizzazioneTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	String pagina="ErrorPage.jsp";
	
    public VisualizzazioneTirociniServlet() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(true);
		
		//controllo se l'utente è loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		String key = (String) session.getAttribute("key");
		
		if(tipoAccount == 5){
			
			int idResponsabileAziendale = Integer.parseInt(key);
			
				try {
					ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();
					list = ResponsabileAziendaleDCS.caricaTirocini(idResponsabileAziendale);
					session.setAttribute("listaTirocini", list);
					pagina="gestioneTirocini.jsp";
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}	
		}
		else{//se l'utente non è loggato come responsabile aziendale
			System.out.println("Utente non loggato come Responsabile Aziendale!");
			session.setAttribute("messaggioErrore", "ACCESSO NEGATO");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
