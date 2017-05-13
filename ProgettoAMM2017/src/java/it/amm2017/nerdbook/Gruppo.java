
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 * @author Mario Taccori
 */

public class Gruppo {
    
    private int id;
    private String nome;
    private String groupIconUrl;
    private int fondatore;
    
    public Gruppo()
    {
        this.nome = "";
        this.id = -1;
        this.groupIconUrl = "";
        this.fondatore = -1;
    }    
    public Gruppo(int id, String nome, String iconUrl, int fondatore)
    {
        this.id = id;
        this.nome = nome;
        this.groupIconUrl = iconUrl;
        this.fondatore = fondatore;
    }          
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
	if(obj==this)
            return true;

	if(!(obj instanceof Gruppo))
            return false;

	if(this.id==((Gruppo) obj).getId())
            return true;

	return false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getGroupIconUrl() { return groupIconUrl; }
    public void setGroupIconUrl(String groupIconUrl) { this.groupIconUrl = groupIconUrl; }   
    public int getFondatore() { return fondatore; }
    public void setFondatore(int fondatore) { this.fondatore = fondatore; }
}
