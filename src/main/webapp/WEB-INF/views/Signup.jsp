<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>Signup</h2>
			
				<s:form action="saveuser" method="post"
					enctype="multipart/form-data" modelAttribute="user">
					<div class="form-group">
						<label for="firstName">FirstName:</label>
						<s:input cssClass="form-control" id="email"
							placeholder="Enter firstname" path="firstName"></s:input>
						<s:errors path="firstName" cssClass="error"></s:errors>
					</div>

					<div class="form-group">
						<label for="email">Email:</label>
						<s:input type="text" class="form-control" id="email"
							placeholder="Enter email" path="email" />
						<s:errors path="email" cssClass="error"></s:errors>
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<s:password class="form-control" id="pwd"
							placeholder="Enter password" path="password" />
					</div>


					<div class="form-group">
						<label for="pwd">Profile:</label> <input type="file"
							name="imgProfile" />
					</div>

				

					<button type="submit" class="btn btn-primary">Submit</button>
				</s:form>
			</div>
		</div>
	</div>



</body>
</html>