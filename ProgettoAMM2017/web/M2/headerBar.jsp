<%-- 
    Document   : navbar
    Created on : 22-apr-2017, 10.04.29
    Author     : Mario Taccori
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="headerBar">

    <header> <!-- Titolo -->
        <div id="title">
            <img id="logo" src="Assets/ICONS/NerdBook_logo.svg" alt="Logo del social network" />NerdBook
        </div>
    </header>

    <nav> <!-- Menu di navigazione -->
        <ol>   
            <li <c:if test="${page=='profilo'}">class="active"</c:if>><a id="profiloLink" href="profilo.html"><img src="Assets/ICONS/profilo_icona.svg" alt="immagine tasto profilo" />Profilo</a></li>
            <li <c:if test="${page=='bacheca'}">class="active"</c:if>><a id="bachecaLink" href="bacheca.html"><img src="Assets/ICONS/bacheca_icona.svg" alt="immagine tasto bacheca" />Bacheca</a></li>
            <li <c:if test="${page=='descrizione'}">class="active"</c:if>><a id="descrizioneLink" href="descrizione.html"><img src="Assets/ICONS/descrizione_icona.svg" alt="immagine tasto descrizione" />Descrizione</a></li>
            <li <c:if test="${page=='login'}">class="active"</c:if>><a id="loginLink" href="login.html"><img src="Assets/ICONS/login_icona.svg" alt="immagine tasto login" />Login</a></li>
        </ol>
    </nav> 
        
</div>
        
<div class="clear"></div>
        