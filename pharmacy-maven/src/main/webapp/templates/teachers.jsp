<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teachers Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/teachersmenu.css">

    <style>
        table, th, td {
            margin: 0 auto;
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>

    <div class="center">
        
        <div class="search-wrapper">
	        <div class="bot-gap">
	            <span class="title">Teachers Search</span>
	        </div>
	        <div class="bot-gap">
	            <!-- <form> -->
	                <input id="searchInput" type="text" class="search rounded" 
                            placeholder="Insert teacher's lastname" autofocus/>
	                <br><br>
	                <button id="btn" class="search-btn rounded color-btn" type="button">Search</button>
	            <!-- </form> -->
	        </div>
        </div>
     
        <h1>List of Teachers</h1>
        <p class="testp"></p>   
        <table class="teachers-list">

        </table>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/teachers.js"></script>
    
</body>
</html>