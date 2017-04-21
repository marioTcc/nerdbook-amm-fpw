
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 *
 * @author Mario Taccori
 */
public class GruppoFactory {
    
    private static GruppoFactory singleton;
    private ArrayList<Gruppo> listaUtenti = new ArrayList<Gruppo>();
    
    private GruppoFactory()
    {}

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
        return singleton;
    }
       
    public Gruppo getUtenteById(int id)
    {
        for (Gruppo tmpGruppo : this.listaUtenti) 
        {
            if (tmpGruppo.getId() == id) 
                return tmpGruppo;
        }
        return null;
    }
    
    
}
