package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domainClasses.Tirocinio;
import utility.ConvertStringToDate;

@WebServlet("/ModificaTirociniServlet")
public class ModificaTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ModificaTirociniServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Tirocinio tirocinio = new Tirocinio();
		tirocinio.setIdTirocinio(Integer.parseInt(request.getParameter("idTirocinio")));
		
		try {
			tirocinio.leggiDatiDaDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if(!((request.getParameter("idTutorAziendale")).equals(""))) {
			tirocinio.setIdTutorAziendale(Integer.parseInt((request.getParameter("idTutorAziendale"))));
		}
		if(!((request.getParameter("descrizione")).equals(""))) {
			tirocinio.setDescrizione(request.getParameter("descrizione"));
		}
		if(!((request.getParameter("tematica")).equals(""))) {
			tirocinio.setTematica(request.getParameter("tematica"));
			}
		if(!((request.getParameter("note")).equals(""))) {
			tirocinio.setNote(request.getParameter("note"));
		}
		if(!((request.getParameter("dataInizio")).equals(""))) {
			tirocinio.setDataInizio(ConvertStringToDate.convert(request.getParameter("dataInizio")));
		}
		if(!((request.getParameter("dataFine")).equals(""))) {
			tirocinio.setDataFine(ConvertStringToDate.convert(request.getParameter("dataFine")));
		}

		try {
			tirocinio.aggiornaDatiSuDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
