package fileUpload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//copypaste
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public FileUpload() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	      Part filePart = request.getPart("nomeFile");
	 
	      String nomeFile = getFilename(filePart);
	 
	      BufferedReader reader = new BufferedReader(new InputStreamReader(filePart.getInputStream()));
	      
	      //stampiamo il contenuto del file in console
	      String line = null;
	      while ((line = reader.readLine()) != null) {
	         System.out.println(line);
	      }
	      
//upload da finire
	      // controlliamo da dove comincia realmente il contenuto del file (senza intestazione)
	      int pos;
	         pos = file.indexOf("filename=\"");
	         pos = file.indexOf("\n", pos) + 1;
	         pos = file.indexOf("\n", pos) + 1;
	         pos = file.indexOf("\n", pos) + 1;
	         int boundaryLocation = file.indexOf(boundary, pos) - 4;
	         int posizioneIniziale = ((file.substring(0, pos)).getBytes()).length;
	         int posizioneFinale = ((file.substring(0, boundaryLocation)).getBytes()).length;
	    
	         // creiamo un nuovo file con lo stesso nome e contenuto del file in upload
	         FileOutputStream fileOut = new FileOutputStream(nomeFile);
	         fileOut.write(dataBytes, posizioneIniziale, (posizioneFinale - posizioneIniziale));
	         fileOut.flush();
	         fileOut.close();
	 
	         System.out.println("File "+nomeFile+" inviato con succeso");
	 
	         
	 // fine upload     
	      System.out.println("nome File->"+nomeFile);
	   }
	   
	   //metodo per ottenere il nome del file caricato
	   private static String getFilename(Part part) {
		   for (String cd : part.getHeader("content-disposition").split(";")) {
		      if (cd.trim().startsWith("filename")) {
		         String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
		         return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
		      }
		   }
		 
		   return null;
		}

}
