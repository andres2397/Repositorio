<%-- 
    Document   : select_parking
    Created on : 16/05/2017, 10:43:18 PM
    Author     : ValeriaLeivaQuirós
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" pageEncoding="UTF-8"> 
        <title>Seleccionar parqueo</title>
    </head>
    <body 
        <br><br><br>
    <center>
  
            <form name="loginForm" action="ParkingLotInfoServlet" method="post">
            <i>
                <marquee <b><font color="lightgreen" size="8">Sistema de Selección de Parqueo</font></b>
                </marquee>
            </i>
            <font color="lightgreen" ><h1 align="center"><label>id</label></h1>
            </font>
            <br>
            <input type="text" name="id" value="" size="30" />
            <br>
            <br>
            <font color="lightgreen" ><h1 align="center"><label>Nombre del parqueo:</label></h1>
            </font>
            <br>
            <input type="name" name="name" value="" size="30"/>
            <br>
            <br>
            <input type="submit" value="Ingresar" name="login" />
            <input type="reset" value="Cancelar" name="cancel" />
        </form>
    </center>
</body>
</html>