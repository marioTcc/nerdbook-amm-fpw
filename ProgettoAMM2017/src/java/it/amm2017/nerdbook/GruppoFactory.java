
package it.amm2017.nerdbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private String connectionUsername;
    private String connectionPassword;
    
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
        String query = "select * from gruppi where id = ?"; //id
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Gruppo tmp = new Gruppo(set.getInt("id"), set.getString("nome"), set.getString("urlIcona"), this.getGroupFounderId(set.getInt("id")));                          
                stmt.close();
                conn.close();                
                return tmp;
            }
            
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        return null;
    }    
    public ArrayList<Gruppo> getAllGroups()
    {
        
        ArrayList<Gruppo> tmp = new ArrayList<>();
        String query = "SELECT * FROM gruppi";
                
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            PreparedStatement stmt = conn.prepareStatement(query);
            
            ResultSet set = stmt.executeQuery();
            
            while(set.next())
            {
                Gruppo tmpGruppo = new Gruppo(set.getInt("id"), set.getString("nome"), set.getString("urlIcona"), this.getGroupFounderId(set.getInt("id")));
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
                " WHERE idUtente = ?"+ //idUtente
                " AND idGruppo = ?"; //idGruppo
        
        int resultCount = 0;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idUtente);
            stmt.setInt(2, idGruppo);
            
            ResultSet set = stmt.executeQuery();
            
            while(set.next()) { resultCount++; }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }
        
        if(resultCount > 0) return true;
        else return false;
        
    }
    public void registerSubscription(int userId, int groupId)
    {
        String query = "INSERT INTO iscrizioniGruppi (idUtente, idGruppo) VALUES (?, ?)"; //userId, groupId
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, groupId);
            
            stmt.executeUpdate();        
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }       
    }
    public int getGroupFounderId(int groupId)
    {
        String query = "SELECT fondatore FROM gruppi WHERE id = ?"; //groupId
        int returnValue = -1;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, groupId);
            
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
                returnValue = set.getInt("fondatore");                
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }  
        
        return returnValue;        
    }
    public boolean deleteGroupById(int groupId) throws SQLException
    {
        String query = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {
            conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            conn.setAutoCommit(false);
            
            // ELIMINA POST GRUPPO
            query = "DELETE FROM posts WHERE idGruppoDest = ?"; //groupId
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, groupId);
            
            stmt.executeUpdate();
            
            // ELIMINA ISCRIZIONI
            query = "DELETE FROM iscrizioniGruppi WHERE idGruppo = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, groupId);
            
            stmt.executeUpdate();
            
            // ELIMINA GRUPPO
            query = "DELETE FROM gruppi WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, groupId);
            
            stmt.executeUpdate();
            
            
            //COMMITTA CHIUDI
            conn.commit();            
            
            conn.setAutoCommit(true);
            
            stmt.close();
            conn.close();  
            return true;
        }
        catch(SQLException ex)
        {
            conn.rollback();           
            conn.setAutoCommit(true);
            
            stmt.close();
            conn.close();  
            return false;
        }
    }
    
    public String getConnectionUsername() { return connectionUsername; }
    public void setConnectionUsername(String connectionUsername) { this.connectionUsername = connectionUsername; }
    public String getConnectionPassword() { return connectionPassword; }
    public void setConnectionPassword(String connectionPassword) { this.connectionPassword = connectionPassword; }  
}
