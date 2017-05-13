
package it.amm2017.nerdbook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    private String connectionUsername;
    private String connectionPassword;
    
    private PostFactory(){}
    public static PostFactory getInstance()
    {
        if (singleton == null) singleton = new PostFactory();       
        return singleton;
    }
   
    public Post getPostById(int id) //DA RIVEDERE, SERVE?
    {
        Post tmp = null;        
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
                " where idUtenteDest = ? ";//utente.getId()
        ResultSet set = null;
        UtenteSecure autore = null;

        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            
            set = stmt.executeQuery();
                       
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
        
        
        
        String query2 = "SELECT * FROM iscrizioniGruppi WHERE idUtente = ?"; //utente.getId()
        set = null;
        autore = null;

        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
           
            PreparedStatement stmt = conn.prepareStatement(query2);
            stmt.setInt(1, utente.getId());
            
            set = stmt.executeQuery();
                       
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
                " WHERE idGruppoDest = ?"+ //gruppo.getId()
                " ORDER BY dataPost DESC, oraPost DESC";
        
        ResultSet set = null;
        UtenteSecure autore = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, gruppo.getId());
            
            set = stmt.executeQuery();
            
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
            " VALUES ( default, ?,"+ //newPost.getAutorePost().getId()
                " ?,"+ //newPost.getContenuto()
                " ?,"+ //idTipoPost
                " ?,"+ //newPost.getAttachedUrl()
                " ?,"+ //idTipoDestinazione
                " ?,"+ //LocalDate.now()
                " ?,"+ //LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                " ?,"+ //idUtenteDest
                " ?)"; //idGruppoDest
        
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, newPost.getAutorePost().getId());
            stmt.setString(2, newPost.getContenuto());
            stmt.setInt(3, idTipoPost);
            stmt.setString(4, newPost.getAttachedUrl());
            stmt.setInt(5, idTipoDestinazione);
            stmt.setDate(6, Date.valueOf(LocalDate.now()));
            stmt.setTime(7, Time.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
            
            if(newPost.getTipoDestinazione()==Post.DestinationType.BACHECA) 
            {
                stmt.setInt(8, newPost.getIdDestinazione());
                stmt.setNull(9, java.sql.Types.INTEGER);
            }
            else
            {
                stmt.setNull(8, java.sql.Types.INTEGER);
                stmt.setInt(9, newPost.getIdDestinazione());
            }
            
            
            stmt.executeUpdate();    
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }  
    }   
    public int getPostTypeId(Post.PostType type)
    {
        String query = "SELECT * FROM tipiPost WHERE nomeTipoPost = ?"; //type.toString()
        ResultSet set = null;
        int id = -1;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, type.toString());
            
            set = stmt.executeQuery();  
            
            if(set.next())
                id = set.getInt("id");
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return id;
    }  
    public int getDestinationTypeId(Post.DestinationType type)
    {
        String query = "SELECT * FROM tipiDestinazione WHERE nomeTipoDestinazione = ?"; //type.toString()
        ResultSet set = null;
        int id = -1;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, type.toString());
            
            set = stmt.executeQuery();  
            
            if(set.next())
                id = set.getInt("id");
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return id;
    }
    public void deletePostList(ArrayList<Integer> idDeleteList) //FUNZIONA?
    {
        String query;
        
        for(Integer tmpPostId : idDeleteList)
        {       
            query = "DELETE FROM posts WHERE id = ?"; //tmpPostId
            
            try
            {
                Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
                
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, tmpPostId);

                stmt.executeUpdate();  

                stmt.close();
                conn.close();

            }
            catch (SQLException ex) { Logger.getLogger(PostFactory.class.getName()).log(Level.SEVERE, null, ex); }
            
        }        
    }
    
    public void setConnectionString(String s) { this.connectionString = s; }
    public String getConnectionString() { return this.connectionString; }            
    public String getConnectionUsername() { return connectionUsername; }
    public void setConnectionUsername(String connectionUsername) { this.connectionUsername = connectionUsername; }
    public String getConnectionPassword() { return connectionPassword; }
    public void setConnectionPassword(String connectionPassword) { this.connectionPassword = connectionPassword; }
}
