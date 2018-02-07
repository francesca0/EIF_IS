package servlet;

import java.io.IOException;
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



@WebServlet("/CaricaTirociniAzienda")
public class CaricaTirociniAzienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	RequestDispatcher dispatcher = null;

    public CaricaTirociniAzienda() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
		session = request.getSession(true);
		String pagina = "";

		try {
			listaTirocini = TirocinioDCS.caricaTirociniDaAzienda(Integer.parseInt((request.getParameter("idAzienda"))));
			session.setAttribute("listaTirocini", listaTirocini);
			session.setAttribute("tipoRicerca", "tirocini");
			System.out.println("sono in CaricaTirociniAzienda");
			pagina = "testAzienda.jsp";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
