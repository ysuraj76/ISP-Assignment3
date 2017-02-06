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

<form action=SellerViewOrderDetails.jsp method=post	>
Ship date: <input type=text name=ship_date><br>	
Carrier name: <input type=text name=carrier_name><br>	
Tracking number: <input type=text name=trk_name><br>	

<input type=submit value=Update> <br> 
</form>

 <a href="SellerManageProducts.jsp">Manage Products</a> <br>
 <a href="SellerViewCurrentOrders.jsp">Current Orders</a> <br>

</body>
</html>