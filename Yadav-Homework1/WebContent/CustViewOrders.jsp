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

<h2>Orders</h2>
<table border="2">
   <tr>
        <td>Order#</td>
        <td>Order Total</td>
        <td>Order Date</td>
       
   </tr>
  
   <%
 		PlaceHolder ph = new PlaceHolder();
		for(int i=0; i<3; i++)
	{ 
			%>
				
  
           <tr><td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.date()); %></td>
           <td><form action=CustManageOrder.jsp method=post	>
		   <input type=submit value=View> <br> </form></td></tr>
         
   <%
       }
   %>
   </table>


</body>
</html>