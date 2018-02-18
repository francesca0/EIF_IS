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

import dcs.TutorAccademicoDCS;
import domainClasses.Studente;
import utility.ConvertDate;

@WebServlet("/ModificaAccountStudenteServlet")
public class ModificaAccountStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	String pagina="ErrorPage.jsp";
       
    public ModificaAccountStudenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		session = request.getSession(true);

		//controllo se l'utente è loggato
		boolean dateFormatIsCorrect = true;
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		String key = (String) session.getAttribute("key");
		if((tipoAccount == 1) &&(key.equals("ufficio"))){
			
			String matricolaStudenteModifica = request.getParameter("matricolaStudente");
			String matricolaStudenteOriginale = request.getParameter("matricolaStudenteOriginale");
			
			Studente studente = new Studente();
			studente.setMatricolaStudente(matricolaStudenteOriginale);
			
			try {
				studente.leggiDatiDaDB();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");		
				
			String luogoDiNascita = request.getParameter("luogoDiNascita");
			String residenza = request.getParameter("residenza");
			String telefono = request.getParameter("telefono");
			String matricolaTutorAccademico = request.getParameter("matricolaTutorAccademico");
			boolean tutorAziendaleExists=false;
			
			if(matricolaTutorAccademico.equals("")){ //nel caso non inserisca nulla
				tutorAziendaleExists = true;
			}
			else{ //nel caso inserisca controlliamo
				try {
					tutorAziendaleExists = TutorAccademicoDCS.exists(matricolaTutorAccademico);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} 
			}
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if(tutorAziendaleExists){
				if(!nome.equals("")){
					studente.setNome(nome);
				}
				if(!cognome.equals("")){
					studente.setCognome(cognome);
				}
		
				if(!(request.getParameter("dataDiNascita")).equals("")){
					if(ConvertDate.checkValidDate(request.getParameter("dataDiNascita"))){
						Date dataDiNascita = ConvertDate.convertStringToDate(request.getParameter("dataDiNascita"));
						studente.setDataDiNascita(dataDiNascita);
					}
					else{
						dateFormatIsCorrect = false;
						System.out.println("La data inserita non è corretta!");
						session.setAttribute("messaggioErrore", "La data inserita non è corretta!");
					}
					
				}
				
				if(!luogoDiNascita.equals("")){
					studente.setLuogoDiNascita(luogoDiNascita);
				}
				if(!residenza.equals("")){
					studente.setResidenza(residenza);
				}
				if(!telefono.equals("")){
					studente.setTelefono(telefono);
				}
				
				if(!matricolaTutorAccademico.equals("")){
					studente.setMatricolaTutorAccademico(matricolaTutorAccademico);
				}
				
				if(!email.equals("")){
					studente.setEmail(email);
				}
				if(!password.equals("")){
					studente.setPassword(password);
				}
				
				if(dateFormatIsCorrect){
					try {
						if(!matricolaStudenteModifica.equals("")){ // se inserisco una matricola studente da modificare inserisce , setta e poi cancella la vecchia
							studente.setMatricolaStudente(matricolaStudenteModifica);
							studente.inserisciDatiSuDB();
							studente.setMatricolaStudente(matricolaStudenteOriginale);
							studente.cancellaDatiDaDB();
						}
						else{
							studente.aggiornaDatiSuDB();
						}
						
						
						session.setAttribute("flagModificaStudente", 1 );
						pagina="VisualizzazioneAccountStudentiServlet"; //in questo caso rimandiamo alla servlet
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else{
				//se il tutor accademico non esiste
				System.out.println("Il tutor accademico inserito non è presente nel database!");
				session.setAttribute("messaggioErrore", "Il tutor accademico inserito non è presente nel database!");
			}
		}
		else{//se l'utente non è loggato come ufficio
			System.out.println("Non sei loggato come Ufficio!");
			session.setAttribute("messaggioErrore", "Non sei loggato come Ufficio!");
		}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
	dispatcher.forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
