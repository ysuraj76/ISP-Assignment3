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

<% PlaceHolder ph = new PlaceHolder(); %>

<h2> Products Sold </h2>


<table border="2">
   <tr>
        <td>Item</td>
        <td>Category</td>
        <td>Price in $</td>
        <td>Product thumbnail</td>
        <td>Total purchases$</td>
        <td>Item left</td>
       
   </tr>
  
   <% 
		for(int i=0; i<3; i++)
	{ 		String sta=ph.status();
			%>
				
  
           <tr><td><% out.println(ph.pdName()); %></td>
           <td><% out.println(ph.category()); %></td>
           <td><% out.println(ph.number()); %></td>
           <td><img src="<% out.println(ph.image()); %>" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           <td><% out.println(ph.number()); %></td>
           <td><% out.println(ph.number()); %></td>

           <td><form action=SellerEditProducts.jsp method=post	>
		   <input type=submit value=Edit> <br> </form></td>
		   
		  <%	
       }
   %>
   </table>

<form action=SellerAddNewProduct.jsp method=post	>
<input type=submit value="New Product"> <br> 
</form>


</body>
</html>