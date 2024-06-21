<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<style type="text/css">
.center {
	margin: auto;
	width: 35%;
	border: 1px solid #151316;
	padding: 10px;
}
</style>
</head>
<body>
<font color="red">${message}</font>

<form id="updatedprofileForm" method="post" action="updatedprofile" modelAttribute="userBean" enctype="multipart/form-data">

<img width="100" height="100" src="data:image/jpg;base64, ${userBean.pic}"/>
 
FirstName  :  ${userBean.firstName}
<br>
<br>
LastName   :  ${userBean.lastName}
<br>
<br>
email      :  ${userBean.email}
<br>
<br>
contactNo  :  ${userBean.contactNo}
<br>
<br>
address    :  ${userBean.address}
<br>
<br>
<br>


<p>Profile updated successfully...</p>

<a href="login">Login</a> 
</form>
</body>
</html>