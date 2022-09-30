<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/productsmenu.css">
</head>
<body>
    <div class="center m-top">
        
        <div class="search-wrapper">
	        <div class="bot-gap">
	            <span class="title">Products Search</span>
	        </div>
	        <div class="bot-gap">
	            <form method="GET" action="${pageContext.request.contextPath}/search">
	                <input name="name" type="text" class="search rounded" placeholder="Insert products's name" autofocus/>
	                <br><br>
	                <button class="search-btn rounded color-btn" type="submit">Search</button>
	            </form>
	        </div>
        </div>
        
        <div class="insert-wrapper">
	        <div class="bot-gap">
	            <span class="title">Products Insert</span>
	        </div>
	        <div class="bot-gap">
	            <form method="POST" action="${pageContext.request.contextPath}/insert">
	                <input name="name" type="text" class="insert rounded" placeholder="Product name" autofocus/><br>
	                <input name="description" type="text" class="insert rounded" placeholder="Product's description"/><br>
	               	<input name="quantity" type="number" class="insert rounded" placeholder="Quantity"/><br>
	                <br>
	                <button class="search-btn rounded color-btn" type="submit">Insert</button>
	            </form>
	        </div>
        </div>     
    </div>
    
    <c:if test="${sqlError}">
	    <div class="center error">
	   		<span>Error in insert. Please try again</span>
	    </div>
    </c:if>
    
    <c:if test="${emptyFields}">
	    <div class="center error">
	   		<span>All fields should be filled correctly.</span>
	    </div>
    </c:if>
    
    <c:if test="${productsNotFound}">
	     <div class="center error">
	   		<span>No products found</span>
	    </div>
    </c:if>
    
    <div>
    	<a class="home-btn" href="${pageContext.request.contextPath}/index.jsp">Home</a>
    </div>
</body>
</html>
        
    