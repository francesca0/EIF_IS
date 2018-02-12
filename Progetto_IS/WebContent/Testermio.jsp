<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test File Upload</title>

	<jsp:include page="datiCss.jsp" />
	
	
    
</head>
<% String key = "0512103873"; //matricola di test %>
   <body>
			 <center>
		        <form method="get" action="DownloadProgettoFormativoServlet">
		            <input type="submit" value="ScaricaFile" />
		            <input type="hidden" value="<%=key%>" id="matricolaFile" name="matricolaFile"/>
		        </form>
		    </center>
		    
	   </body>
</html>