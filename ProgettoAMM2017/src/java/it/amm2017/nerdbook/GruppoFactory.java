
package it.amm2017.nerdbook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mario Taccori
 */

public class GruppoFactory {
    
    private static GruppoFactory singleton;
   
    
    private GruppoFactory()
    {
    }

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
        return singleton;
    }
    
    public ArrayList<Gruppo> getSubscribedGroups(UtenteSecure utente)
    {/*
        ArrayList<Gruppo> subscribedGroups=new ArrayList<>();
        
        for(Gruppo tmp : this.listaGruppi)
        {
            if(tmp.getIscritti().contains(utente))
                subscribedGroups.add(tmp);
        }
        
        return subscribedGroups;*/
        return null;
    }
       
    public Gruppo getGruppoById(int id)
    {/*
        for (Gruppo tmpGruppo : this.listaGruppi) 
        {
            if (tmpGruppo.getId() == id) 
                return tmpGruppo;
        }*/
        return null;
    }
}
