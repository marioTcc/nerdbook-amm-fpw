<%-- 
    Document   : errors
    Created on : 23-apr-2017, 18.43.06
    Author     : Mario Taccori
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<c:choose>
    <c:when test="${notificationType == 'loginError' && notificationValue=='wrongCredentials'}">
        <div class="notificationDiv">
            <p>Nome utente e/o Password errati, riprovare.</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'loginError' && notificationValue=='emptyField'}">
        <div class="notificationDiv">
            <p>Per favore, compilare tutti i campi.</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'loginError' && notificationValue=='sessionExpired'}">
        <div class="notificationDiv">
            <p>Sei stato disconnesso.</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'accessDenied' && notificationValue=='accessDenied'}">
        <div class="notificationDiv">
            <p>Accesso negato. Per favore, effettuare il login.</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'userInfoIncompleteError' && notificationValue=='userInfoIncompleteError'}">
        <div class="notificationDiv">
            <p>I campi in rosso sono obbligatori</p>
        </div>
    </c:when>
    
    <c:when test="${notificationType == 'profileInfo' && notificationValue=='updatedProfileInfo'}">
        <div class="notificationDiv">
            <p>I seguenti campi sono stati aggiornati:</p>
            <ul class="notificationList">
                <c:forEach var="tmp" items="${campiModificati}">
                    <li>${tmp}</li>
                </c:forEach>
            </ul>
        </div>
    </c:when>
</c:choose>