<%@page import="model.PlaceHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	function getdata() {
		var quan = $("#qnty").val();

		// Sending request to servlet of the same app
		$.get("ServUpdateCart", {
			quantity : quan
		}, function(data, status) {
			if (data == -1) {
				$("#results").load("ajax/failure.html");
			}

			if (data == 1) {
				//alert("sucessful");
				$("#list").remove
				$("#results").load("ajax/success.html");

			}
		});
	}

	function updRev() {
		var rate = $("#rating").val();
		var com = $("#review").val();

		// Sending request to servlet of the same app
		$.get("ServUpdReview", {
			rating : rate,
			review : com
		}, function(data, status) {

			alert("Thanks for adding comments");
			location.reload();

		});
	}

	function updQuestion() {
		var ques = $("#question").val();

		// Sending request to servlet of the same app
		$.get("ServUpdQuestion", {
			question : ques
		}, function(data, status) {

			alert("Thanks for your Question");
			location.reload();

		});
	}
</script>
</head>
<body>

	<div id="right">
		<a href="Login.jsp">LogOut</a> <br>
	</div>
	<div id="right">
		<a href="CustHomepage.jsp">Home</a>
	</div>

	<%
		PlaceHolder ph = new PlaceHolder();
	%>

	<p id="results"></p>
	<h2>Product Details</h2>


	<table border="2">


		<tr>
			<td>Item</td>
			<td>${Prdts.name}</td>
		<tr>
			<td>Price in $</td>
			<td>${Prdts.price}</td>
		<tr>
			<td>Seller Name</td>
			<td>${Prdts.sellName}</td>
		<tr>
			<td>Available Quantity</td>
			<td>${Prdts.quantity}</td>
		<tr>
			<td>Estimated Delivery date</td>
			<td>${Prdts.shipDate}</td>
		<tr>
			<td>Product thumbnail</td>
			<td><img src="${Prdts.path}" class="img-rounded"
				alt="Cinque Terre" width="150" height="100"></td>
		<tr>
			<td>Product Description</td>
			<td>${Prdts.description}</td>
		<tr>
			<td>Average Rating</td>
			<td>${Prdts.rating}</td>
		<tr>
			<td>Customer Reviews</td>
			<td>${Prdts.review}</td>
		<tr>
			<td>Add rating: <input type=text value="5" id=rating></td>
			<td>Add review: <input type=text id=review></td>
			<td><input type="button" value="Add" onClick="updRev()"></td>
	</table>




	Quantity:
	<input type=text id=qnty>
	<input type="button" value="Add to Cart" onClick="getdata()">
	<br>

	<div id="comments">
		Question and Answers:<br>
		<c:forEach var="item" items="${QA}">
			<c:out value="${item}" />
			<br>
		</c:forEach>
		Ask Question: <input type=text id=question> <input
			type="Button" value="Submit" onClick="updQuestion()">
	</div>

	<form action=CustProductSearchResults.jsp method=post>
		<input type=submit value=Back> <br>
	</form>

	<form action=CustCheckoutCart.jsp method=post>
		<input type=submit value="Proceed for chkout"> <br>
	</form>




</body>
</html>