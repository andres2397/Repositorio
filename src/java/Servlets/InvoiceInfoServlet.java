package Servlets;

import Business.InvoiceBusiness;
import Domain.Invoice;
import Domain.VehicleType;
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


@WebServlet(name = "InvoiceInfoServlet", urlPatterns = {"/InvoiceInfoServlet"})
public class InvoiceInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    InvoiceBusiness invoiceBusiness;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InvoiceInfoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InvoiceInfoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    public void init() throws ServletException {
      invoiceBusiness= new InvoiceBusiness();
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
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String typeOfVehicle=request.getParameter("plate");
        String hourlyRate=request.getParameter("hourlyRate");
        invoiceBusiness.insertInvoice(new Invoice(0, Integer.parseInt(hourlyRate), new VehicleType(hourlyRate, 0)));
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
        Invoice invoice= new Invoice();
         String typeOfVehicle = request.getParameter("typeOfVehicle");
         try{
             invoice=invoiceBusiness.getInvoiceByVehicleType(typeOfVehicle);
                System.out.println("name: "+invoice.getVehicleType());
            //verifica que se encontró el cliente y por ende, tiene un nombre
            if (invoice.getVehicleType().equals(typeOfVehicle)) {

                RequestDispatcher dispacher = request.getRequestDispatcher("main_menu.jsp");
                response.setHeader("typeOfVehicle", invoice.getVehicleType().getDescription());
                dispacher.forward(request, response);
            }else{
                     RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
                dispacher.forward(request, response);
            }
           } catch (ParseException ex) {
            Logger.getLogger(VehicleInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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