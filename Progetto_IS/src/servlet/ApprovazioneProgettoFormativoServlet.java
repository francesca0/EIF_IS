package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.ResponsabileAziendaleDCS;
import domainClasses.ResponsabileAziendale;

@WebServlet("/ApprovazioneProgettoFormativoServlet")
public class ApprovazioneProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session = null;   
 
    public ApprovazioneProgettoFormativoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		session = request.getSession(true);
		ResponsabileAziendale responsabileAziendale = (ResponsabileAziendale) session.getAttribute("utente");
		
		int idResponsabileAziendale= responsabileAziendale.getIdResponsabileAziendale();
		int idProgettoFormativo = Integer.parseInt(request.getParameter("idProgettoFormativo"));
		
		try {
			ResponsabileAziendaleDCS.approvaPF(idProgettoFormativo, idResponsabileAziendale);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
