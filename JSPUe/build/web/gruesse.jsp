<html>
    <body>
        <%-- *1* --%>
        <h3>Hallo Welt!</h3>
        <h4>Geben Sie Ihren Namen und Ihre Gru&szlig;worte ein, um
            die Welt über diese JSP-Seite zu gr&uuml;&szlig;en.</h4>
        <form method="post" action="">
            <table>
                <tr><td align="right">Name</td>
                    <td><input type="text" name="benutzer" size="40" /></td>
                </tr>
                <tr><td align="right">Gru&szlig;worte</td>
                    <td><input type="text" name="gruesse" size="80" /></td>
                </tr>
                <tr><td><input type="submit" value="Absenden" /></td>
                    <td><input type="reset" value="R&uuml;cksetzen" /></td>
                </tr>
            </table>
        </form>
        <%-- *2* --%>
        <%-- Auswertung der Request-Parameter --%>
        <% String benutzer = request.getParameter("benutzer");
            String gruesse = request.getParameter("gruesse");
            if (benutzer != null && gruesse != null
                    && !benutzer.equals("") && !gruesse.equals("")) {
        %>
        <jsp:include page="gruesse-modul.jsp" />
        <% } else {
        %>
        <p>Information: Erster Aufruf dieser Seite oder
            Aufruf ohne Parameter in der aktuellen Sitzung.</p>
            <% }
            %>
    </body>
</html>

