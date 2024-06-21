<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>edit profile</title>
<style type="text/css">
.center {
	margin: auto;
	width: 30%;
	border: 1px solid #151316;
	padding: 10px;
}
</style>
</head>
<body>

	<font color="red">${message}</font>
	<div class="center">
		<form:form id="editprofileForm" method="post" action="/SpringMVCloginExample/editprofile" modelAttribute="userBean" enctype="multipart/form-data">
			<h1>Edit Profile</h1>
			
			<form:label path="firstName">firstName</form:label> 
			<form:input id="firstName" name="firstName" path=""
			 value = "${userBean.firstName }"/>
			 <br> <br>
			 
			<form:label path="lastName">lastName</form:label>
		    <form:input id="lastName" name="lastName" path=""
		     value = "${userBean.lastName }" /> 
		    <br> <br>
		    
		    <form:label path="email">email</form:label>
		   	<form:input id="email" path="email" readonly="true"
		     value = "${userBean.email }" /> 
		   	<br> <br> 
		   	
		   	<form:label path="password">password</form:label> 
	 	    <form:input type="password" id="password" name="password" path=""
	 	     value = "${userBean.password }" /> 
	 	    <br> <br> 
	 	    
		    <form:label path="contactNo">contactNo</form:label>
			<form:input id="contactNo" name="contactNo" path=""
			 value = "${userBean.contactNo }" />
			 <br> <br> 
			 
			 <form:label path="address">address</form:label>
			 <form:input id="address" name="address" path=""
			 value = "${userBean.address }" />
			 <br> <br> 
			 
			 <form:label path="image">Upload-Image</form:label>
			 <form:input type="file" id="image" name="image" path=""
			 value = "${userBean.pic }" />
			 <br> <br> 
		
			<input type="submit" value="Update" />
		</form:form>
	</div>
</body>
</html>