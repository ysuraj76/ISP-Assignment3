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

<h2> Add a new product </h2>
<form action=ServProducts method=post>

Name: <input type=text name=name required> <br>
Product Type:
<select name="product">
    <option value="Home">Home & Decor</option>
    <option value="Mens">Mens Aparel</option>
    <option value="Womens">Womens Apparel</option>
    <option value="Child">Children</option>
  </select><br>
Product Image/Video: <input type=text name=path><br>
Product Description: <input type=text name=description><br>
Estimated Shipping time: <input type=text name=shipping required><br>
No. of items: <input type=text name=items required><br>
Price: <input type=text name=price required><br>
  
<input type=submit value=Save> <br>
</form>

<form action=SellerManageProducts.jsp method=post	>
<input type=submit value=Cancel> <br> 
</form>


</body>
</html>