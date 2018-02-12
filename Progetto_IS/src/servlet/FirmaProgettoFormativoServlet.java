package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.DirettoreDipartimentoDCS;
import dcs.PresidenteConsiglioDidatticoDCS;
import dcs.TutorAccademicoDCS;
import dcs.TutorAziendaleDCS;

@WebServlet("/FirmaProgettoFormativoServlet")
public class FirmaProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
    
    public FirmaProgettoFormativoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(true);
		String pagina="homePage.jsp";		
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		String key = (String) session.getAttribute("key");
		int idProgettoFormativo = Integer.parseInt(request.getParameter("idProgettoFormativoFirma"));
		
		if(tipoAccount == 2) {
			int idTutorAziendale = Integer.parseInt(key);
			try {
				TutorAziendaleDCS.firmaPF(idProgettoFormativo, idTutorAziendale);
				pagina="VisualizzazioneProgettiFormativiServlet"; //in questo caso richiamiamo la servlet
				session.setAttribute("flagFirma", 1);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Errore nella firma del ProgettoFormativo. idProgettoFormativo-> ["+idProgettoFormativo+" ]");
				e.printStackTrace();
			}	
		}
		else if(tipoAccount == 3) {
			
			String matricolaTutorAccademico = key;
			try {
				TutorAccademicoDCS.firmaPF(idProgettoFormativo, matricolaTutorAccademico);
				pagina="VisualizzazioneProgettiFormativiServlet"; //in questo caso richiamiamo la servlet
				session.setAttribute("flagFirma", 1);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Errore nella firma del ProgettoFormativo. idProgettoFormativo-> ["+idProgettoFormativo+" ]");
				e.printStackTrace();
			}			
		}
		else if(tipoAccount == 6) {
			try {
				PresidenteConsiglioDidatticoDCS.firmaPF(idProgettoFormativo);
				pagina="VisualizzazioneProgettiFormativiServlet"; //in questo caso richiamiamo la servlet
				session.setAttribute("flagFirma", 1);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Errore nella firma del ProgettoFormativo. idProgettoFormativo-> ["+idProgettoFormativo+" ].");
				e.printStackTrace();
			}
		}
		else if(tipoAccount == 7) {
			try {
				DirettoreDipartimentoDCS.firmaPF(idProgettoFormativo);
				pagina="VisualizzazioneProgettiFormativiServlet"; //in questo caso richiamiamo la servlet
				session.setAttribute("flagFirma", 1);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Errore nella firma del ProgettoFormativo. idProgettoFormativo-> ["+idProgettoFormativo+" ]");
				e.printStackTrace();
			}
		}	
		else{//se l'utente non è loggato come un utente che applica firme
			String utente = "[Utente non Loggato]";
			if(tipoAccount==1){utente="Ufficio";}
			else if(tipoAccount==4){utente="Studente";}
			else if(tipoAccount==5){utente="Responsabile Aziendale";}
			
			System.out.println("Utente loggato come ["+utente+"] , Non puo' firmare ");
			session.setAttribute("messaggioErrore", "Utente loggato come ["+utente+"]\n ACCESSO NEGATO");
			pagina = "ErrorPage.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
