<%-- 
    Document   : aufgabe2
    Created on : 16.05.2018, 11:45:16
    Author     : stea1th
--%>

<%@page import="helpers.Helper"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            button{width: 100px; height: 20px}
        </style>
        <title>Fakultät berechnen</title>
    </head>
    <body>
        <h1 align="center">Jetzt berechnen wir den Fakultät</h1><br>
        <hr/>
        <form method="post" action="">
            <table>
                <tr>
                    <th>Geben Sie ein Zahl ein:</th>
                    <th><input type="text" name="zahl" size="15" /></th>
                </tr>
                <tr >
                    <td align="right"><button type="submit"/>Send</td>
                    <td><button type="reset" />Reset</td>
                </tr>
            </table>
        </form>
        <hr/>
        <p><% out.println(new Helper().getFakult(request.getParameter("zahl")));%></p>
        <hr/>
    </body>
</html>

