<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook - Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mario Taccori">
        <meta name="keywords" content="NerdBook login social network">
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen">
    </head>
    
    <body>
        
        <div id="divBodyLogin">
                     
            <div id="loginFormDiv"> <!-- Contenitore form di login -->
                <div>
                    <img src="Assets/ICONS/NerdBook_logo.svg" width="54" height="44" alt="Logo del social network" />
                    <h1> NerdBook </h1>
                </div>
                <form id="loginForm" method="post" action="login.html?action=login">
                    <div>
                        <label for="username">Nome utente:</label>
                        <input type="text" name="username" id="username">
                    </div>
                    <div>
                        <label for="password">Password:</label>
                        <input type="password" name="password" id="password">
                    </div>
                    <div>
                        <button type="submit">Accedi</button>
                    </div>
                </form>
                
                <c:set var="notificationType" value="loginError" scope="request" />
                <c:set var="notificationValue" value="${loginError}" scope="request" />
                <jsp:include page="notifications.jsp" />
                
            </div> <!-- Fine form di login -->
                        
        </div>
    </body>
</html>
