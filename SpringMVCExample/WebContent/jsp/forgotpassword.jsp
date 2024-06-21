<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forgotPassword</title>
<style type="text/css">
.center {
	margin: auto;
	width: 50%;
	border: 1px solid #151316;
	padding: 10px;
}
</style>
</head>
<body>

	<font color="red">${message}</font>
	<div class="center">
		<form id="forgotPasswordForm" method="post" action="forgotpassword" modelAttribute="userBean">
		
			<h1>ForgotPassword</h1>
			
			<label path="email">email</label> 
			<input id="email" name="email" />
			<br> <br> 
			
			<label path="newPassword">newPassword</label> 
			<input id="newPassword" name="newPassword" /> 
			<br> <br> 
			
			<label path="confirmPassword">confirmPassword</label> 
			<input id="confirmPassword" name="confirmPassword" /> 
			<br> <br>

			<input type="submit" value="Submit" />
			
		</form>
	</div>
</body>
</html>