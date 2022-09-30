<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful insertion!</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/productinserted.css">
</head>
<body>

	<div class="container">
		<div class="center">
			<h1>Product inserted successfully</h1>
			<div>
				<p>Product Name: ${insertedproduct.name}</p>
				<p>Product Description: ${insertedproduct.description}</p>
				<p>Quantity: ${insertedproduct.quantity}</p>
			</div>
			<a href="${pageContext.request.contextPath}/jsps/productsmenu.jsp">Back to menu</a>
		</div>
	</div>
	
	
</body>
</html>