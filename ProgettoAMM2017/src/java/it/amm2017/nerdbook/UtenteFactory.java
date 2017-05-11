
package it.amm2017.nerdbook;

import java.sql.Statement;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mario Taccori
 */

public class UtenteFactory
{   
    private static UtenteFactory singleton;
    private String connectionString;
    
    private UtenteFactory(){}
    public static UtenteFactory getInstance()
    {
        if (singleton == null) singleton = new UtenteFactory();      
        return singleton;
    }   
    public void setConnectionString(String s) { this.connectionString = s; }    
    public String getConnectionString() { return this.connectionString; }      
    public static boolean checkCompletion(UtenteSecure utente) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String tmp="";

        Method [] methods=utente.getClass().getDeclaredMethods();
        
        for(Method m : methods)
        {
            if(m.getName().startsWith("get") && m.getReturnType()==String.class)
            {
                if(m.getName().endsWith("Nome") || m.getName().endsWith("Cognome") 
                        || m.getName().endsWith("FrasePresentazione") || m.getName().endsWith("UrlFotoProfilo") )
                {
                    tmp=(String)m.invoke(utente);
                    if(tmp==null || tmp.equals(""))
                        return false;
                }
            }
        }      
        return true;
    }
    
    public boolean updateUserInfo(UtenteSecure _new)
    {
        //TODO
        return false;
    }      
    public UtenteSecure getUtenteById(int id) 
    {
        UtenteSecure tmp = null;
        String query = "select * from utenti where id="+id;
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
             
            if(set.next())
            {
                tmp = new UtenteSecure(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toString(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione")
                        );
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex); }
            
        
        return tmp;
    }   
    public Utente getUtenteByUsername(String username) 
    {
        Utente tmp = null;      
        String query = "SELECT * FROM utenti"+
                " JOIN tipiUtente ON utenti.tipoUtente = tipiUtente.ID"+
                " where username='"+username+"'";
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
             
            if(set.next())
            {
                tmp = new Utente(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toString(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione"),
                        set.getString("username"), set.getString("password"), set.getString("nomeTipoUtente"));
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex); }
            
        return tmp;
    }  
    public ArrayList<UtenteSecure> getAllUsers(ArrayList<Integer> excludeListId)
    {      
        ArrayList<UtenteSecure> tmp = new ArrayList<>();
        UtenteSecure tmpUtente = null;
        String query = "SELECT * FROM utenti";
        ResultSet set = null;

        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
                       
            while(set.next())
            {
                tmpUtente = new UtenteSecure(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toString(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione")
                        );
                
                if(!excludeListId.contains(tmpUtente.getId()))
                    tmp.add(tmpUtente);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return tmp;
        
    } 
    public Utente.TipoUtente getTipoUtente(UtenteSecure utente)
    {
        String query = "SELECT nomeTipoUtente FROM utenti"+
                " JOIN tipiUtente ON utenti.tipoUtente = tipiUtente.ID"+
                " WHERE utenti.id="+utente.getId();
        
        ResultSet set = null;
        Utente.TipoUtente tipo = Utente.TipoUtente.INVALID;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
            
            if(set.next())
            {
                switch(set.getString("nomeTipoUtente"))
                {
                    case "ADMIN":
                        tipo = Utente.TipoUtente.ADMIN;
                        break;
                    case "USER":
                        tipo = Utente.TipoUtente.USER;
                        break;
                    default:
                        tipo = Utente.TipoUtente.INVALID;   
                        break;
                }
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return tipo;
    }
    public boolean checkFriendship(int id1, int id2)
    {
        String query = "SELECT * FROM amici"+
                " WHERE (idUtente1="+id1+" OR idUtente1="+id2+" )"+
                " AND (idUtente2="+id1+" OR idUtente2="+id2+" )";
        
        ResultSet set = null;
        int resultCount = 0;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
            
            while(set.next())
            {
                resultCount++;                
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        if(resultCount>0)
            return true;
        else return false;
        
    }
    public void registerFriendship(int userId1, int userId2)
    {
        String query = "INSERT INTO amici (idUtente1, idUtente2) VALUES ("+userId1+", "+userId2+")";
        String query2 = "INSERT INTO amici (idUtente1, idUtente2) VALUES ("+userId2+", "+userId1+")";        
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate(query);    
            stmt.executeUpdate(query2);  
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }       
    }
    
    
    
    
 
    // SERVONO ?
    public ArrayList<UtenteSecure> cercaUtente(String nome, String cognome)
    {
        //SERVE?
        return null;       
    }   
    public ArrayList<UtenteSecure> getFriends(UtenteSecure utente)
    {      
        //SERVE?
        return null; 
    }
}
