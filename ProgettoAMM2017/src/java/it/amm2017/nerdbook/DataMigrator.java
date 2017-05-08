
package it.amm2017.nerdbook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mario Taccori
 */

public class DataMigrator
{
    private static DataMigrator singleton;
    
    private DataMigrator()
    {

    }
    
    public ArrayList<Post> getAllPosts()
    {
        UtenteFactory utenteFactory = UtenteFactory.getInstance();
        ArrayList<Post> listaPost= new ArrayList<>();

        //Creazione Post1
        Post post1 = new Post();
        post1.setContenuto("Ciao, miei schiavi. Datemi cibo! Adesso! Miaomiaomiaomiaomiao!");
        post1.setId(0);
        post1.setAutorePost(utenteFactory.getUtenteById(0));
        
        post1.setTipoDestinazione(Post.DestinationType.BACHECA);
        post1.setIdDestinazione(0);
        
        
        //Creazione Post2
        Post post2 = new Post();
        post2.setContenuto("Ti mando una foto, ciao");
        post2.setAttachedUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post2.setId(1);
        post2.setAutorePost(utenteFactory.getUtenteById(0));
        post2.setTipoPost(Post.PostType.IMMAGINE);
        
        post2.setTipoDestinazione(Post.DestinationType.BACHECA);
        post2.setIdDestinazione(1);

        
        //Creazione Post3        
        Post post3 = new Post();
        post3.setContenuto("Siete invitati al'evento in molgonfiera di giovedì, ci vediamo lì, ciao");
        post3.setAttachedUrl("http://68.media.tumblr.com/fe7cd8c3cd98e15f1812430959c36b56/tumblr_myftmaNObo1sh9bnuo1_500.jpg");
        post3.setId(2);
        post3.setAutorePost(utenteFactory.getUtenteById(1));
        post3.setTipoPost(Post.PostType.IMMAGINE);
        
        post3.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post3.setIdDestinazione(0);

        
        //Creazione Post4
        Post post4 = new Post();
        post4.setContenuto("Và tutti che bella questa pic");
        post4.setId(3);
        post4.setAutorePost(utenteFactory.getUtenteById(2));
        post4.setAttachedUrl("http://68.media.tumblr.com/11e0fa516c5c382765ef28af19a341d3/tumblr_mynfdmKYPa1rq3dyyo1_1280.jpg");
        post4.setTipoPost(Post.PostType.IMMAGINE);
        post4.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post4.setIdDestinazione(0);

        
        //Creazione Post5
        Post post5 = new Post();
        post5.setContenuto("Ti mando una foto, ciao");
        post5.setAttachedUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post5.setId(4);
        post5.setAutorePost(utenteFactory.getUtenteById(1));
        post5.setTipoPost(Post.PostType.IMMAGINE);
        
        post5.setTipoDestinazione(Post.DestinationType.BACHECA);
        post5.setIdDestinazione(0);

               
        //Creazione Post6
        Post post6 = new Post();
        post6.setContenuto("Guardati questo link, ciao");
        post6.setAttachedUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post6.setId(4);
        post6.setAutorePost(utenteFactory.getUtenteById(0));
        post6.setTipoPost(Post.PostType.LINK);
        
        post6.setTipoDestinazione(Post.DestinationType.BACHECA);
        post6.setIdDestinazione(1);
        
        //Creazione Post7
        Post post7 = new Post();
        post7.setContenuto("Forse anche a trenitalia interessa iscriversi a questo gruppo? Invitateli!");
        post7.setId(5);
        post7.setAutorePost(utenteFactory.getUtenteById(2));
        post7.setAttachedUrl("Assets/IMG/trenitalia_ritardo_post.jpg");
        post7.setTipoPost(Post.PostType.IMMAGINE);
        post7.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post7.setIdDestinazione(1);
        
        //Creazione Post8
        Post post8 = new Post();
        post8.setContenuto("Hahaha dedicato al mio amico Gym");
        post8.setId(6);
        post8.setAutorePost(utenteFactory.getUtenteById(0));
        post8.setAttachedUrl("Assets/IMG/ritardo_post.jpg");
        post8.setTipoPost(Post.PostType.IMMAGINE);
        post8.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post8.setIdDestinazione(1);
        
        //Creazione Post9
        Post post9 = new Post();
        post9.setContenuto("Iscrivetevi!");
        post9.setId(6);
        post9.setAutorePost(utenteFactory.getUtenteById(0));
        post9.setAttachedUrl("google.it");
        post9.setTipoPost(Post.PostType.LINK);
        post9.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post9.setIdDestinazione(1);
        
        
        //Lista post
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);   
        listaPost.add(post6);
        listaPost.add(post7);
        listaPost.add(post8);
        listaPost.add(post9);
        
