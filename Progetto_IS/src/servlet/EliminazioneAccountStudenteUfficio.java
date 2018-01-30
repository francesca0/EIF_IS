package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domainClasses.Studente;

@WebServlet("/EliminaAccountStudenteUfficio")
public class EliminazioneAccountStudenteUfficio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminazioneAccountStudenteUfficio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Studente studente= new Studente();
		studente.setMatricolaStudente(request.getParameter("matricolaStudente"));
		
			try {
				studente.cancellaDatiDaDB();
			} catch (Exception e) {
				System.out.println("Errore nell'eliminazione dello studente. Matricola-> ["+request.getParameter("matricolaStudente")+" ]");
				e.printStackTrace();
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
