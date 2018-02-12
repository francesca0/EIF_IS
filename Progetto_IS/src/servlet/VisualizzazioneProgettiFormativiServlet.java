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

/**
 * Servlet implementation class VisualizzazioneProgettiFormativiUfficio
 */
@WebServlet("/VisualizzazioneProgettiFormativiServlet")
public class VisualizzazioneProgettiFormativiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
	RequestDispatcher dispatcher = null;
	String pagina = "ErrorPage.jsp";
	
    public VisualizzazioneProgettiFormativiServlet() {
        super();
    }
   

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	session = request.getSession(true);
    	int tipoAccount = (int) session.getAttribute("tipoAccount");
    	String key = (String) session.getAttribute("key");
    	
    	if((tipoAccount == 1) &&(key.equals("ufficio"))){
	    	try {
	    		session.setAttribute("listaProgettiFormativiRicevuti", UfficioDCS.caricaProgettiFormativi());
	    		pagina="visualizzazioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 2) {
    		try {
    			int idTutorAziendale= Integer.parseInt(key);
	    		session.setAttribute("listaProgettiFormativiRicevuti", TutorAziendaleDCS.caricaProgettiFormativi(idTutorAziendale) );
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 3) {
    		try {
    			String matricolaTutorAccademico= key;
	    		session.setAttribute("listaProgettiFormativiRicevuti", TutorAccademicoDCS.caricaProgettiFormativi(matricolaTutorAccademico));
	    		pagina="visualizzazioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 4) {
    		System.out.println("Errore , lo studente non dovrebbe mai richiamare VisualizzazioneProgettiFormativiServlet");
    		session.setAttribute("messaggioErrore", "ACCESSO NEGATO");
    	}
    	else if(tipoAccount == 5) {
    		try {
    			int idResponsabileAziendale= Integer.parseInt(key);
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
    		System.out.println("Errore , un utente non loggato tenta di accedere a VisualizzazioneProgettiFormativiServlet!");
			session.setAttribute("messaggioErrore", "ACCESSO NEGATO");
    	}
    	
    	dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
