package servletAGGIORNATE;

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
import dcs.StudenteDCS;
import dcs.TutorAccademicoDCS;
import dcs.TutorAziendaleDCS;
import dcs.UfficioDCS;
import domainClasses.DirettoreDipartimento;
import domainClasses.PresidenteConsiglioDidattico;
import domainClasses.ResponsabileAziendale;
import domainClasses.Studente;
import domainClasses.TutorAccademico;
import domainClasses.TutorAziendale;
import domainClasses.Ufficio;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;

    public loginServlet() {
    	super();
    }
    					
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException /*aggiungere myexception */{
			
		String emailForm = request.getParameter("email");					
		String passwordForm = request.getParameter("password");
			// TUTTI I COMMENTI MI SERVONO PER ORGANIZZARMI PERSONALMENTE , POI VANNO TOLTI												
		session = request.getSession(true);	 //Istanzio la sessione
		RequestDispatcher dispatcher = null;
		int tipoAccount = 0;
		Object obj = null;
		
			obj = UfficioDCS.loadByEmail(emailForm);
			tipoAccount = 1;							//UFFICIO 1
		
		if(obj == null){
			obj = TutorAziendaleDCS.loadByEmail(emailForm);
			tipoAccount = tipoAccount + 1;				//TUTOR AZIENDALE 2
		}
		if(obj == null){
			obj = TutorAccademicoDCS.loadByEmail(emailForm);
			tipoAccount = tipoAccount + 1;				//TUTOR ACCADEMICO 3
		}
		if(obj == null){
			obj = StudenteDCS.loadByEmail(emailForm);
			tipoAccount = tipoAccount + 1;				//STUDENTE 4
		}
		if(obj == null){
			obj = ResponsabileAziendaleDCS.loadByEmail(emailForm);
			tipoAccount = tipoAccount + 1;				//RESPONSABILE AZIENDALE 5
		}
		if(obj == null){
			obj = PresidenteConsiglioDidatticoDCS.loadByEmail(emailForm);
			tipoAccount = tipoAccount + 1;				//PRESIDENTE CONSIGLIO 6
		}
		if(obj == null){
			obj = DirettoreDipartimentoDCS.loadByEmail(emailForm);
			tipoAccount = tipoAccount + 1;				//DIRETTORE DIPARTIMENTO 7
		}
		if(obj == null){
			System.out.println("ACCOUNT NON REGISTRATO");
			tipoAccount = 0; //mi sentivo piu' sicuro a metterla a zero
			session.setAttribute("logged", false);
			dispatcher = request.getRequestDispatcher("errorPage.jsp"); // QUI RIMANDO ALLA PAGINA DI ERRORE <<< <DA RIVEDEREEEEEEEEEE<<<<
			dispatcher.forward(request, response);
		}
		
		
		switch(tipoAccount){
			case 1:{
				Ufficio utente = (Ufficio) obj;
				break;
			}	
			case 2:{
				TutorAziendale utente = (TutorAziendale) obj;
				break;
			}	
			case 3:{
				TutorAccademico utente = (TutorAccademico) obj;
				break;
			}	
			case 4:{
				Studente utente = (Studente) obj;
				break;
			}	
			case 5:{
				ResponsabileAziendale utente = (ResponsabileAziendale) obj;
				break;
			}	
			case 6:{
				PresidenteConsiglioDidattico utente = (PresidenteConsiglioDidattico) obj;
				break;
			}
			
			case 7:{
				DirettoreDipartimento utente = (DirettoreDipartimento) obj;
				break;
			}	
				
			default: System.out.println("ACCOUNT NON REGISTRATO");
				break;
			
		if(utente.getPassword().equals(passwordForm)){
			session.setAttribute("utente", utente);
			session.setAttribute("tipoAccount", tipoAccount);
			System.out.println("UTENTE LOGGATO CORRETTAMENTE");
		}
		else{
			System.out.println("PASSWORD ERRATA");
		}
		
		}									
		session.setAttribute("logged", true);
		dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
