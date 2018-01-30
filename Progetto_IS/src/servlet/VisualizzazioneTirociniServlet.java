package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.ResponsabileAziendaleDCS;
import dcs.TirocinioDCS;
import domainClasses.Tirocinio;
import utility.ConvertStringToDate;

@WebServlet("/VisualizzazioneTirociniServlet")
public class VisualizzazioneTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	 
    public VisualizzazioneTirociniServlet() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(true);
				
		int tipoAccount = (int) session.getAttribute("tipoAccount");
		ArrayList<Tirocinio> list = new ArrayList<Tirocinio>();

		if(tipoAccount == 5){	
			try {
				list = ResponsabileAziendaleDCS.caricaTirocini(Integer.parseInt((request.getParameter("idResponsabileAziendale"))));
				session.setAttribute("listaTirocini", list);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}	
		}		
		else if(tipoAccount == 4){	
			Date dataInizio = ConvertStringToDate.convert(request.getParameter("dataInizio"));
			Date dataFine = ConvertStringToDate.convert(request.getParameter("dataFine"));
				
			try {
				list = TirocinioDCS.caricaTirociniRicerca(dataInizio, dataFine);
				session.setAttribute("listaTirocini", list);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Errore sconosciuto, non dovrebbe essere possibile arrivare qui.");
		}
		
		//commento se va messo qualcosa di ritorno 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
