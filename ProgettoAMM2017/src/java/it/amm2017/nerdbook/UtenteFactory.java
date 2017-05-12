
package it.amm2017.nerdbook;

import java.sql.Statement;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
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

public class UtenteFactory
{   
    private static UtenteFactory singleton;
    private String connectionString;
    private String connectionUsername;
    private String connectionPassword;
    
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
    public UtenteSecure getUtenteById(int id) 
    {
        UtenteSecure tmp = null;
        String query = "select * from utenti where id = ?"; //id
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            
            set = stmt.executeQuery();
             
            if(set.next())
            {
                tmp = new UtenteSecure(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toLocalDate(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione")
                        );
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex); }
            
        
        return tmp;
    }   
    public Utente getUtenteCompleteById(int id) 
    {
        Utente tmp = null;
        String query = "SELECT utenti.*, tipiUtente.nomeTipoUtente FROM utenti JOIN tipiUtente ON utenti.tipoUtente = tipiUtente.ID WHERE utenti.id = ?"; //id
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            
            set = stmt.executeQuery();
             
            if(set.next())
            {
                tmp = new Utente(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toLocalDate(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione"),
                        set.getString("username"), set.getString("password"), set.getString("nomeTipoUtente"));
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
                " WHERE username = ?"; //username
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            
            set = stmt.executeQuery();
             
            if(set.next())
            {
                tmp = new Utente(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toLocalDate(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione"),
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
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
                       
            while(set.next())
            {
                tmpUtente = new UtenteSecure(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toLocalDate(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione")
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
                " WHERE utenti.id = ?"; //utente.getId()
        
        ResultSet set = null;
        Utente.TipoUtente tipo = Utente.TipoUtente.INVALID;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, utente.getId());
            
            set = stmt.executeQuery();
            
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
                " WHERE (idUtente1 = ?"+ //id1
                " OR idUtente1 = ?"+ //id2
                " )"+
                " AND (idUtente2 = ?"+ //id1
                " OR idUtente2 = ?)"; //id2
        
        ResultSet set = null;
        int resultCount = 0;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id1);
            stmt.setInt(2, id2);
            stmt.setInt(3, id1);
            stmt.setInt(4, id2);
            
            set = stmt.executeQuery();
            
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
        String query = "INSERT INTO amici (idUtente1, idUtente2) VALUES (?, ?)"; //userId1, userId2
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId1);
            stmt.setInt(2, userId2);
            
            stmt.executeUpdate();    
            
            stmt.setInt(1, userId2);
            stmt.setInt(2, userId1);
            stmt.executeUpdate();  
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }       
    }
    public void updateUserInfo(Utente _new) throws java.text.ParseException
    {
        
        String query = "UPDATE utenti SET nome = ?"+ //_new.getNome()
                ", cognome = ?"+ //_new.getCognome()
                ", urlFotoProfilo = ?"+ //_new.getUrlFotoProfilo()
                ", frasePresentazione = ?"+ //_new.getFrasePresentazione()
                ", password = ?"+ //_new.getPassword()
                ", dataNascita = ?"+ //_new.getDataNascita()
                " WHERE id = ?"; //_new.getId()
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
           
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, _new.getNome());
            stmt.setString(2, _new.getCognome());
            stmt.setString(3, _new.getUrlFotoProfilo());
            stmt.setString(4, _new.getFrasePresentazione());
            stmt.setString(5, _new.getPassword());
            stmt.setDate(6, java.sql.Date.valueOf(_new.getDataNascita()));
            stmt.setInt(7, _new.getId());
            
            stmt.executeUpdate();    
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex) { Logger.getLogger(GruppoFactory.class.getName()).log(Level.SEVERE, null, ex); }    
        
    }
    public boolean deleteAccount(int userId) throws SQLException
    {
        String query = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try
        {
            conn = DriverManager.getConnection(this.getConnectionString(), this.getConnectionUsername(), this.getConnectionPassword());
            conn.setAutoCommit(false);
            
            // ELIMINA POST FATTI DA UTENTE
            query = "DELETE FROM posts WHERE autore = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            
            stmt.executeUpdate();
            
            // ELIMINA POST BACHECA UTENTE
            query = "DELETE FROM posts WHERE idUtenteDest = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            
            stmt.executeUpdate();
            
            // ELIMINA AMICIZIE
            query = "DELETE FROM amici WHERE idUtente1 = ? OR idUtente2 = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setInt(2, userId);
            
            stmt.executeUpdate();

            // ELIMINA ISCRIZIONI GRUPPI 
            query = "DELETE FROM iscrizioniGruppi WHERE idUtente = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            
            stmt.executeUpdate();
            
            // ELIMINA UTENTE
            query = "DELETE FROM utenti WHERE id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            
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
