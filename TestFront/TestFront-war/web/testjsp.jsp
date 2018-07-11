<%-- 
    Document   : testjsp
    Created on : 09.07.2018, 09:04:25
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            .btn {
                display: inline-block;
                margin-bottom: 4px;
                padding: 4px 8px;
                background-color: greenyellow;
                border: 1px solid #eeeeee;
                cursor: pointer;
            }

            .btnOben {
                display: inline-block;
                margin-bottom: 10px;
                padding: 4px 8px;
                background-color: greenyellow;
                border: 1px solid #eeeeee;
                cursor: pointer;


            }
            ul {
                text-align: justify;
                line-height: 0;

                
                font-size: 1px;

                
                text-justify: newspaper; 
                zoom: 1;
                text-align-last: justify;
            }
            ul:after {
                width: 100%;
                height: 0px;
                visibility: hidden;
                overflow: hidden;
                content: "";
                display: inline-block;
            }
            ul li  {
                display: inline-block;
                text-align: left;
                line-height: normal;
                font-size: 14px;

                vertical-align: top;

                /* IE6-7 */
                //display : inline;
                //zoom : 1;
            }

        </style>
    </head>
    <body style='background: lavenderblush'>
        <h1 align='center'>Fehltage Datenbank für CDT</h1>
        <ul style="border: 1px solid #494dcc;padding:5px;margin-bottom:20px; ">
            <li><label for="pseudoBtn" class="btnOben" onclick="openbox('form1');
                    return false">Abfrage1</label></li>
            <li><label for="pseudoBtn" class="btnOben" onclick="openbox('form2');
                    return false">Abfrage2</label></li>
            <li><label for="pseudoBtn" class="btnOben" onclick="openbox('form3');
                    return false">Abfrage3</label></li>
            <li><label for="pseudoBtn" class="btnOben" onclick="openbox('form4');
                    return false">Abfrage4</label></li>
            <li><label for="pseudoBtn" class="btnOben" onclick="openbox('form5');
                    return false">Abfrage5</label></li>
            <li><label for="pseudoBtn" class="btnOben" onclick="openbox('form6');
                    return false">Abfrage6</label></li>
        </ul>
        <div id="form1" style="display: none; border: 1px solid deeppink;padding:5px;margin-bottom:20px;">
            <form method="post" action="TestServlet?action=abfrage1" >
                <h2 align='center'>Anzahl der Fehltage (gesamt) des Teilnehmers in der Massnahme</h2>
                <table align="center">
                    <tr >
                        <th width="100" align="right">Name:</th>
                        <td><input type="text" name="name"
                                   placeholder="Name" required/></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Vorname:</th>
                        <td><input type="text"  name="vorname"
                                   placeholder="Vorname" required/></td>
                    </tr>
                    <tr>
                        <th width="100" align="right">Massnahme:</th>
                        <td><input type="text" name="massnahme" placeholder="MassnahmeId" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2"  align="right" ><button class='btn' type="submit">Submit</button>
                            <button class='btn' onclick="document.getElementById('form1').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="form2" style="display: none; border: 1px solid deeppink;padding:5px;margin-bottom:20px;">
            <form method="post" action="TestServlet?action=abfrage2">
                <h2 align='center'>Liste der Bausteine, die der Teilnehmer bereits besucht hat</h2>
                <table align="center">
                    <tr >
                        <th width="100" align="right">Name:</th>
                        <td><input type="text" name="name"
                                   placeholder="Name" required/></td>
                    </tr>
                    <tr>
                        <th width="100" align="right">Vorname:</th>
                        <td><input type="text"  name="vorname"
                                   placeholder="Vorname" required/></td>
                    </tr>
                    <tr>
                        <th width="100" align="right">Massnahme:</th>
                        <td><input type="text" name="massnahme" placeholder="MassnahmeId" required/></td>
                    </tr>
                    <tr>
                        <td colspan="2"  align="right" ><button class='btn' type="submit">Submit</button>
                            <button class='btn' onclick="document.getElementById('form2').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="form3" style="display: none; border: 1px solid deeppink;padding:5px;margin-bottom:20px;">
            <form method="post" action="TestServlet?action=abfrage3">
                <h2 align='center'>Anzahl der Fehltage des Teilnehmers im Baustein der Massnahme</h2>
                <table align="center">
                    <tr >
                        <th width="100" align="right">Name:</th>
                        <td><input type="text" name="name"
                                   placeholder="Name" required/></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Vorname:</th>
                        <td><input type="text"  name="vorname"
                                   placeholder="Vorname" required/></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Massnahme:</th>
                        <td><input type="text" name="massnahme" placeholder="MassnahmeId" required/></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Baustein:</th>
                        <td><input type="text" name="baustein" placeholder="BausteinId" required/></td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' type="submit">Submit</button>
                            <button class='btn' onclick="document.getElementById('form3').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="form4" style="display: none; border: 1px solid deeppink;padding:5px;margin-bottom:20px;">
            <form method="post" action="TestServlet?action=abfrage4">
                <h2 align='center'>Liste aller Teilnehmer, die in einem oder mehreren Bausteinen Fehltage hatten</h2>
                <table align="center">
                    <tr>
                        <th width="100" align="right">Massnahme:</th>
                        <td><input type="text" name="massnahme" placeholder="MassnahmeId" required/></td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' type="submit">Submit</button>
                            <button class='btn' onclick="document.getElementById('form4').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="form5" style="display: none; border: 1px solid deeppink;padding:5px;margin-bottom:20px;">
            <form method="post" action="TestServlet?action=abfrage5">
                <h2 align='center'>Liste aller Teilnehmer, die im Baustein Fehltage hatten</h2>
                <table align="center">
                    <tr >
                        <th width="100" align="right">Massnahme:</th>
                        <td><input type="text" name="massnahme" placeholder="MassnahmeId" required/></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Baustein:</th>
                        <td><input type="text" name="baustein" placeholder="BausteinId" required/></td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' type="submit">Submit</button>
                            <button class='btn' onclick="document.getElementById('form5').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="form6" style="display: none; border: 1px solid deeppink;padding:5px;margin-bottom:20px;">
            <form method="post" action="TestServlet?action=abfrage6">
                <h2 align='center'>Liste aller Teilnehmer, die Fehltage haben</h2>
                <table align="center">
                    <tr >
                        <th width="100" hidden align="right">Baustein:</th>
                        <td><input type="text" hidden  name="baustein" placeholder="BausteinId" /></td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' type="submit">Submit</button>
                            <button class='btn' onclick="document.getElementById('form6').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

        <script type="text/javascript">
            function hiddenIfPresent() {
                var x = ['form1', 'form2', 'form3', 'form4', 'form5', 'form6'];
                for (var i = 0; i < x.length; i++) {
                    display = document.getElementById(x[i]).style.display;
                    if (display !== 'none') {
                        document.getElementById(x[i]).style.display = 'none';
                    }
                }
            }
            function openbox(id) {

                hiddenIfPresent();
                display = document.getElementById(id).style.display;
                if (display === 'none') {
                    document.getElementById(id).style.display = 'block';
                } else {
                    document.getElementById(id).style.display = 'none';
                }
            }
        </script>
    </body>
</html>
