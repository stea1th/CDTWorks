<%-- 
    Document   : jspbeispiel2
    Created on : 15.05.2018, 13:32:48
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo für helfende Methode</title>
    </head>
    <body>
        <% for (int idx = 1; idx <= 10; idx++) {%>
        <p align="<%= ausrichtung(idx)%>">
            <%= idx%>. Zeile</p>
            <% }%>
    </body>
</html>
<%--Beispiel für die jsp - Deklaration eine Methode--%>

<%! public String ausrichtung(int i) {
        return i % 2 == 0 ? "right" : "left";
    }%>
