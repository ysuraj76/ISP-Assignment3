<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<title>Insert title here</title>
</head>
<body>

<div id="right"><a href="ServLogout">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<% PlaceHolder ph = new PlaceHolder(); %>
<c:set var="id" scope="session" value="${Index}"/>

<h2> The Product '${Items.get(id).name}' in the Order# ${Ord.id} has been cancelled</h2>

<b>Amount to be refunded: $</b>${total}<br>

<a href="ServViewOrders">View Current Orders</a> <br>

</body>
</html>