
package it.amm2017.nerdbook;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mario Taccori
 */

public class GruppoFactory {
    
    private static GruppoFactory singleton;
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private GruppoFactory()
    {
        UtenteFactory tmp = UtenteFactory.getInstance();
        
        // Gruppo 1
        Gruppo gruppo1=new Gruppo();
        gruppo1.setId(0);
        gruppo1.setNome("Molgonfieristi");
        gruppo1.setGroupIconUrl("Assets/ICONS/molgonfieristi_icona.svg");
        gruppo1.setIscritti(new ArrayList<UtenteSecure>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(1), tmp.getUtenteById(2))));
        
        // Gruppo 2
        Gruppo gruppo2=new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNome("Ritardatari");
        gruppo2.setGroupIconUrl("Assets/ICONS/ritardatari_icona.svg");
        gruppo2.setIscritti(new ArrayList<UtenteSecure>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(2))));
        
        // Gruppo 3
        Gruppo gruppo3=new Gruppo();
        gruppo3.setId(2);
        gruppo3.setNome("Fittizio1");
        gruppo3.setGroupIconUrl("Assets/ICONS/error_icona.svg");
        gruppo3.setIscritti(new ArrayList<UtenteSecure>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(1), tmp.getUtenteById(2))));
        
        
        // Lista Gruppi
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        listaGruppi.add(gruppo3);
     
    }

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
        return singleton;
    }
    
    public ArrayList<Gruppo> getSubscribedGroups(UtenteSecure utente)
    {
        ArrayList<Gruppo> subscribedGroups=new ArrayList<>();
        
        for(Gruppo tmp : this.listaGruppi)
        {
            if(tmp.getIscritti().contains(utente))
                subscribedGroups.add(tmp);
        }
        
        return subscribedGroups;
    }
       
    public Gruppo getGruppoById(int id)
    {
        for (Gruppo tmpGruppo : this.listaGruppi) 
        {
            if (tmpGruppo.getId() == id) 
                return tmpGruppo;
        }
        return null;
    }
}
