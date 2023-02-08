<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>

	<form action="RegistrationServlet" method="post">

		FirstName: <input type="text" name="firstName" /><br> <br>
		Email : <input type="text" name="email" /><br> <br>
		Password : <input type="text" name="password" /><br> <br>
		EnrollmentNum : <input type="text" name="enrollmentNum"><br>
		<Br> <input type="submit" value="Signup">


	</form>


</body>
</html>