<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

</head>
<body>
	
	
	<br>
	<a href="signup">Add More User</a>
	<br>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>UserId</th>
				<th>FirstName</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userId }</td>
					<td>${user.firstName }</td>
					<td>${user.email}</td>
					<td>
					<a href="deleteUser?userId=${user.userId}">  Delete </a>
					<a href="deleteUserByPath/${user.userId}">  Delete </a>
					<a href="edituser/${user.userId}">Edit</a>	
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>