<%@page import="model.PlaceHolder"%>
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
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Product Details </h2>


<table border="2">
   
   		 <tr><td>Item</td>
   		 <td>Quantity</td>
   		 <td>Total Price in $</td>
         <td>Seller Name</td>
   	
   <% 
		for(int i=0; i<3; i++)
	{ 		String sta=ph.status();
			%>
				
  	       
  	       
           <tr><td><% out.println(ph.pdName()); %></td>
          <td><% out.println(ph.number()); %></td>
		   <td><% out.println(ph.number()); %></td>
         
           <td><% out.println(ph.name()); %></td>
           
		 	   
		  <%	
       }
   %>
   </table>
   
 
 
 <form action=CustTransactionConfirmation.jsp method=post	>

Account Holders Details<br>

First Name: <input type=text name=name><br>
Last Name: <input type=text name=name><br>

Card Type:
<select name="card">
    <option value="Mastercard">Mastercard</option>
    <option value="Visa">Visa</option>
    <option value="Discover">Discover</option>
  </select><br>
  
Card Number: <input type=text name=path><br>
CVV: <input type=text name=description><br>
Month <select name="month">
    <option value="Jan">Jan</option>
    <option value="Feb">Feb</option>
    <option value="Mar">Mar</option>
    <option value="Apr">Apr</option>
    <option value="May">May</option>
    <option value="Jun">Jun</option>
    <option value="July">July</option>
    <option value="Aug">Aug</option>
    <option value="Sep">Sep</option>
    <option value="Oct">Oct</option>
    <option value="Nov">Nov</option>
    <option value="Dec">Dec</option>
  </select>
  Year <select name="month">
    <option value="2017">2017</option>
    <option value="2018">2018</option>
    <option value="2019">2019</option>
    <option value="2020">2020</option>
    
  </select><br>
Billing Address: <input type=text name=Billing><br>
Shipping Address: <input type=text name=Shipping><br>
Price: <input type=text name=price><br>
  
<input type=submit value=Confirm> <br>
</form>

<form action=CustCheckoutCart.jsp method=post	>
<input type=submit value="Cancel"> <br> 
</form>

<a href="CustViewOrders.jsp">View Orders</a>
</body>
</html>