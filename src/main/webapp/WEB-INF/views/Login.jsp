<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>

	<form action="login" method="post">

		Username: <input type="text" name="username" /><br> Password: <input
			type="password" name="password" /><br> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}"> <input
			type="submit" value="Login" />

	</form>
	<br>
	<c:if test="${param.error != null}">
		Invalid Credentials
	</c:if>

</body>
</html>