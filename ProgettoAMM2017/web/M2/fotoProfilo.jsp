<%-- 
    Document   : fotoProfilo
    Created on : 22-apr-2017, 10.04.29
    Author     : Mario Taccori
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<img alt="foto profilo" src=
     <c:choose>
         <c:when test="${sessionScope.user.urlFotoProfilo != ''}">
            "${sessionScope.user.urlFotoProfilo}"
         </c:when>

         <c:otherwise>
            "Assets/ICONS/noProfilePic_icona.svg" class="defaultPic"
         </c:otherwise>
    </c:choose>/>