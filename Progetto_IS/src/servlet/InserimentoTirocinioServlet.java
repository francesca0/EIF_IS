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

import dcs.TutorAziendaleDCS;
import domainClasses.ResponsabileAziendale;
import domainClasses.Tirocinio;
import utility.ConvertDate;

@WebServlet("/InserimentoTirocinioServlet")
public class InserimentoTirocinioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session = null;  
	
    public InserimentoTirocinioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		session = request.getSession(true);
		String pagina="index.html";

		//controllo se l'utente � loggato
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		if(tipoAccount == 5){
			
			
			ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
			int idResponsabileAziendale = responsabileAziendale.getIdResponsabileAziendale();
			
			Tirocinio tirocinio = new Tirocinio();
			tirocinio.setIdResponsabileAziendale(idResponsabileAziendale);

			int idTutorAziendale = Integer.parseInt((request.getParameter("idTutorAziendale")));
			int tutorAziendaleExists = 0;
			
			//controllo se il tutor aziendale inserito esiste
			try {
				if(TutorAziendaleDCS.loadById(idTutorAziendale)!=null){
					tirocinio.setIdTutorAziendale(idTutorAziendale);
					tutorAziendaleExists=1;
				}
				else{
					System.out.println("Il tutor aziendale inserito non esiste nel database!");
					session.setAttribute("messaggioErrore", "L'Id del tutor aziendale inserito ["+idTutorAziendale+"] non esiste nel database!");
					pagina = "ErrorPage.jsp";
					tutorAziendaleExists=1;
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
				
			if(!(request.getParameter("descrizione")=="")) {
				tirocinio.setDescrizione(request.getParameter("descrizione"));
			}
			
			tirocinio.setTematica(request.getParameter("tematica"));
	
			if(!(request.getParameter("note")=="")) {
				tirocinio.setNote(request.getParameter("note"));
			}
				
			tirocinio.setDataInizio(ConvertDate.convertStringToDate(request.getParameter("dataInizio")));
			tirocinio.setDataFine(ConvertDate.convertStringToDate(request.getParameter("dataFine")));
			tirocinio.setTotaleOre(Integer.parseInt(request.getParameter("totaleOre")));
			tirocinio.setNumeroMesi(Integer.parseInt(request.getParameter("numeroMesi")));
			
			if(tutorAziendaleExists==1){
				try {			
					tirocinio.inserisciDatiSuDB();
					System.out.println(tirocinio.toString());
					session.setAttribute("flagInserimento", 1);
					
					pagina="inserimentoTirocinio.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else{//se l'utente non � loggato come responsabile aziendale
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