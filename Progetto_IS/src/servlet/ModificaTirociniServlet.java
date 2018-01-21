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

@WebServlet("/ModificaTirociniServlet")
public class ModificaTirociniServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    Connection con = null;
    PreparedStatement ps = null;
   
    public ModificaTirociniServlet(){
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
    
    // Metodo doGet per la Modifica dei Tirocini.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String idTirocinio = request.getParameter("idTirocinio");
		String idResponsabile = request.getParameter("idResponsabile");
		String idTutorAziendale = request.getParameter("idTutorAziendale");
		String descrizione = request.getParameter("descrizione");
		String tematica = request.getParameter("tematica");
		String note = request.getParameter("note");
		String dataInizio = request.getParameter("dataInizio");
		String dataFine = request.getParameter("dataFine");
		
		String query = "UPDATE tirocinio SET idTirocinio=?, idResponsabile=?, idTutorAziendale=?, descrizione=?, tematica=?, note=?, dataInizio=?, dataFine=? ";
		
		try{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, idTirocinio);
			ps.setString(2, idResponsabile);
			ps.setString(3, idTutorAziendale);
			ps.setString(4, descrizione);
			ps.setString(5, tematica);
			ps.setString(6, note);
			ps.setString(7, dataInizio);
			ps.setString(8, dataFine);
			
			ps.executeUpdate();
			
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
