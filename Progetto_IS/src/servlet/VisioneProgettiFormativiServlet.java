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
import javax.servlet.http.HttpSession;

import dcs.ConnectionManager;
import domainClasses.ResponsabileAziendale;
import domainClasses.TutorAccademico;
import domainClasses.TutorAziendale;
import domainClasses.ProgettoFormativo;
import domainClasses.Studente;

@WebServlet("/VisioneProgettiFormativiServlet")
public class VisioneProgettiFormativiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	HttpSession session = null;
 
    public VisioneProgettiFormativiServlet() {
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

    // Metodo doGet per la Visione dei Progetti Formativi.
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList <ProgettoFormativo> list = new ArrayList<ProgettoFormativo>();
		session = request.getSession(true);
		String query = "";
		
		int tipoAccount = (int) session.getAttribute("tipoAccount"); 
		
		switch (tipoAccount){
		
		// Ufficio Stage e Tirocini.
		case 1: 
			query = "SELECT * FROM progetto_formativo WHERE confermaUst='1'";
			break;
			
		// Tutor Aziendale.
		case 2: 
			query = "SELECT * FROM progetto_formativo WHERE firmaTaz='1' AND idTaz='"+((TutorAziendale)session.getAttribute("utente")).getIdTutorAziendale()+"'";
			break;
			
		// Tutor Accademico.
		case 3: 
			query = "SELECT * FROM progetto_formativo WHERE firmaTac='1' AND idTac='"+((TutorAccademico)session.getAttribute("utente")).getIdTutorAccademico()+"'";
			break;
			
		// Studente.	
		case 4:
			query = "SELECT * FROM progetto_formativo WHERE matricolaStudente='"+((Studente)session.getAttribute("utente")).getMatricolaStudente()+"'";
			break;
			
		// Responsabile Aziendale.
		case 5: 
			query = "SELECT * FROM progetto_formativo WHERE approvazioneRa='1' AND idRa='"+((ResponsabileAziendale)session.getAttribute("utente")).getIdResponsabile()+"'";
			break;
			
		// Presidente del Consiglio Didattico.	
		case 6: 
			query = "SELECT * FROM progetto_formativo WHERE firmaPcd='1'";
			break;
			
		// Direttore di Dipartimento.	
		case 7: 
			query = "SELECT * FROM progetto_formativo WHERE firmaDd='1'";
			break;
		
		default: System.out.println("Errore!");
			break;
		}
		
		try{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()){
				ProgettoFormativo progettoFormativo = new ProgettoFormativo();
				
				progettoFormativo.setIdProgettoFormativo(rs.getString("idProgettoFormativo"));
				progettoFormativo.setMatricolaStudente(rs.getString("matricolaStudente"));
				progettoFormativo.setIdTaz(rs.getString("idTaz"));
				progettoFormativo.setIdTirocinio(rs.getString("idTirocinio"));
				progettoFormativo.setIdRa(rs.getString("idRa"));
				progettoFormativo.setIdTac(rs.getString("idTac"));
				progettoFormativo.setIdDd(rs.getString("idDd"));
				progettoFormativo.setIdPcd(rs.getString("idPcd"));
				progettoFormativo.setFirmaTaz(rs.getInt("firmaTaz"));
				progettoFormativo.setApprovazioneRa(rs.getInt("approvazioneRa"));
				progettoFormativo.setFirmaTac(rs.getInt("firmaTac"));
				progettoFormativo.setFirmaDd(rs.getInt("firmaDd"));
				progettoFormativo.setFirmaPcd(rs.getInt("firmaPcd"));
				progettoFormativo.setConfermaUst(rs.getInt("confermaUst"));
				progettoFormativo.setNomeFile(rs.getString("nomeFile"));
				progettoFormativo.setRifiutato(rs.getInt("rifiutato"));
				progettoFormativo.setAnnullato(rs.getInt("annullato"));
				
				list.add(progettoFormativo);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		destroy();	
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
