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

Eseguite il commit finale su GitHub per la consegna, utilizzando come messaggio “consegna M2”


-----------------------------------------------------------------------------------------------


## Milestone 3: Programmazione Server Side ##

Per il progetto si implementerà un piccolo social network semplificato, che permetta agli utenti di stringere amicizie e di creare e gestire dei gruppi. Si avranno due tipologie di utenti:

* Utenti registrati, che possono inserire informazioni personali, stringere amicizia con altri utenti, creare e gestire dei gruppi, inserire post nella sua bacheca o quella degli amici.
* L’amministratore, che può cancellare i post da qualsiasi bacheca e cancellare qualsiasi gruppo.


Per questa milestone dovete creare una parte della logica server side del per il vostro sito web. 
 
### Task 1 ###

Se il vostro progetto Netbeans non fosse un progetto Java-Web, createne uno nuovo nel repository che utilizzate per la consegna. 

### Task 2 ###

Create un package dedicato a contenere il modello della vostra applicazione. All'interno di questo package ci deve essere una classe per ogni oggetto del dominio applicativo manipolato dalla vostra applicazione. In particolare:

* Utenti registrati
* Post
* Gruppi

Inserite all’interno di queste classi tutte le variabili necessarie per descriverli. Fatto questo, create per ognuna una Factory che restituisca istanze della classe popolata con dati fittizi, restituendole in base ad un determinato criterio. 

Per esempio (vuol dire che non siete costretti ad implementare l’elenco di sotto ma qualcosa di simile), consideriamo la classe Post (il nome non è importante, chiamatela come volete) che rappresenta un oggetto in vendita. La corrispondente factory PostFactory può avere i seguenti metodi:

* Post getPostById(int id) che restituisce l’oggetto avente l’identificatore passato per parametro
* List<Post> getPostList(User usr) che restituisce tutti gli oggetti Post per un determinato utente
* List<Post> getPostList(Group gr) che restituisce tutti gli oggetti Post per un determinato gruppo

E tutti gli altri metodi necessari per fare la ricerca di dati nell'applicazione.

### Task 3 ###

Trasformate le pagine HTML delle milestones precedenti in JSP, effettuando le seguenti operazioni:

* Individuate i pezzi ripetuti di HTML ed isolateli in altre JSP, importandoli all’interno delle altre con le include (p.es. Header, footer, barre di navigazione ecc.)
* Rendete dinamiche le parti HTML da generare in base ai dati dell’applicazione, come per esempio l’elenco dei post in bacheca.  Per fare questo, assumete che nella request siano stati impostati tutti gli attributi necessari (p.e. la lista dei post da scorrere) dalla servlet che richiama la JSP. 
* Impostate la pagina di descrizione come welcome file della vostra applicazione web

### Task 4 ###
Create una servlet Login e mappatela sulla URL login.html. La servlet si deve comportare ne modo seguente:

* Nel caso l’utente non sia autenticato, deve mostrare il form di login (login.jsp) e verificare username e password nel caso siano inviate tramite il form
* Nel caso l’utente sia già stato autenticato (durante la gestione della richiesta corrente o ad una precedente), deve mostrare:
* * La pagina di modifica dei dati del profilo nel caso l’utente non abbia registrato uno fra i seguenti dati: nome, cognome, immagine del profilo, frase di presentazione. 
* * La bacheca con i post dell’utente nel caso tutti i dati precedenti siano stati registrati.
* Nel caso l’utente abbia inviato username e password ma l’autenticazione sia fallita, deve mostrare un messaggio di errore e permettere di riprovare. 

Suggerimento: nelle factory create, fra gli altri utenti, un utente incompleto, il cui campo nome, cognome, immagine del profilo o frase di presentazione sia a null. Per tutti gli altri, impostate invece tutti i campi. Nel caso incompleto effettui la login, deve vedere la pagina del profilo subito dopo l’autenticazione. Gli altri devono vedere la bacheca. 

### Task 5 ###

Create una servlet Profilo e mappatela sulla URL profilo.html. La servlet si deve comportare nel modo seguente:

* Nel caso l’utente non sia autenticato, deve mostrare un messaggio di accesso negato
* Nel caso l’utente sia autenticato, deve mostrare il form di inserimento dei dati del profilo. 
* Nel caso siano inviati i dati relativi al profilo, deve mostrare una conferma dell’avvenuto inserimento ed i dati inseriti.

N.B. In realtà nel caso si faccia il reload della pagina, i dati torneranno ad essere quelli che erano prima dell’inserimento. Ciò che scrivete nel form sarà disponibile solo per la riposta immediatamente dopo il submit del form. È un problema che risolveremo nella prossima milestone.

### Task 6 ###

Create una servlet Bacheca e mappatela sulla URL bacheca.html. È possibile per gli utenti autenticati visitare la bacheca di altri utenti. La servlet si deve comportare nel modo seguente:

* Nel caso l’utente non sia autenticato, deve mostrare un messaggio di accesso negato
* Nel caso l’utente sia autenticato, deve mostrare l’elenco dei post di uno specifico utente. 
* Sulla sinistra della pagina, ci deve essere un elenco di link alle bacheche degli  utenti presenti nel sistema. Cliccando su uno di questi link, si visita la bacheca dell’utente selezionato. 
* In cima alla parte centrale della pagina, ci deve essere un form per l’inserimento di un nuovo post. È possibile per un utente scrivere nella bacheca di altri utenti. Una volta inserito il messaggio, la servlet mostrerà il riepilogo dei dati inseriti, mostrando esplicitamente chi sia l’autore del post e chi sia il proprietario della bacheca. Il riepilogo deve mostrare un pulsante di conferma che conclude l’inserimento. Premuto questo pulsante, deve comparire il messaggio “Hai scritto sulla bacheca di [Tizio]”. 

