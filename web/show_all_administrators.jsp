<%-- 
    Document   : show_all_administrators
    Created on : 16/05/2017, 07:06:56 PM
    Author     : Andres JM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de administradores</title>
    </head>
    <body background="images/maxresdefault.jpg">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de administradores del Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre del administrador</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Cedula</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Teléfono</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Correo electrónico</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Usuario</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <c:forEach items="${administrators}" var="currentAdministrator" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentAdministrator.name}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentAdministrator.id}"/></font></td>
                    <td><font size="5"><c:out value="${currentAdministrator.phone}"/></font></td>
                    <td><font size="5"><c:out value="${currentAdministrator.email}"/></font></td>
                    <td><font size="5"><c:out value="${currentAdministrator.username}"/></font></td>

                   
                    <td><font size="5"><a href="AdministratorManagementServlet.do?action=edit&administratorUsername=<c:out value="${currentAdministrator.username}"/>">Modificar</a></font>
                   <font size="5"><a href="AdministratorManagementServlet.do?action=delete&administratorUsername=<c:out value="${currentAdministrator.username}"/>">Eliminar</a></font></td>
                </tr>

            </c:forEach>


        </table>

    </center>

</body>

</html>

