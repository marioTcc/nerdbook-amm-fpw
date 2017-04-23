<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook - Modifica profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mario Taccori">
        <meta name="keywords" content="NerdBook profilo social network">
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen">
    </head>
    <body>
        
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="headerBar.jsp"/>                
        <jsp:include page="sideBar.jsp"/>
                  
        <div id="divBody">
            
            <c:choose>
                <c:when test="${sessionScope.loggedIn==true}">
                    <div>

                        <div id="profilePic">
                            <c:set var="picSubject" value="self" scope="request" />
                            <jsp:include page="fotoProfilo.jsp" />
                        </div>

                        <div id="divForm"> <!-- Form dati profilo -->
                            <form id="formDatiProfilo" action="#" method="post">

                                <div> <!-- Nome utente -->
                                    <label for="userName">Nome:</label>
                                    <input type="text" name="userName" id="userName">
                                </div>

                                <div> <!-- Cognome utente -->
                                    <label for="userName">Cognome:</label>
                                    <input type="text" name="userSurname" id="userSurname">
                                </div>

                                <div> <!-- Immagine profilo -->
                                    <label for="profilePicURL">Url immagine profilo:</label>
                                    <input type="url" name="profilePicURL" id="profilePicURL">
                                </div>

                                <div> <!-- Presentazione -->
                                    <label for="presentazione">Presentazione:</label>
                                    <textarea name="presentazione" id="presentazione"></textarea>
                                </div>

                                <div> <!-- Data di nascita -->
                                    <label for="bDate">Data di nascita:</label>
                                    <input type="date" name="bDate" id="bDate">
                                </div>

                                <div> <!-- Password -->
                                    <label for="password">Password:</label>
                                    <input type="password" name="password" id="password">
                                </div>

                                <div> <!-- Conferma password -->
                                    <label for="passwordConfirm">Conferma password:</label>
                                    <input type="password" name="passwordConfirm" id="passwordConfirm">
                                </div>

                                <div>
                                    <button type="submit" form="formDatiProfilo">Aggiorna</button>
                                </div>
                            </form> 
                        </div> <!-- Fine form login -->
                    </div>
                        
                        
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
