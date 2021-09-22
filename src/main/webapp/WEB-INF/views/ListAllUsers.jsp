<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List All Users</title>
</head>
<body>
	<h2>All Users</h2>


	<a href="/logout">Logout</a>
	<br>

	<table border="1">
		<tr>
			<td>UserId</td>
			<td>FirstName</td>
			<td>Action</td>
		</tr>

		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userId }</td>
				<td>${user.firstName }</td>
				<td><a href="users/${user.userId}">View</a> | Delete | Edit</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>