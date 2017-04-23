
package it.amm2017.nerdbook;

/**
 * @author Mario Taccori
 */

public class Post {

    public enum PostType
    {
        TESTO, IMMAGINE, LINK
    };
    
    private int id;
    private Utente autorePost;
    private String contenuto;
    private PostType tipoPost;
    private String imgUrl;
    private String attachedLink;
    
    public Post()
    {
        this.id=-1;
        this.autorePost=null;
        this.contenuto="";
        this.imgUrl="";
        this.attachedLink="";
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
    public Utente getAutorePost() {
        return autorePost;
    }

    /**
     * @param autorePost the autorePost to set
     */
    public void setAutorePost(Utente autorePost) {
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
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the attachedLink
     */
    public String getAttachedLink() {
        return attachedLink;
    }

    /**
     * @param attachedLink the attachedLink to set
     */
    public void setAttachedLink(String attachedLink) {
        this.attachedLink = attachedLink;
    }
    
}
