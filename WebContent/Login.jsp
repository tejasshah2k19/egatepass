<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
	.error{
		border-color: red;
	}
</style>
</head>
<body>
	<h2>Login</h2>

	<%
		String error = (String) request.getAttribute("error");
	%>
	<form action="LoginServlet" method="post">

		<%
			if (error == null) {
		%>
		Email : <input type="text" name="email" /><br> <br>
		<%
			} else {
		%>
		Email : <input type="text" name="email" class="error" /> <font color="red"><%=error %></font><br> <br>

		<%
			}
		%>
		Password : <input type="password" name="password" /><br> <br>
		<Br> <input type="submit" value="Login"> <font
			color="red"><%=error == null ? "" : error%></font><br>
	</form>
	<a href="Signup.jsp">Signup</a>




</body>
</html>