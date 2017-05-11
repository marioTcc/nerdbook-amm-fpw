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
                            <c:when test="${requestScope.user.urlFotoProfilo != null && requestScope.user.urlFotoProfilo != ''}">
                                "${requestScope.user.urlFotoProfilo}" width="150px" height="150px"
                            </c:when>

                            <c:otherwise>
                               "Assets/ICONS/noProfilePic_icona.svg" class="defaultPic"
                            </c:otherwise>
                       </c:choose>
        />
    </c:when>
    
    <c:when test="${picSubject=='postAuthor'}">
        <img alt="foto profilo" src=
                <c:choose>
                    <c:when test="${post.autorePost.urlFotoProfilo !=null && post.autorePost.urlFotoProfilo != ''}">
                       "${post.autorePost.urlFotoProfilo}" class="defaultPic"
                    </c:when>

                    <c:otherwise>
                       "Assets/ICONS/noProfilePic_icona.svg" class="defaultPic"
                    </c:otherwise>
               </c:choose>
        />
    </c:when>
               
    <c:when test="${picSubject=='friend'}">
        <img class="friendPic" alt="foto profilo amico" src=
                <c:choose>
                    <c:when test="${friendPicUrl != null && friendPicUrl != ''}">
                       "${friendPicUrl}"
                    </c:when>

                    <c:otherwise>
                       "Assets/ICONS/noProfilePic_icona.svg"
                    </c:otherwise>
               </c:choose>
        />
    </c:when>
               
    <c:when test="${picSubject=='groupIcon'}">
        <img class="groupIcon" alt="icona gruppo" src=
                <c:choose>
                    <c:when test="${groupPicUrl != null && groupPicUrl != ''}">
                       "${groupPicUrl}"
                    </c:when>

                    <c:otherwise>
                       "Assets/ICONS/noProfilePic_icona.svg"
                    </c:otherwise>
               </c:choose>
        />
    </c:when>
                       
</c:choose>