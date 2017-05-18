<%-- 
    Document   : show_info_parkingLot
    Created on : 16/05/2017, 11:10:51 AM
    Author     : ValeriaLeivaQuirós
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parqueo Insertado</title>

        <%
            String name = request.getParameter("name");
            String numberOfSpaces= request.getParameter("numberOfSpaces");
           
        %>
<style type="text/css">
    .r {
	color: #AAA;
}
    .r {
	text-align: center;
}
</style>
</head>
    <body 
    <body>

        <p class="r">Datos ingresados con éxito</p>
        <p class="r"><span class="r">Datos del parqueo insertado:
          
          Nombre: <%=name%>
        Numero de espacios: <%=numberOfSpaces%>
       
        <p>&nbsp;</p>
    <p class="r"><span class="r"><a href="insert_parkingLot.jsp" class="r">Regresar al inicio</a></span><a href="show_info_customer.jsp" class="r"></a></p>
    </body>
</html>