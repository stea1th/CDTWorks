<%-- 
    Document   : printresult
    Created on : 10.07.2018, 09:17:34
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fehltage CDT</title>
        <link rel="stylesheet" type="text/css" href="template/mycss.css">
    </head>
    <body style='background: lightgray' class='container'>
        <header>
        <h1 align='center'>Fehltage Datenbank für CDT</h1>
        <ul class='top-buttons'>
            <li><label for="pseudoBtn" class="btn" onclick="window.history.back()">Zurück</label></li>
        </ul>
        </header>
        <div>
            <hr/>
            <table class='ausgabe' cellpadding="8" cellspacing="0">
                <tr>
                    <th>Name</th>
                    <th>Vorname</th>
                    <th>Massnahme</th>
                    <th>Baustein</th>
                    <th>Fehltage</th>
                </tr>
                <c:forEach var="x" items="${list}" >
                    <tr >
                        <td><c:out value="${x.getName()}"/></td>
                        <td><c:out value="${x.getVorname()}"/></td>
                        <td align='center'><c:out value="${x.getMassnahme()}"/></td>
                        <td align='center'><c:out value="${x.getBaustein()}"/></td>
                        <td align='center'><c:out value="${x.getFehlTage()}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="output" align='center'>
                <c:set var="x" value="${error}"/>
                <div  style="color: red"><p><c:out value="${x}"/></p></div>
            </div>
        </div>
        <footer >
            <hr/>
            <div class='label' align='right'>
                (c)Copyright stea1th
            </div>
        </footer>
    </body>
</html>
