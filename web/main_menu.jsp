<%-- 
    Document   : main_menu
    Created on : Apr 26, 2017, 11:32:13 PM
    Author     : Esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Menú principal</title>

        <%
            String name = response.getHeader("name");
        %>
    </head>

    <body background="images/background-image.gif">

        <font size=6 color=lightgreen> Bienvenido(a), <%=name%> </font>
        <i>
            <marquee <b><font color="lightgreen" size="8">Menú Principal del Sistema</font></b>
            </marquee>
        </i>

        <table border="2" align="center" bgcolor="black" bordercolor="white">
            <tr>
                <td>
                    <font size="5" color="white">    
                    1--> <a href="./insert_customer.jsp">Insertar cliente</a>
                    </font>
                </td>
            </tr>
            <tr>
                <td>
                    <font size="5" color="white">
                    2--> <a href="CustomerRetrievalServlet">Consultar clientes</a>
                    </font>
                </td>
            </tr>

            <tr>
                <td>
                    <font size="5" color="white">
                    2--> <a href="AdministratorRetrievalServlet">Consultar administradores</a>
                    </font>
                </td>
            </tr>
        </table>
    </body>
</html>
