
package it.amm2017.nerdbook;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Mario Taccori
 */

public class Profilo extends HttpServlet {

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
            if(request.getParameter("action")==null)
            {                
                try{ loadData(request); }
                catch(Exception ex){}
            }
            else if(request.getParameter("action").equals("updateInfo"))
            {
                // AGGIORNAMENTO FITTIZIO DEI DATI (SOLO IN SESSIONE PER ORA)
                UtenteSecure _old = (UtenteSecure)session.getAttribute("user");
                UtenteSecure _new = new UtenteSecure(_old.getId(), request.getParameter("userName"),
                                                    request.getParameter("userSurname"), _old.getEmail(),
                                                    request.getParameter("bDate"), request.getParameter("profilePicURL"),
                                                    request.getParameter("presentazione"));
                
                try
                {
                    ArrayList<String> campiModificati = updateUserInfo(request, _old, _new);
                    request.setAttribute("campiModificati", campiModificati);
                    loadData(request);
                }
                catch(Exception ex){}         
            }
            
            try
            {
                if(UtenteFactory.checkCompletion((UtenteSecure)session.getAttribute("user")))
                    request.setAttribute("isUserInfoComplete", true);
                else 
                    request.setAttribute("isUserInfoComplete", false);
            }catch(Exception ex){}
            
            request.getRequestDispatcher("M2/profilo.jsp").forward(request, response);
        }
        else response.sendRedirect("login.html");
    }
    
    public void loadData(HttpServletRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        UtenteSecure utente = (UtenteSecure) request.getSession(false).getAttribute("user");
        Field [] classFields = utente.getClass().getDeclaredFields();
        Method tmpGetter;
        
        for(Field tmp : classFields)
        {
            if(tmp.getType() == String.class)
            {    
                tmpGetter = UtenteSecure.class.getMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1));
                request.setAttribute(tmp.getName(), tmpGetter.invoke(utente).toString());
            }        
        }       
    }
    
    public ArrayList<String> updateUserInfo(HttpServletRequest request, UtenteSecure _old, UtenteSecure _new) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        ArrayList<String> campiModificati = new ArrayList<>();
        Field [] classFields = _old.getClass().getDeclaredFields();
        Method [] classMethods = _old.getClass().getDeclaredMethods();
        Method tmpGetter, tmpSetter;
        
        for(Field tmp : classFields)
        {
            if(tmp.getType() == String.class)
            {    
                tmpGetter = UtenteSecure.class.getMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1));
                tmpSetter = UtenteSecure.class.getMethod("set"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1), String.class);
                
                if(tmpGetter.invoke(_new).toString()!= null
                   && !tmpGetter.invoke(_new).toString().equals("")
                   && !tmpGetter.invoke(_new).toString().equals(tmpGetter.invoke(_old).toString()))
                {
                    campiModificati.add(tmp.getName());
                    tmpSetter.invoke(_old, tmpGetter.invoke(_new));
                }
            }
        }
        
        request.getSession(false).setAttribute("user", _old);
        return campiModificati;                
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
