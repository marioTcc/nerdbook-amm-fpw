
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 * @author Mario Taccori
 */

public class PostFactory {
    
    private static PostFactory singleton;
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory()
    {
        UtenteFactory utenteFactory = UtenteFactory.getInstance();

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
     
    }

    public static PostFactory getInstance()
    {
        if (singleton == null)
            singleton = new PostFactory();
        
        return singleton;
    }
       
    public Post getPostById(int id)
    {
        for (Post tmpPost : this.listaPost) 
        {
            if (tmpPost.getId() == id) 
                return tmpPost;
        }
        return null;
    }
        
    public Post getFakePost(UtenteSecure autore, String contenuto, Post.PostType tipoPost, String attachedUrl, Post.DestinationType tipoDestinazione)
    {
        Post tmp = new Post();
        
        tmp.setAutorePost(autore);
        tmp.setContenuto(contenuto);
        tmp.setTipoPost(tipoPost);
        tmp.setAttachedUrl(attachedUrl);
        tmp.setTipoDestinazione(tipoDestinazione);       
        
        return tmp;
    }
        
    ArrayList<Post> getPostList(UtenteSecure utente)
    {
        ArrayList<Post> tmp = new ArrayList<Post>();
        
        for (Post tmpPost : this.listaPost) 
        {
            if (tmpPost.getTipoDestinazione()==Post.DestinationType.BACHECA && tmpPost.getIdDestinazione()==utente.getId())
                tmp.add(tmpPost);
        }

        return tmp;
    }
    
    ArrayList<Post> getPostList(Gruppo gruppo)
    {
        ArrayList<Post> tmp = new ArrayList<Post>();
        
        for (Post tmpPost : this.listaPost) 
        {
            if (tmpPost.getTipoDestinazione()==Post.DestinationType.GRUPPO && tmpPost.getIdDestinazione()==gruppo.getId())
                tmp.add(tmpPost);
        }

        return tmp;
    }  
}
