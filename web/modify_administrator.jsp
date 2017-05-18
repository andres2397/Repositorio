<%-- 
    Document   : modify_administrator
    Created on : 16/05/2017, 08:15:04 PM
    Author     : Andres JM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar datos del administrador</title>
        
    </head>
    <body background="Images/background-image.gif">
        <i>
            <marquee  <b><font color="lightgreen" size="8">Modificación de administradores del Sistema </font></b>
            </marquee>
        </i>
    <center>
        
        <form name="modifyAdministratorForm" action="AdministratorManagementServlet.do" method="post">

            <table>
                <tr>
                <h2>  Formulario de modificación de Administradores </h2>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="name" size="30" value="${administrator.name}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Correo: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="email" size="30" value="${administrator.email}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Teléfono: </label> </b></font> 


                    </td>

                    <td>
                        <input type="text" name="phone" size="30" value="${administrator.phone}">
                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Username: </label> </b></font> 


                    </td>

                    <td>

                        <input type="text" name="username" size="30" value="${administrator.username}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Password: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="password" size="30" value="${administrator.password}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <input type="submit" value="Modificar administrador"/>

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
