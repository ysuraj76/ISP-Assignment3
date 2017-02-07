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
   
         
   <% 
		for(int i=0; i<1; i++)
	{ 		String sta=ph.status();
			%>
				
  	       <tr><td>Item</td>
           <td><% out.println(ph.pdName()); %></td>
          
		   <tr><td>Price in $</td>
           <td><% out.println(ph.number()); %></td>
           
           <tr><td>Seller Name</td>
           <td><% out.println(ph.name()); %></td>
           
           <tr><td>Available Quantity</td>
		   <td><% out.println(ph.number()); %></td>        
           
           <tr><td>Estimated Delivery date</td>
		   <td><% out.println(ph.date()); %></td>  
		   
		   <tr><td>Product thumbnail</td>
           <td><img src="<% out.println(ph.image()); %>" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           
		   <tr><td>Product Description</td>
		   <td><% out.println("Best in performance"); %></td>
           
		   <tr><td>Question and Answers</td>
		   <td><% out.println("Add Q&A"); %></td>
		   
		   <tr><td>Overall Rating</td>
		   <td><% out.println(ph.number()); %></td>
		   
		   <tr><td>Customer Name</td>
           <td><% out.println(ph.name()); %></td>
           
           <tr><td>Review Date</td>
		   <td><% out.println(ph.date()); %></td>
		   
		   <tr><td>Customer Rating</td>
		   <td><% out.println(ph.number()); %></td>
		   
		   <tr><td>Customer Review</td>
		   <td><% out.println("Best Product"); %></td>
		   
                   
		   
		  <%	
       }
   %>
   </table>

<form action=CustCheckoutCart.jsp method=post	>
<input type=submit value="Add to cart"> <br> 
</form>

<form action=CustProductSearchResults.jsp method=post	>
<input type=submit value=Back> <br> 
</form>


</body>
</html>