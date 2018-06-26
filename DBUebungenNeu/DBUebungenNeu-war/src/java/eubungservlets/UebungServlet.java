package eubungservlets;

import dbuebungneu.beans.UebungNeuLocal;
import dbuebungneu.dtos.TransportDtO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UebungServlet", urlPatterns = {"/UebungServlet"})

public class UebungServlet extends HttpServlet {

    @EJB
    private UebungNeuLocal uebungNeu;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UebungServlet</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            out.println("<h3>Average Salary</h3>");
            out.println("<table>\n"
                    + "            <tr>\n"
                    + "                <th>Department</th>\n"
                    + "                <th>Average Salary</th>\n"
                    + "            </tr>");

            for (TransportDtO t : uebungNeu.getData()) {
                out.printf("<tr>\n"
                        + "                <td>%s</td>\n"
                        + "                <td>%.2f</td>\n"
                        + "            </tr>\n", t.getdName(), t.getAverage());
            }
            out.println("</table>");
            
            out.println("<h3>Salary Pro Department</h3>");
            out.println("<table>\n"
                    + "            <tr>\n"
                    + "                <th>Department</th>\n"
                    + "                <th>LastName</th>\n"
                    + "                <th>Salary</th>\n"
                    + "            </tr>");

            for (TransportDtO t : uebungNeu.getSalary()) {
                out.printf("<tr>\n"
                        + "                <td>%s</td>\n"
                        + "                <td>%s</td>\n"
                        + "                <td>%.2f</td>\n"
                        + "            </tr>\n", t.getdName(),t.getLastName(), t.getSalary());
            }
            out.println("</table>");

        } catch (EJBException e) {
            out.println("<p>" + e.getMessage() + "</p>");

        } finally {
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
