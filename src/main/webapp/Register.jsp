<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css\register.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="form-group"> 
                    <form method="post" action="Register">   
                        <h2 class="sign-up-title">Sign up</h2>
                        <div class="input-group">
                            <!-- <label for="username">Username:</label> -->
                            <input type="text" id="username" name="username" placeholder="Username" required>
                        </div>
                        <div class="input-group">
                            <!-- <label for="password">Password:</label> -->
                            <input type="password" id="password" name="password" placeholder="Password" required>
                        </div>
                         <div class="input-group">
                            <!-- <label for="firstname">FirstName:</label> -->
                            <input type="text" id="firstName" name="firstname" placeholder="First Name" required>
                        </div>
                        
                         <div class="input-group">
                            <!-- <label for="lastname">LastName:</label> -->
                            <input type="text" id="lastName" name="lastname" placeholder="Last Name" required>
                        </div>
                        
                        <button type="submit" class="sign-up-btn">Register</button>
                    </form>
                </div>
                <img src="asset\Sign up-rafiki.png" height="55%" width="55%">
            </div>
        </div>
            <script src="" async defer></script>
    </body>
</html>