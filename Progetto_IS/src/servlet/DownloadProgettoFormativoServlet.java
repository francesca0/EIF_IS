package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadProgettoFormativoServlet")
public class DownloadProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DownloadProgettoFormativoServlet() {
        super();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String matricola = request.getParameter("matricolaFile");

        String fileName = "progetto_formativo_matricola_"+matricola+".pdf";
        String filePath = "C:"+File.separator+"ProgettiFormativiServer"+ File.separator +fileName;
        
        String fileType = "application/pdf";


        response.setContentType(fileType);

        response.setHeader("Content-disposition","attachment; filename="+fileName);

        File my_file = new File(filePath);

        // Invia il file al browser
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
   }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
