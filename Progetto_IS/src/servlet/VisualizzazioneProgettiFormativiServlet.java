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
import dcs.ResponsabileAziendaleDCS;
import dcs.TutorAccademicoDCS;
import dcs.TutorAziendaleDCS;
import dcs.UfficioDCS;
import domainClasses.ResponsabileAziendale;
import domainClasses.TutorAccademico;
import domainClasses.TutorAziendale;

/**
 * Servlet implementation class VisualizzazioneProgettiFormativiUfficio
 */
@WebServlet("/VisualizzazioneProgettiFormativiServlet")
public class VisualizzazioneProgettiFormativiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
	RequestDispatcher dispatcher = null;
	String pagina = "";
	
    public VisualizzazioneProgettiFormativiServlet() {
        super();
    }
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	pagina="homePage.jsp";
    	session = request.getSession(true);
    	int tipoAccount = (int) session.getAttribute("tipoAccount");
    	
    	if(tipoAccount == 1) {
	    	try {
	    		session.setAttribute("listaProgettiFormativiRicevuti", UfficioDCS.caricaProgettiFormativi());
	    		pagina="visualizzazioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 2) {
    		try {
    			TutorAziendale tutorAziendale = (TutorAziendale) session.getAttribute("utente");
    			int idTutorAziendale= tutorAziendale.getIdTutorAziendale();
	    		session.setAttribute("listaProgettiFormativiRicevuti", TutorAziendaleDCS.caricaProgettiFormativi(idTutorAziendale) );
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 3) {
    		try {
    			TutorAccademico tutorAccademico = (TutorAccademico) session.getAttribute("utente");
    			String matricolaTutorAccademico= tutorAccademico.getMatricolaTutorAccademico();
	    		session.setAttribute("listaProgettiFormativiRicevuti", TutorAccademicoDCS.caricaProgettiFormativi(matricolaTutorAccademico));
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 4) {
    		
    		System.out.println("Errore sconosciuto , lo studente non dovrebbe mai richiamare VisualizzazioneProgettiFormativiServlet");
    		session.setAttribute("messaggioErrore", "Errore sconosciuto , lo studente non dovrebbe mai richiamare VisualizzazioneProgettiFormativiServlet");
    		pagina="ErrorPage.jsp";
    	}
    	else if(tipoAccount == 5) {
    		try {
    			ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
    			int idResponsabileAziendale= responsabileAziendale.getIdResponsabileAziendale();
	    		session.setAttribute("listaProgettiFormativiRicevuti", ResponsabileAziendaleDCS.caricaProgettiFormativi(idResponsabileAziendale));
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 6) {
    		try {
	    		session.setAttribute("listaProgettiFormativiRicevuti", PresidenteConsiglioDidatticoDCS.caricaProgettiFormativi());
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 7) {
    		try {
	    		session.setAttribute("listaProgettiFormativiRicevuti", DirettoreDipartimentoDCS.caricaProgettiFormativi());
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else {
    		System.out.println("Errore Sconosciuto in VisualizzazioneProgettiFormativiServlet!");
			session.setAttribute("messaggioErrore", "Errore Sconosciuto in VisualizzazioneProgettiFormativiServlet!");
    		pagina="ErrorPage.jsp";
    	}
    	
    	dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
