<%-- 
    Document   : datumzeit3
    Created on : 15.05.2018, 13:01:40
    Author     : stea1th
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demonstration von JSP-Skripting</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% Date aktuell = new Date();%>
        <p>Heute ist der <%= aktuell%>.<br/>
            <%--Skriplet 1--%>
            <% String teilStr = aktuell.toString().substring(0, 3);
        if (teilStr.startsWith("S")) {%>
            Es ist Wochenende (<%= teilStr%>)
            <%-- Skriplet 2 --%>
            <% } else {%>
            Es ist unter der Woche (<%= teilStr%>)
            <%-- Skriptlet 3 --%>
            <% }%>
        </p>
    </body>
</html>
