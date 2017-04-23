
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
        post2.setImgUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post2.setId(1);
        post2.setAutorePost(utenteFactory.getUtenteById(0));
        post2.setTipoPost(Post.PostType.IMMAGINE);
        
        post2.setTipoDestinazione(Post.DestinationType.BACHECA);
        post2.setIdDestinazione(1);

        
        //Creazione Post3        
        Post post3 = new Post();
        post3.setContenuto("Siete invitati al'evento in molgonfiera di giovedì, ci vediamo lì, ciao");
        post3.setImgUrl("http://68.media.tumblr.com/fe7cd8c3cd98e15f1812430959c36b56/tumblr_myftmaNObo1sh9bnuo1_500.jpg");
        post3.setId(2);
        post3.setAutorePost(utenteFactory.getUtenteById(1));
        post3.setTipoPost(Post.PostType.IMMAGINE);
        
        post3.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post3.setIdDestinazione(0);

        
        //Creazione Post4
        Post post4 = new Post();
        post4.setContenuto("I need ansioliticy");
        post4.setId(3);
        post4.setAutorePost(utenteFactory.getUtenteById(0));
        
        post4.setTipoDestinazione(Post.DestinationType.GRUPPO);
        post4.setIdDestinazione(0);

        
        //Creazione Post5
        Post post5 = new Post();
        post5.setContenuto("Ti mando una foto, ciao");
        post5.setImgUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post5.setId(4);
        post5.setAutorePost(utenteFactory.getUtenteById(1));
        post5.setTipoPost(Post.PostType.IMMAGINE);
        
        post5.setTipoDestinazione(Post.DestinationType.BACHECA);
        post5.setIdDestinazione(0);

               
        //Creazione Post6
        Post post6 = new Post();
        post6.setContenuto("Guardati questo link, ciao");
        post6.setAttachedLink("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post6.setId(4);
        post6.setAutorePost(utenteFactory.getUtenteById(0));
        post6.setTipoPost(Post.PostType.LINK);
        
        post6.setTipoDestinazione(Post.DestinationType.BACHECA);
        post6.setIdDestinazione(1);


        
        
        //Lista post
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);   
        listaPost.add(post6);
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
    
    ArrayList<Post> getPostListAsAuthor(UtenteSecure utente)
    {
        ArrayList<Post> tmp = new ArrayList<Post>();
        
        for (Post tmpPost : this.listaPost) 
        {
            if (tmpPost.getAutorePost().getId() == utente.getId()) 
                tmp.add(tmpPost);
        }

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
