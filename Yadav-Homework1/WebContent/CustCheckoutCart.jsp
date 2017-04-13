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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	function cancelItem() {
		var id = $("#DelProdId").val();

		// Sending request to servlet of the same app
		$.get("ServCancelItem", {
			index : id
		}, function(data, status) {
			alert("Item Removed");
			location.reload();
					});
	}
	</script>
</head>
<body>
<div id="right"><a href=ServLogout>LogOut</a> <br></div>
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
		   
		    
           <td><input type=hidden id="DelProdId" value="${loop.count}"></td>    
		  <td> <input type=submit value=Delete onClick="cancelItem()"> <br> </td></tr>
		                    
		</c:forEach>   
	
   </table>
Total Cost: ${SumCart} 

<form action=CustTransaction.jsp method=post	>
<input type=submit value="Check Out"> <br> 
</form><br>





</body>
</html>