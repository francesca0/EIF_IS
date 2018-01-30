package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.DirettoreDipartimentoDCS;
import dcs.PresidenteConsiglioDidatticoDCS;
import dcs.TutorAccademicoDCS;
import dcs.TutorAziendaleDCS;
import domainClasses.TutorAccademico;
import domainClasses.TutorAziendale;

@WebServlet("/FirmaProgettoFormativoServlet")
public class FirmaProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
    
    public FirmaProgettoFormativoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(true);
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		int idProgettoFormativo = Integer.parseInt(request.getParameter("idProgettoFormativo"));
		
		if(tipoAccount == 2) {
			TutorAziendale tutorAziendale = new TutorAziendale();
			tutorAziendale = (TutorAziendale) session.getAttribute("utente");
			int idTutorAziendale = tutorAziendale.getIdTutorAziendale();
			try {
				TutorAziendaleDCS.firmaPF(idProgettoFormativo, idTutorAziendale);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}		
		}
		else if(tipoAccount == 3) {
			TutorAccademico tutorAccademico = new TutorAccademico();
			tutorAccademico = (TutorAccademico) session.getAttribute("utente");
			String matricolaTutorAccademico = tutorAccademico.getMatricolaTutorAccademico();
			try {
				TutorAccademicoDCS.firmaPF(idProgettoFormativo, matricolaTutorAccademico);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}				
		}
		else if(tipoAccount == 6) {
			try {
				PresidenteConsiglioDidatticoDCS.firmaPF(idProgettoFormativo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else if(tipoAccount == 7) {
			try {
				DirettoreDipartimentoDCS.firmaPF(idProgettoFormativo);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
