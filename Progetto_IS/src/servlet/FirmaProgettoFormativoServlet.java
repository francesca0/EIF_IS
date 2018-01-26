package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.ConnectionManager;
import domainClasses.TutorAccademico;
import domainClasses.TutorAziendale;

@WebServlet("/FirmaProgettoFormativoServlet")
public class FirmaProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	HttpSession session = null;
	RequestDispatcher dispatcher = null;

    public FirmaProgettoFormativoServlet() {
        super();
    }
    
    // Il metodo init permette l'inizializzazione della Servlet e la connessione al database.

    public void init(ServletConfig config) throws ServletException{	
		super.init(config);
		try{
			con = ConnectionManager.getConnection();
			
			System.out.println("init firma");
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
		System.out.println("prima switch");
		switch(tipoAccount){	
		
				// Tutor Aziendale.
				case 2: 
					query = "UPDATE progetto_formativo SET firmaTaz='1' WHERE idProgettoFormativo='"+(String)request.getParameter("idProgettoFormativo")+"'AND approvazioneRa='1' AND firmaTaz='0' AND idTaz='"+((TutorAziendale)session.getAttribute("utente")).getIdTutorAziendale()+"';";
					System.out.println("taz");
					break;
					
				// Tutor Accademico.
				case 3: 
					query = "UPDATE progetto_formativo SET firmaTac='1' WHERE idProgettoFormativo='"+(String)request.getParameter("idProgettoFormativo")+"'AND approvazioneRa='1' AND firmaTac='0' AND idTac='"+((TutorAccademico)session.getAttribute("utente")).getIdTutorAccademico()+"';";
					break;
					
				// Presidente del Consiglio Didattico.	
				case 6:  
					query = "UPDATE progetto_formativo SET firmaPcd='1' WHERE idProgettoFormativo='"+(String)request.getParameter("idProgettoFormativo")+"'AND approvazioneRa='1'AND firmaPcd='0'";
					break;
					
				// Direttore di Dipartimento.	
				case 7: 
					query = "UPDATE progetto_formativo SET firmaDd='1' WHERE idProgettoFormativo='"+(String)request.getParameter("idProgettoFormativo")+"'AND approvazioneRa='1' AND firmaDd='0'";
					break;
				
				default: System.out.println("Errore!");
					break;
		}
		
		System.out.println("dopo switch");
		
		dispatcher = request.getRequestDispatcher("test1.jsp");
		dispatcher.forward(request, response);
		
		try{
			ps = con.prepareStatement(query);			
			ps.executeQuery();
			
			
		}catch(Exception e){
			
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
