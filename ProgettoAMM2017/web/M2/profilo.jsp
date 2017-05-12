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
                            <form id="formDatiProfilo" action="profilo.html" method="POST">
                                
                                <div> <!-- Nome utente -->
                                    <label for="userName">Nome:</label>
                                    <input <c:if test="${isUserInfoComplete == false}">class='necessaryField'</c:if> type="text" name="userName" id="userName" <c:if test="${nome != null}">value="${nome}"</c:if>>
                                </div>

                                <div> <!-- Cognome utente -->
                                    <label for="userSurname">Cognome:</label>
                                    <input <c:if test="${isUserInfoComplete == false}">class='necessaryField'</c:if> type="text" name="userSurname" id="userSurname" <c:if test="${cognome != null}">value="${cognome}"</c:if>>
                                </div>

                                <div> <!-- Immagine profilo -->
                                    <label for="profilePicURL">Url immagine profilo:</label>
                                    <input <c:if test="${isUserInfoComplete == false}">class='necessaryField'</c:if> type="url" name="profilePicURL" id="profilePicURL" <c:if test="${urlFotoProfilo != null}">value="${urlFotoProfilo}"</c:if>>
                                </div>

                                <div> <!-- Presentazione -->
                                    <label for="presentazione">Presentazione:</label>
                                    <textarea <c:if test="${isUserInfoComplete == false}">class='necessaryField'</c:if> name="presentazione" id="presentazione"><c:if test="${frasePresentazione != null}">${frasePresentazione}</c:if></textarea>
                                </div>

                                <div> <!-- Data di nascita -->
                                    <label for="bDate">Data di nascita:</label>
                                    <input type="date" name="bDate" id="bDate" <c:if test="${dataNascitaString != null}">value="${dataNascitaString}"</c:if>>
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
                                    <button type="submit" form="formDatiProfilo" name="action" value="updateInfo">Aggiorna</button>
                                    <button type="submit" form="formDatiProfilo" name="action" value="deleteAccount">Cancella account</button>
                                </div>
                            </form> 
                                
                            <c:if test="${isUserInfoComplete!=null && isUserInfoComplete == false}"> 
                                <c:set var="notificationType" value="userInfoIncompleteError" scope="request" />
                                <c:set var="notificationValue" value="userInfoIncompleteError" scope="request" />
                                <jsp:include page="notifications.jsp" />
                            </c:if>
                                
                            <c:if test="${campiModificati != null}">
                                <c:set var="notificationType" value="profileInfo" scope="request" />
                                <c:set var="notificationValue" value="updatedProfileInfo" scope="request" />
                                <c:set var="extraParameters" value="${campiModificati}" scope="request" />
                                <jsp:include page="notifications.jsp" />
                            </c:if>
                        </div> <!-- Fine form login -->
                    </div>          
                </c:when>
                    
                <c:otherwise>
                    <c:set var="notificationType" value="accessDenied" scope="request" />
                    <c:set var="notificationValue" value="accessDenied" scope="request" />
                    <jsp:include page="notifications.jsp" />
                </c:otherwise>
                    
            </c:choose>
        </div><!-- Fine divBody -->
        
        <div class="clear"></div>
    </body>
</html>
