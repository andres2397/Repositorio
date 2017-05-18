<%-- 
    Document   : show_info_administrator
    Created on : 16/05/2017, 07:09:21 PM
    Author     : Andres JM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Administrador creado</title>

        <%
            String name = request.getParameter("name");
            String id = request.getParameter("id");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
        %>
    </head>
    
    <body>

        Datos del administrador creado:

        Nombre: <%=name%>
        Cedula: <%=id%>
        Correo: <%=email%>
        Teléfono: <%=phone%>
        Username: <%=username%>
        Password: <%=password%>
    </body>
    
</html>
