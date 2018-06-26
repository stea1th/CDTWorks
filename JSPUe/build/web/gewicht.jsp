<%-- 
    Document   : gewicht
    Created on : 16.05.2018, 15:17:12
    Author     : stea1th
--%>


<%@page import="helpers.Helper2"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            button{width: 100px; height: 20px}
            
        </style>
        <title>Gewicht berechnen</title>
    </head>
    <body>
        <h1 align="center">Gewichtberechnung</h1>
        <hr/>
        <form method="post" action="" >
            <table align="center" >
                <tr>
                    <td colspan="3"><b>Geben Sie Ihre Daten ein:</b></td>
                </tr>
                <tr>
                    <th align="right">Grösse:</th>
                    <th colspan="2"><input type="text" name="grosse"></th>
                </tr>
                <tr>
                    <th align="right">Gewicht:</th>
                    <th colspan="2"><input type="text"  name="gewicht"></th>
                </tr>
                <tr>
                    <th align="right">Geschlecht:</th>
                    <th ><input type="radio" value="m" name="geschlecht" >M</th>
                    <th ><input type="radio" value="w" name="geschlecht" >W</th>
   
                </tr>
                <tr>
                    <th align="right"><button type="submit">Accept</th>
                    <th></th>
                    <th align="right"><button type="reset">Reset</th>
                </tr>
            </table>
        </form>
        <hr/>
        
        <% try{out.println(new Helper2(new String[]{request.getParameter("grosse"), request.getParameter("gewicht"), request.getParameter("geschlecht")}).getAllData());
                } catch(Exception e){
                 out.println(e.getMessage());
        }%>
        <hr/>
    </body>
</html>
