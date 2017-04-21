
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 *
 * @author Mario Taccori
 */
public class UtenteFactory {
    
    private static UtenteFactory singleton;
    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    
    private UtenteFactory()
    {}

    public static UtenteFactory getInstance()
    {
        if (singleton == null)
            singleton = new UtenteFactory();
        
        return singleton;
    }
       
    public Utente getUtenteById(int id)
    {
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getId() == id) 
                return tmpUser;
        }
        
        return null;
    }
    
    public ArrayList<Utente> cercaUtente(String nome, String cognome)
    {
        ArrayList<Utente> utentiTrovati= new ArrayList<Utente>();
        
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getNome() == nome && tmpUser.getCognome() == cognome) 
                utentiTrovati.add(tmpUser);
        }
        
        return utentiTrovati;        
    }
}
