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

import dcs.ConnectionManager;

@WebServlet("/EliminazioneAccountServlet")
public class EliminazioneAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
       
    public EliminazioneAccountServlet(){
        super();
    }
    
    // Il metodo init permette l'inizializzazione della Servlet e la connessione al database.
    
    public void init(ServletConfig config) throws ServletException{
		super.init(config);
		try{
			con = ConnectionManager.getConnection();
		}
		catch(SQLException e){
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    // Metodo doGet per l'Eliminazione degli Account.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String matricolaStudente = request.getParameter("matricolaStudente");
		String query = "DELETE FROM studente WHERE matricolaStudente='"+matricolaStudente+"';";

		try{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.executeUpdate(query);
			
			// Chiudiamo la connessione e distruggiamo la servlet.
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}

}
