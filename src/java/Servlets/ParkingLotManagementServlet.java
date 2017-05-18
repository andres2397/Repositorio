/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.ParkingLotBusiness;
import Domain.Customer;
import Domain.ParkingLot;
import Domain.Space;
import Domain.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
@WebServlet(name = "ParkingLotManagementServlet", urlPatterns = {"/ParkingLotManagementServlet"})
public class ParkingLotManagementServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    ParkingLotBusiness parkingLotBusiness;

    @Override
    public void init()
            throws ServletException {
        String NameParkingLot = null;

        parkingLotBusiness = new ParkingLotBusiness();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParkingLotManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingLotManagementServlet at " + request.getContextPath() + "</h1>");
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

            String parkingLotId = request.getParameter("id");
            int idTemp = Integer.parseInt(parkingLotId);

            try {
                parkingLotBusiness.deleteParking(idTemp);
                try {
                    request.setAttribute("parkingLots", parkingLotBusiness.getAllParkingLots());
                } catch (ParseException ex) {
                    Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_parkingLot.jsp");
            dispatcher.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {

            String parkingLotId = request.getParameter("id");
            int idTemp = Integer.parseInt(parkingLotId);

            ParkingLot parkingLot = new ParkingLot();
            try {
                parkingLot = parkingLotBusiness.getParkingLot(idTemp);
                request.setAttribute("parkingLot", parkingLot);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_parkingLot.jsp");
                dispatcher.forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            request.setCharacterEncoding("UTF-8");
            ParkingLot parkingLotTemp = new ParkingLot();

            String parkingLotId = request.getParameter("id");
            int idTemp = Integer.parseInt(parkingLotId);

            String name = request.getParameter("name").toString();
            String numberOfSpaces = request.getParameter("numberOfSpaces");
            parkingLotTemp = parkingLotBusiness.getParkingLot(idTemp);
            ArrayList<Vehicle> vehicles = parkingLotTemp.getVehicles();
            Space[] spaces = parkingLotTemp.getSpaces();

            ParkingLot parkingLot = new ParkingLot(name, idTemp, vehicles, spaces);

            try {
                parkingLotBusiness.modifyParkingLot(idTemp, parkingLot);
                try {
                    request.setAttribute("parkingLots", parkingLotBusiness.getAllParkingLots());
                } catch (ParseException ex) {
                    Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (ParseException ex) {
                Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_parkingLot.jsp");
            dispatcher.forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(ParkingLotManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
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