
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 * @author Mario Taccori
 */

public class Gruppo {
    
    private int id;
    private String nome;
    private String groupIconUrl;
    private ArrayList<UtenteSecure> iscritti;
    
    public Gruppo()
    {
        this.nome="";
        this.id=-1;
        this.iscritti=new ArrayList<UtenteSecure>();
        this.groupIconUrl="";
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the iscritti
     */
    public ArrayList<UtenteSecure> getIscritti() {
        return iscritti;
    }

    /**
     * @param iscritti the iscritti to set
     */
    public void setIscritti(ArrayList<UtenteSecure> iscritti) {
        this.iscritti = iscritti;
    }

    /**
     * @return the groupIconUrl
     */
    public String getGroupIconUrl() {
        return groupIconUrl;
    }

    /**
     * @param groupIconUrl the groupIconUrl to set
     */
    public void setGroupIconUrl(String groupIconUrl) {
        this.groupIconUrl = groupIconUrl;
    }
    
}
