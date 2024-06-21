<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
.center {
	margin: auto;
	width: 30%;
	border: 1px solid #151316;
	padding: 10px;
}
 body{
            background-image:url("https://images.unsplash.com/photo-1584117756263-bc482c509c49?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2340&q=80");
            background-repeat: no-repeat;
            background-attachment: fixed; 
            background-size: 140% 120%;
        }
</style>
</head>
<body>

	<font color="red">${message}</font>
	<div class="center">
		<form id="registerForm" method="post" action="register" modelAttribute="userBean" enctype="multipart/form-data">
			<h1>Register</h1>
			
			<label path="firstName">firstName</label> 
			<input id="firstName" name="firstName" />
			 <br> <br>
			 
			<label path="lastName">lastName</label>
		    <input id="lastName" name="lastName" /> 
		    <br> <br>
		    
		    <label path="email">email</label>
		   	<input id="email" name="email" /> 
		   	<br> <br> 
		   	
		   	<label path="password">password</label> 
	 	    <input id="password" name="password" /> 
	 	    <br> <br> 
	 	    
		    <label path="contactNo">contactNo</label>
			<input id="contactNo" name="contactNo" />
			 <br> <br> 
			 
			 <label path="address">address</label>
			<input id="address" name="address" />
			 <br> <br> 
			
			<label path="image"></label> 
		    <input type="file"  id="image" name="image" path="" />
			<br> <br>
		
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>