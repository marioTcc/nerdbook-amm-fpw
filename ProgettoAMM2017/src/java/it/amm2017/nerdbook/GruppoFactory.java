
package it.amm2017.nerdbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mario Taccori
 */

public class GruppoFactory
{
    
    private static GruppoFactory singleton;
    private String connectionString;
    
    private GruppoFactory(){}
    public static GruppoFactory getInstance()
    {
        if (singleton == null) singleton = new GruppoFactory();     
        return singleton;
    }   
    public void setConnectionString(String s) { this.connectionString = s; } 
    public String getConnectionString() { return this.connectionString; }
    public Gruppo getGruppoById(int id)
    {
        Gruppo tmp = null;
        String query = "select * from gruppi where id="+id;
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
            
            if(set.next())
            {
                tmp = new Gruppo(set.getInt("id"), set.getString("nome"), set.getString("urlIcona"));
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return tmp;
    }    
    public ArrayList<Gruppo> getAllGroups()
    {
        
        ArrayList<Gruppo> tmp = new ArrayList<>();
        Gruppo tmpGruppo = null;
        String query = "SELECT * FROM gruppi";
        ResultSet set = null;
                
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
            
            while(set.next())
            {
                tmpGruppo = new Gruppo(set.getInt("id"), set.getString("nome"), set.getString("urlIcona"));

                tmp.add(tmpGruppo);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
            
        return tmp;       
    }    
    public boolean checkSubscription(int idUtente, int idGruppo)
    {
        String query = "SELECT * FROM iscrizioniGruppi"+
                " WHERE idUtente="+idUtente+" AND idGruppo="+idGruppo;
        
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
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        if(resultCount>0)
            return true;
        else return false;
        
    }
    public void registerSubscription(int userId, int groupId)
    {
        String query = "INSERT INTO iscrizioniGruppi (idUtente, idGruppo) VALUES ("+userId+", "+groupId+")";
        
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
    
 
    
    // SERVONO?
    public ArrayList<Gruppo> getSubscribedGroups(UtenteSecure utente)
    {
        // SERVE?
        return null;
    }
       
    
}
