<%
if(request.getSession().getAttribute("username")==null){
	response.sendRedirect("Login.jsp");
}
%>




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Note Application</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/dashboard.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="">
        <form action="noteController" method="post"> 
            <input type="text" class="search-bar" placeholder="Search Notes" name="search" required>
            <button type="submit" class="search-btn" name="action" value="search">Search</button>
		</form>
             
            <div class="row">
                <div class="note">
                 <form method="post" action="noteController">
                   		<input class="title"  placeholder="Title" name="title" required>
                    	<input class="content" placeholder="Take a note..." name="content" required>
                    	<button type="submit" class="btn" name="action" value="insert">Create</button>
                </form>
                </div>
               </div>
                 <h1 class="heading">Notes</h1>
               <div class="row">
                <c:forEach var="note" items="${list}">
                <form action="noteController" method="post">
                 <div class="note">
                 	<input type="hidden" name="id" value="${note.id}">
                 	
			        <input class="title"  placeholder="Title" value="${note.title}" name="updatedTitle">
			        
			        <input class="content"  placeholder="Take a note..." value="${note.content}" name="updatesContent">
			        
			        <div class="btn-div">
			            <button type="submit" class="mod-btn"  name="action" value="edit">Edit</button>
			            <button type="submit" class="mod-btn"  name="action" value="delete">Delete</button>
			        </div>
    				
    				</div>
    				</form>
                </c:forEach>
                
            </div>
        </div>
    </div>
</body>

</html>
