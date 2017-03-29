<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Web Application</title>
</head>
<body>

<h1> A Simple MVC Web Application</h1>
<h2> Register here</h2>

<form action	=ServRegister>

User Name: <input type=text name=userName><br>
Password: <input type=password name=password><br>
Email: <input type=text name=email><br>
Register as:
<select name="type">
    <option value="cust">Customer</option>
    <option value="seller">Seller</option><br>
   </select><br>
 
 <input type=submit value=Register> <br> 

</form>

<br>
<br>

<!-- Navigation links --> 
<a href="Login.jsp">Login </a> <br>


</body>
</html>