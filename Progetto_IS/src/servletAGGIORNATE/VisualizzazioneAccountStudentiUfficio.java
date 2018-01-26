package servletAGGIORNATE;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.UfficioDCS;

/**
 * Servlet implementation class VisualizzazioneAccountStudentiUfficio
 */
@WebServlet("/VisualizzazioneAccountStudentiUfficio")
public class VisualizzazioneAccountStudentiUfficio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzazioneAccountStudentiUfficio() {
        super();
        }
        
        HttpSession session=null;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        	session = request.getSession(true);

        	try {
        		session.setAttribute("listaProgettiFormativi", UfficioDCS.caricaProgettiFormativi());
    		} catch (ClassNotFoundException | SQLException e) {
    			e.printStackTrace();
    		}
        	
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doGet(request, response);
    	}
}