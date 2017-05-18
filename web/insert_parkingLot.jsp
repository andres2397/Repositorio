<%-- 
    Document   : insert_parkingLot
    Created on : 16/05/2017, 10:32:04 PM
    Author     : ValeriaLeivaQuirós
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Ingresar Parqueo</title>
    </head>
    <body 
        
        
        
        <i>
            <marquee <b><font color="lightgreen" size="8">Ingreso de Parqueos al Sistema </font></b>
            </marquee>
        </i>

    <center>
        <form action="ParkingLotInfoServlet" method="get">

            <table>
                <tr>
                <h2>  Formulario de ingreso de parqueo</h2>

                </tr>

         
                <tr>

                    <td>
                        <font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font>
                    </td>

                    <td>
                        <input type="text" name="name" size="30">
                    </td>

                </tr>

                <tr>

                    <td>
                        <font size="5" color="lightgreen"><b> <label>Numero de espacios: </label> </b></font>
                    </td>

                    <td>
                        <input type="text" name="numberOfSpaces" size="30">
                    </td>

               

                <tr>

                    <td>

                        <input type="submit" value="Guardar parqueo" />

                    </td>

                    <td>

                        <input type="reset" value="Cancelar" />

                    </td>

                </tr>

            </table>



        </form>
    </center>

</body>
</html>
