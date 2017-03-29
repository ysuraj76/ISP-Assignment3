<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

</head>
<body>

<div id="right"><a href="Login.jsp">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Product Details </h2>


<table border="2">
   
         				
  	       <tr><td>Item</td>
           <td>${Prdts.name}</td>
          
		   <tr><td>Price in $</td>
           <td>${Prdts.price}</td>
           
           <tr><td>Seller Name</td>
           <td>${Prdts.sellName}</td>
           
           <tr><td>Available Quantity</td>
		   <td>${Prdts.quantity}</td>        
           
           <tr><td>Estimated Delivery date</td>
		   <td>${Prdts.shipDate}</td>  
		   
		   <tr><td>Product thumbnail</td>
           <td><img src="${Prdts.path}" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           
		   <tr><td>Product Description</td>
		   <td>${Prdts.description}</td>
           
		      
		   <tr><td>Review Date</td>
		   <td>${Prdts.revDate}</td>
		   
		   <tr><td>Customer Rating</td>
		   <td>${Prdts.rating}</td>
		   
		   <tr><td>Customer Review</td>
		   <td>${Prdts.review}</td>
		   
                   
		   
 
   </table>

<form action=ServUpdateCart method=post	>
Quantity: <input type=text name=qnty>
<input type=submit value="Add to cart"> <br> 
</form>

<form action=CustProductSearchResults.jsp method=post	>
<input type=submit value=Back> <br> 
</form>


</body>
</html>