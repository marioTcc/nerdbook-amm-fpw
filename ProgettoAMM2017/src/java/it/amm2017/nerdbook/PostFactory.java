
package it.amm2017.nerdbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mario Taccori
 */

public class PostFactory {
    
    private static PostFactory singleton;
    private String connectionString;
    
    private PostFactory(){}
    public static PostFactory getInstance()
    {
        if (singleton == null) singleton = new PostFactory();       
        return singleton;
    }
    public void setConnectionString(String s) { this.connectionString = s; }
    public String getConnectionString() { return this.connectionString; }       
    public Post getPostById(int id) //DA RIVEDERE
    {
        Post tmp = null;
        String query = "SELECT * FROM posts JOIN tipiPost ON posts.tipoPost = tipiPost.ID where id='"+id+"'";
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
            
            if(set.next())
            {
                tmp = new Post(set.getInt("id"), UtenteFactory.getInstance().getUtenteById(set.getInt("autore")),
                        set.getString("contenuto"), set.getString("nomeTipoPost"), set.getString("attachedUrl"), set.getString("tipoDestinazione"),
                        set.getInt("idDestinazione"), set.getDate("dataPost").toLocalDate(), set.getTime("oraPost").toLocalTime());
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }


        return tmp;
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
    public ArrayList<Post> getPostList(UtenteSecure utente)
    {
        Set<Post> tmp = new TreeSet<>();
        Post tmpPost = null;
        String query = "SELECT * FROM posts"+
                " JOIN tipiPost ON posts.tipoPost = tipiPost.ID"+
                " JOIN tipiDestinazione ON posts.tipoDestinazione = tipiDestinazione.ID"+
                " where idUtenteDest="+utente.getId();
        ResultSet set = null;
        UtenteSecure autore = null;

        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
                       
            while(set.next())
            {
                autore = UtenteFactory.getInstance().getUtenteById(set.getInt("autore"));
                
                tmpPost = new Post(set.getInt("id"), autore,
                        set.getString("contenuto"), set.getString("nomeTipoPost"), set.getString("attachedUrl"), set.getString("nomeTipoDestinazione"),
                        utente.getId(), set.getDate("dataPost").toLocalDate(), set.getTime("oraPost").toLocalTime());
                
                if(tmpPost.getTipoDestinazione() == Post.DestinationType.BACHECA)
                    tmpPost.setIdDestinazione(set.getInt("idUtenteDest"));
                else if(tmpPost.getTipoDestinazione() == Post.DestinationType.GRUPPO)
                    tmpPost.setIdDestinazione(set.getInt("idGruppoDest"));

                tmp.add(tmpPost);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        
        
        String query2 = "SELECT * FROM iscrizioniGruppi WHERE idUtente="+utente.getId();
        set = null;
        autore = null;

        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query2);
                       
            while(set.next())
            {
                for(Post tmpPost2 : this.getPostList(GruppoFactory.getInstance().getGruppoById(set.getInt("idGruppo"))))
                    tmp.add(tmpPost2);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }

        return new ArrayList<Post>(tmp);
    }  
    public ArrayList<Post> getPostList(Gruppo gruppo)
    {
        ArrayList<Post> tmp = new ArrayList<>();
        Post tmpPost = null;
        String query = "SELECT * FROM posts"+
                " JOIN tipiPost ON posts.tipoPost = tipiPost.ID"+
                " JOIN tipiDestinazione ON posts.tipoDestinazione = tipiDestinazione.ID"+
                " WHERE idGruppoDest="+gruppo.getId()+
                " ORDER BY dataPost DESC, oraPost DESC";
        
        ResultSet set = null;
        UtenteSecure autore = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
            
            while(set.next())
            {
                autore = UtenteFactory.getInstance().getUtenteById(set.getInt("autore"));
                
                tmpPost = new Post(set.getInt("id"), autore,
                        set.getString("contenuto"), set.getString("nomeTipoPost"), set.getString("attachedUrl"), set.getString("nomeTipoDestinazione"),
                        -1, set.getDate("dataPost").toLocalDate(), set.getTime("oraPost").toLocalTime());
                
                tmpPost.setIdDestinazione(set.getInt("idGruppoDest"));

                tmp.add(tmpPost);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }

        return tmp;
    } 
    public void registerNewPost(Post newPost)
    {
        int idTipoPost = this.getPostTypeId(newPost.getTipoPost());
        int idTipoDestinazione = this.getDestinationTypeId(newPost.getTipoDestinazione());
        
        
        String query = "INSERT INTO posts ( id, autore, contenuto, tipoPost, attachedUrl, tipoDestinazione, dataPost, oraPost, idUtenteDest, idGruppoDest)" +
            " VALUES ( default, "+newPost.getAutorePost().getId()+", '"+newPost.getContenuto()+"', "+idTipoPost+", '"+
            newPost.getAttachedUrl()+"', "+idTipoDestinazione+", '"+LocalDate.now()+"', '"+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"'";
        
        if(newPost.getTipoDestinazione()==Post.DestinationType.BACHECA) query += ", "+newPost.getIdDestinazione()+", NULL)";
        else query += ", NULL, "+newPost.getIdDestinazione()+")";
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate(query);    
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }  
    }   
    public int getPostTypeId(Post.PostType type)
    {
        String query = "SELECT * FROM tipiPost WHERE nomeTipoPost='"+type.toString()+"'";
        ResultSet set = null;
        int id = -1;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);  
            
            if(set.next())
                id = set.getInt("id");
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return id;
    }  
    public int getDestinationTypeId(Post.DestinationType type)
    {
        String query = "SELECT * FROM tipiDestinazione WHERE nomeTipoDestinazione='"+type.toString()+"'";
        ResultSet set = null;
        int id = -1;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);  
            
            if(set.next())
                id = set.getInt("id");
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return id;
    }
}
