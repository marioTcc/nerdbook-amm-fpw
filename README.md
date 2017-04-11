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

Creare nel proprio repository GitHub un progetto Netbeans del tipo Java -> Web Application per contenere i file da consegnare. Aggiungere una sottocartella di nome “M1” all'interno di “Web Pages”.


### Task 2 ###

Creare 4 pagine HTML vuote all'interno della cartella M1:

* descrizione.html
* login.html
* bacheca.html
* profilo.html


### Task 3 ###

Inserire all'interno della pagina descrizione.html una breve descrizione del social network: a chi sia rivolto, come iscriversi, se sia gratis o a pagamento. Non è molto importante quello che scriverete, dovete creare un testo con una gerarchia di sezioni e titoli, che arrivi almeno al livello h3. Inserite un sommario con link interni alle sezioni all'inizio della pagina. 

Create una sezione di navigazione che permetta di raggiungere la pagina login.html. 
Inserite le meta-informazioni sulla pagina e validatela. 


### Task 4 ###

Inserire all'interno della pagina di login.html un form per richiedere username e password all'utente, utilizzando i campi di input corretti. 

Create una sezione di navigazione che permetta di raggiungere la pagina descrizione.html, profilo.html e bacheca.html.
Inserite le meta-informazioni sulla pagina e validatela. 


### Task 5 ###
includa: nome dell’utente che ha postato qualcosa, con una foto del suo profilo, il contenuto del post. I tre post si differenziano in questo modo: il primo non ha allegati, il secondo ha come allegato un’immagine, il terzo ha come allegato un link. 

Create una sezione di navigazione che permetta di raggiungere la pagina descrizione.html e login.html.

Inserite le meta-informazioni sulla pagina e validatela.Inserite una sezione nella pagina bacheca.html che contenga la descrizione di almeno 3 post, che  


### Task 6 ###
Create un form per l’inserimento dei dati del profilo all'interno della pagina profilo.html. Il form deve richiedere all'utente le seguenti informazioni, utilizzando le tipologie di input corrette:

* Nome dell’utente
* Cognome dell’utente
* URL di una immagine per il profilo
* Frase di presentazione
* Data di nascita
* Password
* Conferma password

Create una sezione di navigazione che permetta di raggiungere la pagina descrizione.html e login.html.
Inserite le meta-informazioni sulla pagina e validatela. 


### Task 7 ###
Eseguite il commit finale su GitHub per la consegna, utilizzando come messaggio “consegna M1”


-----------------------------------------------------------------------------------------------


## Milestone 2: CSS ##



Per questa milestone dovete creare il layout grafico per il vostro sito web. 
Regole:

* Non si possono usare librerie di terze parti per la creazione del layout (es. bootstrap).
* Potete modificare l’HTML delle pagine della milestone precedente. Prima di farlo però chiedetevi se sia strettamente necessario e, soprattutto, attenzione alla semantica del documento. 


### Task 1 ###

Creare nel progetto Netbeans utilizzato per la scorsa milestone una nuova cartella di nome “M2” all’interno di “Web Pages”.  Copiare le pagine create per la milestone precedente nella cartella M2.


### Task 2 ###

Creare un file di nome style.css all’interno della cartella M2. Collegare ognuna delle pagine al foglio di stile. 


### Task 3 ###

Impostare le caratteristiche generali di visualizzazione della pagina, facendo in modo che le regole che scrivete valgano per tutte le pagine. In particolare:

* Colore di sfondo
* Colore e font per il del testo 
* Proprietà dei dei titoli (almeno da h1 ad h3)
* Proprietà dei link
* Visualizzazione dei campi di input

Fate attenzione alla leggibilità ed alla gradevolezza degli stili. 


### Task 4 ###

Scrivere delle regole CSS che permetta alla struttura della pagina bacheca.html di essere visualizzata come nella seguente figura. 

In particolare:
Avete libertà sui colori e tipi di font. Non è quindi necessario che sia in bianco e nero, quello che vedete è solo una bozza. Gli stili che vedete sono anzi sconsigliati (per esempio il font è bruttissimo). 
Vi viene richiesto di individuare quelle che nella bozza sarebbero immagini decorative (da non inserire nell’HTML) dalle immagini che portano informazione. Le immagini decorative devono essere inserite in modo opzionale tramite CSS (cioè se lo fate correttamente vi daremo uno 0.1 in più, se non lo fate potete prendere comunque il massimo). 
Non considerate il form di ricerca e quello per l’inserimento di un nuovo post per i il momento

