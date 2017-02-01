<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC Web Application</title>
</head>
<body>

<h1> A Simple MVC Web Application</h1>
<h2> Login here</h2>

<form action=ServLogin method=post	>

User Name: <input type=text name=userName><br>	
Password: <input type=password name=password><br>
<input type=submit value=Login> <br> 

</form>

<br>
<br>

<!-- Navigation links --> 
<a href="Register.jsp"> Are you a New User? </a> <br>

</body>
</html>