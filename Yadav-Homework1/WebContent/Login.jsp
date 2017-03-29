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

<h1> Welcome to A2Z Corp !!!</h1>
<h2>Buyers meet Sellers here </h2>


<h2> Login here</h2>
<%!
	String uName;
	String pwd;
%>

<%
	Cookie cookieList[] = request.getCookies();
	if(cookieList != null) {
		for (int i = 0; i < cookieList.length; i++) {
			Cookie c = cookieList[i];
			if(c.getName().equals("uName")) {
				uName = c.getValue();
			}
			if(c.getName().equals("pwd")) {
				pwd = c.getValue();
			}
		}
	}
	
	if(uName == null || uName.trim().equals(""))
		uName ="";
	if(pwd == null || pwd.trim().equals("")) 
		pwd = "";

	

%>

<form action=ServLogin method=post	>

I am a:
<select name="type">
    <option value="cust">Customer</option>
    <option value="seller">Seller</option><br>
   </select><br><br>

User Name: <input type=text name=userName value=<%=uName%>><br>	
Password: <input type=password name=password value=<%=pwd%>>><br>
<INPUT TYPE="CHECKBOX" name="storePass">Remember me on this Computer<br><br>
 
<input type=submit value=Login> <br> 

</form>

<br>
<br>

<!-- Navigation links --> 
<a href="Register.jsp"> Are you a New User? </a> <br>

</body>
</html>