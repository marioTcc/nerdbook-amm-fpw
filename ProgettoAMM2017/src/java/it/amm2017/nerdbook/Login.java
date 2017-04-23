
package it.amm2017.nerdbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mario Taccori
 */

public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {     
        if(request.getParameter("action")==null || request.getParameter("action").equals("login"))
            this.login(request, response);
        else if(request.getParameter("action").equals("logout"))
            this.logout(request, response); 
    }
    
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        
        if(session.getAttribute("loggedIn")!=null)
        {
            if(session.getAttribute("loggedIn").equals(false))
            {
                if(request.getParameter("username")!=null && request.getParameter("password")!=null)
                {
                    if(request.getParameter("username").toString().length()>0 && request.getParameter("password").toString().length()>0)
                    {
                        Utente tmp=UtenteFactory.getInstance().getUtenteByUsername(request.getParameter("username").toString());

                        if(tmp!=null && tmp.getPassword().equals(request.getParameter("password")))
                        {
                            session.setAttribute("loginError", "none");
                            session.setAttribute("loggedIn", true);
                            
                            try
                            {
                                chooseDestination(new UtenteSecure(tmp), request, response);
                            }catch(Exception ex){}
                        }
                        else
                        {
                            session.setAttribute("loginError", "wrongCredentials");
                            request.getRequestDispatcher("M2/login.jsp").forward(request, response);  
                        }                          
                    }
                    else
                    {
                        session.setAttribute("loginError", "emptyField");
                        request.getRequestDispatcher("M2/login.jsp").forward(request, response);
                    }  
                }
                else
                {
                    session.setAttribute("loginError", "none");
                    request.getRequestDispatcher("M2/login.jsp").forward(request, response);
                }
            }
            else
            {
                try
                {
                    chooseDestination((UtenteSecure)session.getAttribute("user"), request, response);
                }catch(Exception ex){System.out.println(ex.getMessage());}
            }
        }
        else
        {
            session.setAttribute("loginError", "none");
            session.setAttribute("loggedIn", false);
            request.getRequestDispatcher("M2/login.jsp").forward(request, response);                
        }        
    }
    
    public void chooseDestination(UtenteSecure tmp, HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, IOException, InvocationTargetException
    {
        if(UtenteFactory.checkCompletion(tmp))
        {
            request.getSession(false).setAttribute("user", tmp);
            response.sendRedirect("bacheca.html");
            //request.getRequestDispatcher("M2/bacheca.jsp").forward(request, response);
        }
        else
        {
            request.getSession(false).setAttribute("user", tmp);
            response.sendRedirect("profilo.html");
            //request.getRequestDispatcher("M2/profilo.jsp").forward(request, response);
        }       
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        session.invalidate(); 
        //request.getRequestDispatcher("M2/login.jsp?").forward(request, response);  
        response.sendRedirect("login.html");
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
