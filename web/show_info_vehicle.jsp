<%-- 
    Document   : show_info_vehicle
    Created on : 17/05/2017, 11:52:17 PM
    Author     : Matamoros Cordero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vehiculo insertado</title>

        <%
            String plate = request.getParameter("plate");
            String model = request.getParameter("model");
            String brand = request.getParameter("brand");
            String description = request.getParameter("description");
            String nameCustomerVehicle = request.getParameter("nameCustomerVehicle");
            String idCustomerVehicle = request.getParameter("idCustomerVehicle");
            String emailCustomerVehicle = request.getParameter("emailCustomerVehicle");
            String phoneCustomerVehicle = request.getParameter("phoneCustomerVehicle");

            String userNameVehicle = request.getParameter("userNameCustomerVehicle");
            String password = request.getParameter("passwordCustomerVehicle");

            String nameCustomerVehicle1 = request.getParameter("nameCustomerVehicle1");
            String emailCustomerVehicle1 = request.getParameter("emailCustomerVehicle1");
            String phoneCustomerVehicle1 = request.getParameter("phoneCustomerVehicle1");
            String idCustomerVehicle1 = request.getParameter("idCustomerVehicle1");
            String userNameVehicle1 = request.getParameter("userNameCustomerVehicle1");
            String password1 = request.getParameter("passwordCustomerVehicle1");

            String nameCustomerVehicle2 = request.getParameter("nameCustomerVehicle2");
            String emailCustomerVehicle2 = request.getParameter("emailCustomerVehicle2");
            String phoneCustomerVehicle2 = request.getParameter("phoneCustomerVehicle2");
            String idCustomerVehicle2 = request.getParameter("idCustomerVehicle2");
            String userNameVehicle2 = request.getParameter("userNameCustomerVehicle2");
            String password2 = request.getParameter("passwordCustomerVehicle2");
        %>
    </head>
    <body>

        Datos del vehiculo insertado:
        Placa<%=plate%>
        Modelo<%=model%>
        brand<%=brand%>
        Descripcion<%=description%>
        Nombre<%=nameCustomerVehicle%>
        Email<%=emailCustomerVehicle%>
        Phone<%=phoneCustomerVehicle%>
        id<%=userNameVehicle%>
        Nombre<%=nameCustomerVehicle1%>
        Email<%=emailCustomerVehicle1%>
         Phone<%=phoneCustomerVehicle1%>
            id<%=userNameVehicle1%>
        Nombre<%=nameCustomerVehicle2%>
        Email<%=emailCustomerVehicle2%>
         Phone<%=phoneCustomerVehicle2%>
         id<%=userNameVehicle2%>
    </body>
</html>