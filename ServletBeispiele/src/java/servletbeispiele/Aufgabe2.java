package servletbeispiele;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Aufgabe2", urlPatterns = {"/Aufgabe2"})

public class Aufgabe2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Aufgabe2</title>");
        out.println("<style> th{}</style> ");
        out.println("</head>");
        out.println("<body>");
        out.println("<table align=\"center\" border=\"1px\">\n"
                + "            <tr>\n"
                + "                <th colspan=\"11\"><h2>Multiplikationstafel</h2></th>\n"
                + "            </tr>");
        out.println("<tr>"
                + "<th style=\"width: 30px; height: 30px; background-color: lightgreen\">*</th>");
        for (int i = 1; i < 11; i++) {
            out.println("<th style=\"width: 30px; height: 30px; background-color: lightgreen\">" + i + "</th>");
        }
        out.println("</tr>");

        for (int i = 1; i < 11; i++) {
            out.println("<tr align=\"center\" >");
            out.println("<th style=\"width: 30px; height: 30px; background-color: lightgreen\">" + i + "</th>");

            for (int j = 1; j < 11; j++) {
                out.println("<td>" + i * j + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
