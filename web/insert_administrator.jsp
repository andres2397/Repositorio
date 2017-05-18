<%-- 
    Document   : insert_administrador
    Created on : 20/04/2017, 05:34:27 PM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fnt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear usuario Administrador</title>
    </head>
    <body>
        <i>
            <font size=6 COLOR=009900>

            <marquee>
                SISTEMA DE INGRESO DE ADMINISTRADORES
            </marquee>
            </font>
        </i>
        <form action="AdministratorInfoServlet" method="get">
            <table align="center">

                <tr>
                    <td>
                        name:
                    </td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                
                <tr>
                    <td>
                        Id:
                    </td>
                    <td>
                        <input type="text" name="id">
                    </td>
                </tr>
                
                <tr>
                    <td >
                        email:
                    </td>
                    <td>
                        <input type="text" name="email">
                    </td>
                </tr>
                <tr>
                    <td>
                        phone:
                    </td>
                    <td>
                        <input type="text" name="phone">
                    </td>
                </tr>
                
               
                <tr>
                    <td>
                        username:
                    </td>
                    <td>
                        <input type="text" name="username">
                    </td>
                </tr>
                <tr>
                    <td>
                        password:
                    </td>
                    <td>
                        <input type="text" name="password">
                    </td>
                </tr>
                
                </tr>

            </table>
            
            <div align="center"><input type="submit" value="Guardar Cliente" /></div>

        </form>


    </body>
</html>
