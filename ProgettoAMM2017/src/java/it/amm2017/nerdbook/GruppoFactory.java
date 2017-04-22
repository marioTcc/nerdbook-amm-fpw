
package it.amm2017.nerdbook;

import it.amm2017.nerdbook.UtenteFactory; // TMP?
import java.util.ArrayList;
import java.util.Arrays; // TMP?

/**
 *
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
        gruppo1.setGroupIconUrl("Assets/ICONS/molgonfieristiIcon.svg");
        gruppo1.setIscritti(new ArrayList<Utente>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(1))));
        
        // Gruppo 1
        Gruppo gruppo2=new Gruppo();
        gruppo2.setId(1);
        gruppo2.setNome("Ritardatari");
        gruppo2.setGroupIconUrl("Assets/ICONS/ritardatariIcon.svg");
        gruppo2.setIscritti(new ArrayList<Utente>(Arrays.asList(tmp.getUtenteById(0), tmp.getUtenteById(2))));
        
        
        // Lista Gruppi
        this.listaGruppi.add(gruppo1);
        this.listaGruppi.add(gruppo2);
    }

    public static GruppoFactory getInstance()
    {
        if (singleton == null)
            singleton = new GruppoFactory();
        
        return singleton;
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
