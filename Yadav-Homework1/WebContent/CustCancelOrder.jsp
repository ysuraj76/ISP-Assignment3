	<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<title>Insert title here</title>

</head>
<body>

<div id="right"><a href="ServLogout">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<c:set var="id" scope="session" value="${Index}"/>

<h2> Details for Product '${Items.get(id).name}'</h2>


 	<b>Order# : </b>${Ord.id}<br>
   <b>Order Date: </b>${Ord.ordDate}<br>
   <b>Price: </b>${Items.get(id).prd_price}<br>
   <b>Quantity: </b>${Items.get(id).qnt}<br>
   <b>Status: </b>${Items.get(id).shipping}<br><br>
   
<form action=ServCancelConfirmation method=post	>
<input type=submit value=Confirm> <br> 
</form>

<form action=CustHomepage.jsp method=post	>
<input type=submit value=Discard> <br> 
</form>

<a href="CustViewOrders.jsp">View Current Orders</a> <br>

</body>
</html>