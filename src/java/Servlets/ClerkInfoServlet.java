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
@WebServlet(name = "ClerkInfoServlet", urlPatterns = {"/ClerkInfoServlet"})
public class ClerkInfoServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

        } finally {
            out.close();
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
        
        String phone = request.getParameter("phone");
        String id = request.getParameter("id");
        String name = request.getParameter("name");        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Clerk clerk = new Clerk(phone, id, name, username, password, email);
        ClerkBusiness clerkBusiness = new ClerkBusiness();
        clerkBusiness.insertClerkInFile(clerk);

        RequestDispatcher dispacher = request.getRequestDispatcher("show_info_clerk.jsp");
        dispacher.forward(request, response);
        // processRequest(request, response);

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

        Clerk clerk = new Clerk();
        ClerkBusiness clerkBusiness = new ClerkBusiness();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            clerk = clerkBusiness.getClerkByUsernameAndPassword(username, password);
            System.out.println("name: "+clerk.getName());
            //verifica que se encontró el cliente y por ende, tiene un nombre
            if (clerk.getUsername().equals(username)&&clerk.getPassword().equals(password)) {

                RequestDispatcher dispacher = request.getRequestDispatcher("main_menu.jsp");
                response.setHeader("name", clerk.getName());
                dispacher.forward(request, response);
            }else{
            
            RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
                dispacher.forward(request, response);
            }

        } catch (ParseException ex) {
            Logger.getLogger(CustomerInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

     
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
