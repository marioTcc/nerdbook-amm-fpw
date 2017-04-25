
package it.amm2017.nerdbook;

/**
 * @author Mario Taccori
 */

public class Post {

    public enum PostType
    {
        TESTO, IMMAGINE, LINK
    };
    
    public enum DestinationType
    {
        INVALID, BACHECA, GRUPPO;
    };
         
    
    private int id;
    private UtenteSecure autorePost;
    private String contenuto;
    private PostType tipoPost;
    private String attachedUrl;   
    private DestinationType tipoDestinazione;
    private int idDestinazione;    
    
    public Post()
    {
        this.id=-1;
        this.autorePost=null;
        this.contenuto="";
        this.attachedUrl="";     
        this.tipoDestinazione=DestinationType.INVALID;
        this.idDestinazione=-1;
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
     * @return the autorePost
     */
    public UtenteSecure getAutorePost() {
        return autorePost;
    }

    /**
     * @param autorePost the autorePost to set
     */
    public void setAutorePost(UtenteSecure autorePost) {
        this.autorePost = autorePost;
    }

    /**
     * @return the contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * @param contenuto the contenuto to set
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * @return the tipoPost
     */
    public PostType getTipoPost() {
        return tipoPost;
    }

    /**
     * @param tipoPost the tipoPost to set
     */
    public void setTipoPost(PostType tipoPost) {
        this.tipoPost = tipoPost;
    }

    /**
     * @return the attachedLink
     */
    public String getAttachedUrl() {
        return attachedUrl;
    }

    /**
     * @param attachedLink the attachedLink to set
     */
    public void setAttachedUrl(String attachedUrl) {
        this.attachedUrl = attachedUrl;
    }

    /**
     * @return the tipoDestinazione
     */
    public DestinationType getTipoDestinazione() {
        return tipoDestinazione;
    }

    /**
     * @param tipoDestinazione the tipoDestinazione to set
     */
    public void setTipoDestinazione(DestinationType tipoDestinazione) {
        this.tipoDestinazione = tipoDestinazione;
    }

    /**
     * @return the idDestinazione
     */
    public int getIdDestinazione() {
        return idDestinazione;
    }

    /**
     * @param idDestinazione the idDestinazione to set
     */
    public void setIdDestinazione(int idDestinazione) {
        this.idDestinazione = idDestinazione;
    }
    
}
