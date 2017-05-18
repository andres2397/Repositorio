/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.ParkingLotBusiness;
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
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
@WebServlet(name = "ParkingLotInfoServlet", urlPatterns = {"/ParkingLotInfoServlet"})
public class ParkingLotInfoServlet extends HttpServlet {

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

        String name = request.getParameter("name");
        String numberOfSpaces = request.getParameter("numberOfSpaces");
        ArrayList<Vehicle> vehicles = null ;
       
        Space[] spaces = null;

        ParkingLot parkingLot = new ParkingLot(name, Integer.parseInt(numberOfSpaces), vehicles, spaces);
        ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
        parkingLotBusiness.insertParkinLot(parkingLot);

        RequestDispatcher dispacher = request.getRequestDispatcher("show_info_parkingLot.jsp");
        dispacher.forward(request, response);
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
        ParkingLot parkingLot= new ParkingLot();
       
       
        String name= request.getParameter("name");
        String id = request.getParameter("id");
        ParkingLotBusiness parkingLotBusiness = new ParkingLotBusiness();
        
       
        try {
 
            parkingLot= parkingLotBusiness.getParkingLot(Integer.parseInt(id));
            System.out.println("name: " + parkingLot.getName());
            //verifica que se encontró el cliente y por ende, tiene un nombre
            if (parkingLot.getName().equals(name) && (parkingLot.getId() == (Integer.parseInt(id)))) {

                RequestDispatcher dispacher = request.getRequestDispatcher("main_menu.jsp");
                response.setHeader("name", parkingLot.getName());
                dispacher.forward(request, response);
            } else {

                RequestDispatcher dispacher = request.getRequestDispatcher("select_parking.jsp");
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