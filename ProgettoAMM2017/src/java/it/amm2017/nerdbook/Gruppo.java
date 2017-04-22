
package it.amm2017.nerdbook;

import java.util.ArrayList;

/**
 *
 * @author Mario Taccori
 */

public class Gruppo {
    
    private int id;
    private String nome;
    private String groupIconUrl;
    private ArrayList<Utente> iscritti;
    
    public Gruppo()
    {
        this.nome="";
        this.id=-1;
        this.iscritti=new ArrayList<Utente>();
        this.groupIconUrl="";
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
    public ArrayList<Utente> getIscritti() {
        return iscritti;
    }

    /**
     * @param iscritti the iscritti to set
     */
    public void setIscritti(ArrayList<Utente> iscritti) {
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
