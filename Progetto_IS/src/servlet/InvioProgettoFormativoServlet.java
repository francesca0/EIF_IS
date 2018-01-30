package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dcs.ProgettoFormativoDCS;
import domainClasses.ProgettoFormativo;
import domainClasses.Studente;
import domainClasses.Tirocinio;

@WebServlet("/InvioProgettoFormativoServlet")
public class InvioProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session=null;
	
    public InvioProgettoFormativoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	session=request.getSession(true);
    	
    	int idProgettoFormativo=0; // DEVE ESSERE RESO AUTOINCREMENTALE
  
    	Studente studente = (Studente) session.getAttribute("utente");
    	
    	String matricolaStudente= studente.getMatricolaStudente();
    	
    	int idTirocinio=Integer.parseInt(request.getParameter("idTirocinioScelto")); // DEVE ESSERE RESO AUTOINCREMENTALE
    	
    	Tirocinio tirocinio = new Tirocinio();
    	
    	tirocinio.setIdTirocinio(idTirocinio);
    	try {
			tirocinio.leggiDatiDaDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	int  idTutorAziendale = tirocinio.getIdTutorAziendale();
    	String matricolaTutorAccademico = studente.getMatricolaTutorAccademico(); // va cambiato in idTutorAccademico
    	int idResponsabileAziendale=tirocinio.getIdResponsabileAziendale();
    	
    	String nomeFile=request.getParameter("nomeFile");
    	
    	ProgettoFormativo progettoFormativo = new ProgettoFormativo(idProgettoFormativo, matricolaStudente, idTirocinio, idTutorAziendale, matricolaTutorAccademico, idResponsabileAziendale, 0, 0, 0, 0, 0, 0, nomeFile, 0, 0);
    	
    	try {
			progettoFormativo.inserisciDatiSuDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	da completare
  	}
    	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doGet(request, response);
   	}


}
