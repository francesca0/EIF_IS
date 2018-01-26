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

import dcs.ConnectionManager;
import domainClasses.Tirocinio;

@WebServlet("/RicercaTirociniServlet")
public class RicercaTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
 
    public RicercaTirociniServlet() {
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

    // Metodo doGet per la Ricerca dei Tirocini.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Tirocinio> list = new ArrayList<Tirocinio>();
		String dataInizio = request.getParameter("dataInizio");
		String dataFine = request.getParameter("dataFine");	
		String query = "SELECT * FROM tirocinio WHERE dataInizio='"+dataInizio+"' AND dataFine='"+dataFine+"';";
		
		try{	
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Tirocinio tirocinio = new Tirocinio();
				
				tirocinio.setIdTirocinio(rs.getString("idTirocinio"));
				tirocinio.setIdResponsabile(rs.getString("idResponsabile"));
				tirocinio.setIdTutorAziendale(rs.getString("idTutorAziendale"));
				tirocinio.setDescrizione(rs.getString("descrizione"));
				tirocinio.setTematica(rs.getString("tematica"));
				tirocinio.setNote(rs.getString("note"));
				tirocinio.setDataInizio(rs.getDate("dataInizio"));
				tirocinio.setDataFine(rs.getDate("dataFine"));
				
				list.add(tirocinio);
				
			}
			
			for(int i=0; i<list.size(); i++){
				System.out.println(list.get(i).getDataInizio());
			}		
			
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
