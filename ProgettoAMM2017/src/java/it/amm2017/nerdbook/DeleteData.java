/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amm2017.nerdbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User1
 */
public class DeleteData extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        if(session == null || session.getAttribute("loggedIn").equals(false)) response.sendRedirect("login.html");
        else if(session.getAttribute("loggedIn").equals(true))
        {
            UtenteSecure tmp = UtenteFactory.getInstance().getUtenteById((int)request.getSession(false).getAttribute("user"));
            request.setAttribute("user", tmp);
            request.setAttribute("groups", GruppoFactory.getInstance().getAllGroups());
            request.setAttribute("users", UtenteFactory.getInstance().getAllUsers(new ArrayList<>(Arrays.asList(tmp.getId()))));
                            
            switch(request.getParameter("action"))
            {
                case "deletePost":
                    if(UtenteFactory.getInstance().getTipoUtente(tmp) == Utente.TipoUtente.ADMIN)
                        PostFactory.getInstance().deletePostList(new ArrayList<>(Arrays.asList(Integer.parseInt(request.getParameter("postId")))));
                    response.sendRedirect("bacheca.html?owner="+request.getParameter("owner")+"&ownerType="+request.getParameter("ownerType"));
                    return;

                case "deleteGroup": //TODO VA QUI?
                    if(UtenteFactory.getInstance().getTipoUtente(tmp) == Utente.TipoUtente.ADMIN
                      || GruppoFactory.getInstance().getGroupFounderId(Integer.parseInt(request.getParameter("groupId"))) == (int)session.getAttribute("user"))
                    {
                        try { GruppoFactory.getInstance().deleteGroupById(Integer.parseInt(request.getParameter("groupId"))); }
                        catch(Exception ex){}
                    }

                    // TORNA INDIETRO
                    String requestUrl = request.getHeader("referer");
                    Pattern p = Pattern.compile("\\/[a-zA-Z]*\\.html");
                    Matcher m = p.matcher(requestUrl);
                    
                    if(m.find())
                    {
                        switch(m.group(0))
                        {
                            case "/bacheca.html":
                                response.sendRedirect("bacheca.html?action=view&ownerType="+request.getParameter("ownerType")+"&owner="+request.getParameter("owner"));
                                return;
                                
                            case "/profilo.html":
                                response.sendRedirect("profilo.html");
                                return;
                                
                            case "/descrizione.html":
                                response.sendRedirect("descrizione.html");
                                return;
                                
                            default:
                                response.sendRedirect("login.html");
                                return;
                        }
                    }
                    return; 


                case "deleteAccount":
                    try
                    {
                        if(UtenteFactory.getInstance().deleteAccount((int)request.getSession(false).getAttribute("user")))
                            response.sendRedirect("login.html?action=logout");                     
                    }
                    catch(Exception ex){ response.sendRedirect("profilo.html?deletionError=true"); }
                    return;
            }    
        }
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
