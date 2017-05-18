<%-- 
    Document   : newjsp
    Created on : Apr 20, 2017, 7:08:37 PM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente insertado</title>

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

        Datos del cliente insertado:

        Nombre: <%=name%>
        Cedula: <%=id%>
        Correo: <%=email%>
        Teléfono: <%=phone%>
        Username: <%=username%>
        Password: <%=password%>
    </body>
</html>
