<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h2>Signup</h2>

	<form action="saveuser" method="post">
		FirstName : <input type="text" name="firstName" /><br> Email : <input
			type="text" name="email" /><br> Password : <input
			type="password" name="password" /><br> <input type="submit"
			value="Signup" /> <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">

	</form>


</body>
</html>