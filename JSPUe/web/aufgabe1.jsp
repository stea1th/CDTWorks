<%-- 
    Document   : aufgabe1
    Created on : 15.05.2018, 13:47:38
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            name{font-size: 35px; font-style: oblique; color: green;}
            .zahl{width: 120px}
            
        </style>
        <title>JSP Aufgabe</title>
    </head>
    <body>
        <form action="" method="post" id="nameform">
            Geben Sie was ein:
            <input type="text" name="mytext"><br>
            
        </form>
        <p align="center"><b><%= request.getParameter("mytext")
        %></b></p>
        <table align="center" border="2px">
            <tr>
                <th colspan="2"><name>Fakultäten</name></th>
            </tr>
            <tr>
                <th class="zahl"><h3>Zahl</h3></th>
                <th class="zahl"><h3>Fakultät</h3></th>
            </tr>
            <% for (int i = 0; i <= Integer.parseInt(request.getParameter("mytext")); i++) {%>
            <tr style="background-color: <%= i % 2 == 0 ? "lightblue" : "lightyellow"%>" align="right">
                <td><%= i%></td>
                <td><%= fakult(i)%></td>
            </tr>
            <% }%>
        </table>
        
        
        <button  type="submit" form="nameform" value="Submit">Submit</button>
    </body>
</html>
<%-- public long fakult(long i) {
        if (i == 0) return 1;
        if (i > 1) i *= fakult(i - 1);
        return i;
    }--%>
    
<%! public long fakult(int i){
    long sum = 1;
    for(; i > 1; i--) sum *= i;
    return sum; 
}%>
    
