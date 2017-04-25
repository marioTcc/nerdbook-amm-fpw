<%-- 
    Document   : headerBar
    Created on : 22-apr-2017, 10.04.29
    Author     : Mario Taccori
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<div class="headerBar">

    <header> <!-- Titolo -->
        <div id="title">
            <img id="logo" src="Assets/ICONS/NerdBook_logo.svg" alt="Logo del social network" />NerdBook
        </div>
    </header>

    <nav> <!-- Menu di navigazione -->
        <ol>   
            <li <c:if test="${page=='profilo'}">class="active"</c:if>><a id="profiloLink" href="profilo.html"><img src="Assets/ICONS/profilo_icona.svg" alt="immagine tasto profilo" />Profilo</a></li>
            <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a id="bachecaLink" href="bacheca.html?ownerType=user"><img src="Assets/ICONS/bacheca_icona.svg" alt="immagine tasto bacheca" />Bacheca</a></li>
            <li <c:if test="${page=='descrizione'}">class="active"</c:if>><a id="descrizioneLink" href="descrizione.html"><img src="Assets/ICONS/descrizione_icona.svg" alt="immagine tasto descrizione" />Descrizione</a></li>
            
            <c:choose>
                <c:when test="${sessionScope.loggedIn == false || sessionScope.loggedIn==null}">
                    <li id="loggedOutLi"><a id="loginLink" href="login.html"><img src="Assets/ICONS/login_icona.svg" alt="immagine tasto login" />Login</a></li>
                </c:when>
                    
                <c:when test="${sessionScope.loggedIn == true}">
                    <li id="loggedInLi">
                        <div id="loggedInDiv">      
                            <c:set var="picSubject" value="self" scope="request" />
                            <jsp:include page="fotoProfilo.jsp" />
                            <p>${sessionScope.user.nome} ${sessionScope.user.cognome}</p>
                            <a id="logoutLink" href="login.html?action=logout"><img src="Assets/ICONS/loggedIn_icona.svg" alt="immagine tasto login" />Logout</a>
                        </div>
                    </li>
                </c:when>            
            </c:choose>    
        </ol>
    </nav> 
        
</div>
        
<div class="clear"></div>
        