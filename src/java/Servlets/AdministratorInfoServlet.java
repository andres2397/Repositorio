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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Andres JM
 */
@WebServlet(name = "AdministratorInfoServlet", urlPatterns = {"/AdministratorInfoServlet"})
public class AdministratorInfoServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String username = request.getParameter("username");        
        String password = request.getParameter("password");
        String email = request.getParameter("email");        
        String phone = request.getParameter("phone");

        Administrator administrator=new Administrator(id, name, username, password, email, phone);
        AdministratorBusiness administratorBusiness =new AdministratorBusiness();
        administratorBusiness.insertAdministrator(administrator);

        RequestDispatcher dispacher = request.getRequestDispatcher("show_info_administrator.jsp");
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

        Administrator administrator = new Administrator();
        AdministratorBusiness administratorBusiness = new AdministratorBusiness();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            administrator = administratorBusiness.getAdministratorByUsernameAndPassword(username, password);
            System.out.println("name: "+administrator.getName());
            //verifica que se encontró el cliente y por ende, tiene un nombre
            if (administrator.getUsername().equals(username)&&administrator.getPassword().equals(password)) {

                RequestDispatcher dispacher = request.getRequestDispatcher("main_menu.jsp");
                response.setHeader("name", administrator.getName());
                dispacher.forward(request, response);
            }else{
            
            RequestDispatcher dispacher = request.getRequestDispatcher("login_administator.jsp");
                dispacher.forward(request, response);
            }

        } catch (ParseException ex) {
            Logger.getLogger(AdministratorInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(AdministratorInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

     
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
