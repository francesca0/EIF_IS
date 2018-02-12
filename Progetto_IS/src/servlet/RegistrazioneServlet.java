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
	String pagina="ErrorPage.jsp";
	
    public RegistrazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

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
				String key="";
				Object obj= null;
				
				//controllo che non esista gia' lo studente
				try {
					key = StudenteDCS.getKeyByEmail(email);
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();		
				} 	

				if(key!=null) { 
					session.setAttribute("messaggioErrore", "Lo studente è già registrato!");
					System.out.println("Lo studente è già registrato!!!");
				}
				else{
					//controllo se esiste il tutor accademico
					try {
						obj =	TutorAccademicoDCS.loadByMatricola(matricolaTutorAccademico);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					if(obj==null) { 
						session.setAttribute("messaggioErrore", "Il tutor accademico inserito non è presente nel database!");
						pagina="ErrorPage.jsp";
					}
					else{ //se va tutto bene
						
						try {
						
							Studente nuovoStudente = new Studente(matricolaStudente, nome, cognome, dataDiNascita, luogoDiNascita, residenza, telefono, matricolaTutorAccademico, email, password, 4);

							nuovoStudente.inserisciDatiSuDB();
							pagina="login.jsp";
						} catch (Exception e) {
							e.printStackTrace();
						}
				
						
					}	
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
	}

}
