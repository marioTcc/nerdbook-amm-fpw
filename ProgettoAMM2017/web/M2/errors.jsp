<%-- 
    Document   : errors
    Created on : 23-apr-2017, 18.43.06
    Author     : Mario Taccori
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<c:choose>
    <c:when test="${errorType == 'loginError' && errorValue=='wrongCredentials'}">
        <div class="errorDiv">
            <p>Nome utente e/o Password errati, riprovare.</p>
        </div>
    </c:when>
    
    <c:when test="${errorType == 'loginError' && errorValue=='emptyField'}">
        <div class="errorDiv">
            <p>Per favore, compilare tutti i campi.</p>
        </div>
    </c:when>
    
    <c:when test="${errorType == 'loginError' && errorValue=='loggedOut'}">
        <div class="errorDiv">
            <p>Sei stato disconnesso.</p>
        </div>
    </c:when>
    
    <c:when test="${errorType == 'accessDenied' && errorValue=='accessDenied'}">
        <div class="errorDiv">
            <p>Accesso negato. Per favore, effettuare il login.</p>
        </div>
    </c:when>
    
</c:choose>