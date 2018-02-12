package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import dcs.ProgettoFormativoDCS;
import domainClasses.ProgettoFormativo;
import domainClasses.Studente;
import domainClasses.Tirocinio;


@WebServlet("/InvioProgettoFormativoServlet")
public class InvioProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public InvioProgettoFormativoServlet() {
        super();
    }

    //variabili sessione e pagina
    HttpSession session=null;
	String pagina = "ErrorPage.jsp";
    
 // Path di salvataggio dei dati
    private static final String UPLOAD_DIRECTORY = "C:"+File.separator+"ProgettiFormativiServer";

    // Settings di Upload
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    
    //doget
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
    /**
     * Quando riceve il submit dell' upload del file , fa il parse della request per leggerne i dati in upload e salvarli sul disco.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	session = request.getSession(true);
    	
    	//Prepariamo i dati per il Progetto Formativo
    	Studente studente = new Studente();
    	String matricolaStudente = (String) session.getAttribute("key");
    	studente.setMatricolaStudente(matricolaStudente);
    	try {
			studente.leggiDatiDaDB();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
    	String matricolaTutorAccademico = studente.getMatricolaTutorAccademico();
    	
    	//tirocinio scelto
    	
    	if(session.getAttribute("idTirocinioScelto")!=null){
    		int idTirocinio = (int) session.getAttribute("idTirocinioScelto");
	    	session.removeAttribute("idTirocinioScelto"); // con la request per qualche motivo non funziona @da controllare
	    	
	    	Tirocinio tirocinio= new Tirocinio();
	    	tirocinio.setIdTirocinio(idTirocinio);
	    	
	    	try {
				tirocinio.leggiDatiDaDB();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	
	    	int idTutorAziendale = tirocinio.getIdTutorAziendale();
	    	int idResponsabileAziendale = tirocinio.getIdResponsabileAziendale();
	    	String nomeFile="";
	    	// Fine dichiarazioni di inserimento
	    	
	    	//controllo se l'utente ha gia' un progetto formativo in corso , se lo ha , controlla se è annullato o rifiutato
	    	ProgettoFormativo pf=null;
			try {
				pf = ProgettoFormativoDCS.loadByMatricola(matricolaStudente);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			if((pf==null)||(pf.getAnnullato()==1)||(pf.getRifiutato()==1)){
				
				try {
					if(pf!=null){
						pf.cancellaDatiDaDB(); //cancelliamo il progetto vecchio se c'e'
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	    		// Controlliamo se la request contiene il file da caricare
	            if (!ServletFileUpload.isMultipartContent(request)) {
	            	System.out.println("La request non contiene alcun file da caricare");
	            	pagina = "ErrorPage.jsp";
	    			session.setAttribute("messaggioErrore", "La request non contiene alcun file da caricare!");
	            }
	            else{
	    	        // Configurazione settings di upload
	    	        DiskFileItemFactory factory = new DiskFileItemFactory();
	    	        // set del memory threshold -oltre questo i file sono salvati su disco
	    	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	    	        // set della temporary location dove salvare i file
	    	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	    	 
	    	        ServletFileUpload upload = new ServletFileUpload(factory);
	    	         
	    	        // sets maximum size of upload file
	    	        upload.setFileSizeMax(MAX_FILE_SIZE);
	    	         
	    	        // sets maximum size of request (include file + form data)
	    	        upload.setSizeMax(MAX_REQUEST_SIZE);
	    	 
	    	        // settiamo il path di upload
	    	        String uploadPath = UPLOAD_DIRECTORY;
	    	        
	    	        // crea la directory nel caso non esistesse
	    	        File uploadDir = new File(uploadPath);
	    	        if (!uploadDir.exists()) {
	    	            uploadDir.mkdir();
	    	        }
	    	 
	    	        try {
	    	            // parsing del contenuto della request per ottenerne i dati
	    	            List<FileItem> formItems = upload.parseRequest(request);
	    	 
	    	            if (formItems != null && formItems.size() > 0) {
	    	                // itera sui campi del form
	    	                for (FileItem item : formItems) {
	    	                    // processa solo i campi che non sono campi del form
	    	                    if (!item.isFormField()) {
	    	                    
	    	                    	String fileName = new File(item.getName()).getName(); //qui ci prendiamo il nome del file
	    							String estensione = FilenameUtils.getExtension(fileName); // mi prendo l'estensione
									if(!(estensione.equals("pdf"))){
											System.out.println("Errore , l'estensione non è pdf");
											pagina = "ErrorPage.jsp";
											session.setAttribute("messaggioErrore", "Il file caricato non è pdf.");
									}
									else if(estensione.equals("pdf")){
	    								nomeFile = "progetto_formativo_matricola_"+matricolaStudente+"."+estensione; //cambiamo il nome del file
	
	    		                        String filePath = uploadPath + File.separator + nomeFile;
	    		                        File storeFile = new File(filePath);
	    		 
	    		                        // salva i file su disco
	    		                        item.write(storeFile);
	    		                        System.out.println("FILE CARICATO CORRETTAMENTE");
	    		                        
	    		                        //progettoFormativo
	    		                    	ProgettoFormativo progettoFormativo = new ProgettoFormativo(matricolaStudente, idTirocinio, idTutorAziendale, matricolaTutorAccademico, idResponsabileAziendale, nomeFile);
	    		                    	progettoFormativo.inserisciDatiSuDB();
	    		                    	System.out.println("PF CARICATO CORRETTAMENTE");
	    		                    	
	    		                        session.setAttribute("progettoInviato", 1);
	    		                        pagina = "VisioneProgettiFormativiServlet"; //servlet per la visualizzazione del progetto dello studente
	    	                    	}
	    	                    	
	    	                    }
	    	                }
	    	            }
	    	        } catch (Exception ex) {
	    	        	System.out.println("Errore nel caricamento del file"+ ex.getMessage());
	    	        	pagina = "ErrorPage.jsp";
	    				session.setAttribute("messaggioErrore", "Errore nel caricamento del file :" + ex.getMessage());
	    	        }
	            }
	        }
	    	else{
	    		System.out.println("L'utente ha già un progetto formativo, non annullato o rifiutato");
	    		pagina = "ErrorPage.jsp";
				session.setAttribute("messaggioErrore", "Hai già un progetto formativo e non è nemmeno annullato o rifiutato!");
	    	}
    	}
		else{
			System.out.println("Nessun idTirocinio presente");
			pagina = "ErrorPage.jsp";
			session.setAttribute("messaggioErrore", "Riseleziona il tirocinio! L'id tirocinio è stato gia' eliminato da una precedente iterazione oppure l'accesso è improprio!");	
		}
	        // redirect
	        RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
	    }
    
   
}
    