Suggerimenti: Fate attenzione all'utilizzo della sessione. Deve essere possibile aprire la bacheca di più utenti su più tab. 

### Task 7 ###

Eseguite il commit finale su Git Hub per la consegna, utilizzando come messaggio “consegna M3”


-------------------------------------------------------------------------------------------


## Milestone 4: Persistenza dei dati ##

Per questa milestone dovrete implementare la persistenza dei dati, con piccole modifiche alla parte web.


### Task 1 ###

Individuate entità e relazioni nel dominio della vostra applicazione, insieme con i loro attributi. Una volta che li avete individuati, descriveteli in modo schematico in un file testuale da inserire in una cartella db-definition all’interno di WEB-INF. Per schematico intendo un elenco di entità con relativi attributi e di relazioni con relazione di partenza, di arrivo, cardinalità ed eventuali attributi.


### Task 2 ###

Traducete lo schema del task precedente in tabelle.
Create le query per la loro creazione, salvandole in file crea-db.sql da inserire nella cartella WEB-INF/db-definition.
Create delle query di inserimento per i dati iniziali dell’applicazione (quelli che avevate nelle factory: utenti, gruppi, post ecc.)


### Task 3 ###

Questo task non è concettuale, ma organizzativo. Permetterà al docente di correggere la milestone senza modificare il path del db.

Create un database Derby di nome ammdb all’interno di una cartella db a sua volta all’interno della cartella WEB-INF. Per farlo, seguite la guida che abbiamo visto ad esercitazione.
Aggiungete JavaDB alle librerie del progetto (seguite sempre la guida).
All’interno di ogni classe factory, aggiungete una variabile di istanza connectionString di tipo Stringa e due metodi pubblici:


```
#!java

public void setConnectionString(String s){
	this.connectionString = s;
}
public String getConnectionString(){
	return this.connectionString;
}
```


All'interno della servlet Login:

* aggiungete un parametro loadOnStartup = 0 alla annotazione @WebServlet.
* Aggiungete tre costanti:
* * private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
* * private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
* * private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
* Fate l’override del metodo init della servlet con il seguente codice:

```
#!java


@Override
   public void init(){
       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       ObjectFactory.getInstance().setConnectionString(dbConnection);
   }
```


NB: assumo che la vostra factory si chiami ObjectFactory. Nel caso molto probabile di nome diverso cambiatelo. Se avete più factory, invocate setConnectionString su ognuna (ovviamente create anche le variabili di istanza ed i metodi).

Se avete fatto tutto nel modo corretto, all’avvio del servlet container avete sia caricato il driver di derby che impostato la stringa di connessione in modo dinamico (indipendente dalla posizione sul filesystem della macchina).



Vorrei attirare la vostra attenzione su due punti che potrebbero essere causa di confusione:

* Il Servlet Container non legge il contenuto della cartella WEB-INF che vedete nel vostro progetto NetBeans ma una copia all’interno di una cartella build, che viene creata in fase di compilazione del progetto. Per questo motivo avete due copie dello stesso database: una nella cartella web/WEB-INF del progetto ed una nella cartella build/WEB-INF del progetto. Queste copie non sono sincronizzate, perciò ho messo due costanti che vi permettono di accedere ad entrambe: DB_CLEAN_PATH è quella del progetto Netbeans, DB_BUILD_PATH quella nella build. Per cambiare il db dovete solo modificare l’ultima parte dell’assegnamento della variabile dbConnection. Tenete in DB_CLEAN_PATH la configurazione iniziale del db, cioè quella che volete mandare a me per provarlo. Se fate una compilazione del progetto, perdete i dati nella build che vengono sovrascritti con la versione clean.
* Utilizziamo il driver embedded di Derby, quindi avete a disposizione una sola connessione al db. Se utilizzate DB_BUILD_PATH, non avete questo problema, perché il db che aprite in Netbeans per lanciare query command line e quello dell’applicazione sono diversi. Se utilizzate  DB_CLEAN_PATH dovete avere cura di chiudere la connessione in netbeans prima di lanciare l’applicazione web.


### Task 4 ###

Eseguite le query contenute in crea-db.sql connettendovi al db creato al task 3
Modificate i metodi della factory creata per la milestone precedente in modo che legga i dati eseguendo delle query sullo stesso db. Gli oggetti saranno dunque istanziati non può con un hard-coding dei valori delle variabili di istanza, ma tramite la lettura degli stessi dal db.


### Task 5 ###

Aggiungere alle factory i metodi necessari per salvare in modo persistente i post sulla bacheca di un utente. Il programma si dovrà comportare nello stesso modo descritto nel Task 6 della milestone 3, ma il post dovrà essere visibile anche fra due visite consecutive della pagina delle bacheca.


### Task 6 ###

Gestire la cancellazione di un utente e della sua bacheca con una transazione. Il pulsante per la cancellazione deve essere disponibile nella pagina di modifica dei dati del profilo e deve essere accessibile al solo proprietario del profilo stesso. La cancellazione deve procedere nel modo seguente:
* Devono essere cancellati prima tutti i post presenti sulla bacheca,
* Dopo di che devono essere cancellati i dati del profilo. 
La cancellazione deve andare a buon fine solo nel caso entrambi i passi siano completati in modo corretto. Altrimenti la situazione nel db deve rimanere invariata. 

Nel caso di cancellazione, deve essere mostrata semplicemente la pagina di login.

 
### Task 7 ###

Eseguite il commit finale su GitHub per la consegna, utilizzando come messaggio “consegna M4”


-------------------------------------------------------------------------------------------