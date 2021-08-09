<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>EDIT USER</h2>
				<form action="../updateuser" method="post">
					<input type="hidden" name="userId" value="${user.userId}"/>
					<div class="form-group">
						<label for="email">FirstName:</label> <input type="text"
							class="form-control" id="email" placeholder="Enter firstname"
							name="firstName" value="${user.firstName}">
					</div>
				
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" placeholder="Enter email"
							name="email" value="${user.email}">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" id="pwd" placeholder="Enter password"
							name="password" value="${user.password}">
					</div>

					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>



</body>
</html>