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
<div id="right"><a href="SellerHomepage.jsp">Home</a></div>

<h2>Orders</h2>
<table border="2">
   <tr>
        <td>Order#</td>
        <td>Ordered Date</td>
        <td>Order Status</td>
       
   </tr>
  
   <%
 		PlaceHolder ph = new PlaceHolder();
		for(int i=0; i<3; i++)
	{ 
			%>
				
  
           <tr><td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.date()); %></td>
           <td><% out.println(ph.status()); %></td>
           <td><form action=SellerViewOrderDetails.jsp method=post	>
		   <input type=submit value=View> <br> </form></td></tr>
         
   <%
       }
   %>
   </table>

 <a href="SellerManageProducts.jsp">Manage Products</a> <br>


</body>
</html>