        return listaPost;
    }
    
    public ArrayList<Gruppo> getAllGroups()
    {
        UtenteFactory tmp = UtenteFactory.getInstance();
        ArrayList<Gruppo> listaGruppi= new ArrayList<>();
        
        // Gruppo 1
        Gruppo gruppo1=new Gruppo();
        gruppo1.setId(0);
        gruppo1.setNome("Molgonfieristi");
        gruppo1.setGroupIconUrl("Assets/ICONS/molgonfieristi_icona.svg");
        gruppo1.setIscritti(new ArrayList<UtenteSecure>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(1), tmp.getUtenteById(2))));
        
        // Gruppo 2
        Gruppo gruppo2=new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNome("Ritardatari");
        gruppo2.setGroupIconUrl("Assets/ICONS/ritardatari_icona.svg");
        gruppo2.setIscritti(new ArrayList<UtenteSecure>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(2))));
        
        // Gruppo 3
        Gruppo gruppo3=new Gruppo();
        gruppo3.setId(2);
        gruppo3.setNome("Fittizio1");
        gruppo3.setGroupIconUrl("Assets/ICONS/error_icona.svg");
        gruppo3.setIscritti(new ArrayList<UtenteSecure>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(1), tmp.getUtenteById(2))));
        
        
        // Lista Gruppi
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
        
        return listaGruppi;
    }
    
    public ArrayList<Utente> getAllUsers()
    {
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        
        // Utente1
        Utente utente1 = new Utente();
        utente1.setId(0);
        
        utente1.setNome("Djanni");
        utente1.setCognome("Gatto");
        
        utente1.setEmail("djannigatto@gmail.com");
        
        utente1.setUsername("DjG");
        utente1.setPassword("123");
        
        utente1.setUrlFotoProfilo("Assets/IMG/djanniprofilo.jpg");
        utente1.setFrasePresentazione("ciao a tutti, sono io, Djanni");
        utente1.setDataNascita("2010-10-10");

        // Utente2
        Utente utente2 = new Utente();
        utente2.setId(1);
        
        utente2.setNome("Heavy");
        utente2.setCognome("Breathing");
        
        utente2.setEmail("cholansia@gmail.com");
   
        utente2.setUsername("HeavyBreathing");
        utente2.setPassword("123");
        
        utente2.setUrlFotoProfilo("");
        utente2.setFrasePresentazione("ciao, sono Heavy Breathing");
        utente2.setDataNascita("2010-10-11");

        // Utente3
        Utente utente3 = new Utente();
        utente3.setId(2);
        
        utente3.setNome("Gym");
        utente3.setCognome("WorkOut");
        
        utente3.setUsername("GymWorkOut");        
        utente3.setEmail("doIt@gmail.com");
        
        utente3.setPassword("123");
        
        utente3.setUrlFotoProfilo("Assets/IMG/siamese.jpg");
        utente3.setFrasePresentazione("ciao, sono GymWorkOut");
        utente3.setDataNascita("2010-10-12");

        // Utente4
        Utente utente4 = new Utente();
        utente4.setId(3);
        
        utente4.setNome("Chao");
        utente4.setCognome("Povery");
        
        utente4.setEmail("r1tchb1tch@gmail.com");
        
        utente4.setUsername("ChaoPovery"); 
        utente4.setPassword("123");
        
        utente4.setUrlFotoProfilo("");
        utente4.setFrasePresentazione("ciao, sono Chao Povery");
        utente4.setDataNascita("2010-10-13");
        
        // Incompleto
        Utente incompleto = new Utente();
        incompleto.setId(4);
        
        incompleto.setNome("Incompleto");
        incompleto.setCognome("Orrù");
        
        incompleto.setEmail("");
        
        incompleto.setUsername("incompleto");
        incompleto.setPassword("sonoincompleto");
        
        incompleto.setUrlFotoProfilo("");
        incompleto.setFrasePresentazione("ciao, sono incompleto; completami!");
        incompleto.setDataNascita("2010-10-14");

        
        // Lista utenti
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
        listaUtenti.add(incompleto);
        
        return listaUtenti;
    }

    public static DataMigrator getInstance()
    {
        if (singleton == null)
            singleton = new DataMigrator();
        
        return singleton;
    }
    
}
