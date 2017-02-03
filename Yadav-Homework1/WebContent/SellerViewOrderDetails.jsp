<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action=SellerViewProduct.jsp method=post	>
<input type=submit value=View> <br> 
</form>

<form action=SellerCancelOrder.jsp method=post	>
<input type=submit value=Cancel> <br> 
</form>

 <a href="Login.jsp">LogOut</a> <br>
 <a href="SellerUpdateOrderStatus.jsp">Update Order Status</a> <br>
 <a href="SellerManageProducts.jsp">Manage Products</a> <br>
 <a href="SellerViewCurrentOrders.jsp">Current Orders</a> <br>
 <a href="SellerHomepage.jsp">Home</a> <br>

</body>
</html>