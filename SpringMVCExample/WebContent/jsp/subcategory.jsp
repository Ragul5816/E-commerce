<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="Navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub category</title>

</head>
<body>

      <c:forEach var="category" items="${categoryBean}" >
    
    <img width="140" height="140" src="data:image/jpg;base64, ${category.pic}"/> 
    <a href="/SpringMVCloginExample/brand/${category.categoryid }">${category.categoryName }</a>
     </c:forEach><br> <br>
     

</body>
</html>