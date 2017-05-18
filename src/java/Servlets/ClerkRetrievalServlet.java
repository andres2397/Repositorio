/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.ClerkBusiness;
import Domain.Clerk;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
@WebServlet(name = "ClerkRetrievalServlet", urlPatterns = {"/ClerkRetrievalServlet"})
public class ClerkRetrievalServlet extends HttpServlet {

    ClerkBusiness clerkBusiness;
    LinkedList<Clerk> clerks;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClerkRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClerkRetrievalServlet at " + request.getContextPath() + "</h1>");
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
    public void init()
            throws ServletException {

        clerkBusiness = new ClerkBusiness();
        clerks = new LinkedList<>();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
                clerks = clerkBusiness.getAllClerks();
        }catch (ParseException ex) {
                Logger.getLogger(ClerkRetrievalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
       

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show_all_clerks.jsp");

        request.setAttribute("clerks", clerks);

        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}