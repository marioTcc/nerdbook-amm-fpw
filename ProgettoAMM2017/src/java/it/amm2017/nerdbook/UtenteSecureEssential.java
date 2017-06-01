package it.amm2017.nerdbook;

/**
 * @author Mario Taccori
 */
public final class UtenteSecureEssential
{
    private final String nome;
    private final String cognome;
    private final String urlFotoProfilo;
    private final int id;

    public UtenteSecureEssential(String nome, String cognome, String urlFotoProfilo, int id)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.urlFotoProfilo = urlFotoProfilo;
        this.id = id;
    }

    public String getNome(){ return this.nome; }
    public String getCognome(){ return this.cognome; }
    public String getUrlFotoProfilo(){ return this.urlFotoProfilo; }
    public int getId(){ return this.id; }
}   
