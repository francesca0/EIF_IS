package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dcs.ConnectionManager;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs;
       
    public RegistrazioneServlet(){
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
    
    // Metodo doGet per la Registrazione.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String matricolaStudente = request.getParameter("matricolaStudente");
		String dataDiNascita = request.getParameter("dataDiNascita");
		String luogoDiNascita = request.getParameter("luogoDiNascita");
		String residenza = request.getParameter("residenza");
		String telefono = request.getParameter("telefono");
		String tutorAccademico = request.getParameter("tutorAccademico");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String query = "INSERT INTO studente(nome, cognome, matricolaStudente, dataDiNascita, luogoDiNascita, residenza, telefono, tutorAccademico, email, password, tipoAccount) values(?,?,?,?,?,?,?,?,?,?,4)";
		
		try{
			ps = con.prepareStatement(query);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			ps.setString(3, matricolaStudente);
			ps.setString(4, dataDiNascita);
			ps.setString(5, luogoDiNascita);
			ps.setString(6, residenza);
			ps.setString(7, telefono);
			ps.setString(8, tutorAccademico);
			ps.setString(9, email);
			ps.setString(10, password);
			
			ps.executeUpdate(query);
			
			destroy();
			
		}catch (Exception e){
			
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
