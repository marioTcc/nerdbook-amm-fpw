<%-- 
    Document   : fotoProfilo
    Created on : 22-apr-2017, 10.04.29
    Author     : Mario Taccori
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<c:choose>
    <c:when test="${picSubject=='self'}">
        <img alt="foto profilo" src=
                        <c:choose>
                            <c:when test="${sessionScope.user.urlFotoProfilo != ''}">
                               "${sessionScope.user.urlFotoProfilo}"
                            </c:when>

                            <c:otherwise>
                               "Assets/ICONS/noProfilePic_icona.svg" class="defaultPic"
                            </c:otherwise>
                       </c:choose>/>
    </c:when>
    
    <c:when test="${picSubject=='postAuthor'}">
        <img alt="foto profilo" src=
                <c:choose>
                    <c:when test="${post.autorePost.urlFotoProfilo != ''}">
                       "${post.autorePost.urlFotoProfilo}"
                    </c:when>

                    <c:otherwise>
                       "Assets/ICONS/noProfilePic_icona.svg" class="defaultPic"
                    </c:otherwise>
               </c:choose>/>
    </c:when>
                       
</c:choose>