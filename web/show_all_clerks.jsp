<%-- 
    Document   : show_all_clerks
    Created on : 18/05/2017, 03:12:10 PM
    Author     : Andres JM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Operarios</title>
    </head>
    <body background="images/texture.jpg">

        <i>
            <marquee  <b><font color="lightgreen" size="8">Lista de Operararios en el Sistema </font></b>
            </marquee>
        </i>

        <br><br><br>

    <center>
        <table border="2">

            <td bgcolor="white" ><font size="5" color="#00009C"><b>Nombre del cliente</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Cedula</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Teléfono</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Correo electrónico</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Usuario</b></font> </td>
            <td bgcolor="white" ><font size="5" color="#00009C"><b>Acción</b></font> </td>

            <c:forEach items="${clerks}" var="currentClerk" varStatus="counter">
                <c:set var="color" value="${counter.index%2==0? 'gray' : 'lightblue'}"/>
                <tr bgcolor= "${color}">

                    <td><font size="5"><c:out value="${currentClerk.name}"/> </font> </td>
                    <td><font size="5"><c:out value="${currentClerk.id}"/></font></td>
                    <td><font size="5"><c:out value="${currentClerk.phone}"/></font></td>
                    <td><font size="5"><c:out value="${currentClerk.email}"/></font></td>
                    <td><font size="5"><c:out value="${currentClerk.username}"/></font></td>

                    

                    <td><font size="5"><a href="ClerkManagementServlet.do?action=edit&clerkUsername=<c:out value="${currentClerk.username}"/>">Modificar</a></font>
                   <font size="5"><a href="ClerkManagementServlet.do?action=delete&clerkUsername=<c:out value="${currentClerk.username}"/>">Eliminar</a></font></td>
                </tr>

            </c:forEach>
        </table>

    </center>

</body>
</html>

