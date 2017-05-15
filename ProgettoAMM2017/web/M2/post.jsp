<%-- 
    Document   : post
    Created on : 23-apr-2017, 15.09.10
    Author     : Mario Taccori
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<div>             
    <div class="datiAutore"> <!-- Contenitore dati autore -->    
        <div class="profilePic">
            <c:set var="picSubject" value="postAuthor" scope="request" />
            <jsp:include page="fotoProfilo.jsp" />
        </div>

        <div class="autorePost"> <!-- Nome autore del post -->                         
            <p>${post.autorePost.nome} ${post.autorePost.cognome}</p>
        </div>
        
        <c:if test="${post.id != null && post.id != -1}">        
            <div class="postTimeStamp">
                 <c:if test="${isAdmin != null && isAdmin == true}">
                    <a title="Elimina il post" class="deleteLink" href="delete?action=deletePost&postId=${post.id}&owner=${owner.id}&ownerType=${ownerType}" class="deletePostButton">
                        <img src="Assets/ICONS/delete_icona.svg" class="deleteIcon">
                    </a>                
                </c:if>
                <c:if test="${post.dataPost != null && post.oraPost != null}">
                    <div>${post.dataPost}, ${post.oraPost}</div>
                </c:if>
            </div>
        </c:if>
    </div> 

    <div class="clear"></div>

    <div class="contenutoPost"> <!-- Contenuto del post -->
        <div> <!-- Testo del post -->                         
            <p>${post.contenuto}</p>
        </div>

        <div class="allegatoPost"> <!-- Allegato del post -->
            <c:choose>
                <c:when test="${post.tipoPost == 'IMMAGINE'}">
                    <img alt="Immagine in allegato al post" src="${post.attachedUrl}">
                </c:when>
                    
                <c:when test="${post.tipoPost == 'LINK'}">
                    <a href="http://${post.attachedUrl}">${post.attachedUrl}</a>                        
                </c:when>
            </c:choose>
        </div>
    </div>
</div>