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
<div id="right"><a href="Login.jsp">LogOut</a> <br></div>

<div id="wrap">
<jsp:useBean id="user" class="model.Users" scope="session"/>
<h1>Welcome ${user.userName}</h1>

	
	
<a href="SellerViewCurrentOrders.jsp">View Current Orders</a> <br>
<a href="ServManageProducts">Manage Orders</a> <br><br>

<div id="picSeller"><img src="images/seller.jpg" alt="seller" style="width:600px;height:400px;"><br></div>


</div>
</body>
</html>