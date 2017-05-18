<%-- 
    Document   : insert_invoice_vehicles
    Created on : 18/05/2017, 11:48:19 AM
    Author     : Matamoros Cordero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar tarifas de vehiculos</title>
    </head>
   
        <i>
            <marquee <b><font color="lightgreen" size="8">Sistema de tarifas</font></b>
            </marquee>
        </i>

    <center>
        <form action="InvoiceInfoServlet" method="get">

            <table>
                <tr>
                <h2>  Formulario de ingreso de tarifas </h2>

                </tr>

                <tr>

                    <td>
                        <font size="5" color="lightgreen"><b> <label>Tipo de vehiculo: </label> </b></font>
                    </td>

                    <td>
                        <input type="text" name="typeOfVehicle" size="30">
                    </td>

                </tr>

                <tr>

                    <td>
                        <font size="5" color="lightgreen"><b> <label>Precio por hora: </label> </b></font>
                    </td>

                    <td>
                        <input type="text" name="hourlyRate" size="30">
                    </td>

                </tr>

              
            </table>
            <br><br><br>
             <input type="submit" value="Guardar tarifa" /></div>
        </form>
    </center>

</html>
