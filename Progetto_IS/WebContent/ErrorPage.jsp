<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	
	<jsp:include page="datiCss.jsp" />

</head>
<body>
<%@ page isErrorPage = "true" %>
<% String messaggioErrore = (String) session.getAttribute("messaggioErrore"); %>

<p>-----------------------------------</p>
<h3>Pagina di Errore</h3>
<p>Messaggio di errore: <%=messaggioErrore %></p>
<p>-----------------------------------</p>
<% session.removeAttribute("messaggioErrore"); %>
<p><%//= exception.getMessage()%></p>
</body>
</html>