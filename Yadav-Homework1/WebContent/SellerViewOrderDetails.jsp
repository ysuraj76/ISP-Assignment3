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
<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Details for Order# <% out.print(ph.number()); %> </h2>


<table border="2">
   <tr>
        <td>Item</td>
        <td>Quantity</td>
        <td>Price in $</td>
        <td>Shipping Status</td>
       
   </tr>
  
   <% 
		for(int i=0; i<3; i++)
	{ 		String sta=ph.status();
			%>
				
  
           <tr><td><% out.println(ph.pdName()); %></td>
           <td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.number()); %></td>
           <td><% out.println(sta); %></td>

           <td><form action=SellerViewProduct.jsp method=post	>
		   <input type=submit value=View> <br> </form></td>
		   
		   <% if(!sta.equals("Delivered")) {%>
           <td><form action=SellerCancelOrder.jsp method=post	>
		   <input type=submit value=Cancel> <br></form></td></tr>
   <%		}	
       }
   %>
   </table>
   
   <b>Order Total: </b> <% out.println(ph.number());%>$<br>
   <b>Order Date: </b><%out.println(ph.date()); %><br>
   <b>Customer Name: </b><%out.println(ph.name()); %><br>
   <b>Shipping Address: </b><%out.println(ph.address()); %><br>
   <b>Billing Address: </b><%out.println(ph.address()); %><br>
   <b>Order Status: </b><%out.println(ph.status()); %><br><br>



 <a href="Login.jsp">LogOut</a> <br>
 <a href="SellerUpdateOrderStatus.jsp">Update Order Status</a> <br>
 <a href="SellerManageProducts.jsp">Manage Products</a> <br>
 <a href="SellerViewCurrentOrders.jsp">Current Orders</a> <br>
 <a href="SellerHomepage.jsp">Home</a> <br>

</body>
</html>