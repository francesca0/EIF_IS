<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test File Upload</title>
</head>
   <body>
		 
		<!-- form method="POST" enctype="multipart/form-data" action="fup.cgi"> -->
		 	<!-- File to upload: <input type="file" name="upfile"><br/> -->
			<!--  <br/>-->
			<!--  <input type="submit" value="Press"> to upload the file!-->
		<!--	</form> -->
		 
		 <center>
		        <form method="post" action="FileUploadServlet" enctype="multipart/form-data">
		            Select file to upload:
		            <input type="file" name="uploadFile" />
		            <br/><br/>
		            <input type="submit" value="Upload" />
		        </form>
		    </center>
   </body>
</html>