package servletAGGIORNATE;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dcs.UfficioDCS;

@WebServlet("/ConfermaProgettoFormativoUfficioServlet")
public class ConfermaProgettoFormativoUfficioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
       
    public ConfermaProgettoFormativoUfficioServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			UfficioDCS.confermaPf(request.getParameter("idProgettoFormativo"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
