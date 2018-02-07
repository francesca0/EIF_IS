package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.TirocinioDCS;
import domainClasses.Tirocinio;
import utility.ConvertDate;


@WebServlet("/RicercaTirociniServlet")
public class RicercaTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	RequestDispatcher dispatcher = null;

    public RicercaTirociniServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Date dataInizio = ConvertDate.convertStringToDate(request.getParameter("dataInizio"));
		Date dataFine = ConvertDate.convertStringToDate(request.getParameter("dataFine"));
		ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
		session = request.getSession(true);
		String pagina = "index.html";
				
		if(!((request.getParameter("dataInizio").equals(""))) && !(request.getParameter("dataFine").equals(""))) { //campi obbligatori
			try {
				listaTirocini = TirocinioDCS.caricaTirociniRicerca(dataInizio, dataFine);
				session.setAttribute("listaTirocini", listaTirocini);
				session.setAttribute("tipoRicerca", "tirocini");
				pagina = "risultatiRicerca.jsp";
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Parametri insufficienti , non si dovrebbe poter arrivare qui");
		}
				
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
