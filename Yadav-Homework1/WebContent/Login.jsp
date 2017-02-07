<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A2Z Web Application</title>
</head>
<body>

<h1> Welcome to A-2-Z Corp !!!</h1>
<h2>Buyers meet Sellers here </h2>


<h2> Login here</h2>

<form action=ServLogin method=post	>

User Name: <input type=text name=userName><br>	
Password: <input type=password name=password><br>
I am a:
<select name="type">
    <option value="cust">Customer</option>
    <option value="seller">Seller</option><br>
   </select><br>
   
<input type=submit value=Login> <br> 

</form>

<br>
<br>

<!-- Navigation links --> 
<a href="Register.jsp"> Are you a New User? </a> <br>

</body>
</html>