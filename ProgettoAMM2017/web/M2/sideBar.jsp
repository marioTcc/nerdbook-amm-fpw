<%-- 
    Document   : sideBar
    Created on : 22-apr-2017, 20.17.10
    Author     : Mario Taccori
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="sidebar1">
    <div id="searchBar">
        <input type="text" value="Cerca">
    </div>
    
    <c:if test="${users != null}">

        <div id="elencoPersone">
            <h4>Persone:</h4>
            <ul>
                <c:forEach var="userTmp" items="${users}">
                    <li>
                        <a href="bacheca.html?action=view&owner=${userTmp.id}&ownerType=user">
                            <c:set var="friendPicUrl" value="${userTmp.urlFotoProfilo}" scope="request" />
                            <c:set var="picSubject" value="friend" scope="request" />
                            <jsp:include page="fotoProfilo.jsp" />
                            ${userTmp.nome} ${userTmp.cognome}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        
    </c:if>
    
    <c:if test="${groups != null}">
        <div id="elencoGruppi">
            <h4>Gruppi:</h4>
            <ul>
                <c:forEach var="gruppoTmp" items="${groups}">
                    <li>
                        <a href="bacheca.html?action=view&owner=${gruppoTmp.id}&ownerType=group">
                            <c:set var="groupPicUrl" value="${gruppoTmp.groupIconUrl}" scope="request" />
                            <c:set var="picSubject" value="groupIcon" scope="request" />
                            <jsp:include page="fotoProfilo.jsp" />
                            ${gruppoTmp.nome}
                        </a>
                        <c:if test="${(isAdmin != null && isAdmin == true) || (gruppoTmp.fondatore != null && gruppoTmp.fondatore == sessionScope.user)}">
                            <a title="Elimina gruppo" class="deleteLink" href="delete?action=deleteGroup&groupId=${gruppoTmp.id}<c:if test="${owner != null && ownerType != null}">&owner=${owner.id}&ownerType=${ownerType}</c:if>">
                                <img src="Assets/ICONS/delete_icona.svg" class="deleteIcon">
                            </a>
                        </c:if>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
</div>