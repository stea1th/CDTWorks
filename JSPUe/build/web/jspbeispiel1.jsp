<%-- 
    Document   : jspbeispiel1
    Created on : 15.05.2018, 13:17:49
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SchleifenDemo</title>
    </head>
    <body>
        <% for (int idx = 1; idx <= 10; idx++) {%>
        <p align="<%= idx % 2 == 0 ? "right" : "left"%>">
            <%= idx%>. Zeile</p>
            <% }%>
    </body>
</html>
