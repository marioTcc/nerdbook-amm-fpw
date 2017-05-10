
package it.amm2017.nerdbook;

/**
 * @author Mario Taccori
 */

public class Utente extends UtenteSecure
{
    private String username;
    private String password;
    
    public Utente()
    {
        super();
        this.username = "";
        this.password = "";              
    }  
    
    public Utente(int id, String nome, String cognome, String email, String dataNascita, String urlFotoProfilo, String frasePresentazione, String username, String password)
    {
        super(id, nome, cognome, email, dataNascita, urlFotoProfilo, frasePresentazione);
        this.username = username;
        this.password = password;
    }
    
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
