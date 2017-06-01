
package it.amm2017.nerdbook;

import java.time.LocalDate;

/**
 * @author Mario Taccori
 */

public class UtenteSecure
{
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String urlFotoProfilo;
    private String frasePresentazione;
    
    public UtenteSecure()
    {
        this.id=-1;
        this.nome= "";
        this.cognome="";
        this.email="";
        this.dataNascita = LocalDate.of(1999, 01, 01);
        this.urlFotoProfilo="";
        this.frasePresentazione="";
    }     
    public UtenteSecure(Utente utente)
    {
        this.id = utente.getId();
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();
        this.email = utente.getEmail();
        this.dataNascita = utente.getDataNascita();
        this.urlFotoProfilo = utente.getUrlFotoProfilo();
        this.frasePresentazione = utente.getFrasePresentazione();                
    }   
    public UtenteSecure(int id, String nome, String cognome, String email, LocalDate dataNascita, String urlFotoProfilo, String frasePresentazione)
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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getDataNascita() { return dataNascita; }
    public void setDataNascita(LocalDate dataNascita) { this.dataNascita = dataNascita; }
    public String getUrlFotoProfilo() { return urlFotoProfilo; }
    public void setUrlFotoProfilo(String urlFotoProfilo) { this.urlFotoProfilo = urlFotoProfilo; }
    public String getFrasePresentazione() { return frasePresentazione; }
    public void setFrasePresentazione(String frasePresentazione) { this.frasePresentazione = frasePresentazione; } 
    
    public UtenteSecureEssential getEssentials(){ return new UtenteSecureEssential(this.nome, this.cognome, this.urlFotoProfilo, this.id); }   
}
