package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domainClasses.ResponsabileAziendale;
import domainClasses.Tirocinio;
import utility.ConvertStringToDate;

@WebServlet("/InserimentoTirociniServlet")
public class InserimentoTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session = null;  
	
    public InserimentoTirociniServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Tirocinio tirocinio = new Tirocinio();
		session = request.getSession(true);
		
		ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
		int idResponsabileAziendale = responsabileAziendale.getIdResponsabileAziendale();
		
		tirocinio.setIdTirocinio(Integer.parseInt(request.getParameter("idTirocinio")));
		tirocinio.setIdResponsabileAziendale(idResponsabileAziendale);
		tirocinio.setIdTutorAziendale(Integer.parseInt((request.getParameter("idTutorAziendale"))));
		tirocinio.setDescrizione(request.getParameter("descrizione"));
		tirocinio.setTematica(request.getParameter("tematica"));
		tirocinio.setNote(request.getParameter("note"));
		tirocinio.setDataInizio(ConvertStringToDate.convert(request.getParameter("dataInizio")));
		tirocinio.setDataFine(ConvertStringToDate.convert(request.getParameter("dataFine")));
		
		
		try {
			tirocinio.inserisciDatiSuDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
