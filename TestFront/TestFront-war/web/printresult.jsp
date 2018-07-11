<%-- 
    Document   : printresult
    Created on : 10.07.2018, 09:17:34
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {width: 100%; border-spacing: 3px;}
            tr:nth-child(2n) {
                text-align: left;
                background: #ffff66;
            }
            tr:nth-child(2n+1) {
                background: greenyellow;
                text-align: left;
            }
            tr:nth-child(1) {
                background: #666666;
                color: white;
                text-align: left;
            }

            .btn {
                display: inline-block;
                margin-bottom: 4px;
                padding: 4px 8px;
                background-color: greenyellow;
                border: 1px solid #eeeeee;
                cursor: pointer;
            }


        </style>
    </head>
    <body style='background: lavenderblush'>
        <h1 align='center'>Fehltage Datenbank für CDT</h1>
        <div style="border: 1px solid #494dcc;padding:5px;margin-bottom:20px;">
            <label for="pseudoBtn" class="btn" onclick="window.history.back()">Zurück</label>
        </div>
        <div>
            <table>
                <tr>
                    <th>NameTest</th>
                    <th>Vorname</th>
                    <th>Massnahme</th>
                    <th>Baustein</th>
                    <th>Fehltage</th>
                </tr>
                <c:forEach var="x" items="${list}" >
                    <tr >
                        <td><c:out value="${x.getName()}"/></td>
                        <td><c:out value="${x.getVorname()}"/></td>
                        <td><c:out value="${x.getMassnahme()}"/></td>
                        <td><c:out value="${x.getBaustein()}"/></td>
                        <td><c:out value="${x.getFehlTage()}"/></td>
                    </tr>
                </c:forEach>
            </table>
                    <div>
                        <c:set var="x" value="${error}"/>
                        <div align='center' style="color: red"><c:out value="${x}"/></div>
                    </div>
        </div>
    </body>
</html>
