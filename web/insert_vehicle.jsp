<%-- 
    Document   : insert_vehicle
    Created on : 10/05/2017, 02:29:13 PM
    Author     : Matamoros Cordero
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fnt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar vehiculo</title>
    </head>
    <body>
        <i>
            <font size=6 COLOR=009900>
            
            <marquee>
                SISTEMA DE INGRESO DE VEHICULOS
            </marquee>
            </font>
        </i>
        <form action="VehicleInfoServlet" method="get">
            <table align="center">
                
                <tr>
                    <td>
                        Placa del vehiculo:
                    </td>
                    <td>
                        <input type="text" name="plate">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Modelo del vehiculo:
                    </td>
                    <td>
                        <input type="text" name="model">
                    </td>
                </tr>
                
                <td>
                    Marca:
                </td>
                <td>
                    <input type="text" name="brand">
                </td>
                </tr>
                
                <tr>
                    <td>
                        Tipo de Vehiculo:
                    </td>
                    <td>
                        <input type="text" name="description">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Nombre del cliente responsable:
                    </td>
                    <td>
                        <input type="text" name="nameCustomerVehicle">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cedula de identidad:
                    </td>
                    <td>
                        <input type="text" name="idCustomerVehicle">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email del cliente:
                    </td>
                    <td>
                        <input type="text" name="emailCustomerVehicle">
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefono del cliente :
                    </td>
                    <td>
                        <input type="text" name="phoneCustomerVehicle">
                    </td>
                </tr>
                
                  <tr>
                    <td>
                        Username :
                    </td>
                    <td>
                        <input type="text" name="userNameCustomerVehicle">
                    </td>
                </tr>
                  <tr>
                    <td>
                        Password :
                    </td>
                    <td>
                        <input type="text" name="passwordCustomerVehicle">
                    </td>
                </tr>
                <tr>
                     <td>
                         *Campos opcionales:
                     </td>
                   
                </tr>
                   <tr>
                    <td>
                        Nombre del cliente responsable:
                    </td>
                    <td>
                        <input type="text" name="nameCustomerVehicle1">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cedula de identidad:
                    </td>
                    <td>
                        <input type="text" name="idCustomerVehicle1">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email del cliente:
                    </td>
                    <td>
                        <input type="text" name="emailCustomerVehicle1">
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefono del cliente :
                    </td>
                    <td>
                        <input type="text" name="phoneCustomerVehicle1">
                    </td>
                </tr>
                  <tr>
                    <td>
                        Username :
                    </td>
                    <td>
                        <input type="text" name="userNameCustomerVehicle1">
                    </td>
                </tr>
                  <tr>
                    <td>
                        Password :
                    </td>
                    <td>
                        <input type="text" name="passwordCustomerVehicle1">
                    </td>
                </tr>
                   <tr>
                    <td>
                        Nombre del cliente responsable:
                    </td>
                    <td>
                        <input type="text" name="nameCustomerVehicle2">
                    </td>
                </tr>
                <tr>
                    <td>
                        Cedula de identidad:
                    </td>
                    <td>
                        <input type="text" name="idCustomerVehicle2">
                    </td>
                </tr>
                <tr>
                    <td>
                        Email del cliente:
                    </td>
                    <td>
                        <input type="text" name="emailCustomerVehicle2">
                    </td>
                </tr>
                <tr>
                    <td>
                        Telefono del cliente :
                    </td>
                    <td>
                        <input type="text" name="phoneCustomerVehicle2">
                    </td>
                </tr>
                
                  <tr>
                    <td>
                        Username :
                    </td>
                    <td>
                        <input type="text" name="userNameCustomerVehicle2">
                    </td>
                </tr>
                  <tr>
                    <td>
                        Password :
                    </td>
                    <td>
                        <input type="text" name="passwordCustomerVehicle2">
                    </td>
                </tr>
            </table>
            
             <input type="submit" value="Guardar vehiculo" /></div>
    </form>
    
    
</body>
</html>
