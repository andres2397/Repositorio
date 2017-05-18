<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Parqueos</title>
        
    </head>
    <body 
        <i>
            <marquee  <b><font color="lightgreen" size="8">Modificación de Parqueos </font></b>
            </marquee>
        </i>
    <center>
        
        <form name="modifyCustomerForm" action="ParkingLotManagementServlet.do" method="post">

            <table>
                <tr>
                <h2>  Formulario de modificación de parqueos </h2>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="name" size="30" value="${parkinglot.name}">

                    </td>

                </tr>

                <tr>

                    <td>

                        <font size="5" color="lightgreen"><b> <label>Numero de Espacios: </label> </b></font> 

                    </td>

                    <td>

                        <input type="text" name="numberOfSpaces" size="30" value="${parkinglot.numberOfSpaces}">

                    </td>

                </tr>

              
                    </td>

                </tr>

            </table>

        </form>
    </center>

</body>

</html>