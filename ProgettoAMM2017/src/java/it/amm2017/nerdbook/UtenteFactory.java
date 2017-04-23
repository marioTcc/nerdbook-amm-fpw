
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
        // Utente1
        Utente utente1 = new Utente();
        utente1.setId(0);
        
        utente1.setNome("Djanni");
        utente1.setCognome("Gatto");
        
        utente1.setEmail("djannigatto@gmail.com");
        
        utente1.setUsername("DjG");
        utente1.setPassword("123");
        
        utente1.setUrlFotoProfilo("Assets/IMG/djanniprofilo.jpg");
        utente1.setFrasePresentazione("ciao a tutti, sono io, Djanni");
        utente1.setDataNascita("10/10/2010");

        // Utente2
        Utente utente2 = new Utente();
        utente2.setId(1);
        
        utente2.setNome("Heavy");
        utente2.setCognome("Breathing");
        
        utente2.setEmail("cholansia@gmail.com");
   
        utente2.setUsername("HeavyBreathing");
        utente2.setPassword("123");
        
        utente2.setUrlFotoProfilo("");
        utente2.setFrasePresentazione("ciao");
        utente2.setDataNascita("10/10/2010");

        // Utente3
        Utente utente3 = new Utente();
        utente3.setId(2);
        
        utente3.setNome("Gym");
        utente3.setCognome("WorkOut");
        
        utente3.setUsername("GymWorkOut");        
        utente3.setEmail("doIt@gmail.com");
        
        utente3.setPassword("123");
        
        utente3.setUrlFotoProfilo("");
        utente3.setFrasePresentazione("ciao");
        utente3.setDataNascita("10/10/2010");

        // Utente4
        Utente utente4 = new Utente();
        utente4.setId(3);
        
        utente4.setNome("Chao");
        utente4.setCognome("Povery");
        
        utente4.setEmail("r1tchb1tch@gmail.com");
        
        utente4.setUsername("ChaoPovery"); 
        utente4.setPassword("123");
        
        utente4.setUrlFotoProfilo("");
        utente4.setFrasePresentazione("ciao");
        utente4.setDataNascita("10/10/2010");
        
        // Incompleto
        Utente incompleto = new Utente();
        incompleto.setId(4);
        
        incompleto.setNome("Djanni");
        incompleto.setCognome("");
        
        incompleto.setEmail("");
        
        incompleto.setUsername("incompleto");
        incompleto.setPassword("sonoincompleto");
        
        incompleto.setUrlFotoProfilo("");
        incompleto.setFrasePresentazione("ciao");
        incompleto.setDataNascita("10/10/2010");

        
        // Lista utenti
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
        listaUtenti.add(utente4);
        listaUtenti.add(incompleto);
    }

    public static UtenteFactory getInstance()
    {
        if (singleton == null)
            singleton = new UtenteFactory();
        
        return singleton;
    }
       
    public static boolean checkCompletion(UtenteSecure t) throws IllegalAccessException,
                     IllegalArgumentException,
                     InvocationTargetException
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
    
    
    public Utente getUtenteById(int id)
    {
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getId() == id) 
                return tmpUser;
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
    
    public ArrayList<Utente> cercaUtente(String nome, String cognome)
    {
        ArrayList<Utente> utentiTrovati= new ArrayList<Utente>();
        
        for (Utente tmpUser : this.listaUtenti) 
        {
            if (tmpUser.getNome().equals(nome) && tmpUser.getCognome().equals(cognome)) 
                utentiTrovati.add(tmpUser);
        }
        
        return utentiTrovati;        
    }
}
