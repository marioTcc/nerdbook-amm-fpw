
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 *
 * @author Mario Taccori
 */

public class PostFactory {
    
    private static PostFactory singleton;
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory()
    {}

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
    
    ArrayList<Post> getPostList(Utente utente)
    {
        return new ArrayList<Post>();
    }
    
    ArrayList<Post> getPostList(Gruppo gruppo)
    {
        return new ArrayList<Post>();
    }  
}
