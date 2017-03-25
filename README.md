# Progetto creato per il corso di Amministrazione di sistema (fondamenti di programmazione web) dell'Università di Cagliari, a.a.2016/2017. #


-----------------------------------------------------------------------------------------------


# Specifiche del progetto #


## Nerdbook ##

L’applicazione web da sviluppare è un social network semplificato, che permetta agli utenti di stringere amicizie e di creare e gestire dei gruppi. Si avranno due tipologie di utenti:

* Utenti registrati, che possono inserire informazioni personali, stringere amicizia con altri utenti, creare e gestire dei gruppi, inserire post nella sua bacheca o quella degli amici.
* L’amministratore, che può cancellare i post da qualsiasi bacheca e cancellare qualsiasi gruppo.


## Utenti registrati ##


### Inserimento dati profilo ###

Un utente registrato ha associati una serie di dati personali (nome, cognome, data di nascita). Inoltre ha una frase di presentazione che appare in cima alla propria bacheca (vedi la funzionalità gestione della bacheca) ed una immagine del profilo, di cui specifica la URL. Inoltre, ha una password che può modificare. 


### Gestione della bacheca ###

Ogni utente registrato ha una bacheca, che mostra una serie di post. I post sono formati da:

* Un messaggio
* Un allegato opzionale, che può essere un link o una immagine, entrambi da specificare come URL. 

Un utente registrato può inserire dei post nella sua bacheca o in quella dei suoi amici. Nel caso un utente visiti la bacheca di un altro utente che non è nella lista dei suoi amici, l’applicazione gli permetterà di stringere amicizia. Non è prevista una conferma dell’amicizia. 
Una volta stretta l’amicizia, l’utente potrà inserire dei post in bacheca. 


### Gestione dei gruppi ###

I gruppi permettono di raccogliere degli utenti, che non siano necessariamente amici fra loro, per condividere informazioni e materiali legati da un comune interesse (un linguaggio di programmazione, una squadra di calcio, un gruppo musicale ecc.). Anche i gruppi hanno la loro bacheca. Ogni volta che un post viene pubblicato sulla bacheca di un gruppo, questo viene replicato anche nella bacheca di tutti gli appartenenti al gruppo.
Un utente si iscrive spontaneamente visitando la bacheca del gruppo e richiedendo l’iscrizione. Non è prevista la conferma dell’iscrizione dagli altri appartenenti al gruppo. 
Il gruppo viene fondato da un utente, che è l’unico, oltre all'amministratore, che può cancellarlo. Una volta cancellato, anche tutti i post del gruppo sono eliminati. 


### Amministratore ###

L’amministratore è un utente speciale che può cancellare i contenuti ritenuti non appropriati. Per questo può cancellare post di qualsiasi utente e qualsiasi gruppo. 



-----------------------------------------------------------------------------------------------



## Milestone 1: HTML ##

Per questa milestone dovete creare solo il contenuto HTML statico. Non preoccupatevi della grafica. 


### Task 1 ###

Creare nel proprio repository Git Hub un progetto Netbeans del tipo Java -> Web Application per contenere i file da consegnare. Aggiungere una sottocartella di nome “M1” all’interno di “Web Pages”.


### Task 2 ###

Creare 4 pagine HTML vuote all’interno della cartella M1:

* descrizione.html
* login.html
* bacheca.html
* profilo.html


### Task 3 ###

Inserire all’interno della pagina descrizione.html una breve descrizione del social network: a chi sia rivolto, come iscriversi, se sia gratis o a pagamento. Non è molto importante quello che scriverete, dovete creare un testo con una gerarchia di sezioni e titoli, che arrivi almeno al livello h3. Inserite un sommario con link interni alle sezioni all’inizio della pagina. 

Create una sezione di navigazione che permetta di raggiungere la pagina login.html. 
Inserite le metainformazioni sulla pagina e validatela. 


### Task 4 ###

Inserire all’interno della pagina di login.html un form per richiedere username e password all’utente, utilizzando i campi di input corretti. 

Create una sezione di navigazione che permetta di raggiungere la pagina descrizione.html, profilo.html e bacheca.html.
Inserite le metainformazioni sulla pagina e validatela. 


### Task 5 ###
includa: nome dell’utente che ha postato qualcosa, con una foto del suo profilo, il contenuto del post. I tre post si differenziano in questo modo: il primo non ha allegati, il secondo ha come allegato un’immagine, il terzo ha come allegato un link. 

Create una sezione di navigazione che permetta di raggiungere la pagina descrizione.html e login.html.

Inserite le metainformazioni sulla pagina e validatela.Inserite una sezione nella pagina bacheca.html che contenga la descrizione di almeno 3 post, che  


### Task 6 ###
Create un form per l’inserimento dei dati del profilo all’interno della pagina profilo.html. Il form deve richiedere all’utente le seguenti informazioni, utilizzando le tipologie di input corrette:

* Nome dell’utente
* Cognome dell’utente
* URL di una immagine per il profilo
* Frase di presentazione
* Data di nascita
* Password
* Conferma password

Create una sezione di navigazione che permetta di raggiungere la pagina descrizione.html e login.html.
Inserite le metainformazioni sulla pagina e validatela. 


### Task 7 ###
Eseguite il commit finale su Git Hub per la consegna, utilizzando come messaggio “consegna M1”