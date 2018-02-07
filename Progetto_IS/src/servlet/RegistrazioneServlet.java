package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.StudenteDCS;
import dcs.TutorAccademicoDCS;
import domainClasses.Studente;
import utility.ConvertDate;


@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
	
    public RegistrazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String pagina="index.html";

	String nome= request.getParameter("nome");
	String cognome= request.getParameter("cognome");
	String matricolaStudente= request.getParameter("matricolaStudente");
	Date dataDiNascita=ConvertDate.convertStringToDate(request.getParameter("dataDiNascita"));
	String luogoDiNascita= request.getParameter("luogoDiNascita");
	String residenza= request.getParameter("residenza");
	String telefono= request.getParameter("telefono");
	String matricolaTutorAccademico= request.getParameter("matricolaTutorAccademico");
	String email= request.getParameter("email");
	String password= request.getParameter("password");
	
		
	//Controlli
	int studenteExists=0;
	int tutorAccademicoExists=0;
	
			//controllo se non esista gia' lo studente
			try {
				Object obj=	StudenteDCS.loadByEmail(email);
				if(!(obj==null)) { 
					studenteExists = 1; 
					session.setAttribute("messaggioErrore", "Lo studente è già registrato!");
					pagina="ErrorPage.jsp";
					System.out.println("Lo studente è già registrato!!!");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();		
			} 	
			
			//controllo se esiste il tutor accademico
			try {
				Object obj=	TutorAccademicoDCS.loadByMatricola(matricolaTutorAccademico);
				if(!(obj==null)) { 
					tutorAccademicoExists = 1; 
					System.out.println("Il tutor è presente nel database");
				}
				else {
					session.setAttribute("messaggioErrore", "Il tutor accademico inserito non è presente nel database!");
					pagina="ErrorPage.jsp";
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//se va tutto bene
			if(studenteExists==0 && tutorAccademicoExists==1) {
				
				try {
					Studente nuovoStudente = new Studente(nome, cognome, matricolaStudente, dataDiNascita, luogoDiNascita, residenza, telefono, matricolaTutorAccademico, email, password, 4);
					nuovoStudente.inserisciDatiSuDB();
					pagina="login.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				
			}
			
		
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
