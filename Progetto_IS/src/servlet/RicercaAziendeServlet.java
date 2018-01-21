package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domainClasses.Azienda;
import dcs.ConnectionManager;

@WebServlet("/RicercaAziendeServlet")
public class RicercaAziendeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
    
    public RicercaAziendeServlet() {
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

    // Metodo doGet per la Ricerca delle Azienda.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomeAzienda = request.getParameter("nomeAzienda");
		String localitaAzienda = request.getParameter("localitaAzienda");
		ArrayList <Azienda> list = new ArrayList<>();
		
		String query = "SELECT * FROM azienda WHERE nomeAzienda='"+nomeAzienda+"' AND localitaAzienda='"+localitaAzienda+"';";
		
		try{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(query) ;
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Azienda azienda = new Azienda();
				azienda.setIdAzienda(rs.getString("idAzienda"));
				azienda.setIndirizzoAzienda(rs.getString("indirizzoAzienda"));
				azienda.setLocalitaAzienda(rs.getString("localitaAzienda"));
				azienda.setNomeAzienda(rs.getString("nomeAzienda"));
				
				list.add(azienda);
			}
			
			for(int i=0; i<list.size(); i++){
				System.out.println(list.get(i).getNomeAzienda());
			}
			
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
