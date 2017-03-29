<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

</head>
<body>
<div id="right"><a href="ServLogout">LogOut</a> <br></div>
<div id="right"><a href="CustHomepage.jsp">Home</a></div>

<h2>Orders</h2>
<table border="2">
   <tr>
        <td>Name</td>
        <td>Category</td>
        <td>Seller Name</td>
        <td>Price</td>
        <td>Image</td>
       
   </tr>
 <c:forEach items="${products}" var="temp" >
				
  
           <tr><td>${temp.name}</td>
           <td>${temp.type}</td>
           <td>${temp.sellName}</td>
           <td>${temp.price}</td>
           <td><img src="${temp.path}" class="img-rounded" alt="Cinque Terre" width="150" height="100"></td>
           
           <td><form action=ServProdSearchResults method=post	>
           <input type=hidden name=ProdId value="${temp.id}">
		   <input type=submit value=View> <br> </form></td></tr>
         
    </c:forEach>
   </table>
   
   <a href="CustManageOrder.jsp">Manage Order</a>

</body>
</html>