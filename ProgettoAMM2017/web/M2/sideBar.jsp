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

    <div id="elencoPersone">
        <h4>Persone:</h4>
        <ul>
            <c:forEach var="friendTmp" items="${friends}">
                <li>${friendTmp.nome} ${friendTmp.cognome}</li>
            </c:forEach>
        </ul>
    </div>

    <div id="elencoGruppi">
        <h4>Gruppi:</h4>
        <ul>
            <c:forEach var="gruppoTmp" items="${subscribedGroups}">
                <li>${gruppoTmp.nome}</li>
            </c:forEach>
        </ul>
    </div>
</div>