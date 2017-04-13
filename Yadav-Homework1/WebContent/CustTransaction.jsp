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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	function bankVerification() {
		var name= $("#name").val();
		var type = $("#type").val();
		var no = $("#no").val();
		var cvv = $("#cvv").val();
		var expDate = $("#expDate").val();
		var total= $("#total").val();
		
		// Sending request to servlet of the same app
		$.get("../Bank/ServBanking", {
			name : name, type:type, cardNo:no, cvv:cvv,expDate: expDate, total:total
		}, function(data, status) {
			if (data.trim()=="Successful transaction") {
				placeOrder();
			}
		
			else{
				console.log(data);
				alert(data);
				

			}
		});
	}
		
		function placeOrder() {
						
			var no = $("#no").val();
			var bill = $("#bill").val();
			var ship = $("#ship").val();
			var mess= "Successful transaction";
			
		$.get("ServTransactionConfirmation", {
			message:mess, card:no, Billing:bill, Shipping:ship }, function(data, status){
				//load("CustTransactionConfirmation.jsp");
				window.location.replace('CustTransactionConfirmation.jsp');
			}
			);
		
		//$("#results").load("ajax/failure.html");
	}
</script>

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
<h2>Total Cost: ${SumCart}</h2>
<input type="hidden" id="total" value="${SumCart}"><br>
  
 
 


Account Holders Details<br>

Name: <input type=text id="name" name=name><br>

Card Type:
<select name="card-type" id="type">
    <option value="Mastercard">Mastercard</option>
    <option value="Visa">Visa</option>
    <option value="Discover">Discover</option>
  </select><br>
  
Card Number: <input type=text id="no" name=card required><br>
CVV: <input type=text id="cvv" name=cvv required><br>

Expiration date: <input type=text id="expDate" name=expDate required><br>


Billing Address: <input type=text name=Billing><br>
Shipping Address: <input type=text name=Shipping><br>
  
<input type=submit value=Confirm onClick="bankVerification()"> <br>


<form >
<input type=submit value="Cancel" > <br> 
</form>



<a href="CustViewOrders.jsp">View Orders</a>
</body>
</html>