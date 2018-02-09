package fileUpload;


import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 

@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	
    public FileUploadServlet() {
        super();
    }

    //variabili sessione e pagina
    HttpSession session=null;
	String pagina="index.html";
    
 // Path di salvataggio dei dati
    private static final String UPLOAD_DIRECTORY = "C:"+File.separator+"ProgettiFormativiServer";

    // Settings di Upload
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * Quando riceve il submit dell' upload del file , fa il parse della request per leggerne i dati in upload e salvarli sul disco.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	session = request.getSession(true);
    	
    	// Controlliamo se la request contiene il file da caricare
        if (!ServletFileUpload.isMultipartContent(request)) {
        	System.out.println("La request non contiene alcun file da caricare");
			session.setAttribute("messaggioErrore", "La request non contiene alcun file da caricare!");
			pagina = "ErrorPage.jsp";
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
	                        String fileName = new File(item.getName()).getName();
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	 
	                        // salva i file su disco
	                        item.write(storeFile);
	                        System.out.println("FILE CARICATO CORRETTAMENTE");
	                        
	                        ///INSERIRE I DATI DI  CARICAMENTO E RELATIVA COSTRUZIONE DEL PROGETTO FORMATIVO
	                        
	                        
	                        ///
	                        
	                        session.setAttribute("progettoInviato", 1);
	                        pagina = "visioneProgettiFormativiServlet"; //servlet per la visualizzazione del progetto dello studente
	                        
	                    }
	                }
	            }
	        } catch (Exception ex) {
	        	System.out.println("Errore nel caricamento del file"+ ex.getMessage());
				session.setAttribute("messaggioErrore", "Errore nel caricamento del file :" + ex.getMessage());
				pagina = "ErrorPage.jsp";
	        }
	        // redirect
	        RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
	    }
    }
}