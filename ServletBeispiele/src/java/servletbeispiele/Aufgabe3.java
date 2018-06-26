package servletbeispiele;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Aufgabe3", urlPatterns = {"/Aufgabe3"})

public class Aufgabe3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<String> list = getData();
        int columns = Integer.parseInt(list.get(list.size() - 1));
     
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Aufgabe3</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table align=\"center\">\n"
                + "            <tr>\n"
                + "                <th colspan=\"" + columns + "\" ><h2>Unsere Abteilungen</h2></th>\n"
                + "            </tr><tr>");
        for (String s : list.get(0).split(" ")) {
            out.println(String.format("<th style=\"background-color: lightgreen\">%s</th>\n", s));
        }
        out.println("</tr>");
        for (int i = 1; i < list.size() - 1; i++) {
            out.println("<tr >");
            for (String s : list.get(i).split(" ")) {
                out.println(String.format("<td width=\"150\" align=\"left\">%s</td>\n", s));
            }
            out.println("</tr>");
        }
        out.println("<tr><th colspan=\""+columns+"\"><hr/></th></tr>");
        out.println(String.format("<tr><td colspan=\"%s\" align=\"left\">Das sind <b>%s</b> Abteilungen</td></tr>",columns, list.size()-2));
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private List<String> getData() {
        List<String> list = new LinkedList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (PreparedStatement statement = DriverManager.getConnection("jdbc:sqlserver://10.140.130.16;databaseName=Firma21",
                    "dba21", "dba21").prepareCall("select * from abteilung")) {
                ResultSetMetaData meta = statement.getMetaData();
                ResultSet result = statement.executeQuery();
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    builder.append(meta.getColumnName(i)).append(" ");
                }
                list.add(builder.toString());
                builder.delete(0, builder.toString().length());
                while (result.next()) {
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        builder.append(result.getString(i)).append(" ");
                    }
                    list.add(builder.toString());
                    builder.delete(0, builder.toString().length());
                }
                list.add("" + meta.getColumnCount());
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getCause());
        }
        return list;
    }
}
