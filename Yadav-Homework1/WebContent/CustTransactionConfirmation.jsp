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

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Transaction Successful </h2>



<table border="2">
   
   		 <tr><td>Item</td>
   		 <td>Quantity</td>
   		 <td>Total Price in $</td>
         <td>Seller Name</td>
   	
 <c:forEach items="${Items}" var="temp">

				
  	       
  	       
           <tr><td>${temp.name}</td>
          <td>${temp.qnt}</td>
		   <td>${temp.prd_price }</td>
		   
         
           <td>${temp.seller_name}</td>
           
		 	   
    </c:forEach>
   </table>
      <a href="CustTransactionConfirmation.jsp">Print</a>
   
   
   
   
   
   <a href="CustViewOrders.jsp">View Orders</a>
   
</body>
</html>