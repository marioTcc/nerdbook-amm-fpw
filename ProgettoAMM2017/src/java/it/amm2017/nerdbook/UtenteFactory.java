
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

public class UtenteFactory {
    
    private static UtenteFactory singleton;
    private String connectionString;
    
    private UtenteFactory()
    { 
        
    }

    public static UtenteFactory getInstance()
    {
        if (singleton == null)
            singleton = new UtenteFactory();
        
        return singleton;
    }
    
    public void setConnectionString(String s)
    {
	this.connectionString = s;
    }
    
    public String getConnectionString()
    {
	return this.connectionString;
    }
       
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
        catch (SQLException ex)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return tmp;
    }
    
    public Utente getUtenteByUsername(String username) 
    {
        Utente tmp = null;      
        String query = "select * from utenti where username='"+username+"'";
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
                        set.getString("username"), set.getString("password"));
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return tmp;
    }
    
    public ArrayList<UtenteSecure> cercaUtente(String nome, String cognome)
    {/*
        ArrayList<UtenteSecure> utentiTrovati= new ArrayList<UtenteSecure>();
        
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getNome().equals(nome) && tmpUser.getCognome().equals(cognome)) 
                utentiTrovati.add(new UtenteSecure(tmpUser));
        }
        
        return utentiTrovati; */ return null;       
    }
    
    public ArrayList<UtenteSecure> getFriends(UtenteSecure utente)
    {
        
        ArrayList<UtenteSecure> tmp = new ArrayList<>();/*
        UtenteSecure tmpUtente = null;
        String query = "SELECT * FROM amici JOIN utenti ON utenti.id = amici.idUtente1"+" WHERE amici.idUtente1 ="+utente.getId();
        ResultSet set = null;
        
        try
        {
            Connection conn = DriverManager.getConnection(this.getConnectionString(), "ali_baba", "apriti sesamo");
            Statement stmt = conn.createStatement();
            
            set = stmt.executeQuery(query);
             
            if(set.next())
            {
                tmpUtente = new UtenteSecure(set.getInt("id"), set.getString("nome"), set.getString("cognome"),
                        set.getString("email"), set.getDate("dataNascita").toString(), set.getString("urlFotoProfilo"), set.getString("frasePresentazione")
                        );

                tmp.add(tmpUtente);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
        return tmp;
        
    }
    
    public ArrayList<UtenteSecure> getAllUsers()
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

                tmp.add(tmpUtente);
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tmp;
        
    }
}
