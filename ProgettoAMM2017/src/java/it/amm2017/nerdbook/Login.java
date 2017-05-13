
package it.amm2017.nerdbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 * @author Mario Taccori
 */
@WebServlet( name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0 )
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

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
                    if(request.getParameter("username").length()>0 && request.getParameter("password").length()>0)
                    {
                        Utente tmp = UtenteFactory.getInstance().getUtenteByUsername(request.getParameter("username"));

                        if(tmp!=null && tmp.getPassword().equals(request.getParameter("password")))
                        {
                            request.setAttribute("loginError", "none");
                            session.setAttribute("loggedIn", true);
                            
                            try { chooseDestination(new UtenteSecure(tmp), request, response); }
                            catch(Exception ex){}
                        }
                        else
                        {
                            request.setAttribute("loginError", "wrongCredentials");
                            request.getRequestDispatcher("M2/login.jsp").forward(request, response);  
                        }                          
                    }
                    else
                    {
                        request.setAttribute("loginError", "emptyField");
                        request.getRequestDispatcher("M2/login.jsp").forward(request, response);
                    }  
                }
                else
                {
                    request.setAttribute("loginError", "none");
                    request.getRequestDispatcher("M2/login.jsp").forward(request, response);
                }
            }
            else
            {
                try { chooseDestination((UtenteSecure)UtenteFactory.getInstance().getUtenteById((int)session.getAttribute("user")), request, response); }
                catch(Exception ex){}
            }
        }
        else
        {
            request.setAttribute("loginError", "none");
            session.setAttribute("loggedIn", false);
            request.getRequestDispatcher("M2/login.jsp").forward(request, response);                
        }        
    }   
    public void chooseDestination(UtenteSecure tmp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IllegalAccessException, IOException, InvocationTargetException
    {
        request.getSession(false).setAttribute("user", tmp.getId());

        if(UtenteFactory.checkCompletion(tmp))   
            response.sendRedirect("bacheca.html?ownerType=user");
        else
            response.sendRedirect("profilo.html?isUserInfoComplete=false");
    }   
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.getSession(false).invalidate(); 
        response.sendRedirect("login.html");
    }
    
    @Override
    public void init()
    {
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_CLEAN_PATH;
        
        try { Class.forName(JDBC_DRIVER); }
        catch (ClassNotFoundException ex) { Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex); }
        
        UtenteFactory.getInstance().setConnectionString(dbConnection);
        PostFactory.getInstance().setConnectionString(dbConnection);
        GruppoFactory.getInstance().setConnectionString(dbConnection);
        
        UtenteFactory.getInstance().setConnectionUsername("ali_baba");
        PostFactory.getInstance().setConnectionUsername("ali_baba");
        GruppoFactory.getInstance().setConnectionUsername("ali_baba");
        
        UtenteFactory.getInstance().setConnectionPassword("apriti sesamo");
        PostFactory.getInstance().setConnectionPassword("apriti sesamo");
        GruppoFactory.getInstance().setConnectionPassword("apriti sesamo");
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
