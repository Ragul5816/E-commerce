<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="Navbar.jsp" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"  />
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product list</title>
<style type="text/css">
.size{
text-align : left;
font-size: 15px;
font-family:Arial;
padding-top:10px;
padding-bottom:10px;
padding-left:30px;
paddin-right:50px;
background-color:white;
line-spacing:1px;

}

.center {
  margin: auto;
  width: 60%;
  border: 1px solid #151316;
  padding: 10px;
  background-color:grey;
  text-align : left;
  font-family:Arial;
  font-size: 15px;
}
.search{
margin-left:12px;
font-size:20px;

}
.display{
display: left;
}
</style>
</head>
<body>
<form id="productForm" method="get" action="productlist" modelAttribute="productBean">
      
      <c:forEach var="product" items="${productBean}" >
      <img width="140" height="140" src="data:image/jpg;base64, ${product.pic}"/> 
      <p><a href="/SpringMVCloginExample/productdescription/${product.productid }">${product.productname }</a></p>
      <p> price: ${product.price }</p><br>
      </c:forEach><br> <br>
     
</form>        
</body>
</html>