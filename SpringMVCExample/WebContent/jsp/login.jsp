<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
.center {
	margin: auto;
	width: 30%;
	border: 1px solid #151316;
	padding: 10px;
}
 body{
            background-image:url("https://img.freepik.com/free-photo/modern-office-desk-composition-with-technological-device_23-2147915828.jpg?w=1380&t=st=1693466226~exp=1693466826~hmac=7697bfd9bcd7782e11c5026f8c52b4f9613d420c51896c40a6447896a9115463");
            background-repeat: no-repeat;
            background-attachment: fixed; 
            background-size: 100% 100%;
        }
</style>

</head>
<body>


	<font color="red">${message}</font>
	<div class="center">
		<form:form id="loginForm" method="post" action="login" modelAttribute="userBean">

			<h1>Login</h1>
			
			<form:label path="email">Enter your email</form:label>
			<form:input id="email" name="email" path="" />
			<br>
			<br>

			<form:label path="password">Enter your password</form:label>
			<form:password id="password" name="password" path="" />
			<br>
			<br>
			
			<input type="submit" value="Submit" />
			<br>
			<br>
			
			<a href="register">register</a>
			<br>
			<br>
			
			<a href="forgotpassword">forgotPassword</a>

		</form:form>
	</div>
</body>
</html>