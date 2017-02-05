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

<h2> Edit Details </h2>


<table border="2">
   
         
   <% 
		for(int i=0; i<1; i++)
	{ 		String sta=ph.status();
			%>
				
  	       <tr><td>Item</td>
           <td><% out.println(ph.pdName()); %></td>
           <td><form action="SellerEditProducts.jsp" method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Category</td>
           <td><% out.println(ph.category()); %></td>
           <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Price in $</td>
           <td><% out.println(ph.number()); %></td>
           <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Shipping time</td>
		   <td><% out.println(ph.number()); %></td>        
           <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Product thumbnail</td>
           <td><img src="<% out.println(ph.image()); %>" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Item left</td>
		   <td><% out.println(ph.number()); %></td>
           <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Product Description</td>
		   <td><% out.println("Add Description"); %></td>
           <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
		   
		   <tr><td>Question and Answers</td>
		   <td><% out.println("Add Q&A"); %></td>
		   <td><form action="SellerEditProducts.jsp " method=post	>
		   <input type=submit value=Edit> <br> </form></tr></td>
           
		   
		  <%	
       }
   %>
   </table>

<form action=SellerManageProducts.jsp method=post	>
<input type=submit value=Save> <br> 
</form>

<form action=SellerManageProducts.jsp method=post	>
<input type=submit value=Cancel> <br> 
</form>

 <a href="Login.jsp">LogOut</a> <br>
 <a href="SellerHomepage.jsp">Home</a> <br>

</body>
</html>