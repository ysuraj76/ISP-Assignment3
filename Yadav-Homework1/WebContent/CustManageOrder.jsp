<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="right"><a href="Login.jsp">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Details for Order# <% out.print(ph.number()); %> </h2>


<table border="2">
   <tr>
        <td>Item</td>
        <td>Quantity</td>
        <td>Price in $</td>
        <td>Seller Name</td>
        <td>Shipping Status</td>
       
   </tr>
  
   <% 
		for(int i=0; i<3; i++)
	{ 		String sta=ph.status();
			%>
				
  
           <tr><td><% out.println(ph.pdName()); %></td>
           <td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.name()); %></td>
           <td><% out.println(sta); %></td>

           <td><form action=CustViewProducts.jsp method=post	>
		   <input type=submit value=View> <br> </form></td>
		   
		   <% if(!sta.equals("Delivered")) {%>
           <td><form action=CustCancelOrder.jsp method=post	>
		   <input type=submit value=Cancel> <br></form></td></tr>
   <%		}	
       }
   %>
   </table>
   
   <b>Order Total: </b> <% out.println(ph.number());%>$<br>
   <b>Order Date: </b><%out.println(ph.date()); %><br>
   <b>Shipping Address: </b><%out.println(ph.address()); %><br>

 <a href="CustViewOrders.jsp">View Orders</a> <br>



</body>
</html>