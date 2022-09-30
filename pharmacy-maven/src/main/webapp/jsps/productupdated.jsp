<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Updated!</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/productupdated.css">
</head>
<body>

    <div class="container">
        <div class="center">
            <h1>New Product attributes: </h1>
            <p>Product Name: ${product.name}</p>
            <p>Product Description: ${product.description}</p>
            <p>Quantity: ${product.quantity}</p>
            <div>
            	<a href="${pageContext.request.contextPath}/jsps/productsmenu.jsp">Back to menu</a>
            </div>
           	
        </div>
    </div>
    
</body>
</html>