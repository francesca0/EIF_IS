package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import domainClasses.Studente;

@WebServlet("/EliminazioneAccountStudenteServlet")
public class EliminazioneAccountStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	
    public EliminazioneAccountStudenteServlet() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(true);
		String pagina="homePage.jsp";

		//controllo se l'utente è loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		if(tipoAccount == 1){
			
			String matricolaStudente = request.getParameter("matricolaStudenteEliminazione");
			
				Studente studente = new Studente();
				studente.setMatricolaStudente(matricolaStudente);
				
				try {
					pagina="VisualizzazioneAccountStudentiServlet"; //in questo caso richiamiamo la servlet
					session.setAttribute("flagEliminazioneStudente", 1);
					studente.cancellaDatiDaDB();
				} catch (Exception e) {
					System.out.println("Errore nell'eliminazione dello studente. MatricolaStudente-> ["+matricolaStudente+" ]");
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
