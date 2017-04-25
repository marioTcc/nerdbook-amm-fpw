<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Bacheca di ${owner.nome}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mario Taccori">
        <meta name="keywords" content="NerdBook bacheca social network">
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen">
    </head>
    <body>
        
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="headerBar.jsp"/>
        
        <jsp:include page="sideBar.jsp"/>
        
        <div id="divBody">
            
            <c:choose>
                <c:when test="${sessionScope.loggedIn==true}">
                    <c:if test="${ownerType!='group' && owner.frasePresentazione!=null}">
                        <div id="presentazione">
                            <p>${owner.frasePresentazione}</p>
                        </div>
                    </c:if>
                    
                    <c:if test="${postState!=null && postState=='created'}">
                        <div id="notificaNuovoPost">
                            <p>Hai scritto sulla bacheca di ${owner.nome} <c:if test="${ownerType!='group'}">${owner.cognome}!</c:if></p>
                        </div>                            
                    </c:if>
                   
                    <c:choose>
                        <c:when test="${confirmRequired==null || confirmRequired==false}">
                            <div id="nuovoPostDiv">
                                <form id="formNuovoPost" action="bacheca.html" method="post">
                                    <div id="inputsDiv"> 
                                        <div>
                                            <label for="contenuto"></label>
                                            <input type="text" name="contenuto" id="contenuto" value="Testo nuovo post">
                                        </div>
                                        <div>
                                            <label for="allegato"></label>
                                            <input type="url" name="allegato" id="allegato" value="URL allegato (opzionale, cancella se non necessario)">
                                        </div>
                                    </div>

                                    <div id="radiosDiv">
                                        <div class="filler"></div>
                                        <div>
                                            <input type="radio" name="postType" id="postTypeTextRadio" value="testo" checked="checked">
                                            <label for="postTypeTextRadio">Testo</label>
                                            <input type="radio" name="postType" id="postTypeImmagineRadio" value="immagine">
                                            <label for="postTypeImmagineRadio">Immagine</label>
                                            <input type="radio" name="postType" id="postTypeLinkRadio" value="link">
                                            <label for="postTypeLinkRadio">Link</label>
                                        </div>
                                    </div>

                                    <input type="hidden" name="owner" value="${owner.id}">
                                    <input type="hidden" name="ownerType" value="${ownerType}">
                                    <input type="hidden" name="action" value="newPost">
                                    <input type="hidden" name="confirmRequired" value="true">

                                    <div id="buttonDiv">
                                        <div class="filler"></div>
                                        <button type="submit" form="formNuovoPost">Crea post</button>
                                    </div>
                                </form> 
                            </div>
                        </c:when>

                        <c:when test="${confirmRequired!=null && confirmRequired==true}">
                            <div id="nuovoPostDiv">
                                <div id="riepilogoDiv">
                                    <p>Riepilogo dati inseriti:</p>
                                    <ul>
                                        <li>Autore: "${sessionScope.user.nome} ${sessionScope.user.cognome}"</li>
                                        <li>
                                            Proprietario della bacheca:
                                            <c:choose>
                                                <c:when test="${previewPost.tipoDestinazione == 'BACHECA'}">
                                                    "${owner.nome} ${owner.cognome}"
                                                </c:when>
                                                    
                                                <c:when test="${previewPost.tipoDestinazione == 'GRUPPO'}">
                                                    Gruppo "$owner.nome"
                                                </c:when>
                                                    
                                            </c:choose>                                        
                                        </li>
                                        <li>Testo: "${previewPost.contenuto}"</li>
                                        <li>URL: "${previewPost.attachedUrl}"</li>
                                        <li>Tipo: "${previewPost.tipoPost}"</li>                    
                                    </ul>
                                </div>
                                    
                                <div id="previewPostDiv">    
                                    <p>Preview:</p>
                                    <c:set var="post" value="${previewPost}" scope="request" />
                                    <jsp:include page="post.jsp" />     
                                </div>

                                <div id="choiceDiv">
                                    <div>
                                        <form id="confirmForm" action="bacheca.html" method="post">
                                            <!-- AGGIUNGERE I FORM HIDDEN PER RIMANDARE I DATI DELLA NUOVO POST PER SALVARLO IN DB -->
                                            <input type="hidden" name="owner" value="${owner.id}">
                                            <input type="hidden" name="ownerType" value="${ownerType}">
                                            <input type="hidden" name="action" value="confirmNewPost">
                                            <div>
                                                <button type="submit" form="confirmForm">Conferma</button>
                                            </div>
                                        </form>
                                        <form id="cancelForm" action="bacheca.html" method="post"> 
                                            <input type="hidden" name="owner" value="${owner.id}">
                                            <input type="hidden" name="ownerType" value="${ownerType}">
                                            <input type="hidden" name="action" value="cancelNewPost">
                                            <div>
                                                <button type="submit" form="cancelForm">Annulla</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>        
                        </c:when>                      
                    </c:choose>  

                    <div id="posts"> <!-- Sezione dei post -->
                        <c:forEach var="postTmp" items="${listaPost}">
                            <c:set var="post" value="${postTmp}" scope="request" />
                            <jsp:include page="post.jsp" />                      
                        </c:forEach>
                    </div> <!-- Chiusura sezione dei post -->
                    
                </c:when>
                    
                <c:otherwise>
                    <c:set var="notificationType" value="accessDenied" scope="request" />
                    <c:set var="notificationValue" value="accessDenied" scope="request" />
                    <jsp:include page="notifications.jsp" />
                </c:otherwise>
                    
            </c:choose>
        </div><!-- Fine divBody -->
        
        <div class="clear"></div>
    </body>
</html>
