
package it.amm2017.nerdbook;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author Mario Taccori
 */

public class UtenteFactory {
    
    private static UtenteFactory singleton;
    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    
    private UtenteFactory()
    {
        this.listaUtenti = DataMigrator.getInstance().getAllUsers();
    }

    public static UtenteFactory getInstance()
    {
        if (singleton == null)
            singleton = new UtenteFactory();
        
        return singleton;
    }
       
    public static boolean checkCompletion(UtenteSecure t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        String tmp="";
        String dummy="";
        Method [] methods=t.getClass().getDeclaredMethods();
        
        for(Method m : methods)
        {
            if(m.getName().startsWith("get") && m.getReturnType()==String.class)
            {
                if(m.getName().endsWith("Nome") || m.getName().endsWith("Cognome") 
                        || m.getName().endsWith("FrasePresentazione") || m.getName().endsWith("UrlFotoProfilo") )
                {
                    tmp=(String)m.invoke(t);
                    if(tmp.equals(dummy))
                        return false;
                }
            }
        }      
        return true;
    }
       
    public UtenteSecure getUtenteById(int id)
    {
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getId() == id) 
                return new UtenteSecure(tmpUser);
        }    
        return null;
    }
    
    public Utente getUtenteByUsername(String username)
    {
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getUsername().equals(username))
                return tmpUser;
        }  
        return null;
    }
    
    public ArrayList<UtenteSecure> cercaUtente(String nome, String cognome)
    {
        ArrayList<UtenteSecure> utentiTrovati= new ArrayList<UtenteSecure>();
        
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getNome().equals(nome) && tmpUser.getCognome().equals(cognome)) 
                utentiTrovati.add(new UtenteSecure(tmpUser));
        }
        
        return utentiTrovati;        
    }
    
    public ArrayList<UtenteSecure> getFriends(UtenteSecure t)
    {
        ArrayList<UtenteSecure> tmp = new ArrayList<UtenteSecure>();
        for(Utente u : this.listaUtenti)
        {
            if(!((UtenteSecure)u).equals(t))
                tmp.add(new UtenteSecure(u));
        }
        
        return tmp;
    }
}
