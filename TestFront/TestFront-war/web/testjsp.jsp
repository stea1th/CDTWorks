<%-- 
    Document   : testjsp
    Created on : 09.07.2018, 09:04:25
    Author     : stea1th
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fehltage CDT</title>
        <link rel="stylesheet" type="text/css" href="template/mycss.css">
        <script src='template/myjs.js'></script>
    </head>
    <body style='background: lightgray' class='container'>
        <header>
            <h1 align='center'>Fehltage Datenbank für CDT</h1>
            <ul class='top-buttons' >
                <li><label for="pseudoBtn" class="btn" onclick="openbox('form1');
                        return false">Abfrage1</label></li>
                <li><label for="pseudoBtn" class="btn" onclick="openbox('form2');
                        return false">Abfrage2</label></li>
                <li><label for="pseudoBtn" class="btn" onclick="openbox('form3');
                        return false">Abfrage3</label></li>
                <li><label for="pseudoBtn" class="btn" onclick="openbox('form4');
                        return false">Abfrage4</label></li>
                <li><label for="pseudoBtn" class="btn" onclick="openbox('form5');
                        return false">Abfrage5</label></li>
                <li><label for="pseudoBtn" class="btn" onclick="openbox('form6');
                        return false">Abfrage6</label></li>
            </ul>
        </header>



        <div id="form1" class='forms' >
            <form method="post" action="TestServlet?action=abfrage1" >
                <h2 align='center'>Teilnehmerdaten:</h2>
                <table align="center" class="input">
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

                        <td><select name='massnahme' class="input">
                                <option selected disabled>Massnahme wählen</option>
                                <option value='FIAE'>Anwendungsentwicklung</option>
                                <option value='FISI'>Systemintegration</option>

                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="2"  align="right" ><button class='btn' id='ok' type="submit">Submit</button>
                            <button class='btn' id='ok' onclick="document.getElementById('form1').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
                <aside class='side-block-up'>
                    <div id='hinweis'>
                        Hinweis:
                    </div>
                    <div>
                        Anzahl der Fehltage(gesamt) des Teilnehmers in der Massnahme
                    </div>
                </aside>
            </form>

        </div>
        <div id="form2" class='forms'>
            <form method="post" action="TestServlet?action=abfrage2">
                <h2 align='center'>Teilnehmerdaten:</h2>
                <table align="center" class="input">
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
                        <td><select name='massnahme' class="input">
                                <option selected disabled>Massnahme wählen</option>
                                <option value='FIAE'>Anwendungsentwicklung</option>
                                <option value='FISI'>Systemintegration</option>

                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="2"  align="right" ><button class='btn' id='ok' type="submit">Submit</button>
                            <button class='btn' id='ok' onclick="document.getElementById('form2').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
                <aside class='side-block-up'>
                    <div id='hinweis'>
                        Hinweis:
                    </div>
                    <div>
                        Liste der Bausteine, die der Teilnehmer im Rahmen
                        der Massnahme bereits besucht hat mit Anzahl 
                        der Fehltage pro Baustein
                    </div>
                </aside>
            </form>
        </div>
        <div id="form3" class='forms'>
            <form method="post" action="TestServlet?action=abfrage3">
                <h2 align='center'>Teilnehmerdaten:</h2>
                <table align="center" class="input">
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
                        <td><select name='massnahme' class="input">
                                <option selected disabled>Massnahme wählen</option>
                                <option value='FIAE'>Anwendungsentwicklung</option>
                                <option value='FISI'>Systemintegration</option>

                            </select></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Baustein:</th>
                        <td><select name='baustein' class="input" required>
                                <option selected disabled>Baustein wählen</option>
                                <optgroup label="Fachinformatik">
                                    <option value='WIRE'>Arbeitsrecht</option>
                                    <option value='FIBU'>Finanzbuchhaltung</option>
                                    <option value='KORE'>Kosten und Leistungsrechnung</option>
                                    <option value='BEVT'>Grundlagen Absatzwirtschaft</option>
                                    <option value='MSWF'>MS Word</option>
                                    <option value='MSEF'>MS Excel</option>
                                    <option value='GVWL'>Grundlagen der Volkswirtschaft</option>
                                    <option value='BWLO'>Betriebswirtschaftslehre</option>
                                </optgroup>
                                <optgroup label='Anwendungsentwicklung' hidden>
                                    <option value='JAVS'>Java- Spezielle Themen</option>
                                    <option value='SUML'>Software Engineering</option>
                                    <option value='EJS1'>Enterprise Applikationen</option>
                                    <option value='EWBS'>Web Service</option>
                                </optgroup>
                                <optgroup label='Systemintegration'>
                                    <option value='W8AM'>MS Windows Server 2012</option>
                                    <option value='NETE'>Netzwerktechnologien</option>
                                    <option value='GRHW'>Grundlagen Hardware</option>
                                    <option value='GRDS'>Grundlagen Datensicherheit</option>
                                </optgroup>
                            </select></td>

                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' id='ok' type="submit">Submit</button>
                            <button class='btn' id='ok' onclick="document.getElementById('form3').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
                <aside class='side-block-up'>
                    <div id='hinweis'>
                        Hinweis:
                    </div>
                    <div>
                        Anzahl der Fehltage des Teilnehmers im Baustein der Massnahme
                    </div>
                </aside>
            </form>
        </div>
        <div id="form4" class='forms'>
            <form method="post" action="TestServlet?action=abfrage4">
                <h2 align='center'>Massnahme:</h2>
                <table align="center" class="input">
                    <tr>
                        <th width="100" align="right">Massnahme:</th>
                        <td>
                            <select name='massnahme' class="input">
                                <option selected disabled>Massnahme wählen</option>
                                <option value='FIAE'>Anwendungsentwicklung</option>
                                <option value='FISI'>Systemintegration</option>

                            </select>
                        </td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' id='ok' type="submit">Submit</button>
                            <button class='btn' id='ok' onclick="document.getElementById('form4').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
                <aside class='side-block'>
                    <div id='hinweis'>
                        Hinweis:
                    </div>
                    <div>
                        Liste aller Teilnehmer, die in einem oder 
                        mehreren Bausteine der Massnahme Fehltage hatten;
                    </div>
                    <div>
                        pro Teilnehmer die Anzahl der Fehltage (gesamt)
                    </div>
                </aside>
            </form>
        </div>
        <div id="form5" class='forms'>
            <form method="post" action="TestServlet?action=abfrage5">
                <h2 align='center'>Massnahme und Baustein:</h2>
                <table align="center" class="input">
                    <tr >
                        <th width="100" align="right">Massnahme:</th>
                        <td><select name='massnahme' class="input">
                                <option selected disabled>Massnahme wählen</option>
                                <option value='FIAE'>Anwendungsentwicklung</option>
                                <option value='FISI'>Systemintegration</option>

                            </select></td>
                    </tr>
                    <tr >
                        <th width="100" align="right">Baustein:</th>
                        <td><select name='baustein' class="input" required>
                                <option selected disabled>Baustein wählen</option>
                                <optgroup label="Fachinformatik">
                                    <option value='WIRE'>Arbeitsrecht</option>
                                    <option value='FIBU'>Finanzbuchhaltung</option>
                                    <option value='KORE'>Kosten und Leistungsrechnung</option>
                                    <option value='BEVT'>Grundlagen Absatzwirtschaft</option>
                                    <option value='MSWF'>MS Word</option>
                                    <option value='MSEF'>MS Excel</option>
                                    <option value='GVWL'>Grundlagen der Volkswirtschaft</option>
                                    <option value='BWLO'>Betriebswirtschaftslehre</option>
                                </optgroup>
                                <optgroup label='Anwendungsentwicklung' hidden>
                                    <option value='JAVS'>Java- Spezielle Themen</option>
                                    <option value='SUML'>Software Engineering</option>
                                    <option value='EJS1'>Enterprise Applikationen</option>
                                    <option value='EWBS'>Web Service</option>
                                </optgroup>
                                <optgroup label='Systemintegration'>
                                    <option value='W8AM'>MS Windows Server 2012</option>
                                    <option value='NETE'>Netzwerktechnologien</option>
                                    <option value='GRHW'>Grundlagen Hardware</option>
                                    <option value='GRDS'>Grundlagen Datensicherheit</option>
                                </optgroup>
                            </select></td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' id='ok' type="submit">Submit</button>
                            <button class='btn' id='ok' onclick="document.getElementById('form5').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
                <aside class='side-block'>
                    <div id='hinweis'>
                        Hinweis:
                    </div>
                    <div>
                        Liste aller Teilnehmer, die im Baustein Fehltage hatten;
                    </div>
                    <div>
                        pro Teilnehmer die Anzahl der Fehltage
                    </div>
                </aside>
            </form>
        </div>
        <div id="form6"  class='forms'>
            <form method="post" action="TestServlet?action=abfrage6">
                <h2 align='center'>alle Teilnehmer mit Fehltage:</h2>
                <table align="center" >
                    <tr >
                        <th width="100" hidden align="right">Baustein:</th>
                        <td><input type="text" hidden  name="baustein" placeholder="BausteinId" /></td>
                    </tr>
                    <tr >
                        <td colspan="2"  align="right" ><button class='btn' id='ok' type="submit">Submit</button>
                            <button class='btn' id='ok' onclick="document.getElementById('form6').style.display = 'none';"  type="button">Cancel</button>
                        </td>
                    </tr>
                </table>
                <aside class='side-block'>
                    <div id='hinweis'>
                        Hinweis:
                    </div>
                    <div>
                        Liste aller Teilnehmer, die  Fehltage haben;
                    </div>
                    <div>
                        pro Teilnehmer die Massnahme, die er 
                        besucht und die Anzahl der Fehltage (gesamt)
                    </div>
                </aside>
            </form>
        </div>



        <footer  >
            <hr/>
            <div class='label' align='right'>
                (c)Copyright stea1th
            </div>

        </footer>
    </body>
</html>
