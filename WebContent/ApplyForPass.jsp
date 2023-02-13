<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ApplyForPass</title>
</head>
<body>
	<%
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String today = df.format(d);
	%>
	<form action="ApplyForPassServlet" method="post">
		Pass Date : <input type="text" readonly="readonly" value="<%=today%>"><br>
		<br>
		Reason : <input type="text" name="reason"><br><br>
		OutTime : <input type="time" name="outtime"><br><Br>
		
		<input type="Submit" value="Apply"/> 
		
		
		

	</form>

</body>
</html>