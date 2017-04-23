
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
        
        utente2.setNome("HeavyBreathing");
        utente2.setCognome("Utente");
        
        utente2.setEmail("cholansia@gmail.com");
   
        utente2.setPassword("123");
        
        utente2.setUrlFotoProfilo("img/user1.gif");
        utente2.setFrasePresentazione("ciao");
        utente2.setDataNascita("10/10/2010");

        // Utente3
        Utente utente3 = new Utente();
        utente3.setId(2);
        
        utente3.setNome("GymWorkOut");
        utente3.setCognome("Utente");  
        
        utente3.setEmail("doIt@gmail.com");
        
        utente3.setPassword("123");
        
        utente3.setUrlFotoProfilo("img/user2.jpg");
        utente3.setFrasePresentazione("ciao");
        utente3.setDataNascita("10/10/2010");

        // Utente4
        Utente utente4 = new Utente();
        utente4.setId(3);
        
        utente4.setNome("ChaoPovery");
        utente4.setCognome("Utente");
        
        utente4.setEmail("r1tchb1tch@gmail.com");
        
        utente4.setPassword("123");
        
        utente4.setUrlFotoProfilo("img/user3.jpg");
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
       
    public static boolean checkCompletion(Utente t) throws IllegalAccessException,
                     IllegalArgumentException,
                     InvocationTargetException
    {
        String tmp="";
        String dummyEmpty="";
        Method [] methods=t.getClass().getDeclaredMethods();
        
        for(Method m : methods)
        {
            if(m.getName().startsWith("get") && m.getReturnType()==String.class)
            {
                tmp=(String)m.invoke(t);
                if(tmp.equals(dummyEmpty))
                    return false;
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
