package servletAGGIORNATE;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domainClasses.Studente;
import utility.ConvertStringToDate;

/**
 * Servlet implementation class registrazioneServlet
 */
@WebServlet("/registrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegistrazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	String pagina="index.html";

	String nome= request.getParameter("nome");
	String cognome= request.getParameter("cognome");
	String matricolaStudente= request.getParameter("matricolaStudente");
	
	Date dataDiNascita=ConvertStringToDate.convert(request.getParameter("dataDiNascita"));
	
	String luogoDiNascita= request.getParameter("luogoDiNascita");
	String residenza= request.getParameter("residenza");
	String telefono= request.getParameter("telefono");
	String tutorAccademico= request.getParameter("tutorAccademico");
	String email= request.getParameter("email");
	String password= request.getParameter("password");
	String confermapassword = request.getParameter("confermapassword");
	
		if(password.equals(confermapassword)) {
		
			Studente nuovoStudente = new Studente(nome, cognome, matricolaStudente, dataDiNascita, luogoDiNascita, residenza, telefono, tutorAccademico, email, password, 4);
		
			try {
				nuovoStudente.inserisciDatiSuDB();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			pagina="login.jsp";
		}
		else {
			// LA PASSWORD INSERITA NON COINCIDE CON LA CONFERMA < gestire
			pagina="registrazione.jsp";
		}
		
	RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
	dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
