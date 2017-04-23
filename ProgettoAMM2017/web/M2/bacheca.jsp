<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook - Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mario Taccori">
        <meta name="keywords" content="NerdBook bacheca social network">
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen">
    </head>
    <body>
        
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="headerBar.jsp"/>
        
        <jsp:include page="sideBar.jsp"/>
        
        <div id="divBody">
            
            <div id="presentazione">
                <p>${sessionScope.user.frasePresentazione}</p>
            </div>
                     
            <div id="posts"> <!-- Sezione dei post -->
                <c:forEach var="postTmp" items="${listaPost}">
                    <c:set var="post" value="${postTmp}" scope="request" />
                    <jsp:include page="post.jsp" />                      
                </c:forEach>
            </div> <!-- Chiusura sezione dei post -->
        </div><!-- Fine divBody -->
        
        <div class="clear"></div>
    </body>
</html>
