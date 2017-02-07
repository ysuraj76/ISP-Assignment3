<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="right"><a href="Login.jsp">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Details for Product '<%out.println(ph.pdName());%>'</h2>


 	<b>Order# : </b> <% out.println(ph.number());%><br>
   <b>Order Date: </b><%out.println(ph.date()); %><br>
   <b>Price: </b><%out.println(ph.number()); %><br>
   <b>Status: </b><%out.println(ph.status()); %><br><br>
   
<form action=CustCancellationConfirmation.jsp method=post	>
<input type=submit value=Confirm> <br> 
</form>

<form action=CustHomepage.jsp method=post	>
<input type=submit value=Discard> <br> 
</form>

<a href="CustViewOrders.jsp">View Current Orders</a> <br>

</body>
</html>