<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>NerdBook - Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mario Taccori">
        <meta name="keywords" content="NerdBook bacheca social network">
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen">
    </head>
    <body>
        
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="headerBar.jsp"/>

        <div class="clear"></div>
        
        <jsp:include page="sideBar.jsp"/>
        
        <div id="divBody">
            <div id="presentazione">
                <p>Autore presentazione: Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
                     
            <div id="posts"> <!-- Sezione dei post -->

                <!-- Post senza allegati -->
                <div>             
                    <div class="datiAutore"> <!-- Contenitore dati autore -->    
                        <div class="profilePic"> <!-- Foto profilo -->                           
                            <img src="Assets/IMG/djanniprofilo.jpg" alt="Foto autore del post">
                        </div>

                        <div class="autorePost"> <!-- Nome autore del post -->                         
                            <p>nome autore del post</p>
                        </div>
                    </div> 

                    <div class="clear"></div>

                    <div class="contenutoPost"> <!-- Contenuto del post -->
                        <div> <!-- Testo del post -->                         
                            <p>Questo Ã¨ il testo del post</p>
                        </div>

                        <div class="allegatoPost"> <!-- Allegato del post -->
                            <!-- Nessun allegato -->                            
                        </div>
                    </div>
                </div>

                <!-- Post con immagine in allegato -->
                <div>                    
                    <div class="datiAutore"> <!-- Contenitore dati autore -->
                        <div class="profilePic"> <!-- Foto profilo -->                          
                            <img src="Assets/IMG/djanniprofilo.jpg" alt="Foto autore del post">
                        </div>

                        <div class="autorePost"> <!-- Nome autore del post -->                          
                            <p>nome autore del post</p>
                        </div>
                    </div>  

                    <div class="clear"></div>

                    <div class="contenutoPost"> <!-- Contenuto del post -->
                        <div> <!-- Testo del post -->                         
                            <p>Questo Ã¨ il testo del post</p>
                        </div>

                        <div class="allegatoPost"> <!-- Allegato del post -->                        
                            <img src="Assets/IMG/siamese.jpg" alt="Immagine in allegato al post">
                        </div>
                    </div>
                </div>

                <!-- Post con link in allegato -->
                <div>       
                    <div class="datiAutore"> <!-- Contenitore dati autore -->
                        <div class="profilePic"> <!-- Foto profilo -->                           
                            <img src="Assets/IMG/djanniprofilo.jpg" alt="Foto autore del post">
                        </div>

                        <div class="autorePost"> <!-- Nome autore del post -->                        
                            <p>nome autore del post</p>
                        </div>
                    </div>   

                    <div class="clear"></div>

                    <div class="contenutoPost"> <!-- Contenuto del post -->
                        <div>
                            <!-- Testo del post -->
                            <p>Questo Ã¨ il testo del post</p>
                        </div>

                        <div class="allegatoPost"> <!-- Allegato del post -->                            
                            <a href="http://www.google.it">Link in allegato</a>
                        </div>
                    </div>
                </div>

            </div> <!-- Chiusura sezione dei post -->
        </div><!-- Fine divBody -->
        
        <div class="clear"></div>
    </body>
</html>
