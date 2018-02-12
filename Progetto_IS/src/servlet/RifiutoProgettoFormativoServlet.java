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

import dcs.ResponsabileAziendaleDCS;

@WebServlet("/RifiutoProgettoFormativoServlet")
public class RifiutoProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session = null;   
	String pagina="ErrorPage.jsp";
	 
	    public RifiutoProgettoFormativoServlet() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			session = request.getSession(true);
			//controllo se l'utente è loggato
			int tipoAccount = (int) session.getAttribute("tipoAccount");
			String key = (String) session.getAttribute("key");
			
			if(tipoAccount == 5){

				int idResponsabileAziendale= Integer.parseInt(key);
				int idProgettoFormativo = Integer.parseInt(request.getParameter("idProgettoFormativoRifiuto"));
				
				try {
					ResponsabileAziendaleDCS.rifiutaPF(idProgettoFormativo, idResponsabileAziendale);
					pagina="VisualizzazioneProgettiFormativiServlet"; //in questo caso richiamiamo la servlet
					session.setAttribute("flagRifiuto", 1);
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println("Errore nel rifiuto del ProgettoFormativo. idProgettoFormativo-> ["+request.getParameter("idProgettoFormativoRifiuto")+" ]");
					e.printStackTrace();
				}
					
			}
			else{//se l'utente non è loggato come responsabile aziendale
				System.out.println("Non sei loggato come responsabile aziendale!");
				session.setAttribute("messaggioErrore", "Non sei loggato come responsabile aziendale!");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}

