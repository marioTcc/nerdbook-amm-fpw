
package it.amm2017.nerdbook;

import java.util.ArrayList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mario Taccori
 */

public class Bacheca extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        
        if(session!=null)
        {
            if(session.getAttribute("loggedIn")!=null && session.getAttribute("loggedIn").equals(true))
            {
                if(request.getParameter("action") == null)
                    this.loadView(request);
                else
                {
                    switch (request.getParameter("action")) 
                    {
                        case "view":
                            this.loadView(request);
                            break;
                        case "newPost":
                            this.loadNewPost(request);
                            break;
                        case "confirmNewPost":
                            this.confirmNewPost(request);
                            break;
                        case "cancelNewPost":
                            this.loadView(request);
                            break;
                        default:
                            break;
                    }
                }
            }
            
            request.getRequestDispatcher("M2/bacheca.jsp").forward(request, response);
        }
        else response.sendRedirect("login.html");
    }
    
    public void loadView(HttpServletRequest request) 
    {
        UtenteSecure us;
        
        if(request.getParameter("owner")!=null)
            us = UtenteFactory.getInstance().getUtenteById(Integer.parseInt(request.getParameter("owner")));
        else 
            us =(UtenteSecure)request.getSession().getAttribute("user");

        ArrayList<Post> listaPost = PostFactory.getInstance().getPostList(us);

        request.setAttribute("owner", us);
        request.setAttribute("listaPost", listaPost); 
        
    }
    
    public void loadNewPost(HttpServletRequest request)
    {
        this.loadView(request);
        request.setAttribute("confirmRequired", true);
        
        Post.PostType tmpType = Post.PostType.TESTO;
        
        if(request.getParameter("postType")!=null)
        {
            switch(request.getParameter("postType"))
            {
                case "":
                    tmpType = Post.PostType.TESTO;
                    break;
                
                case "immagine":
                    tmpType = Post.PostType.IMMAGINE;
                    break;
                    
                case "link":
                    tmpType = Post.PostType.LINK;
                    break;
            }
        }
        else tmpType = Post.PostType.TESTO;
                    
        Post previewPost = PostFactory.getInstance().getFakePost((UtenteSecure) request.getSession(false).getAttribute("user"),
                request.getParameter("contenuto"), tmpType, request.getParameter("allegato"), Post.DestinationType.BACHECA);
        
        request.setAttribute("previewPost", previewPost);
        
              
    }
    
    public void confirmNewPost(HttpServletRequest request)
    {  
        this.loadView(request);
        //CHIAMA DATAMIGRATOR PER SALVARE IL NUOVO POST NEL DB
        request.setAttribute("postState", "created");
    }
    
    
    
    
    
    
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
