package servletAGGIORNATE;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domainClasses.Studente;
import utility.ConvertStringToDate;

/**
 * Servlet implementation class ModificaAccountStudenteUfficio
 */
@WebServlet("/ModificaAccountStudenteUfficio")
public class ModificaAccountStudenteUfficio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
       
    public ModificaAccountStudenteUfficio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Studente studente = new Studente();
		studente.setMatricolaStudente(request.getParameter("matricolaStudente"));
		try {
			studente.leggiDatiDaDB();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");		
		Date dataDiNascita = ConvertStringToDate.convert(request.getParameter("dataDiNascita"));	
		String luogoDiNascita = request.getParameter("luogoDiNascita");
		String residenza = request.getParameter("residenza");
		String telefono = request.getParameter("telefono");
		String tutorAccademico = request.getParameter("tutorAccademico");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(!nome.equals("")){
			studente.setNome(nome);
		}
		if(!cognome.equals("")){
			studente.setCognome(cognome);
		}
		//da controllare il 00-00-0000 <<<<<<<<<<<<<<<<<<<<<<<<<<<<CONTROLLA<<<<<<<<<<<<<<<<<<<<<<
		if((request.getParameter("dataDiNascita")).equals("") || (request.getParameter("dataDiNascita")).equals("00-00-0000")){
			studente.setDataDiNascita(dataDiNascita);
		}
		if(!luogoDiNascita.equals("")){
			studente.setLuogoDiNascita(luogoDiNascita);
		}
		if(!residenza.equals("")){
			studente.setResidenza(residenza);
		}
		if(!telefono.equals("")){
			studente.setTelefono(telefono);
		}
		if(!tutorAccademico.equals("")){
			studente.setTutorAccademico(tutorAccademico);
		}
		if(!email.equals("")){
			studente.setEmail(email);
		}
		if(!password.equals("")){
			studente.setPassword(password);
		}
		
		try {
			studente.aggiornaDatiSuDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
