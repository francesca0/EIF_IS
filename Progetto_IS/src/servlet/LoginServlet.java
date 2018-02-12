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
    					
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailForm = request.getParameter("email");					
		String passwordForm = request.getParameter("password");
		String pagina = "ErrorPage.jsp";
		session = request.getSession(true);	 //Istanzio la sessione
		RequestDispatcher dispatcher = null;
		int tipoAccount = 0;
		String key = null;
		
			try {
				key = UfficioDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = 1;							//UFFICIO 1
		
		if(key == null){
			try {
				key = TutorAziendaleDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//TUTOR AZIENDALE 2
		}
		if(key == null){
			try {
				key = TutorAccademicoDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//TUTOR ACCADEMICO 3
		}
		if(key == null){
			try {
				key = StudenteDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//STUDENTE 4
		}
		if(key == null){
			try {
				key = ResponsabileAziendaleDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//RESPONSABILE AZIENDALE 5
		}
		if(key == null){
			try {
				key = PresidenteConsiglioDidatticoDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//PRESIDENTE CONSIGLIO 6
		}
		if(key == null){
			try {
				key = DirettoreDipartimentoDCS.getKeyByEmail(emailForm);
			} catch (ClassNotFoundException | SQLException e) {
				 
				e.printStackTrace();
			}
			tipoAccount = tipoAccount + 1;				//DIRETTORE DIPARTIMENTO 7
		}
			
		//se va oltre tipoaccount diventa 8 e viene notato dallo switch
		 
		switch(tipoAccount){
			case 1:{
				Ufficio ufficio = new Ufficio();
				ufficio.setIdUfficio(key);
				try {
					ufficio.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(ufficio.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}	
			case 2:{
				TutorAziendale tutorAziendale = new TutorAziendale();
				tutorAziendale.setIdTutorAziendale(Integer.parseInt(key));
				try {
					tutorAziendale.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(tutorAziendale.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}	
			case 3:{
				TutorAccademico tutorAccademico = new TutorAccademico();
				tutorAccademico.setMatricolaTutorAccademico(key);
				try {
					tutorAccademico.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(tutorAccademico.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}	
			case 4:{
				Studente studente = new Studente();
				studente.setMatricolaStudente(key);
				try {
					studente.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(studente.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}	
			case 5:{
				ResponsabileAziendale responsabileAziendale = new ResponsabileAziendale();
				responsabileAziendale.setIdResponsabileAziendale(Integer.parseInt(key));
				try {
					responsabileAziendale.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(responsabileAziendale.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}	
			case 6:{
				PresidenteConsiglioDidattico presidenteConsiglioDidattico = new PresidenteConsiglioDidattico();
				presidenteConsiglioDidattico.setIdPresidenteConsiglioDidattico(key);
				try {
					presidenteConsiglioDidattico.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(presidenteConsiglioDidattico.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}
			
			case 7:{
				DirettoreDipartimento direttoreDipartimento = new DirettoreDipartimento();
				direttoreDipartimento.setIdDirettoreDipartimento(key);
				try {
					direttoreDipartimento.leggiDatiDaDB();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(direttoreDipartimento.getPassword().equals(passwordForm)){
					session.setAttribute("key", key);
					session.setAttribute("tipoAccount", tipoAccount);
				}
				else{
					System.out.println("La password inserita è errata!");
					session.setAttribute("messaggioErrore", "La password inserita è errata!");
				}
				break;
			}	
				
			case 8:{ 
					System.out.println("La mail inserita non è collegata a nessun account!");
					session.setAttribute("messaggioErrore", "L'account non è registrato!");
				}
				break;
		}
		
		if(tipoAccount>0 && tipoAccount<8){
			System.out.println("Password Corretta");
			pagina = "homePage.jsp";
		}
										
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
