package servletAGGIORNATE;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudenteDAO;
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
			StudenteDAO.load(studente);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		try {
			StudenteDAO.delete(studente);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore nella delete");
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
