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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;

    public LoginServlet() {
    	super();
    }
    					
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException /*aggiungere myexception */{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//doGet(request, response);
		
		String emailForm = request.getParameter("email");					
		String passwordForm = request.getParameter("password");
		String pagina = "index.html";
		session = request.getSession(true);	 //Istanzio la sessione
		RequestDispatcher dispatcher = null;
		int tipoAccount = 0;
		Object obj = null;
		
			try {
				obj = UfficioDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = 1;							//UFFICIO 1
		
		if(obj == null){
			try {
				obj = TutorAziendaleDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//TUTOR AZIENDALE 2
		}
		if(obj == null){
			try {
				obj = TutorAccademicoDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//TUTOR ACCADEMICO 3
		}
		if(obj == null){
			try {
				obj = StudenteDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//STUDENTE 4
		}
		if(obj == null){
			try {
				obj = ResponsabileAziendaleDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//RESPONSABILE AZIENDALE 5
		}
		if(obj == null){
			try {
				obj = PresidenteConsiglioDidatticoDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//PRESIDENTE CONSIGLIO 6
		}
		if(obj == null){
			try {
				obj = DirettoreDipartimentoDCS.loadByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//DIRETTORE DIPARTIMENTO 7
		}
		if(obj == null){
			System.out.println("La mail inserita non è collegata a nessun account!");
		}


		int userLogged =0;
		 
		switch(tipoAccount){
			case 1:{
				Ufficio utente = (Ufficio) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}	
			case 2:{
				TutorAziendale utente = (TutorAziendale) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}	
			case 3:{
				TutorAccademico utente = (TutorAccademico) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}	
			case 4:{
				Studente utente = (Studente) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}	
			case 5:{
				ResponsabileAziendale utente = (ResponsabileAziendale) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}	
			case 6:{
				PresidenteConsiglioDidattico utente = (PresidenteConsiglioDidattico) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}
			
			case 7:{
				DirettoreDipartimento utente = (DirettoreDipartimento) obj;
				if(utente.getPassword().equals(passwordForm)){
					userLogged=1;
					session.setAttribute("utente", utente);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				break;
			}	
				
			case 8:{ 
					System.out.println("La mail inserita non è collegata a nessun account!");
					session.setAttribute("messaggioErrore", "L'account non è registrato!");
					pagina = "ErrorPage.jsp";
					userLogged=2;
				}
				break;
		}
		
		if(userLogged == 1){
			System.out.println("Password Corretta");
			session.setAttribute("logged", true);
			pagina = "homePage.jsp"; /////////////////////////////////////////////////////////////////////////////////////////////////////
		}
		else if (userLogged == 0){
			System.out.println("La password inserita è errata!");
			session.setAttribute("messaggioErrore", "La password inserita è errata!");
			pagina="ErrorPage.jsp";
		}
										
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
