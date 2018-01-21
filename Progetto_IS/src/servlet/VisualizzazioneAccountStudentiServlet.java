package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudenteDAO;
import dcs.ConnectionManager;
import domainClasses.Studente;

@WebServlet("/VisualizzaAccountStudentiServlet")
public class VisualizzazioneAccountStudentiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
   
    public VisualizzazioneAccountStudentiServlet() {
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

    // Metodo doGet per la Visualizzazione degli Account degli Studenti.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List <Studente> list = new ArrayList<Studente>();
		String query = "SELECT * from studente";
		
		
		//CAMBIARE
		Studente studente = new Studente();
		//try {
		//	//studente.findAll();
		//} catch (ClassNotFoundException | SQLException e) {
			
		//	e.printStackTrace();
		//}
		
		/*
		try{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Studente studente = new Studente();
				
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setMatricolaStudente(rs.getString("matricolaStudente"));
				studente.setDataDiNascita(rs.getString("dataDiNascita"));
				studente.setLuogoDiNascita(rs.getString("luogoDiNascita"));
				studente.setResidenza(rs.getString("residenza"));
				studente.setTelefono(rs.getString("telefono"));
				studente.setTutorAccademico(rs.getString("tutorAccademico"));
				studente.setEmail(rs.getString("email"));
				studente.setPassword(rs.getString("password"));
				studente.setTipoAccount(rs.getInt("tipoAccount"));

				list.add(studente);	
				
			}
			
			for(int i=0;i<list.size();i++){
			    System.out.println(list.get(i).getCognome());
			} 
			
			destroy();
			
		}catch (Exception e) {
			
		}
		
		*/
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
