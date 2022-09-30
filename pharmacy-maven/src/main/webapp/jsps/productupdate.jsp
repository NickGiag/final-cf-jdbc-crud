<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/productupdate.css">
</head>
<body>
	<div class="container">
		<div class ="center">
	        <form method="GET" action="${pageContext.request.contextPath}/update">
	            <label for="id">Product ID: </label><br>
	            <input type="text" name="id" value="${param.id}" readonly><br>
	            <label for="name">Product Name: </label><br>
	            <input type="text" name="name" value="${param.name}"><br>
	            <label for="description">Description: </label><br>
	            <input type="text" name="description" value="${param.description}"><br>
	            <label for="quantity">Quantity: </label><br>
	            <input type="number" name="quantity" value="${param.quantity}"><br>
	            <br>
	            <div class="btn" >
	            <button type="submit">Update product</button>
	            </div>
	            
	        </form>
	    </div>
	</div>
    

</body>
</html>