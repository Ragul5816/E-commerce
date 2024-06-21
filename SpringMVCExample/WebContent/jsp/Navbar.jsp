<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Commerce Website</title>
<style type="text/css">
*{
	margin: auto;
	font-family: sans-serif;
	text-decoration: none;
	list-style: none;
	font-weight: bold;
}
.nav{
       width: 100%;
       height: 70px;
       background-color: Darkgrey;
}
span{
       color: black;
       font-size: 1.2rem;
       padding-left: 20px;
       line-height: 70px;
}
.nav ul{
        float: right;
         padding-right: 20px;
}
.nav ul li{
         display: inline-block;
         margin: 0px 15px;
         line-height: 70px;
}
.nav ul li a{
          color: black;
}

 
</style>
</head>
<body>
       <nav class="nav">
       <span>E-commerce Website</span>
       <ul>
         <li> <input type="search" placeholder="Search">
              <button type="submit">Search</button> </li>
           <li><a href="login">Login</a></li>
           <li><a href="register">Register</a></li>
           <li><a href="profile">Profile</a></li>
           <li><a href="#">cart</a></li>
          
           
       </ul>
</nav>     
</body>
</html>