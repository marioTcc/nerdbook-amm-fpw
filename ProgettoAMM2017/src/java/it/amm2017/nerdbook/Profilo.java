
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;

/**
 * @author Mario Taccori
 */
@WebServlet( name = "Profilo", urlPatterns = {"/profilo.html"})
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
        
        if(session!=null && session.getAttribute("loggedIn").equals(true))
        {                                
            if(request.getParameter("action")==null)
            {                
                try{ loadData(request); } catch(Exception ex){}
            }
            else if(request.getParameter("action").equals("updateInfo"))
            {
                try
                {
                    Utente _oldComplete = UtenteFactory.getInstance().getUtenteCompleteById((int)session.getAttribute("user"));
                    
                    Utente _new = new Utente(_oldComplete.getId(), request.getParameter("userName"),
                                                        request.getParameter("userSurname"), _oldComplete.getEmail(),
                                                        LocalDate.parse(request.getParameter("bDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                                                        request.getParameter("profilePicURL"),
                                                        request.getParameter("presentazione"), _oldComplete.getUsername(),
                                                        request.getParameter("password"), _oldComplete.getTipoUtente().toString());
        
                    
                    ArrayList<String> campiModificati = updateUserInfo(request, _oldComplete, _new);
                    
                    if(campiModificati.isEmpty()) request.setAttribute("campiModificati", "none");
                    else request.setAttribute("campiModificati", campiModificati);
                    
                    loadData(request);
                }
                catch(Exception ex){}
                
            }
            
            try
            {
                if(UtenteFactory.checkCompletion(UtenteFactory.getInstance().getUtenteById((int)request.getSession(false).getAttribute("user"))))
                    request.setAttribute("isUserInfoComplete", true);
                else request.setAttribute("isUserInfoComplete", false);
                
            } catch(Exception ex){}
            
            UtenteSecure tmp = UtenteFactory.getInstance().getUtenteById((int)request.getSession(false).getAttribute("user"));
            request.setAttribute("user", tmp);
            request.setAttribute("dataNascitaString", tmp.getDataNascita().getYear()+"-"+tmp.getDataNascita().getMonthValue()+"-"+tmp.getDataNascita().getDayOfMonth());
            request.setAttribute("groups", GruppoFactory.getInstance().getAllGroups());
            request.setAttribute("users", UtenteFactory.getInstance().getAllUsers(new ArrayList<Integer>(Arrays.asList(tmp.getId()))));
            
            
            
            request.getRequestDispatcher("M2/profilo.jsp").forward(request, response);
        }
        else response.sendRedirect("login.html");
    }   
    public void loadData(HttpServletRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {
        UtenteSecure utente = UtenteFactory.getInstance().getUtenteById((int)request.getSession(false).getAttribute("user"));
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
    public ArrayList<String> updateUserInfo(HttpServletRequest request, Utente _old, Utente _new) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        ArrayList<String> campiModificati = new ArrayList<>();
        
        ArrayList<Field> classFields = new ArrayList<>(Arrays.asList(_old.getClass().getDeclaredFields()));
        for(Field tmp : _old.getClass().getSuperclass().getDeclaredFields())
            classFields.add(tmp);
        
        Method tmpGetter = null, tmpSetter = null;
              
        for(Field tmp : classFields)
        {
            if(tmp.getType() == String.class)
            {   
                try { tmpGetter = _old.getClass().getDeclaredMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1)); }
                catch(Exception ex) { tmpGetter = _old.getClass().getSuperclass().getDeclaredMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1)); }
                
                try { tmpSetter = _old.getClass().getMethod("set"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1), String.class); }
                catch(Exception ex) { tmpSetter = _old.getClass().getSuperclass().getMethod("set"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1), String.class); }
                
                if(tmpGetter.invoke(_new).toString()!= null
                   && !tmpGetter.invoke(_new).toString().equals("")
                   && !tmpGetter.invoke(_new).toString().equals(tmpGetter.invoke(_old).toString()))
                {
                    campiModificati.add(tmp.getName());
                    tmpSetter.invoke(_old, tmpGetter.invoke(_new));
                }
            }
            else if(tmp.getType() == LocalDate.class)
            {
                try { tmpGetter = _old.getClass().getDeclaredMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1)); }
                catch(Exception ex) { tmpGetter = _old.getClass().getSuperclass().getDeclaredMethod("get"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1)); }
                
                try { tmpSetter = _old.getClass().getMethod("set"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1), LocalDate.class); }
                catch(Exception ex) { tmpSetter = _old.getClass().getSuperclass().getMethod("set"+tmp.getName().substring(0, 1).toUpperCase() + tmp.getName().substring(1), LocalDate.class); }
                
                if(tmpGetter.invoke(_new) != null
                   && !tmpGetter.invoke(_new).toString().equals("")
                   && !tmpGetter.invoke(_new).equals(tmpGetter.invoke(_old)))
                {
                    campiModificati.add(tmp.getName());
                    tmpSetter.invoke(_old, tmpGetter.invoke(_new));
                }
            }
        }
        
        try { UtenteFactory.getInstance().updateUserInfo(_old); }
        catch(Exception ex){}
        
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
