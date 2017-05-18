<%-- 
    Document   : modify_clerk
    Created on : 18/05/2017, 02:49:47 PM
    Author     : Andres JM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar cliente</title>
        
    </head>
    <body background="Images/background-image.gif">
        <i>
            <marquee  <b><font color="lightgreen" size="8">Modificación de Clientes del Sistema </font></b>
            </marquee>
        </i>
    <center>
        
        <form name="modifyClerkForm" action="ClerkManagementServlet.do" method="post">

            <table>
                <tr>
                <h2>  Formulario de modificación de operario </h2>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="name" size="30" value="${clerk.name}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Correo: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="email" size="30" value="${clerk.email}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Teléfono: </label> </b></font> 


                    </td>

                    <td>
                        <input type="text" name="phone" size="30" value="${clerk.phone}">
                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Username: </label> </b></font> 


                    </td>

                    <td>

                        <input type="text" name="username" size="30" value="${clerk.username}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Password: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="password" size="30" value="${clerk.password}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <input type="submit" value="Modificar operario"/>

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
