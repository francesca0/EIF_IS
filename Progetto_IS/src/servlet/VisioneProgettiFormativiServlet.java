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

@WebServlet("/VisioneProgettiFormativiServlet")
public class VisioneProgettiFormativiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session=null;
	RequestDispatcher dispatcher = null;
	String pagina = "ErrorPage.jsp";
	
    public VisioneProgettiFormativiServlet() {
        super();
    }
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	pagina="homePage.jsp";
    	session = request.getSession(true);
    	int tipoAccount = (int) session.getAttribute("tipoAccount");
    	String key = (String) session.getAttribute("key");
    	
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
    			int idTutorAziendale= Integer.parseInt(key);
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
    			String matricolaTutorAccademico= key;
	    		session.setAttribute("listaProgettiFormativiCompletati", TutorAccademicoDCS.caricaProgettiFormativiFirmati(matricolaTutorAccademico));
	    		pagina="visioneProgettoFormativo.jsp";
    		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    	}
    	else if(tipoAccount == 4) {
    		try {
    		String matricolaStudente=  key;
    		session.setAttribute("progettoFormativoStudente",StudenteDCS.caricaProgettoFormativo(matricolaStudente));
    		pagina="visioneProgettoFormativo.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
    		
    	}
    	else if(tipoAccount == 5) {
    		try {
    			int idResponsabileAziendale= Integer.parseInt(key);
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
    		System.out.println("Utente non loggato tenta di accedere in VisioneProgettiFormativiServlet!");
			session.setAttribute("messaggioErrore", "ACCESSO NEGATO");
    		pagina="ErrorPage.jsp";
    	}
    	
    	dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
