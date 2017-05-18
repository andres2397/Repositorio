/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.ClerkBusiness;
import Business.CustomerBusiness;
import Domain.Clerk;
import Domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Andres JM
 */
@WebServlet(name = "ClerkManagementServlet", urlPatterns = {"/ClerkManagementServlet"})
public class ClerkManagementServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ClerkBusiness clerkBusiness;

    @Override
    public void init()
            throws ServletException {

        clerkBusiness = new ClerkBusiness();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClerkManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClerkManagementServlet at " + request.getContextPath() + "</h1>");
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

            String customerUsername = request.getParameter("customerUsername");
            try {
                clerkBusiness.deleteCustomer(customerUsername);
                try {
                    request.setAttribute("clerks", clerkBusiness.getAllClerks());
                } catch (ParseException ex) {
                    Logger.getLogger(ClerkManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ClerkManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_clerks.jsp");
            dispatcher.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {

            String clerkUsername = request.getParameter("clerkUsername");
            Clerk clerk = new Clerk();
            try {
                clerk = clerkBusiness.getClerkByName(clerkUsername);
                request.setAttribute("clerk", clerk);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_clerk.jsp");
                dispatcher.forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(ClerkManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        String phone = request.getParameter("phone").toString();
        String id = request.getParameter("id").toString();        
        String name = request.getParameter("name").toString();
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();        
        String email = request.getParameter("email").toString();

        Clerk clerk = new Clerk(phone, id, name, username, password, email);

        try {
                clerkBusiness.modifyClerk(username, clerk);
           
                request.setAttribute("clerks", clerkBusiness.getAllClerks());
        }catch (ParseException ex) {
                Logger.getLogger(ClerkManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_clerks.jsp");
        dispatcher.forward(request, response);

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
