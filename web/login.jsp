<%-- 
    Document   : login
    Created on : 04/05/2017, 04:56:37 PM
    Author     : Andres JM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" pageEncoding="UTF-8"> 
        <title>Ingreso al Sistema</title>
    </head>
    <body background="images/maxresdefault.jpg">
        <br><br><br>
    <center>
        <form name="loginForm" action="CustomerInfoServlet" method="post">
            <i>
                <marquee <b><font color="lightgreen" size="8">Sistema de Gestión de Clientes</font></b>
                </marquee>
            </i>
            <font color="lightgreen" ><h1 align="center"><label>Usuario:</label></h1>
            </font>
            <br>
            <input type="text" name="username" value="" size="30" />
            <br>
            <br>
            <font color="lightgreen" ><h1 align="center"><label>Contraseña:</label></h1>
            </font>
            <br>
            <input type="password" name="password" value="" size="30"/>
            <br>
            <br>
            <input type="submit" value="Ingresar" name="login" />
            <input type="reset" value="Cancelar" name="cancel" />
        </form>
    </center>
</body>
</html>

