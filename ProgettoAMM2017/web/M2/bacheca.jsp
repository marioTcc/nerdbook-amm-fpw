<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Bacheca di ${owner.nome} ${owner.cognome}</title>
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
            
            <c:choose>
                <c:when test="${sessionScope.loggedIn==true}">
                    <div id="presentazione">
                        <p>${owner.frasePresentazione}</p>
                    </div>
   

                    <div id="posts"> <!-- Sezione dei post -->
                        <c:forEach var="postTmp" items="${listaPost}">
                            <c:set var="post" value="${postTmp}" scope="request" />
                            <jsp:include page="post.jsp" />                      
                        </c:forEach>
                    </div> <!-- Chiusura sezione dei post -->
               </c:when>
                    
                <c:otherwise>
                    <c:set var="errorType" value="accessDenied" scope="request" />
                    <c:set var="errorValue" value="accessDenied" scope="request" />
                    <jsp:include page="errors.jsp" />
                </c:otherwise>
                    
            </c:choose>
        </div><!-- Fine divBody -->
        
        <div class="clear"></div>
    </body>
</html>
