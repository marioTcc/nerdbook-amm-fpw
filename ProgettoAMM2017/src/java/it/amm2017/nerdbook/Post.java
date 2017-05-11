
package it.amm2017.nerdbook;

/**
 * @author Mario Taccori
 */

public class Post 
{
    public enum PostType { TESTO, IMMAGINE, LINK };
    public enum DestinationType { INVALID, BACHECA, GRUPPO; };
           
    private int id;
    private UtenteSecure autorePost;
    private String contenuto;
    private PostType tipoPost;
    private String attachedUrl;   
    private DestinationType tipoDestinazione;
    private int idDestinazione;    
    private String dataPost;
    
    public Post()
    {
        this.id = -1;
        this.autorePost = null;
        this.contenuto = "";
        this.attachedUrl = "";     
        this.tipoDestinazione = DestinationType.INVALID;
        this.idDestinazione = -1;
        this.dataPost = "1999-01-01";
    }   
    public Post(int id, UtenteSecure autorePost, String contenuto, String tipoPost, String attachedUrl, String tipoDestinazione, int idDestinazione, String dataPost)
    {
        this.id = id;
        this.autorePost = autorePost;
        this.contenuto = contenuto;
        this.attachedUrl = attachedUrl;
        this.idDestinazione = idDestinazione;
        this.dataPost = dataPost;
        
        switch(tipoPost)
        {
            case "IMMAGINE":
                this.tipoPost = PostType.IMMAGINE;
                break;
            case "LINK":
                this.tipoPost = PostType.LINK;
                break;
            default:
                this.tipoPost = PostType.TESTO;
                break;
        }
        
        switch(tipoDestinazione)
        {
            case "BACHECA":
                this.tipoDestinazione = DestinationType.BACHECA;
                break;
            case "GRUPPO":
                this.tipoDestinazione = DestinationType.GRUPPO;
                break;
            default:
                this.tipoDestinazione = DestinationType.INVALID;
                break;
        }
    }         
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
	if(obj==this)
            return true;

	if(!(obj instanceof Post))
            return false;

	if(this.id==((Post) obj).getId())
            return true;

	return false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public UtenteSecure getAutorePost() { return autorePost; }
    public void setAutorePost(UtenteSecure autorePost) { this.autorePost = autorePost; }
    public String getContenuto() { return contenuto; }
    public void setContenuto(String contenuto) { this.contenuto = contenuto; }
    public PostType getTipoPost() { return tipoPost; }
    public void setTipoPost(PostType tipoPost) { this.tipoPost = tipoPost; }
    public String getAttachedUrl() { return attachedUrl; }
    public void setAttachedUrl(String attachedUrl) { this.attachedUrl = attachedUrl; }
    public DestinationType getTipoDestinazione() { return tipoDestinazione; }
    public void setTipoDestinazione(DestinationType tipoDestinazione) { this.tipoDestinazione = tipoDestinazione; }
    public int getIdDestinazione() { return idDestinazione; }
    public void setIdDestinazione(int idDestinazione) { this.idDestinazione = idDestinazione; }
    public String getDataPost() { return dataPost; }
    public void setDataPost(String dataPost) { this.dataPost = dataPost; }
    
}
