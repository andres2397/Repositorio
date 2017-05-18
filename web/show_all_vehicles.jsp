<%-- 
    Document   : show_all_vehicles
    Created on : 16/05/2017, 02:29:27 PM
    Author     : Matamoros Cordero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de vehiculos</title>
    </head>
    <body background="Images/background-image.gif">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de vehiculos ingresados en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Placa del vehiculo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Color </b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Modelo</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Marca</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Descripcion</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Clientes responsables del vehiculo</b></font> </td>
              <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>
            <c:forEach items="${vehicles}" var="currentVehicle" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentVehicle.plate}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentVehicle.color}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.model}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.brand}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.description}"/></font></td>
                    <td><font size="5"><c:out value="${currentVehicle.customers}"/></font></td>

                    <td><font size="5"><a href="VehicleManagementServlet.do?action=edit&vehiclePlate=<c:out value="${currentVehicle.plate}"/>"Modificar</a></font>
                   <font size="5"><a href="VehicleManagementServlet.do?action=delete&vehiclePlate=<c:out value="${currentVehicle.plate}"/>"Eliminar</a></font></td>
                </tr>

            </c:forEach>


        </table>

    </center>

</body>
</html>