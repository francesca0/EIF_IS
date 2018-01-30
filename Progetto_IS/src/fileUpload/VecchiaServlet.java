package fileUpload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class VecchiaServlet
 */
@WebServlet("/VecchiaServlet")
public class VecchiaServlet extends HttpServlet {
		   private static final long serialVersionUID = 1L;
		   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      // ricaviamo il content type
		      String contentType = request.getContentType();
		      //check se il content type non è nullo e mulitpart/form-data contiene qualcosa
		      if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
		         DataInputStream in = new DataInputStream(request.getInputStream());
		 
		         //lunghezza del contenuto del content type
		         int formDataLength = request.getContentLength();
		         byte dataBytes[] = new byte[formDataLength];
		         int byteRead = 0;
		         int totalBytesRead = 0;
		         //convertiamo il file in upload in byte code
		         while (totalBytesRead < formDataLength) {
		            byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
		            totalBytesRead += byteRead;
		         }
		 
		         String file = new String(dataBytes);
		         // ricaviamo il nome del file
		         String nomeFile = file.substring(file.indexOf("filename=\"") + 10);
		         nomeFile = nomeFile.substring(0, nomeFile.indexOf("\n"));
		         nomeFile = nomeFile.substring(nomeFile.lastIndexOf("\\") + 1,nomeFile.indexOf("\""));
		         int lastIndex = contentType.lastIndexOf("=");
		         String boundary = contentType.substring(lastIndex + 1,contentType.length());
		         int pos;
		         // controlliamo da dove comincia realmente il contenuto del file (senza intestazione)
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
		      }
		   }
		}

