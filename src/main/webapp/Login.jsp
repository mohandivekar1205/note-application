<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Note Application</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/login.css">
        <link
        href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
    </head>
    <body>
        <div class="background">
        </div>
        <div class="container">
        <div class="login-image">
            <img src="asset\Login-rafiki.png" height="100%" width="100%">
        </div>
        
        <div class="form-group">
            <form method="post" action="Login">   
                <h2 class="title">Welcome Back!</h2>
                <h3 class="sub-title">Login to Continue</h3>
                <div class="input-group">
                    <!-- <label for="username">Username:</label> -->
                    <input type="text" id="username" name="username" placeholder="Username" required>
                </div>
                <div class="input-group">
                    <!-- <label for="password">Password:</label> -->
                    <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit">Login</button>
            </form>
            <hr>
            <a href="Register.jsp">Create New Account</a>
        </div>
        </div>
        <script src="" async defer></script>
    </body>
</html>