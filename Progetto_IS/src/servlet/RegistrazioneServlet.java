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
		Date dataDiNascita = null;
		String matricolaStudente= request.getParameter("matricolaStudente");
		String luogoDiNascita= request.getParameter("luogoDiNascita");
		String residenza= request.getParameter("residenza");
		String telefono= request.getParameter("telefono");
		String matricolaTutorAccademico= request.getParameter("matricolaTutorAccademico");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
			
		
				//Controlli
				session = request.getSession(true);
				boolean dateFormatIsCorrect = false;
				boolean emailAlreadyTaken = false;
				boolean matricolaAlreadyTaken = false;
				boolean tutorAccademicoExists = false;
				
				//controllo che la data sia corretta
				System.out.println("DATE->"+request.getParameter("dataDiNascita"));
				dateFormatIsCorrect = ConvertDate.checkValidDate(request.getParameter("dataDiNascita"));
				if(dateFormatIsCorrect){
					dataDiNascita = ConvertDate.convertStringToDate(request.getParameter("dataDiNascita"));
				}
				//controllo che non esista una mail collegata ad uno studente
				try {
					emailAlreadyTaken = StudenteDCS.emailExists(email);
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				}
				
				//controllo che non esista una matricola collegata ad uno studente
				try {
					matricolaAlreadyTaken = StudenteDCS.matricolaExists(matricolaStudente);
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				}
					
				//controllo che il tutor accademico esista
				try {
					tutorAccademicoExists = TutorAccademicoDCS.exists(matricolaTutorAccademico);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				//valuto i risultati
				if(!dateFormatIsCorrect) {  //controlla se la data ha un formato errato
					session.setAttribute("messaggioErrore", "La data inserita non è valida!");
					System.out.println("La data inserita non è valida!");
					pagina="ErrorPage.jsp";
				}
				else if(emailAlreadyTaken && matricolaAlreadyTaken) {  //controlla se mail e matricola sono gia' presenti
					session.setAttribute("messaggioErrore", "Sia la email che la matricola sono già presenti nel database!");
					System.out.println("Sia la email che la matricola sono già presenti nel database!");
					pagina="ErrorPage.jsp";
				}
				else if(emailAlreadyTaken) {  //controlla se la mail esiste gia'
					session.setAttribute("messaggioErrore", "Lo studente è già registrato con questa email!");
					System.out.println("Lo studente è già registrato con questa mail!!!");
					pagina="ErrorPage.jsp";
				}
				else if(matricolaAlreadyTaken){	//controlla se la matricola esiste gia'
					session.setAttribute("messaggioErrore", "Lo studente è già registrato con questa matricola!");
					System.out.println("Uno studente è già registrato con questa matricola!!!");
					pagina="ErrorPage.jsp";
				}
				else if(!tutorAccademicoExists) { //controlla se il tutor accademico non esiste
						session.setAttribute("messaggioErrore", "Il tutor accademico inserito non è presente nel database!");
						System.out.println("Il tutor accademico inserito non è presente nel database!");
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
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
				dispatcher.forward(request, response);
	}
}
