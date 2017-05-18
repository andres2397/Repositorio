/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Business.AdministratorBusiness;
import Domain.Administrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Esteban
 */
public class AdministratorManagementServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    AdministratorBusiness administratorBusiness;

    public void init()
            throws ServletException {

        administratorBusiness =new AdministratorBusiness();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdministratorManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdministratorManagementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            String administratorUsername = request.getParameter("administratorUsername");
            try {
                administratorBusiness.deleteAdministrator(administratorUsername);
               
                try {
                    request.setAttribute("administrators", administratorBusiness.getAllAdministrators());
                } catch (ParseException | java.text.ParseException ex) {
                    Logger.getLogger(AdministratorManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            } catch (ParseException ex) {
                Logger.getLogger(AdministratorManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_administrators.jsp");
            dispatcher.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {

            String administratorUsername = request.getParameter("administratorUsername");
            Administrator administrator= new Administrator();
            try {
                administrator =administratorBusiness.getAdministratorByUsername(administratorUsername);
                request.setAttribute("administrator", administrator);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_administrator.jsp");
                dispatcher.forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(AdministratorManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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
        request.setCharacterEncoding("UTF-8");
        
        String id = request.getParameter("id").toString();        
        String name = request.getParameter("name").toString();
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();        
        String email = request.getParameter("email").toString();        
        String phone = request.getParameter("phone").toString();
        
        Administrator administrator = new Administrator(id, name, username, password, email, phone);

        try {
            administratorBusiness.modifyAdministratorFromFile(username, administrator);
           
                request.setAttribute("administrators",administratorBusiness.getAllAdministrators());
        }catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.text.ParseException ex) {
            Logger.getLogger(AdministratorManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_administrators.jsp");
        dispatcher.forward(request, response);

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
