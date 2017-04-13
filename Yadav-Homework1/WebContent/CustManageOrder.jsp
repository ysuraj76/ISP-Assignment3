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

<div id="right"><a href=ServLogout>LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Details for Order# ${SelOrder} </h2>


<table border="2">
   <tr>
        <td>Item</td>
        <td>Quantity</td>
        <td>Price in $</td>
        <td>Seller Name</td>
        <td>Shipping Status</td>
       
   </tr>
  
<c:forEach items="${Items}" var="temp" varStatus="loop">

				
  
           <tr><td>${temp.name}</td>
           <td>${temp.qnt}</td>
           <td>${temp.prd_price}</td>
           <td>${temp.seller_name}</td>
           <td>${temp.shipping}</td>

           <td><form action=ServProdSearchResults method=post	>
           <input type=hidden name=ProdId value="${temp.prd_id}">    
           <input type=submit value=View> <br> </form></td>
		   
		   <c:if test="${temp.ship_sta!= 3}">
   		
   		<td><form action=ServCancelItem method=post	>
   		<input type=hidden name=index value="${loop.count}" >
  		
   		<input type=submit value=Cancel> <br></form></td></tr>
  			
		   </c:if>           
      </c:forEach>

   </table>
   
   <b>Order Total: </b> ${Ord.totCost}<br>
   <b>Order Date: </b>${Ord.ordDate}<br>
   <b>Shipping Address: </b>${Ord.shpAdd}<br>

 <a href=ServViewOrders>View Orders</a> <br>



</body>
</html>