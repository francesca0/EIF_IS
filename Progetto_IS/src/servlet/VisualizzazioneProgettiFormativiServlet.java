package servlet;

import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/VisualizzazioneProgettiFormativiUfficio")
public class VisualizzazioneProgettiFormativiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualizzazioneProgettiFormativiServlet() {
        super();
    }
    
    HttpSession session=null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	//if(!(session.getAttribute("listaProgettiFormativi") == null)) {
    		//devo fare un controllo per vedere se i progetti sono stati modificati <<<<<<<
    //	}
    	session = request.getSession(true);
    	int tipoAccount = (int) session.getAttribute("tipoAccount");
    	
    	if(tipoAccount == 1) {
	    	try {
	    		session.setAttribute("listaProgettiFormativi", UfficioDCS.caricaProgettiFormativi());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 2) {
    		try {
    			TutorAziendale tutorAziendale = (TutorAziendale) session.getAttribute("utente");
    			int idTutorAziendale= tutorAziendale.getIdTutorAziendale();
	    		session.setAttribute("listaProgettiFormativi", TutorAziendaleDCS.caricaProgettiFormativi(idTutorAziendale) );
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 3) {
    		try {
    			TutorAccademico tutorAccademico = (TutorAccademico) session.getAttribute("utente");
    			String matricolaTutorAccademico= tutorAccademico.getMatricolaTutorAccademico();
	    		session.setAttribute("listaProgettiFormativi", TutorAccademicoDCS.caricaProgettiFormativi(matricolaTutorAccademico));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 4) {
    		System.out.println("Errore sconosciuto , lo studente non dovrebbe mai richiamare VisualizzazioneProgettiFormativiServlet");
    	}
    	else if(tipoAccount == 5) {
    		try {
    			ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
    			int idResponsabileAziendale= responsabileAziendale.getIdResponsabileAziendale();
	    		session.setAttribute("listaProgettiFormativi", ResponsabileAziendaleDCS.caricaProgettiFormativi(idResponsabileAziendale));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 6) {
    		try {
	    		session.setAttribute("listaProgettiFormativi", PresidenteConsiglioDidatticoDCS.caricaProgettiFormativi());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 7) {
    		try {
	    		session.setAttribute("listaProgettiFormativi", DirettoreDipartimentoDCS.caricaProgettiFormativi());
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else {
    		//errore sconosciuto, non si dovrebbe poter entrare qui.
    	}
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
