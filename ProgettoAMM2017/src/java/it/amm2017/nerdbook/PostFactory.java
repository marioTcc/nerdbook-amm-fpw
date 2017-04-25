
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
        this.listaPost = DataMigrator.getInstance().getAllPosts();
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
