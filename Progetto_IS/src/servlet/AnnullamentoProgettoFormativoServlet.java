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

import dcs.UfficioDCS;

@WebServlet("/AnnullamentoProgettoFormativoServlet")
public class AnnullamentoProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session = null;
    public AnnullamentoProgettoFormativoServlet() {
        super();
   
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(true);
		String pagina="homePage.jsp";

		//controllo se l'utente è loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		String key = (String) session.getAttribute("key");
		if((tipoAccount == 1) &&(key.equals("ufficio"))){
			
			int idProgettoFormativo = Integer.parseInt(request.getParameter("idProgettoFormativoAnnullamento"));
			
			try {
				UfficioDCS.annullaPf(idProgettoFormativo);
				pagina="VisualizzazioneProgettiFormativiServlet"; //in questo caso richiamiamo la servlet
				session.setAttribute("flagAnnullamento", 1);
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Errore nell' annullamento del ProgettoFormativo. idProgettoFormativo-> ["+idProgettoFormativo+" ]");
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
