<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacy Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
</head>
<body>
    <div class="container-fluid">
        <div class="header">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/static/img/pharmacy-logo.jpg" alt="pharmacy logo">
            </div>
            
            <div class="menu">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Products</a></li>
                    <li><a href="#">Selling Points</a></li>
                    <li><a href="${pageContext.request.contextPath}/jsps/login.jsp">Login</a></li>
                </ul>
            </div>
        </div>

        <div class="slider">
            <div class="title"><p>Saving lives one prescription at a time.</p></div>
            <div class="subtitle"><p>Find every health-care product you need right here!</p></div>
            
        </div>

        <div class="main">
        	
            <img src="${pageContext.request.contextPath}/static/img/pills.jpg" alt="a picture of pills">
            <div class="main-para">
            	<div class="main-title">
                <h1>Your neighborhood Doctor</h1>
            </div>
            <div class="main-text">
                <p>Welcome to your local Pharmacy store! Here you will find all the medicine you need.
                Working from 1980 we serve our costumers with care and the medicine they need.</p>
            </div>
            </div>
            
           
        </div>

        <div class="footer">
            <div class="copyright"> 
                <p>&copy; Company,  
                    All rights reserved</p>
            </div>
            <div class="social"> 
                <p class="follow-us">Follow us:</p> 
                <i class="fab fa-facebook-square"></i>
                <i class="fab fa-twitter-square"></i>
            </div>
        </div>
    </div>

    
</body>
</html>
