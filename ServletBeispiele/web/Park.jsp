<%-- 
    Document   : Park
    Created on : 18.05.2018, 10:49:11
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parkgebühren</title>
    </head>
    <body>
        <h2 align="center">Parkgebühren</h2><br><hr/>
        
        <form method="post" action="">
            <table align="center">
                
                <tr>
                    <th style="width: 120px" align="left">Parkzeiteingabe:</th>
                    <th><input type="text" name="stunde" style="width: 50px"></th>
                    
                </tr>
                <tr>
                    <th></th>
                    <th><input type="text" name="minute" style="width: 50px"></th>
                </tr>
                <tr>
                    <th colspan="2" align="right"><input type="submit" value="Send"></th>
                </tr>
            </table><br>
            <hr/>
            <table align="center">
                <tr >
                    <th align="left" style="width: 100px">Parkzeit:</th>
                    <th align="left" style="width: 70px">Parkgebühr:</th>
                </tr>
                <tr>
                    <th colspan="2"><hr/></th>
                </tr>
                <tr>
                    <td align="center"><% if(request.getParameter("stunde")!=null|request.getParameter("minute")!=null){
                        out.println(String.format("<b>%s</b> Std. <b>%s</b> Minuten",request.getParameter("stunde") ,request.getParameter("minute"))); }%></td>
                    <td align="center">
                        <jsp:include page="ParkGebuehr"/>
                    </td>
                </tr>
            </table><hr/>
        </form>
        
    </body>
    
</html>
