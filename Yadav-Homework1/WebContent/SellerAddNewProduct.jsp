<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=ServProducts method=post	>

Name: <input type=text name=name><br>
Product Type:
<select name="product">
    <option value="Home">Home & Decor</option>
    <option value="Mens">Mens Aparel</option>
    <option value="Womens">Womens Apparel</option>
    <option value="Child">Children</option>
  </select><br>
Product Image/Video: <input type=text name=path><br>
Product Description: <input type=text name=description><br>
Estimated Shipping time: <input type=text name=shipping><br>
No. of items: <input type=text name=items><br>
Price: <input type=text name=price><br>
  
<input type=submit value=Save> <br>
</form>
<a href="SellerManageProducts.jsp">Cancel</a> <br></head>


</body>
</html>