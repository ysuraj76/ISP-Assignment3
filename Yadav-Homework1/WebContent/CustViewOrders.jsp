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
<div id="right"><a href="Login.jsp">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<h2>Orders</h2>
<table border="2">
   <tr>
        <td>Order#</td>
        <td>Order Total</td>
        <td>Order Date</td>
       
   </tr>
  
<c:forEach items="${Orders}" var="temp" varStatus="loop">
				
  
           <tr><td>${temp.id}</td>
           <td>${temp.totCost}</td>
           <td>${temp.ordDate}</td>
           <td><form action=ServManageOrders method=post	>
           <input type=hidden name=OrderId value="${temp.id}">
           <input type=hidden name=OrderIndex value="${loop.count}" >
           <input type=submit value=View> <br> </form></td></tr>
        
    </c:forEach>

   </table>


</body>
</html>