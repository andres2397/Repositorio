package Servlets;

import Business.VehicleBusiness;
import Domain.Customer;
import Domain.Vehicle;
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


@WebServlet(name = "VehicleManagementServlet", urlPatterns = {"/VehicleManagementServlet"})
public class VehicleManagementServlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    VehicleBusiness vehicleBusiness;
    
    @Override
    public void init() throws ServletException {
        vehicleBusiness= new VehicleBusiness();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VehicleManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleManagementServlet at " + request.getContextPath() + "</h1>");
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
            
            String plate= request.getParameter("plate");
            try {
                vehicleBusiness.deleteVehicle(plate);
                request.setAttribute("vehicles", vehicleBusiness.getAllVehicles().toString());
            } catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.text.ParseException ex) {
                Logger.getLogger(VehicleManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_vehicles.jsp");
            dispatcher.forward(request, response);
            
        } else if (action.equalsIgnoreCase("edit")) {
            
            String plate = request.getParameter("plate");
            Vehicle vehicle = new Vehicle();
            try {
                vehicle = vehicleBusiness.getVehiclePlate(plate);
                request.setAttribute("vehicle", vehicle);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_vehicle.jsp");
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
        String plate = request.getParameter("plate").toString();
        String model = request.getParameter("model");
        String color = request.getParameter("color");
        String brand = request.getParameter("brand");
        String description = request.getParameter("description");
        
        Customer[ ] customers= new Customer[3];
         String nameCustomerVehicle= request.getParameter("nameCustomerVehicle");
        String emailCustomerVehicle= request.getParameter("emailCustomerVehicle");
        String  phoneCustomerVehicle= request.getParameter("phoneCustomerVehicle");
        String  idCustomerVehicle= request.getParameter("idCustomerVehicle");
        String userNameVehicle = request.getParameter("phoneCustomerVehicle");
        String password = request.getParameter("password");
        String nameCustomerVehicle1= request.getParameter("nameCustomerVehicle1");
        String emailCustomerVehicle1= request.getParameter("emailCustomerVehicle1");
        String  phoneCustomerVehicle1= request.getParameter("phoneCustomerVehicle1");
        String  idCustomerVehicle1= request.getParameter("idCustomerVehicle1");
        String userNameVehicle1 = request.getParameter("phoneCustomerVehicle1");
        String password1 = request.getParameter("password1");
        String nameCustomerVehicle2= request.getParameter("nameCustomerVehicle2");
        String emailCustomerVehicle2= request.getParameter("emailCustomerVehicle2");
        String  phoneCustomerVehicle2= request.getParameter("phoneCustomerVehicle2");
        String  idCustomerVehicle2= request.getParameter("idCustomerVehicle2");
        String userNameVehicle2 = request.getParameter("phoneCustomerVehicle2");
        String password2 = request.getParameter("password2");
        if(!nameCustomerVehicle.equals(null)&&!emailCustomerVehicle.equals(null)&&!phoneCustomerVehicle.equals(null)&&!idCustomerVehicle.equals(null)&&!userNameVehicle.equals(null)
                &&!password.equals(null)){
            
            Customer customer = new Customer(phoneCustomerVehicle,idCustomerVehicle,nameCustomerVehicle,userNameVehicle, password, emailCustomerVehicle);
            customers[0]=customer;
        }
        if(!nameCustomerVehicle1.equals(null)&&!emailCustomerVehicle1.equals(null)&&!phoneCustomerVehicle1.equals(null)&&!idCustomerVehicle1.equals(null)&&!userNameVehicle1.equals(null)
                &&!password1.equals(null)){
            Customer customer = new Customer(phoneCustomerVehicle1,idCustomerVehicle1,nameCustomerVehicle1,userNameVehicle1, password1, emailCustomerVehicle1);
            customers[1]=customer;
        }
         if(!nameCustomerVehicle2.equals(null)&&!emailCustomerVehicle2.equals(null)&&!phoneCustomerVehicle2.equals(null)&&!idCustomerVehicle2.equals(null)&&!userNameVehicle2.equals(null)
                &&!password2.equals(null)){
            Customer customer = new Customer(phoneCustomerVehicle2,idCustomerVehicle2,nameCustomerVehicle2,userNameVehicle2, password2, emailCustomerVehicle2);
            customers[2]=customer;
        }
        
        
        Vehicle vehicle = new Vehicle(plate,brand, model, customers, new VehicleType(description, 0));
        
        try {
            vehicleBusiness.modifyVehicleFromFile(plate, vehicle);
            request.setAttribute("vehicles", vehicleBusiness.getAllVehicles());
            
        } catch (ParseException ex) {
            Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(VehicleManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_vehicles.jsp");
        dispatcher.forward(request, response);
        
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