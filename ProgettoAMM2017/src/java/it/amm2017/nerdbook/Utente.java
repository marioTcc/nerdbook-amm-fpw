package it.amm2017.nerdbook;

import java.time.LocalDate;

/**
 * @author Mario Taccori
 */
public final class Utente extends UtenteSecure
{
    public enum TipoUtente { INVALID, ADMIN, USER; };
        
    private String username;
    private String password;
    private TipoUtente tipoUtente;
    
    public Utente()
    {
        super();
        this.username = "";
        this.password = ""; 
        this.tipoUtente = TipoUtente.INVALID;
    }    
    public Utente(int id, String nome, String cognome, String email, LocalDate dataNascita, String urlFotoProfilo, String frasePresentazione, String username, String password, String tipoUtente)
    {
        super(id, nome, cognome, email, dataNascita, urlFotoProfilo, frasePresentazione);
        this.username = username;
        this.password = password;
        
        switch(tipoUtente)
        {
            case "ADMIN":
                this.tipoUtente = TipoUtente.ADMIN;
                break;
            case "USER":
                this.tipoUtente = TipoUtente.USER;
                break;
            default:
                this.tipoUtente = TipoUtente.INVALID;
                break;               
        }
    }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public TipoUtente getTipoUtente() { return tipoUtente; }
    public void setTipoUtente(TipoUtente tipoUtente) { this.tipoUtente = tipoUtente; }
}
