<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Deleted!</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/productdeleted.css">
<body>

    <div class="container">
        <div class="center">
        	<p>Producted is deleted successfully!</p>
            <p>Product ID: ${product.id}</p>
            <p>Product Name: ${product.name}</p>
            <p>Product Description: ${product.description}</p>
            <p>Quantity: ${product.quantity}</p>
            <a href="${pageContext.request.contextPath}/jsps/productsmenu.jsp">Back to menu</a>

        </div>
    </div>
    
</body>
</html>