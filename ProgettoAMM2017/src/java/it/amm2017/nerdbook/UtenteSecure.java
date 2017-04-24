
package it.amm2017.nerdbook;

/**
 * @author User1
 */

public class UtenteSecure
{
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String dataNascita;
    private String urlFotoProfilo;
    private String frasePresentazione;
    
    public UtenteSecure()
    {
        this.id=-1;
        this.nome= "";
        this.cognome="";
        this.email="";
        this.dataNascita="";
        this.urlFotoProfilo="";
        this.frasePresentazione="";                
    }   
    
    public UtenteSecure(Utente t)
    {
        this.id=t.getId();
        this.nome= t.getNome();
        this.cognome=t.getCognome();
        this.email=t.getEmail();
        this.dataNascita=t.getDataNascita();
        this.urlFotoProfilo=t.getUrlFotoProfilo();
        this.frasePresentazione=t.getFrasePresentazione();                
    }
    
    public UtenteSecure(int id, String nome, String cognome, String email, String dataNascita, String urlFotoProfilo, String frasePresentazione)
    {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.urlFotoProfilo = urlFotoProfilo;
        this.frasePresentazione = frasePresentazione;
    }
    
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
	if(obj==this)
            return true;

	if(!(obj instanceof UtenteSecure))
            return false;

	if(this.id==((UtenteSecure) obj).getId())
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
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    /**
     * @return the frasePresentazione
     */
    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    /**
     * @param frasePresentazione the frasePresentazione to set
     */
    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }
    
}
