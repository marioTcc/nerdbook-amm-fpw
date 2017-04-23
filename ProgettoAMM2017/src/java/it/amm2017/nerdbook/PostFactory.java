
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

        //Creazione Post
        Post post1 = new Post();
        post1.setContenuto("Ciao, miei schiavi. Datemi cibo! Adesso! Miaomiaomiaomiaomiao!");
        post1.setId(0);
        post1.setAutorePost(utenteFactory.getUtenteById(0));

        Post post2 = new Post();
        post2.setContenuto("Ti mando una foto, ciao");
        post2.setImgUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post2.setId(1);
        post2.setAutorePost(utenteFactory.getUtenteById(0));
        post2.setTipoPost(Post.PostType.IMMAGINE);

        Post post3 = new Post();
        post3.setContenuto("Ti mando una foto, ciao");
        post3.setImgUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post3.setId(2);
        post3.setAutorePost(utenteFactory.getUtenteById(0));
        post3.setTipoPost(Post.PostType.IMMAGINE);

        Post post4 = new Post();
        post4.setContenuto("I need ansioliticy");
        post4.setId(3);
        post4.setAutorePost(utenteFactory.getUtenteById(0));

        Post post5 = new Post();
        post5.setContenuto("Ti mando una foto, ciao");
        post5.setImgUrl("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post5.setId(4);
        post5.setAutorePost(utenteFactory.getUtenteById(1));
        post5.setTipoPost(Post.PostType.IMMAGINE);
        
        Post post6 = new Post();
        post6.setContenuto("Guardati questo link, ciao");
        post6.setAttachedLink("https://68.media.tumblr.com/51942e1f788f7209ee0f6db7cfc5e0fb/tumblr_n37ycpbMZf1rkxod7o1_500.jpg");
        post6.setId(4);
        post6.setAutorePost(utenteFactory.getUtenteById(0));
        post6.setTipoPost(Post.PostType.LINK);

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
    
    ArrayList<Post> getPostList(UtenteSecure utente)
    {
        ArrayList<Post> tmp = new ArrayList<Post>();
        
        for (Post tmpPost : this.listaPost) 
        {
            if (tmpPost.getAutorePost().getId() == utente.getId()) 
                tmp.add(tmpPost);
        }

        return tmp;
    }
    
    ArrayList<Post> getPostList(Gruppo gruppo)
    {// TODO: DA IMPLEMENMTARE
        return new ArrayList<Post>();
    }  
}
