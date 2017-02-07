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
           <td>Product thumbnail</td>
           <td>Seller Name</td>
           <td>Quantity</td>
		   <td>Total Price in $</td>
           <td>Estimated Delivery date</td></tr>
         
   <% 
		for(int i=0; i<3; i++)
	{ 		String sta=ph.status();
			%>
				
  	       
  	       
           <tr><td><% out.println(ph.pdName()); %></td>
          
           <td><img src="<% out.println(ph.image()); %>" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           
           <td><% out.println(ph.name()); %></td>
           
		   <td><% out.println(ph.number()); %></td>
		   
           <td><% out.println(ph.number()); %></td>
                   
           
		   <td><% out.println(ph.date()); %></td>  
		   
		    <td><form action=CustCheckoutCart.jsp method=post	>
		   <input type=submit value=Delete> <br> </form></td></tr>
		                    
		   
		  <%	
       }
   %>
   </table>

<form action=CustTransaction.jsp method=post	>
<input type=submit value="Check Out"> <br> 
</form><br>


Total Cost: <% out.println(ph.number()); %> $


</body>
</html>