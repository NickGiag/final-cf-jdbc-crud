<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/products.css">
</head>
<body>
	
	<div class="container">
		<div class="center">
        <table>

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>

            <c:forEach var = "product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.quantity}</td>
                    <td><a class="del" href="${pageContext.request.contextPath}/delete?id=${product.id}&name=${product.name}&description=${product.description}&quantity=${product.quantity}">Delete</a></td>
                    <td><a class="upd" href="${pageContext.request.contextPath}/jsps/productupdate.jsp?id=${product.id}&name=${product.name}&description=${product.description}&quantity=${product.quantity}">Update</a></td>
                </tr>
            </c:forEach>

        </table>

    </div>
	</div>
    

    <div>
        <c:if test="${deleteAPIError}">
            <p>Something went wrong with Delete</p>
        </c:if>  
    </div>

    <div>
        <c:if test="${updateAPIError}">
            <p>Something went wrong with Update</p>
        </c:if>  
    </div>


</body>
</html>