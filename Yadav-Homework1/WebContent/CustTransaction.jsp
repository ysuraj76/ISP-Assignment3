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
           <td>Product thumbnail</td>
           <td>Seller Name</td>
           <td>Quantity</td>
		   <td>Total Price in $</td>
           <td>Estimated Delivery date</td></tr>
         
  
				
 <c:forEach items="${Cart}" var="temp" varStatus="loop">
  	       
  	       
           <tr><td>${temp.name}</td>
          
           <td><img src="${temp.path}" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           
           <td>${temp.sellName}</td>
           
		   <td>${temp.reqQuantity}</td>
		   
           <td>${temp.totalAmount}</td>
                   
           
		   <td>${temp.shipDate}</td>  
		   
		    
		                    
		</c:forEach>   
	
   </table>
Total Cost: ${SumCart} 
   
 
 
 <form action=ServTransactionConfirmation method=post	>

Account Holders Details<br>

Name: <input type=text name=name><br>

Card Type:
<select name="card-type">
    <option value="Mastercard">Mastercard</option>
    <option value="Visa">Visa</option>
    <option value="Discover">Discover</option>
  </select><br>
  
Card Number: <input type=text name=card><br>
CVV: <input type=text name=cvv><br>

Expiration date: <input type=text name=expDate><br>

    
  </select><br>
Billing Address: <input type=text name=Billing><br>
Shipping Address: <input type=text name=Shipping><br>
  
<input type=submit value=Confirm> <br>
</form>

<form action=CustCheckoutCart.jsp method=post	>
<input type=submit value="Cancel"> <br> 
</form>

<a href="CustViewOrders.jsp">View Orders</a>
</body>
</html>