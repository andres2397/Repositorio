/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.CustomerBusiness;
import Domain.Customer;
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
public class CustomerManagementServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    CustomerBusiness customerBusiness;

    @Override
    public void init()
            throws ServletException {

        customerBusiness = new CustomerBusiness();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerManagementServlet at " + request.getContextPath() + "</h1>");
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
                customerBusiness.deleteCustomer(customerUsername);
                try {
                    request.setAttribute("customers", customerBusiness.getAllCustomers());
                } catch (ParseException ex) {
                    Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_customers.jsp");
            dispatcher.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {

            String customerUsername = request.getParameter("customerUsername");
            Customer customer = new Customer();
            try {
                customer = customerBusiness.getCustomerByName(customerUsername);
                request.setAttribute("customer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_customer.jsp");
                dispatcher.forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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

        Customer customer = new Customer(phone, id, name, username, password, email);

        try {
            customerBusiness.modifyCustomer(username, customer);
           
                request.setAttribute("customers", customerBusiness.getAllCustomers());
        }catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_customers.jsp");
        dispatcher.forward(request, response);

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
