package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dcs.ProgettoFormativoDCS;

@WebServlet("/DownloadProgettoFormativoServlet")
public class DownloadProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DownloadProgettoFormativoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ProgettoFormativoDCS.downloadProgettoFormativo();
    	
    	da completare
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
