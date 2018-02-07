package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domainClasses.Tirocinio;

@WebServlet("/EliminazioneTirocinioServlet")
public class EliminazioneTirocinioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
    public EliminazioneTirocinioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		session = request.getSession(true);
		String pagina="homePage.jsp";

		//controllo se l'utente è loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		if(tipoAccount == 5){
			
			Tirocinio tirocinio = new Tirocinio();
			tirocinio.setIdTirocinio(Integer.parseInt(request.getParameter("idTirocinioEliminazione")));
			
			try {
				tirocinio.cancellaDatiDaDB();
				pagina="VisualizzazioneTirociniServlet"; //in questo caso richiamiamo la servlet
				session.setAttribute("flagEliminazione", 1);
			} catch (Exception e) {
				System.out.println("Errore nell'eliminazione del tirocinio. idTirocinio-> ["+request.getParameter("idTirocinioEliminazione")+" ]");
				e.printStackTrace();
			}
			
		}
		else{//se l'utente non è loggato come responsabile aziendale
			System.out.println("Non sei loggato come responsabile aziendale!");
			session.setAttribute("messaggioErrore", "Non sei loggato come responsabile aziendale!");
			pagina = "ErrorPage.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