![Senzanome.png](https://bitbucket.org/repo/758Eg8/images/3656594249-Senzanome.png)


### Task 5 ###

Rendere il form per la login ed il form per l’inserimento dei dati personali gradevoli dal punto di vista estetico, utilizzando le bozze in figura (stesse indicazioni del task 6). In particolare:

* Fare in modo che le label ed i campi di input siano allineati.
* Impostare bordi e colori per i campi di input, in particolare per il focus
* Rendere i pulsanti individuabili e gradevoli, posizionandoli al centro dello spazio riservato al form (oppure in altre posizioni a scelta, che siano però gradevoli e coerenti per i due form).

Riutilizzate il più possibile gli stessi stili per entrambi i form.
Per il momento, non considerate la barra di ricerca. 

#### Login: ####

![pasted image 0.png](https://bitbucket.org/repo/758Eg8/images/1698892564-pasted%20image%200.png)

#### Profilo: #####

![sgds.png](https://bitbucket.org/repo/758Eg8/images/2621833283-sgds.png)


### Task 6 ###

Create un layout responsive, da utilizzare per tutte le pagine. In particolare considerate tre configurazioni:
* Per larghezze maggiori o uguali a 1024px utilizzare un layout a due colonne
* Per larghezze minori o uguali a 480px utilizzare un layout ad una sola colonna
* Per quelli intermedi utilizzare massimo due colonne. 
* Posizionare i vari contenuti nella posizione ritenuta più appropriata.  


### Task 7 ###

Eseguite il commit finale su Git Hub per la consegna, utilizzando come messaggio “consegna M2”


-----------------------------------------------------------------------------------------------


## Milestone 3: Consegna 5 Maggio 2017 ##

#### Programmazione Server-Side ####

Per il progetto si implementerà un piccolo sito di e-commerce, che lavorerà utilizzando moneta molto virtuale. Il venditore avrà la possibilità di controllare il saldo della moneta virtuale, di inserire e rimuovere oggetti in vendita. Il cliente invece potrà ricaricare il proprio saldo e procedere all'acquisto di uno o più oggetti. Quale tipologia di oggetto si possa mettere in vendita è a vostra scelta.
 

### Task 1 ###

Se il vostro progetto Netbeans non fosse un progetto Java-Web, createne uno nuovo nel repository che utilizzate per la consegna. 

### Task 2 ###

Create un package dedicato a contenere il modello della vostra applicazione. All'interno di questo package ci deve essere una classe per ogni oggetto del dominio applicativo manipolato dalla vostra applicazione. In particolare:

* Utenti venditori
* Utenti clienti
* Oggetti messi in vendita
* Saldo del conto di clienti e venditori

Inserite all’interno di queste classi tutte le variabili necessarie per descriverli. Fatto questo, create per ognuna una Factory che restituisca istanze della classe popolata con dati fittizi, restituendole in base ad un determinato criterio. 

Per esempio (vuol dire che non siete costretti ad implementare l’elenco di sotto ma qualcosa di simile), consideriamo la classe ObjectSale (il nome non è importante, chiamatela come volete) che rappresenta un oggetto in vendita. La corrispondente factory ObjectSaleFactory può avere i seguenti metodi:

* ObjectSale getObjectSaleById(int id) che restiuisce l’oggetto avente l’identificatore passato per parametro
* List<ObjectSale> getSellingObjectList() che restituisce tutti gli oggetti ObjectSale presenti nel sistema
* List<ObjectSale> getSellingObjectByCategory(String category) che restituisce tutti gli oggetti di una determinata categoria 

E tutti gli altri metodi necessari per fare la ricerca di dati nell'applicazione.

### Task 3 ###

Trasformate le pagine HTML delle milestones precedenti in JSP, effettuando le seguenti operazioni:
* Individuate i pezzi ripetuti di HTML ed isolateli in altre JSP, importandoli all’interno delle altre con le include. 
*Rendete dinamiche le parti HTML da generare in base ai dati dell’applicazione, come per esempio la tabella degli oggetti.  Per fare questo, assumete che nella request siano stati impostati tutti gli attributi necessari (p.e. la lista di oggetti) dalla servlet che richiama la JSP. 
* Impostate la pagina di descrizione come welcome file della vostra applicazione web

### Task 4 ###

Create una servlet Login e mappatela sulla URL login.html. La servlet si deve comportare ne modo seguente:

* Nel caso l’utente non sia autenticato, deve mostrare il form di login (login.jsp) e verificare username e password nel caso siano inviate tramite il form
* Nel caso l’utente sia già stato autenticato (durante la gestione della richiesta corrente o ad una precedente), deve mostrare
 * La pagina per l’aggiunta di un nuovo oggetto nel caso l’utente sia un venditore (venditore.jsp)
 * La pagina per l’acquisto di un nuovo oggetto nel caso l’utente sia un cliente (cliente.jsp)
* Nel caso l’utente abbia inviato username e password ma l’autenticazione sia fallita, deve mostrare un messaggio di errore e permettere di riprovare. 

### Task 5 ###

Create una servlet Venditore e mappatela sulla URL venditore.html. La servlet si deve comportare nel modo seguente:

* Nel caso l’utente non sia autenticato o non sia un venditore, deve mostrare un messaggio di accesso negato
* Nel caso l’utente sia un venditore, deve mostrare il form di inserimento dell’oggetto. 
* Nel caso siano inviati i dati relativi all'inserimento di un oggetto, deve mostrare una conferma dell’avvenuto inserimento ed i dati dell’oggetto inserito.

### Task 6 ###

Create una servlet Cliente e mappatela sulla URL cliente.html. La servlet si deve comportare nel modo seguente:

* Nel caso l’utente non sia autenticato o non sia un cliente, deve mostrare un messaggio di accesso negato
* Nel caso l’utente sia un cliente, deve mostrare la lista degli oggetti.
* Nel caso l’utente selezioni il link per comprare un oggetto, deve mostrare solo un riepilogo dei dati dell’oggetto ed un pulsante per la conferma di acquisto
* In caso di conferma dell’acquisto, deve verificare che l’utente abbia abbastanza soldi. In caso positivo deve mostrare un messaggio di avvenuto acquisto, altrimenti un messaggio di errore. 

### Task 7 ###

Eseguite il commit finale su Git Hub per la consegna, utilizzando come messaggio “consegna M3”