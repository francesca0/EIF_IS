package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domainClasses.Studente;
import utility.ConvertDate;

@WebServlet("/ModificaAccountStudenteServlet")
public class ModificaAccountStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
       
    public ModificaAccountStudenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		session = request.getSession(true);
		String pagina="homePage.jsp";

		//controllo se l'utente è loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		String key = (String) session.getAttribute("key");
		if((tipoAccount == 1) &&(key.equals("ufficio"))){
			
			Studente studente = new Studente();
			studente.setMatricolaStudente(request.getParameter("matricolaStudenteModifica"));
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
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if(!nome.equals("")){
				studente.setNome(nome);
			}
			if(!cognome.equals("")){
				studente.setCognome(cognome);
			}
	
			if(!(request.getParameter("dataDiNascita")).equals("")){
				Date dataDiNascita = ConvertDate.convertStringToDate(request.getParameter("dataDiNascita"));
				studente.setDataDiNascita(dataDiNascita);
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
			
			try {
				studente.aggiornaDatiSuDB();
				session.setAttribute("flagModificaStudente", 1 );
				pagina="VisualizzazioneAccountStudentiServlet"; //in questo caso rimandiamo alla servlet
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{//se l'utente non è loggato come ufficio
			System.out.println("Non sei loggato come Ufficio!");
			session.setAttribute("messaggioErrore", "Non sei loggato come Ufficio!");
			pagina = "ErrorPage.jsp";
		}
	
	RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
	dispatcher.forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
