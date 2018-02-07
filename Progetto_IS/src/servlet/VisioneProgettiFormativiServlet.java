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

import dcs.DirettoreDipartimentoDCS;
import dcs.PresidenteConsiglioDidatticoDCS;
import dcs.ResponsabileAziendaleDCS;
import dcs.StudenteDCS;
import dcs.TutorAccademicoDCS;
import dcs.TutorAziendaleDCS;
import dcs.UfficioDCS;
import domainClasses.ProgettoFormativo;
import domainClasses.ResponsabileAziendale;
import domainClasses.Studente;
import domainClasses.TutorAccademico;
import domainClasses.TutorAziendale;

@WebServlet("/VisioneProgettiFormativiServlet")
public class VisioneProgettiFormativiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session=null;
	RequestDispatcher dispatcher = null;
	String pagina = "";
	
    public VisioneProgettiFormativiServlet() {
        super();
    }
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	pagina="homePage.jsp";
    	session = request.getSession(true);
    	int tipoAccount = (int) session.getAttribute("tipoAccount");
    	
    	if(tipoAccount == 1) {
	    	try {
	    		session.setAttribute("listaProgettiFormativiCompletati", UfficioDCS.caricaProgettiFormativiCompletati());
	    		pagina="visioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 2) {
    		try {
    			TutorAziendale tutorAziendale = (TutorAziendale) session.getAttribute("utente");
    			int idTutorAziendale= tutorAziendale.getIdTutorAziendale();
    			ArrayList<ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
				list = (ArrayList<ProgettoFormativo>)  TutorAziendaleDCS.caricaProgettiFormativiFirmati(idTutorAziendale);
	    		session.setAttribute("listaProgettiFormativiCompletati",list);
	    		
	    		pagina="visioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 3) {
    		try {
    			TutorAccademico tutorAccademico = (TutorAccademico) session.getAttribute("utente");
    			String matricolaTutorAccademico= tutorAccademico.getMatricolaTutorAccademico();
	    		session.setAttribute("listaProgettiFormativiCompletati", TutorAccademicoDCS.caricaProgettiFormativiFirmati(matricolaTutorAccademico));
	    		pagina="visioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 4) {
    		try {
    		Studente studente = (Studente) session.getAttribute("utente");
    		String matricolaStudente= studente.getMatricolaStudente();
    		session.setAttribute("progettoFormativoStudente",StudenteDCS.caricaProgettoFormativo(matricolaStudente));
    		pagina="visioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    		
    	}
    	else if(tipoAccount == 5) {
    		try {
    			ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
    			int idResponsabileAziendale= responsabileAziendale.getIdResponsabileAziendale();
	    		session.setAttribute("listaProgettiFormativiCompletati", ResponsabileAziendaleDCS.caricaProgettiFormativiApprovati(idResponsabileAziendale));
	    		pagina="visioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 6) {
    		try {
	    		session.setAttribute("listaProgettiFormativiCompletati", PresidenteConsiglioDidatticoDCS.caricaProgettiFormativiFirmati());
	    		pagina="visioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 7) {
    		try {
	    		session.setAttribute("listaProgettiFormativiCompletati", DirettoreDipartimentoDCS.caricaProgettiFormativiFirmati());
	    		pagina="visioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else {
    		System.out.println("Errore Sconosciuto in VisioneProgettiFormativiServlet!");
			session.setAttribute("messaggioErrore", "Errore Sconosciuto in VisioneProgettiFormativiServlet!");
    		pagina="ErrorPage.jsp";
    	}
    	
    	dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
