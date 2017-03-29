<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${user.userName}</h1>
<form action=ServSearchQuery method=post	>

Section:
<select name="product">
	    <option value="All">All</option>
	    <option value="Home">Home & Decor</option>
    <option value="Mens">Mens Aparel</option>
    <option value="Womens">Womens Apparel</option>
    <option value="Child">Children</option>
  </select><br>

Items to Search: <input type=text name=searchVal><br>
  
<input type=submit value=Search> <br>
</form>

<a href="ServLogout">LogOut</a> <br>
<a href="ServViewOrders">View Orders</a> <br>


</body>
</html>