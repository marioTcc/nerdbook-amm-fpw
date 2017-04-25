
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 * @author Mario Taccori
 */

public class GruppoFactory {
    
    private static GruppoFactory singleton;
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();
    
    private GruppoFactory()
    {
        this.listaGruppi=DataMigrator.getInstance().getAllGroups();
    }

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
        return singleton;
    }
    
    public ArrayList<Gruppo> getSubscribedGroups(UtenteSecure t)
    {
        ArrayList<Gruppo> subscribedGroups=new ArrayList<>();
        
        for(Gruppo tmp : this.listaGruppi)
        {
            if(tmp.getIscritti().contains(t))
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
