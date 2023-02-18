<%@page import="com.bean.PassBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Past Request</title>
</head>
<body>
	<%
		ArrayList<PassBean> pastRequest = (ArrayList<PassBean>) request.getAttribute("pastRequest");
	%>
	<a href="ApplyForPass.jsp">New Request</a>
	<table border="1">
		<tr>
			<th>Pass Date</th>
			<th>Time</th>           
			<th>Reason</th>
			<th>Status</th>
		</tr>

		<%
			for (PassBean p : pastRequest) {
		%>
		<tr>
			<td><%=p.getPassDate()%> </td>
			<td><%=p.getOutTime()%> </td>
			<td><%=p.getReason()%>
						<td><%=p.getApprove()%> </td>

		</tr>
		<%
			}
		%>
	</table>
</body>
</html>