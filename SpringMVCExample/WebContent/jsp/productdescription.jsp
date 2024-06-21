<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="Navbar.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>description</title>
<style type="text/css">
.container{
font-size:15px;
font-family:Arial;
}
.btn-incre,btn-decre{
box-shadow: none;
font-size:15px;

}
</style>

</head>
<body>
<div class="center">
       
      <img width="200" height="200" src="data:image/jpg;base64, ${productBean.pic}"/> 
      <p>${productBean.productname } (${productBean.colour })</p><br>
      <p>price: ${productBean.price }</p><br>
      <p>Product Description: ${productBean.description }</p><br>
      <p>Model: ${productBean.model }</p><br>
      <p>Features: ${productBean.features }</p><br>
      <br> <br>
      
      <form:form action="/SpringMVCloginExample/addToCart" method="post" modelAttribute="form">
      
      <label for="quantity">Quantity:</label>
      <input type="number" name="quantity" value="1" min="1" max="10">
      <input type="hidden" name="price" value="${productBean.price}">
      <input type="hidden" name="productid" value="${productBean.productid}">
      <input type="submit" class="btn btn-warning" value="Add To Cart">
      
      </form:form>
      </div>
             
</body>
</html>