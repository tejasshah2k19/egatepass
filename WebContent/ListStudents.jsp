<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Students</title>
</head>
<body>
	<%
		ArrayList<UserBean> students = (ArrayList<UserBean>) request.getAttribute("students");
	%>
	<table border="1">
		<tr>
			<th>StudentId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>EnrollmentNum</th>
			<th>Status</th>
		</tr>


		<%
			for (UserBean s : students) {
		%>
		<tr>
			<td><%=s.getUserId()%></td>
			<td><%=s.getFirstName()%></td>
			<td><%=s.getEmail()%></td>
			<td><%=s.getEnrollmentNum()%></td>
			<td><a href="ChangeStudentStatus?userId=<%=s.getUserId()%>&currentStatus=<%=s.isApprove()%>"> <%=s.isApprove()%>
			</a></td>

		</tr>


		<%
			}
		%>
	</table>
</body>
</html>