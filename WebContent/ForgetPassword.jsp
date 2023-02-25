<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ForgetPassword</title>
</head>
<body>
<form action="ForgetPasswordServlet" method="post">
	Email : <input type="text" name="email"/><br><br>
	<input type="submit" value="SendOtp"/>
	
	
</form>
<br>
 
${error}

</body>
</html>