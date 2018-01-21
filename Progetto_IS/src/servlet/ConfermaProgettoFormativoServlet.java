package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.ConnectionManager;


@WebServlet("/ConfermaProgettoFormativoServlet")
public class ConfermaProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	Connection con = null;
	PreparedStatement ps = null;
	HttpSession session = null;
       
    public ConfermaProgettoFormativoServlet() {
        super();
    }
    
    // Il metodo init permette l'inizializzazione della Servlet e la connessione al database.

    public void init(ServletConfig config) throws ServletException{	
		super.init(config);
		try{
			con = ConnectionManager.getConnection();
			
			System.out.println("init");
		}
		catch(SQLException e){
			e.printStackTrace();
		} 
		
		catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		int tipoAccount = (int) session.getAttribute("tipoAccount");	
		String query = "";
		
		if(tipoAccount == 1){
			query = "UPDATE progetto_formativo SET confermaUst='1' WHERE idProgettoFormativo='"+(String)request.getParameter("idProgettoFormativo")+"'AND approvazioneRa='1' AND firmaTaz='1' AND firmaTac='1' AND (firmaDd='1' OR firmaPcd='1') AND confermaUst='0' AND annullato='0' AND rifiutato='0'";
		}
		
		try{
			ps = con.prepareStatement(query);
			ps.executeQuery();
			
			destroy();
		}catch(Exception e){
			
		}
		
	}
	
	// Il metodo destroy permette la distruzione della Servlet e la chisura della connessione al database.
	
	public void destroy(){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
